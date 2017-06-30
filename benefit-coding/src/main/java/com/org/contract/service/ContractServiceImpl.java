package com.org.contract.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.group.domain.Contract;

@Service
public class ContractServiceImpl implements ContractService {

	private final Logger log = LoggerFactory.getLogger(getClass());

/*	@Autowired
	private ContractRepository repository;*/

	@Override
	@HystrixCommand(fallbackMethod = "fallbackFindByName")
	public Contract findByName(String contractName) throws Exception {
		throw new Exception("TESTING FALLBACK");
		/*Group group = new Group();
		group.setName("Success");
		return group;*/
	}
	
	public Contract fallbackFindByName(String contractName, Throwable t) {
		log.info("Inside Fallback method , rootcause :" + t.getMessage());
		Contract contract = new Contract();
		contract.setName("Fallback");
		return contract;
	}

	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public Contract create(User user) {

		Contract existing = repository.findByName(user.getUsername());
		Assert.isNull(existing, "account already exists: " + user.getUsername());

		//authClient.createUser(user);

		Group group = new Group();
		group.setName(user.getUsername());
		group.setCreationDate(new Date());

		Contract contract = new Contract();
		contract.setGroup(group);
		contract.setContractDate(new Date());

		repository.save(contract);

		log.info("new account has been created: " + group.getName());

		return contract;
	}

	*//**
	 * {@inheritDoc}
	 *//*
	@Override
	public void saveChanges(String name, Contract update) {

		Contract contract = repository.findByName(name);
		Assert.notNull(contract, "can't find contract with name " + name);

		contract.setNote(update.getNote());
		contract.setContractDate(new Date());
		repository.save(contract);

		log.debug("contract {} changes are saved", name);

		//statisticsClient.updateBenefitPlan(name, contract);
	}*/
}
