<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Model>
 */
class MealFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'name' => fake()->sentence(2),
            'meal_type' => fake()->word(),
            'dietary_type' => fake()->word(),
            'recipe' => fake()->sentence(10),
            'prep_time' => fake()->randomFloat(2, 10, 120),
            'cook_time' => fake()->randomFloat(2, 10, 180),
            'servings' => fake()->numberBetween(1, 10),
            'thumbnail' => 'images/logo.png',
            ];
    }
}
