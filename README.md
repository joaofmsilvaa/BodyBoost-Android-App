<div align="center">
 <img src="images/BodyBoostIcon.png" alt="Logo" width="160" height="auto">  
</div>


# Bodyboost

The project has a mobile application and website for exercise and healthy meals aimed at people who can't go to a gym or get dietary advice by other means. The project is focused in an API powered mobile app and the API itself. The mobile app provides meals, news and exercise plans as well as user registration and log-in.

## Functionalities

- Comercial website with meals and news
- Responsive website
- Strong Laravel API
- API powered mobile app developed in Android Studio

<!-- ROADMAP -->
## Roadmap

- [X] Code the structure of the inicial menu
  - [X] Make the progress bar functional
    - [X] Style the progress bar 
  - [X] Make the navigation bar functional
    - [X] Style the navigation bar 
  - [X] Make the cards functional
    - [X] Style the cards 
- [X] Code the structure of the user profile
  - [X] Let him change his personal data
  
- [X] Code the structure of the workout list section
    - [X] Display the exercises corresponding to the users goal

- [X] Code the structure of the meal list section
  - [X] Make the "meals information" option functional
  
- [X] Code the structure of the statistics menu
  - [X] Make the weight list functional

- [X] Code the structure of the feed menu
  - [X] Make the "news consulting" option functional


## API Documentation

#### Return all meals

```
  GET /api/meals
```

| Type       | Description                           |
| :--------- | :---------------------------------- |
| `Array` | Returns all the meals with its informations |

#### Return the ingredients of a certain meal

```
  GET /api/meals/{id}/ingredients
```

| Type       | Description                                   |
| :--------- | :------------------------------------------ |
| `Array` | **Mandatory:** Must pass the id of the meal |

#### Return the relations between the ingredient and the meal

```
  GET /api/meals/{id}/meal-ingredients
```

| Type       | Description                                   |
| :--------- | :------------------------------------------ |
| `Array` | **Mandatory:** Must pass the id of the meal |


#### Return all news

```
  GET /api/news
```

| Type       | Description                                   |
| :--------- | :------------------------------------------ |
| `Array` | Retuns all the news with its informations |


## Deploy

To deploy the project open the folder of the website and initialize it.

```bash
  php artisan serve
```

Initialize and create the database "bodyboost" in XAMPP

Migrate the database
```bash
  php artisan migrate
```

Import our SQL file to your XAMPP database

Open the mobile app in the android studio emulator and enjoy.

## License
Distributed under the MIT License. See LICENSE.txt for more information.


## Authors

- [@joao7640](https://www.github.com/joao7640)
- [@SaiNt._.LuKe](https://github.com/IM-SaiNt-LuKe)
