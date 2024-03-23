package org.example;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {

  @QueryMapping
  public List<Book> allBooks() {
    return Book.all();
  }

  @QueryMapping
  public List<Author> allAuthors() {
    return Author.all();
  }

  @QueryMapping
  public Book bookById(@Argument String id) {
    return Book.getById(id);
  }

  @MutationMapping
  public String deleteBook(@Argument String id) {
    if (Book.delete(id)) {
      return "Das Buch mit der ID " + id + " wurde erfolgreich gelöscht.";
    } else {
      return "Das Buch mit der ID " + id + " konnte nicht gefunden oder gelöscht werden.";
    }
  }

  @SchemaMapping
  public Author author(Book book) {
    return Author.getById(book.authorId());
  }

}