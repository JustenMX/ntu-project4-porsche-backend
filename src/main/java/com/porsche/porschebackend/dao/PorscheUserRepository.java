package com.porsche.porschebackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porsche.porschebackend.entity.PorscheUser;

public interface PorscheUserRepository extends JpaRepository<PorscheUser, Long> {

}
