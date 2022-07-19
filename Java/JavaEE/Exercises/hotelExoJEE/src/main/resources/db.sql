DROP DATABASE hoteldb;
CREATE DATABASE hoteldb;
USE hoteldb;
CREATE TABLE room(
                     room_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     available BOOLEAN NOT NULL,
                     type VARCHAR(255) NOT NULL,
                     capacity int NOT NULL,
                     price DECIMAL(7,2) NOT NULL,
                     img VARCHAR(255) NOT NULL

);
CREATE TABLE customer(
                         customer_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         last_name VARCHAR(255) NOT NULL,
                         first_name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL
);
CREATE TABLE Booking(
                        booking_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        customer_id int NOT NULL,
                        room_id int NOT NULL,
                        date_begin DATE NOT NULL,
                        date_end DATE NOT NULL,
                        CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                        CONSTRAINT fk_room_id FOREIGN KEY (room_id) REFERENCES room(room_id)
);

INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'BASIC', 2, 200.99, 'https://www.hotel-omaha-beach.com/wp-content/uploads/2016/03/Hotel-Mercure-Omaha-Beach-Chambre-Standard-5.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99, 'https://www.hoteldelaplage.com/wp-content/uploads/2018/05/H%C3%B4tel-de-la-Plage-Bordagain-3.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'SUITE', 6, 400.99, 'https://asset.montecarlosbm.com/styles/hero_desktop_wide_responsive/s3/media/orphea/hp_diamond_suite_princesse_grace_0006_0.jpg.jpeg?itok=bj_1Pz2c');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'BASIC', 2, 200.99, 'https://www.hotel-omaha-beach.com/wp-content/uploads/2016/03/Hotel-Mercure-Omaha-Beach-Chambre-Standard-5.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99, 'https://www.hoteldelaplage.com/wp-content/uploads/2018/05/H%C3%B4tel-de-la-Plage-Bordagain-3.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'SUITE', 6, 400.99, 'https://asset.montecarlosbm.com/styles/hero_desktop_wide_responsive/s3/media/orphea/hp_diamond_suite_princesse_grace_0006_0.jpg.jpeg?itok=bj_1Pz2c');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'BASIC', 2, 200.99, 'https://www.hotel-omaha-beach.com/wp-content/uploads/2016/03/Hotel-Mercure-Omaha-Beach-Chambre-Standard-5.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99, 'https://www.hoteldelaplage.com/wp-content/uploads/2018/05/H%C3%B4tel-de-la-Plage-Bordagain-3.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'SUITE', 6, 400.99, 'https://asset.montecarlosbm.com/styles/hero_desktop_wide_responsive/s3/media/orphea/hp_diamond_suite_princesse_grace_0006_0.jpg.jpeg?itok=bj_1Pz2c');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'BASIC', 2, 200.99, 'https://www.hotel-omaha-beach.com/wp-content/uploads/2016/03/Hotel-Mercure-Omaha-Beach-Chambre-Standard-5.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99, 'https://www.hoteldelaplage.com/wp-content/uploads/2018/05/H%C3%B4tel-de-la-Plage-Bordagain-3.jpg');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'SUITE', 6, 400.99, 'https://asset.montecarlosbm.com/styles/hero_desktop_wide_responsive/s3/media/orphea/hp_diamond_suite_princesse_grace_0006_0.jpg.jpeg?itok=bj_1Pz2c');
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`, `img`) VALUES (NULL, 1, 'SUITE', 6, 400.99, 'https://asset.montecarlosbm.com/styles/hero_desktop_wide_responsive/s3/media/orphea/hp_diamond_suite_princesse_grace_0006_0.jpg.jpeg?itok=bj_1Pz2c');

INSERT INTO `customer` (`customer_id`, `last_name`, `first_name`, `email`, `password`) VALUES (NULL, 'hello', 'hola', 'hello.hola@customer.com','helloWorld');
INSERT INTO `customer` (`customer_id`, `last_name`, `first_name`, `email`, `password`) VALUES (NULL, 'ya', 'yes', 'ya.yes@customer.com','helloWorld');

INSERT INTO `booking` (`booking_id`, `customer_id`, `room_id`, `date_begin`, `date_end`) VALUES (NULL, '1', '1', '2022-07-19', '2022-07-26');
INSERT INTO `booking` (`booking_id`, `customer_id`, `room_id`, `date_begin`, `date_end`) VALUES (NULL, '2', '1', '2022-08-05', '2022-08-20');
