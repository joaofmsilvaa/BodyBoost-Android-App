<?php

namespace App\Models;

use App\Models\MealIngredients;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class Meal extends Model
{
    use HasFactory;

    public function scopeFilter($query, array $filters)
    {

        if (isset($filters['search']) && $filters['search'] !== '') {
            $query->where(function ($query) use ($filters) {
                $search = $filters['search'];
                $query->where('name', 'like', '%' . $search . '%')
                    ->orWhere('recipe', 'like', '%' . $search . '%');
            });
        }

        $query->when($filters['dietary-type'] ?? false, fn($query, $dietaryType) => $query->whereExists(fn($query) => $query->from('dietary_types')
            ->whereColumn('dietary_types.id', 'meals.dietary_types_id')
            ->where('dietary_types.slug', $dietaryType))
        );

        $query->when($filters['meal-type'] ?? false, fn($query, $mealType) => $query->whereExists(fn($query) => $query->from('meal_types')
            ->whereColumn('meal_types.id', 'meals.meal_types_id')
            ->where('meal_types.slug', $mealType))
        );

    }

    public function mealIngredients()
    {
        return $this->hasMany(MealIngredients::class);
    }

    public function dietaryType()
    {
        return $this->belongsTo(DietaryTypes::class, 'dietary_types_id');
    }

    public function mealType()
    {
        return $this->belongsTo(mealType::class, 'meal_types_id');
    }
}
