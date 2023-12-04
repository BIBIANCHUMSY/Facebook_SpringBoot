package com.facebook.facebook.dto.userDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacebookUserRequestDTO {
    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 25, message = "Name size should be between 3-25")
    private String name;

    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Password is required!")
    private String password;

    @NotBlank(message = "Gender is required!")
    private String gender;
}
