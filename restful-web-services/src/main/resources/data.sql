INSERT INTO user_details(Birthdate,id,name)
VALUES(current_date(),1001,'superman'),
       (current_date(),1002,'batman'),
       (current_date(),1003,'hulk'),
       (current_date(),1004,'thor'),
       (current_date(),1005,'ultron');

       
INSERT INTO Post(id,description,user_id)
VALUES(2001,'i want to learn spring boot',1001),
      (2002,'i want to learn spring ',1001),
      (2003,'i want to learn aws',1002),
      (2004,'i want to learn hibernate and jpa',1003),
      (2005,'i want to learn spring security',1004),
      (2006,'i want to learn spring cloud',1005),
      (2007,'i want to learn spring microservices',1005);
      