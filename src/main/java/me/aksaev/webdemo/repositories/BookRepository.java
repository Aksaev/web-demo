package me.aksaev.webdemo.repositories;

import me.aksaev.webdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByNameIgnoreCase(String name);
    Collection<Book> findBookByAuthorContainingIgnoreCase(String author);
    Collection<Book> findAllByNameContainsIgnoreCase(String part);
}
