<?php

namespace App\Models;

use App\Models\ExerciseSet;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class WorkoutPlan extends Model
{
    use HasFactory;

    protected $guarded = [];

    public function exerciseSets()
    {
        return $this->hasMany(ExerciseSet::class);
    }
}
