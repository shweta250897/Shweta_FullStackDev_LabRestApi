package com.glearning.collegefest.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DomainUserDetails implements UserDetails{
	
	private User user;
	public DomainUserDetails(User user) {
		this.user= user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    List<Role> roles = this.user.getRoles();
	    List<GrantedAuthority> authorities= new ArrayList<>();
	    for(Role role: roles) {
	    	String roleName=role.getName();
	    	SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);
	    	authorities.add(authority);
	    }
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
