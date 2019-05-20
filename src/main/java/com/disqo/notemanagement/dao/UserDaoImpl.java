package com.disqo.notemanagement.dao;

import com.disqo.notemanagement.dao.api.UserDao;
import com.disqo.notemanagement.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@Repository
public class UserDaoImpl implements UserDao {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Collection<UserDto> fetchAllUsers() {
		return null;
	}

	@Override
	public Optional<UserDto> findUserByEmail(String userEmail) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", userEmail);
		UserDto userDto = this.jdbcTemplate.queryForObject(SQLQueriesConstants.LOAD_USER_BY_ID, parameters, new DaoHelper.UserMapper());
		return Optional.ofNullable(userDto);
	}
}
