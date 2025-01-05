CREATE DATABASE commerce_db CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'commerce_admin'@'%' IDENTIFIED BY 'commerceadmin12!@';
GRANT ALL PRIVILEGES ON commerce_db.* TO 'commerce_admin'@'%';
FLUSH PRIVILEGES;