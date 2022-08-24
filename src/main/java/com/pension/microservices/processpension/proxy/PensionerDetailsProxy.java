package com.pension.microservices.processpension.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pension.microservices.processpension.entity.PensionerDetails;

@FeignClient(name = "pensioner-detail", url = "localhost:8000")
public interface PensionerDetailsProxy
{
    @GetMapping(value = "/pension/pensioner-details-by-aadhaar/{id}")
	public PensionerDetails getPensionerDetailByAadhaar(@PathVariable(name = "id") String id);
}