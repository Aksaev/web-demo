package me.aksaev.webdemo.controllers;

import me.aksaev.webdemo.model.Book;
import me.aksaev.webdemo.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("books")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    // Отоброжение книги по идентификатору
    @GetMapping("{id}") // GET http://localhost:8080/books/23
    public ResponseEntity<Book> getBookInfo(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        // Если книга не нашлась, возвращаем 404
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        // Если книга нашлась, то возвращаем её
        return ResponseEntity.ok(book);
    }

    // Отоброжение всех книг
    @GetMapping // GET http://localhost:8080/books
    public ResponseEntity findBooks(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String author,
                                    @RequestParam(required = false) String namePart) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(bookService.findByName(name));
        }
        if (author != null && !author.isBlank()) {
            return ResponseEntity.ok(bookService.findByAuthor(author));
        }
        if (namePart != null && !namePart.isBlank()) {
            return ResponseEntity.ok(bookService.findByNamePart(namePart));
        }

        return ResponseEntity.ok(bookService.getAllBooks());
    }


    // Создание книги
    @PostMapping // POST http://localhost:8080/books
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    // Редактирвоание книги
    @PutMapping // PUT http://localhost:8080/books
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        Book foundBook = bookService.editBook(book);
        // Если книга не нашлась, возвращаем 400
        if (foundBook == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Запрос был выполнен не правильно
        }
        // Если книга нашлась, то возвращаем её
        return ResponseEntity.ok(foundBook);

    }

    // Удаление книги по идентификатору
    @DeleteMapping("{id}") // DELETE http://localhost:8080/books/23
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
