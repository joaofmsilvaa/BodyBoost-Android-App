<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\MealIngredients;

class Ingredients extends Model
{
    use HasFactory;

    protected $guarded = [];

    public function mealIngredients()
    {
        return $this->hasMany(MealIngredients::class);
    }
}
