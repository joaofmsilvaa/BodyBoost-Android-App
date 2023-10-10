<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Meal;
use App\Models\MealIngredients;

class MealController extends Controller
{
    public function create(){
        $filters = request(['search']);

        $meals = Meal::latest()
            ->filter($filters)
            ->paginate(15);


        return view('nutrition.index', compact('meals'));
    }

    public function show(Meal $meal){

        $mealIngredients = $meal->mealIngredients()->orderBy('created_at', 'asc')->get();;

        $ingredients = $mealIngredients->map(function ($mealIngredients) {
            return $mealIngredients->ingredients;
        });

        return view('nutrition.show', compact('meal', 'ingredients'));
    }
}
