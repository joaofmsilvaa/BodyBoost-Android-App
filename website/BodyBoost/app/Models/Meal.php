<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Meal extends Model
{
    use HasFactory;

    public function scopeFilter($query, array $filters)
    {

        if (isset($filters['search']) && $filters['search'] !== '') {
            $query->where(function ($query) use ($filters) {
                $search = $filters['search'];
                $query->where('name', 'like', '%' . $search . '%')
                    ->orWhere('recipe', 'like', '%' . $search . '%')
                    ->orWhere('dietary_type', 'like', '%' . $search . '%')
                    ->orWhere('meal_type', 'like', '%' . $search . '%');
            });
        }
    }
}
