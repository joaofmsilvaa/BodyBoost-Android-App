<?php

namespace App\Http\Controllers;

use App\Models\Meal;
use Illuminate\Http\Request;

class AdminController extends Controller
{
    public function create(){

        $meals = Meal::latest()
            ->paginate(15);

        return view('admin.create', [
            'meals' => $meals
        ]);
    }
}
