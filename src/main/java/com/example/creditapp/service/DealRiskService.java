package com.example.creditapp.service;

import com.example.creditapp.model.CreditApplication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DealRiskService {

    public String calculateDealRisk(int creditScore, CreditApplication creditApplication) {
        BigDecimal amount = creditApplication.getAmount();
        String riskLevel;

        if (creditScore >= 70) {
            if (amount.compareTo(BigDecimal.valueOf(50000)) < 0) {
                riskLevel = "Low";
            } else if (amount.compareTo(BigDecimal.valueOf(100000)) < 0) {
                riskLevel = "Medium";
            } else {
                riskLevel = "High";
            }
        } else if (creditScore >= 50) {
            if (amount.compareTo(BigDecimal.valueOf(30000)) < 0) {
                riskLevel = "Medium";
            } else {
                riskLevel = "High";
            }
        } else {
            riskLevel = "High";
        }

        return riskLevel;
    }
}
