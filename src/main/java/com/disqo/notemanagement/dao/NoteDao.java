package com.disqo.notemanagement.dao;

import com.disqo.notemanagement.model.NoteDto;

import java.util.Collection;
import java.util.Optional;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public interface NoteDao {

	/**
	 * Returns all notes of the system.
	 * @return      Collection of noteDto objects.
	 */
	Collection<NoteDto> fetchAllNotes();

	/**
	 * Returns all notes of the provided user.
	 * @param userId           Provided userId.
	 * @return                  Collection of noteDto objects.
	 */
	Collection<NoteDto> fetchUserAllNotes(Integer userId);

	/**
	 * Returns note object by provided id.
	 * @param noteId            Provided note id.
	 * @return                  NoteDto object.
	 */
	Optional<NoteDto> fetchNoteById(Integer noteId);

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
