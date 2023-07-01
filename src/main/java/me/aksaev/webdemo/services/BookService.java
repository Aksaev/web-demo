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

    // Поиск по названию книги
    public Book findByName(String name) {
        return bookRepository.findByNameIgnoreCase(name);
    }

    // Поиск по автору книги
    public Collection<Book> findByAuthor(String author) {
        return bookRepository.findBookByAuthorContainingIgnoreCase(author);
    }

    // Поиск по части названия книги
    public Collection<Book> findByNamePart(String part) {
        return bookRepository.findAllByNameContainsIgnoreCase(part);
    }

}
