package com.application.market.repository;

import com.application.market.entity.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilRepository extends JpaRepository <Profil, Long> {
}
