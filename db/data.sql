-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               9.0.1 - MySQL Community Server - GPL
-- Server OS:                    Linux
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for crowdfund_db
CREATE DATABASE IF NOT EXISTS `crowdfund_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `crowdfund_db`;

-- Dumping structure for table crowdfund_db.payments
CREATE TABLE IF NOT EXISTS `payments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `payment_date` datetime(6) NOT NULL,
  `project_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7h0as5hqhn845eewc7usiy0x3` (`project_id`),
  KEY `FKj94hgy9v5fw1munb90tar2eje` (`user_id`),
  CONSTRAINT `FK7h0as5hqhn845eewc7usiy0x3` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  CONSTRAINT `FKj94hgy9v5fw1munb90tar2eje` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table crowdfund_db.payments: ~13 rows (approximately)
INSERT INTO `payments` (`id`, `amount`, `payment_date`, `project_id`, `user_id`) VALUES
	(1, 50, '2024-09-25 16:15:00.000000', 1, 2),
	(2, 75.5, '2024-09-26 12:30:00.000000', 1, 2),
	(3, 100, '2024-09-27 11:45:00.000000', 1, 3),
	(4, 150, '2024-09-28 13:00:00.000000', 1, 3),
	(5, 200, '2024-09-29 14:15:00.000000', 1, 4),
	(6, 80, '2024-09-30 15:30:00.000000', 1, 5),
	(7, 60, '2024-10-01 16:45:00.000000', 1, 4),
	(8, 90, '2024-10-02 17:00:00.000000', 1, 5),
	(9, 110, '2024-10-03 18:20:00.000000', 1, 5),
	(10, 125, '2024-10-04 19:40:00.000000', 2, 5),
	(11, 1, '2024-11-30 19:48:05.267000', 1, 1),
	(12, 150, '2024-11-30 19:48:44.989000', 1, 1),
	(13, 10, '2024-11-30 19:49:06.335000', 1, 1),
	(14, 1, '2024-11-30 19:51:45.643000', 1, 1),
	(15, 15, '2024-11-30 19:57:34.473000', 1, 1),
	(16, 25, '2024-12-01 22:42:15.067000', 7, 1);

-- Dumping structure for table crowdfund_db.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` text,
  `funding_goal` float NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `money_raised` float NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `percentage_funded` double GENERATED ALWAYS AS (((`money_raised` / `funding_goal`) * 100)) VIRTUAL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhswfwa3ga88vxv1pmboss6jhm` (`user_id`),
  CONSTRAINT `FKhswfwa3ga88vxv1pmboss6jhm` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table crowdfund_db.projects: ~7 rows (approximately)
INSERT INTO `projects` (`id`, `date_created`, `description`, `funding_goal`, `location`, `money_raised`, `name`, `type`, `user_id`) VALUES
	(1, '2024-09-15 12:00:00', 'This initiative focuses on establishing a sustainable community garden designed to address multiple issues such as food insecurity, urban environmental challenges, and community engagement. By transforming vacant lots and underutilized urban spaces into vibrant, productive gardens, the project aims to provide fresh, organic produce to local families while promoting environmentally friendly practices. Educational workshops will teach residents about composting, crop rotation, and organic pest control, empowering them to grow their own food and reduce their carbon footprint. Additionally, the garden will serve as a hub for community interaction, fostering stronger social ties and offering opportunities for volunteerism, skill-sharing, and outdoor recreation.', 12000, 'Downtown Area', 1742.75, 'Community Garden Project', 'Environment', 1),
	(2, '2024-09-20 13:30:00', 'This fundraiser is dedicated to transforming the school library into a modern learning center that meets the diverse needs of students in the 21st century. With the funds raised, the project will renovate the library\'s physical space, creating dedicated zones for collaborative work, quiet study, and digital learning. A significant portion of the funds will go toward expanding the collection of books, e-books, and audiobooks, ensuring students have access to a wide range of educational and recreational materials. Additionally, new technology, including tablets, computers, and interactive whiteboards, will be introduced to enhance the learning experience. The project also aims to host literacy programs, author visits, and workshops to inspire a lifelong love of reading and learning among students.', 5000, 'Springfield High School', 125, 'School Library Fundraiser', 'Education', 2),
	(3, '2024-09-25 16:15:00', 'This vital initiative addresses the urgent need for access to clean and safe drinking water in communities that suffer from contaminated or insufficient water supplies. The project plans to implement sustainable water solutions, including drilling wells, installing filtration systems, and repairing existing infrastructure. Beyond providing immediate access to potable water, the initiative will educate community members on proper sanitation practices, water conservation, and maintenance of the systems to ensure long-term success. By targeting rural and underserved regions, the program seeks to drastically reduce waterborne diseases, improve overall health outcomes, and enhance the quality of life for thousands of people. This initiative underscores the belief that access to clean water is a fundamental human right, and it aims to create lasting change for future generations.', 20000, 'Various Locations', 15000, 'Clean Water Initiative', 'Health', 3),
	(4, '2024-09-30 11:45:00', 'This comprehensive renovation project seeks to transform the local animal shelter into a state-of-the-art facility that can better meet the needs of rescued animals and the community. The proposed upgrades include replacing outdated kennels with spacious, climate-controlled units to provide comfort and safety for the animals. Veterinary facilities will be expanded and modernized to allow for on-site medical care and spay/neuter programs. Outdoor exercise and play areas will be developed to promote the animals’ physical and emotional well-being, and a new adoption center will create a welcoming environment for prospective pet owners. The project will also introduce community outreach programs to raise awareness about responsible pet ownership and support the shelter\'s mission of finding loving homes for every animal in their care.', 15000, 'Animal Shelter, City Center', 0, 'Animal Shelter Renovation', 'Animal Welfare', 4),
	(5, '2024-10-05 14:00:00', 'This forward-thinking campaign is dedicated to accelerating the adoption of renewable energy technologies across the community, with a focus on sustainability, cost savings, and environmental impact. The project plans to install solar panels on public buildings, provide subsidies for residential solar systems, and introduce community wind and geothermal projects to reduce dependency on fossil fuels. Educational workshops and seminars will be conducted to inform residents about the benefits of renewable energy, including long-term savings and reduced carbon emissions. Additionally, the campaign aims to collaborate with local businesses and policymakers to create incentives for adopting green energy solutions. By fostering a culture of sustainability, the project envisions a future where renewable energy is not only accessible but also embraced as the norm in every household and organization in the community.', 25000, 'Citywide', 0, 'Renewable Energy Campaign', 'Energy', 5),
	(6, '2024-09-20 11:30:00', 'This initiative seeks to transform underutilized urban spaces into thriving community gardens. The project will create green spaces in vacant lots, rooftops, and public parks, providing residents with the opportunity to grow their own fruits and vegetables, fostering a sense of community, and promoting environmental sustainability. Workshops on urban farming, composting, and sustainable agriculture will be organized to educate participants about cultivating healthy, organic produce. In addition to improving food security, the initiative aims to address urban heat islands and enhance air quality. Collaborations with local schools will incorporate gardening into educational curriculums, instilling environmental consciousness in young minds. The project\'s ultimate goal is to create a network of urban gardens that supply fresh produce to the community while promoting healthy lifestyles and environmental stewardship.', 15000, 'Downtown District', 0, 'Urban Gardening Initiative', 'Community Development', 1),
	(7, '2024-11-10 16:45:00', 'This program is designed to bridge the digital divide by equipping underprivileged youth with essential technological skills. The project will provide free access to laptops, software, and internet connectivity, ensuring students have the tools needed to succeed in an increasingly tech-driven world. Through coding bootcamps, robotics workshops, and digital literacy courses, participants will gain hands-on experience in cutting-edge technologies such as artificial intelligence, web development, and data science. The program also aims to offer mentorship opportunities with industry professionals and internships at local tech companies, paving the way for future career opportunities. By empowering young minds with tech skills, this initiative envisions a more inclusive and digitally proficient community.', 30000, 'Eastside Neighborhood', 25, 'Youth Tech Empowerment Program', 'Education', 1);

-- Dumping structure for table crowdfund_db.project_images
CREATE TABLE IF NOT EXISTS `project_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image_order` int NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `project_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoej10untas4roy2rqxcmbdj42` (`project_id`),
  CONSTRAINT `FKoej10untas4roy2rqxcmbdj42` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table crowdfund_db.project_images: ~21 rows (approximately)
INSERT INTO `project_images` (`id`, `image_order`, `image_url`, `project_id`) VALUES
	(1, 1, 'https://placehold.co/600x400?text=p1.1', 1),
	(2, 2, 'https://placehold.co/600x400?text=p1.2', 1),
	(3, 3, 'https://placehold.co/600x400?text=p1.3', 1),
	(4, 1, 'https://placehold.co/600x400?text=p2.1', 2),
	(5, 2, 'https://placehold.co/600x400?text=p2.2', 2),
	(6, 3, 'https://placehold.co/600x400?text=p2.3', 2),
	(7, 1, 'https://placehold.co/600x400?text=p3.1', 3),
	(8, 2, 'https://placehold.co/600x400?text=p3.2', 3),
	(9, 3, 'https://placehold.co/600x400?text=p3.3', 3),
	(10, 1, 'https://placehold.co/600x400?text=p4.1', 4),
	(11, 2, 'https://placehold.co/600x400?text=p4.2', 4),
	(12, 3, 'https://placehold.co/600x400?text=p4.3', 4),
	(13, 1, 'https://placehold.co/600x400?text=p5.1', 5),
	(14, 2, 'https://placehold.co/600x400?text=p5.2', 5),
	(15, 3, 'https://placehold.co/600x400?text=p5.3', 5),
	(16, 1, 'https://placehold.co/600x400?text=p6.1', 6),
	(17, 2, 'https://placehold.co/600x400?text=p6.2', 6),
	(18, 3, 'https://placehold.co/600x400?text=p6.3', 6),
	(19, 1, 'https://placehold.co/600x400?text=p7.1', 7),
	(20, 2, 'https://placehold.co/600x400?text=p7.2', 7),
	(21, 3, 'https://placehold.co/600x400?text=p7.3', 7);

-- Dumping structure for table crowdfund_db.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile_picture` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table crowdfund_db.users: ~6 rows (approximately)
INSERT INTO `users` (`id`, `email`, `name`, `password`, `profile_picture`, `role`) VALUES
	(1, 'user@example.com', 'Matthew Stone', '$2a$10$lzA58GjJKsdTF4kW0ECW0OjM3OMXMlLMHmCLZ31zg/LaBSPt98GhO', 'https://avatar.iran.liara.run/public', 'user'),
	(2, 'emilyjohnson@example.com', 'Emily Johnson', '$2a$10$8joaASWeJWGr.X8y31g0X.IJnmYixv2ANwIaHftw3Lu7pu/QTClbq', 'https://avatar.iran.liara.run/public', 'user'),
	(3, 'michaelbrown@example.com', 'Michael Brown', '$2a$10$mafApnlvJjdsD2MMCz0cp.kNr3MBNP0BJRajc2lXnyn4sRU4oIFjy', 'https://avatar.iran.liara.run/public', 'user'),
	(4, 'sophiadavis@example.com', 'Sophia Davis', '$2a$10$DSHXnKXg3qlf5fXDaeHj3e6Aq.iNdCxff1lA0.ErMkp/XE7lg0phC', 'https://avatar.iran.liara.run/public', 'user'),
	(5, 'jameswilson@example.com', 'James Wilson', '$2a$10$n9P7Yx4iKOD9jDXGrd205OjpzSmVBhkr.crFy/2mzSD2pt20ssis2', 'https://avatar.iran.liara.run/public', 'user'),
	(6, 'admin@example.com', 'The Admin', '$2a$10$Pl4NfZP5D0DFBOeVusmM5.iK0M3JmgXi0nVRQI.fQzPUkS2w2CU2O', 'https://avatar.iran.liara.run/public', 'admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
