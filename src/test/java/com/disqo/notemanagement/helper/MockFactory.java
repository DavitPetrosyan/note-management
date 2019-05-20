package com.disqo.notemanagement.helper;

import com.disqo.notemanagement.model.NoteDto;
import com.disqo.notemanagement.service.NoteInternalService;
import com.disqo.notemanagement.service.impl.NoteInternalServiceImpl;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.doReturn;

/**
 * author by davitpetrosyan on 2019-05-12.
 */
public class MockFactory {

	public NoteInternalService getMockedNoteInternalService() {
		NoteInternalService noteInternalService = Mockito.mock(NoteInternalServiceImpl.class);

		NoteDto noteDto1 = new NoteDto(1, 1, "title1", "note1", null, null);
		NoteDto noteDto2 = new NoteDto(2, 1, "title2", "note2", null, null);
		doReturn(noteDto1).when(noteInternalService).getNoteById(1);
		doReturn(Arrays.asList(noteDto1, noteDto2)).when(noteInternalService).getAllNotes();

		return noteInternalService;
	}

}
