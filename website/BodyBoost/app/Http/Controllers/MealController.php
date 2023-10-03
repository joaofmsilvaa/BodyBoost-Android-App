<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Meal;

class MealController extends Controller
{
    public function create(){
        $filters = request(['search']);

        $meals = Meal::latest()
            ->filter($filters)
            ->paginate(15);


        return view('nutrition', compact('meals'));
    }
}
