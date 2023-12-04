package com.facebook.facebook.controller;
import com.facebook.facebook.dto.postDTO.PostRequestDTO;
import com.facebook.facebook.dto.postDTO.PostResponseDTO;
import com.facebook.facebook.entities.Commentfac;
import com.facebook.facebook.entities.FacebookUser;
import com.facebook.facebook.entities.Post;
import com.facebook.facebook.services.PostServicesImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    private final PostServicesImpl postService;


    @Autowired
    public PostController(PostServicesImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post());
        model.addAttribute("newComment", new Commentfac());
        return "newsFeed";
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        model.addAttribute("post", post.orElse(null));
        return "comment";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model) {
        System.out.println("Bros do well oo");
        model.addAttribute("post", new Post());
        System.out.println("Omo this one mad");
        return "edit";
    }


    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute("post") PostResponseDTO post) {
        post.setId(id);

        System.out.println("POST"+post);
       postService.updatePost(post);
        return "home";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        model.addAttribute("post", post.orElseThrow());
        return "editComment";
    }



    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<Post> optionalPost = postService.getPostById(id);

        if (optionalPost.isPresent()) {
            postService.deletePost(id);
        } else {
            redirectAttributes.addFlashAttribute("error", "The post does not exist.");
        }

        return "redirect:/posts";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute("post") PostRequestDTO post, @RequestParam("content") String content, HttpSession session) {
        // Get the authenticated user from the session
        System.out.println("oh mehn!");
        FacebookUser user = (FacebookUser) session.getAttribute("user");

        // Create a new Post object

        post.setUser(user);
        post.setContent(content);
//        post.setTimestamp(LocalDateTime.now());

        // Save the post using the PostService
        postService.createPost(post);
        System.out.println("What to do now");

        return "redirect:/home";
    }







}
