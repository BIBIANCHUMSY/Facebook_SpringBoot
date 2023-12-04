package com.facebook.facebook.controller;

import com.facebook.facebook.dto.userDTO.FacebookUserRequestDTO;
import com.facebook.facebook.entities.FacebookUser;
import com.facebook.facebook.entities.Post;
import com.facebook.facebook.repositories.UserRepository;
import com.facebook.facebook.services.PostServicesImpl;
import com.facebook.facebook.services.UserServicesImpl;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserServicesImpl userServices;
    private final UserRepository userRepository;
    private final PostServicesImpl postServices;
    private Mapper mapperService;

    @Autowired
    public UserController(UserServicesImpl userServices, UserRepository userRepository, PostServicesImpl postServices) {
        this.userServices = userServices;
        this.userRepository = userRepository;
        this.postServices = postServices;
    }

    @GetMapping("/registrations")
    public String showRegistrationForm(Model model) {
        model.addAttribute("FacebookUser", new FacebookUserRequestDTO());
        return "index";
    }


    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") FacebookUserRequestDTO user) {
        System.out.println("I was here");
        try {
            userServices.registerUser(user);
            System.out.println("Me tooooo");
            return "redirect:/welcomes";
        } catch (IllegalArgumentException e) {
            return "index";
        }
    }

    @GetMapping("/welcomes")
    public String showWelcomePage() {
        return "login";
    }

    @PostMapping("/welcome")
    public String processLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        // Attempt to login the user
        Optional<FacebookUser> optionalUser = userServices.loginUser(email, password);

        if (optionalUser.isPresent()) {
            FacebookUser user = optionalUser.get();

            // Set the user in the session for authentication
            session.setAttribute("user", user);

            // Redirect to the home page
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {
        // Get the authenticated user from the session
        FacebookUser user = (FacebookUser) session.getAttribute("user");

        // Check if the user is logged in
        if (user != null) {
            // Add the user's name to the model
            model.addAttribute("userName", user.getName());

            // Retrieve all posts
            List<Post> posts = postServices.getAllPosts();

            // Add the posts to the model
            model.addAttribute("posts", posts);

            // Return the homepage template
            return "home";
        } else {
            // If the user is not logged in, redirect to the login page
            return "redirect:/welcome";
        }
    }


}
