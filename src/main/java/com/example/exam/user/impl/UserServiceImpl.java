package com.example.exam.user.impl;

import com.example.exam.role.RoleRepository;
import com.example.exam.role.entity.Role;
import com.example.exam.user.UserDtoMapper;
import com.example.exam.user.UserRepository;
import com.example.exam.user.UserService;
import com.example.exam.user.dto.UserDto;
import com.example.exam.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDtoMapper dtoMapper;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(dtoMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }
}