package com.example.creditapp.service;

import com.example.creditapp.model.Client;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CreditScoreService {

    public int calculateCreditScore(Client client) {
        int creditScore = 0;

        // Возраст
        int age = client.getDateOfBirth().until(LocalDate.now()).getYears();
        if (age >= 18 && age <= 25) {
            creditScore += 10;
        } else if (age > 25 && age <= 35) {
            creditScore += 20;
        } else if (age > 35) {
            creditScore += 30;
        }

        // Образование
        switch (client.getEducation().toLowerCase()) {
            case "high school":
                creditScore += 10;
                break;
            case "bachelor":
                creditScore += 20;
                break;
            case "master":
                creditScore += 30;
                break;
            case "phd":
                creditScore += 40;
                break;
        }

        // Работа
        if ("full-time".equalsIgnoreCase(client.getJob())) {
            creditScore += 30;
        } else if ("part-time".equalsIgnoreCase(client.getJob())) {
            creditScore += 20;
        } else if ("unemployed".equalsIgnoreCase(client.getJob())) {
            creditScore += 10;
        }

        // Средний годовой доход в белорусских рублях
        BigDecimal income = client.getAverageAnnualIncome();
        if (income.compareTo(BigDecimal.valueOf(20000)) < 0) {
            creditScore += 10;
        } else if (income.compareTo(BigDecimal.valueOf(50000)) < 0) {
            creditScore += 20;
        } else {
            creditScore += 30;
        }

        return creditScore;
    }
}
