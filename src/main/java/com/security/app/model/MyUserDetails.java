package com.security.app.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

public class MyUserDetails implements UserDetails {

	private String userName;
	private String password;
	private List<String> roles;

	public MyUserDetails(User user, List<String> role) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.roles = role;
	}
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role=StringUtils.collectionToCommaDelimitedString(this.roles); 
		  return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
