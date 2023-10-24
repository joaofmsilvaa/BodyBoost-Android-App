<?php

namespace App\Http\Controllers;

use App\Models\Meal;
use App\Models\User;
use App\Models\News;
use App\Models\Ingredients;
use App\Models\MealIngredients;
use App\Models\MealType;
use App\Models\DietaryTypes;
use App\Models\Category;
use App\Models\Exercise;
use App\Models\ExerciseSet;
use App\Models\ExerciseSteps;
use App\Models\WorkoutPlan;

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

    public function createMealTypes(){

        $mealTypes = MealType::latest()
            ->paginate(10);

        return view('admin.MealTypes.create', [
            'mealTypes' => $mealTypes
        ]);
    }

    public function createDietaryTypes(){

        $dietaryTypes = DietaryTypes::latest()
            ->paginate(10);

        return view('admin.dietaryTypes.create', [
            'dietaryTypes' => $dietaryTypes
        ]);
    }

    public function createCategories(){

        $categories = Category::latest()
            ->paginate(10);

        return view('admin.categories.create', [
            'categories' => $categories
        ]);
    }

    public function createExercises(){

        $exercises = Exercise::latest()
            ->paginate(10);

        return view('admin.exercises.create', [
            'exercises' => $exercises
        ]);
    }

    public function createExerciseSets(){

        $exerciseSets = ExerciseSet::latest()
            ->paginate(10);

        return view('admin.exerciseSets.create', [
            'exerciseSets' => $exerciseSets
        ]);
    }

    public function createExerciseSteps(){

        $exerciseSteps = ExerciseSteps::latest()
            ->paginate(10);

        return view('admin.exerciseSteps.create', [
            'exerciseSteps' => $exerciseSteps
        ]);
    }

    public function createWorkoutPlans(){

        $workoutPlans = WorkoutPlan::latest()
            ->paginate(10);

        return view('admin.workoutPlans.create', [
            'workoutPlans' => $workoutPlans
        ]);
    }


    public function destroyUser(User $user){
        $user->delete();

        return back()->with('success', 'User Deleted');
    }

    public function destroyCategory(Category $category){
        $category->delete();

        return back()->with('success', 'Category Deleted');
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

    public function destroyMealType(MealType $mealType){
        $mealType->delete();

        return back()->with('success', 'Meal type deleted');
    }

    public function destroyDietaryType(DietaryTypes $dietaryType){
        $dietaryType->delete();

        return back()->with('success', 'Dietary type deleted');
    }

    public function destroyExercise(Exercise $exercise){
        $exercise->delete();

        return back()->with('success', 'Exercise deleted');
    }

    public function destroyExerciseSet(ExerciseSet $exerciseSet){
        $exerciseSet->delete();

        return back()->with('success', 'Exercise set deleted');
    }

    public function destroyExerciseStep(ExerciseSteps $exerciseSteps){
        $exerciseSteps->delete();

        return back()->with('success', 'Exercise steps deleted');
    }

    public function destroyWorkoutPlan(WorkoutPlan $workoutPlan){
        $workoutPlan->delete();

        return back()->with('success', 'Workout plan deleted');
    }


    public function editUser(User $user){
        return view('admin.users.edit', ['user' => $user]);
    }
    public function editCategory(Category $category){
        return view('admin.categories.edit', ['category' => $category]);
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

    public function editMealType(MealType $mealType){
        return view('admin.MealTypes.edit', ['mealType' => $mealType]);
    }

    public function editDietaryType(DietaryTypes $dietaryType){
        return view('admin.dietaryTypes.edit', ['dietaryType' => $dietaryType]);
    }

    public function editExercise(Exercise $exercise){
        return view('admin.exercises.edit', ['exercise' => $exercise]);
    }

    public function editExerciseSet(ExerciseSet $exerciseSet){
        return view('admin.exerciseSets.edit', ['exerciseSet' => $exerciseSet]);
    }

    public function editExerciseStep(ExerciseSteps $exerciseStep){
        return view('admin.exerciseSteps.edit', ['exerciseStep' => $exerciseStep]);
    }

    public function editWorkoutPlan(WorkoutPlan $workoutPlan){
        return view('admin.workoutPlans.edit', ['workoutPlan' => $workoutPlan]);
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

    public function updateNews(News $news){

        $attributes = request()->validate([
            'title'=>'required',
            'slug'=>'required',
            'thumbnail' => ['image'],
            'excerpt'=>['required', 'min:20', 'max:255' ],
            'body'=>['required', 'min:20'],
            'source'=>'required',
            'category_id' => ['required', Rule::exists('categories', 'id')],
        ]);

        if(isset($attributes['thumbnail'])){
            $storingPath = request()->file('thumbnail')->store('public/thumbnails');
            $attributes['thumbnail'] = str_replace("public/", "",$storingPath);

        }


        $news->update($attributes);

        return back()->with('success', 'News Updated');

    }

    public function updateIngredient(Ingredients $ingredient){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
        ]);

        $ingredient->update($attributes);

        return back()->with('success', 'Ingredient Updated');

    }
    public function updateCategory(Category $category){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
            'slug'=>['required', 'min:4'],
        ]);

        $category->update($attributes);

        return back()->with('success', 'Category Updated');

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

    public function updateMealType(MealType $mealType){

        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
            'slug'=>['required'],
        ]);


        $mealType->update($attributes);

        return back()->with('success', 'Meal type Updated');

    }

    public function updateDietaryType(DietaryTypes $dietaryType){

        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
            'slug'=>['required'],
        ]);


        $dietaryType->update($attributes);

        return back()->with('success', 'Dietary type Updated');

    }


    public function updateExercise(Exercise $exercise){

        $attributes = request()->validate([
            'exerciseName'=>'required',
            'exerciseDescription'=>['required', 'min:20', 'max:255' ],
        ]);

        $exercise->update($attributes);

        return back()->with('success', 'Exercise Updated');

    }

    public function updateExerciseSet(ExerciseSet $exerciseSet){

        $attributes = request()->validate([
            'dayId'=>['required'],
            'orderIndex'=>'required',
            'repetitions' => 'required',
            'time' => 'required',
            'exercise_id' => ['required', Rule::exists('exercises', 'id')],
        ]);



        $exerciseSet->update($attributes);

        return back()->with('success', 'Exercise Set Updated');

    }

    public function updateExerciseStep(ExerciseSteps $exerciseSteps){

        $attributes = request()->validate([
            'thumbnail' => ['image'],
            'exercise_id' => ['required', Rule::exists('exercises', 'id')],
        ]);

        if(isset($attributes['image'])){
            $storingPath = request()->file('image')->store('public/thumbnails');
            $attributes['image'] = str_replace("public/", "",$storingPath);

        }


        $exerciseSteps->update($attributes);

        return back()->with('success', 'Exercise Step Updated');

    }

    public function updateWorkoutPlan(WorkoutPlan $workoutPlan){

        $attributes = request()->validate([
            'dayId'=>['required'],
            'type'=>'required',
            'exercise_id' => ['required', Rule::exists('exercises', 'id')],
        ]);



        $workoutPlan->update($attributes);

        return back()->with('success', 'Workout plan Updated');

    }


    public function newIngredient(){
        return view('admin.Ingredients.new');
    }
    public function newCategory(){
        return view('admin.categories.new');
    }
    public function newMealIngredient(){
        return view('admin.MealIngredients.new');
    }

    public function newMeal(){
        return view('admin.Meals.new');
    }

    public function newNews(){
        return view('admin.News.new');
    }

    public function newMealType(){
        return view('admin.MealTypes.new');
    }

    public function newDietaryType(){
        return view('admin.DietaryTypes.new');
    }

    public function newExercise(){
        return view('admin.exercises.new');
    }

    public function newExerciseSet(){
        return view('admin.exerciseSets.new');
    }

    public function newExerciseStep(){
        return view('admin.exerciseSteps.new');
    }

    public function newWorkoutPlan(){
        return view('admin.workoutPlans.new');
    }


    public function storeNewIngredient(){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
        ]);

        Ingredients::create($attributes);

        return back()->with('success', 'Ingredient created');
    }
    public function storeNewCategory(){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
            'slug'=>['required', 'min:4']
        ]);

        Category::create($attributes);

        return back()->with('success', 'Category created');
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

    public function storeNewNews(){
        $attributes = request()->validate([
            'title'=>'required',
            'slug'=>'required',
            'thumbnail' => ['image'],
            'excerpt'=>['required', 'min:20', 'max:255' ],
            'body'=>['required', 'min:20'],
            'source'=>'required',
            'category_id' => ['required', Rule::exists('categories', 'id')],
        ]);

        if(isset($attributes['thumbnail'])){
            $storingPath = request()->file('thumbnail')->store('public/thumbnails');
            $attributes['thumbnail'] = str_replace("public/", "",$storingPath);

        }


        News::create($attributes);

        return back()->with('success', 'News created');

    }

    public function storeNewMealType(){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
            'slug'=>['required']
        ]);

        MealType::create($attributes);

        return back()->with('success', 'Meal type created');
    }

    public function storeNewDietaryType(){
        $attributes = request()->validate([
            'name'=>['required', 'min:4'],
            'slug'=>['required']
        ]);


        DietaryTypes::create($attributes);

        return back()->with('success', 'Dietary type created');
    }


    public function storeNewExercise(){

        $attributes = request()->validate([
            'exerciseName'=>'required',
            'exerciseDescription'=>['required', 'min:20', 'max:255' ],
        ]);

        Exercise::create($attributes);

        return back()->with('success', 'Exercise created');

    }

    public function storeNewExerciseSet(){

        $attributes = request()->validate([
            'dayId'=>['required'],
            'orderIndex'=>'required',
            'repetitions' => 'required',
            'time' => 'required',
            'exercise_id' => ['required', Rule::exists('exercises', 'id')],
        ]);



        ExerciseSet::create($attributes);

        return back()->with('success', 'Exercise Set created');

    }

    public function storeNewExerciseStep(){
        dd(request());
        $attributes = request()->validate([
            'image' => ['image'],
            'exercise_id' => ['required', Rule::exists('exercises', 'id')],
        ]);

        if(isset($attributes['image'])){
            $storingPath = request()->file('image')->store('public/thumbnails');
            $attributes['image'] = str_replace("public/", "",$storingPath);

        }


        ExerciseSteps::create($attributes);

        return back()->with('success', 'Exercise Step created');

    }

    public function storeNewWorkoutPlan(){

        $attributes = request()->validate([
            'dayId'=>['required'],
            'type'=>'required',
            'exercise_id' => ['required', Rule::exists('exercises', 'id')],
        ]);


        WorkoutPlan::create($attributes);

        return back()->with('success', 'Workout plan created');

    }

}

