package com.example.exam.user;

import com.example.exam.user.dto.UserDto;
import com.example.exam.user.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}