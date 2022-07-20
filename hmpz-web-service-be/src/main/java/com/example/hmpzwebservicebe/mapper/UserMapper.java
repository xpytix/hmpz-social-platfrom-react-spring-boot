package com.example.hmpzwebservicebe.mapper;

import com.example.hmpzwebservicebe.dto.UserDtoId;
import com.example.hmpzwebservicebe.model.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserDtoId userToUserDto(User user);
    public User userDtoToUser(UserDtoId userDtoId);
    public List<UserDtoId> userToUserDto(List<User> users);
}