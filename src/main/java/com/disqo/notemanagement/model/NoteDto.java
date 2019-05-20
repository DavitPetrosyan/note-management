package com.disqo.notemanagement.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public class NoteDto {

	private final Integer id;
	private final Integer ownerId;
	private final String title;
	private final String note;
	private final LocalDate creationTime;
	private final LocalDate lastModificationTime;

	@JsonCreator
	public NoteDto(@JsonProperty("id") Integer id,
	               @JsonProperty("ownerId") Integer ownerId,
	               @JsonProperty("title") String title,
	               @JsonProperty("note") String note,
	               @JsonProperty("creationTime") LocalDate creationTime,
	               @JsonProperty("lastModificationTime") LocalDate lastModificationTime
	               ) {

		this.id = id;
		this.ownerId = ownerId;
		this.title = title;
		this.note = note;
		if(creationTime == null) {
			creationTime = LocalDate.now();
		}
		this.creationTime = creationTime;
		if(lastModificationTime == null) {
			lastModificationTime = LocalDate.now();
		}
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

	public LocalDate getCreationTime() {
		return creationTime;
	}

	public LocalDate getLastModificationTime() {
		return lastModificationTime;
	}
}
