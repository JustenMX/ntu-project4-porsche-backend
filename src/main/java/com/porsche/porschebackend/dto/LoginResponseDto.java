package com.porsche.porschebackend.dto;

import com.porsche.porschebackend.entity.PorscheUserAuth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private PorscheUserAuth porscheUserAuth;
    private String jwt;
}
