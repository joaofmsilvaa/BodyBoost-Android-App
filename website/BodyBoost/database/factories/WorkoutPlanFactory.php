<?php

namespace Database\Factories;

use App\Models\Exercise;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\WorkoutPlan>
 */
class WorkoutPlanFactory extends Factory
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
            'type' => $this->faker->word(),
            ];
    }
}
