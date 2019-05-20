package com.disqo.notemanagement.service.impl;

import com.disqo.notemanagement.dao.NoteDao;
import com.disqo.notemanagement.model.NoteDto;
import com.disqo.notemanagement.service.NoteInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@Service
public class NoteInternalServiceImpl implements NoteInternalService {


	private NoteDao noteDao;

	@Autowired
	public NoteInternalServiceImpl(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

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
