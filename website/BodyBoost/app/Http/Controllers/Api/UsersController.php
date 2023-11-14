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

        $newUsername = $request->input('username');

        $existingUserWithUsername = AppUser::where('username', $newUsername)->first();

        if ($existingUserWithUsername) {
            return response()->json(['message' => 'Username not available'], 422);
        }
        else{
            $user = AppUser::create(request()->all());

            return new AppUserResource($user);
        }


    }

    public function show(Request $request)
    {
        $username = $request->input('username');
        $password = $request->input('password');

        $user = AppUser::where('username', $username)->where('password', $password)->first();

        if ($user) {
            return new AppUserResource($user);
        } else {
            return response()->json(['message' => 'User not found or wrong password'], 404);
        }
    }

    public function update(Request $request, $id){

        $user = AppUser::find($id);

        if(isset($user)){

            $newUsername = $request->input('username');

            $existingUserWithUsername = AppUser::where('username', $newUsername)->where('id', '!=', $id)->first();

            if ($existingUserWithUsername) {
                return response()->json(['message' => 'Username not available'], 422);
            }
            else{
                $user->update($request->all());

                return new AppUserResource($user);
            }

        }
        else{
            return response()->json(['message' => 'User not found with the given Id'], 404);

        }

    }

}
