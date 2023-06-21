package me.aksaev.webdemo.services;

import me.aksaev.webdemo.model.Book;
import me.aksaev.webdemo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Создание новой книги
    public Book createBook(Book book) {
       return bookRepository.save(book);
    }

    // Поиск(возвращение) книги по идентификатору
    public Book findBook(long id) {
        return bookRepository.findById(id).get();
    }

    // Редактирование книги по идентификатору
    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    // Удаление книги по идентификатору
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    // Отображение всех книг
    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
