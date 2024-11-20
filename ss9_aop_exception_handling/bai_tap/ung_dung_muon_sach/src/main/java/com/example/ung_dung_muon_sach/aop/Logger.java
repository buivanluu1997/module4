package com.example.ung_dung_muon_sach.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;

    @After("execution(* com.example.ung_dung_muon_sach.service.BookService.borrowBook(..)) || execution(* com.example.ung_dung_muon_sach.service.BookService.returnBook(..))")
    public void logBookStage(){
        System.out.println("hành động khiến trạng thái sách của thư viện bị thay đổi.");
    }

    @After("execution(* com.example.ung_dung_muon_sach.controller.BookController.*(..))")
    public void countBookStage(){
        count++;
        System.out.println("Số lượng người đã ghé thăm thư viện sách (tất cả các thao tác)." + count);
    }
}
