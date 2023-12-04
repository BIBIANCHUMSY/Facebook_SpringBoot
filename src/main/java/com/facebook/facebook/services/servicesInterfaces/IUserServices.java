package com.facebook.facebook.services.servicesInterfaces;

import com.facebook.facebook.dto.userDTO.FacebookUserRequestDTO;
import com.facebook.facebook.entities.FacebookUser;

import java.util.List;
import java.util.Optional;

public interface IUserServices {
    FacebookUser registerUser(FacebookUserRequestDTO newUser);
    List<FacebookUser> getAllUsers();
    Optional<FacebookUser> getUserById(Long id);
    FacebookUser updateUser(FacebookUserRequestDTO user);
    Optional<FacebookUser> loginUser(String email, String password);
    void deleteUser(Long id);
    Long getUserIdByUsername(String name);

    //FacebookUser getUserByUsername(String username);
}
