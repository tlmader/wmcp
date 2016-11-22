--job_profile inserts
insert into job_profile (jp_code, jp_title, description, avg_pay) values (001, 'Cloud Developer', 'Job description:', 111883.60);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (002, 'Operating System Devloper', 'Job description:', 122764.62);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (003, 'Big Data Analyst', 'Job description:', 106175.93);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (004, 'Industrial Internet Analyst', 'Job description:', 115144.97);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (005, 'Game Dev', 'Job description:', 65140.53);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (006, 'Network Admin', 'Job description:', 95495.72);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (007, 'Lead Developer', 'Job description:', 161774.72);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (008,  'Information Security Analyst', 'Job description:', 134456.42);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (009, 'Database Admin', 'Job description:', 148715.26);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (010, 'Front End Dev', 'Job description:', 129989.09);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (011, 'Back End Dev', 'Job description:', 64294.70);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (012, 'Lead Architect', 'Job description:', 139430.06);
insert into job_profile (jp_code, jp_title, description, avg_pay) values (013, 'Special', 'Job description:', 209430.06);
--knowledge_skill inserts
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (1, 'Java', 'Knowledge in the Java programming language', 'beginner');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (2, 'SQL', 'Knowledge in the development of database queries', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (3, 'Amazon Web Services', 'Knowledge in services such as S3', 'advanced');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (4, 'CRUD', 'Knowledge in CRUD', 'beginner');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (5, 'RESTful Services', 'Knowledge in REST services', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (6, 'C', 'Competency in C programming language', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (7, 'C++', 'Competency in C++ programming language', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (8, 'Application Architecture', 'Knowledge in application structure', 'advanced');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (9, 'Server Administration', 'Knowledge in server administration', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (10, 'Assembly', 'Competency in Assembler language', 'advanced');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (11, 'HTML', 'Knowledge in HTML', 'beginner');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (12, 'Angular', 'Experience in Angular', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (13, 'Jquery', 'Experience in Jquery', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (14, 'CSS', 'Skill in CSS', 'beginner');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (15, 'System Security', 'Knowledge in system security', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (16, 'Test Driven Development', 'Competency in test driven development', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (17, 'Leadership', 'Skilled in the area of leading a team', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (18, 'C#/.NET Framework', 'Knowledge in microsofts frameworks', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (19, 'Server Architecture', 'Skilled in the area of server organization', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (20, 'Cloud Development', 'Knowledge in cloud development', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (21, 'Spring Framework', 'Skilled in the Spring Framework', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (22, 'Large Data Manipulation', 'Knowledge in Big Data movement', 'medium');
insert into knowledge_skill (ks_code, ks_title, description, s_level) values (23, 'Debugging', 'Knowledge in debugging', 'beginner');
--required_skill inserts
insert into required_skill (jp_code, ks_code) values (001, 20);
insert into required_skill (jp_code, ks_code) values (002, 6);
insert into required_skill (jp_code, ks_code) values (002, 7);
insert into required_skill (jp_code, ks_code) values (002, 8);
insert into required_skill (jp_code, ks_code) values (002, 10);
insert into required_skill (jp_code, ks_code) values (003, 3);
insert into required_skill (jp_code, ks_code) values (003, 22);
insert into required_skill (jp_code, ks_code) values (004, 3);
insert into required_skill (jp_code, ks_code) values (004, 20);
insert into required_skill (jp_code, ks_code) values (004, 8);
insert into required_skill (jp_code, ks_code) values (004, 5);
insert into required_skill (jp_code, ks_code) values (005, 6);
insert into required_skill (jp_code, ks_code) values (005, 7);
insert into required_skill (jp_code, ks_code) values (006, 3);
insert into required_skill (jp_code, ks_code) values (006, 4);
insert into required_skill (jp_code, ks_code) values (006, 5);
insert into required_skill (jp_code, ks_code) values (006, 15);
insert into required_skill (jp_code, ks_code) values (006, 19);
insert into required_skill (jp_code, ks_code) values (007, 1);
insert into required_skill (jp_code, ks_code) values (007, 2);
insert into required_skill (jp_code, ks_code) values (007, 3);
insert into required_skill (jp_code, ks_code) values (007, 4);
insert into required_skill (jp_code, ks_code) values (007, 5);
insert into required_skill (jp_code, ks_code) values (007, 8);
insert into required_skill (jp_code, ks_code) values (007, 17);
insert into required_skill (jp_code, ks_code) values (007, 21);
insert into required_skill (jp_code, ks_code) values (007, 23);
insert into required_skill (jp_code, ks_code) values (008, 8);
insert into required_skill (jp_code, ks_code) values (008, 9);
insert into required_skill (jp_code, ks_code) values (008, 15);
insert into required_skill (jp_code, ks_code) values (008, 19);
insert into required_skill (jp_code, ks_code) values (009, 2);
insert into required_skill (jp_code, ks_code) values (009, 4);
insert into required_skill (jp_code, ks_code) values (009, 17);
insert into required_skill (jp_code, ks_code) values (009, 22);
insert into required_skill (jp_code, ks_code) values (010, 11);
insert into required_skill (jp_code, ks_code) values (010, 12);
insert into required_skill (jp_code, ks_code) values (010, 13);
insert into required_skill (jp_code, ks_code) values (010, 14);
insert into required_skill (jp_code, ks_code) values (011, 1);
insert into required_skill (jp_code, ks_code) values (011, 2);
insert into required_skill (jp_code, ks_code) values (011, 4);
insert into required_skill (jp_code, ks_code) values (011, 5);
insert into required_skill (jp_code, ks_code) values (011, 23);
insert into required_skill (jp_code, ks_code) values (012, 3);
insert into required_skill (jp_code, ks_code) values (012, 4);
insert into required_skill (jp_code, ks_code) values (012, 8);
insert into required_skill (jp_code, ks_code) values (012, 15);
insert into required_skill (jp_code, ks_code) values (012, 19);
insert into required_skill (jp_code, ks_code) values (012, 21);
insert into required_skill (jp_code, ks_code) values (013, 17);
--company
insert into company (comp_id, comp_name, address, primary_sector, website) values (1, 'Vague Electric', '52512 Red Cloud Lane', 'Electric', 'www.Vauge.com');
insert into company (comp_id, comp_name, address, primary_sector, website) values (2, 'Tosh Incorporated', '9 Hollow Ridge Way', 'Bussiness', 'www.Tosh.com');
insert into company (comp_id, comp_name, address, primary_sector, website) values (3, 'Mader Machinery', '4733 Dovetail Center', 'Machinery', 'www.MaderMachinery.com');
insert into company (comp_id, comp_name, address, primary_sector, website) values (4, 'Eaton Foods', '79 Lake View Court', 'Food', 'www.EatonFoods.come');
insert into company (comp_id, comp_name, address, primary_sector, website) values (5, 'The Government', '935 Birchwood Point', 'Public Sector', 'www.Government.gov');
insert into company (comp_id, comp_name, address, primary_sector, website) values (6, 'The Company', '82 Del Mar Circle', 'Business Sector', 'www.TheCompany.com');
insert into company (comp_id, comp_name, address, primary_sector, website) values (7, 'Putin Power Industrial', '45 Lakeland Point', 'Power', 'www.PPI.come');
insert into company (comp_id, comp_name, address, primary_sector, website) values (8, 'Joshua Junction', '77863 Macpherson Avenue', 'Transportation', 'www.JoshuaJunct.com');
insert into company (comp_id, comp_name, address, primary_sector, website) values (9, 'Ted Technology', '21975 Alpine Lane', 'Technology', 'www.TedTech.com');
insert into company (comp_id, comp_name, address, primary_sector, website) values (10, 'Jed Industrial', '924 Maryland Trail', 'Industrial Technology', 'www.JedInd.com');
--job
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (700, 001, 1, 'Full Time', 106693.07, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (701, 002, 1, 'Full Time', 120500.45, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (702, 012, 1, 'Full Time', 157280.82, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (703, 005, 2, 'Full Time', 70282.05, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (704, 007, 2, 'Full Time', 135106.98, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (705, 006, 3, 'Full Time', 84026.89, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (706, 008, 3, 'Full Time', 134098.71, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (707, 003, 4, 'Full Time', 90030.80, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (708, 012, 4, 'Full Time', 150664.88, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (709, 006, 4, 'Full Time', 95768.24, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (710, 010, 5, 'Full Time', 60401.49, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (711, 011, 5, 'Full Time', 68982.19, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (712, 006, 5, 'Full Time', 128982.16, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (713, 012, 5, 'Full Time', 87703.18, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (714, 011, 5, 'Full Time', 68982.17, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (715, 001, 6, 'Full Time', 40.00, 'wage');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (716, 008, 7, 'Full Time', 108996.74, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (717, 004, 7, 'Full Time', 157060.86, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (718, 004, 8, 'Full Time', 91365.75, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (719, 003, 8, 'Full Time', 144712.10, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (720, 004, 8, 'Full Time', 91365.75, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (721, 003, 8, 'Full Time', 144712.10, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (722, 004, 9, 'Full Time', 101365.75, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (723, 005, 9, 'Full Time', 81365.75, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (724, 005, 9, 'Full Time', 81365.75, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (725, 007, 9, 'Full Time', 144712.10, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (726, 011, 9, 'Full Time', 70365.75, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (727, 012, 9, 'Full Time', 75712.10, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (728, 011, 9, 'Full Time', 70365.75, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (729, 012, 9, 'Full Time', 75712.10, 'salary');
insert into Job (job_code, jp_code, comp_id, type, pay_rate, pay_type) values (730, 013, 5, 'Full Time', 200000.00, 'salary');
--person
insert into person (per_id, person_name, address, phone_num, email, gender) values (1, 'Mary Mills', '523 Fremont Place', '62-(824)697-2977', 'mmills0@yandex.ru', 'Female');
insert into person (per_id, person_name, address, phone_num, email, gender) values (2, 'Justin Ryan', '061 Nelson Road', '62-(684)953-6514', 'jryan1@samsung.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (3, 'Michael Fisher', '6325 Havey Road', '55-(420)700-6395', 'mfisher2@techcrunch.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (4, 'Michael Velez', '4 Golf View Place', '86-(258)135-8369', 'velez@gmail.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (5, 'Martin Ross', '859 Southridge Road', '504-(705)477-5676', 'mross4@eepurl.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (6, 'Gerald Hall', '1 Manley Alley', '86-(941)467-8953', 'ghall5@foxnews.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (7, 'Roger Elliott', '2 Schurz Trail', '54-(417)570-7461', 'relliott6@reference.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (8, 'Carol Morrison', '86475 Melody Hill', '1-(281)995-0144', 'cmorrison7@oakley.com', 'Female');
insert into person (per_id, person_name, address, phone_num, email, gender) values (9, 'Andrew Turner', '2288 Merchant Court', '383-(937)951-5382', 'aturner8@amazon.co.uk', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (10, 'Jason Little', '4 Sheridan Way', '670-(472)889-7477', 'jlittle9@cocolog-nifty.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (11, 'Wayne Coleman', '37695 Center Pass', '7-(584)322-3490', 'wcolemana@wp.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (12, 'Carl Crawford', '42 Ruskin Park', '86-(780)355-8657', 'ccrawfordb@linkedin.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (13, 'Craig Hall', '81 Westerfield Pass', '64-(878)699-1993', 'challc@fastcompany.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (14, 'John Ramos', '5686 Loeprich Street', '86-(937)265-2469', 'jramosd@odnoklassniki.ru', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (15, 'Jason Stevens', '46755 Esch Terrace', '62-(637)726-7076', 'jstevense@jiathis.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (16, 'Nicole Miller', '3 Melody Hill', '380-(217)203-1922', 'nmillerf@auda.org.au', 'Female');
insert into person (per_id, person_name, address, phone_num, email, gender) values (17, 'Nicole Berry', '90 Old Gate Plaza', '63-(244)731-8963', 'nberryg@jigsy.com', 'Female');
insert into person (per_id, person_name, address, phone_num, email, gender) values (18, 'Paul Cox', '0403 Novick Court', '351-(525)203-6026', 'pcoxh@goo.ne.jp', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (19, 'Steven Mitchell', '10 Scoville Street', '86-(395)182-1749', 'smitchelli@prnewswire.com', 'Male');
insert into person (per_id, person_name, address, phone_num, email, gender) values (20, 'Eric Andrews', '18424 Rowland Trail', '86-(282)647-6173', 'eandrewsj@feedburner.com', 'Male');
--works
insert into works (per_id, job_code, start_date, end_date) values (1, 700, TO_DATE('2014-05-27','YYYY-MM-DD'), NULL);
insert into works (per_id, job_code, start_date, end_date) values (2, 701, TO_DATE('2014-05-06','YYYY-MM-DD'), NULL);
insert into works (per_id, job_code, start_date, end_date) values (3, 702, TO_DATE('2014-11-24','YYYY-MM-DD'), SYSDATE);
insert into works (per_id, job_code, start_date, end_date) values (4, 705, TO_DATE('2010-10-28','YYYY-MM-DD'), TO_DATE('2015-9-30','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (4, 704, TO_DATE('2014-10-28','YYYY-MM-DD'), NULL);
insert into works (per_id, job_code, start_date, end_date) values (4, 703, TO_DATE('2014-10-28','YYYY-MM-DD'), TO_DATE('2015-10-11','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (4, 730, TO_DATE('2004-10-28','YYYY-MM-DD'), TO_DATE('2010-10-11','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (5, 704, TO_DATE('2014-07-02','YYYY-MM-DD'), NULL);
insert into works (per_id, job_code, start_date, end_date) values (6, 705, TO_DATE('2014-07-08','YYYY-MM-DD'), NULL);
insert into works (per_id, job_code, start_date, end_date) values (7, 706, TO_DATE('2014-09-11','YYYY-MM-DD'), TO_DATE('2015-12-25','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (8, 707, TO_DATE('2014-02-26','YYYY-MM-DD'), TO_DATE('2016-07-19','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (9, 708, TO_DATE('2014-12-24','YYYY-MM-DD'), TO_DATE('2016-07-14','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (10, 709, TO_DATE('2013-05-06','YYYY-MM-DD'), NULL);
insert into works (per_id, job_code, start_date, end_date) values (11, 710, TO_DATE('2010-09-29','YYYY-MM-DD'), TO_DATE('2016-04-03','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (12, 711, TO_DATE('2011-09-01','YYYY-MM-DD'), TO_DATE('2016-03-22','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (13, 712, TO_DATE('2014-01-06','YYYY-MM-DD'), TO_DATE('2015-12-15','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (14, 713, TO_DATE('2011-08-22','YYYY-MM-DD'), TO_DATE('2016-04-04','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (15, 714, TO_DATE('2011-07-11','YYYY-MM-DD'), NULL);
insert into works (per_id, job_code, start_date, end_date) values (16, 715, TO_DATE('2011-02-01','YYYY-MM-DD'), TO_DATE('2015-11-07','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (17, 716, TO_DATE('2011-12-29','YYYY-MM-DD'), TO_DATE('2016-03-21','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (18, 717, TO_DATE('2011-10-17','YYYY-MM-DD'), TO_DATE('2016-08-22','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (19, 718, TO_DATE('2013-11-02','YYYY-MM-DD'), TO_DATE('2016-01-25','YYYY-MM-DD'));
insert into works (per_id, job_code, start_date, end_date) values (20, 719, TO_DATE('2012-01-08','YYYY-MM-DD'), TO_DATE('2016-08-07','YYYY-MM-DD'));
--specialty
insert into specialty (spec_id, spec_title) values (1, 'Electrical Technology');
insert into specialty (spec_id, spec_title) values (2, 'Incorporated Products');
insert into specialty (spec_id, spec_title) values (3, 'Computer Hardware');
insert into specialty (spec_id, spec_title) values (4, 'Food');
insert into specialty (spec_id, spec_title) values (5, 'Corruption');
insert into specialty (spec_id, spec_title) values (6, 'Logistics Service');
insert into specialty (spec_id, spec_title) values (7, 'Power');
insert into specialty (spec_id, spec_title) values (8, 'Construction and Transportation');
insert into specialty (spec_id, spec_title) values (9, 'Technology');
insert into specialty (spec_id, spec_title) values (10, 'Industrials');
--company_specialty 
insert into company_specialty (comp_id, spec_id) values (1, 1);
insert into company_specialty (comp_id, spec_id) values (2, 2);
insert into company_specialty (comp_id, spec_id) values (3, 3);
insert into company_specialty (comp_id, spec_id) values (4, 4);
insert into company_specialty (comp_id, spec_id) values (5, 5);
insert into company_specialty (comp_id, spec_id) values (6, 6);
insert into company_specialty (comp_id, spec_id) values (7, 7);
insert into company_specialty (comp_id, spec_id) values (8, 8);
insert into company_specialty (comp_id, spec_id) values (9, 9);
insert into company_specialty (comp_id, spec_id) values (10, 10);
--course
insert into course (c_code, c_title, c_level, description, status, retail_price) values (1, 'Java Certification', 'medium', 'description:', 'active', 1200.00);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (2, 'Database SQL', 'medium', 'description:', 'active', 950.58);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (3, 'Amazon Web Services Certification', 'advanced', 'description:', 'active', 1185.50);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (4, 'API and CRUD', 'medium', 'description:', 'expired', 1085.99);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (5, 'REST Practices', 'advanced', 'description:', 'expired', 1852.06);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (6, 'C Certification', 'medium', 'description:', 'expired', 1330.01);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (7, 'C++ Certification', 'medium', 'description:', 'expired', 1212.82);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (8, 'Architecture Desgin for Applications', 'advanced', 'description:', 'active', 1373.89);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (9, 'Introduction into Server Administration', 'medium', 'description:', 'expired', 1155.67);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (10, 'Assembly', 'medium', 'description:', 'expired', 1334.04);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (11, 'HTML and CSS Basics', 'beginner', 'description:', 'active', 800.74);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (12, 'Javascript Certification', 'beginner', 'description:', 'active', 750.23);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (13, 'Angular and JQuery', 'beginner', 'description:', 'expired', 1533.69);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (14, 'Web Design Basics', 'medium', 'description:', 'expired',533.81);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (15, 'System Security Overview', 'medium', 'description:', 'active',618.64);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (16, 'Test Development Certification', 'medium', 'description:', 'expired', 1471.51);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (17, 'Leadership Skills', 'beginner', 'description:', 'expired', 576.03);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (18, 'C#/.NET Certification', 'beginner', 'description:', 'expired', 1670.17);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (19, 'Server Architecture Overview', 'medium', 'description:', 'active', 1438.16);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (20, 'Industrial Cloud Development', 'advanced', 'description:', 'active', 1449.24);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (21, 'Spring Framework Certification', 'medium', 'description:', 'expired', 1670.17);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (22, 'Big Data', 'medium', 'description:', 'active', 1538.16);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (23, 'Essentials in Debugging', 'beginner', 'description:', 'active', 500.24);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (24, 'Back End Basics', 'medium', 'description:', 'active', 1170.17);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (25, 'Front End Basics', 'medium', 'description:', 'active', 1138.16);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (26, 'Networking Skills', 'beginner', 'description:', 'active', 707.24);
insert into course (c_code, c_title, c_level, description, status, retail_price) values (27, 'C++ and Architecture', 'advanced', 'description:', 'active', 1200.58);
--section
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (1, 1, TO_DATE('2016-12-09','YYYY-MM-DD'), 2016, 'Guru Nanak Dev University', 'online-sync',1355.67);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (2, 2, TO_DATE('2016-11-09','YYYY-MM-DD'), 2016, 'University of Udine', 'online-sync',1834.04);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (3, 3, TO_DATE('2016-10-09','YYYY-MM-DD'), 2016, 'Rajamangala University of Technology, Lanna Nan', 'online-sync', 618.64);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (4, 4, TO_DATE('2016-9-09','YYYY-MM-DD'), 2016, 'Chinese University of Hong Kong', 'correspondence', 533.81);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (5, 5, TO_DATE('2016-8-09','YYYY-MM-DD'), 2016, 'University of Connecticut at Hartford', 'online-selfpaced', 1461.74);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (6, 6, TO_DATE('2016-7-09','YYYY-MM-DD'), 2016, 'Bharathidasan University', 'online-selfpaced', 1533.69);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (7, 7, TO_DATE('2016-6-09','YYYY-MM-DD'), 2016, 'Westminster College New Wilmington', 'classroom', 1852.06);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (8, 8, TO_DATE('2016-5-09','YYYY-MM-DD'), 2016, 'University of California, San Diego', 'online-sync', 618.64);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (9, 9, TO_DATE('2016-4-09','YYYY-MM-DD'), 2016, 'National Taiwan Ocean University', 'online-sync', 1179.23);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (10, 10, TO_DATE('2016-3-09','YYYY-MM-DD'), 2016, 'Universidad Técnica de Cotopaxi', 'online-selfpaced', 1212.82);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (11, 11, TO_DATE('2016-2-09','YYYY-MM-DD'), 2016, 'University of California, San Diego', 'online-sync', 618.64);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (12, 12, TO_DATE('2016-1-09','YYYY-MM-DD'), 2016, 'National Taiwan Ocean University', 'online-sync', 1179.23);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (13, 13, TO_DATE('2016-8-09','YYYY-MM-DD'), 2016, 'Universidad Técnica de Cotopaxi', 'online-selfpaced', 1212.82);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (14, 14, TO_DATE('2016-5-09','YYYY-MM-DD'), 2016, 'Guru Nanak Dev University', 'online-sync',1355.67);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (15, 15, TO_DATE('2016-4-09','YYYY-MM-DD'), 2016, 'University of Udine', 'online-sync', 1834.04);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (16, 16, TO_DATE('2016-5-09','YYYY-MM-DD'), 2016, 'Rajamangala University of Technology, Lanna Nan', 'online-sync', 618.64);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (17, 17, TO_DATE('2016-7-09','YYYY-MM-DD'), 2016, 'Chinese University of Hong Kong', 'correspondence', 533.81);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (18, 18, TO_DATE('2016-5-09','YYYY-MM-DD'), 2016, 'University of Connecticut at Hartford', 'online-selfpaced', 1461.74);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (19, 19, TO_DATE('2016-4-09','YYYY-MM-DD'), 2016, 'Bharathidasan University', 'online-selfpaced', 1533.69);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (20, 20, TO_DATE('2016-4-09','YYYY-MM-DD'), 2016, 'Westminster College New Wilmington', 'classroom', 1852.06);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (21, 21, TO_DATE('2016-4-09','YYYY-MM-DD'), 2016, 'University of California, San Diego', 'online-sync', 618.64);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (22, 22, TO_DATE('2016-3-09','YYYY-MM-DD'), 2016, 'National Taiwan Ocean University', 'online-sync', 1179.23);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (23, 23, TO_DATE('2016-7-09','YYYY-MM-DD'), 2016, 'Universidad Técnica de Cotopaxi', 'online-selfpaced', 1212.82);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (24, 24, TO_DATE('2016-11-09','YYYY-MM-DD'), 2016, 'University of California, San Diego', 'online-sync', 1018.64);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (25, 25, TO_DATE('2016-11-09','YYYY-MM-DD'), 2016, 'National Taiwan Ocean University', 'online-sync', 1109.23);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (26, 26, TO_DATE('2016-11-09','YYYY-MM-DD'), 2016, 'Universidad Técnica de Cotopaxi', 'online-selfpaced', 1212.82);
insert into section (sec_no, c_code, complete_date, sec_year, offered_by, sec_format, price) values (27, 27, TO_DATE('2016-12-09','YYYY-MM-DD'), 2016, 'University of New Orleans', 'online-selfpaced', 1500.82);
--knows
insert into knows (per_id, ks_code) values (1, 20);
insert into knows (per_id, ks_code) values (2, 6);
insert into knows (per_id, ks_code) values (2, 7);
insert into knows (per_id, ks_code) values (3, 7);
insert into knows (per_id, ks_code) values (3, 3);
insert into knows (per_id, ks_code) values (4, 2);
insert into knows (per_id, ks_code) values (4, 4);
insert into knows (per_id, ks_code) values (4, 16);
insert into knows (per_id, ks_code) values (4, 17);
insert into knows (per_id, ks_code) values (5, 5);
insert into knows (per_id, ks_code) values (6, 6);
insert into knows (per_id, ks_code) values (7, 7);
insert into knows (per_id, ks_code) values (8, 8);
insert into knows (per_id, ks_code) values (9, 9);
insert into knows (per_id, ks_code) values (10, 10);
insert into knows (per_id, ks_code) values (11, 11);
insert into knows (per_id, ks_code) values (12, 12);
insert into knows (per_id, ks_code) values (13, 13);
insert into knows (per_id, ks_code) values (14, 14);
insert into knows (per_id, ks_code) values (15, 15);
insert into knows (per_id, ks_code) values (16, 16);
insert into knows (per_id, ks_code) values (17, 9);
insert into knows (per_id, ks_code) values (17, 15);
insert into knows (per_id, ks_code) values (17, 17);
insert into knows (per_id, ks_code) values (18, 18);
insert into knows (per_id, ks_code) values (19, 3);
insert into knows (per_id, ks_code) values (19, 4);
insert into knows (per_id, ks_code) values (19, 5);
insert into knows (per_id, ks_code) values (19, 8);
insert into knows (per_id, ks_code) values (19, 15);
insert into knows (per_id, ks_code) values (19, 19);
insert into knows (per_id, ks_code) values (20, 3);
insert into knows (per_id, ks_code) values (20, 20);
--teaches
insert into teaches (c_code, ks_code) values (1, 1);
insert into teaches (c_code, ks_code) values (2, 2);
insert into teaches (c_code, ks_code) values (2, 4);
insert into teaches (c_code, ks_code) values (2, 17);
insert into teaches (c_code, ks_code) values (2, 22);
insert into teaches (c_code, ks_code) values (3, 3);
insert into teaches (c_code, ks_code) values (4, 4);
insert into teaches (c_code, ks_code) values (5, 5);
insert into teaches (c_code, ks_code) values (6, 6);
insert into teaches (c_code, ks_code) values (7, 7);
insert into teaches (c_code, ks_code) values (8, 8);
insert into teaches (c_code, ks_code) values (9, 9);
insert into teaches (c_code, ks_code) values (10, 10);
insert into teaches (c_code, ks_code) values (11, 11);
insert into teaches (c_code, ks_code) values (11, 14);
insert into teaches (c_code, ks_code) values (12, 12);
insert into teaches (c_code, ks_code) values (12, 13);
insert into teaches (c_code, ks_code) values (13, 13);
insert into teaches (c_code, ks_code) values (14, 14);
insert into teaches (c_code, ks_code) values (15, 15);
insert into teaches (c_code, ks_code) values (16, 16);
insert into teaches (c_code, ks_code) values (17, 17);
insert into teaches (c_code, ks_code) values (18, 18);
insert into teaches (c_code, ks_code) values (19, 19);
insert into teaches (c_code, ks_code) values (20, 20);
insert into teaches (c_code, ks_code) values (21, 21);
insert into teaches (c_code, ks_code) values (22, 22);
insert into teaches (c_code, ks_code) values (23, 23);
insert into teaches (c_code, ks_code) values (24, 1);
insert into teaches (c_code, ks_code) values (24, 2);
insert into teaches (c_code, ks_code) values (24, 23);
insert into teaches (c_code, ks_code) values (25, 11);
insert into teaches (c_code, ks_code) values (25, 12);
insert into teaches (c_code, ks_code) values (25, 14);
insert into teaches (c_code, ks_code) values (26, 5);
insert into teaches (c_code, ks_code) values (26, 9);
insert into teaches (c_code, ks_code) values (26, 19);
insert into teaches (c_code, ks_code) values (27, 7);
insert into teaches (c_code, ks_code) values (27, 8);






