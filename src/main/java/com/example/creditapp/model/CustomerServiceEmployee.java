package com.example.creditapp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CustomerServiceEmployee")
public class CustomerServiceEmployee extends Employee {
    // Дополнительные поля, если нужны
}
