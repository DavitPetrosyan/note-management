package com.disqo.notemanagement.api;

import com.disqo.notemanagement.model.NoteDto;

import java.util.Collection;
import java.util.List;

/**
 * Main api of note management.
 *
 * author by davitpetrosyan on 2019-05-20.
 */
public interface NoteService {

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
	 * @return              Returns object of type Object.
	 */
	Object createNote(NoteDto noteDto);

	/**
	 * Creates new notes.
	 * @param noteDtoList   List of new notes.
	 * @return              Returns object of type Object.
	 */
	Object createNotes(List<NoteDto> noteDtoList);

	/**
	 * Updates provided noteDto object.
	 * @param noteDto       NoteDto object with new data.
	 * @return              returns object of type Object.
	 */
	Object updateNote(NoteDto noteDto);

	/**
	 * Deletes note by provided note Id
	 * @param noteId            Provided note id.
	 * @return                  Returns object of type Object
	 */
	Object deleteNote(Integer noteId);

	/**
	 * Deletes provided user all notes.
	 * @param userId           Provided user id.
	 * @return                  Returns object of type Object
	 */
	Object deleteUserNotes(Integer userId);
}
