package org.example.data;

import org.jetbrains.annotations.NotNull;


public interface IPerson extends Identifiable {

  @NotNull String username();

  @NotNull String firstName();

  @NotNull String lastName();

}
