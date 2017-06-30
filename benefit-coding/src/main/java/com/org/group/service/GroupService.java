package com.org.group.service;

import com.org.group.domain.Group;

public interface GroupService {

	/**
	 * Finds group by given name
	 *
	 * @param groupName
	 * @return found group
	 * @throws Exception 
	 */
	Group findByName(String groupName) throws Exception;

	/**
	 * Checks if group with the same name already exists
	 * Invokes Auth Service user creation
	 * Creates new group with default parameters
	 *
	 * @param user
	 * @return created group
	 */
	//Group create(User user);

	/**
	 * Validates and applies incoming group updates
	 * Invokes Statistics Service update
	 *
	 * @param name
	 * @param update
	 */
	//void saveChanges(String name, Group update);
}
