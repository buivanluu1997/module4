package com.example.product_manager_validete_session.dto;

import com.example.product_manager_validete_session.model.Category;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class ProductDto{
    private int id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯêùơẠ-ỹ]+$", message = "Tên sản phẩm không được chứa kí tự đặc biệt")
    private String name;
    @Size(min = 10, max = 1000, message = "Độ dài phải lớn hơn 1 kí tự và nhỏ hơn 1000")
    private String description;

    @NotNull(message = "Giá không được để trống")
    @Positive(message = "Giá phải lớn hơn 0")
    private int price;
    private String urlImage;
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
