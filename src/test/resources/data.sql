-- USERS table
DROP TABLE IF EXISTS users;
CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(255),
                       name VARCHAR(255),
                       password VARCHAR(255),
                       profile_picture VARCHAR(255) NOT NULL,
                       role VARCHAR(255) NOT NULL
);

-- PROJECTS table
DROP TABLE IF EXISTS projects;
CREATE TABLE projects (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          description TEXT,
                          funding_goal FLOAT NOT NULL,
                          location VARCHAR(255),
                          money_raised FLOAT NOT NULL,
                          name VARCHAR(255),
                          type VARCHAR(255),
                          user_id INT,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

-- PAYMENTS table
DROP TABLE IF EXISTS payments;
CREATE TABLE payments (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          amount FLOAT NOT NULL,
                          payment_date TIMESTAMP NOT NULL,
                          project_id INT,
                          user_id INT,
                          FOREIGN KEY (project_id) REFERENCES projects(id),
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

-- PROJECT_IMAGES table
DROP TABLE IF EXISTS project_images;
CREATE TABLE project_images (
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                image_order INT NOT NULL,
                                image_url VARCHAR(255),
                                project_id INT,
                                FOREIGN KEY (project_id) REFERENCES projects(id)
);

-- Insert into USERS
INSERT INTO USERS (id, email, name, password, profile_picture, role) VALUES (1, 'user@example.com', 'Matthew Stone', '$2a$10$ZRBvWF4BwgJmLnWC4n/6POeMbWGa69OgKLk.Wp1r81ObPjYFGOIxS', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (2, 'emilyjohnson@example.com', 'Emily Johnson', '$2a$10$WPTxtcRvZTAC8aghbt3FT.toOnNI6DLT5iXJFoGQnjpNxkJ6A58OC', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (3, 'michaelbrown@example.com', 'Michael Brown', '$2a$10$O8lg9et43FeaQEZXDP0mquUYBGv2uCUGDeV5q3UV/QnooeTzrXSie', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (4, 'sophiadavis@example.com', 'Sophia Davis', '$2a$10$xd.mTht3m4KYKbiyHpbHI.8Sjyz8h6li4eIVgvCcvO5pwAeVvc3im', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (5, 'jameswilson@example.com', 'James Wilson', '$2a$10$6ymyhl7Qrv9DjWgf20fTAuab0Otwtqz0PEuxg5VcgKjTeQuMxAkbe', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (6, 'admin@example.com', 'The Admin', '$2a$10$QgMs6MACwOtRCCPsaud2heiOW/YIoerwwfsBkesRcNT91iBGBrtEe', 'https://avatar.iran.liara.run/public', 'admin');

-- Insert into PROJECTS
INSERT INTO projects (id, date_created, description, funding_goal, location, money_raised, name, type, user_id) VALUES (1, '2024-09-15 12:00:00', 'This initiative focuses on establishing a sustainable community garden...', 12000, 'Downtown Area', 6543, 'Community Garden Project', 'Environment', 1);
INSERT INTO projects (id, date_created, description, funding_goal, location, money_raised, name, type, user_id) VALUES (2, '2024-09-20 13:30:00', 'This fundraiser is dedicated to transforming the school library...', 5000, 'Springfield High School', 0, 'School Library Fundraiser', 'Education', 2);

-- Insert into PAYMENTS
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (1,  50, '2024-09-25 16:15:00', 1, 2);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES  (2, 75.5, '2024-09-26 12:30:00', 1, 2);

-- Insert into PROJECT_IMAGES
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (1, 1, 'https://placehold.co/600x400?text=p1.1', 1);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (2, 2, 'https://placehold.co/600x400?text=p1.2', 1);
