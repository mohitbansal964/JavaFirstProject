SELECT modulecode, duration FROM MODULES WHERE duration<6;

SELECT p.batchcode, p.trainerid, p.coursecode, p.startdate, p.capacity, p.batchstrength
FROM batches p INNER JOIN trainers t on p.trainerid = t.trainerid where t.trainername = 'KRISHNAN';

SELECT m.modulename
FROM MODULES m
INNER JOIN courseandmodules c on m.modulecode = c.modulecode
WHERE c.coursecode = 100;

SELECT COUNT(m.modulecode) as ModuleCount
FROM MODULES m
INNER JOIN courseandmodules c on m.modulecode = c.modulecode
WHERE c.coursecode = 100;

SELECT coursecode, COUNT(modulecode) as ModuleCount
FROM courseandmodules group by coursecode;

SELECT title, MAX(fees)
FROM courses;

SELECT studentid, studentname, batchcode, place, phone
FROM students
WHERE batchcode = 3001;

SELECT studentid, studentname, batchcode, place, phone
FROM students
WHERE place = 'CHENNAI';

SELECT COUNT(modulecode) as LESSTHANSIXDAYS, duration FROM MODULES WHERE duration<6;

SELECT b.batchcode, c.title as CourseTitle, b.startdate
FROM batches b
INNER JOIN courses c on b.coursecode = c.coursecode
WHERE b.startdate >= '2012-05-01' and b.startdate < '2012-06-01';

SELECT c.coursecode, c.title, c.fees
FROM courses c
INNER JOIN batches b on c.coursecode = b.coursecode
WHERE b.startdate < '2012-01-01' or b.startdate > '2012-01-31';

SELECT m.modulename
FROM MODULES m
LEFT JOIN courseandmodules c on m.modulecode = c.modulecode
LEFT JOIN courses c2 on c.coursecode = c2.coursecode
WHERE c2.title = 'Oracle DBA';

SELECT s.studentid, s.studentname, s.batchcode, s.place, s.phone
FROM students s
INNER JOIN batches b on s.batchcode = b.batchcode
WHERE place = 'CHENNAI' and strftime('%Y',b.startdate) = '2012';

SELECT s.studentid, s.studentname
FROM students s
INNER JOIN batches b on s.batchcode = b.batchcode
WHERE b.coursecode = 200;