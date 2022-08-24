package com.pension.microservices.processpension.controller;

// import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

import com.pension.microservices.processpension.entity.PensionerDetails;
import com.pension.microservices.processpension.proxy.PensionerDetailsProxy;
import com.pension.microservices.processpension.repository.PensionerDetailsRepository;
import com.pension.microservices.processpension.service.PensionCalculation;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin("*")
public class ProcessPensionController
{
    @Autowired
    private PensionerDetailsProxy pensionerDetailsProxy;

    @Autowired
    private PensionCalculation pensionAmount;

    @Autowired
    private PensionerDetailsRepository pensionerDetailsRepository;

    @GetMapping(path = "/pension/calculate-pension/{id}")
    public ResponseEntity<PensionerDetails> calculatePension(@PathVariable String id)
    {
        PensionerDetails pensionerDetails = this.pensionerDetailsProxy.getPensionerDetailByAadhaar(id);

        PensionerDetails pd = new PensionerDetails(pensionerDetails.getAadhaarNumber(), pensionerDetails.getName(), pensionerDetails.getDob(), pensionerDetails.getPan(), pensionerDetails.getSalaryEarned(), pensionerDetails.getAllowances(), pensionerDetails.getPensionType(), pensionerDetails.getBankType(), pensionAmount.calculatePension(pensionerDetails.getSalaryEarned(), pensionerDetails.getAllowances(), pensionerDetails.getPensionType()), pensionAmount.calculateServiceCharge(pensionerDetails.getBankType()));

        return new ResponseEntity<PensionerDetails>(pensionerDetailsRepository.save(pd), HttpStatus.CREATED);

        // this.pensionerDetailsRepository.save(pd);
        // return ResponseEntity.ok(pensionerDetailsRepository.findById(id));
        // return pd;
    }

    @GetMapping(path = "/pension/show-pension-details/{id}")
    public ResponseEntity<Optional<PensionerDetails>> showPensionDetails(@PathVariable String id)
    {
        return ResponseEntity.ok(pensionerDetailsRepository.findById(id));
    }
}