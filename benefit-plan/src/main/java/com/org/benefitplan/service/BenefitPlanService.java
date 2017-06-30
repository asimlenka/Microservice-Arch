package com.org.benefitplan.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.org.benefitplan.domain.BenefitPlan;
import com.org.benefitplan.domain.Contract;

@Service
public interface BenefitPlanService {


	public String findByBenefitPlanName(String name) throws Exception;
	
	List<BenefitPlan> findByGroupName(String groupName);

	void save(String groupName, Contract contract);

	

}
