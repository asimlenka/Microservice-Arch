package com.org.group.controller;

import java.security.Principal;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.org.group.domain.Group;
import com.org.group.service.GroupService;

@Component
@RestController
@RefreshScope
@Configuration
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private int port;

	private static final Logger LOG = Logger.getLogger(GroupController.class.getName());
	
	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Group getCurrentGroup(Principal principal) throws Exception {
		return groupService.findByName(principal.getName());
	}

	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public String getTestResults(@PathVariable String name) throws Exception {
		LOG.log(Level.INFO, "calling getTestResult");
		Group group = groupService.findByName(name);
		return group.getName();
	}
	
	
	@RequestMapping(path="/callService",method = RequestMethod.GET)
	public @ResponseBody String getPortNumber()
	{
		LOG.log(Level.INFO, "Inside Benefit-coding callService");
		String result = restTemplate.getForObject("http://BENEFIT-PLAN/statistics/plan", String.class);
		long range = 1234567L;
		Random r = new Random();
		long number = (long)(r.nextDouble()*range);
		
		StringBuilder finalResponse = new StringBuilder();
		finalResponse.append("Called Benefit coding : "+ number);
		finalResponse.append("    ::   ");
		finalResponse.append("Instance used of BENEFIT-CODING is running on Port :"+ port);
		finalResponse.append("    ::   ");
		finalResponse.append("And Internally called BENEFIT_PLAN Service, "+result);
		LOG.log(Level.INFO, finalResponse.toString());
		return finalResponse.toString();
	}
	
}
