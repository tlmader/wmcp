CREATE TABLE job_profile
(
  jp_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  jp_title VARCHAR2(100) NOT NULL,
  description VARCHAR2(100),
  avg_pay DECIMAL(10,2)
  
);
CREATE TABLE knowledge_skill
(
  ks_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  ks_title VARCHAR2(100) NOT NULL,
  description VARCHAR2(100),
  s_level VARCHAR(10),
  CHECK(s_level IN('beginner','medium','advanced'))
);
CREATE TABLE required_skill
(
  jp_code VARCHAR2(10) NOT NULL,
  ks_code VARCHAR2(10) NOT NULL,
  CONSTRAINT pk_required_skill PRIMARY KEY (jp_code, ks_code),
  CONSTRAINT fk_rs_jp FOREIGN KEY (jp_code)
    REFERENCES job_profile(jp_code),
  CONSTRAINT fk_rs_ks FOREIGN KEY (ks_code)
    REFERENCES knowledge_skill(ks_code)
);
CREATE TABLE company
(
  comp_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  comp_name VARCHAR2(100) NOT NULL,
  address VARCHAR2(100),
  primary_sector VARCHAR2(100),
  website VARCHAR2(100)
);
CREATE TABLE job
(
  job_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  jp_code VARCHAR2(10) NOT NULL,
  comp_id VARCHAR2(10) NOT NULL,
  type VARCHAR2(100) NOT NULL,
  pay_rate DECIMAL(10,2),
  pay_type VARCHAR2(10),
  CONSTRAINT fk_job_comp FOREIGN KEY (comp_id)
    REFERENCES company(comp_id),
  CONSTRAINT fk_job_jp FOREIGN KEY (jp_code)
    REFERENCES job_profile(jp_code),
  CHECK(type IN('Full Time','Part Time')),
  CHECK(pay_type IN('wage','salary'))
);
CREATE TABLE person
(
  per_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  person_name VARCHAR2(100) NOT NULL,
  address VARCHAR2(100),
  phone_num VARCHAR2(20) NOT NULL,
  email VARCHAR2(100),
  gender VARCHAR2(20),
  CHECK(gender IN('Male','Female'))
);
CREATE TABLE works
(
  per_id VARCHAR2(10) NOT NULL,
  job_code VARCHAR2(10) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE,
  CONSTRAINT pk_works PRIMARY KEY (per_id, job_code),
  CONSTRAINT fk_works_per FOREIGN KEY (per_id)
    REFERENCES person(per_id),
  CONSTRAINT fk_works_job FOREIGN KEY (job_code)
    REFERENCES job(job_code)
);
CREATE TABLE specialty
(
  spec_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  spec_title VARCHAR2(100) NOT NULL
);
CREATE TABLE company_specialty
(
  comp_id VARCHAR2(10) NOT NULL,
  spec_id VARCHAR2(10) NOT NULL,
  CONSTRAINT pk_company_specialty PRIMARY KEY (comp_id, spec_id),
  CONSTRAINT fk_cs_comp FOREIGN KEY (comp_id)
    REFERENCES company(comp_id),
  CONSTRAINT fk_cs_spec FOREIGN KEY (spec_id)
    REFERENCES specialty(spec_id)
);
CREATE TABLE course
(
  c_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  c_title VARCHAR2(100) NOT NULL,
  c_level VARCHAR(20),
  description VARCHAR2(100),
  status VARCHAR2(20),
  retail_price VARCHAR2(38),
  CHECK(c_level IN('beginner', 'medium', 'advanced')),
  CHECK(status IN('active','expired'))
);
CREATE TABLE section
(
  c_code VARCHAR2(10) NOT NULL, 
  sec_no VARCHAR2(10) NOT NULL,
  sec_year NUMBER(4) NOT NULL,
  complete_date DATE,
  offered_by VARCHAR2(100),
  sec_format VARCHAR2(100),
  price DECIMAL(10,2),
  CONSTRAINT pk_section PRIMARY KEY (c_code, sec_no, sec_year),
  CONSTRAINT fk_sec_c FOREIGN KEY (c_code)
    REFERENCES course(c_code),
  CHECK (sec_format IN('classroom', 'online-sync', 'online-selfpaced', 'correspondence'))
);
CREATE TABLE takes
(
  per_id VARCHAR2(10) NOT NULL,
  c_code VARCHAR2(10) NOT NULL,
  sec_no VARCHAR2(10) NOT NULL,
  sec_year NUMBER(4) NOT NULL,
  CONSTRAINT pk_takes PRIMARY KEY (per_id, sec_no),
  CONSTRAINT fk_takes_per FOREIGN KEY (per_id)
    REFERENCES person(per_id),
  CONSTRAINT fk_takes_sec FOREIGN KEY (c_code, sec_no, sec_year)
    REFERENCES section(c_code, sec_no, sec_year)
);
CREATE TABLE knows
(
  per_id VARCHAR2(10) NOT NULL,
  c_code VARCHAR2(10) NOT NULL,
  ks_code VARCHAR2(10) NOT NULL,
  CONSTRAINT pk_knows PRIMARY KEY (per_id, c_code, ks_code),
   CONSTRAINT fk_knows_per FOREIGN KEY (per_id)
    REFERENCES person(per_id),
   CONSTRAINT fk_knows_c FOREIGN KEY (c_code)
    REFERENCES course(c_code),
  CONSTRAINT fk_knows_ks FOREIGN KEY (ks_code)
    REFERENCES knowledge_skill(ks_code)
);
CREATE TABLE teaches
(
  c_code VARCHAR2(10) NOT NULL,
  ks_code VARCHAR2(10) NOT NULL,
  CONSTRAINT pk_teaches PRIMARY KEY (c_code, ks_code),
  CONSTRAINT fk_teaches_c FOREIGN KEY (c_code)
    REFERENCES course(c_code),
  CONSTRAINT fk_teaches_ks FOREIGN KEY (ks_code)
    REFERENCES knowledge_skill(ks_code)
);

