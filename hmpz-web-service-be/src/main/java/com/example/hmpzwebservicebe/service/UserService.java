package com.example.hmpzwebservicebe.service;

import com.example.hmpzwebservicebe.dto.UserDtoId;
import com.example.hmpzwebservicebe.mapper.UserMapper;
import com.example.hmpzwebservicebe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDtoId> getUsers() {
        return userMapper.userToUserDto(userRepository.findAll());
    }
}
