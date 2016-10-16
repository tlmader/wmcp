CREATE TABLE address
(
  address_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  street VARCHAR2(100) NOT NULL,
  locality VARCHAR2(100) NOT NULL,
  region VARCHAR2(100) NOT NULL,
  zip_code VARCHAR2(10) NOT NULL,
  country_code VARCHAR2(2) NOT NULL
);
CREATE TABLE person
(
  per_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  person_name VARCHAR2(100) NOT NULL,
  address_id VARCHAR2(10),
  email VARCHAR2(100),
  gender VARCHAR2(100),
  CONSTRAINT fk_per_address FOREIGN KEY (address_id)
    REFERENCES address(address_id)
);
CREATE TABLE phone
(
  per_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  phone_num VARCHAR2(15) NOT NULL,
  CONSTRAINT fk_phone_per FOREIGN KEY (per_id)
    REFERENCES person(per_id)
);
CREATE TABLE job_profile
(
  jp_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  title VARCHAR2(100) NOT NULL,
  description VARCHAR2(100),
  avg_pay NUMBER(20)
);
CREATE TABLE knowledge_skill
(
  ks_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  title VARCHAR2(100) NOT NULL,
  description VARCHAR2(100),
  s_level NUMBER(10)
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
  address_id VARCHAR2(10),
  primary_sector VARCHAR2(100),
  website VARCHAR2(100),
  CONSTRAINT fk_comp_address FOREIGN KEY (address_id)
    REFERENCES address(address_id)
);
CREATE TABLE job
(
  job_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  type VARCHAR2(100) NOT NULL,
  pay_rate NUMBER(20),
  pay_type NUMBER(20),
  comp_id VARCHAR2(10) NOT NULL,
  CONSTRAINT fk_job_comp FOREIGN KEY (comp_id)
    REFERENCES company(comp_id)
);
CREATE TABLE specialty
(
  spec_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  title VARCHAR2(100) NOT NULL
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
  title VARCHAR2(100) NOT NULL,
  c_level NUMBER(10),
  description VARCHAR2(100),
  status VARCHAR2(100),
  retail_price NUMBER(20)
);
CREATE TABLE section
(
  c_code VARCHAR2(10) NOT NULL,
  sec_no VARCHAR2(10) NOT NULL,
  complete_date DATE,
  sec_year NUMBER(4),
  offered_by VARCHAR2(100),
  sec_format VARCHAR2(100),
  price NUMBER(20),
  CONSTRAINT pk_section PRIMARY KEY (c_code, sec_no),
  CONSTRAINT fk_sec_c FOREIGN KEY (c_code)
    REFERENCES course(c_code)
);
