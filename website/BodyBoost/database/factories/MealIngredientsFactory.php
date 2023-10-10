<?php

namespace Database\Factories;

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
            'ingredients_id' => function () {
                return \App\Models\Ingredients::factory()->create()->id;
            },
            'meal_id' => function () {
                return \App\Models\Meal::factory()->create()->id;
            },
            'amount' => $this->faker->randomFloat(2, 0.1, 10.0),
            'measure' => $this->faker->word,
            'time' => $this->faker->optional(0.7)->randomNumber(),
        ];
    }
}
