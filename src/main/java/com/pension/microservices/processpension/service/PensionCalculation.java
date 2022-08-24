package com.pension.microservices.processpension.service;

import org.springframework.stereotype.Service;

@Service
public class PensionCalculation
{
    public double calculatePension(double salary, double allowance, String pensionType)
    {
        double pensionAmount = 0;
        if(pensionType.equalsIgnoreCase("self"))
        {
            pensionAmount = (salary * 0.80) + allowance;
        }
        else if(pensionType.equalsIgnoreCase("family"))
        {
            pensionAmount = (salary * 0.50) + allowance;
        }
        return pensionAmount; 
    }

    public double calculateServiceCharge(String bankType)
    {
        double serviceCharge = 0;
        if(bankType.equalsIgnoreCase("private"))        serviceCharge = 550.0;
        else if(bankType.equalsIgnoreCase("public"))    serviceCharge = 500.0;
        return serviceCharge;
    }

    public double deductServiceCharge(double pensionAmount, double serviceCharge)
    {
        return pensionAmount - serviceCharge;
    }
}