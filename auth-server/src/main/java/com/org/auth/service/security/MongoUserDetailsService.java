package com.org.auth.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.org.auth.domain.UserDetails;
import com.org.auth.repository.UserRepository;

@Service
public class MongoUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repository;

	public UserDetails loadUserByUser(String username) throws UsernameNotFoundException {

		/*User user = repository.findOne(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		 */
		UserDetails user = new UserDetails();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setUsername(username);
		return user;
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
