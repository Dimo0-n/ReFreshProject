package com.application.market.service;

import com.application.market.entity.Profile;
import com.application.market.entity.User;
import com.application.market.repository.ProfileRepository;
import com.application.market.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public void updateProfil(String email, Profile updatedProfile) {
        Profile existingProfile = profileRepository.findByEmail(email);
        User user = userService.findByEmail(email);

        if (existingProfile != null) {
            existingProfile.setName(updatedProfile.getName());
            user.setName(updatedProfile.getName());
            existingProfile.setSurname(updatedProfile.getSurname());
            user.setSurname(updatedProfile.getSurname());
            existingProfile.setPhoneNumber(updatedProfile.getPhoneNumber());
            user.setPhoneNumber(updatedProfile.getPhoneNumber());
            existingProfile.setAddress(updatedProfile.getAddress());
            existingProfile.setBase64Image(updatedProfile.getBase64Image());
            user.setBase64Image(updatedProfile.getBase64Image());

            userRepository.save(user);
            profileRepository.save(existingProfile);
        }
    }
}
