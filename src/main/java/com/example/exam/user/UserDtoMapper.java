package com.example.exam.user;

import com.example.exam.user.dto.UserDto;
import com.example.exam.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
