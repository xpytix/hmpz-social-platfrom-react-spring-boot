package com.example.hmpzwebservicebe.controller;

import com.example.hmpzwebservicebe.dto.UserDtoId;
import com.example.hmpzwebservicebe.model.Post;
import com.example.hmpzwebservicebe.model.User;
import com.example.hmpzwebservicebe.repository.UserRepository;
import com.example.hmpzwebservicebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserDtoId>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }



}