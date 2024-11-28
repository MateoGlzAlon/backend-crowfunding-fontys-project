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