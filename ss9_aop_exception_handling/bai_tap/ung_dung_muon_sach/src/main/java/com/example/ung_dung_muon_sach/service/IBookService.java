package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllBook(Pageable pageable);

    Book findBookById(int id);

    String borrowBook(int id);

    void returnBook(String borrowCode);

}
