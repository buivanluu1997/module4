package com.example.song_validate.controller;

import com.example.song_validate.dto.SongDto;
import com.example.song_validate.model.Song;
import com.example.song_validate.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listSong(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "2") int size,
                           Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        Pageable pageable = PageRequest.of(page, size, sort);
        model.addAttribute("songPage", songService.findAll(pageable));
        return "song/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("create")
    public String createSong(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        Song song = new Song();
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm bài hát thành công");
        return "redirect:/song";
    }
}
