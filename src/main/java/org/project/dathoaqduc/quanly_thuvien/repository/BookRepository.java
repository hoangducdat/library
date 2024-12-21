package org.project.dathoaqduc.quanly_thuvien.repository;

import java.util.List;
import org.project.dathoaqduc.quanly_thuvien.enity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndCategoryContainingIgnoreCase(
      String title, String author, String category);
}
