<?php

namespace App\Http\Controllers;

use App\Models\Meal;
use App\Models\User;
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
<<<<<<< Updated upstream
=======
    public function createNews(){
        $news = News::latest()
            ->paginate(10);

        return view('admin.news.create', [
            'news' => $news
        ]);
    }

    public function destroyUser(User $user){
        $user->delete();

        return back()->with('success', 'User Deleted');
    }

    public function destroyMeal(Meal $meal){
        $meal->delete();

        return back()->with('success', 'Meal Deleted');
    }

    public function destroyNews(News $news){
        $news->delete();

        return back()->with('success', 'News Deleted');
    }
>>>>>>> Stashed changes
}

