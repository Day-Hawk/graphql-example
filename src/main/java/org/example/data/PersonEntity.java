package org.example.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;


@Entity
@Table(name="person",
    uniqueConstraints={@UniqueConstraint(columnNames={"username", "firstName", "lastName"})})
@Getter
@NoArgsConstructor
@Accessors(fluent=true)
public final class PersonEntity extends AbstractEntity implements IPerson {

  @Column(name="username", nullable=false, unique=true)
  private String username;

  @Column(name="firstName", nullable=false)
  private String firstName;

  @Column(name="lastName", nullable=false)
  private String lastName;

  public PersonEntity(@Nullable final String username,
                      @Nullable final String firstName,
                      @Nullable final String lastName) {
    this.username = Objects.requireNonNull(username);
    this.firstName = Objects.requireNonNull(firstName);
    this.lastName = Objects.requireNonNull(lastName);
  }
}
