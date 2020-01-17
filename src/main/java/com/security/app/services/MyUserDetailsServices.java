package com.security.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.app.model.MyUserDetails;
import com.security.app.model.User;
import com.security.app.repo.RoleRepo;
import com.security.app.repo.UserRepo;

@Service
public class MyUserDetailsServices implements UserDetailsService {
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found "+ username);
		}else {
			List<String> role = roleRepo.findByUserName(username);			
			return new MyUserDetails(user,role);
		}
	}

}
