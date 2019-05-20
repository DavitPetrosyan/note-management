package com.disqo.notemanagement.endpoint;

import com.disqo.notemanagement.api.NoteService;
import com.disqo.notemanagement.model.NoteDto;
import com.disqo.notemanagement.service.NoteInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NoteServiceController implements NoteService {


	private NoteInternalService noteInternalService;

	@Autowired
	public NoteServiceController(NoteInternalService noteInternalService) {
		this.noteInternalService = noteInternalService;
	}


	@Override
	@GetMapping("")
	public Collection<NoteDto> getAllNotes() {
		return null;
	}

	@Override
	@GetMapping("/user/{userId}")
	public Collection<NoteDto> getUserAllNotes(Integer userId) {
		return null;
	}

	@Override
	@GetMapping("/{id}")
	public NoteDto getNoteById(Integer id) {
		return null;
	}

	@Override
	@PostMapping("/")
	public Object createNote(NoteDto noteDto) {
		return null;
	}

	@Override
	@PutMapping("/")
	public Object updateNote(NoteDto noteDto) {
		return null;
	}

	@Override
	@DeleteMapping("/")
	public Object deleteNote(Integer noteId) {
		return null;
	}

}
