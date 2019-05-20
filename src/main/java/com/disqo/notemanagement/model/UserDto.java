package com.disqo.notemanagement.model;

import java.time.LocalDateTime;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public class UserDto {

	private final Integer userId;
	private final String  email;
	private final String  password;
	private final LocalDateTime creationTime;
	private final LocalDateTime lastModificationTime;

	public UserDto(Integer userId, String email, String password) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		LocalDateTime now = LocalDateTime.now();
		this.creationTime = now;
		this.lastModificationTime = now;
	}

	public UserDto(Integer userId, String email, String password, LocalDateTime creationTime, LocalDateTime lastModificationTime) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.creationTime = creationTime;
		this.lastModificationTime = lastModificationTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public LocalDateTime getLastModificationTime() {
		return lastModificationTime;
	}
}
