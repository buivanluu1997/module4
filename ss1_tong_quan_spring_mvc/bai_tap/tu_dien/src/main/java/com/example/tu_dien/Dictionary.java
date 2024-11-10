package com.example.tu_dien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class Dictionary {
    private static HashMap<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("computer", "máy tính");
        dictionary.put("language", "ngôn ngữ");
        dictionary.put("book", "sách");
        dictionary.put("love", "yêu");
        dictionary.put("friend", "bạn bè");
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("translate")
    public String lookUp(@RequestParam String key, Model model){
        String work = dictionary.get(key.toLowerCase());
        if(work != null){
            model.addAttribute("key", key);
            model.addAttribute("work",work);
        } else {
            model.addAttribute("message","Không tìm thấy từ trong từ điển");
        }
        return "result";
    }
}
