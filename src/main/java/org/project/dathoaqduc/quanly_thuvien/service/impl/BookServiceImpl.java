package org.project.dathoaqduc.quanly_thuvien.service.impl;

import java.util.List;
import org.project.dathoaqduc.quanly_thuvien.enity.Book;
import org.project.dathoaqduc.quanly_thuvien.exception.BookNotFoundException;
import org.project.dathoaqduc.quanly_thuvien.repository.BookRepository;
import org.project.dathoaqduc.quanly_thuvien.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Book createBook(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Book updateBook(Long id, Book bookDetails) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException("Book with id {} not found" + id));
    book.setTitle(bookDetails.getTitle());
    book.setAuthor(bookDetails.getAuthor());
    book.setCategory(bookDetails.getCategory());
    return bookRepository.save(book);
  }

  @Override
  public void deleteBook(Long id) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException("Book with id {} not found" + id));
    bookRepository.delete(book);
  }

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book getBookById(Long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException("Book with id {} not found" + id));
  }
  @Override
  public List<Book> searchBooks(String title, String author, String category) {
    if (title.isEmpty() || author.isEmpty() || category.isEmpty()) {
      return bookRepository.findAll(); // Nếu không có tham số, trả về tất cả sách
    }
    return bookRepository.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndCategoryContainingIgnoreCase(
        title, author, category);
  }
}