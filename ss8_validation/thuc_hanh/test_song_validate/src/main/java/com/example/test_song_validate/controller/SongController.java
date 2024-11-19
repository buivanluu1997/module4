package com.example.test_song_validate.controller;

import com.example.test_song_validate.dto.SongDto;
import com.example.test_song_validate.model.Category;
import com.example.test_song_validate.model.Song;
import com.example.test_song_validate.service.ICategoryService;
import com.example.test_song_validate.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String searchSong(@RequestParam(required = false, defaultValue = "0") int page,
                            @RequestParam(required = false, defaultValue = "2") int size,
                            @RequestParam(required = false, defaultValue = "") String searchTitle,
                            Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "title").and(Sort.by( "id"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Song> listSong = songService.searchSongsByTitleContaining(searchTitle, pageable);
        model.addAttribute("listSong", listSong);
        model.addAttribute("searchTitle", searchTitle);
        return "song/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "song/create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute("songDto") SongDto songDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("categoryList", categoryService.getAllCategories());
        Song song = new Song();
        if (bindingResult.hasErrors()) {
            return "/song/create";
        }
        BeanUtils.copyProperties(songDto, song, "category");
        Category category = categoryService.getCategoryById(songDto.getCategoryId());
        song.setCategory(category);
        songService.saveSong(song);
        redirectAttributes.addFlashAttribute("add", "Đã thêm thành công");
        return "redirect:/song";
    }

    @GetMapping("/detele")
    public String detele(@RequestParam int id, RedirectAttributes redirectAttributes) {
        songService.deleteSongById(id);
        redirectAttributes.addFlashAttribute("delete", "Đã xoá thành công");
        return "redirect:/song";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam int id, Model model) {
        model.addAttribute("song", songService.findSongById(id));
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "song/update";
    }

    @PostMapping("update")
    public String updateSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.updateSong(song);
        redirectAttributes.addFlashAttribute("update", "Cập nhật thành công");
        return "redirect:/song";
    }
}
