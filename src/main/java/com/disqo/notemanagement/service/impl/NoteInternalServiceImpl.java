package com.disqo.notemanagement.service.impl;

import com.disqo.notemanagement.dao.NoteDao;
import com.disqo.notemanagement.exception.CustomNoteException;
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
		return this.noteDao.fetchAllNotes();
	}

	@Override
	public Collection<NoteDto> getUserAllNotes(Integer userId) {
		return this.noteDao.fetchUserAllNotes(userId);
	}

	@Override
	public NoteDto getNoteById(Integer noteId) {
		return this.noteDao.fetchNoteById(noteId).orElseThrow(CustomNoteException::new); //TODO @Davit, create custom own exception
	}

	@Override
	public Integer createNote(NoteDto noteDto) {
		return this.noteDao.createNote(noteDto);
	}

	@Override
	public void updateNote(NoteDto noteDto) {
		this.noteDao.updateNote(noteDto);
	}

	@Override
	public void deleteNote(Integer noteId) {
		this.noteDao.deleteNote(noteId);
	}
}
