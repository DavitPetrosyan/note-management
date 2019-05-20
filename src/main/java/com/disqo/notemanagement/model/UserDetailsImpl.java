package com.disqo.notemanagement.model;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl extends UserDto implements UserDetails {

	public UserDetailsImpl(UserDto user) {
		super(user.getUserId(), user.getEmail(), user.getPassword());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles()
				.stream()
				.map(role-> new SimpleGrantedAuthority("ROLE_"+role.toString()))
				.collect(Collectors.toList());
	}

	private Collection<Object> getRoles() {
		return Arrays.asList("ADMIN", "USER"); // TODO @Davit, change to normal RoleDto object
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return "firstName"; // TODO @Davit add fields to userDto object
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
