<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class ApiDocsController extends Controller
{
    public function create(){
        return view('api.welcome');

    }

    public function createMeals(){
        return view('api.meals');

    }
    public function createIngredientsMeal(){
        return view('api.ingredientsmeals');

    }
    public function createIngredientsInMeal(){
        return view('api.ingredientsinmeal');

    }
    public function createNews(){
        return view('api.news');

    }
}
