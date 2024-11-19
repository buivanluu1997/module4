package com.example.song_validate.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
public class SongDto implements Validator {
    private int id;
    private String title;
    private String singer;
    private String category;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if ("".equals(songDto.getTitle())) {
            errors.rejectValue("title", null, "Tên bài hát không được để trống");
        } else if (songDto.getTitle().length() > 800) {
            errors.rejectValue("title", null, "Tên bài hát không được quá 800 từ");
        } else if (!songDto.getTitle().matches("^[a-zA-Z0-9\\s]+$")) {
            errors.rejectValue("title", null, "Tên bài hát không được có những kí tự đặc biệt như:  @ ; , . = - + , ….");
        }

        if ("".equals(songDto.getSinger())) {
            errors.rejectValue("singer", null,"Tên ca sĩ không được để trống");
        } else if (songDto.getSinger().length() > 300) {
            errors.rejectValue("singer", null,"Tên ca sĩ không quá 300 từ");
        } else if (!songDto.getSinger().matches("^[a-zA-Z0-9\\s]+$")) {
            errors.rejectValue("singer", null,"Tên ca sĩ không được có những kí tự đặc biệt như:  @ ; , . = - + , ….");
        }

        if ("".equals(songDto.getCategory())) {
            errors.rejectValue("category", null,"Tên thể loại bài hát không được để trống");
        }else if (songDto.getSinger().length() > 1000) {
            errors.rejectValue("category", null,"Tên thể loại bài hát không quá 1000 từ");
        } else if (!songDto.getCategory().matches("^[a-zA-Z0-9\\s,]+$")) {
            errors.rejectValue("singer", null,"Tên thể loại bài hát không được có những kí tự đặc biệt như:  @ ; , . = - + , ….(ngoại trừ dấu ,)");
        }
    }
}
