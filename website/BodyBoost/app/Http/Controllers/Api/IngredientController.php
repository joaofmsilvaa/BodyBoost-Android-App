<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\Controller;
use App\Http\Resources\IngredientResource;
use App\Models\Ingredients;
use App\Models\Meal;
use Illuminate\Http\Request;


class IngredientController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index($id)
    {
        $meal = Meal::find($id);

        if (!$meal) {
            return response()->json(['message' => 'Refeição não encontrada'], 404);
        }

        $ingredients = $meal->mealIngredients->map(function ($mealIngredient) {
            return $mealIngredient->ingredients;
        });
        
        return IngredientResource::collection($ingredients);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(Ingredients $ingredients)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Ingredients $ingredients)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Ingredients $ingredients)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Ingredients $ingredients)
    {
        //
    }
}
