package com.porsche.porschebackend.service;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.porsche.porschebackend.dao.PorscheUserAuthRepository;
import com.porsche.porschebackend.dto.LoginRequestDto;
import com.porsche.porschebackend.dto.LoginResponseDto;
import com.porsche.porschebackend.entity.PorscheUserAuth;
import com.porsche.porschebackend.exception.AuthenticationFailureException;
import com.porsche.porschebackend.exception.PorscheUserAuthNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PorscheUserAuthService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private PorscheUserAuthRepository porscheUserAuthRepository;
    private TokenService tokenService;

    /**
     * LOAD USER BY USERNAME
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the porscheuser authentication service");

        return porscheUserAuthRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }

    /**
     * AUTHENTICATE PORSCHE USER LOGIN
     * 
     * @param loginRequestDto
     * @return
     */
    public LoginResponseDto authenticateLogin(LoginRequestDto loginRequestDto) {
        System.out.println("In the porscheuser  auth service (authenticate login)");
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        //
        PorscheUserAuth userDetails = porscheUserAuthRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user is not valid"));

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new AuthenticationFailureException("Invalid credentials");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        String jwtToken = tokenService.generateJwt(authentication);

        return new LoginResponseDto((PorscheUserAuth) userDetails, jwtToken);
    }

    /**
     * GET ALL PORSCHE USER AUTH
     * 
     * @return
     */
    public List<PorscheUserAuth> getAllPorscheUserAuth() {
        return porscheUserAuthRepository.findAll();
    }

    /**
     * GET SINGLE PORSCHE USER AUTH
     * 
     * @param id
     * @return
     */
    public PorscheUserAuth getPorscheUserAuth(Long id) {
        PorscheUserAuth porscheUserAuth = porscheUserAuthRepository.findById(id)
                .orElseThrow(() -> new PorscheUserAuthNotFoundException(id));
        return porscheUserAuth;
    }

}
