package com.disqo.notemanagement.service.impl;

import com.disqo.notemanagement.model.NoteDto;
import com.disqo.notemanagement.service.NoteInternalService;

import java.util.Collection;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public class NoteInternalServiceImpl implements NoteInternalService {

	@Override
	public Collection<NoteDto> getAllNotes() {
		return null;
	}

	@Override
	public Collection<NoteDto> getUserAllNotes(Integer userId) {
		return null;
	}

	@Override
	public NoteDto getNoteById(Integer noteId) {
		return null;
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
