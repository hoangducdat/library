package org.project.dathoaqduc.quanly_thuvien.controller;

import java.util.List;
import org.project.dathoaqduc.quanly_thuvien.enity.Book;
import org.project.dathoaqduc.quanly_thuvien.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody Book book) {
    Book newBook = bookService.createBook(book);
    return new ResponseEntity<>(newBook, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
    Book updatedBook = bookService.updateBook(id, bookDetails);
    return new ResponseEntity<>(updatedBook, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Book book = bookService.getBookById(id);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }
  @GetMapping("/api/books/search")
  public List<Book> searchBooks(@RequestParam(required = false, defaultValue = "") String title,
      @RequestParam(required = false, defaultValue = "") String author,
      @RequestParam(required = false, defaultValue = "") String category) {
    return bookService.searchBooks(title, author, category);
  }

}
