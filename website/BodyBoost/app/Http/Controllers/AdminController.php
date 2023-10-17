<?php

namespace App\Http\Controllers;

use App\Models\Meal;
use App\Models\User;
use App\Models\News;
use Illuminate\Http\Request;

class AdminController extends Controller
{
    public function createMeals(){

        $meals = Meal::latest()
            ->paginate(10);

        return view('admin.meals.create', [
            'meals' => $meals
        ]);
    }

    public function createUsers(){
        $users = User::latest()
            ->paginate(10);


        return view('admin.users.create', [
            'users' => $users
        ]);
    }

    public function createNews(){
        $news = News::latest()
            ->paginate(10);

        return view('admin.news.create', [
            'news' => $news
        ]);
    }
}

