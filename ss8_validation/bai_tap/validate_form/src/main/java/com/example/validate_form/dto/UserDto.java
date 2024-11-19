package com.example.validate_form.dto;

import com.example.validate_form.model.Account;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private int id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài phải từ 5 đến 45 kí tự")
    private String firstName;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài phải từ 5 đến 45 kí tự")
    private String lastName;

    @Pattern(regexp ="^0\\d{9,10}$", message = "Số điện thoại phải bắt đầu bằng 0 và có từ 10 đến 11 chữ số.")
    private String phoneNumber;

    @Min(value = 18, message = "Phải 18 tuổi trở lên")
    private int age;

    @Email(message = "Địa chỉ email không hợp lệ.")
    private String email;
    private Account account;
}
