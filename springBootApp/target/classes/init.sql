INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'USER');
-- password = azerty
INSERT INTO `user` (`user_id`, `address`, `created_at`, `email`, `firstname`, `is_account_activated`, `is_deleted`, `last_name`, `password`, `updated_at`) VALUES
(1, 'sfax', '2018-01-08 00:00:00', 'admin@gmail.com', 'adminFirstName', b'1111111111111111111111111111111', b'1111111111111111111111111111111', 'adminLastName', '$2a$10$iisWaqSUzDcf2O1YjPIkr.o4hRwALeDW/Nn5k6.vBcfIq4Qy5zytK', NULL),
(2, 'sfax', '2018-01-08 00:00:00', 'user@gmail.com', 'userFirstName', b'1111111111111111111111111111111', b'1111111111111111111111111111111', 'userLastName', '$2a$10$iisWaqSUzDcf2O1YjPIkr.o4hRwALeDW/Nn5k6.vBcfIq4Qy5zytK', NULL);

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);
