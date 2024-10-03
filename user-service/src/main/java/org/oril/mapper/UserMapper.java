package org.oril.mapper;

import org.oril.entities.User;
import org.oril.pojo.UserDto;

public class UserMapper {

    public static User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setEnabled(userDto.isEnabled());
        user.setId(userDto.getId());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEnabled(user.isEnabled());
        userDto.setId(user.getId());
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
