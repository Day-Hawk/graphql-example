package org.example.graphql;

import org.example.Author;
import org.example.Book;
import org.example.data.IPerson;
import org.example.data.PersonRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class PersonController {

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
  public IPerson personById(@Argument final long id) {
    return this.personRepository
        .findById(id)
        .orElseThrow();
  }

}