package com.application.market.service;

import com.application.market.dto.UserDto;
import com.application.market.entity.Role;
import com.application.market.entity.User;
import com.application.market.repository.RoleRepository;
import com.application.market.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(@Valid UserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");

        user.setRoles(Arrays.asList(role));

        userRepository.save(user);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return List.of();
    }

//    @Override
//    public List<UserDto> findAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map((user) -> mapToUserDto(user))
//                .collect(Collectors.toList());
//    }
//
//    private UserDto mapToUserDto(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setLastName(user.getLastName());
//        userDto.setEmail(user.getEmail());
//        userDto.setRoles(user.getRoles().stream()
//                .map(Role::getName)
//                .collect(Collectors.toList()));
//        return userDto;
//    }

}
