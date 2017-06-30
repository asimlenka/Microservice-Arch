package com.org.benefitplan.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.benefitplan.domain.BenefitPlan;
import com.org.benefitplan.domain.Contract;

@Service
public class BenefitPlanServiceImpl implements BenefitPlanService {

	private static final Logger LOG = Logger.getLogger(BenefitPlanServiceImpl.class.getName());

	/*@Autowired
	private BenefitPlanRepository repository;*/
	
	@Override
	@HystrixCommand(fallbackMethod = "fallback")
	public String findByBenefitPlanName(String name) throws Exception {
		LOG.log(Level.INFO, "Calling findByBenefitPlanName service");
		//return repository.findByBenefitPlanId(benefitPlanId);
		throw new Exception("TESTING FALLBACK");
	}
	
	public String fallback(String name, Throwable t) {
		return "Successfully handled , returning response now.";
	}

	@Override
	public void save(String groupName, Contract contract) {

	}

	@Override
	public List<BenefitPlan> findByGroupName(String groupName) {
		return null;
	}


}
