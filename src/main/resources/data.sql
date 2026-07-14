-- Seed Departments
INSERT IGNORE INTO departments (id, contact_no, description, name) VALUES
(1, '1084', 'Road Construction and Maintenance', 'Public Works Department'),
(2, '1081', 'Description for Department of Health', 'Department of Health'),
(3, '1082', 'Description for Department of Garbage Collection', 'Department of Garbage Collection');

-- Seed Users
-- admin password is '$2a$10$Kk5EMeUstEd3Ykr4zLzcBujImTEoIXHL2z1Dtjq11cvPqf5rfUeca' (decrypts to 'admin')
-- user password is '$2a$10$dm7yhx4IpIXJ4Plc3cMdVuo0rnMTWuzALAEFv4mLF2ez40Jc2pG9K' (decrypts to 'user')
-- user2 password is '$2a$10$nFdviG20VyapnrNea6xud.XVclxw5nj2ft4jLXcsMYqjxu8mLOiJu' (decrypts to 'user2')
-- user3 password is '$2a$10$oOQL1GbGEGY4GTSHigERvuWP54dtcVq8WGHQ3VJ3rHuDxKHLmJV2C' (decrypts to 'user3')
INSERT IGNORE INTO users (id, email, name, username, password, role, department_id) VALUES
(999, 'admin@gmail.com', 'admin', 'admin', '$2a$10$Kk5EMeUstEd3Ykr4zLzcBujImTEoIXHL2z1Dtjq11cvPqf5rfUeca', 'admin', NULL),
(1, 'user@gmail.com', 'user', 'user', '$2a$10$dm7yhx4IpIXJ4Plc3cMdVuo0rnMTWuzALAEFv4mLF2ez40Jc2pG9K', 'USER', 1),
(2, 'user2@gmail.com', 'user2', 'user2', '$2a$10$nFdviG20VyapnrNea6xud.XVclxw5nj2ft4jLXcsMYqjxu8mLOiJu', 'USER', 2),
(3, 'user3@gmail.com', 'user3', 'user3', '$2a$10$oOQL1GbGEGY4GTSHigERvuWP54dtcVq8WGHQ3VJ3rHuDxKHLmJV2C', 'USER', 3);

