<?php

namespace App\Models;

use App\Models\Exercise;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class ExerciseSteps extends Model
{
    use HasFactory;

    protected $guarded = [];

    public function exercises()
    {
        return $this->belongsToMany(Exercise::class);
    }

}
