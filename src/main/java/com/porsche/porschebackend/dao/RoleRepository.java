package com.porsche.porschebackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porsche.porschebackend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
