package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    Optional<BorrowBook> findBorrowBookByBorrowCode(String borrowCode);

}
