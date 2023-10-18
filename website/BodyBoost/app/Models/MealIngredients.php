<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class MealIngredients extends Model
{
    use HasFactory;

    protected $guarded = [];

    public function meal()
    {
        return $this->belongsTo(Meal::class);
    }

    public function ingredients()
    {
        return $this->belongsTo(Ingredients::class);
    }

}
