package com.application.market.repository;


import com.application.market.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findByEmail(String email);
}
