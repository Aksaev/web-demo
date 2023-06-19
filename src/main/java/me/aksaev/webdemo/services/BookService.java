package me.aksaev.webdemo.services;

import me.aksaev.webdemo.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class BookService {
    private final HashMap<Long, Book> books = new HashMap<>();
    private long lastId = 0;

    // Добавление новой книги
    public Book createBook(Book book) {
        book.setId(++lastId);
        books.put(lastId, book);
        return book;
    }

    // Поиск(возвращение) книги по идентификатору
    public Book findBook(long id) {
        return books.get(id);
    }

    // Редактирование книги по идентификатору
    public Book editBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
            return book;
        }
        return null;
    }

    // Удаление книги по идентификатору
    public Book deleteBook(long id) {
        return books.remove(id);
    }

    // Отображение всех книг
    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
