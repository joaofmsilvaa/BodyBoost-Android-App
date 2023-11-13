<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Resources\AppUserResource;
use Illuminate\Http\Request;
use App\Models\AppUser;


class UsersController extends Controller
{
    public function store()
    {

        $user = AppUser::create(request()->all());

        return new AppUserResource($user);
    }

    public function show(Request $request)
    {
        $username = $request->input('username');
        $password = $request->input('password');

        $user = AppUser::where('username', $username)->where('password', $password)->first();

        if ($user) {
            return new AppUserResource($user);
        } else {
            return response()->json(['message' => 'Usuário não encontrado ou senha incorreta'], 404);
        }
    }

}
