package com.org.benefitplan.controller;

import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.benefitplan.domain.BenefitPlan;
import com.org.benefitplan.service.BenefitPlanService;

@RestController
@RefreshScope
@Configuration
public class BenefitPlanController {

	@Autowired
	private BenefitPlanService benefitplanService;
	
	/*@Autowired
	private RestTemplate restTemplate;*/
	
	@Value("${server.port}")
	private int port;
	
	@Value("${refreshParameter}")
	private String testVal;

	private static final Logger LOG = Logger.getLogger(BenefitPlanController.class.getName());
	
	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public List<BenefitPlan> getCurrentAccountStatistics(Principal principal) {
		return benefitplanService.findByGroupName(principal.getName());
	}

	@RequestMapping(value = "/{groupName}", method = RequestMethod.GET)
	public String getBenefitPlansByGroupName(@PathVariable String groupName) throws Exception {
		LOG.log(Level.INFO, "calling getBenefitPlansByGroupName");
		return benefitplanService.findByBenefitPlanName(groupName);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "testFallbackId")
	public @ResponseBody String testHystrixById(@PathVariable int id) throws Exception {
		if(id == 1){
			LOG.log(Level.INFO, "Successfully Called Benefit-coding.");
			return "Successfully Called Benefit-coding.";
		}else{
			Thread.sleep(10000);
			LOG.log(Level.INFO, "Circuit Tripped while calling Benefit-Coding");
			throw new Exception("Circuit Tripped while calling Benefit-Coding");
		}
	}

	public String testFallbackId(int id, Throwable t) {
		LOG.log(Level.INFO, "Inside Fallback method, rootcause :" + t.getMessage());
		return "Inside Fallback method, rootcause :" + t.getMessage();
	}
	
	@RequestMapping(path="/refreshConfigParam",method = RequestMethod.GET)
	public @ResponseBody String refreshConfigParam(){
		LOG.log(Level.INFO, testVal);
		return  (String) testVal;
	}
	
	@RequestMapping(path="/plan",method = RequestMethod.GET)
	public @ResponseBody String getPortNumber()
	{
		LOG.log(Level.INFO, " Instance used of BENEFIT-PLAN is running on Port : " + port);
		return  (String) " Instance used of BENEFIT-PLAN is running on Port : " + port;
	}
	
}
