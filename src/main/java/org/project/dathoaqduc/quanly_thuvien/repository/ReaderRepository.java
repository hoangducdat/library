package org.project.dathoaqduc.quanly_thuvien.repository;

import org.project.dathoaqduc.quanly_thuvien.enity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
