package com.example.creditapp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DepartmentManager")
public class DepartmentManager extends Employee {
    // Дополнительные поля, если нужны
}
