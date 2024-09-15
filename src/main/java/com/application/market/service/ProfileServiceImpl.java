package com.application.market.service;

import com.application.market.entity.Profile;
import com.application.market.repository.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void updateProfil(String email, Profile addedProfile) {
        Profile sentProfile = new Profile();
        sentProfile = profileRepository.findByEmail(email);

        if (sentProfile == null) {
            // Handle the case when the profile is not found
            throw new EntityNotFoundException("Profile with email " + email + " not found");
        }

        sentProfile.setName(addedProfile.getName());
        sentProfile.setSurname(addedProfile.getSurname());

        sentProfile.setAddress(addedProfile.getAddress());

        profileRepository.save(sentProfile);
    }
}
