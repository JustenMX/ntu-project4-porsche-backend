package com.porsche.porschebackend.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "porsche_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PorscheUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Password is required")
    private String password;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Name is required")
    private String name;

    @Column(name = "vehicleNo", nullable = false)
    @NotNull(message = "vehicleNo is required")
    private String vehicleNo;

    @Column(name = "porsche_model", nullable = false)
    @NotNull(message = "Vehicle model is required")
    @Enumerated(EnumType.STRING)
    private PorscheModel porscheModel;

    @Column(name = "opt_marketing", nullable = false)
    @NotNull(message = "Opt for marketing is required")
    private boolean optMarketing;

    @Column(name = "join_date", nullable = false)
    @NotNull(message = "Registration date is required")
    @PastOrPresent(message = "Registration date should not be in the future")
    private LocalDate joinDate;

    /**
     * ONE TO ONE
     */
    @OneToOne(mappedBy = "porscheUser", cascade = CascadeType.ALL)
    private PorscheUserAuth porscheUserAuth;

}
