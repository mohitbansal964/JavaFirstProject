/*Query 1*/
SELECT modulecode, duration FROM MODULES WHERE duration<6;

/*Query 2*/
SELECT p.batchcode, p.trainerid, p.coursecode, p.startdate, p.capacity, p.batchstrength
FROM batches p INNER JOIN trainers t on p.trainerid = t.trainerid where t.trainername = 'KRISHNAN';

/*Query 3*/
SELECT m.modulename FROM MODULES m
INNER JOIN courseandmodules c on m.modulecode = c.modulecode
WHERE c.coursecode = 100;

/*Query 4*/
SELECT m.modulename, c.coursecode FROM MODULES m
INNER JOIN courseandmodules c on m.modulecode = c.modulecode
WHERE c.coursecode = 100;

/*Query 5*/
SELECT COUNT(m.modulecode) as NumberOfModules FROM MODULES m
INNER JOIN courseandmodules c on m.modulecode = c.modulecode
WHERE c.coursecode = 100;

/*Query 6*/
SELECT coursecode, COUNT(modulecode) as NumberOfModules 
FROM courseandmodules group by coursecode;

/*Query 7*/
SELECT title, fees FROM courses 
WHERE fees in (SELECT MAX(fees) FROM courses);

/*Query 8*/
SELECT * FROM students
WHERE batchcode = 3001;

/*Query 9*/
SELECT * FROM students
WHERE place = 'CHENNAI';

/*Query 10*/
SELECT COUNT(modulecode) as LESSTHANSIXDAYS FROM MODULES WHERE duration<6;

/*Query 11*/
SELECT b.batchcode, c.title, b.startdate 
FROM batches b INNER JOIN courses c ON b.coursecode=c.coursecode 
WHERE startdate BETWEEN '2012-05-01' AND '2012-05-31';

/*Query 12*/
SELECT * FROM courses
WHERE coursecode NOT IN
(SELECT coursecode FROM batches 
WHERE startdate BETWEEN '2012-01-01' AND '2012-01-31');

/*Query 13*/
SELECT m.modulename 
FROM (modules m INNER JOIN courseandmodules cm on m.modulecode = cm.modulecode) 
INNER JOIN courses c on cm.coursecode=c.coursecode 
WHERE c.title='Oracle DBA';

/*Query 14*/
SELECT s.studentid, s.studentname, s.batchcode, s.place, s.phone
FROM students s
INNER JOIN batches b on s.batchcode = b.batchcode
WHERE place = 'CHENNAI' and startdate >= '2012-01-01' and startdate<='2012-12-31';

/*Query 15*/
SELECT s.studentid, s.studentname
FROM students s
INNER JOIN batches b on s.batchcode = b.batchcode
WHERE b.coursecode = 200;