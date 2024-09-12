package com.application.market.service;

import com.application.market.entity.Profile;
import com.application.market.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile findById(long id) {
        return profileRepository.findById(id);
    }

}
