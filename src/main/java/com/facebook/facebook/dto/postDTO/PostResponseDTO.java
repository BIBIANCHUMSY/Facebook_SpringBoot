package com.facebook.facebook.dto.postDTO;

import com.facebook.facebook.entities.Commentfac;
import com.facebook.facebook.entities.FacebookUser;
import com.facebook.facebook.entities.Likes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostResponseDTO {
    private Long id;
    private String username;
    private FacebookUser user;
    private String content;
    private List<Commentfac> commentfacs;
    private List<Likes> likesList;
    private LocalDateTime timestamp;
    private Integer likeCount;
}
