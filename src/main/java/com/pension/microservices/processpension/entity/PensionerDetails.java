package com.pension.microservices.processpension.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "PensionDetails")
public class PensionerDetails
{
    @Id
    @Column(name = "Aadhaar_Number")
    private String aadhaarNumber;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "DOB", nullable = false)
    private Date dob;
    @Column(name = "PAN", nullable = false)
    private String pan;
    @Column(name = "Salary", nullable = false)
    private long salaryEarned;
    @Column(name = "Allowances", nullable = false)
    private long allowances;
    @Column(name = "Pension_Type", nullable = false)
    private String pensionType;
    @Column(name = "Bank_Type", nullable = false)
    private String bankType;
    @Column(name = "Pension_Amount")
    private double pensionAmount;
    @Column(name = "Service_Charge")
    private double serviceCharge;
}