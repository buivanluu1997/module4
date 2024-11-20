package com.example.test_song_validate.dto;


import com.example.test_song_validate.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SongDto {
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Tên bài hát không được chứa số hoặc kí tự đặc biệt")
    private String title;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z\\s]+$",message = "Tên ca sĩ không được chứa số hoặc kí tự đặc biệt")
    private String singer;
    private Category category;

}
