package com.disqo.notemanagement.model;

import java.time.LocalDateTime;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public class NoteDto {

	private final Integer id;
	private final Integer ownerId;
	private final String title;
	private final String note;
	private final LocalDateTime creationTime;
	private final LocalDateTime lastModificationTime;

	public NoteDto(Integer id, Integer ownerId, String title, String note) {
		this.id = id;
		this.ownerId = ownerId;
		this.title = title;
		this.note = note;
		LocalDateTime now = LocalDateTime.now();
		this.creationTime = now;
		this.lastModificationTime = now;
	}

	public NoteDto(Integer id, Integer ownerId, String title, String note, LocalDateTime creationTime, LocalDateTime lastModificationTime) {
		this.id = id;
		this.ownerId = ownerId;
		this.title = title;
		this.note = note;
		this.creationTime = creationTime;
		this.lastModificationTime = lastModificationTime;
	}

	public Integer getId() {
		return id;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public String getTitle() {
		return title;
	}

	public String getNote() {
		return note;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public LocalDateTime getLastModificationTime() {
		return lastModificationTime;
	}
}
