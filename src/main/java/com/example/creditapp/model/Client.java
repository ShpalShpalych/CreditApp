package com.example.creditapp.model;

import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private String passportNumber;
    private String phoneNumber;
    private String job;
    private String education;
    private BigDecimal averageAnnualIncome;
    private int creditScore;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CreditApplication> creditApplications;

}
