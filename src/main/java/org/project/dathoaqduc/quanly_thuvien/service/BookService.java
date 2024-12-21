package org.project.dathoaqduc.quanly_thuvien.service;

import java.util.List;
import org.project.dathoaqduc.quanly_thuvien.enity.Book;

public interface BookService {
  Book createBook(Book book);
  Book updateBook(Long id, Book bookDetails);
  void deleteBook(Long id);
  List<Book> getAllBooks();
  Book getBookById(Long id);
  List<Book> searchBooks(String title, String author, String category);

}
