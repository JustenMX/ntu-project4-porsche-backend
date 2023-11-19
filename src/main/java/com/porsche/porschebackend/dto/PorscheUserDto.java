package com.porsche.porschebackend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.porsche.porschebackend.entity.PorscheModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PorscheUserDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String vehicleNo;
    private PorscheModel porscheModel;
    private boolean optMarketing;
    private LocalDate joinDate;
}
