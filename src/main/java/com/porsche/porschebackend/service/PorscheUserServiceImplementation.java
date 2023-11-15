package com.porsche.porschebackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.porsche.porschebackend.dao.PorscheUserAuthRepository;
import com.porsche.porschebackend.dao.PorscheUserRepository;
import com.porsche.porschebackend.dao.RoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PorscheUserServiceImplementation implements PorscheUserService {

    private final Logger logger = LoggerFactory.getLogger(PorscheUserServiceImplementation.class);
    private PorscheUserRepository porscheUserRepository;
    private PorscheUserAuthRepository porscheUserAuthRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
}
