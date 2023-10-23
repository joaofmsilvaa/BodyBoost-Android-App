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
        return $this->belongsTo(ExerciseSet::class);
    }

    public function exerciseSteps()
    {
        return $this->belongsToMany(ExerciseSteps::class);
    }
}
