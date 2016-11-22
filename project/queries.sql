-- 1. List a company's workers by names
WITH current_works
  AS (SELECT per_id, job_code
        FROM works
       WHERE sysdate >= start_date
         AND (sysdate < end_date
              OR end_date IS NULL))
SELECT person_name
  FROM person
       INNER JOIN current_works
       ON person.per_id = current_works.per_id
       INNER JOIN job
       ON current_works.job_code = job.job_code
          AND comp_id = 1;

-- 2. List a company’s staff by salary in descending order.
WITH current_works
  AS (SELECT per_id, job_code
        FROM works
       WHERE sysdate >= start_date
         AND (sysdate < end_date
              OR end_date IS NULL))
SELECT person_name, pay_rate
  FROM person
       INNER JOIN current_works
       ON person.per_id = current_works.per_id
       INNER JOIN job
       ON current_works.job_code = job.job_code
          AND comp_id = 1
 ORDER BY pay_rate DESC;

-- 3. List companies’ labor cost (total salaries and wage rates by 1920 hours) in descending order.
WITH current_works
  AS (SELECT per_id, job_code
        FROM works
       WHERE sysdate >= start_date
         AND (sysdate < end_date
              OR end_date IS NULL)),
job_rel_pay
  AS (SELECT job_code, comp_id,
             CASE pay_type
             WHEN 'wage'
             THEN pay_rate * 1920
             WHEN 'salary'
             THEN pay_rate * 1920 / 2080
              END AS pay
        FROM job)
SELECT comp_name, ROUND(pay_sum, 2) AS labor_cost
  FROM (SELECT comp_name, SUM(pay) AS pay_sum
          FROM person
               INNER JOIN current_works
               ON person.per_id = current_works.per_id
               INNER JOIN job_rel_pay
               ON current_works.job_code = job_rel_pay.job_code
               INNER JOIN company
               ON job_rel_pay.comp_id = company.comp_id
         GROUP BY comp_name)
 ORDER BY pay_sum DESC;

-- 4. Find all the jobs a person is currently holding and worked in the past.
SELECT job.job_code, jp_title
  FROM job
       INNER JOIN job_profile
       ON job.jp_code = job_profile.jp_code
       INNER JOIN works
       ON job.job_code = works.job_code
       INNER JOIN person
       ON works.per_id = person.per_id
          AND person.per_id = 1;

-- 5. List a person’s knowledge/skills in a readable format.
SELECT ks_title, description
  FROM knowledge_skill
       INNER JOIN knows
       ON knows.ks_code = knowledge_skill.ks_code
       INNER JOIN person
       ON knows.per_id = person.per_id
          AND person.per_id = 1;

-- 6. List the skill gap of a worker between his/her job(s) and his/her skills.
SELECT job.job_code, jp_title, ks_title
  FROM job
       INNER JOIN job_profile
       ON job.jp_code = job_profile.jp_code
       INNER JOIN required_skill
       ON job_profile.jp_code = required_skill.jp_code
       INNER JOIN knowledge_skill
       ON required_skill.ks_code = knowledge_skill.ks_code
       INNER JOIN works
       ON job.job_code = works.job_code
       INNER JOIN person
       ON works.per_id = person.per_id
          AND person.per_id = 1
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
          AND job_profile.jp_code = 001;

-- 8. List a person’s missing knowledge/skills for a specific job in a readable format.
SELECT ks_title
  FROM knowledge_skill
       INNER JOIN required_skill
       ON knowledge_skill.ks_code = required_skill.ks_code
       INNER JOIN job
       ON required_skill.jp_code = job.jp_code
          AND job_code = 703
       LEFT JOIN knows
       ON required_skill.ks_code = knows.ks_code
 WHERE knows.per_id <> 6;

-- 9. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.
WITH known_ks
  AS (SELECT ks_code
        FROM knows
       WHERE per_id = 6),
missing_ks
  AS (SELECT required_skill.jp_code, required_skill.ks_code
        FROM required_skill
             LEFT JOIN known_ks
             ON required_skill.ks_code = known_ks.ks_code
       WHERE known_ks.ks_code IS NULL
         AND required_skill.jp_code = 002)
SELECT course.c_code, course.c_title
  FROM course
       INNER JOIN teaches
       ON course.c_code = teaches.c_code
       INNER JOIN missing_ks
       ON teaches.ks_code = missing_ks.ks_code
 GROUP BY course.c_code, course.c_title
HAVING COUNT(*) = (SELECT COUNT(*)
                     FROM missing_ks);

-- 10. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the “quickest” solution for this worker. Show the course, section information and the completion date.
WITH known_ks
  AS (SELECT ks_code
        FROM knows
       WHERE per_id = 6),
missing_ks
  AS (SELECT required_skill.jp_code, required_skill.ks_code
        FROM required_skill
             LEFT JOIN known_ks
             ON required_skill.ks_code = known_ks.ks_code
       WHERE known_ks.ks_code IS NULL
         AND required_skill.jp_code = 002)
SELECT *
  FROM (SELECT course.c_code, course.c_title, sec_no, complete_date
          FROM course
               INNER JOIN section
               ON course.c_code = section.c_code
               INNER JOIN teaches
               ON course.c_code = teaches.c_code
                INNER JOIN teaches
                ON course.c_code = teaches.c_code
                INNER JOIN missing_ks
                ON teaches.ks_code = missing_ks.ks_code
          WHERE status = 'active'
          GROUP BY course.c_code, course.c_title, sec_no, complete_date
         HAVING COUNT(*) = (SELECT COUNT(*)
                             FROM missing_ks)
         ORDER BY complete_date)
 WHERE ROWNUM = 1;

-- 11. Find the cheapest course to make up one’s skill gap by showing the course to take and the cost (of the section price).
WITH known_ks
  AS (SELECT ks_code
        FROM knows
       WHERE per_id = 6),
missing_ks
  AS (SELECT required_skill.jp_code, required_skill.ks_code
        FROM required_skill
             LEFT JOIN known_ks
             ON required_skill.ks_code = known_ks.ks_code
       WHERE known_ks.ks_code IS NULL
         AND required_skill.jp_code = 002)
SELECT c_code, c_title, ROUND(price, 2) AS cost
  FROM (SELECT course.c_code, course.c_title, price
          FROM course
               INNER JOIN section
               ON course.c_code = section.c_code
               INNER JOIN teaches
               ON course.c_code = teaches.c_code
                INNER JOIN teaches
                ON course.c_code = teaches.c_code
                INNER JOIN missing_ks
                ON teaches.ks_code = missing_ks.ks_code
          WHERE status = 'active'
          GROUP BY course.c_code, course.c_title, price
         HAVING COUNT(*) = (SELECT COUNT(*)
                             FROM missing_ks)
         ORDER BY price DESC)
 WHERE ROWNUM = 1;

-- 12. If query #9 returns nothing, then find the course sets that their combination covers all the missing knowledge/ skills for a person to pursue a specific job. The considered course sets will not include more than three courses. If multiple course sets are found, list the course sets (with their course IDs) in the order of the ascending order of the course sets’ total costs.
WITH known_ks
  AS (SELECT ks_code
        FROM knows
       WHERE per_id = 6),
missing_ks
  AS (SELECT required_skill.jp_code, required_skill.ks_code
        FROM required_skill
             LEFT JOIN known_ks
             ON required_skill.ks_code = known_ks.ks_code
       WHERE known_ks.ks_code IS NULL
         AND required_skill.jp_code = 002),
course_for_missing_ks
  AS (SELECT course.c_code, missing_ks.ks_code, price
        FROM course
             INNER JOIN section
             ON course.c_code = section.c_code
             INNER JOIN teaches
             ON course.c_code = teaches.c_code
             INNER JOIN missing_ks
             ON teaches.ks_code = missing_ks.ks_code
       WHERE status = 'active'),
course_sets
  AS (SELECT c1.c_code AS course_1,
             c2.c_code AS course_2,
             NULL AS course_3,
             c1.ks_code AS ks_1,
             c2.ks_code AS ks_2,
             NULL AS ks_3,
             ROUND(c1.price + c2.price, 2) AS total_cost
        FROM course_for_missing_ks c1
             INNER JOIN course_for_missing_ks c2
             ON c1.c_code < c2.c_code
       UNION ALL
      SELECT c1.c_code AS course_1,
             c2.c_code AS course_2,
             c3.c_code AS course_3,
             c1.ks_code AS ks_1,
             c2.ks_code AS ks_2,
             c3.ks_code AS ks_3,
             ROUND(c1.price + c2.price + c3.price, 2) AS total_cost
        FROM course_for_missing_ks c1
             INNER JOIN course_for_missing_ks c2
             ON c1.c_code < c2.c_code
             INNER JOIN course_for_missing_ks c3
             ON c1.c_code < c3.c_code
                AND c2.c_code < c3.c_code),
course_set_per_ks
  AS (SELECT ks_1 AS ks_code, course_1, course_2, course_3, total_cost
        FROM course_sets
       UNION ALL
      SELECT ks_2 AS ks_code, course_1, course_2, course_3, total_cost
        FROM course_sets
       UNION ALL
      SELECT ks_3 AS ks_code, course_1, course_2, course_3, total_cost
        FROM course_sets)
SELECT course_1, course_2, course_3, total_cost
  FROM course_set_per_ks
 GROUP BY course_1, course_2, course_3, total_cost
HAVING COUNT(DISTINCT ks_code) = (SELECT COUNT(*)
                                    FROM missing_ks)
 ORDER BY total_cost ASC;

-- 13. List all the job profiles that a person is qualified for.
WITH known_ks
  AS (SELECT ks_code
        FROM knows
       WHERE per_id = 1),
missing_ks
  AS (SELECT required_skill.jp_code, required_skill.ks_code
        FROM required_skill
             LEFT JOIN known_ks
             ON required_skill.ks_code = known_ks.ks_code
       WHERE known_ks.ks_code IS NULL)
SELECT job_profile.jp_code, job_profile.jp_title
  FROM job_profile
       INNER JOIN required_skill
       ON job_profile.jp_code = required_skill.jp_code
       LEFT JOIN missing_ks
       ON required_skill.jp_code = missing_ks.jp_code
 WHERE missing_ks.jp_code IS NULL
 GROUP BY job_profile.jp_code, job_profile.jp_title;

-- 14. Find the job with the highest pay rate for a person according to his/her skill qualification.
WITH job_rel_pay
  AS (SELECT job_code, jp_code, comp_id,
             CASE pay_type
             WHEN 'wage'
             THEN pay_rate * 1920
             WHEN 'salary'
             THEN pay_rate * 1920 / 2080
              END AS rel_pay
        FROM job),
known_ks
  AS (SELECT ks_code
        FROM knows
       WHERE per_id = 1),
missing_ks
  AS (SELECT required_skill.jp_code, required_skill.ks_code
        FROM required_skill
             LEFT JOIN known_ks
             ON required_skill.ks_code = known_ks.ks_code
       WHERE known_ks.ks_code IS NULL)
SELECT job_code, ROUND(rel_pay, 2) AS pay
FROM (SELECT DISTINCT job_code, rel_pay
        FROM job_rel_pay
             INNER JOIN job_profile
             ON job_rel_pay.jp_code = job_profile.jp_code
             INNER JOIN required_skill
             ON job_profile.jp_code = required_skill.jp_code
             LEFT JOIN missing_ks
             ON required_skill.jp_code = missing_ks.jp_code
       WHERE missing_ks.jp_code IS NULL
       ORDER BY rel_pay DESC)
 WHERE ROWNUM = 1;

-- 15. List all the names along with the emails of the persons who are qualified for a job profile.
SELECT person_name, email
  FROM person
       INNER JOIN knows
       ON person.per_id = knows.per_id
       INNER JOIN required_skill
       ON knows.ks_code = required_skill.ks_code
 GROUP BY person_name, email
HAVING COUNT(*) = COUNT(DISTINCT knows.ks_code);

-- 16. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a “missing-one” list that lists people who miss only one skill for a specified job profile.
SELECT person_name
  FROM person
       INNER JOIN knows
       ON person.per_id = knows.per_id
       INNER JOIN required_skill
       ON knows.ks_code = required_skill.ks_code
          AND jp_code = 001
 GROUP BY person_name
HAVING COUNT(*) = COUNT(DISTINCT knows.ks_code) - 1;

-- 17. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.
WITH missing_one
  AS (SELECT person.per_id
        FROM person
             INNER JOIN knows
             ON person.per_id = knows.per_id
             INNER JOIN required_skill
             ON knows.ks_code = required_skill.ks_code
                AND jp_code = 001
       GROUP BY person.per_id
      HAVING COUNT(*) = COUNT(DISTINCT knows.ks_code) - 1)
SELECT knows.ks_code, COUNT(missing_one.per_id) AS person_count
  FROM missing_one
       INNER JOIN knows
       ON missing_one.per_id = knows.per_id
 GROUP BY knows.ks_code;

-- 18. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the “least number”.
WITH ks_for_jp
  AS (SELECT ks_code
        FROM required_skill
       WHERE jp_code = 012)
SELECT person_name,
       (SELECT COUNT(*) FROM ks_for_jp) - MIN(ks_count) AS missing_ks_count
  FROM (SELECT person_name, COUNT(knows.ks_code) AS ks_count
          FROM person
               INNER JOIN knows
               ON person.per_id = knows.per_id
               INNER JOIN ks_for_jp
               ON knows.ks_code = ks_for_jp.ks_code
         GROUP BY person_name)
 GROUP BY person_name;

-- 19. For a specified job profile and a given small number k, make a “missing-k” list that lists the people’s IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills
WITH ks_for_jp
  AS (SELECT ks_code
        FROM required_skill
       WHERE jp_code = 012)
SELECT person_name,
       (SELECT COUNT(*) FROM ks_for_jp) - ks_count AS missing_ks_count
  FROM (SELECT person_name, COUNT(knows.ks_code) AS ks_count
          FROM person
               INNER JOIN knows
               ON person.per_id = knows.per_id
               INNER JOIN ks_for_jp
               ON knows.ks_code = ks_for_jp.ks_code
         GROUP BY person_name)
 WHERE (SELECT COUNT(*) FROM ks_for_jp) - ks_count <= 5;

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
                AND jp_code = 012
       GROUP BY person_name
      HAVING COUNT(DISTINCT ks_code) - COUNT(ks_code) < k
       ORDER BY COUNT(DISTINCT ks_code) - COUNT(ks_code) ASC)
SELECT ks_code, COUNT(DISTINCT per_id) AS per_count
  FROM knows
       INNER JOIN required_skill
       ON knows.ks_code = required_skill.ks_code
          AND jp_code = 012
       RIGHT JOIN missing_k
       ON knows.per_id = missing_k.per_id
 GROUP BY ks_code
 ORDER BY COUNT(DISTINCT per_id) DESC;

-- 21. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.
SELECT person_name
  FROM person
       INNER JOIN works
       ON person.per_id = works.per_id
       INNER JOIN job
       ON works.job_code = job.job_code
       INNER JOIN job_profile
       ON job.jp_code = job_profile.jp_code
          AND jp_title = 'Special';

-- 22. Find all the unemployed people who once held a job of the given job-profile identifier.
WITH current_works
  AS (SELECT per_id, job_code
        FROM works
       WHERE sysdate >= start_date
         AND (sysdate < end_date
              OR end_date IS NULL))
SELECT DISTINCT person_name
  FROM person
       INNER JOIN works
       ON person.per_id = works.per_id
       INNER JOIN job
       ON works.job_code = job.job_code
          AND job.jp_code = 001
       INNER JOIN job_profile
       ON job.jp_code = job_profile.jp_code
       LEFT JOIN current_works
       ON person.per_id = current_works.per_id
 WHERE current_works.per_id IS NULL;

-- 23. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.
WITH current_works
  AS (SELECT per_id, job_code
        FROM works
       WHERE sysdate >= start_date
         AND (sysdate < end_date
              OR end_date IS NULL))
SELECT comp_name
  FROM (SELECT comp_name
          FROM company
               INNER JOIN job
               ON company.comp_id = job.comp_id
               INNER JOIN current_works
               ON job.job_code = current_works.job_code
         GROUP BY comp_name
         ORDER BY COUNT(per_id) DESC)
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
WITH job_rel_pay
  AS (SELECT job_code, jp_code, comp_id,
             CASE pay_type
             WHEN 'wage'
             THEN pay_rate * 1920
             WHEN 'salary'
             THEN pay_rate * 1920 / 2080
              END AS pay
        FROM job),
works_ordered
  AS (SELECT job_rel_A, ROWNUM AS row
        FROM (SELECT pay
                FROM job_rel_pay
                     INNER JOIN works
                     ON job_rel_pay.job_code = works.job_code
               ORDER BY job_rel_pay.start_date ASC)),
per_delta_pay
  AS (SELECT w1.per_id, j2.pay - j1.pay AS delta_pay
  FROM works_ordered w1
       INNER JOIN works w2
       ON w1.comp_id = w2.comp_id
          AND w1.row + 1 = w2.row
          AND comp_id = 'Electric')
SELECT AVG(delta_pay) AS avg_delta_pay
  FROM per_delta_pay;

-- 26. Find the job profiles that have the most openings due to lack of qualified workers. If there are many opening jobs of a job profile but at the same time there are many qualified jobless people. Then training cannot help fill up this type of job. What we want to find is such a job profile that has the largest difference between vacancies (the unfilled jobs of this job profile) and the number of jobless people who are qualified for this job profile.
WITH current_works
  AS (SELECT *
        FROM works
       WHERE start_date <= CURRENT_DATE
         AND end_date > CURRENT_DATE
          OR end_date IS NULL),
unemployed
  AS (SELECT person.per_id
        FROM person
             LEFT JOIN current_works
             ON person.per_id = current_works.per_id
       WHERE current_works.per_id IS NULL),
opening
  AS (SELECT job.job_code, job.jp_code, jp_title
        FROM job
             INNER JOIN job_profile
             ON job.jp_code = job_profile.jp_code
             LEFT JOIN current_works
             ON job.job_code = current_works.job_code
       WHERE current_works.job_code IS NULL),
qualified
  AS (SELECT unemployed.per_id, opening.jp_code, jp_title
        FROM unemployed
             INNER JOIN knows
             ON unemployed.per_id = knows.per_id
             INNER JOIN required_skill
             ON knows.ks_code = required_skill.ks_code
             INNER JOIN opening
             ON required_skill.jp_code = opening.jp_code
       GROUP BY unemployed.per_id, opening.jp_code, jp_title
      HAVING COUNT(knows.ks_code) = COUNT(DISTINCT knows.ks_code))
SELECT *
  FROM (SELECT qualified.jp_code, qualified.jp_title
          FROM qualified
               INNER JOIN opening
               ON qualified.jp_code = opening.jp_code
         GROUP BY (qualified.jp_code, qualified.jp_title)
         ORDER BY COUNT(job_code) - COUNT(per_id) DESC)
 WHERE ROWNUM = 1;

-- 27. Find the courses that can help most jobless people find a job by training them toward the job profiles that have the most openings due to lack of qualified workers.
WITH current_works
  AS (SELECT *
        FROM works
       WHERE start_date <= CURRENT_DATE
         AND end_date > CURRENT_DATE
          OR end_date IS NULL),
unemployed
  AS (SELECT person.per_id
        FROM person
             LEFT JOIN current_works
             ON person.per_id = current_works.per_id
       WHERE current_works.per_id IS NULL),
opening
  AS (SELECT job.job_code, job.jp_code, jp_title
        FROM job_profile
             INNER JOIN job
             ON job_profile.jp_code = job.jp_code
             LEFT JOIN current_works
             ON job.job_code = current_works.job_code
       WHERE current_works.job_code IS NULL),
qualified
  AS (SELECT unemployed.per_id, opening.jp_code, jp_title
        FROM unemployed
             INNER JOIN knows
             ON unemployed.per_id = knows.per_id
             INNER JOIN required_skill
             ON knows.ks_code = required_skill.ks_code
             INNER JOIN opening
             ON required_skill.jp_code = opening.jp_code
       GROUP BY unemployed.per_id, opening.jp_code, jp_title
      HAVING COUNT(knows.ks_code) = COUNT(DISTINCT knows.ks_code)),
jp_most_openings
  AS (SELECT qualified.jp_code, qualified.jp_title,
             COUNT(job_code) - COUNT(per_id) AS difference
        FROM qualified
             INNER JOIN opening
             ON qualified.jp_code = opening.jp_code
       GROUP BY (qualified.jp_code, qualified.jp_title)
       ORDER BY difference DESC)
SELECT course.c_code, c_title, difference
  FROM course
       INNER JOIN teaches
       ON course.c_code = teaches.c_code
       INNER JOIN required_skill
       ON teaches.ks_code = required_skill.ks_code
       INNER JOIN jp_most_openings
       ON required_skill.jp_code = jp_most_openings.jp_code
          AND status = 'active'
 GROUP BY course.c_code, c_title, difference
HAVING COUNT(*) = COUNT(DISTINCT teaches.ks_code)
 ORDER BY difference;

-- 28. (BONUS) List all the courses, directly or indirectly required, that a person has to take in order to be qualified for a job of the given profile, according to his/her skills possessed and courses taken.
WITH knows_by_person
  AS (SELECT ks_code
        FROM knows
       WHERE per_id = 'Person')
ks_by_best_course
  AS (SELECT c_code, c_title, ks_code
        FROM (SELECT c_code, c_title, COUNT(ks_code) AS ks_count
                FROM course
                     INNER JOIN teaches
                     ON course.c_code = teaches.c_code
               GROUP BY c_code, c_title)
             INNER JOIN teaches
             ON course.c_code = teaches.c_code
       WHERE ROW_NUMBER() OVER(PARTITION BY ks_code
                                   ORDER BY ks_count DESC) = 1)
SELECT DISTINCT c_code, c_title
  FROM course
       INNER JOIN ks_by_best_course
       ON course.c_code = teaches.c_code
       INNER JOIN required_skill
       ON ks_by_best_course.ks_code = required_skill.ks_code
       INNER JOIN job_profile
       ON required_skill.jp_code = job_profile.jp_code
          AND job_profile.jp_title = 'Profile'
       LEFT JOIN knows_by_person
       ON teaches.per_id = knows_by_person.per_id
 WHERE knows.per_id IS NULL;
