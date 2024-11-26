package com.example.i18n_customer_manager.dto;

import com.example.i18n_customer_manager.model.Category;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CustomerDto {
    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂÂÁẮẰẲẴẶàáâãăạảấầẩẫậắằẳẵặèéẹẻẽêềểễệìíỉĩịòóọỏõôồốổỗộơờởỡợùúụủũưừứửữựỳýỵỷỹ\\s]+$", message = "Tên không được chứa kí tự đặc biệt")
    private String name;
    @Max(value = 120 , message = "Tuổi không được quá 120")
    @Min(value = 1, message = "Tuổi không được thấp hơn 1")
    private int age;
    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email phải đúng định dạng")
    private String email;
    private Category category;
}
