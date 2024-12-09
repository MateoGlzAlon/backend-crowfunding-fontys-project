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
  CONSTRAINT `FK7h0as5hqhn845eewc7usiy0x3` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table crowdfund_db.payments: ~11 rows (approximately)
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
	(11, 15, '2024-12-09 10:11:45.737000', 1, 1);

-- Dumping structure for table crowdfund_db.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` text,
  `funding_goal` float NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `money_raised` float NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `percentage_funded` double GENERATED ALWAYS AS (((`money_raised` / `funding_goal`) * 100)) VIRTUAL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhswfwa3ga88vxv1pmboss6jhm` (`user_id`),
  CONSTRAINT `FKhswfwa3ga88vxv1pmboss6jhm` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table crowdfund_db.projects: ~6 rows (approximately)
INSERT INTO `projects` (`id`, `name`, `date_created`, `description`, `funding_goal`, `location`, `money_raised`, `type`, `user_id`) VALUES
	(1, 'Community Garden Project', '2024-09-15 12:00:00', 'This initiative focuses on establishing a sustainable community garden designed to address multiple issues such as food insecurity, urban environmental challenges, and community engagement. By transforming vacant lots and underutilized urban spaces into vibrant, productive gardens, the project aims to provide fresh, organic produce to local families while promoting environmentally friendly practices. Educational workshops will teach residents about composting, crop rotation, and organic pest control, empowering them to grow their own food and reduce their carbon footprint. Additionally, the garden will serve as a hub for community interaction, fostering stronger social ties and offering opportunities for volunteerism, skill-sharing, and outdoor recreation.', 12000, 'Downtown Area', 930.5, 'Environment', 1),
	(2, 'School Library Fundraiser', '2024-09-20 13:30:00', 'This fundraiser is dedicated to transforming the school library into a modern learning center that meets the diverse needs of students in the 21st century. With the funds raised, the project will renovate the library\'s physical space, creating dedicated zones for collaborative work, quiet study, and digital learning. A significant portion of the funds will go toward expanding the collection of books, e-books, and audiobooks, ensuring students have access to a wide range of educational and recreational materials. Additionally, new technology, including tablets, computers, and interactive whiteboards, will be introduced to enhance the learning experience. The project also aims to host literacy programs, author visits, and workshops to inspire a lifelong love of reading and learning among students.', 5000, 'Springfield High School', 125, 'Education', 1),
	(3, 'Clean Water Initiative', '2024-09-25 16:15:00', 'This vital initiative addresses the urgent need for access to clean and safe drinking water in communities that suffer from contaminated or insufficient water supplies. The project plans to implement sustainable water solutions, including drilling wells, installing filtration systems, and repairing existing infrastructure. Beyond providing immediate access to potable water, the initiative will educate community members on proper sanitation practices, water conservation, and maintenance of the systems to ensure long-term success. By targeting rural and underserved regions, the program seeks to drastically reduce waterborne diseases, improve overall health outcomes, and enhance the quality of life for thousands of people. This initiative underscores the belief that access to clean water is a fundamental human right, and it aims to create lasting change for future generations.', 20000, 'Various Locations', 0, 'Health', 2),
	(5, 'Renewable Energy Campaign', '2024-10-05 14:00:00', 'This forward-thinking campaign is dedicated to accelerating the adoption of renewable energy technologies across the community, with a focus on sustainability, cost savings, and environmental impact. The project plans to install solar panels on public buildings, provide subsidies for residential solar systems, and introduce community wind and geothermal projects to reduce dependency on fossil fuels. Educational workshops and seminars will be conducted to inform residents about the benefits of renewable energy, including long-term savings and reduced carbon emissions. Additionally, the campaign aims to collaborate with local businesses and policymakers to create incentives for adopting green energy solutions. By fostering a culture of sustainability, the project envisions a future where renewable energy is not only accessible but also embraced as the norm in every household and organization in the community.', 25000, 'Citywide', 0, 'Energy', 4),
	(6, 'Tech for All Initiative', '2024-12-08 01:55:32', 'This innovative campaign focuses on bridging the digital divide by providing access to technology, digital literacy training, and career development resources to underserved communities. The project aims to distribute refurbished laptops, offer free coding and software development bootcamps, and create mentorship programs connecting tech professionals with aspiring students. Public tech hubs equipped with high-speed internet and learning materials will be established in local libraries and community centers. In collaboration with educational institutions and tech companies, the campaign will facilitate job placement programs and internships to empower individuals with employable digital skills. By fostering tech inclusivity, the project envisions a future where technological advancement is a shared opportunity for all.', 30000, 'Community Centers and Schools', 0, 'Education', 1),
	(7, 'Green City Gardens Project', '2024-12-08 01:56:28', 'This eco-friendly campaign aims to transform underutilized urban spaces into thriving community gardens, promoting food security, sustainability, and environmental stewardship. The project will establish rooftop gardens, vertical farms, and community plots where residents can grow fruits, vegetables, and herbs. Workshops on organic farming, composting, and water conservation will be conducted to educate participants on sustainable gardening practices. The initiative plans to partner with local restaurants, schools, and community organizations to distribute surplus produce and reduce food waste. By fostering a culture of urban agriculture, the project envisions greener neighborhoods, healthier diets, and stronger community bonds through shared gardening experiences.', 8000, 'Urban Neighborhoods and Public Spaces', 0, 'Environment', 1);

-- Dumping structure for table crowdfund_db.project_images
CREATE TABLE IF NOT EXISTS `project_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image_order` int NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `project_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoej10untas4roy2rqxcmbdj42` (`project_id`),
  CONSTRAINT `FKoej10untas4roy2rqxcmbdj42` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table crowdfund_db.project_images: ~16 rows (approximately)
INSERT INTO `project_images` (`id`, `image_order`, `image_url`, `project_id`) VALUES
	(1, 1, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/community-garden-1.jpg', 1),
	(2, 2, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/community-garden-2.jpg', 1),
	(3, 3, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/community-garden-3.jpg', 1),
	(4, 1, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/school-library-1.jpg', 2),
	(5, 2, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/school-library-2.jpg', 2),
	(6, 1, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/clean-water-1.png', 3),
	(7, 2, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/clean-water-2.jpg', 3),
	(8, 3, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/clean-water-3.jpg', 3),
	(11, 1, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/renewable-energy-1.jpg', 5),
	(12, 2, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/renewable-energy-2.webp', 5),
	(16, 1, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/01d7ba7683552438f121d27552193424b11f57e6e568dde00ba8792feecb17bd', 6),
	(17, 3, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/fdac2894253ebe972e098e94aad6fa028435d63dba6b308849ff7e67fd6da980', 7),
	(18, 1, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/0d584c7016d7d722ff9f0b62eba4245b7647de9636e8a738669ca77e6d47ed52', 7),
	(19, 2, 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/f60c94be8315b7ec442c90b04096e0509d22cf7ccb6de25404fa1be4f75593a3', 7);

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

-- Dumping data for table crowdfund_db.users: ~5 rows (approximately)
INSERT INTO `users` (`id`, `email`, `name`, `password`, `profile_picture`, `role`) VALUES
	(1, 'user@example.com', 'Matthew Stone', '$2a$10$tayjd4zSddcQfK6aa8NfGuiZNNcKhoog.evBJr78hIaZYRwqh8Am2', 'https://raisehub-crowdfunding-bucket.s3.eu-west-3.amazonaws.com/6be5b05f00bd748bb65a13718ff4d8b19b4082488e573729d692f5427486ae1e', 'user'),
	(2, 'emilyjohnson@example.com', 'Emily Johnson', '$2a$10$z7VycO.GbEroJXl.sQTTSO2pOdw6IWyC16QUeAYZGaUTj/YKnl0Lm', 'https://avatar.iran.liara.run/public', 'user'),
	(4, 'sophiadavis@example.com', 'Sophia Davis', '$2a$10$eJ06/tu4u5pi70O1vaGscOko8lw83r3dUdOsxDRp.HRDrthyG5LRi', 'https://avatar.iran.liara.run/public', 'user'),
	(5, 'jameswilson@example.com', 'James Wilson', '$2a$10$Ce0ipA5wFckulTIEHpQkV.AEqVoIGQxDGUVLsG3fbybr8BYN.sBw6', 'https://avatar.iran.liara.run/public', 'user'),
	(6, 'admin@example.com', 'The Admin', '$2a$10$pat943w6Gu9JjA5NSi.r2eKPFMV.8bjnYiDpw0/eStLn44Ods31D2', 'https://avatar.iran.liara.run/public', 'admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
