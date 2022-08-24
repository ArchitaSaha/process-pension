package com.pension.microservices.processpension.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pension.microservices.processpension.entity.PensionerDetails;

public interface PensionerDetailsRepository extends JpaRepository<PensionerDetails, String>
{
    PensionerDetails getDetailsByAadhaarNumber(String aadhaarNumber);
}