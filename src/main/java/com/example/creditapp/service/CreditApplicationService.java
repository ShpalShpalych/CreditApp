package com.example.creditapp.service;

import com.example.creditapp.model.CreditApplication;
import com.example.creditapp.repository.CreditApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditApplicationService {

    @Autowired
    private CreditApplicationRepository creditApplicationRepository;

    public List<CreditApplication> getAllApplications() {
        return creditApplicationRepository.findAll();
    }

    public CreditApplication saveApplication(CreditApplication application) {
        return creditApplicationRepository.save(application);
    }

    public CreditApplication getApplicationById(Long id) {
        return creditApplicationRepository.findById(id).orElse(null);
    }

    public void deleteApplication(Long id) {
        creditApplicationRepository.deleteById(id);
    }
}
