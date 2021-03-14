-- public.candidates definition

-- Drop table

-- DROP TABLE public.candidates;

create TABLE public.candidates (
	id UUID NOT NULL,
	"name" varchar(255) NOT NULL,
	birthday varchar(255) NOT NULL,
	gender varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	address varchar(255) NULL,
	linkedin varchar(255) NULL,
	phone_number varchar(255) NULL,
	CONSTRAINT candidates_pkey PRIMARY KEY (id)
);


-- public.job_offers definition

-- Drop table

-- DROP TABLE public.job_offers;

create TABLE public.job_offers (
	id int8 NOT NULL,
	"name" date NOT NULL,
	description text NULL,
	start_date date NOT NULL,
	end_date date NOT NULL,
	CONSTRAINT job_offers_pkey PRIMARY KEY (id)
);


-- public.technologies definition

-- Drop table

-- DROP TABLE public.technologies;

create TABLE public.technologies (
	id int8 NOT NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT technologies_name_key UNIQUE (name),
	CONSTRAINT technologies_pkey PRIMARY KEY (id)
);


-- public.candidates_applications definition

-- Drop table

-- DROP TABLE public.candidates_applications;

create TABLE public.candidates_applications (
	job_offer_id int8 NOT NULL,
	candidate_id UUID NOT NULL,
	notes text NULL,
	availability_from date NOT NULL,
	CONSTRAINT candidates_applications_pkey PRIMARY KEY (job_offer_id, candidate_id),
	CONSTRAINT candidates_applications_fkey1 FOREIGN KEY (job_offer_id) REFERENCES job_offers(id),
	CONSTRAINT candidates_applications_fkey2 FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);


-- public.career_informations definition

-- Drop table

-- DROP TABLE public.career_informations;

create TABLE public.career_informations (
	id int8 NOT NULL,
	candidate_id UUID NOT NULL,
	school varchar(255) NULL,
	company varchar(255) NULL,
	description text NOT NULL,
	course varchar(255) NULL,
	notes text NULL,
	place varchar(255) NULL,
	start_date date NULL,
	end_date date NULL,
	CONSTRAINT career_informations_pkey PRIMARY KEY (id),
	CONSTRAINT career_informations_fkey1 FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);


-- public.cover_letters definition

-- Drop table

-- DROP TABLE public.cover_letters;

create TABLE public.cover_letters (
	job_offer_id int8 NOT NULL,
	candidate_id UUID NOT NULL,
	description text NOT NULL,
	"date" date NOT NULL,
	CONSTRAINT cover_letters_pkey PRIMARY KEY (job_offer_id, candidate_id),
	CONSTRAINT cover_letters_fkey1 FOREIGN KEY (job_offer_id) REFERENCES job_offers(id),
	CONSTRAINT cover_letters_fkey2 FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);


-- public.technologies_candidates definition

-- Drop table

-- DROP TABLE public.technologies_candidates;

create TABLE public.technologies_candidates (
	technology_id int8 NOT NULL,
	candidate_id UUID NOT NULL,
	career_information_id int8 NOT NULL,
	CONSTRAINT technologies_candidates_pkey PRIMARY KEY (technology_id, candidate_id, career_information_id),
	CONSTRAINT technologies_candidates_fkey1 FOREIGN KEY (technology_id) REFERENCES technologies(id),
	CONSTRAINT technologies_candidates_fkey2 FOREIGN KEY (candidate_id) REFERENCES candidates(id),
	CONSTRAINT technologies_candidates_fkey3 FOREIGN KEY (career_information_id) REFERENCES career_informations(id)
);