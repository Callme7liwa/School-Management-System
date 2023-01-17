CREATE TYPE enum_gender AS ENUM ('male','female');

CREATE TABLE students (
    student_id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    student_name VARCHAR(50) NOT NULL , 
    student_secondName  VARCHAR(50) NOT NULL  , 
    student_birthday DATE NOT NULL ,
    student_gmail VARCHAR(100) NOT NULL , 
    student_password VARCHAR(255) , 
    student_cin  VARCHAR(50), 
    student_cne VARCHAR(50) , 
    student_adress VARCHAR(255),
    student_country VARCHAR(30) , 
    student_city VARCHAR(30), 
    student_postalCode VARCHAR(30),
    student_phoneNumber VARCHAR(50),
)

ALTER TABLE students
ADD COLUMN field_id INTEGER(11) CONSTRAINT students_fieldId_FK FOREIGN KEY(field_id) REFERENCES fields(student_id);

CREATE TABLE professors (
    professor_id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    professor_name VARCHAR(50) NOT NULL , 
    professor_secondName  VARCHAR(50) NOT NULL  , 
    professor_birthday DATE NOT NULL ,
    professor_gender  enum_gender,
    professor_gmail VARCHAR(100) NOT NULL , 
    professor_password VARCHAR(255) , 
    professor_cin  VARCHAR(50), 
    professor_adress VARCHAR(255),
    professor_country VARCHAR(30) , 
    professor_city VARCHAR(30), 
    professor_postalCode VARCHAR(30),
    professor_phoneNumber VARCHAR(50),
    departement_id INTEGER(11)  , 
)

CREATE TABLE departements (
    departement_id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    departement_name VARCHAR(50) , 
    departement_description VARCHAR(255),
)

CREATE TABLE groups (
    group_id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    group_name VARCHAR(50) NOT NULL , 
    group_abbreviation VARCHAR(10),
    group_creationDate DATE , 
    field_id INTEGER(11)
    level_id INTEGER(11),
)

CREATE TABLE moduls (
    modul_id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    modul_name VARCHAR(50) NOT NULL , 
    modul_abbrevation VARCHAR(10)  , 
    modul_creationDate DATE , 
)

CREATE TABLE fields (
    field_id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    field_name VARCHAR(50) NOT NULL ,
    field_description VARCHAR(255) 
)

CREATE TABLE levels (
    level_id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    level_name VARCHAR(255) NOT NULL , 
)

CREATE TABLE student_absences (
    student_id INTEGER(11) ,
    modul_id INTEGER(11) , 
    absence_date TIMESTAMP , 
    absence_hours NUMBER(2),
    absence_description VARCHAR(250)
)

CREATE TABLE student_marks (
    student_id INTEGER(11) ,
    modul_id INTEGER(11) , 
    mark_date DATE , 
    mark_description , 
)

CREATE TABLE student_groups (
    student_id INTEGER(11) ,
    group_id INTEGER(11) , 
    mark_description , 
)

CREATE TABLE professor_groups (
    professor_id INTEGER(11) , 
    group_id INTEGER(11) , 
    affectation_date DATE 
)

CREATE TABLE professor_moduls (
    professor_id INTEGER(11) , 
    modul_id INTEGER(11) , 
    affectation_date DATE 
)

CREATE TABLE group_moduls (
    group_id INTEGER(11) , 
    modul_id INTEGER(11) , 
    affectation_date DATE 
)

CREATE TABLE group_docs (
    group_id INTEGER(11),
    group_doc VARCHAR(250)
)

-- ****************************************************************************************************
CREATE TABLE Group_Modul_Professor(
    group_id INTEGER(11),
    professor_id INTEGER(11),
    modul_id INTEGER(11),
    affectation_date DATE 
);

CREATE TABLE events(
    event_id INTEGER(11) PRIMARY KEY ,
    event_name VARCHAR(250),
    event_local VARCHAR(150),
    event_description VARCHAR(500),
    event_filePath VARCHAR(100),=
);

ALTER TABLE Group_Modul_Professor 
ADD CONSTRAINT GMP_groupId_FK FOREIGN KEY group_id REFERENCES groups(group_id);
ALTER TABLE Group_Modul_Professor 
ADD CONSTRAINT GMP_professorId_FK FOREIGN KEY professor_id REFERENCES professors(professor_id);
ALTER TABLE Group_Modul_Professor 
ADD CONSTRAINT GMP_modulId_FK FOREIGN KEY modul_id REFERENCES moduls(modul_id);
ALTER TABLE   Group_Modul_Professor 
ADD CONSTRAINT GMP_modulId_PK PRIMARY KEY (group_id,professor_id,modul_id)
-- *****************************************************************************************************

ALTER TABLE group_docs 
ADD CONSTRAINT group_docs_groupId_FK FOREIGN KEY group_id REFERENCES group_moduls(group_id)

-- ADD FOREIGN KEY TO PROFESSORS TABLE : 
ALTER TABLE professors 
ADD FOREIGN KEY(departement_id) REFERENCES departements(departement_id);


ALTER TABLE groups 
ADD FOREIGN KEY(field_id) REFERENCES fields(field_id);

ALTER TABLE groups 
ADD FOREIGN KEY(level_id) REFERENCES levels(level_id);


-- ADD PRIMARY KEY AND FOREIGN KEY TO STUDENT_ABSENCES TABLE 
ALTER TABLE student_absences
ADD FOREIGN KEY(student_id) REFERENCES students(student_id);

ALTER TABLE student_absences
ADD FOREIGN KEY(modul_id) REFERENCES moduls(modul_id);

ALTER TABLE student_absences
ADD CONSTRAINT studentAbsences_student_module_PK PRIMARY KEY NONCLUSTERED (student_id, modul_id,absence_date);
-- 

-- 
ALTER TABLE student_marks
ADD FOREIGN KEY(student_id) REFERENCES students(student_id);

ALTER TABLE student_marks
ADD FOREIGN KEY(modul_id) REFERENCES moduls(modul_id);

ALTER TABLE student_marks
ADD CONSTRAINT studentMarks_student_marks_PK PRIMARY KEY NONCLUSTERED (student_id, modul_id);
-- 
ALTER TABLE professor_moduls
ADD FOREIGN KEY(professor_id) REFERENCES professors(professor_id);

ALTER TABLE professor_moduls
ADD FOREIGN KEY(modul_id) REFERENCES moduls(modul_id);

ALTER TABLE professor_moduls
ADD CONSTRAINT studentMarks_student_marks_PK PRIMARY KEY NONCLUSTERED (professor_id, modul_id);
-- GROUP _ MODULS 
ALTER TABLE group_moduls
ADD FOREIGN KEY(group_id) REFERENCES groups(group_id);

ALTER TABLE group_moduls
ADD FOREIGN KEY(modul_id) REFERENCES moduls(modul_id);

ALTER TABLE group_moduls
ADD CONSTRAINT groupModuls_group_moduls_PK PRIMARY KEY NONCLUSTERED (group_id, modul_id);
-- PROFESSOIS _  GROUPS _ ADD _ PRIMARY _ KEY
ALTER TABLE professor_groups
ADD FOREIGN KEY(group_id) REFERENCES groups(group_id);

ALTER TABLE professor_groups
ADD FOREIGN KEY(professor_id) REFERENCES moduls(professor_id);

ALTER TABLE professor_groups
ADD CONSTRAINT professorGroups_professor_group_PK PRIMARY KEY NONCLUSTERED (group_id, professoir_id);
-- GROUP _ STUDENTS
ALTER TABLE student_groups
ADD FOREIGN KEY(group_id) REFERENCES groups(group_id);

ALTER TABLE student_groups
ADD FOREIGN KEY(student_id) REFERENCES students(student_id);

ALTER TABLE student_groups
ADD CONSTRAINT groupStudents_group_students_PK PRIMARY KEY NONCLUSTERED (group_id, student_id);


---------------------------------------------------------------- INSERTION -----------------------------------------------------------------------------------


INSERT INTO fields ('field_name' , 'field_description')
VALUES ()

--

ALTER TABLE groups 
ADD CONSTRAINT groups_levelId_FK FOREIGN KEY (level_id) REFERENCES levels (level_id)

--
ALTER TABLE students
ADD CONSTRAINT students_fieldId_FK FOREIGN KEY (field_id) REFERENCES fields(field_id)
--

INSERT INTO `groups` (`group_id`, `group_name`, `group_abbreviation`, `group_creationDate`, `field_id`, `level_id`) 
VALUES 
(NULL, 'group7', 'g7', '2022-11-01', '4', '1'),
(NULL, 'group2', 'g2', '2022-11-03', '3', '1'), 
(NULL, 'group3', 'g3', '2022-11-11', '1', '2'),
(NULL, 'group10', 'g10', '2022-11-28', '2', '3'),
(NULL, 'group1', 'g1', '2022-11-26', '1', '1'),
(NULL, 'group2', 'g2', '2022-11-01', '1', '1');

-- Students

INSERT INTO `students` (`student_id`, `student_name`, `student_secondName`, `student_birthday`, `student_gender`, `student_gmail`, `student_email`, `student_password`, `student_cin`, `student_cne`, `student_adress`, `student_country`, `student_city`, `student_postalCode`, `student_phoneNumber`, `field_id`) 
VALUES (NULL, 'mehdi', 'seddiki', '2022-11-17', 'male', 'mehdi@gmail.com', 'mehdi@gmail.com', 'Aseddiki96!', 'CD269360', 'N139149171', '30 rue hay salam fes', 'morocco', 'fes', '9000', '645298385', '1');

INSERT INTO `students` (`student_id`, `student_name`, `student_secondName`, `student_birthday`, `student_gender`, `student_gmail`, `student_email`, `student_password`, `student_cin`, `student_cne`, `student_adress`, `student_country`, `student_city`, `student_postalCode`, `student_phoneNumber`, `field_id`) 
VALUES (NULL, 'amine', 'seddiki', '2022-11-17', 'male', 'amine@gmail.com', 'amine@gmail.com', 'Aseddiki96!', 'CD269360', 'N139149171', '30 rue hay salam fes', 'morocco', 'fes', '9000', '645298385', '1');

INSERT INTO `students` (`student_id`, `student_name`, `student_secondName`, `student_birthday`, `student_gender`, `student_gmail`, `student_email`, `student_password`, `student_cin`, `student_cne`, `student_adress`, `student_country`, `student_city`, `student_postalCode`, `student_phoneNumber`, `field_id`) 
VALUES (NULL, 'yassine', 'seddiki', '2022-11-17', 'male', 'yassine@gmail.com', 'yassine@gmail.com', 'Aseddiki96!', 'CD269360', 'N139149171', '30 rue hay salam fes', 'morocco', 'fes', '9000', '645298385', '1');

INSERT INTO `students` (`student_id`, `student_name`, `student_secondName`, `student_birthday`, `student_gender`, `student_gmail`, `student_email`, `student_password`, `student_cin`, `student_cne`, `student_adress`, `student_country`, `student_city`, `student_postalCode`, `student_phoneNumber`, `field_id`) 
VALUES (NULL, 'ahmed', 'seddiki', '2022-11-17', 'male', 'ahmed@gmail.com', 'ahmed@gmail.com', 'Aseddiki96!', 'CD269360', 'N139149171', '30 rue hay salam fes', 'morocco', 'fes', '9000', '645298385', '2');

INSERT INTO `students` (`student_id`, `student_name`, `student_secondName`, `student_birthday`, `student_gender`, `student_gmail`, `student_email`, `student_password`, `student_cin`, `student_cne`, `student_adress`, `student_country`, `student_city`, `student_postalCode`, `student_phoneNumber`, `field_id`) 
VALUES (NULL, 'kamal', 'seddiki', '2022-11-17', 'male', 'kamal@gmail.com', 'kamal@gmail.com', 'Aseddiki96!', 'CD269360', 'N139149171', '30 rue hay salam fes', 'morocco', 'fes', '9000', '645298385', '2');

-- 

-- Professors
INSERT INTO `professors` (`professor_id`, `professor_name`, `professor_secondName`, `professor_birthday`, `professor_gmail`, `professor_password`, `professor_cin`, `professor_adress`, `professor_country`, `professor_city`, `professor_postalCode`, `professor_phoneNumber`, `departement_id`) 
VALUES (NULL, 'Mohamed', 'Radouane', '2010-11-16', 'mohamed_radouane@gmail.com', 'Aseddiki96!', 'CD269360', '30 rue hay salam fes ', 'morocco', 'fes', '9999', '645298385', '2');

INSERT INTO `professors` (`professor_id`, `professor_name`, `professor_secondName`, `professor_birthday`, `professor_gmail`, `professor_password`, `professor_cin`, `professor_adress`, `professor_country`, `professor_city`, `professor_postalCode`, `professor_phoneNumber`, `departement_id`) 
VALUES (NULL, 'Khalid', 'Nafil', '2000-11-16', 'khalid_nafil@gmail.com', 'Aseddiki96!', 'CD269360', '30 rue hay salam fes ', 'morocco', 'fes', '9999', '645298385', '2');

INSERT INTO `professors` (`professor_id`, `professor_name`, `professor_secondName`, `professor_birthday`, `professor_gmail`, `professor_password`, `professor_cin`, `professor_adress`, `professor_country`, `professor_city`, `professor_postalCode`, `professor_phoneNumber`, `departement_id`) 
VALUES (NULL, 'Nawal', 'Chaouini', '2000-11-16', 'Naoual_chaouni@gmail.com', 'Aseddiki96!', 'CD269360', '30 rue hay salam fes ', 'morocco', 'fes', '9999', '645298385', '2');

-- Moduls 
INSERT INTO `moduls` (`modul_id`, `modul_name`, `modul_abbrevation`, `modul_creationDate`)
VALUES (NULL, 'Sql Server', 'ss', '2022-11-08');

INSERT INTO `moduls` (`modul_id`, `modul_name`, `modul_abbrevation`, `modul_creationDate`) 
VALUES (NULL, 'Administration Windows', 'Aw', '2022-11-08');

INSERT INTO `moduls` (`modul_id`, `modul_name`, `modul_abbrevation`, `modul_creationDate`) 
VALUES (NULL, 'Administration Unix', 'AU', '2022-11-08');

-- PROFESSORS_MODULS 
INSERT INTO `professor_moduls` (`professor_id`, `modul_id`, `affectation_date`)
VALUES  ('1', '1', '2022-11-01'), 
        ('1', '2', '2022-11-02');
INSERT INTO `professor_moduls` (`professor_id`, `modul_id`, `affectation_date`) 
VALUES ('2', '1', '2022-11-17'), ('2', '2', '2022-11-25'), ('2', '3', '2022-11-30'), 
       ('3', '1', '2022-11-30'), ('3', '2', '2022-11-28'), ('3', '3', '2022-11-19');

-- GROUP _ STUDENTS 
INSERT INTO `student_groups` (`student_id`, `group_id`, `affectation_date`) 
VALUES ('1', '1', '2022-11-01'), ('1', '2', '2022-11-16'), ('2', '1', '2022-11-27'), 
      ('2', '2', '2022-11-22'), ('1', '3', '2022-11-12'), ('2', '3', '2022-11-28');

SELECT s.student_id s.student_name , s.student_secondName FROM students s where  s.level_id=1 AND s.field_id=1 AND  s.student_id   not in ( SELECT DISTINCT(student_id) FROM student_groups and group_id=5 ) ;
SELECT f.field_id , f.field_name , f.field_abbreviation  , COUNT(s.field_id) as student_number , COUNT(g.field_id) as group_number FROM fields f , students s , groups g  WHERE f.field_id=1AND  s.field_id=1AND g.field_id=1GROUP BY f.field_id;
SELECT g.group_id , g.group_name , g.group_abbreviation , g.creationDate ,(SELECT f.field_id  FROM  fields f  WHERE  f.field_id = g.field_id ) , (SELECT f.field_abbreviation  FROM  fields f  WHERE  f.field_id = g.field_id ) FROM  groups g ;



<!-- <input type=text  value=<c:out value='${group.group_id}' /> hidden/>
                                <div className=add-group-input-container>
                                <label> Group Name</label>
                                <input type=text name=name value=<c:out value='${group.group_name}' />  disabled/>
                                </div>
                                <div className=add-group-input-container>
                                <label> Select Student    </label> -->

                                 <!-- <c:forEach items=${students} var=${student}  >
                                        <option value=<c:out value='${student.student_id}'  /> > ${student.student_name} </option>
                                    </c:forEach> -->


 SELECT m.modul_id , m.modul_name , m.modul_abbreviation 
                          FROM moduls m   
                          WHERE m.modul_id IN (  
                             SELECT gm.modul_id  
                             FROM group_moduls gm  
                             WHERE gm.group_id IN (  
                                 SELECT g.group_id  
                                 FROM groups g   
                                 WHERE g.level_id IN (   
                                     SELECT s.stuent_id   
                                     FROM students s   
                                     WHERE s.student_id=student_id
                                     )  
                                 )  
                             );

SELECT ga.absence_date ga.absence_hours 
                              FROM group_absences ga 
                              WHERE ga.student_id=1
                              AND ga.modul_id=1

SELECT m.modul_id , m.modul_name , m.modul_abbreviation , m.modul_creationDate  ,   
                      (SELECT COUNT(p.professor_id) 'professors_number' FROM professor_moduls pm WHERE m.modul_id=pm.modul_id) , 
                      (SELECT COUNT(p.group_id) 'groups_number' FROM group_moduls gm WHERE m.modul_id=gm.modul_id) 
                     FROM moduls m  ;

 SELECT DISTINCT(f.field_id , f.field_abbreviation, f.field_name)   
                          FROM fields f  , groups p   
                          WHERE f.field_id = p.field_id
                          AND p.group_in IN (
                          SELECT group_id FROM group_moduls gm WHERE  gm.modul_id = moduls.get(i).getModul_id()  
                         );


 SELECT s.student_id , s.student_cne , s.student_name , s.student_secondName ,   
                          (SELECT l.level_name FROM levels l WHERE l.level_id  = s.level_id ) student_level
                          (SELECT f.field_name FROM fields f WHERE f.field_id = s.field_id) student_field
                          FROM students s 
                          WHERE s.student_id = student_;

SELECT m.modul_name , m.modul_abbreviation , m.modul_id  
                          FROM moduls m   
                          WHERE m.modul_id  IN ( 
                          SELECT m.modul_id
                          FROM group_moduls gm
                          WHERE gm.group_id=group_id
                         ) ;


  SELECT m.modul_id , m.modul_name ,m.modul_abbreviation 
                          FROM moduls m  
                          WHERE m.modul_id IN ( SELECT g.modul_id FROM group_moduls g WHERE g.group_id=1)
                          AND   m.modul_id NOT IN (SELECT gm.modul_id FROM  group_modul_professor gmp WHERE gmp.group_id=1)  ; 


SELECT m.modul_id , m.modul_name , m.modul_abbreviation ,
                         p.professor_id , p.professor_name , p.professor_secondName , p.professor_imagePath   
                         FROM professors p , moduls m , group_modul_professor gmp 
                         WHERE gmp.group_id=1
                         AND   gmp.moul_id=m.modul_id 
                         AND   gmp.professor_id = p.professor_id
                         AND   p.professor_id IN ( SELECT pg.professor_id FROM professor_groups pg WHERE pg.group_id=1)
                         AND   m.modul_id IN ( SELECT gm.modul_id FROM group_moduls gm WHERE gm.group_id=1 )
                     
SELECT code , libelle FROM produits ORDER BY price DESC LIMIT 1 ;

SELECT f.Fref , f.Fdate , c.Cnom , p.libelle , p.prix , l.QTE , (p.prix*l.QTE) as total
FROM   facture f , client c  , produit p , ligne l 
WHERE p.Pcode = f.Pcode 
AND   c.Ccode = f.Ccode 
AND   l.Fref  = f.Fref  
AND   c.ville = "agadir";