package org.project.dathoaqduc.quanly_thuvien.repository;

import org.project.dathoaqduc.quanly_thuvien.enity.BookBorrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowerRepository extends JpaRepository<BookBorrower, Long> {
}
