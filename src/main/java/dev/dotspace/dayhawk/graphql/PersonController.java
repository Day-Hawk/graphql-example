package dev.dotspace.dayhawk.graphql;

import dev.dotspace.dayhawk.data.PersonEntity;
import dev.dotspace.dayhawk.data.PersonRepository;
import dev.dotspace.dayhawk.exception.DataAlreadyPresentException;
import dev.dotspace.dayhawk.exception.NoDataPresentException;
import dev.dotspace.dayhawk.data.IPerson;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public final class PersonController {

  @Autowired
  private PersonRepository personRepository;

  @QueryMapping
  public List<IPerson> person() {
    return this.personRepository
        .findAll()
        .stream()
        .map(personEntity -> (IPerson) personEntity)
        .toList();
  }

  @QueryMapping
  public IPerson personById(@Argument final long id) throws NoDataPresentException {
    return this.personRepository
        .findById(id)
        .orElseThrow(() -> new NoDataPresentException("No person with id "+id+" present!"));
  }

  @MutationMapping
  public IPerson createPerson(@Argument @Nullable String username,
                              @Argument @Nullable String firstName,
                              @Argument @Nullable String lastName) throws DataAlreadyPresentException {
    //Create entity from parameters
    final PersonEntity personEntity = new PersonEntity(username, firstName, lastName);

    //Already present
    if (this.personRepository.exists(Example.of(personEntity, ExampleMatcher
        .matching()
        .withIgnorePaths("id")
        .withIgnoreCase()))) {
      throw new DataAlreadyPresentException("Person with parameters already present!");
    }

    return this.personRepository.save(personEntity);
  }

  @MutationMapping
  public boolean deletePerson(@Argument final long id) throws NoDataPresentException {
    //Error if person is not present.
    if (!this.personRepository.existsById(id)) {
      throw new NoDataPresentException("No person with id "+id+" present to delete.");
    }

    this.personRepository.deleteById(id);
    //Check with id.
    return this.personRepository.existsById(id);
  }

}