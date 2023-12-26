CREATE TABLE t_file(
	id serial,
	file_extens TEXT,
	file_name TEXT NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_file ADD CONSTRAINT id_file_pk
	PRIMARY KEY(id);

CREATE TABLE t_file_type(
	id serial,
	type_name TEXT NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_file_type ADD CONSTRAINT id_file_type_pk
	PRIMARY KEY(id);

CREATE TABLE t_profile(
	id serial,
	full_name VARCHAR(30) NOT NULL,
	phone_numb VARCHAR(12) NOT NULL,
	profile_photo int,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_profile ADD CONSTRAINT id_profile_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_profile ADD CONSTRAINT id_profile_photo_fk
	FOREIGN KEY(profile_photo)
	REFERENCES t_file(id);

CREATE TABLE t_role(
	id serial,
	role_name VARCHAR(20),
	role_code VARCHAR(5),
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_role ADD CONSTRAINT id_role_pk
	PRIMARY KEY(id);

CREATE TABLE t_user(
	id serial,
	username TEXT NOT NULL,
	user_password TEXT NOT NULL,
	id_role int NOT NULL,
	id_profile int NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_user ADD CONSTRAINT id_user_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_user ADD CONSTRAINT id_user_role_fk
	FOREIGN KEY(id_role)
	REFERENCES t_role(id);

ALTER TABLE t_user ADD CONSTRAINT id_user_profile_fk
	FOREIGN KEY(id_profile)
	REFERENCES t_profile(id);

CREATE TABLE t_question_type(
	id serial,
	type_question_name VARCHAR(10) NOT NULL,
	type_code VARCHAR(5) NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_question_type ADD CONSTRAINT id_question_type_pk
	PRIMARY KEY(id);


CREATE TABLE t_progress_status(
	id serial,
	status_name VARCHAR(30) NOT NULL,
	status_code VARCHAR(5) NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_progress_status ADD CONSTRAINT id_progress_status_pk
	PRIMARY KEY(id);

CREATE TABLE t_result_status(
	id serial,
	result_name VARCHAR(20),
	result_code VARCHAR(5),
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_result_status ADD CONSTRAINT id_result_status_pk
	PRIMARY KEY(id);

CREATE TABLE t_candidate_assign(
	id serial,
	candidate_id int NOT NULL,
	question_type_id int NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_candidate_assign ADD CONSTRAINT id_candidate_assign_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_candidate_assign ADD CONSTRAINT id_candidate_assign_candidate_fk
	FOREIGN KEY(candidate_id)
	REFERENCES t_user(id);

ALTER TABLE t_candidate_assign ADD CONSTRAINT id_candidate_assign_question_type_fk
	FOREIGN KEY(question_type_id)
	REFERENCES t_question_type(id);

CREATE TABLE t_question_packet(
	id serial,
	packet_question_name VARCHAR(30),
	packet_question_code VARCHAR(5),
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_question_packet ADD CONSTRAINT id_question_packet_pk
	PRIMARY KEY(id);

CREATE TABLE t_question_topic(
	id serial,
	topic_name VARCHAR(30) NOT NULL,
	topic_code VARCHAR(5) NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_question_topic ADD CONSTRAINT id_question_topic_pk
	PRIMARY KEY(id);

CREATE TABLE t_question(
	id serial,
	question_name TEXT NOT NULL,
	question_code VARCHAR(5) NOT NULL,
	id_question_topic int NOT NULL,
	id_question_type int NOT NULL,
	id_question_packet int NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_question ADD CONSTRAINT id_question_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_question ADD CONSTRAINT id_question_topic_fk
	FOREIGN KEY(id_question_topic)
	REFERENCES t_question_topic(id);

ALTER TABLE t_question ADD CONSTRAINT id_question_type_fk
	FOREIGN KEY(id_question_type)
	REFERENCES t_question_type(id);

ALTER TABLE t_question ADD CONSTRAINT id_question_packet_fk
	FOREIGN KEY(id_question_packet)
	REFERENCES t_question_packet(id);

CREATE TABLE t_question_option(
	id serial,
	option_label TEXT NOT NULL,
	option_correct boolean NOT NULL,
	id_question int NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_question_option ADD CONSTRAINT id_question_option_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_question_option ADD CONSTRAINT id_question_option_question_fk
	FOREIGN KEY(id_question)
	REFERENCES t_question(id);

CREATE TABLE t_candidate_answer(
	id serial,
	essay_answer TEXT,
	id_question int NOT NULL,
	id_question_option int,
	candidate_assign_id int NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_candidate_answer ADD CONSTRAINT id_candidate_answer_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_candidate_answer ADD CONSTRAINT id_candidate_answer_question_fk
	FOREIGN KEY(id_question)
	REFERENCES t_question(id);

ALTER TABLE t_candidate_answer ADD CONSTRAINT id_candidate_answer_pg_fk
	FOREIGN KEY(id_question_option)
	REFERENCES t_question_option(id);

ALTER TABLE t_candidate_answer ADD CONSTRAINT id_candidate_answer_candidate_assign_fk
	FOREIGN KEY(candidate_assign_id)
	REFERENCES t_candidate_assign(id);

CREATE TABLE t_review(
	id serial,
	id_reviewer int NOT NULL,
	id_candidate int NOT NULL,
	id_status int,
	id_result int,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_review ADD CONSTRAINT id_review_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_review ADD CONSTRAINT id_review_reviewer_fk
	FOREIGN KEY(id_reviewer)
	REFERENCES t_user(id);

ALTER TABLE t_review ADD CONSTRAINT id_review_candidate_fk
	FOREIGN KEY(id_candidate)
	REFERENCES t_user(id);

ALTER TABLE t_review ADD CONSTRAINT id_review_status_fk
	FOREIGN KEY(id_status)
	REFERENCES t_progress_status(id);

ALTER TABLE t_review ADD CONSTRAINT id_review_result_fk
	FOREIGN KEY(id_result)
	REFERENCES t_result_status(id);


CREATE TABLE t_review_details(
	id serial,
	notes TEXT,
	score float,
	id_review int NOT NULL,
	candidate_assign_id int NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_review_details ADD CONSTRAINT id_review_details_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_review_details ADD CONSTRAINT id_review_details_review_fk
	FOREIGN KEY(id_review)
	REFERENCES t_review(id);

ALTER TABLE t_review_details ADD CONSTRAINT id_review_details_candidate_assign_fk
	FOREIGN KEY(candidate_assign_id)
	REFERENCES t_candidate_assign(id);


CREATE TABLE t_requirement_file(
	id serial,
	file_id int NOT NULL,
	type_id int NOT NULL,
	candidate_id int NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_requirement_file ADD CONSTRAINT id_requirement_file_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_requirement_file ADD CONSTRAINT id_requirement_file_file_fk
	FOREIGN KEY(file_id)
	REFERENCES t_file(id);

ALTER TABLE t_requirement_file ADD CONSTRAINT id_requirement_file_candidate_fk
	FOREIGN KEY(candidate_id)
	REFERENCES t_user(id);

ALTER TABLE t_requirement_file ADD CONSTRAINT id_requirement_file_type_fk
	FOREIGN KEY(type_id)
	REFERENCES t_file_type(id);

CREATE TABLE t_candidate_question(
	id serial,
	id_candidate int NOT NULL,
	id_question int NOT NULL,
	id_hr int NOT NULL,
	candidate_assign_id int NOT NULL,
	created_by int NOT NULL,
	created_at timestamp NOT NULL,
	updated_by int,
	updated_at timestamp,
	is_active boolean NOT NULL,
	ver int NOT NULL
);

-- Primary Key
ALTER TABLE t_candidate_question ADD CONSTRAINT id_candidate_question_pk
	PRIMARY KEY(id);

-- Foreign Key
ALTER TABLE t_candidate_question ADD CONSTRAINT id_candidate_questions_fk
	FOREIGN KEY(id_question)
	REFERENCES t_question(id);

ALTER TABLE t_candidate_question ADD CONSTRAINT id_candidate_candidate_fk
	FOREIGN KEY(id_candidate)
	REFERENCES t_user(id);

ALTER TABLE t_candidate_question ADD CONSTRAINT id_candidate_hr_fk
	FOREIGN KEY(id_hr)
	REFERENCES t_user(id);


ALTER TABLE t_candidate_question ADD CONSTRAINT id_candidate_candidate_assign_fk
	FOREIGN KEY(candidate_assign_id)
	REFERENCES t_candidate_assign(id);