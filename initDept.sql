CREATE database citysync;

-- ===========================================================================================================================

INSERT INTO
    `citysync`.`users`(id , email , name , username, password, role , department_id)
VALUES
    (999,'admin@gmail.com','admin','admin','$2a$10$Kk5EMeUstEd3Ykr4zLzcBujImTEoIXHL2z1Dtjq11cvPqf5rfUeca','admin',null);



-- ===========================================================================================================================
INSERT INTO
    `citysync`.`departments` (id, contact_no, description, name)
VALUES
    ('1', '1084', 'Road Construction and Maintenance', 'Public Works Department'),
    ('2', '1081', 'Description for Department of Health', 'Department of Health'),
    ('3', '1082', 'Description for Department of Garbage Collection', 'Department of Garbage Collection');

-- ===========================================================================================================================

INSERT INTO
    `citysync`.`users` (department_id, id, email, name, password, role, username)
VALUES
    ('1', '1', 'user@gmail.com', 'user', '$2a$10$dm7yhx4IpIXJ4Plc3cMdVuo0rnMTWuzALAEFv4mLF2ez40Jc2pG9K', 'USER', 'user'),
    ('2', '2', 'user2@gmail.com', 'user2', '$2a$10$nFdviG20VyapnrNea6xud.XVclxw5nj2ft4jLXcsMYqjxu8mLOiJu', 'USER', 'user2'),
    ('3', '3', 'user3@gmail.com', 'user3', '$2a$10$oOQL1GbGEGY4GTSHigERvuWP54dtcVq8WGHQ3VJ3rHuDxKHLmJV2C', 'USER', 'user3');

-- ==================================TRIGGER===================================================================================

DELIMITER $$
CREATE TRIGGER update_pooled_quantity
    AFTER UPDATE
    ON resources
    FOR EACH ROW
BEGIN
    INSERT INTO resource_pool(resource, pooled_quantity)
    VALUES(OLD.id , (NEW.allotted_quantity - NEW.used_quantity));
    END$$
    DELIMITER ;