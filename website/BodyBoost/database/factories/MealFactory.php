<?php

namespace Database\Factories;

use App\Models\DietaryTypes;
use App\Models\MealType;
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
            'dietary_types_id' => DietaryTypes::factory(),
            'meal_types_id' => MealType::factory(),
            'name' => fake()->sentence(2),
            'excerpt' => fake()->sentence(5),
            'recipe' => fake()->paragraphs(6),
            'prep_time' => fake()->randomFloat(2, 10, 120),
            'cook_time' => fake()->randomFloat(2, 10, 180),
            'servings' => fake()->numberBetween(1, 10),
            'thumbnail' => 'images/logo.png',
            ];
    }
}
