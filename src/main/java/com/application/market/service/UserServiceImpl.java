package com.application.market.service;

import com.application.market.dto.UserDto;
import com.application.market.entity.Profile;
import com.application.market.entity.Role;
import com.application.market.entity.User;
import com.application.market.repository.ProfileRepository;
import com.application.market.repository.RoleRepository;
import com.application.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        Profile profile = new Profile();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRegisterDate(LocalDateTime.now());

        profile.setEmail(userDto.getEmail());
        profile.setUser(user);

        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(role));

        userRepository.save(user);
        profileRepository.save(profile);
    }


    @Override
    public Profile getUserInfo(String email){

        Profile profile = profileRepository.findByEmail(email);

        if (profile != null) {
            return profile;
        } else
            return null;
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

            // For Many-to-Many or One-to-Many, ensure roles are removed first if needed
            user.getRoles().clear();
            userRepository.save(user);

            // Now delete the user
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
