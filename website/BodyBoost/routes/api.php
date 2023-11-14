<?php

use App\Http\Controllers\Api\MealsController;
use App\Http\Controllers\Api\IngredientController;
use App\Http\Controllers\Api\MealIngredientController;
use App\Http\Controllers\Api\NewsController;
use App\Http\Controllers\Api\UsersController;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::apiResource('meals',MealsController::class)->except([
    'create', 'show', 'edit'
]);
Route::apiResource('meals/{meal:id}/ingredients',IngredientController::class)->except([
    'create', 'show', 'edit'
]);
Route::apiResource('meals/{meal:id}/meal-ingredients', MealIngredientController::class)->except(['create', 'show', 'edit']);


Route::apiResource('appUser/store',UsersController::class)->except([
    'create', 'edit'
]);

Route::get('appUser/show', [UsersController::class, 'show']);

Route::put('appUser/update/{id}',[UsersController::class,'update']);

