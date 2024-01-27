-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 27-Jan-2024 às 02:10
-- Versão do servidor: 10.4.28-MariaDB
-- versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bodyboost`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `app_users`
--

CREATE TABLE `app_users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `weight` double(8,2) NOT NULL,
  `height` double(8,2) NOT NULL,
  `objective` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `app_users`
--

INSERT INTO `app_users` (`id`, `username`, `password`, `weight`, `height`, `objective`, `created_at`, `updated_at`) VALUES
(45, 'utilizador2', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 70.00, 1.69, 'Lose weight', '2023-12-04 10:52:30', '2023-12-04 10:55:40'),
(46, 'juanito', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 60.00, 1.65, 'Gain mass', '2024-01-15 12:29:26', '2024-01-15 12:29:26');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `categories`
--

INSERT INTO `categories` (`id`, `name`, `slug`, `created_at`, `updated_at`) VALUES
(1, 'Football', 'football', '2023-10-25 14:31:57', '2023-10-25 14:31:57'),
(2, 'Basketball', 'basketball', '2023-10-25 14:32:53', '2023-10-25 14:32:53'),
(3, 'Tennis', 'tennis', '2023-10-25 14:33:03', '2023-10-25 14:33:03'),
(4, 'Interview', 'interview', '2023-10-25 14:33:47', '2023-10-25 14:33:47');

-- --------------------------------------------------------

--
-- Estrutura da tabela `dietary_types`
--

CREATE TABLE `dietary_types` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `dietary_types`
--

INSERT INTO `dietary_types` (`id`, `name`, `slug`, `created_at`, `updated_at`) VALUES
(2, 'Vegan', 'vegan', '2023-10-26 07:57:35', '2023-10-26 07:57:35'),
(5, 'Gluten Free', 'gluten-free', '2023-10-26 11:08:55', '2023-10-26 11:08:55'),
(6, 'Non Vegetarian', 'non-vegetarian', '2023-10-26 11:43:38', '2023-10-26 11:43:38');

-- --------------------------------------------------------

--
-- Estrutura da tabela `exercises`
--

CREATE TABLE `exercises` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `exerciseName` varchar(255) NOT NULL,
  `exerciseDescription` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `exercise_sets`
--

CREATE TABLE `exercise_sets` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `exercise_id` int(11) NOT NULL,
  `dayId` int(11) NOT NULL,
  `exerciseSet_id` int(11) NOT NULL,
  `orderIndex` int(11) NOT NULL,
  `repetitions` int(11) NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `exercise_steps`
--

CREATE TABLE `exercise_steps` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `exercise_id` bigint(20) UNSIGNED NOT NULL,
  `image` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `connection` text NOT NULL,
  `queue` text NOT NULL,
  `payload` longtext NOT NULL,
  `exception` longtext NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ingredients`
--

CREATE TABLE `ingredients` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `ingredients`
--

INSERT INTO `ingredients` (`id`, `name`, `created_at`, `updated_at`) VALUES
(1, 'large bell peppers', '2023-10-26 07:59:30', '2023-10-26 07:59:30'),
(2, 'quinoa', '2023-10-26 07:59:40', '2023-10-26 07:59:40'),
(3, 'vegetable broth', '2023-10-26 07:59:45', '2023-10-26 08:00:33'),
(4, 'black beans', '2023-10-26 08:00:46', '2023-10-26 08:00:46'),
(5, 'corn kernels', '2023-10-26 08:00:52', '2023-10-26 08:00:52'),
(6, 'tomatoes', '2023-10-26 08:01:04', '2023-10-26 08:01:04'),
(7, 'red onion', '2023-10-26 08:01:10', '2023-10-26 08:01:10'),
(8, 'zucchini', '2023-10-26 08:01:17', '2023-10-26 08:01:17'),
(9, 'garlic', '2023-10-26 08:01:22', '2023-10-26 08:01:22'),
(10, 'chili powder', '2023-10-26 08:01:28', '2023-10-26 08:01:28'),
(11, 'cumin', '2023-10-26 08:01:34', '2023-10-26 08:01:34'),
(12, 'Salt and pepper', '2023-10-26 08:01:42', '2023-10-26 08:01:42'),
(13, 'cheddar cheese', '2023-10-26 08:01:56', '2023-10-26 08:01:56'),
(14, 'Fresh cilantro leaves', '2023-10-26 08:02:10', '2023-10-26 08:02:10'),
(16, 'portobello mushrooms', '2023-10-26 08:08:49', '2023-10-26 08:08:49'),
(17, 'mushrooms', '2023-10-26 08:08:59', '2023-10-26 08:08:59'),
(18, 'red bell pepper', '2023-10-26 08:09:14', '2023-10-26 08:09:14'),
(19, 'onion', '2023-10-26 08:09:22', '2023-10-26 08:09:22'),
(20, 'garlic', '2023-10-26 08:10:30', '2023-10-26 08:10:30'),
(21, 'feta cheese', '2023-10-26 08:10:43', '2023-10-26 08:10:43'),
(22, 'olive oil', '2023-10-26 08:10:50', '2023-10-26 08:10:50'),
(23, 'red pepper flakes', '2023-10-26 08:11:01', '2023-10-26 08:11:01'),
(24, 'spinach', '2023-10-26 08:28:42', '2023-10-26 08:28:42'),
(25, 'strawberries', '2023-10-26 11:06:11', '2023-10-26 11:06:11'),
(26, 'red onion', '2023-10-26 11:06:17', '2023-10-26 11:06:17'),
(27, 'cilantro', '2023-10-26 11:06:25', '2023-10-26 11:06:25'),
(28, 'jalapeño pepper', '2023-10-26 11:06:40', '2023-10-26 11:06:40'),
(29, 'lime juice', '2023-10-26 11:06:47', '2023-10-26 11:06:47'),
(30, 'Salmon fillet', '2023-10-26 11:27:16', '2023-10-26 11:27:16'),
(31, 'lemon', '2023-10-26 11:27:25', '2023-10-26 11:27:25'),
(32, 'shrimp', '2023-10-26 11:40:41', '2023-10-26 11:40:41'),
(33, 'unsalted butter', '2023-10-26 11:40:52', '2023-10-26 11:40:52'),
(34, 'fresh parsley', '2023-10-26 11:41:10', '2023-10-26 11:41:10'),
(35, 'linguine pasta', '2023-10-26 11:41:27', '2023-10-26 11:41:27'),
(36, 'spinach leaves', '2023-10-27 06:48:55', '2023-10-27 06:48:55'),
(37, 'cucumber', '2023-10-27 06:49:02', '2023-10-27 06:49:02'),
(38, 'green apple', '2023-10-27 06:49:08', '2023-10-27 06:49:08'),
(39, 'fresh ginger', '2023-10-27 06:49:20', '2023-10-27 06:49:20'),
(40, 'coconut water', '2023-10-27 06:49:29', '2023-10-27 06:49:29'),
(41, 'ice cubes', '2023-10-27 06:49:36', '2023-10-27 06:49:36');

-- --------------------------------------------------------

--
-- Estrutura da tabela `meals`
--

CREATE TABLE `meals` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `dietary_types_id` bigint(20) UNSIGNED NOT NULL,
  `meal_types_id` bigint(20) UNSIGNED NOT NULL,
  `excerpt` varchar(255) NOT NULL,
  `recipe` text NOT NULL,
  `prep_time` decimal(5,2) NOT NULL,
  `cook_time` decimal(5,2) NOT NULL,
  `servings` int(11) NOT NULL,
  `calories` int(11) NOT NULL,
  `thumbnail` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `meals`
--

INSERT INTO `meals` (`id`, `name`, `dietary_types_id`, `meal_types_id`, `excerpt`, `recipe`, `prep_time`, `cook_time`, `servings`, `calories`, `thumbnail`, `created_at`, `updated_at`) VALUES
(1, 'Quinoa and Black Bean Stuffed Peppers', 2, 1, 'This recipe is a delicious and healthy vegetarian option that\'s high in fiber, protein, and vitamins. Enjoy your Quinoa and Black Bean Stuffed Peppers!', 'Preheat your oven to 375°F (190°C).\r\n\r\nCut the tops off the bell peppers and remove the seeds and membranes. Place the peppers in a baking dish and set them aside.\r\n\r\nIn a medium saucepan, bring the vegetable broth to a boil. Add the quinoa, reduce the heat to low, cover, and simmer for about 15 minutes or until the quinoa is cooked and the liquid is absorbed.\r\n\r\nIn a large mixing bowl, combine the cooked quinoa, black beans, corn, diced tomatoes, red onion, zucchini, minced garlic, chili powder, cumin, salt, and pepper. Mix everything well.\r\n\r\nCarefully stuff each bell pepper with the quinoa and black bean mixture. Place the stuffed peppers in the baking dish.\r\n\r\nSprinkle the shredded cheese on top of each stuffed pepper.\r\n\r\nCover the baking dish with foil and bake for 25-30 minutes or until the peppers are tender.\r\n\r\nRemove the foil and bake for an additional 5-10 minutes or until the cheese is bubbly and slightly browned.\r\n\r\nGarnish with fresh cilantro leaves before serving.', 20.00, 35.00, 4, 400, 'thumbnails/hp6UIFXQa3EiwSvkE1mhVMGxZlG7AMDt7ynIOoDF.jpg', '2023-10-26 08:06:21', '2023-10-26 08:06:21'),
(2, 'Spinach and Mushroom Stuffed Portobello Mushrooms', 2, 1, 'These Spinach and Mushroom Stuffed Portobello Mushrooms are a delightful vegetarian dinner. Portobello mushrooms filled with a flavorful mix of sautéed mushrooms, spinach, and feta cheese...', 'Preheat your oven to 375°F (190°C).\r\n\r\nClean the portobello mushrooms and remove the stems. Place them on a baking sheet, gill side up.\r\n\r\nIn a large skillet, heat the olive oil over medium heat. Add the chopped onion, garlic, and red bell pepper. Sauté for a few minutes until they become tender.\r\n\r\nAdd the finely chopped mushrooms and continue cooking until they release their moisture and it evaporates. This will take about 5-7 minutes.\r\n\r\nStir in the chopped spinach and cook until it wilts.\r\n\r\nRemove the skillet from heat and stir in the feta cheese. Season with salt, pepper, and red pepper flakes if you want a little heat.\r\n\r\nSpoon the spinach and mushroom mixture into each portobello mushroom cap.\r\n\r\nPlace the stuffed mushrooms in the oven and bake for about 20-25 minutes, or until the mushrooms are tender and the filling is hot and bubbly.\r\n\r\nGarnish with fresh basil leaves before serving.', 25.00, 25.00, 4, 350, 'thumbnails/T44f3mUIm5JnOeMtp2pdTg5YyUE4UJgzkqcGqlgt.jpg', '2023-10-26 08:14:35', '2023-10-26 08:14:35'),
(3, 'Strawberry Salsa for Grilled Chicken', 5, 1, 'Elevate your grilled chicken with this refreshing Strawberry Salsa. The sweet juiciness of fresh strawberries combined with zesty red onion and jalapeño, all brightened up by a splash of lime juice.', 'In a mixing bowl, combine the diced strawberries, finely chopped red onion, chopped cilantro, and minced jalapeño pepper.\r\n\r\nAdd the fresh lime juice and gently mix the ingredients.\r\n\r\nSeason the salsa with salt and pepper to taste.\r\n\r\nAllow the salsa to sit for about 15-30 minutes to let the flavors meld together.\r\n\r\nGrill or cook your chicken breasts to your preference, whether marinated, seasoned, or plain.\r\n\r\nServe the grilled chicken with a generous spoonful of the strawberry salsa on top.', 20.00, 20.00, 4, 120, 'thumbnails/2xxox6hA69YijJJhGnPSB1nqjO9BeYlPC2PypSjH.jpg', '2023-10-26 11:10:48', '2023-10-26 11:10:48'),
(4, 'Grilled Salmon with Lemon Herb Sauce', 5, 1, 'Elevate your dinner with this simple and delightful Grilled Salmon with Lemon Herb Sauce. Succulent salmon fillets are seasoned with a zesty blend of lemon juice, olive oil, and a hint of fresh herbs.', 'For the Salmon:\r\n\r\nPreheat the grill to medium-high heat...\r\n\r\nFor the Lemon Herb Sauce:\r\n\r\nIn a small bowl, mix the lemon juice, olive oil, chopped cilantro (or your chosen herb), salt, and pepper.\r\n\r\nDrizzle the sauce over the grilled salmon before serving.', 10.00, 10.00, 4, 320, 'thumbnails/ek1p7hK56WYRqPNZGVf2tAkbj87LqxfdCAVkdafz.jpg', '2023-10-26 11:29:49', '2023-10-26 11:29:49'),
(5, 'Lemon Garlic Butter Shrimp Pasta', 6, 1, 'Delight in the exquisite combination of succulent shrimp, zesty lemon, and creamy garlic-infused butter with our Lemon Garlic Butter Shrimp Pasta...', 'For the Shrimp:\r\n\r\nIn a large skillet, heat the butter ...\r\n\r\nFor the Pasta:\r\n\r\nIn a separate large pot, bring water to a boil, and add a pinch of salt. Cook the pasta according to the package instructions until al dente...\r\n\r\nServe hot, garnished with additional chopped parsley and lemon zest if desired.', 20.00, 15.00, 4, 380, 'thumbnails/nf3Ynk1T1cToI436vOBUmBcnRumAMCZS0UQPEmkK.jpg', '2023-10-26 11:43:56', '2023-10-26 11:43:56'),
(6, 'Green Detox Smoothie', 2, 2, 'Kickstart your day with this nutritious Green Detox Smoothie. Packed with vitamins, fiber, and antioxidants, it\'s a refreshing way to boost your energy and support your health.', 'Place the spinach, cucumber, green apple, lemon juice, and ginger in a blender.\r\n\r\n    Add water or coconut water to the blender.\r\n\r\n    If desired, add ice cubes for a colder smoothie.\r\n\r\n    Blend until smooth and well combined.\r\n\r\n    Pour into a glass and enjoy your Green Detox Smoothie!', 5.00, 0.00, 2, 150, 'thumbnails/i2T1D2LO0tTE4juDX3lqmtbOJOAhmLPlbmJUeu5M.jpg', '2023-10-27 06:48:25', '2023-10-27 06:48:25');

-- --------------------------------------------------------

--
-- Estrutura da tabela `meal_ingredients`
--

CREATE TABLE `meal_ingredients` (
  `id` int(10) UNSIGNED NOT NULL,
  `ingredients_id` bigint(20) UNSIGNED NOT NULL,
  `meal_id` bigint(20) UNSIGNED NOT NULL,
  `amount` double(8,2) NOT NULL,
  `measure` varchar(255) NOT NULL,
  `time` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `meal_ingredients`
--

INSERT INTO `meal_ingredients` (`id`, `ingredients_id`, `meal_id`, `amount`, `measure`, `time`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 0.00, '4', 0, '2023-10-26 10:15:51', '2023-10-26 10:16:18'),
(2, 2, 1, 0.00, '1 cup', 0, '2023-10-26 10:16:46', '2023-10-26 10:16:46'),
(3, 3, 1, 0.00, '2 cups', 0, '2023-10-26 10:17:06', '2023-10-26 10:17:06'),
(4, 4, 1, 0.00, '1 can ( 15oz )', 0, '2023-10-26 10:17:34', '2023-10-26 10:17:34'),
(5, 5, 1, 0.00, '1 cup', 0, '2023-10-26 10:17:46', '2023-10-26 10:17:46'),
(6, 6, 1, 0.00, '1 cup diced', 0, '2023-10-26 10:18:49', '2023-10-26 10:18:49'),
(7, 7, 1, 0.00, '1 cup diced', 0, '2023-10-26 10:19:01', '2023-10-26 10:19:01'),
(8, 8, 1, 0.00, '1 cup diced', 0, '2023-10-26 10:19:19', '2023-10-26 10:19:19'),
(9, 9, 1, 0.00, '2 cloves', 0, '2023-10-26 10:19:33', '2023-10-26 10:19:33'),
(10, 10, 1, 0.00, '1 tsp', 0, '2023-10-26 10:20:08', '2023-10-26 10:20:08'),
(11, 11, 1, 0.00, '1/2 tsp', 0, '2023-10-26 10:20:24', '2023-10-26 10:20:24'),
(12, 12, 1, 0.00, 'to taste', 0, '2023-10-26 10:20:37', '2023-10-26 10:20:37'),
(13, 13, 1, 0.00, '1 cup shredded', 0, '2023-10-26 10:21:11', '2023-10-26 10:21:11'),
(14, 14, 1, 0.00, 'For garnish', 0, '2023-10-26 10:22:30', '2023-10-26 10:22:30'),
(15, 16, 2, 0.00, '4 large', 0, '2023-10-26 10:27:42', '2023-10-26 10:27:42'),
(16, 24, 2, 0.00, '2 cups fresh', 0, '2023-10-26 10:30:33', '2023-10-26 10:30:33'),
(17, 17, 2, 0.00, '1 cup', 0, '2023-10-26 10:30:58', '2023-10-26 10:30:58'),
(18, 18, 2, 0.00, '1/2 cup', 0, '2023-10-26 10:31:28', '2023-10-26 10:31:28'),
(19, 19, 2, 0.00, '1/2 cup', 0, '2023-10-26 10:31:49', '2023-10-26 10:31:49'),
(20, 20, 2, 0.00, '2 cloves', 0, '2023-10-26 10:32:06', '2023-10-26 10:32:06'),
(21, 21, 2, 0.00, '1/2 cup', 0, '2023-10-26 10:32:34', '2023-10-26 10:32:34'),
(22, 22, 2, 0.00, '2 tsp', 0, '2023-10-26 10:32:55', '2023-10-26 10:32:55'),
(23, 12, 2, 0.00, 'to taste', 0, '2023-10-26 10:33:12', '2023-10-26 10:33:12'),
(24, 23, 2, 0.00, '1/4 tsp', 0, '2023-10-26 10:33:32', '2023-10-26 10:33:32'),
(25, 14, 2, 0.00, 'To garnish', 0, '2023-10-26 10:34:14', '2023-10-26 10:34:14'),
(26, 25, 3, 0.00, '1 cup fresh', 0, '2023-10-26 13:11:39', '2023-10-26 13:11:39'),
(27, 26, 3, 0.00, '1/2 cup', 0, '2023-10-26 13:11:54', '2023-10-26 13:11:54'),
(28, 27, 3, 0.00, '1/4', 0, '2023-10-26 13:12:17', '2023-10-26 13:12:17'),
(29, 28, 3, 0.00, '1 small', 0, '2023-10-26 13:12:29', '2023-10-26 13:12:29'),
(30, 29, 3, 0.00, '1 tsp', 0, '2023-10-26 13:12:47', '2023-10-26 13:12:47'),
(31, 12, 3, 0.00, 'To taste', 0, '2023-10-26 13:13:07', '2023-10-26 13:13:07'),
(32, 30, 4, 0.00, '4', 0, '2023-10-26 13:31:51', '2023-10-26 13:31:51'),
(33, 29, 4, 0.00, '2', 0, '2023-10-26 13:32:36', '2023-10-26 13:35:23'),
(34, 22, 4, 0.00, '4 tsp', 0, '2023-10-26 13:33:31', '2023-10-26 13:35:06'),
(35, 12, 4, 0.00, 'To taste', 0, '2023-10-26 13:33:45', '2023-10-26 13:33:45'),
(36, 27, 4, 0.00, '2 tsp', 0, '2023-10-26 13:34:12', '2023-10-26 13:34:12'),
(37, 32, 5, 0.00, '1 pound large', 0, '2023-10-26 13:44:38', '2023-10-26 13:44:38'),
(38, 9, 5, 0.00, '3 cloves', 0, '2023-10-26 13:45:00', '2023-10-26 13:45:00'),
(39, 33, 5, 0.00, '2 tsp', 0, '2023-10-26 13:46:08', '2023-10-26 13:46:08'),
(40, 22, 5, 0.00, '2 tsp', 0, '2023-10-26 13:46:27', '2023-10-26 13:46:27'),
(41, 31, 5, 0.00, '1 Juice and zest', 0, '2023-10-26 13:47:22', '2023-10-26 13:47:22'),
(42, 12, 5, 0.00, 'To taste', 0, '2023-10-26 13:47:38', '2023-10-26 13:47:38'),
(43, 34, 5, 0.00, '1/4 cup', 0, '2023-10-26 13:48:28', '2023-10-26 13:48:28'),
(44, 23, 5, 0.00, 'For heat', 0, '2023-10-26 13:48:47', '2023-10-26 13:48:47'),
(45, 35, 5, 0.00, '8 oz', 0, '2023-10-26 13:49:09', '2023-10-26 13:49:09'),
(46, 36, 6, 0.00, '1', 0, '2023-10-27 08:50:04', '2023-10-27 08:50:04'),
(47, 37, 6, 0.00, '1/2', 0, '2023-10-27 08:50:29', '2023-10-27 08:50:29'),
(48, 38, 6, 0.00, '1', 0, '2023-10-27 08:50:42', '2023-10-27 08:50:42'),
(49, 31, 6, 0.00, '1/2', 0, '2023-10-27 08:50:54', '2023-10-27 08:50:54'),
(50, 39, 1, 0.00, '1/2', 0, '2023-10-27 08:51:22', '2023-10-27 08:51:22'),
(51, 40, 6, 0.00, '1 cup', 0, '2023-10-27 08:51:39', '2023-10-27 08:51:39'),
(52, 41, 6, 0.00, 'optional', 0, '2023-10-27 08:51:51', '2023-10-27 08:51:51');

-- --------------------------------------------------------

--
-- Estrutura da tabela `meal_types`
--

CREATE TABLE `meal_types` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `meal_types`
--

INSERT INTO `meal_types` (`id`, `name`, `slug`, `created_at`, `updated_at`) VALUES
(1, 'Dinner / Lunch', 'dinner-lunch', '2023-10-26 08:05:23', '2023-10-26 08:05:23'),
(2, 'Drink', 'drink', '2023-10-27 06:43:56', '2023-10-27 06:43:56');

-- --------------------------------------------------------

--
-- Estrutura da tabela `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_reset_tokens_table', 1),
(3, '2019_08_19_000000_create_failed_jobs_table', 1),
(4, '2019_12_14_000001_create_personal_access_tokens_table', 1),
(5, '2023_10_02_173607_create_meal_types_table', 1),
(6, '2023_10_02_204614_create_dietary_types_table', 1),
(7, '2023_10_03_095033_create_meals_table', 1),
(8, '2023_10_06_201150_create_categories_table', 1),
(9, '2023_10_07_200432_create_news_table', 1),
(10, '2023_10_10_102033_create_ingredients_table', 1),
(11, '2023_10_10_115846_create_meal_ingredients_table', 1),
(12, '2023_10_23_191620_create_exercise_table', 1),
(13, '2023_10_23_191649_create_exercise_sets_table', 1),
(14, '2023_10_23_192802_create_exercise_steps_table', 1),
(15, '2023_10_23_192826_create_workout_plans_table', 1),
(16, '2023_11_07_130345_create_app_users_table', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `news`
--

CREATE TABLE `news` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `category_id` bigint(20) UNSIGNED NOT NULL,
  `slug` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `excerpt` text NOT NULL,
  `body` text NOT NULL,
  `source` text NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `news`
--

INSERT INTO `news` (`id`, `category_id`, `slug`, `title`, `thumbnail`, `excerpt`, `body`, `source`, `created_at`, `updated_at`) VALUES
(1, 1, 'lionel-messi-at-inter-miami-how-has-the-argentina-star-fared-at-the-david-beckham-owned-club', 'Messi at Inter Miami: How have the first three months gone?', 'thumbnails/N3UIAqzX7gQx9aPZrw9a69zNfFDWTRoEemakBEmR.jpg', 'Inter Miami\'s MLS season came to an end at the weekend after Lionel Messi\'s arrival catapulted the club into the international consciousness.', 'Just over three months ago, Lionel Messi’s long-discussed move to the MLS finally came to fruition as he joined Inter Miami from Paris Saint-Germain.\r\n\r\nThe star-studded club - part-owned by former England captain David Beckham - had landed the biggest star of them all.\r\n\r\nHe chose Inter Miami over a move to Al Hilal in the Saudi Pro League where many of his contemporaries now play, or a homecoming at Barcelona.\r\n\r\nAnd the MLS club needed their marquee signing to hit the ground running. In June 2023, just before Messi\'s arrival, Phil Neville was sacked as manager. The club were bottom of the Eastern Conference and unlikely to make the play-offs.\r\n\r\nIt will come as no surprise that Messi had an instant impact.\r\n\r\nInter Miami won the 2023 Leagues Cup - the first to be contested between all MLS and Liga MX clubs - less than a month after his arrival and went on a 12-match unbeaten run.\r\n\r\nNot only did the World Cup winner influence his team-mates, but his arrival signifies the wider ambitions of the MLS too, as NBC ProSoccer Talk editor and lead soccer writer Joe Prince-Wright explains.\r\n\r\n\"The similarities to David Beckham\'s arrival in MLS at LA Galaxy can be made, but I\'ve never seen anything quite like this,\" he told Sky Sports.\r\n\r\n\"When he finally arrived it was an incredible moment for the league. And let\'s not forget - the MLS nearly went bust back in 2000, so Messi arriving caps a remarkable turnaround for the league over the last 20 years.\r\n\r\n\"For many years, it has been a slow and steady development of the league, before a rapid period of expansion teams in recent years. Now Messi arriving ahead of the 2026 World Cup is seen by many as the final piece of the jigsaw for the MLS as they aim to become even more mainstream in the USA and around the world.\r\n\r\nLionel Messi helped Inter Miami to win their first silverware with the Leagues Cup\r\n\r\n\"On the pitch, we are talking about the worst team in the Eastern Conference by some way before he arrived.\r\n\r\n\"The goals he scored, the way he has captured the imagination of not only the public and the fanbase in Miami, but the other players there too, is quite astonishing.\r\n\r\n\"Almost every single Inter Miami player has raised their game and signing someone like Messi signifies to the other players \'okay, I have to be at my best level possible because obviously the ownership mean business and I can\'t afford to let my levels slip for a single second.\'\r\n\r\n\"His mentality to lead and want to help this group of players achieve things they never thought would be possible is something we saw come to the fore in the run to win the Leagues Cup and reach the US Open Cup final.\"\r\n\r\nEven those not au fait with football know who Messi is, such is his stature.', 'https://www.skysports.com/football/story-telling/11095/12987520/lionel-messi-at-inter-miami-how-has-the-argentina-star-fared-at-the-david-beckham-owned-club', '2023-10-25 14:37:14', '2023-10-25 14:37:14'),
(2, 1, 'the-debrief-man-utd-unconvincing-even-on-special-night-gary-oneils-mnf-masterclass-and-unai-emerys-brilliance', 'The Debrief: Man Utd unconvincing even on special night, Gary O\'Neil\'s MNF masterclass, and Unai Emery\'s brilliance', 'thumbnails/IK9enKtdaIG7tVWUP444dBzV9adDrw8EZOILm8um.jpg', 'In his latest column, Adam Bate reflects on an emotional night at Old Trafford that still left Manchester United fearing how the derby will play out', 'Manchester Uniteds head coach Erik ten Hag, second left, with Alexander Stepney English former player, second right, and Manchester United academy player Dan Gore lays flowers in memory of Sir Bobby Charlton prior the Champions League group A soccer match between Manchester United and Copenhagen at the Old Trafford stadium in Manchester, England, Tuesday, Oct. 24, 2023. (AP Photo/Dave Thompson)\r\nImage: Dan Gore, Erik ten Hag and Alex Stepney lay a wreath in tribute as a piper plays\r\n\r\nCharlton\'s legacy is myriad but as a Busby Babe and the driving force behind the club\'s first European Cup win, he helped shape how United sees itself. The 87-year sequence in which an academy player has been named in the squad has become part of the mystique.\r\n\r\nTony Whelan, the long-time academy coach, calls it the scarlet thread that runs through the club\'s history. Another United trope is drama and their win over FC Copenhagen served up plenty after a poor first half. Two much-maligned figures enjoyed big moments.\r\n\r\nPlease use Chrome browser for a more accessible video player\r\nTim Sherwood has given Harry Maguire a lot of credit for wanting to stay at Manchester United and fighting for his place in the starting XI.\r\nTim Sherwood has given Harry Maguire a lot of credit for his comeback at Man Utd\r\n\r\nIt was a special evening, one that was rightly celebrated with gusto upon the final whistle. But there was the occasion and there is the situation. It was easy to be excited by Harry Maguire\'s goal and Andre Onana\'s penalty save. Not so easy to be excited by this team.\r\n\r\nErik ten Hag has scrambled his way to three consecutive victories now and can point to the spirit required to do so. But this continues to look like a side searching for something that is missing. The style of play is unclear. The uncertainty in their game is alarming at times.\r\nTrending\r\n\r\n    Rooney\'s Birmingham trailing | All Championship games on Sky LIVE!\r\n    Papers: Premier League recommends Everton face 12-point deduction\r\n    England skipper Farrell slams \'unacceptable\' online abuse of Curry\r\n    Transfer Centre LIVE! Fulham target cut-price Stuttgart striker Guirassy\r\n    Australia demolish Netherlands for record World Cup win\r\n    How Maguire became the defender Ten Hag wanted\r\n    Two police officers guilty of misconduct over Williams stop and search\r\n    Mercedes \'embarrassed\' by Hamilton disqualification\r\n    Merson Says: Villa star is Premier League\'s most underrated player\r\n    Man Utd\'s flimsy form | O\'Neil on MNF | Emery\'s revolution\r\n\r\nPlease use Chrome browser for a more accessible video player\r\nman utd verdict\r\nSky Sports\' Ben Ransom and Adam Bate analyse Manchester United\'s 1-0 victory over FC Copenhagen on an emotional night at Old Trafford.\r\n\r\nThis flimsiest of upturns in fortunes, for Maguire and the rest, will be put to the test against Manchester City on Sunday. That will be another chance for Manchester to pay its respects to England\'s finest. On Tuesday\'s evidence, there will be some trepidation about what follows it.', 'https://www.skysports.com/football/news/12037/12992306/the-debrief-man-utd-unconvincing-even-on-special-night-gary-oneils-mnf-masterclass-and-unai-emerys-brilliance', '2023-10-25 14:50:20', '2023-10-25 14:51:18'),
(3, 2, 'kia-rookie-ladder-nba-debuts-2023-24', 'Kia Rookie Ladder: Victor Wembanyama headlines 16 names to watch', 'thumbnails/3tpFZcD44ZgIjlYI3vGYkNckCUfe9kGUngmAVZYZ.jpg', 'Spurs phenom Victor Wembanyama leads a deep group of newcomers set to debut this week', 'The excitement of a fresh NBA season owes credit to the newest of the new, its rookie class.\r\n\r\nThat applies this season more than most, given the fascination folks have with San Antonio’s Victor Wembanyama. The French newcomer is a prospect like few others in NBA history, with “unicorn” potential never before seen: A 7-foot-4 marvel with shooting range, a serious handle and a bushel of other ways to help the Spurs.\r\n\r\nStill, there is depth to the Class of 2023, with one leftover from the Class of 2022 who might make the Ladder and this season’s Rookie of the Year race legit competitive.\r\n\r\nBefore the first official ladder ranking in two weeks, here’s a look at when the key contenders (plus a dark horse candidate) are set to debut:\r\n\r\n* Chet Holmgren, Oklahoma City Thunder\r\n\r\nNBA debut: Wednesday at Chicago Bulls (8 p.m. ET, NBA League Pass)\r\n\r\nHolmgren, the No. 2 pick in 2022, gets an asterisk instead of a number because he’s a special entrant. Like Ben Simmons and Blake Griffin, his rookie season was wiped out by a right foot injury in August 2022. Now we’ll see if his extended rookie orientation helps him snag the ROY award the way it did Simmons and Griffin. Already, the OKC thin man and Wembanyama are natural rivals.\r\n\r\nNo. 1 pick | Victor Wembanyama, San Antonio Spurs\r\n\r\nNBA debut: Wednesday vs. Dallas Mavericks (9:30 p.m. ET, ESPN)\r\n\r\nNo one seriously will try to get cute and suggest Wemby is anything less than a heavy favorite to be this season’s runaway Kia Rookie of the Year. The variety of ways in which he dazzles already is evident. It’s more likely he’ll be chasing the greatest rookie seasons of all-time as comps than getting leapfrogged on this Ladder.\r\n\r\nNo. 2 pick | Brandon Miller, Charlotte Hornets\r\n\r\nNBA debut: Wednesday vs. Atlanta Hawks (7 p.m. ET, NBA League Pass)\r\n\r\nThe No. 2 pick was not mentioned as a candidate for ROY in the annual NBA GM survey, even though 50% chose someone other than Wembanyama. Miller isn’t expected to start, though Charlotte’s needs and an aging/fragile Gordon Hayward might change that.\r\n\r\nNo. 3 pick | Scoot Henderson, Portland Trail Blazers\r\n\r\nNBA debut: Wednesday at LA Clippers (10:30 p.m. ET, NBA League Pass)\r\n\r\nIf opportunity is the surest path to consideration as the best rookie, Henderson could be a serious Wemby challenger. The Blazers have flipped him the keys for as much as he can handle in their switcheroo from Damian Lillard. Let’s see how his shooting develops.\r\n\r\nCheck out the top moments from Scoot Henderson and the Thompson twins during the preseason.\r\n\r\nNo. 4 pick | Amen Thompson, Houston Rockets\r\n\r\nNBA debut: Wednesday at Orlando Magic (7 p.m. ET, NBA League Pass)\r\n\r\nThompson Twin No. 1 is a tremendous athlete with great positional size (6-foot-7) who could be a transition terror for Houston. He averaged two steals per 36 minutes in the preseason and there already is rumbling around the Rockets for how soon he can become a starter (Fred VanVleet as the team’s biggest offseason “get” precludes that for now).\r\n\r\nNo. 5 pick | Ausar Thompson, Detroit Pistons\r\n\r\nNBA debut: Wednesday at Miami Heat (7:30 p.m. ET, NBA League Pass)\r\n\r\nThompson Twin No. 2 (you know this sort of twin-tracking is inevitable this season, right?) led all rookies at 29.1 preseason minutes. His demonstrated potential-at-the-ready has the Pistons contemplating a starting role in which last season’s All-Rookie guy, Jaden Ivey, becomes the team’s sixth man.', 'https://www.nba.com/news/kia-rookie-ladder-nba-debuts-2023-24', '2023-10-25 14:57:49', '2023-10-25 14:57:49'),
(4, 2, 'players-who-signed-rookie-extensions-before-2023-24-deadline', 'Players who signed rookie extensions before 2023-24 deadline', 'thumbnails/hMYpV40lZYgXI0USD1hPDsI63fTdt0uSv4IfKiUa.jpg', 'LaMelo Ball, Anthony Edwards and Tyrese Haliburton are among the players from the 2020 Draft to sign extensions before the Oct. 23 deadline.', 'For players drafted in the 2020 NBA Draft, the deadline to sign rookie-scale contract extensions was 6 p.m. ET on Monday, Oct. 23.\r\n\r\nHere’s a quick look at the players who agreed to new terms before Monday’s deadline.\r\n\r\n(Editor’s note: All contract terms are reported.)\r\n\r\nPlayers Who Extended This Offseason\r\n\r\nAnthony Edwards, Minnesota Timberwolves (No. 1 pick in 2020)\r\n» 5 years, $260 million\r\n\r\nLaMelo Ball, Charlotte Hornets (No. 3 pick in 2020)\r\n» 5 years, $260 million\r\n\r\nTyrese Haliburton, Indiana Pacers (No. 12 pick in 2020)\r\n» 5 years, $260 million\r\n\r\nDesmond Bane, Memphis Grizzlies (No. 30 pick in 2020)\r\n» 5 years, $207 million\r\n\r\nDevin Vassell, San Antonio Spurs (No. 11 pick in 2020)\r\n» 5 years, $146 million\r\n\r\nJaden McDaniels, Minnesota Timberwolves (No. 28 pick in 2020)\r\n» 5 years, $136 million\r\n\r\nOnyeka Okongwu, Atlanta Hawks (No. 6 pick in 2020)\r\n» 4 years, $62 million\r\n\r\nDeni Avdija, Washington Wizards (No. 9 pick in 2020)\r\n» 4 years, $55 million\r\n\r\nJosh Green, Dallas Mavericks (No. 18 pick in 2020)\r\n» 3 years, $41 million\r\n\r\nCole Anthony, Orlando Magic (No. 15 pick in 2020)\r\n» 3 years, $39 million\r\n\r\nAaron Nesmith, Indiana Pacers (No. 14 pick in 2020)\r\n» 3 years, $33 million\r\n\r\nZeke Nnaji, Denver Nuggets (No. 22 pick in 2020)\r\n» 4 years, $32 million\r\n\r\nPayton Pritchard, Boston Celtics (No. 26 pick in 2020)\r\n» 4 years, $30 million\r\n\r\nNotable Players Who Didn’t Sign Extensions:\r\n(listed alphabetically)\r\n\r\n    Precious Achiuwa, Toronto Raptors (No. 20 pick in 2020)\r\n    Saddiq Bey, Atlanta Hawks (No. 19 pick in 2020)\r\n    Killian Hayes, Detroit Pistons (No. 7 pick in 2020)\r\n    Tyrese Maxey, Philadelphia 76ers (No. 21 pick in 2020)\r\n    Isaac Okoro, Cleveland Cavaliers (No. 5 pick in 2020)\r\n    Immanuel Quickley, New York Knicks (No. 25 pick in 2020)\r\n    Obi Toppin, Indiana Pacers (No. 8 pick in 2020)\r\n    Patrick Williams, Chicago Bulls (No. 4 pick in 2020)\r\n    James Wiseman, Detroit Pistons (No. 2 pick in 2020)', 'https://www.nba.com/news/players-who-signed-rookie-extensions-before-2023-24-deadline', '2023-10-25 14:59:13', '2023-10-25 15:00:44'),
(5, 3, 'karolina-muchova-withdraws-from-maiden-wta-finals-due-to-injury-maria-sakkari-takes-her-place_sto9849593/story', 'Karolina Muchova withdraws from maiden WTA finals due to injury, Maria Sakkari takes her place', 'thumbnails/kBXBtt0tXHrOJPYKEWp738Jhz6hRyCuK8LuOFBEw.jpg', 'Karolina Muchova has had an impressive 2023 campaign, reaching the French Open final in June and the Cincinnati Open final in August.', 'Karolina Muchova has had an impressive 2023 campaign, reaching the French Open final in June and the Cincinnati Open final in August. However, her season has come to an abrupt end due to a wrist injury that has plagued her since a semi-final exit to Coco Gauff at the US Open in September. Muchova has confirmed on social media that she will not be competing at the 2023 WTA finals in Mexico.\r\n\r\nNadal ‘still in pain’ and does not know if he will return at Australian Open\r\nKarolina Muchova has withdrawn from what would have been her first WTA finals due to injury.\r\nThe world No. 8 reached the final of the French Open earlier this year - earning rave reviews - and the Cincinnati Open final in August, but has struggled with a wrist injury for the latter half of the season.\r\nMuchova has not played a competitive match since losing to Coco Gauff - who also beat her in Cincinnati - in the US Open semi-finals in September.\r\nZheng beats Sakkari to reach Zhengzhou quarters, Paolini eliminates GarciaZheng beats Sakkari to reach Zhengzhou quarters, Paolini eliminates Garcia\r\nWTA Zhengzhou\r\nZheng beats Sakkari to reach Zhengzhou quarters, Paolini eliminates Garcia\r\n\r\n11/10/2023 at 16:19\r\nIn a statement on Instagram, Muchova said she has \"tried everything\" to be ready for the season-ending tournament in Cancun, but has not recovered in time to compete in Mexico.\r\n\"I am heartbroken to announce that I will miss my first WTA Finals in Cancun,” the Czech star wrote.\r\n\"Together with the team and doctors we tried everything till the last moments to resolve my wrist injury.\r\n\"Unfortunately, the time needed for the recovery is longer than we would’ve hoped for and therefore I had to make this unpleasant decision.\r\n\"I greatly appreciate the support of all the fans. I will do my best to be back in 2024 and get another chance to be part of the WTA finals.\"\r\nMaria Sakkari, who finished the WTA Race to Cancun in ninth place, will now feature at the tournament for the third year in a row. Sakkari finished as runner-up in 2021 and 2022.\r\nWorld No. 1 Aryna Sabalenka, four-time Grand Slam winner Swiatek and US Open champion Gauff, 2022 Wimbledon winner Elena Rybakina and Jessica Pegula are all set to feature at the WTA finals.\r\n\r\n    \'Young women who have spoken out\' - Murray praises Gauff and Osaka for speaking up on equality\r\n    \'I ask a lot of questions\' - Raducanu opens up on coach troubles\r\n\r\nWorld No. 7 Ons Jabeur and world No. 6 Marketa Vondrousova are both injury doubts.\r\nJabeur withdrew from Zhengzhou Open at the quarter-final stage two weeks ago with a knee injury, while Wimbledon champion Vondrousova has only played once since a quarter-final exit to Madison Keys at this year\'s US Open.\r\nAs well as the WTA finals trophy being up for grabs, Sabalenka and Swiatek will battle it out for the world No. 1 ranking in Mexico.', 'https://www.eurosport.com/tennis/wta-finals/2023/karolina-muchova-withdraws-from-maiden-wta-finals-due-to-injury-maria-sakkari-takes-her-place_sto9849593/story.shtml', '2023-10-25 15:20:02', '2023-10-25 15:21:06'),
(6, 3, 'gael-monfils-beats-qualifier-pavel-kotov-to-win-stockholm-open-i-kept-believing-and-fighting_sto9847762/story', 'Gael Monfils beats qualifier Pavel Kotov to win Stockholm Open - \'I kept believing and fighting\'', 'thumbnails/tIIalWbM1WLee17tHkFVHRTcU0QpU1ww1Lnwp7Jb.jpg', 'Gael Monfils came from a set down to beat qualifier Pavel Kotov and win the Stockholm Open for a second time 4-6 7-6(6) 6-3. Monfils...', 'Gael Monfils came from a set down to beat qualifier Pavel Kotov and win the Stockholm Open for a second time 4-6 7-6(6) 6-3. Monfils, the 37-year-old Frenchman, became the oldest champion in the history of the tournament, and the lowest-ranked player to win a tour-level competition since Borna Sosa in Cincinnati last year. Monfils now rises to 89 in the ATP World Rankings.\r\n\r\nMonfils battles back to beat Kotov and claim Stockholm Open title for second time\r\nGael Monfils came from a set down to beat qualifier Pavel Kotov 4-6 7-6(6) 6-3 and win the Stockholm Open for a second time.\r\nThe Frenchman, in claiming his first title of the season, became the oldest champion in the history of the Swedish tournament as the 37-year-old lifted his first trophy since the Adelaide International in January of last year.\r\nMonfils had to display great athleticism to stay in some tough rallies against his heavy-hitting Russian counterpart, as Kotov looked to step into the court and dictate proceedings with his thunderous forehand.\r\nExclusive: \'A very good fit\' - Becker confirms he is Rune\'s new coachExclusive: \'A very good fit\' - Becker confirms he is Rune\'s new coach\r\nTennis\r\nExclusive: \'A very good fit\' - Becker confirms he is Rune\'s new coach\r\n\r\n19/10/2023 at 19:13\r\nKotov, the first qualifier to reach a tour-level final since Jiri Vesely in Dubai last year, had to contend with Monfils sitting deep behind the baseline, soaking up his opponent\'s power, and demonstrating fantastic guile and touch to disrupt the 24-year-old\'s rhythm.\r\nA particular highlight was a Monfils backhand from way out wide at 5-4, 15-0 down in the first set as the Frenchman showed great reach to make the return and direct it with pinpoint accuracy down the line for a clean winner.\r\n\"Credit to Pavel,\" Monfils said after his victory. \"He has had an unbelievable week and he was pushing me on the court. I ran a lot today.\r\n\"When I had to save break points in the second set, I tried to push through. I don\'t know how I pulled up but I kept believing and fighting.\"\r\n\r\n    Rune thrilled with \'perfect\' game and Stockholm Open win\r\n    Highlights as Rune crashes out to Kecmanovic in Stockholm Open\r\n\r\nMonfils arrived in the Swedish capital ranked world No. 140, having struggled with niggling injuries in the earlier months of the year.\r\nIn Stockholm, the veteran dropped just two sets in his run to the final, including beating seventh seed Christopher Eubanks in his first match, and No. 2 seed and compatriot Adrian Mannarino in the quarter-finals.\r\nMonfils, with his 12th title, has become the lowest-ranked tour champion since Borna Sosa in Cincinnati last year, when the Croat was ranked world No. 152, and the Frenchman now rises to world No. 89.', 'https://www.eurosport.com/tennis/atp-stockholm/2023/gael-monfils-beats-qualifier-pavel-kotov-to-win-stockholm-open-i-kept-believing-and-fighting_sto9847762/story.shtml', '2023-10-25 15:24:13', '2023-10-25 15:26:11'),
(7, 4, 'virgil-van-dijk-loves-f1-trent-alexander-arnold-alpine', 'Virgil van Dijk loves F1 too’: Trent Alexander-Arnold’s need for speed', 'thumbnails/KVp2J9OoNxP4SBlM4TVR7VEOwOkv1PZZneUBexYZ.jpg', 'Rank, it seems, still has its privileges. For Trent Alexander-Arnold that means on the Liverpool coach his teammates are out of luck if they want to watch something that clashes with Formula One', 'Rank, it seems, still has its privileges. For Trent Alexander-Arnold that means on the Liverpool coach his teammates are out of luck if they want to watch something that clashes with Formula One. Alexander-Arnold adores the sport and he has a powerful ally with a shared interest.\r\n\r\n“Virgil van Dijk loves F1, too, he’s a huge Max Verstappen fan of course,” says Alexander-Arnold of his teammate’s fellow Dutchman.\r\n\r\n“Him being captain and me being vice-captain means we get to decide what’s on the TV if we are travelling on the coach. So we overrule any other sport. A race clashed with golf and we had to pull rank to get the race on. A lot of the lads are golf fans so they weren’t happy.”\r\n\r\nFootball has always come first for the Liverpool and England right-back but he has an enthusiasm for F1 stretching back to watching it when he was six with his father. This past week he became directly involved in the sport as one of the backers in the Apex investment group that has bought a stake in the Alpine F1 team.\r\nF1 Academy managing director Susie Wolff\r\nF1 Academy season climax in Austin speeds women closer to main grid\r\nRead more\r\n\r\nThe pleasure it brings to be part of the sport is writ large as he discusses the decision to get involved. He attended his first race at Silverstone last year and was at the Spanish GP in June. “TV doesn’t do it justice. It was one the most special things I have ever seen up close,” he says. “Seeing how the team works and operated it was mind-blowing. It was one the best experiences I’ve ever had, it was incredible.”\r\n\r\nFor Alexander-Arnold, his investment is an opportunity to be part of something he holds dear. The 25-year-old reels off a list of summer grands prix that he will try to attend when his footballing commitments wind down with the ease of a man who has already thought long and hard about them. He also feels the sport, for all that it is a world away from football, shares some common ground in the nature of top-level competition.\r\n\r\n“I like to see how the F1 teams can squeeze out the finest details just to get a little bit ahead of the opposition,” he says. “That was something that was really intriguing to me, because – at the highest level – as players and as teams we compete at a fairly similar level. It comes down to the small differences that you can make so you have that edge. Every day, every year, every time you train and compete it’s about finding those fine margins that the opposition is not doing. That was something that resonated with me.”\r\n\r\n    In my sport there are a lot of players that look like me, but in F1 it was a lot different for Lewis\r\n\r\nTrent Alexander-Arnold\r\n\r\nAlexander-Arnold grew up admiring Michael Schumacher and Ferrari during their all-conquering prime of the early 2000s after which, while football has dominated his life, he stayed in touch with F1, not least in noting the arrival and talent of Lewis Hamilton, whom he came to appreciate as a pioneering black athlete in a predominantly white sport.\r\n\r\n“In my sport there are a lot of players that look like me so I thought it was the same in every sport,” he says. “But in F1 it was a lot different for Lewis. The struggles he went through to make it and not only getting into F1 but also being one of the best drivers to ever live is incredibly inspiring.”\r\n\r\nAlexander-Arnold’s Liverpool teammates greeted his entry into F1 with great interest and he concedes Alpine’s performance will be under no little scrutiny at Anfield. “All the lads were asking questions wanting to know about it,” he says. “They were really excited by it because it’s something that doesn’t really happen in football. So if we have a bad weekend on track then I will get a bit of stick but hopefully I will be the one laughing in the end.”', 'https://www.theguardian.com/sport/2023/oct/22/virgil-van-dijk-loves-f1-trent-alexander-arnold-alpine', '2023-10-25 15:34:14', '2023-10-25 15:34:14'),
(8, 4, 'suso-i-could-understand-gerrard-but-carragher-was-incredible-sevilla-arsenal', 'Suso: ‘I could understand Gerrard but Carragher was incredible', 'thumbnails/Y6HpfTLmPNJaSI057bZJGRI8WRHUr6Ld0BvbdP44.jpg', 'When Suso glances across at the 11 men lined up on the other side of the tunnel on Tuesday evening, the guy with the armband wearing No 8 will look familiar. Nine years have passed, it was brief and much has changed, but the hair hasn’t.', 'When Suso glances across at the 11 men lined up on the other side of the tunnel on Tuesday evening, the guy with the armband wearing No 8 will look familiar. Nine years have passed, it was brief and much has changed, but the hair hasn’t.\r\n\r\n“A little blond kid,” the Sevilla forward says. Officially, he and Martin Ødegaard have never been on a football pitch together but there was a time when they shared a field daily, their careers ahead of them. The Norwegian was 15, the Spaniard 20. More than 700 senior games later, they meet again.\r\n\r\n“When I was at Liverpool, Ødegaard came to try out with us for a week,” Suso says. “It was that time when everyone wanted him. He trained with Madrid, with Liverpool and a few others. He stood out: left-footed, which I always notice more as a left-footer myself, hair like it is now. He had lots of ability. I don’t think I’ve seen him since.”\r\n\r\nØdegaard was a kid, Europe’s most sought-after footballer: it was not him on trial, it was the clubs, Liverpool, Barcelona and Bayern Munich among them. But while he got to choose Madrid and is Arsenal captain at 24, that didn’t make it easy. Just how hard it can be is easily overlooked, Suso says. It is also underlined by the company they kept.\r\n\r\nSuso, too, could have joined Madrid but had left home for Liverpool at 16, alone, the latest talented young Spaniard signed by Rafa Benítez. The week he arrived, in November 2010, Mikel San José departed and Antonio Barragán had already gone, but there was Dani Pacheco, Dani Ayala and Francis Durán.\r\n\r\n“We had agreed everything verbally with Madrid: we had been there to see the residency, the schools, the training ground, everything,” Suso says. “That same day, Pedro Campos and Eduardo Macià, who worked with Rafa, called and said: ‘Don’t go there,’ that they would sort it with Cádiz.\r\n\r\n“It was a period where young players in Spain weren’t getting opportunities, whereas in England they played the Carling Cup, the FA Cup. As a project and a culture, it attracted me more. Opportunities in Spain were always there; maybe the chance to join Liverpool was only going to be once in a lifetime. I had always lived at home with my parents and going somewhere so far away, so different to Cádiz, was a big change.”\r\n\r\nCádiz is in Spain’s south-west corner, a warm, funny place, home of the country’s most famous carnival. He arrived at a club changing ownership and coaches, 1,175 miles north. Benítez was gone. He moved flat “three or four times”. One teammate recalls Suso’s car window being smashed, his wallet stolen. Then there was the language.', 'https://www.theguardian.com/football/2023/oct/23/suso-i-could-understand-gerrard-but-carragher-was-incredible-sevilla-arsenal', '2023-10-25 15:37:08', '2023-10-25 15:37:08');

-- --------------------------------------------------------

--
-- Estrutura da tabela `password_reset_tokens`
--

CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) NOT NULL,
  `tokenable_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `token` varchar(64) NOT NULL,
  `abilities` text DEFAULT NULL,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'joaosilva', 'joao@123.com', NULL, '$2y$10$c4HRoOAQG6qKRP/ngZqA1OJIw4rxOHE8O9.UyLs5ERm4wvsNhur3y', 'U6bdkcclWd6Uih6tOGA9jc2MZZ71eIhzHkXUOHcK6gfsMsdlr4PuRSnlpJ9N', '2023-11-21 16:53:27', '2023-11-21 16:53:27');

-- --------------------------------------------------------

--
-- Estrutura da tabela `workout_plans`
--

CREATE TABLE `workout_plans` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `exerciseSet_id` int(11) NOT NULL,
  `workoutId` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `app_users`
--
ALTER TABLE `app_users`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `categories_slug_unique` (`slug`);

--
-- Índices para tabela `dietary_types`
--
ALTER TABLE `dietary_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dietary_types_name_unique` (`name`),
  ADD UNIQUE KEY `dietary_types_slug_unique` (`slug`);

--
-- Índices para tabela `exercises`
--
ALTER TABLE `exercises`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `exercise_sets`
--
ALTER TABLE `exercise_sets`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `exercise_steps`
--
ALTER TABLE `exercise_steps`
  ADD PRIMARY KEY (`id`),
  ADD KEY `exercise_steps_exercise_id_foreign` (`exercise_id`);

--
-- Índices para tabela `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Índices para tabela `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `meals`
--
ALTER TABLE `meals`
  ADD PRIMARY KEY (`id`),
  ADD KEY `meals_dietary_types_id_foreign` (`dietary_types_id`),
  ADD KEY `meals_meal_types_id_foreign` (`meal_types_id`);

--
-- Índices para tabela `meal_ingredients`
--
ALTER TABLE `meal_ingredients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `meal_ingredients_ingredients_id_foreign` (`ingredients_id`),
  ADD KEY `meal_ingredients_meal_id_foreign` (`meal_id`);

--
-- Índices para tabela `meal_types`
--
ALTER TABLE `meal_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `meal_types_name_unique` (`name`),
  ADD UNIQUE KEY `meal_types_slug_unique` (`slug`);

--
-- Índices para tabela `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `news_slug_unique` (`slug`),
  ADD KEY `news_category_id_foreign` (`category_id`);

--
-- Índices para tabela `password_reset_tokens`
--
ALTER TABLE `password_reset_tokens`
  ADD PRIMARY KEY (`email`);

--
-- Índices para tabela `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`);

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- Índices para tabela `workout_plans`
--
ALTER TABLE `workout_plans`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `app_users`
--
ALTER TABLE `app_users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de tabela `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `dietary_types`
--
ALTER TABLE `dietary_types`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `exercises`
--
ALTER TABLE `exercises`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `exercise_sets`
--
ALTER TABLE `exercise_sets`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `exercise_steps`
--
ALTER TABLE `exercise_steps`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `ingredients`
--
ALTER TABLE `ingredients`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de tabela `meals`
--
ALTER TABLE `meals`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `meal_ingredients`
--
ALTER TABLE `meal_ingredients`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT de tabela `meal_types`
--
ALTER TABLE `meal_types`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `news`
--
ALTER TABLE `news`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `workout_plans`
--
ALTER TABLE `workout_plans`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `exercise_steps`
--
ALTER TABLE `exercise_steps`
  ADD CONSTRAINT `exercise_steps_exercise_id_foreign` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `meals`
--
ALTER TABLE `meals`
  ADD CONSTRAINT `meals_dietary_types_id_foreign` FOREIGN KEY (`dietary_types_id`) REFERENCES `dietary_types` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `meals_meal_types_id_foreign` FOREIGN KEY (`meal_types_id`) REFERENCES `meal_types` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `meal_ingredients`
--
ALTER TABLE `meal_ingredients`
  ADD CONSTRAINT `meal_ingredients_ingredients_id_foreign` FOREIGN KEY (`ingredients_id`) REFERENCES `ingredients` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `meal_ingredients_meal_id_foreign` FOREIGN KEY (`meal_id`) REFERENCES `meals` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `news_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
