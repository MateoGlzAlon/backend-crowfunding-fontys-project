-- Insert into Payments
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (1, 50, '2024-09-25 16:15:00.000000', 1, 2);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (2, 75.5, '2024-09-26 12:30:00.000000', 1, 2);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (3, 100, '2024-09-27 11:45:00.000000', 1, 3);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (4, 150, '2024-09-28 13:00:00.000000', 1, 3);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (5, 200, '2024-09-29 14:15:00.000000', 1, 4);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (6, 80, '2024-09-30 15:30:00.000000', 1, 5);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (7, 60, '2024-10-01 16:45:00.000000', 1, 4);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (8, 90, '2024-10-02 17:00:00.000000', 1, 5);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (9, 110, '2024-10-03 18:20:00.000000', 1, 5);
INSERT INTO payments (id, amount, payment_date, project_id, user_id) VALUES (10, 125, '2024-10-04 19:40:00.000000', 2, 5);

-- Insert into Projects
INSERT INTO projects (id, date_created, description, funding_goal, location, money_raised, name, type, user_id) VALUES (1, '2024-09-15 12:00:00', 'This initiative focuses on establishing a sustainable community garden designed to address multiple issues such as food insecurity, urban environmental challenges, and community engagement. By transforming vacant lots and underutilized urban spaces into vibrant, productive gardens, the project aims to provide fresh, organic produce to local families while promoting environmentally friendly practices. Educational workshops will teach residents about composting, crop rotation, and organic pest control, empowering them to grow their own food and reduce their carbon footprint. Additionally, the garden will serve as a hub for community interaction, fostering stronger social ties and offering opportunities for volunteerism, skill-sharing, and outdoor recreation.', 12000, 'Downtown Area', 6543, 'Community Garden Project', 'Environment', 1);
INSERT INTO projects (id, date_created, description, funding_goal, location, money_raised, name, type, user_id) VALUES (2, '2024-09-20 13:30:00', 'This fundraiser is dedicated to transforming the school library into a modern learning center that meets the diverse needs of students in the 21st century. With the funds raised, the project will renovate the library\'s physical space, creating dedicated zones for collaborative work, quiet study, and digital learning. A significant portion of the funds will go toward expanding the collection of books, e-books, and audiobooks, ensuring students have access to a wide range of educational and recreational materials. Additionally, new technology, including tablets, computers, and interactive whiteboards, will be introduced to enhance the learning experience. The project also aims to host literacy programs, author visits, and workshops to inspire a lifelong love of reading and learning among students.', 5000, 'Springfield High School', 0, 'School Library Fundraiser', 'Education', 2);
INSERT INTO projects (id, date_created, description, funding_goal, location, money_raised, name, type, user_id) VALUES (3, '2024-09-25 16:15:00', 'This vital initiative addresses the urgent need for access to clean and safe drinking water in communities that suffer from contaminated or insufficient water supplies. The project plans to implement sustainable water solutions, including drilling wells, installing filtration systems, and repairing existing infrastructure. Beyond providing immediate access to potable water, the initiative will educate community members on proper sanitation practices, water conservation, and maintenance of the systems to ensure long-term success. By targeting rural and underserved regions, the program seeks to drastically reduce waterborne diseases, improve overall health outcomes, and enhance the quality of life for thousands of people. This initiative underscores the belief that access to clean water is a fundamental human right, and it aims to create lasting change for future generations.', 20000, 'Various Locations', 0, 'Clean Water Initiative', 'Health', 3);
INSERT INTO projects (id, date_created, description, funding_goal, location, money_raised, name, type, user_id) VALUES (4, '2024-09-30 11:45:00', 'This comprehensive renovation project seeks to transform the local animal shelter into a state-of-the-art facility that can better meet the needs of rescued animals and the community. The proposed upgrades include replacing outdated kennels with spacious, climate-controlled units to provide comfort and safety for the animals. Veterinary facilities will be expanded and modernized to allow for on-site medical care and spay/neuter programs. Outdoor exercise and play areas will be developed to promote the animals’ physical and emotional well-being, and a new adoption center will create a welcoming environment for prospective pet owners. The project will also introduce community outreach programs to raise awareness about responsible pet ownership and support the shelter\'s mission of finding loving homes for every animal in their care.', 15000, 'Animal Shelter, City Center', 0, 'Animal Shelter Renovation', 'Animal Welfare', 4);
INSERT INTO projects (id, date_created, description, funding_goal, location, money_raised, name, type, user_id) VALUES (5, '2024-10-05 14:00:00', 'This forward-thinking campaign is dedicated to accelerating the adoption of renewable energy technologies across the community, with a focus on sustainability, cost savings, and environmental impact. The project plans to install solar panels on public buildings, provide subsidies for residential solar systems, and introduce community wind and geothermal projects to reduce dependency on fossil fuels. Educational workshops and seminars will be conducted to inform residents about the benefits of renewable energy, including long-term savings and reduced carbon emissions. Additionally, the campaign aims to collaborate with local businesses and policymakers to create incentives for adopting green energy solutions. By fostering a culture of sustainability, the project envisions a future where renewable energy is not only accessible but also embraced as the norm in every household and organization in the community.', 25000, 'Citywide', 0, 'Renewable Energy Campaign', 'Energy', 5);

-- Insert into Project Images
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (1, 1, 'https://placehold.co/600x400?text=p1.1', 1);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (2, 2, 'https://placehold.co/600x400?text=p1.2', 1);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (3, 3, 'https://placehold.co/600x400?text=p1.3', 1);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (4, 1, 'https://placehold.co/600x400?text=p2.1', 2);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (5, 2, 'https://placehold.co/600x400?text=p2.2', 2);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (6, 3, 'https://placehold.co/600x400?text=p2.3', 2);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (7, 1, 'https://placehold.co/600x400?text=p3.1', 3);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (8, 2, 'https://placehold.co/600x400?text=p3.2', 3);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (9, 3, 'https://placehold.co/600x400?text=p3.3', 3);
INSERT INTO project_images (id, image_order, image_url, project_id) VALUES (10, 1, 'https://placehold.co/600x400?text=p4.1', 4);

-- Insert into Users
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (1, 'user@example.com', 'Matthew Stone', '$2a$10$ZRBvWF4BwgJmLnWC4n/6POeMbWGa69OgKLk.Wp1r81ObPjYFGOIxS', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (2, 'emilyjohnson@example.com', 'Emily Johnson', '$2a$10$WPTxtcRvZTAC8aghbt3FT.toOnNI6DLT5iXJFoGQnjpNxkJ6A58OC', 'https://avatar.iran.liara.run/public', 'user'),;
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (3, 'michaelbrown@example.com', 'Michael Brown', '$2a$10$O8lg9et43FeaQEZXDP0mquUYBGv2uCUGDeV5q3UV/QnooeTzrXSie', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (4, 'sophiadavis@example.com', 'Sophia Davis', '$2a$10$xd.mTht3m4KYKbiyHpbHI.8Sjyz8h6li4eIVgvCcvO5pwAeVvc3im', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (5, 'jameswilson@example.com', 'James Wilson', '$2a$10$6ymyhl7Qrv9DjWgf20fTAuab0Otwtqz0PEuxg5VcgKjTeQuMxAkbe', 'https://avatar.iran.liara.run/public', 'user');
INSERT INTO users (id, email, name, password, profile_picture, role) VALUES (6, 'admin@example.com', 'The Admin', '$2a$10$QgMs6MACwOtRCCPsaud2heiOW/YIoerwwfsBkesRcNT91iBGBrtEe', 'https://avatar.iran.liara.run/public', 'admin');