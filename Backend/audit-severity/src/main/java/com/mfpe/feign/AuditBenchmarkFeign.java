package com.mfpe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.model.AuditBenchmark;

/**
 * 
 * This is Feign interface which has a single method getAuditBenchmark
 * which is used to retrive auditbenchmark list
 * by connecting this microservice with auditbenchmark microservice. 
 * @author Rupesh Lal
 *
 */
@FeignClient(value = "auditbenchmark", url = "${ms.benchmark}")
public interface AuditBenchmarkFeign {
	
	@GetMapping("/AuditBenchmark")
	public List<AuditBenchmark> getAuditBenchmark(@RequestHeader("Authorization") String jwt); 
	
}
