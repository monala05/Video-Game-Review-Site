package org.alanmontes.videogamereviewsite.security;

import org.alanmontes.videogamereviewsite.models.UserLogin;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
*/
public class CurrentUser {// implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private UserLogin userLogin;
	
	public CurrentUser(UserLogin userLogin) {
		super();
		this.userLogin = userLogin;
	}
	
	/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(userLogin.getUserRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userLogin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userLogin.getUserName();
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
	*/
}
