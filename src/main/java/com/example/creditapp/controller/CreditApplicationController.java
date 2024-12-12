package com.example.creditapp.controller;

import com.example.creditapp.model.CreditApplication;
import com.example.creditapp.service.CreditApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class CreditApplicationController {

    @Autowired
    private CreditApplicationService creditApplicationService;

    @GetMapping
    public List<CreditApplication> getAllApplications() {
        return creditApplicationService.getAllApplications();
    }

    @PostMapping
    public CreditApplication saveApplication(@RequestBody CreditApplication application) {
        return creditApplicationService.saveApplication(application);
    }

    @GetMapping("/{id}")
    public CreditApplication getApplicationById(@PathVariable Long id) {
        return creditApplicationService.getApplicationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        creditApplicationService.deleteApplication(id);
    }

    @GetMapping("/application-details/{id}")
    public String getApplicationDetails(@PathVariable Long id, Model model) {
        CreditApplication application = creditApplicationService.getApplicationById(id);
        model.addAttribute("application", application);
        return "application_details";
    }

}
