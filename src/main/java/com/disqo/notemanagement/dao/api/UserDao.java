package com.disqo.notemanagement.dao.api;

import com.disqo.notemanagement.model.UserDto;

import java.util.Collection;
import java.util.Optional;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public interface UserDao {

	/**
	 * Returns all users of the system.
	 * @return      Collection of noteDto objects.
	 */
	Collection<UserDto> fetchAllUsers();


	/**
	 * Returns user object by provided id.
	 * @param userEmail            Provided user email.
	 * @return                      NoteDto object.
	 */
	Optional<UserDto> findUserByEmail(String userEmail);
}
