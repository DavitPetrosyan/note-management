package com.disqo.notemanagement.service;

import com.disqo.notemanagement.model.NoteDto;

import java.util.Collection;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public interface NoteInternalService {

	/**
	 * Returns all notes of the system.
	 * @return      Collection of noteDto objects.
	 */
	Collection<NoteDto> getAllNotes();

	/**
	 * Returns all notes of the provided user.
	 * @param userId           Provided userId.
	 * @return                  Collection of noteDto objects.
	 */
	Collection<NoteDto> getUserAllNotes(Integer userId);

	/**
	 * Returns note object by provided id.
	 * @param noteId            Provided note id.
	 * @return                  NoteDto object.
	 */
	NoteDto getNoteById(Integer noteId);

	/**
	 * Creates new note.
	 * @param noteDto       Provided noteDto.
	 * @return              Returns newly generated id.
	 */
	Integer createNote(NoteDto noteDto);

	/**
	 * Updates provided noteDto object.
	 * @param noteDto       NoteDto object with new data.
	 */
	void updateNote(NoteDto noteDto);

	/**
	 * Deletes note by provided note Id
	 * @param noteId            Provided note id.
	 */
	void deleteNote(Integer noteId);
}
