INSERT INTO users (userName,encoded_password,password_hint) values
('Darcy','$2a$10$BRMZmPOOaLp5ksyMZMY8rOCphXq8xZtgcsi8svVIeSQnEVMp4LY0a','password'),
('Boss', '$2a$10$BRMZmPOOaLp5ksyMZMY8rOCphXq8xZtgcsi8svVIeSQnEVMp4LY0a','password'),
('Staff','$2a$10$BRMZmPOOaLp5ksyMZMY8rOCphXq8xZtgcsi8svVIeSQnEVMp4LY0a','password');

INSERT INTO authorities (permission) values
('ROLE_ADMIN'),
('ROLE_BOSS'),
('ROLE_STAFF');

INSERT INTO users_authorities(user_id,authority_id)
SELECT users.id,authorities.id FROM users,authorities
WHERE users.userName = 'Darcy' and Authorities.permission = 'ROLE_ADMIN';

INSERT INTO users_authorities(user_id,authority_id)
SELECT users.id,authorities.id FROM users,authorities
WHERE users.userName = 'Boss' and Authorities.permission = 'ROLE_BOSS';

INSERT INTO users_authorities(user_id,authority_id)
SELECT users.id,authorities.id FROM users,authorities
WHERE users.userName = 'Staff' and Authorities.permission = 'ROLE_STAFF';



