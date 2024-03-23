package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class AbstractEntity implements  Identifiable{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Override
  public long id() {
    return this.id;
  }
}
