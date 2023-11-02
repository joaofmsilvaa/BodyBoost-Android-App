<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use App\Models\MealIngredients;
use Illuminate\Http\Resources\Json\JsonResource;

class MealResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'id' => $this->id,
            'name' => $this->name,
            'dietary_types_id' => $this->dietary_types_id,
            'meal_types_id' => $this->meal_types_id,
            'excerpt' => $this->excerpt,
            'recipe' => $this->recipe,
            'prep_time' => $this->prep_time,
            'cook_time' => $this->cook_time,
            'servings' => $this->servings,
            'calories' => $this->calories,
            'thumbnail' => $this->thumbnail,
            'created_at' => $this->created_at,
            'ingredients' => MealIngredients::where('meal_id', $this->id)->with('ingredients')->get()
        ];
    }
}
