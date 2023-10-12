package com.mfpe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mfpe.model.AuditType;
import com.mfpe.model.AuditQuestion;

/**
 * 
 * This is Feign interface which has a single method auditCheckListQuestions
 * which is used to retrive list of questions from checklist microservice
 * by connecting this microservice with checklist microservice. 
 * @author Rupesh Lal
 *
 */
@FeignClient(url = "${ms.checklist}", name="auditChecklist")
public interface AuditCheckListFeign {
	
	@RequestMapping(value = "/AuditCheckListQuestions", method = RequestMethod.POST )
	public List<AuditQuestion> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @RequestBody AuditType auditType);
	
}
