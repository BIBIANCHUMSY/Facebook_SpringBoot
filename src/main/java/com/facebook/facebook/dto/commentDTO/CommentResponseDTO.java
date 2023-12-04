package com.facebook.facebook.dto.commentDTO;


import com.facebook.facebook.entities.FacebookUser;
import com.facebook.facebook.entities.Post;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CommentResponseDTO {
    private Long id;
    private String text;
    private LocalDateTime timestamp;
    private FacebookUser user;
    private Post post;

}
