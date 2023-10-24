<?php

namespace App\Models;

use App\Models\ExerciseSet;
use App\Models\ExerciseSteps;

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
}
