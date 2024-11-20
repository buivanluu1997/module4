package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BorrowBook;
import com.example.ung_dung_muon_sach.repository.IBookRepository;
import com.example.ung_dung_muon_sach.repository.IBorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IBorrowBookRepository borrowBookRepository;
    @Override
    public Page<Book> findAllBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }


    @Override
    public String borrowBook(int id) {
        Book book = findBookById(id);
        if (book.getQuantity() <= 0){
            throw new RuntimeException("Khong con sach de muon");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        BorrowBook borrowBook = new BorrowBook();
        String borrowCode = String.format("%05d", new Random().nextInt(100000));
        borrowBook.setBook(book);
        borrowBook.setBorrowCode(borrowCode);

        borrowBookRepository.save(borrowBook);
        return borrowCode;
    }

    @Override
    public void returnBook(String borrowCode) {
        BorrowBook borrowBook = borrowBookRepository.findBorrowBookByBorrowCode(borrowCode).orElse(null);

        if (borrowBook == null){
            throw new RuntimeException("Mã số mượn sách không hợp lệ");
        }


        Book book = borrowBook.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowBookRepository.delete(borrowBook);
    }

}
