package me.aksaev.webdemo.repositories;

import me.aksaev.webdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
