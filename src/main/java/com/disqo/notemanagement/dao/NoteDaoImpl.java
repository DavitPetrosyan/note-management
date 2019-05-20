package com.disqo.notemanagement.dao;

import com.disqo.notemanagement.model.NoteDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@Repository
public class NoteDaoImpl implements NoteDao {

	@Override
	public Collection<NoteDto> getAllNotes() {
		return null;
	}

	@Override
	public Collection<NoteDto> getUserAllNotes(Integer userId) {
		return null;
	}

	@Override
	public Optional<NoteDto> getNoteById(Integer noteId) {
		return Optional.empty();
	}

	@Override
	public Integer createNote(NoteDto noteDto) {
		return null;
	}

	@Override
	public void updateNote(NoteDto noteDto) {

	}

	@Override
	public void deleteNote(Integer noteId) {

	}
}
