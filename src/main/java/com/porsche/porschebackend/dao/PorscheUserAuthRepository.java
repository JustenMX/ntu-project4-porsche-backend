package com.porsche.porschebackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porsche.porschebackend.entity.PorscheUserAuth;

public interface PorscheUserAuthRepository extends JpaRepository<PorscheUserAuth, Long> {

}
