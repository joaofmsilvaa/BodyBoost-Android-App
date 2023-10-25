<?php

namespace App\Models;

use App\Models\ExerciseSet;
use App\Models\ExerciseSteps;
use App\Models\WorkoutPlan;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Exercise extends Model
{
    use HasFactory;

    protected $guarded = [];

    public function exerciseSet()
    {
        return $this->hasMany(ExerciseSet::class);
    }

    public function exerciseSteps()
    {
        return $this->hasMany(ExerciseSteps::class);
    }

    public function workoutPlans()
    {
        return $this->hasMany(WorkoutPlan::class);
    }
}
