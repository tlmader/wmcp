BEGIN
   FOR cur_rec IN (SELECT object_name, object_type
                     FROM user_objects
                    WHERE object_type IN
                             ('TABLE',
                              'VIEW',
                              'PACKAGE',
                              'PROCEDURE',
                              'FUNCTION',
                              'SEQUENCE'
                             ))
   LOOP
      BEGIN
         IF cur_rec.object_type = 'TABLE'
         THEN
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '" CASCADE CONSTRAINTS';
         ELSE
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '"';
         END IF;
      EXCEPTION
         WHEN OTHERS
         THEN
            DBMS_OUTPUT.put_line (   'FAILED: DROP '
                                  || cur_rec.object_type
                                  || ' "'
                                  || cur_rec.object_name
                                  || '"'
                                 );
      END;
   END LOOP;
END;
/
CREATE TABLE job_profile
(
  jp_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  title VARCHAR2(100) NOT NULL,
  description VARCHAR2(100),
  avg_pay VARCHAR(10)
);
CREATE TABLE knowledge_skill
(
  ks_code VARCHAR2(10) NOT NULL PRIMARY KEY,
  title VARCHAR2(100) NOT NULL,
  description VARCHAR2(100),
  s_level VARCHAR(10)
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
  pay_rate VARCHAR(20),
  pay_type VARCHAR(10),
  CONSTRAINT fk_job_comp FOREIGN KEY (comp_id)
    REFERENCES company(comp_id),
  CONSTRAINT fk_job_jp FOREIGN KEY (jp_code)
    REFERENCES job_profile(jp_code)
);
CREATE TABLE person
(
  per_id VARCHAR2(10) NOT NULL PRIMARY KEY,
  job_code VARCHAR2(10) NOT NULL,
  person_name VARCHAR2(100) NOT NULL,
  address VARCHAR2(100),
  phone_num VARCHAR2(20) NOT NULL,
  email VARCHAR2(100),
  gender VARCHAR2(100),
  CONSTRAINT fk_per_id FOREIGN KEY (job_code)
    REFERENCES job(job_code)
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
  c_level VARCHAR(20),
  description VARCHAR2(100),
  status VARCHAR2(20),
  retail_price VARCHAR(100)
);
CREATE TABLE section
(
  sec_no VARCHAR2(10) NOT NULL PRIMARY KEY,
  c_code VARCHAR2(10) NOT NULL,
  complete_date DATE,
  sec_year NUMBER(4),
  offered_by VARCHAR2(100),
  sec_format VARCHAR2(100),
  price NUMBER(20),
  CONSTRAINT fk_sec_c FOREIGN KEY (c_code)
    REFERENCES course(c_code)
);
CREATE TABLE takes
(
  per_id VARCHAR2(10) NOT NULL,
  sec_no VARCHAR2(10) NOT NULL,
  CONSTRAINT pk_takes PRIMARY KEY (per_id, sec_no),
  CONSTRAINT fk_takes_per FOREIGN KEY (per_id)
    REFERENCES person(per_id),
  CONSTRAINT fk_takes_sec FOREIGN KEY (sec_no)
    REFERENCES section(sec_no)
);
CREATE TABLE knows
(
  per_id VARCHAR2(10) NOT NULL,
  ks_code VARCHAR2(10) NOT NULL,
  CONSTRAINT pk_knows PRIMARY KEY (per_id, ks_code),
  CONSTRAINT fk_knows_per FOREIGN KEY (per_id)
    REFERENCES person(per_id),
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
