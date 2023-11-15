package com.porsche.porschebackend.dto;

import java.time.LocalDate;

import com.porsche.porschebackend.entity.PorscheModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PorscheUserRegDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private PorscheModel porscheModel;
    private boolean optMarketing;
    private LocalDate joinDate;
}
