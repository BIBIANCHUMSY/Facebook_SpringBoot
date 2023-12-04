package com.facebook.facebook.dto.likeDTO;

import com.facebook.facebook.entities.FacebookUser;
import com.facebook.facebook.entities.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LikeRequestDTO {
    @NotBlank(message = "like must be seen")
    private FacebookUser user;
    private Post post;
}
