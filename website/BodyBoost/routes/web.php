<?php

use App\Http\Controllers\ProfileController;
use App\Http\Controllers\NewsController;
use App\Http\Controllers\MealController;
use App\Http\Controllers\AdminController;
use Illuminate\Support\Facades\Route;



/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', function () {

    return view('welcome');
})->name('home');

Route::get('privacy-police', function () {
    return view('privacyPolice');
});

Route::get('terms', function () {
    return view('terms');
});

Route::get('nutrition', [MealController::class, 'create']);
Route::get('nutrition/{meal}', [MealController::class, 'show']);

Route::get('news', [NewsController::class, 'create']);
Route::get('news/{news}', [NewsController::class, 'show']);

Route::get('admin/users', [AdminController::class, 'createUsers'])->middleware(['auth', 'admin'])->name('adminUsers');
Route::get('admin/meals', [AdminController::class, 'createMeals'])->middleware(['auth', 'admin'])->name('adminMeals');
Route::get('admin/ingredients', [AdminController::class, 'createIngredients'])->middleware(['auth', 'admin']);
Route::get('admin/meal-ingredients', [AdminController::class, 'createMealIngredients'])->middleware(['auth', 'admin']);
Route::get('admin/news', [AdminController::class, 'createNews'])->middleware(['auth', 'admin']);
Route::get('admin/meal-types', [AdminController::class, 'createMealTypes'])->middleware(['auth', 'admin']);
Route::get('admin/dietary-types', [AdminController::class, 'createDietaryTypes'])->middleware(['auth', 'admin']);
Route::get('admin/categories', [AdminController::class, 'createCategories'])->middleware(['auth', 'admin']);

Route::get('admin/exercises', [AdminController::class, 'createExercises'])->middleware(['auth', 'admin']);
Route::get('admin/exercise-sets', [AdminController::class, 'createExerciseSets'])->middleware(['auth', 'admin']);
Route::get('admin/exercise-steps', [AdminController::class, 'createExerciseSteps'])->middleware(['auth', 'admin']);
Route::get('admin/workout-plans', [AdminController::class, 'createWorkoutPlans'])->middleware(['auth', 'admin']);


Route::delete('/admin/users/{user}', [AdminController::class, 'destroyUser'])->middleware('admin');
Route::delete('/admin/meals/{meal}', [AdminController::class, 'destroyMeal'])->middleware('admin');
Route::delete('/admin/ingredients/{ingredient}', [AdminController::class, 'destroyIngredient'])->middleware('admin');
Route::delete('/admin/meal-ingredients/{mealIngredient}', [AdminController::class, 'destroyMealIngredients'])->middleware('admin');
Route::delete('/admin/news/{news}', [AdminController::class, 'destroyNews'])->middleware('admin');
Route::delete('/admin/meal-types/{mealType}', [AdminController::class, 'destroyMealType'])->middleware('admin');
Route::delete('/admin/dietary-types/{dietaryType}', [AdminController::class, 'destroyDietaryType'])->middleware('admin');
Route::delete('/admin/categories/{category}', [AdminController::class, 'destroyCategory'])->middleware('admin');

Route::delete('/admin/exercises/{exercise}', [AdminController::class, 'destroyExercise'])->middleware('admin');
Route::delete('/admin/exercise-sets/{exerciseSet}', [AdminController::class, 'destroyExerciseSet'])->middleware('admin');
Route::delete('/admin/exercise-steps/{exerciseSteps}', [AdminController::class, 'destroyExerciseStep'])->middleware('admin');
Route::delete('/admin/workout-plans/{workoutPlan}', [AdminController::class, 'destroyWorkoutPlan'])->middleware('admin');


Route::get('/admin/users/{user}/edit', [AdminController::class, 'editUser'])->middleware('admin');
Route::get('/admin/meals/{meal}/edit', [AdminController::class, 'editMeal'])->middleware('admin');
Route::get('/admin/ingredients/{ingredient}/edit', [AdminController::class, 'editIngredient'])->middleware('admin');
Route::get('/admin/meal-ingredients/{mealIngredient}/edit', [AdminController::class, 'editMealIngredients'])->middleware('admin');
Route::get('/admin/news/{news}/edit', [AdminController::class, 'editNews'])->middleware('admin');
Route::get('/admin/meal-types/{mealType}/edit', [AdminController::class, 'editMealType'])->middleware('admin');
Route::get('/admin/dietary-types/{dietaryType}/edit', [AdminController::class, 'editDietaryType'])->middleware('admin');
Route::get('/admin/categories/{category}/edit', [AdminController::class, 'editCategory'])->middleware('admin');

Route::get('/admin/exercises/{exercise}/edit', [AdminController::class, 'editExercise'])->middleware('admin');
Route::get('/admin/exercise-sets/{exerciseSet}/edit', [AdminController::class, 'editExerciseSet'])->middleware('admin');
Route::get('/admin/exercise-steps/{exerciseStep}/edit', [AdminController::class, 'editExerciseStep'])->middleware('admin');
Route::get('/admin/workout-plans/{workoutPlan}/edit', [AdminController::class, 'editWorkoutPlan'])->middleware('admin');


Route::patch('/admin/users/{user}', [AdminController::class, 'updateUser'])->middleware('admin');
Route::patch('/admin/meals/{meal}', [AdminController::class, 'updateMeal'])->middleware('admin');
Route::patch('/admin/ingredients/{ingredient}', [AdminController::class, 'updateIngredient'])->middleware('admin');
Route::patch('/admin/meal-ingredients/{mealIngredient}', [AdminController::class, 'updateMealIngredients'])->middleware('admin');
Route::patch('/admin/news/{news}', [AdminController::class, 'updateNews'])->middleware('admin');
Route::patch('/admin/meal-types/{mealType}', [AdminController::class, 'updateMealType'])->middleware('admin');
Route::patch('/admin/dietary-types/{dietaryType}', [AdminController::class, 'updateDietaryType'])->middleware('admin');
Route::patch('/admin/categories/{category}', [AdminController::class, 'updateCategory'])->middleware('admin');

Route::patch('/admin/exercises/{exercise}', [AdminController::class, 'updateExercise'])->middleware('admin');
Route::patch('/admin/exercise-sets/{exerciseSet}', [AdminController::class, 'updateExerciseSet'])->middleware('admin');
Route::patch('/admin/exercise-steps/{exerciseSteps}', [AdminController::class, 'updateExerciseStep'])->middleware('admin');
Route::patch('/admin/workout-plans/{workoutPlan}', [AdminController::class, 'updateWorkoutPlan'])->middleware('admin');


Route::get('/admin/ingredients/create', [AdminController::class, 'newIngredient'])->middleware('admin');
Route::get('/admin/meal-ingredients/create', [AdminController::class, 'newMealIngredient'])->middleware('admin');
Route::get('/admin/meals/create', [AdminController::class, 'newMeal'])->middleware('admin');
Route::get('/admin/news/create', [AdminController::class, 'newNews'])->middleware('admin');
Route::get('/admin/meal-types/create', [AdminController::class, 'newMealType'])->middleware('admin');
Route::get('/admin/dietary-types/create', [AdminController::class, 'newDietaryType'])->middleware('admin');
Route::get('/admin/categories/create', [AdminController::class, 'newCategory'])->middleware('admin');

Route::get('/admin/exercises/create', [AdminController::class, 'newExercise'])->middleware('admin');
Route::get('/admin/exercise-sets/create', [AdminController::class, 'newExerciseSet'])->middleware('admin');
Route::get('/admin/exercise-steps/create', [AdminController::class, 'newExerciseStep'])->middleware('admin');
Route::get('/admin/workout-plans/create', [AdminController::class, 'newWorkoutPlan'])->middleware('admin');


Route::post('/admin/ingredients/create', [AdminController::class, 'storeNewIngredient'])->middleware('admin');
Route::post('/admin/meal-ingredients/create', [AdminController::class, 'storeNewMealIngredient'])->middleware('admin');
Route::post('/admin/meals/create', [AdminController::class, 'storeNewMeal'])->middleware('admin');
Route::post('/admin/news/create', [AdminController::class, 'storeNewNews'])->middleware('admin');
Route::post('/admin/meal-types/create', [AdminController::class, 'storeNewMealType'])->middleware('admin');
Route::post('/admin/dietary-types/create', [AdminController::class, 'storeNewDietaryType'])->middleware('admin');
Route::post('/admin/categories/create', [AdminController::class, 'storeNewCategory'])->middleware('admin');

Route::post('/admin/exercises/create', [AdminController::class, 'storeNewExercise'])->middleware('admin');
Route::post('/admin/exercise-sets/create', [AdminController::class, 'storeNewExerciseSet'])->middleware('admin');
Route::post('/admin/exercise-steps/create', [AdminController::class, 'storeNewExerciseStep'])->middleware('admin');
Route::post('/admin/workout-plans/create', [AdminController::class, 'storeNewWorkoutPlan'])->middleware('admin');


Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');

});

require __DIR__.'/auth.php';
