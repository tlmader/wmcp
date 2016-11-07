-- 1. List a company's workers by names
SELECT person_name
  FROM person
 WHERE comp_id = '1';

-- 2. List a company’s staff by salary in descending order.
SELECT person_name, pay_rate
  FROM person
       INNER JOIN job
       ON person.job_code = job.job_code
 ORDER BY pay_rate DESC

-- 3. List companies’ labor cost (total salaries and wage rates by 1920 hours) in descending order.
SELECT *
  FROM (SELECT comp_name, SUM(pay_rate * 1920)
          FROM person
               INNER JOIN works
               ON person.per_id = works.per_id
               INNER JOIN job
               ON works.job_code = job.job_code
                  AND pay_type = 'wage'
               INNER JOIN company
               ON job.comp_id = company.comp_id
         GROUP BY comp_name
         UNION ALL
        SELECT comp_name, SUM(pay_rate * 1920 / 2080) -- Assume 2080 hrs/yr
          FROM person
               INNER JOIN works
               ON person.per_id = works.per_id
               INNER JOIN job
               ON works.job_code = job.job_code
                  AND pay_type = 'salary'
               INNER JOIN company
               ON job.comp_id = company.comp_id
         GROUP BY comp_name)
 ORDER BY pay_rate DESC;

-- 4. Find all the jobs a person is currently holding and worked in the past.
SELECT job_code, title
  FROM job_profile
       INNER JOIN job
       ON job_profile.jp_code = job.jp_code
       INNER JOIN works
       ON job.job_code = works.job_code
       INNER JOIN person
       ON works.per_id = person.per_id
          AND person_name = 'person_name';

-- 5. List a person’s knowledge/skills in a readable format.
SELECT title, description
  FROM knowledge_skill
       INNER JOIN knows
       ON knows.ks_code = knowledge_skill.ks_code
       INNER JOIN person
       ON knows.per_id = person.per_id
          AND person_name = 'person_name';

-- 6. List the skill gap of a worker between his/her job(s) and his/her skills.
SELECT job_code, jp_title, ks_title
  FROM job_profile
       INNER JOIN job
       ON job_profile.jp_code = job.jp_code
       INNER JOIN required_skill
       ON job_profile.jp_code = required_skill.jp_code
       INNER JOIN knowledge_skill
       ON required_skill.ks_code = knowledge_skill.ks_code
       INNER JOIN works
       ON job.job_code = works.job_code
       INNER JOIN person
       ON works.per_id = person.per_id
          AND person_name = 'person_name'
       LEFT JOIN knows
       ON works.per_id = knows.per_id
 WHERE knows.per_id IS NULL;

-- 7. List the required knowledge/skills of a job profile in a readable format.
SELECT ks_title
  FROM knowledge_skill
       INNER JOIN required_skill
       ON knowledge_skill.ks_code = required_skill.ks_code
       INNER JOIN job_profile
       ON required_skill.jp_code = job_profile.jp_code
          AND jp_code = 'jp_code';

-- 8. List a person’s missing knowledge/skills for a specific job in a readable format.
SELECT ks_title
  FROM knowledge_skill
       INNER JOIN required_skill
       ON knowledge_skill.ks_code = required_skill.ks_code
       INNER JOIN job
       ON required_skill.jp_code = job.jp_code
          AND jp_code = 'jp_code'
       INNER JOIN works
       ON job.job_code = works.job_code
       INNER JOIN person
       ON works.per_id = person.per_id
          AND person_name = 'person_name'
       LEFT JOIN knows
       ON works.per_id = knows.per_id
 WHERE knows.per_id IS NULL;

-- 9. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.
SELECT c_code, c_title
  FROM course
       INNER JOIN teaches
       ON course.c_code = teaches.c_code
       INNER JOIN required_skill
       ON teaches.ks_code = required_skill.ks_code
       INNER JOIN job
       ON required_skill.jp_code = job.jp_code
          AND jp_code = 'jp_code'
       INNER JOIN works
       ON job.job_code = works.job_code
       INNER JOIN person
       ON works.per_id = person.per_id
          AND person_name = 'person_name'
       LEFT JOIN knows
       ON works.per_id = knows.per_id
 WHERE knows.per_id IS NULL
 GROUP BY c_code
HAVING COUNT(*) = COUNT(DISTINCT ks_code);

-- 10. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the “quickest” solution for this worker. Show the course, section information and the completion date.
SELECT *
  FROM (SELECT c_code, c_title, sec_no, complete_date
          FROM course
               INNER JOIN section
               ON course.c_code = section.c_code
               INNER JOIN teaches
               ON course.c_code = teaches.c_code
               INNER JOIN required_skill
               ON teaches.ks_code = required_skill.ks_code
               INNER JOIN job
               ON required_skill.jp_code = job.jp_code
                  AND jp_code = 'jp_code'
               INNER JOIN works
               ON job.job_code = works.job_code
               INNER JOIN person
               ON works.per_id = person.per_id
                  AND person_name = 'person_name'
               LEFT JOIN knows
               ON works.per_id = knows.per_id
         WHERE knows.per_id IS NULL
           AND status = 'active'
         GROUP BY c_code
      HAVING COUNT(*) = COUNT(DISTINCT ks_code))
         ORDER BY complete_date)
 WHERE ROWNUM = 1;

-- 11. Find the cheapest course to make up one’s skill gap by showing the course to take and the cost (of the section price).
SELECT *
  FROM (SELECT c_code, c_title, price
          FROM course
               INNER JOIN section
               ON course.c_code = section.c_code
               INNER JOIN teaches
               ON course.c_code = teaches.c_code
               INNER JOIN required_skill
               ON teaches.ks_code = required_skill.ks_code
               INNER JOIN job
               ON required_skill.jp_code = job.jp_code
                  AND jp_code = 'jp_code'
               INNER JOIN works
               ON job.job_code = works.job_code
               INNER JOIN person
               ON works.per_id = person.per_id
                  AND person_name = 'person_name'
               LEFT JOIN knows
               ON works.per_id = knows.per_id
         WHERE knows.per_id IS NULL
           AND status = 'active'
         GROUP BY c_code
      HAVING COUNT(*) = COUNT(DISTINCT ks_code))
         ORDER BY price DESC)
 WHERE ROWNUM = 1;

-- 12. If query #9 returns nothing, then find the course sets that their combination covers all the missing knowledge/ skills for a person to pursue a specific job. The considered course sets will not include more than three courses. If multiple course sets are found, list the course sets (with their course IDs) in the order of the ascending order of the course sets’ total costs.
WITH possible_course
  AS (SELECT course.c_code AS c_code, c_title, required_skill.ks_code AS ks_code
        FROM course
             INNER JOIN teaches
             ON course.c_code = teaches.c_code
             INNER JOIN required_skill
             ON teaches.ks_code = required_skill.ks_code
                AND required_skill.jp_code = 'jp_code'
             INNER JOIN job
             ON required_skill.jp_code = job.jp_code
             INNER JOIN works
             ON job.job_code = works.job_code
             INNER JOIN person
             ON works.per_id = person.per_id
                AND person_name = 'person_name'
             LEFT JOIN knows
             ON works.per_id = knows.per_id
       WHERE knows.per_id IS NULL),
complete_course
  AS (SELECT c_code, c_title
        FROM possible_course
      HAVING COUNT(*) = COUNT(DISTINCT ks_code))
SELECT *
  FROM (SELECT c1.c_code AS c1_code, c2.c_code AS c2_code, NULL AS c3_code, SUM(price) AS total_price
          FROM possible_course c1
               INNER JOIN section
               ON c1.c_code = section.c_code
               INNER JOIN possible_course c2
               ON c1.c_code < c2.c_code
         GROUP BY c1.c_code, c2.c_code, NULL
        HAVING COUNT(*) = COUNT(DISTINCT c1.ks_code)
         UNION ALL
        SELECT c1.c_code AS c1_code, c2.c_code AS c2_code, c3.c_code AS c3_code, SUM(price) AS total_price
          FROM possible_course c1
               INNER JOIN section
               ON c1.c_code = section.c_code
               INNER JOIN possible_course c2
               ON c1.c_code < c2.c_code
               INNER JOIN possible_course c3
               ON c1.c_code < c3.c_code
         GROUP BY c1.c_code, c2.c_code, c3.c_code
        HAVING COUNT(*) = COUNT(DISTINCT c1.ks_code))
 ORDER BY total_price ASC;

-- 13. List all the job profiles that a person is qualified for.


-- 14. Find the job with the highest pay rate for a person according to his/her skill qualification.


-- 15. List all the names along with the emails of the persons who are qualified for a job profile.
SELECT person_name, email
  FROM person
       INNER JOIN knows
       ON person.per_id = knows.per_id
       INNER JOIN required_skill
       ON knows.ks_code = required_skill.ks_code
          AND jp_code = 'jp_code'
 GROUP BY person_name
HAVING COUNT(*) = COUNT(DISTINCT ks_code));

-- 16. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a “missing-one” list that lists people who miss only one skill for a specified job profile.
SELECT person_name, email
  FROM person
       INNER JOIN knows
       ON person.per_id = knows.per_id
       INNER JOIN required_skill
       ON knows.ks_code = required_skill.ks_code
          AND jp_code = 'jp_code'
 GROUP BY person_name
HAVING COUNT(*) = COUNT(DISTINCT ks_code) - 1);

-- 17. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.
SELECT ks_code, SUM(person_name)
  FROM (SELECT person_name, email
          FROM person
               INNER JOIN knows
               ON person.per_id = knows.per_id
               INNER JOIN required_skill
               ON knows.ks_code = required_skill.ks_code
                  AND jp_code = 'jp_code'
         GROUP BY person_name
        HAVING COUNT(*) = COUNT(DISTINCT ks_code) - 1)) missing_one
       INNER JOIN knows
       ON missing_one.person_name = knows.person_name
 GROUP BY person_name;

-- 18. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the “least number”.
SELECT distinct_ks_count - known_ks_count
  FROM (SELECT person_name, email, COUNT(ks_code) AS known_ks_count COUNT(DISTINCT ks_code) AS distinct_ks_count
          FROM person
               INNER JOIN knows
               ON person.per_id = knows.per_id
               INNER JOIN required_skill
               ON knows.ks_code = required_skill.ks_code
                  AND jp_code = 'jp_code'
         GROUP BY person_name
         ORDER BY COUNT(DISTINCT ks_code) DESC)
 WHERE ROWNUM = 1;

-- 19. For a specified job profile and a given small number k, make a “missing-k” list that lists the people’s IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills
WITH k AS 3
SELECT per_id
  FROM person
       INNER JOIN knows
       ON person.per_id = knows.per_id
       INNER JOIN required_skill
       ON knows.ks_code = required_skill.ks_code
          AND jp_code = 'jp_code'
 GROUP BY person_name
HAVING COUNT(DISTINCT ks_code) - COUNT(ks_code) < k
 ORDER BY COUNT(DISTINCT ks_code) - COUNT(ks_code) ASC;

-- 20. (BONUS) Given a job profile and its corresponding missing-k list specified in Question 19. Find every skill that is needed by at least one person in the given missing-k list. List each skillID and the number of people who need it in the descending order of the people counts.
WITH k
  AS 3,
missing_k
  AS (SELECT per_id
        FROM person
             INNER JOIN knows
             ON person.per_id = knows.per_id
             INNER JOIN required_skill
             ON knows.ks_code = required_skill.ks_code
                AND jp_code = 'jp_code'
       GROUP BY person_name
      HAVING COUNT(DISTINCT ks_code) - COUNT(ks_code) < k
       ORDER BY COUNT(DISTINCT ks_code) - COUNT(ks_code) ASC)
SELECT ks_code, COUNT(DISTINCT per_id) AS per_count
  FROM knows
       INNER JOIN required_skill
       ON knows.ks_code = required_skill.ks_code
          AND jp_code = 'jp_code'
       RIGHT JOIN missing_k
       ON knows.per_id = missing_k.per_id
 GROUP BY ks_code
 ORDER BY COUNT(DISTINCT per_id) DESC;

-- 21. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.
SELECT person_name
  FROM person
       INNER JOIN works
       ON person.per_id = works.per_id
       INNER JOIN job_profile
       ON works.jp_code = job_profile.jp_code
          AND jp_title = 'Special';

-- 22. Find all the unemployed people who once held a job of the given job-profile identifier.
WITH present_works
  AS (SELECT per_id
        FROM works
       WHERE CURRENT_DATE >= start_date
         AND CURRENT_DATE < end_date
          OR end_date IS NULL)
SELECT DISTINCT person_name
  FROM person
       INNER JOIN works
       ON person.per_id = works.per_id
       INNER JOIN job_profile
       ON works.jp_code = job_profile.jp_code
          AND jp_title = 'Given';
       LEFT JOIN present_works
       ON person.per_id = present_works.per_id
 WHERE present_works.per_id IS NULL

-- 23. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.
SELECT *
  FROM (SELECT comp_name
          FROM company
               INNER JOIN job
               ON company.comp_id = job.comp_id
               INNER JOIN works
               ON job.job_code = works.job_code
                  AND CURRENT_DATE >= start_date
                  AND CURRENT_DATE < end_date
         GROUP BY comp_name
         ORDER BY COUNT(per_id))
 WHERE ROWNUM = 1;

-- 24. Find out the job distribution among business sectors; find out the biggest sector in terms of number of employees or the total amount of salaries and wages paid to employees.
SELECT *
  FROM (SELECT primary_sector
          FROM company
               INNER JOIN job
               ON company.comp_id = job.comp_id
               INNER JOIN works
               ON job.job_code = works.job_code
                  AND CURRENT_DATE >= start_date
                  AND CURRENT_DATE < end_date
                   OR end_date IS NULL
         GROUP BY primary_sector
         ORDER BY COUNT(per_id))
 WHERE ROWNUM = 1;

-- 25. Find out the ratio between the people whose earnings increase and those whose earning decrease; find the average rate of earning improvement for the workers in a specific business sector.
SELECT pay_rate, pay_type, AVG(CASECR) AS avg_delta_pay
  FROM works w1
       INNER JOIN job j1
       ON w1.job_code = j1.job_code
       INNER JOIN works w2
       ON w1.start_date < w2.start_date
          AND w1.per_id = w2.per_id
       INNER JOIN job j2
       ON w2.job_code = j2.job_code
       INNER JOIN company
       ON job.comp_id = company.comp_id
          AND primary_sector = 'Specific sector'
  CASE pay_type
       WHEN 'wage'
       THEN (j2.pay_rate - j1.pay_rate) * 1920
       ELSE (j2.pay_rate - j1.pay_rate) * 1920 / 2080
       END;

-- 26. Find the job profiles that have the most openings due to lack of qualified workers. If there are many opening jobs of a job profile but at the same time there are many qualified jobless people. Then training cannot help fill up this type of job. What we want to find is such a job profile that has the largest difference between vacancies (the unfilled jobs of this job profile) and the number of jobless people who are qualified for this job profile.
WITH present_works
  AS (SELECT *
        FROM works
       WHERE start_date <= CURRENT_DATE
         AND end_date > CURRENT_DATE
          OR end_date IS NULL),
unemployed
  AS (SELECT per_id
        FROM person
             LEFT JOIN present_works
             ON person.per_id = present_works.per_id
       WHERE present_works.per_id IS NULL),
opening
  AS (SELECT job_code, jp_title, job_code, COUNT(ks_code) AS jp_ks_count
        FROM job_profile
             INNER JOIN job
             ON job_profile.job_code = job.job_code
             LEFT JOIN present_works
             ON job.job_code = present_works.job_code
       WHERE present_works.job_code IS NULL
       GROUP BY job_code),
qualified
  AS (SELECT per_id, jp_title
        FROM unemployed
             INNER JOIN knows
             ON unemployed.per_id = knows.per_id
             INNER JOIN required_skill
             ON knows.per_id = required_skill.per_id
             INNER JOIN opening
             ON required_skill.ks_code = opening.ks_code
       GROUP BY per_id, jp_title
      HAVING COUNT(ks_code) = jp_ks_count)
SELECT *
  FROM (SELECT COUNT(job_code) - COUNT(per_id) AS difference
          FROM qualified
               INNER JOIN opening
               ON qualified.jp_title = opening.jp_title
         GROUP BY (jp_title)
         ORDER BY difference DESC)
 WHERE ROWNUM = 1;

-- 27. Find the courses that can help most jobless people find a job by training them toward the job profiles that have the most openings due to lack of qualified workers.


-- 28. (BONUS) List all the courses, directly or indirectly required, that a person has to take in order to be qualified for a job of the given profile, according to his/her skills possessed and courses taken.
