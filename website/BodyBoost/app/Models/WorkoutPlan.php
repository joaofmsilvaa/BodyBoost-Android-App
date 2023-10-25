<?php

namespace App\Models;

use App\Models\ExerciseSet;
use App\Models\Exercise;

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

    public function exercises()
    {
        return $this->belongsTo(Exercise::class, 'exercise_id');
    }
}
