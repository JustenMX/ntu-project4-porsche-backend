package com.porsche.porschebackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porsche.porschebackend.dto.LoginRequestDto;
import com.porsche.porschebackend.dto.LoginResponseDto;
import com.porsche.porschebackend.entity.PorscheUserAuth;
import com.porsche.porschebackend.service.PorscheUserAuthService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/porschesg/api/authentication")
public class PorscheUserAuthController {

    private PorscheUserAuthService porscheUserAuthService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateLogin(@RequestBody LoginRequestDto loginRequestDto) {
        return new ResponseEntity<>(porscheUserAuthService.authenticateLogin(loginRequestDto), HttpStatus.OK);
    }

    /**
     * GET ALL PORSCHE USER AUTH
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<PorscheUserAuth>> getAllPorscheUserAuth() {
        return new ResponseEntity<>(porscheUserAuthService.getAllPorscheUserAuth(), HttpStatus.OK);
    }

    /**
     * GET PORSCHE USER AUTH
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PorscheUserAuth> getPorscheUserAuth(@PathVariable Long id) {
        return new ResponseEntity<>(porscheUserAuthService.getPorscheUserAuth(id), HttpStatus.OK);
    }

}
