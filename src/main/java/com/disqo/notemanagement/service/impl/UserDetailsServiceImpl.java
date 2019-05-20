package com.disqo.notemanagement.service.impl;

import com.disqo.notemanagement.dao.api.UserDao;
import com.disqo.notemanagement.model.UserDetailsImpl;
import com.disqo.notemanagement.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * author by davitpetrosyan on 2019-05-19.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserDao userDao;

	@Autowired
	public UserDetailsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

		Optional<UserDto> user = this.userDao.findUserByEmail(userEmail);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(userEmail);
		}
		return new UserDetailsImpl(user.get());
	}

}
