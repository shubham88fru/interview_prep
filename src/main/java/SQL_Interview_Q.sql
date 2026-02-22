/*
1. Show unique birth years from patients
and order them by ascending.
 */
SELECT distinct YEAR(birth_date) as year
FROM patients
order by YEAR(birth_date) ASC;

/*
2. Show unique first names from the patients
table which only occurs once in the list.

For example, if two or more people are named
'John' in the first_name column then don't include
their name in the output list. If only 1 person
is named 'Leo' then include them in the output.
*/
SELECT first_name
FROM patients
GROUP BY first_name
HAVING COUNT(*) = 1;

/*
3. Show patient_id and first_name from patients where
their first_name start and ends with 's' and is at
least 6 characters long.
*/
SELECT patient_id, first_name
FROM patients
WHERE LEN(first_name) >= 6
AND LOWER(first_name) like 's%s';

/*
4. Show patient_id, first_name, last_name from patients whose
diagnosis is 'Dementia'.
Primary diagnosis is stored in the admissions table.
*/
SELECT p.patient_id, p.first_name, p.last_name
FROM admissions a
JOIN patients p ON p.patient_id = a.patient_id
WHERE a.diagnosis = 'Dementia';

/*
5. Display every patient's first_name.
Order the list by the length of each name
and then by alphabetically.
*/
SELECT first_name
FROM patients
ORDER BY LEN(first_name), first_name;

/*
6.  Show the total amount of male patients and the
total amount of female patients in the patients table.
Display the two results in the same row.
*/
SELECT
    COUNT(CASE WHEN gender = 'M' THEN patient_id ELSE null END ) AS male_count,
    COUNT(CASE WHEN gender = 'F' THEN patient_id ELSE null END )AS female_count
FROM patients;

/*
7.  Show first and last name, allergies from patients
which have allergies to either 'Penicillin' or 'Morphine'.
Show results ordered ascending by allergies then by
first_name then by last_name.
*/
SELECT first_name, last_name, allergies
FROM patients
WHERE allergies in ('Penicillin', 'Morphine')
ORDER BY allergies, first_name, last_name;

/*
8. Show patient_id, diagnosis from admissions.
Find patients admitted multiple times for the same diagnosis.
*/
SELECT patient_id, diagnosis
FROM admissions
GROUP BY patient_id, diagnosis
HAVING COUNT(*) > 1;

/*
9. Show the city and the total number of patients in the city.
Order from most to least patients and then by city name ascending.
*/
SELECT city, COUNT(*) as num_patients
FROM patients
group by city
order by num_patients desc, city;

/*
10. Show first name, last name and role of every person
that is either patient or doctor.
The roles are either "Patient" or "Doctor"
*/
SELECT first_name, last_name, 'Patient' as role
FROM patients
UNION ALL
SELECT first_name, last_name, 'Doctor' AS role
FROM doctors;

/*
11. Show all allergies ordered by popularity.
Remove NULL values from query.
*/
SELECT allergies, COUNT(*) as total_diagnosis
FROM patients
WHERE allergies NOT NULL
GROUP BY allergies
ORDER BY total_diagnosis DESC;

/*
12. Show all patient's first_name, last_name, and birth_date
who were born in the 1970s decade. Sort the list starting from
the earliest birth_date.
*/
SELECT first_name, last_name, birth_date
FROM patients
WHERE YEAR(birth_date) between 1970 AND 1979
ORDER BY birth_date;

/*
13. We want to display each patient's full name in a
single column. Their last_name in all upper letters must
appear first, then first_name in all lower case letters.
Separate the last_name and first_name with a comma.
Order the list by the first_name in decending order
EX: SMITH,jane
*/
SELECT upper(last_name) || ',' || lower(first_name) as new_name_format
FROM patients
ORDER BY first_name desc;

/*
14. Show the province_id(s), sum of height; where the total sum
of its patient's height is greater than or equal to 7,000.
*/
SELECT pn.province_id, SUM(p.height) as sum_height
FROM province_names pn
JOIN patients p ON pn.province_id = p.province_id
GROUP by pn.province_id
HAVING sum_height >= 7000;

/*
15. Show the difference between the largest weight and smallest
weight for patients with the last name 'Maroni'
*/
SELECT (MAX(weight) - MIN(weight)) as delta
FROM patients
WHERE last_name = 'Maroni';

/*
 16. Show all of the days of the month (1-31) and how many
 admission_dates occurred on that day. Sort by the day with
 most admissions to least admissions.
 */
SELECT DAY(admission_date), COUNT(*) as cnt
FROM admissions
GROUP By DAY(admission_date)
ORDER BY cnt DESC;

/*
17. Show all columns for patient_id 542's most recent admission_date.
*/
SELECT *
FROM admissions
WHERE patient_id = 542
ORDER BY admission_date desc
LIMIT 1;

/*
18. Show patient_id, attending_doctor_id, and diagnosis for
admissions that match one of the two criteria:
1. patient_id is an odd number and attending_doctor_id is either 1, 5, or 19.
2. attending_doctor_id contains a 2 and the length of patient_id is 3 characters.
*/
SELECT patient_id, attending_doctor_id, diagnosis
FROM admissions
WHERE (patient_id%2 != 0 AND attending_doctor_id IN (1, 5, 19))
OR (attending_doctor_id like '%2%' AND len(patient_id) = 3);

/*
19.  Show first_name, last_name, and the total number
of admissions attended for each doctor.

Every admission has been attended by a doctor.
*/
SELECT d.first_name, d.last_name, count(*) as admissions
FROM admissions a
JOIN doctors d on a.attending_doctor_id = d.doctor_id
group by a.attending_doctor_id;

/*
20. For each doctor, display their id, full name, and the
first and last admission date they attended.
*/
SELECT d.doctor_id, d.first_name || ' '|| d.last_name,
       MIN(admission_date) as first_ad_date, MAX(admission_date) as last_ad_date
FROM doctors d
JOIN admissions a ON a.attending_doctor_id = d.doctor_id
GROUP BY d.doctor_id;

/*
21. Display the total amount of patients for each province.
Order by descending.
*/
select province_name, COUNT(*) as cnt
FROM province_names pn
JOIN patients p ON pn.province_id = p.province_id
GROUP BY province_name
ORDER BY cnt DESC;

/*
22. For every admission, display the patient's full name, their admission diagnosis,
and their doctor's full name who diagnosed their problem.
*/
SELECT p.first_name || ' ' || p.last_name, a.diagnosis, d.first_name || ' ' || d.last_name
FROM admissions a
JOIN doctors d ON a.attending_doctor_id = d.doctor_id
JOIN patients p ON a.patient_id = p.patient_id;


/*
23. display the first name, last name and number of duplicate patients
based on their first name and last name.

Ex: A patient with an identical name can be considered a duplicate.
*/
SELECT first_name, last_name, COUNT(*) as cnt
FROM patients
GROUP BY first_name, last_name
HAVING COUNT(*) > 1;


/*
24. Display patient's full name,
height in the units feet rounded to 1 decimal,
weight in the unit pounds rounded to 0 decimals,
birth_date,
gender non abbreviated.

Convert CM to feet by dividing by 30.48.
Convert KG to pounds by multiplying by 2.205.
*/
SELECT first_name || ' ' || last_name,
round(height/30.48, 1) as ht,
round(weight*2.205, 0) as wt,
birth_date,
CASE WHEN gender='M' THEN 'MALE' ELSE 'FEMALE' END AS gender
FROM patients;


/*
25.  Show patient_id, first_name, last_name from patients whose
does not have any records in the admissions table.
(Their patient_id does not exist in any admissions.patient_id rows.)
*/
-- approach 1
SELECT patient_id, first_name, last_name
FROM patients
WHERE patient_id NOT IN (
SELECT patient_id
FROM admissions
);

-- approach 2
SELECT p.patient_id, p.first_name, p.last_name
FROM patients p
LEFT JOIN admissions a ON p.patient_id = a.patient_id
WHERE a.patient_id iS null;


/*
26. Display a single row with max_visits, min_visits, average_visits where
the maximum, minimum and average number
of admissions per day is calculated. Average is rounded to 2 decimal places.
*/
WITH CTE AS(
    SELECT admission_date, COUNT(*) as num_visits
    FROM admissions
    GROUP BY admission_date
)
SELECT MAX(num_visits) as max_visits,
       MIN(num_visits) AS min_visits,
       ROUND(AVG(num_visits), 2)
FROM CTE;

/*
27. Display every patient that has at least one admission and show their most recent
admission along with the patient and doctor's full name.
*/
SELECT
    p.first_name || ' ' || p.last_name AS patient_name,
    a.admission_date,
    d.first_name || ' ' || d.last_name AS doctor_name
FROM patients p
         JOIN admissions a ON p.patient_id = a.patient_id
         JOIN doctors d ON a.attending_doctor_id = d.doctor_id
WHERE a.admission_date = (
    SELECT MAX(a2.admission_date)
    FROM admissions a2
    WHERE a2.patient_id = p.patient_id
);

/*
28.  Show all of the patients grouped into weight groups.
Show the total amount of patients in each weight group.
Order the list by the weight group descending.

For example, if they weight 100 to 109 they are placed in the
100 weight group, 110-119 = 110 weight group, etc.
*/
SELECT COUNT(*) as cnt_in_group, FLOOR(weight/10)*10 as wt_group
FROM patients
GROUP BY FLOOR(weight/10)*10
ORDER BY wt_group DESC;

/*
29. Show patient_id, weight, height, isObese from the patients table.

Display isObese as a boolean 0 or 1.

Obese is defined as weight(kg)/(height(m)2) >= 30.

weight is in units kg.

height is in units cm.
*/
SELECT patient_id, weight, height,
       CASE WHEN (weight*1.0)/(height*height) >= 0.003 THEN 1 ELSE 0 END AS isObese
FROM patients;

/*
30. Show patient_id, first_name, last_name, and attending doctor's specialty.
Show only the patients who has a diagnosis as 'Epilepsy' and the doctor's first name is 'Lisa'

Check patients, admissions, and doctors tables for required information.
*/
SELECT p.patient_id, p.first_name, p.last_name, d.specialty
FROM admissions a
         JOIN doctors d ON a.attending_doctor_id = d.doctor_id
         JOIN patients p ON a.patient_id = p.patient_id
WHERE a.diagnosis = 'Epilepsy'
  AND d.first_name = 'Lisa';


/*
31. All patients who have gone through admissions, can see their
medical documents on our site. Those patients are given a temporary
password after their first admission. Show the patient_id and temp_password.

The password must be the following, in order:
1. patient_id
2. the numerical length of patient's last_name
3. year of patient's birth_date
*/
SELECT p.patient_id, concat(p.patient_id,len(p.last_name),year(p.birth_date)) AS temp_pass
FROM patients p
WHERE patient_id IN (SELECT patient_id FROM admissions);


/*
32.  Each admission costs $50 for patients without insurance, and $10 for patients
with insurance. All patients with an even patient_id have insurance.

Give each patient a 'Yes' if they have insurance, and a
'No' if they don't have insurance. Add up the admission_total cost for each has_insurance group.
*/
SELECT CASE WHEN p.patient_id%2 = 0 THEN 'Yes' ELSE 'No' END AS has_insurance,
       SUM(CASE WHEN p.patient_id%2 = 0 THEN 10 ELSE 50 END) AS cost
FROM patients p
         JOIN admissions a ON a.patient_id = p.patient_id
GROUP BY CASE WHEN p.patient_id%2 = 0 THEN 'Yes' ELSE 'No' END;


/*
 33. Show the provinces that has more patients identified
 as 'M' than 'F'. Must only show full province_name
*/
SELECT province_name
FROM patients  p
         JOIN province_names pn ON pn.province_id = p.province_id
GROUP BY pn.province_name
HAVING SUM(CASE WHEN p.gender = 'M' THEN 1 ELSE 0 END) > SUM(CASE WHEN p.gender = 'F' THEN 1 ELSE 0 END);

/*
34.  We are looking for a specific patient. Pull all columns for
the patient who matches the following criteria:
- First_name contains an 'r' after the first two letters.
- Identifies their gender as 'F'
- Born in February, May, or December
- Their weight would be between 60kg and 80kg
- Their patient_id is an odd number
- They are from the city 'Kingston'
*/
SELECT *
FROM patients
WHERE first_name like '__r%'
AND gender = 'F'
AND MONTH(birth_date) IN (2, 5, 12)
AND weight between 60 AND 80
AND patient_id%2 = 1
AND city = 'Kingston';

/*
35. Show the percent of patients that have 'M' as their gender.
Round the answer to the nearest hundreth number and in percent form.
 */
SELECT (ROUND(SUM(CASE WHEN gender = 'M'THEN 1 END)*100.0/(COUNT(*)), 2)) || '%' AS m_c
FROM patients;

/*
36.  For each day display the total amount of admissions
on that day. Display the amount changed from the previous date.
*/
WITH CTE AS(
    SELECT admission_date, COUNT(*) as curr_day_adm
    FROM admissions
    group by admission_date
)
SELECT admission_date, curr_day_adm, curr_day_adm - LAG(curr_day_adm, 1) OVER (order by admission_date) AS prev_day_adm
FROM CTE;

/*
37. Sort the province names in ascending order in such a way
that the province 'Ontario' is always on top.
*/
WITH CTE AS (
    SELECT province_name, (CASE WHEN province_name = 'Ontario' THEN 1 ELSE 0 END) AS sort_order
    FROM province_names
)
SELECT province_name
FROM CTE
order by sort_order DESC, province_name;

/*
38. We need a breakdown for the total amount of admissions
each doctor has started each year.
Show the doctor_id, doctor_full_name, specialty, year,
total_admissions for that year.
*/
SELECT d.doctor_id, d.first_name || ' ' || d.last_name, d.specialty, YEAR(a.admission_date), COUNT(*)
FROM doctors d
JOIN admissions a ON a.attending_doctor_id = d.doctor_id
GROUP BY d.doctor_id, d.first_name || ' ' || d.last_name, d.specialty, YEAR(a.admission_date);

/*
39. Write query to find 3rd highest salary
*/
SELECT DISTINCT salary
FROM Employee
ORDER BY salary DESC
LIMIT 1 OFFSET 2;