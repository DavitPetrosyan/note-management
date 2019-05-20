package com.disqo.notemanagement.dao;

import com.disqo.notemanagement.model.NoteDto;
import com.disqo.notemanagement.model.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author by davitpetrosyan on 11/11/18.
 */
public final class DaoHelper {

	static class NoteMapper
			implements RowMapper<NoteDto> {

		@Override
		public NoteDto mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			return new NoteDto(
					rs.getInt("id"),
					rs.getInt("owner_id"),
					rs.getString("title"),
					rs.getString("note"),
					null, //TODO @Davit, convert Date to LocalDate
					null
					);
		}
	}



	static class UserMapper
			implements RowMapper<UserDto> {

		@Override
		public UserDto mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			return new UserDto(
					rs.getInt("id"),
					rs.getString("email"),
					rs.getString("password")
			);
		}
	}
}
