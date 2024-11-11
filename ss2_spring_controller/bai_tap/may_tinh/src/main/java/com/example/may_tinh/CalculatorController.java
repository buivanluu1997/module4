package com.example.may_tinh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @PostMapping("home")
    public String calculator(@RequestParam int numberOne, @RequestParam int numberTwo,
                             @RequestParam char operation, Model model) {
        int result = 0;
        String message = "";
        switch (operation) {
            case '+':
                result = numberOne + numberTwo;
                break;
            case '-':
                result = numberOne - numberTwo;
                break;
            case '*':
                result = numberOne * numberTwo;
                break;
            case '/':
                if (numberTwo != 0){
                    result = numberOne / numberTwo;
                } else {
                    message = "Mẫu bằng 0 nên không thể chia được";
                }
                break;
            default:
                message = "Hoạt động không hợp lệ";
        }
        if (message.isEmpty()){
            message = "Kết quả: " + result;
        }
        model.addAttribute("message", message);
        return "home";
    }
}
