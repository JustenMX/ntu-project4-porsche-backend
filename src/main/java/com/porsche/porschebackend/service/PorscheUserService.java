package com.porsche.porschebackend.service;

import java.util.List;

import com.porsche.porschebackend.dto.PorscheUserDto;
import com.porsche.porschebackend.dto.PorscheUserRegDto;
import com.porsche.porschebackend.entity.PorscheUser;

public interface PorscheUserService {

    /**
     * REGISTER USERS
     * 
     * @param porscheUserRegDto
     * @return
     */
    PorscheUser registerUser(PorscheUserRegDto porscheUserRegDto);

    /**
     * GET ALL USERS
     * 
     * @return
     */
    List<PorscheUser> getAllUsers();

    /**
     * GET SINGLE USER
     * 
     * @param id
     * @return
     */
    PorscheUser getUser(Long id);

    /**
     * UPDATE USER
     * 
     * @param id
     * @param porscheUserDto
     * @return
     */
    PorscheUser updateUser(Long id, PorscheUserDto porscheUserDto);

    /**
     * DELETE USER
     * 
     * @param id
     */
    void deleteUser(Long id);

}
