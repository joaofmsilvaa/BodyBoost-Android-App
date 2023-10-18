<?php

namespace App\Http\Controllers;

use App\Models\Meal;
use App\Models\User;
use App\Models\News;
use App\Models\Ingredients;
use App\Models\MealIngredients;
use Illuminate\Http\Request;
use Illuminate\Validation\Rule;

use App\Http\Controllers\Controller;
use App\Providers\RouteServiceProvider;
use Illuminate\Auth\Events\Registered;
use Illuminate\Http\RedirectResponse;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Validation\Rules;
use Illuminate\View\View;


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
    public function createIngredients(){
        $ingredients = Ingredients::latest()
            ->paginate(10);

        return view('admin.ingredients.create', [
            'ingredients' => $ingredients
        ]);
    }
    public function createMealIngredients(){
        $mealIngredients = MealIngredients::latest()
            ->paginate(10);

        return view('admin.mealIngredients.create', [
            'mealIngredients' => $mealIngredients
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
    public function destroyIngredient(Ingredients $ingredient){
        $ingredient->delete();

        return back()->with('success', 'Ingredient Deleted');
    }
    public function destroyMealIngredients(MealIngredients $mealIngredient){
        $mealIngredient->delete();

        return back()->with('success', 'Ingredient removed from meal');
    }


    public function editUser(User $user){
        return view('admin.users.edit', ['user' => $user]);
    }
    public function editMeal(Meal $meal){
        return view('admin.meals.edit', ['meal' => $meal]);
    }
    public function editNews(News $news){
        return view('admin.news.edit', ['news' => $news]);
    }
    public function editIngredient(Ingredients $ingredient){
        return view('admin.ingredients.edit', ['ingredient' => $ingredient]);
    }
    public function editMealIngredients(MealIngredients $mealIngredient){
        return view('admin.mealIngredients.edit', ['mealIngredient' => $mealIngredient]);
    }


    public function updateUser(User $user){

        $attributes = request()->validate([
            'name' => ['required','max:30'],
            'email' => ['required', 'email', Rule::unique('users', 'email')->ignore($user->id)],
            'password' => [Rules\Password::defaults()],
        ]);


        $user->update($attributes);

        return back()->with('success', 'User Updated');

    }
    public function updateMeal(Meal $meal){
        $attributes = request()->validate([
            'name'=>'required',
            'thumbnail' => ['image'],
            'excerpt'=>['required', 'min:20', 'max:255' ],
            'recipe'=>['required', 'min:20'],
            'prep_time'=>'required',
            'cook_time'=>'required',
            'servings'=>['required', 'min:1'],
            'dietary_types_id' => ['required', Rule::exists('dietary_types', 'id')],
            'meal_types_id' => ['required', Rule::exists('meal_types', 'id')],
        ]);

        if(isset($attributes['thumbnail'])){
            $storingPath = request()->file('thumbnail')->store('public/thumbnails');
            $attributes['thumbnail'] = str_replace("public/", "",$storingPath);

        }


        $meal->update($attributes);

        return back()->with('success', 'Meal Updated');

    }
    public function updateIngredient(Ingredients $ingredient){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
        ]);

        $ingredient->update($attributes);

        return back()->with('success', 'Ingredient Updated');

    }
    public function updateMealIngredients(MealIngredients $mealIngredient){

        $attributes = request()->validate([
            'amount'=>'required',
            'measure'=>'required',
            'time'=>'required',
            'ingredients_id' => ['required', Rule::exists('ingredients', 'id')],
            'meal_id' => ['required', Rule::exists('meals', 'id')],
        ]);


        $mealIngredient->update($attributes);

        return back()->with('success', 'Meal Updated');

    }


    public function newIngredient(){
        return view('admin.Ingredients.new');
    }
    public function newMealIngredient(){
        return view('admin.MealIngredients.new');
    }

    public function newMeal(){
        return view('admin.Meals.new');
    }


    public function storeNewIngredient(){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
        ]);

        Ingredients::create($attributes);

        return back()->with('success', 'Ingredient created');
    }
    public function storeNewMealIngredient(){

        $attributes = request()->validate([
            'amount'=>'required',
            'measure'=>'required',
            'time'=>'required',
            'ingredients_id' => ['required', Rule::exists('ingredients', 'id')],
            'meal_id' => ['required', Rule::exists('meals', 'id')],
        ]);


        MealIngredients::create($attributes);

        return back()->with('success', 'Ingredient added to meal');

    }
    public function storeNewMeal(){
        $attributes = request()->validate([
            'name'=>'required',
            'thumbnail' => ['image'],
            'excerpt'=>['required', 'min:20', 'max:255' ],
            'recipe'=>['required', 'min:20'],
            'prep_time'=>'required',
            'cook_time'=>'required',
            'servings'=>['required', 'min:1'],
            'dietary_types_id' => ['required', Rule::exists('dietary_types', 'id')],
            'meal_types_id' => ['required', Rule::exists('meal_types', 'id')],
        ]);

        if(isset($attributes['thumbnail'])){
            $storingPath = request()->file('thumbnail')->store('public/thumbnails');
            $attributes['thumbnail'] = str_replace("public/", "",$storingPath);

        }


        Meal::create($attributes);

        return back()->with('success', 'Meal created');

    }

}

