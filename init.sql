CREATE DATABASE mercado_db CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'mercado_admin'@'%' IDENTIFIED BY 'mercadoadmin12!@';
GRANT ALL PRIVILEGES ON mercado_db.* TO 'mercado_admin'@'%';
FLUSH PRIVILEGES;