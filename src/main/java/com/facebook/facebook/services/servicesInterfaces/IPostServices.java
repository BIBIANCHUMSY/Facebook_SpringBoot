package com.facebook.facebook.services.servicesInterfaces;

import com.facebook.facebook.dto.postDTO.PostRequestDTO;
import com.facebook.facebook.dto.postDTO.PostResponseDTO;
import com.facebook.facebook.entities.Post;

import java.util.List;
import java.util.Optional;

public interface IPostServices {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
    PostResponseDTO createPost(PostRequestDTO post);
    PostResponseDTO updatePost(PostResponseDTO post);
    void deletePost(Long id);



}
