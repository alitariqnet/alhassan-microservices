package org.oril.services;

import org.oril.entities.User;
import org.oril.pojo.UserDto;
import org.oril.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.oril.mapper.UserMapper.userDtoToUser;
import static org.oril.mapper.UserMapper.userToUserDto;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto save(UserDto userDto) {
        userDto.setEnabled(true);
        System.out.println(userDto.toString());
        User user = userDtoToUser(userDto);
        System.out.println(user.toString());

        return userToUserDto(userRepository.save(user));
    }

}
