<?php

use App\Http\Controllers\ProfileController;
<<<<<<< Updated upstream
=======
use App\Http\Controllers\NewsController;
use App\Http\Controllers\MealController;
use App\Http\Controllers\AdminController;
>>>>>>> Stashed changes
use Illuminate\Support\Facades\Route;
use Jenssegers\Agent\Agent;
use App\Http\Controllers\MealController;


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
<<<<<<< Updated upstream

Route::get('/dashboard', function () {
    return view('dashboard');
})->middleware(['auth', 'verified'])->name('dashboard');
=======
Route::get('nutrition/{meal}', [MealController::class, 'show']);


Route::get('news', [NewsController::class, 'create']);

Route::get('admin/meals', [AdminController::class, 'create'])->middleware(['auth', 'admin'])->name('admin');;
>>>>>>> Stashed changes

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

require __DIR__.'/auth.php';
