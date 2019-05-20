package com.disqo.notemanagement.endpoint;

import com.disqo.notemanagement.api.NoteService;
import com.disqo.notemanagement.model.NoteDto;
import com.disqo.notemanagement.service.NoteInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		return this.noteInternalService.getAllNotes();
	}

	@Override
	@GetMapping("/user/{userId}")
	public Collection<NoteDto> getUserAllNotes(Integer userId) {
		return this.noteInternalService.getUserAllNotes(userId);
	}

	@Override
	@GetMapping("/{id}")
	public NoteDto getNoteById(@PathVariable("id") Integer noteId) {
		return this.noteInternalService.getNoteById(noteId);
	}

	@Override
	@PostMapping("/")
	public Object createNote(@RequestBody NoteDto noteDto) {
		Integer insertedId = this.noteInternalService.createNote(noteDto);
		return new ResponseEntity<>(insertedId, HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/")
	public Object updateNote(@RequestBody NoteDto noteDto) {
		this.noteInternalService.updateNote(noteDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/{noteId}")
	public Object deleteNote(Integer noteId) {
		this.noteInternalService.deleteNote(noteId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
