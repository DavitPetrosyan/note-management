package com.disqo.notemanagement.dao;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public class SQLQueriesConstants {

	static final String LOAD_ALL_NOTES               = "SELECT * from note";
	static final String LOAD_ALL_NOTES_FOR_USER      = "SELECT * from note where owner_id = :ownerId";
	static final String LOAD_NOTE_BY_ID              = "SELECT * from note where id = :id limit 1";
	static final String CREATE_NOTE                  = "insert into note (owner_id, title, note) values (:ownerId, :title, :note)";
	static final String UPDATE_NOTE                  = "update note set owner_id = :ownerId,  title = :title, note=:note where id = :id";
	static final String DELETE_NOTE                  = "delete from note where id = :id";


	static final String LOAD_USER_BY_ID              = "SELECT * from \"user\" where email = :email limit 1";


	static final String USER_TABLE_CREATION_SCRIPT   = "create table if not exists \"user\"\n" +
			"(\n" +
			"\tid serial not null\n" +
			"\t\tconstraint user_pk\n" +
			"\t\t\tprimary key,\n" +
			"\temail varchar(100) not null,\n" +
			"\tpassword varchar(512) not null,\n" +
			"\tcreation_time timestamp default now() not null,\n" +
			"\tlast_modification_time timestamp default now() not null\n" +
			");";


	static final String NOTE_TABLE_CREATION_SCRIPT   = "create table if not exists note\n" +
			"(\n" +
			"\tid serial not null\n" +
			"\t\tconstraint note_pk\n" +
			"\t\t\tprimary key,\n" +
			"\towner_id integer not null\n" +
			"\t\tconstraint note_to_user_fk\n" +
			"\t\t\treferences \"user\"\n" +
			"\t\t\t\ton update cascade on delete cascade,\n" +
			"\ttitle varchar(50) not null,\n" +
			"\tnote varchar(1000) not null,\n" +
			"\tcreation_time timestamp default now() not null,\n" +
			"\tlast_modification_time timestamp default now() not null" +
			");";
}
