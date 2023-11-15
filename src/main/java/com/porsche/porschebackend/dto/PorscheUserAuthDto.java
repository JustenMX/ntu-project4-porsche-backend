package com.porsche.porschebackend.dto;

import java.util.Set;

import com.porsche.porschebackend.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PorscheUserAuthDto {
    private Long userId;
    private String username;
    private String password;
    private Set<Role> authorities;
}
