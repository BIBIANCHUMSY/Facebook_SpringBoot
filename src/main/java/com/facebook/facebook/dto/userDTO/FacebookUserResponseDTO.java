package com.facebook.facebook.dto.userDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FacebookUserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String gender;
}
