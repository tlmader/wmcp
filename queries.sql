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
        SELECT comp_name, SUM(pay_rate / 2080 * 1920) -- Assume 2080 hrs/yr
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
          AND person_name = "Name";

-- 5. List a person’s knowledge/skills in a readable format.
SELECT title, description
  FROM knowledge_skill
       INNER JOIN knows
       ON knows.ks_code = knowledge_skill.ks_code
       INNER JOIN person
       ON knows.per_id = person.per_id
          AND person_name = "Name";

-- 6. List the skill gap of a worker between his/her job(s) and his/her skills.
SELECT job_code, title
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
          AND person_name = "Name";

-- 7. List the required knowledge/skills of a job profile in a readable format.


-- 8. List a person’s missing knowledge/skills for a specific job in a readable format.


-- 9. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.


-- 10. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the “quickest” solution for this worker. Show the course, section information and the completion date.


-- 11. Find the cheapest course to make up one’s skill gap by showing the course to take and the cost (of the section price).


-- 12. If query #9 returns nothing, then find the course sets that their combination covers all the missing knowledge/ skills for a person to pursue a specific job. The considered course sets will not include more than three courses. If multiple course sets are found, list the course sets (with their course IDs) in the order of the ascending order of the course sets’ total costs.


-- 13. List all the job profiles that a person is qualified for.


-- 14. Find the job with the highest pay rate for a person according to his/her skill qualification.


-- 15. List all the names along with the emails of the persons who are qualified for a job profile.


-- 16. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a “missing-one” list that lists people who miss only one skill for a specified job profile.


-- 17. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.


-- 18. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the “least number”.


-- 19. For a specified job profile and a given small number k, make a “missing-k” list that lists the people’s IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills.


-- 20. (BONUS) Given a job profile and its corresponding missing-k list specified in Question 19. Find every skill that is needed by at least one person in the given missing-k list. List each skillID and the number of people who need it in the descending order of the people counts.


-- 21. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.


-- 22. Find all the unemployed people who once held a job of the given job-profile identifier.


-- 23. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.


-- 24. Find out the job distribution among business sectors; find out the biggest sector in terms of number of employees or the total amount of salaries and wages paid to employees.


-- 25. Find out the ratio between the people whose earnings increase and those whose earning decrease; find the average rate of earning improvement for the workers in a specific business sector.


-- 26. Find the job profiles that have the most openings due to lack of qualified workers. If there are many opening jobs of a job profile but at the same time there are many qualified jobless people. Then training cannot help fill up this type of job. What we want to find is such a job profile that has the largest difference between vacancies (the unfilled jobs of this job profile) and the number of jobless people who are qualified for this job profile.


-- 27. Find the courses that can help most jobless people find a job by training them toward the job profiles that have the most openings due to lack of qualified workers.


-- 28. (BONUS) List all the courses, directly or indirectly required, that a person has to take in order to be qualified for a job of the given profile, according to his/her skills possessed and courses taken.
