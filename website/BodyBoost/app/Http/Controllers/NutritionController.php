<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Meal;

class NutritionController extends Controller
{
    public function create(){
        $meals = Meal::all();

        return view('nutrition', compact('meals'));
    }
}
