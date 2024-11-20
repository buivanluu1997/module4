package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.repository.IBorrowBookRepository;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBookRepository borrowBookRepository;

    @GetMapping("")
    public String listBook(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "3") int size, Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "title");
        Pageable pageable = PageRequest.of(page, size, sort);
        model.addAttribute("books", bookService.findAllBook(pageable));
        return "book/list";
    }

    @GetMapping("/update")
    public String updateBook(@RequestParam int id, Model model) {
        String borrowCode = bookService.borrowBook(id);
        model.addAttribute("borrowCode", borrowCode);
        return "book/borrowBook";
    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam int id, Model model) {
        model.addAttribute("book", bookService.findBookById(id));
        return "book/returnBook";
    }

    @PostMapping("/returnBook")
    public String postReturnBook(@RequestParam String borrowCode, RedirectAttributes redirectAttributes) {
        bookService.returnBook(borrowCode);
        redirectAttributes.addFlashAttribute("returnBook", "Đã trả thành công");
        return "redirect:/book";
    }
}

