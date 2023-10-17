<?php

namespace Database\Factories;

use App\Models\Ingredients;
use App\Models\Meal;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\MealIngredients>
 */
class MealIngredientsFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'ingredients_id' => Ingredients::factory(),
            'meal_id' => Meal::factory(),
            'amount' => $this->faker->randomFloat(2, 0.1, 10.0),
            'measure' => $this->faker->word,
            'time' => $this->faker->optional(0.7)->randomNumber(),
        ];
    }
}
