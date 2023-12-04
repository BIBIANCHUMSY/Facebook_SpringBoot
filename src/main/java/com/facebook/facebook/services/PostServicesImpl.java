package com.facebook.facebook.services;

import com.facebook.facebook.dto.postDTO.PostRequestDTO;
import com.facebook.facebook.dto.postDTO.PostResponseDTO;
import com.facebook.facebook.entities.Post;
import com.facebook.facebook.repositories.PostRepository;
import com.facebook.facebook.repositories.UserRepository;
import com.facebook.facebook.services.servicesInterfaces.IPostServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostServicesImpl implements IPostServices {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired

    public PostServicesImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO post) {
        Post newPost = mapper.map(post, Post.class);
        Post savedPost = postRepository.save(newPost);

        return mapper.map(savedPost, PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO updatePost(PostResponseDTO post) {
        Optional<Post> postToUpdate = postRepository.findById(post.getId());
        if (postToUpdate.isPresent()) {

            postToUpdate.get().setContent(post.getContent());

          Post updatedPost =  postRepository.save(postToUpdate.get());
          return mapper.map(updatedPost, PostResponseDTO.class);
        }

        return null;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
