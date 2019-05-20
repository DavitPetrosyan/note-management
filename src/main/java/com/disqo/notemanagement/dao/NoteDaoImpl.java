package com.disqo.notemanagement.dao;

import com.disqo.notemanagement.dao.api.NoteDao;
import com.disqo.notemanagement.model.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@Repository
public class NoteDaoImpl implements NoteDao {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public NoteDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Collection<NoteDto> fetchAllNotes() {
		return this.jdbcTemplate.query(SQLQueriesConstants.LOAD_ALL_NOTES, new DaoHelper.NoteMapper());
	}

	@Override
	public Collection<NoteDto> fetchUserAllNotes(Integer userId) {
		return this.jdbcTemplate.query(SQLQueriesConstants.LOAD_ALL_NOTES_FOR_USER, new DaoHelper.NoteMapper());
	}

	@Override
	public Optional<NoteDto> fetchNoteById(Integer noteId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", noteId);
		NoteDto noteDto = this.jdbcTemplate.queryForObject(SQLQueriesConstants.LOAD_NOTE_BY_ID, parameters, new DaoHelper.NoteMapper());
		return Optional.ofNullable(noteDto);
	}

	@Override
	public Integer createNote(NoteDto noteDto) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("ownerId", noteDto.getOwnerId());
		parameters.put("title", noteDto.getTitle());
		parameters.put("note", noteDto.getNote());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(SQLQueriesConstants.CREATE_NOTE, new MapSqlParameterSource(parameters), keyHolder);
		if (keyHolder.getKeys().size() > 1) { //TODO @Davit, maybe can move to script?
			return (int)keyHolder.getKeys().get("id");
		} else {
			return keyHolder.getKey().intValue();
		}
	}

	@Override
	public void updateNote(NoteDto noteDto) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("ownerId", noteDto.getOwnerId());
		parameters.put("title", noteDto.getTitle());
		parameters.put("note", noteDto.getNote());//TODO @Davit, do not update creation time
		this.jdbcTemplate.update(SQLQueriesConstants.UPDATE_NOTE, new MapSqlParameterSource(parameters));
	}

	@Override
	public void deleteNote(Integer noteId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", noteId);
		this.jdbcTemplate.update(SQLQueriesConstants.DELETE_NOTE, new MapSqlParameterSource(parameters));
	}
}
