package com.facebook.facebook.dto.likeDTO;

import com.facebook.facebook.entities.Commentfac;
import com.facebook.facebook.entities.FacebookUser;
import com.facebook.facebook.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LikeResponseDTO {
    private Long Id;
    private FacebookUser user;
    private Post post;
    private Commentfac commentfac;
}
