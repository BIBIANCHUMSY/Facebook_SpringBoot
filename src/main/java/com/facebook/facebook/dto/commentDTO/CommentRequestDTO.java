package com.facebook.facebook.dto.commentDTO;

import com.facebook.facebook.entities.FacebookUser;
import com.facebook.facebook.entities.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CommentRequestDTO {
    @NotBlank(message = "comment must be seen")
    private String text;
    private FacebookUser user;
    private Post post;
}
