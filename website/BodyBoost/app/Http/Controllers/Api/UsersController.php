<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Resources\AppUserResource;
use Illuminate\Http\Request;
use App\Models\AppUser;


class UsersController extends Controller
{
    public function store(Request $request)
    {

        $user = AppUser::create(request()->all());

        return new AppUserResource($user);
    }

}
