package com.example.quan_ly_san_pham_on_thi.dto;

import com.example.quan_ly_san_pham_on_thi.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(
            regexp = "^[a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂÂÁẮẰẲẴẶàáâãăạảấầẩẫậắằẳẵặèéẹẻẽêềểễệìíỉĩịòóọỏõôồốổỗộơờởỡợùúụủũưừứửữựỳýỵỷỹ\\s]+$",
            message = "Tên không được chứa kí tự đặc biệt, chỉ chứa chữ cái và số"
    )
    private String name;
    @Min(value = 0, message = "Giá sản phẩm không được dưới 0đ")
    private double price;
    private LocalDate createdAt;
    private Category category;
}
