<?php

namespace Database\Factories;

use App\Models\Exercise;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\ExerciseSet>
 */
class ExerciseSetFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'exercise_id' => Exercise::factory(),
            'dayId' => fake()->numberBetween(1, 7),
            'orderIndex' => fake()->numberBetween(1, 20),
            'exerciseSet_id' => fake()->numberBetween(1,20),
            'repetitions' => fake()->numberBetween(1, 20),
            'time' => fake()->numberBetween(1, 200),
        ];
    }
}
