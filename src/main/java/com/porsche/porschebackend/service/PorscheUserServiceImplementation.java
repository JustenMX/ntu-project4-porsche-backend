package com.porsche.porschebackend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.porsche.porschebackend.dao.PorscheUserAuthRepository;
import com.porsche.porschebackend.dao.PorscheUserRepository;
import com.porsche.porschebackend.dao.RoleRepository;
import com.porsche.porschebackend.dto.PorscheUserDto;
import com.porsche.porschebackend.dto.PorscheUserRegDto;
import com.porsche.porschebackend.entity.PorscheUser;
import com.porsche.porschebackend.entity.PorscheUserAuth;
import com.porsche.porschebackend.entity.Role;
import com.porsche.porschebackend.exception.PorscheUserNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PorscheUserServiceImplementation implements PorscheUserService {

    private final Logger logger = LoggerFactory.getLogger(PorscheUserServiceImplementation.class);
    private PorscheUserRepository porscheUserRepository;
    private PorscheUserAuthRepository porscheUserAuthRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public PorscheUser registerUser(PorscheUserRegDto porscheUserRegDto) {
        PorscheUser porscheUser = new PorscheUser();
        porscheUser.setEmail(porscheUserRegDto.getEmail());
        porscheUser.setPassword(porscheUserRegDto.getPassword());
        porscheUser.setName(porscheUserRegDto.getName());
        porscheUser.setVehicleNo(porscheUserRegDto.getVehicleNo());
        porscheUser.setPorscheModel(porscheUserRegDto.getPorscheModel());
        porscheUser.setOptMarketing(porscheUserRegDto.isOptMarketing());
        porscheUser.setJoinDate(porscheUserRegDto.getJoinDate());
        porscheUser = porscheUserRepository.save(porscheUser);

        // HASH THE PASSWORD FOR ADDITIONAL SECURITY
        String hashedPassword = passwordEncoder.encode(porscheUser.getPassword());
        porscheUser.setPassword(hashedPassword);

        // LOGGER
        logger.info("Added new customer [ID: {}, Name: {}]", porscheUser.getId(),
                porscheUser.getName());

        // CREATE SPRING USER AUTH FOR AUTHENTICATION
        PorscheUserAuth porscheUserAuth = new PorscheUserAuth();
        porscheUserAuth.setUsername(porscheUser.getEmail());
        porscheUserAuth.setPassword(porscheUser.getPassword());

        // SET DEFAULT ROLES
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(null, "USER"));
        roleRepository.saveAll(roles);
        porscheUserAuth.setAuthorities(roles);

        porscheUserAuth = porscheUserAuthRepository.save(porscheUserAuth);
        porscheUser.setPorscheUserAuth(porscheUserAuth);

        return porscheUserRepository.save(porscheUser);

    }

    /**
     * GET ALL USERS
     */
    @Override
    public List<PorscheUser> getAllUsers() {
        List<PorscheUser> allUsers = porscheUserRepository.findAll();
        logger.info("Retrieved {} users successfully", allUsers.size());
        return allUsers;
    }

    /**
     * GET ONE USER
     */
    @Override
    public PorscheUser getUser(Long id) {
        PorscheUser porscheUser = porscheUserRepository.findById(id)
                .orElseThrow(() -> new PorscheUserNotFoundException(id));
        logger.info("Retrieved user [ID: {}, Name: {}] successfully", porscheUser.getId(), porscheUser.getName());
        return porscheUser;
    }

    /**
     * UPDATE USER
     */
    @Override
    public PorscheUser updateUser(Long id, PorscheUserDto porscheUserDto) {
        PorscheUser updateUser = porscheUserRepository.findById(id)
                .orElseThrow(() -> new PorscheUserNotFoundException(id));
        updateUser.setEmail(porscheUserDto.getEmail());
        updateUser.setPassword(porscheUserDto.getPassword());
        updateUser.setName(porscheUserDto.getName());
        updateUser.setVehicleNo(porscheUserDto.getVehicleNo());
        updateUser.setPorscheModel(porscheUserDto.getPorscheModel());
        updateUser.setOptMarketing(porscheUserDto.isOptMarketing());
        updateUser.setJoinDate(porscheUserDto.getJoinDate());
        logger.info("Updated user [ID: {}, Name: {} {}]", updateUser.getId(), updateUser.getName());
        return updateUser;
    }

    /**
     * DELETE USER
     */
    @Override
    public void deleteUser(Long id) {
        logger.info("Deleted user with ID: {}", id);
        porscheUserRepository.deleteById(id);
    }

}
