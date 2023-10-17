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
});

Route::get('nutrition', [MealController::class, 'create']);
Route::get('nutrition/{meal}', [MealController::class, 'show']);

Route::get('news', [NewsController::class, 'create']);

Route::get('admin/users', [AdminController::class, 'createUsers'])->middleware(['auth', 'admin'])->name('admin');;
Route::get('admin/meals', [AdminController::class, 'createMeals'])->middleware(['auth', 'admin'])->name('admin');;
Route::get('admin/news', [AdminController::class, 'createNews'])->middleware(['auth', 'admin'])->name('admin');;

Route::delete('/admin/users/{user}', [AdminController::class, 'destroyUser'])->middleware('admin');
Route::delete('/admin/meals/{meal}', [AdminController::class, 'destroyMeal'])->middleware('admin');
Route::delete('/admin/news/{news}', [AdminController::class, 'destroyNews'])->middleware('admin');

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');

});

require __DIR__.'/auth.php';
