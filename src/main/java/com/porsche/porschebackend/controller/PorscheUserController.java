package com.porsche.porschebackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porsche.porschebackend.dto.PorscheUserDto;
import com.porsche.porschebackend.dto.PorscheUserRegDto;
import com.porsche.porschebackend.entity.PorscheUser;
import com.porsche.porschebackend.service.PorscheUserServiceImplementation;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/porschesg/api/user")
public class PorscheUserController {

    private PorscheUserServiceImplementation porscheUserService;

    @GetMapping("/hello")
    public String helloPorscheUserController() {
        return "Porsche User Level Access";
    }

    /**
     * CREATE USER
     * 
     * @param PorscheUserRegistration
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<PorscheUser> registerUser(@RequestBody PorscheUserRegDto porscheUserRegDto) {
        return new ResponseEntity<>(porscheUserService.registerUser(porscheUserRegDto), HttpStatus.OK);
    }

    /**
     * GET ALL USERS
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<PorscheUser>> getAllUsers() {
        List<PorscheUser> allUsers = porscheUserService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);

    }

    /**
     * GET ONE USER
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PorscheUser> getUser(@PathVariable Long id) {
        PorscheUser porscheUser = porscheUserService.getUser(id);
        return new ResponseEntity<>(porscheUser, HttpStatus.OK);
    }

    /**
     * UPDATE USER
     * 
     * @param id
     * @param PorscheUserDto
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<PorscheUser> updateUser(@PathVariable Long id,
            @RequestBody PorscheUserDto PorscheUserDto) {
        PorscheUser updateUser = porscheUserService.updateUser(id, PorscheUserDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    /**
     * DELETE USER
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        porscheUserService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
