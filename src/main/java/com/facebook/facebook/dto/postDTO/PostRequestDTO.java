package com.facebook.facebook.dto.postDTO;

import com.facebook.facebook.entities.FacebookUser;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {
    @NotBlank(message = "Post can not be empty!")
    private String content;
    private FacebookUser user;

    public void setUser(FacebookUser user) {
        this.user = user;
    }
}
