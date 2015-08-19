
  
 DELIMITER //
CREATE PROCEDURE  insertEvent(IN title VARCHAR(30),IN description TEXT,IN Edate Date,IN photo TEXT,IN dir VARCHAR(50))
BEGIN
 INSERT INTO event(event_title,event_desc,event_date,event_photo,event_dir)
 VALUES(title,description,Edate,photo,dir);
  END// 
  DELIMITER ; 
  
    DELIMITER //
CREATE PROCEDURE getAllEvent()
BEGIN
SELECT *
FROM event;
  END//
  DELIMITER ;
  
   DELIMITER //
CREATE PROCEDURE  deleteEvent(IN userId INT)
BEGIN
DELETE 
FROM user
WHERE user_id=userId;	
  END// 
  DELIMITER ; 
  
    DELIMITER //
CREATE PROCEDURE  updateEvent(IN userId INT,IN name VARCHAR(30),IN email VARCHAR(30))
BEGIN
UPDATE user 
SET user_name=name, user_email=email
WHERE user_id=userId ;	
  END// 
  DELIMITER ; 
  

  