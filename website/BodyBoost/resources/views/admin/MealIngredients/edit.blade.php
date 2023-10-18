@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Edit Meal Ingredient</h1>
            <form method="POST" action="/admin/meal-ingredients/{{$mealIngredient->id}}" enctype="multipart/form-data">
                @csrf
                @method('PATCH')

                <label for="amount" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Amount</label>
                <x-form.formInput name="amount" value="{{$mealIngredient->amount}}" type="number"/>
                @error('amount')
                <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                @enderror

                <div class="mt-3">
                    <label for="measure" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Measure</label>
                    <x-form.formInput name="measure" value="{{$mealIngredient->measure}}"/>
                    @error('measure')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="mt-3">
                    <label for="time" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Time ( minutes )</label>
                    <x-form.formInput name="time" value="{{$mealIngredient->time}}" type="number"/>
                    @error('time')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="mr-2">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ingredient</label>
                    <select name="ingredients_id" id="ingredients_id">
                        @php
                            $ingredients = App\Models\Ingredients::all();
                        @endphp

                        @foreach($ingredients as $ingredient)
                            <option value="{{$ingredient->id}}"
                                {{old('ingredients_id', $mealIngredient->ingredients_id) == $ingredient->id ? 'selected' : ''}}>
                                {{ucwords($ingredient->name)}}</option>
                        @endforeach

                    </select>

                    @error('ingredients_id')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror

                </div>

                <div class="mr-2">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Meal</label>
                    <select name="meal_id" id="meal_id">
                        @php
                            $meals = App\Models\Meal::all();
                        @endphp

                        @foreach($meals as $meal)
                            <option value="{{$meal->id}}"
                                {{old('meal_id', $mealIngredient->meal_id) == $meal->id ? 'selected' : ''}}>
                                {{ucwords($meal->name)}}</option>
                        @endforeach

                    </select>

                    @error('meal_id')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="flex justify-end mt-2 border-t border-gray-300">
                    <button type="submit"
                            class="bg-red-500 mt-2 text-white uppercase font-semibold text-xs py-2 px-10 rounded-2xl hover:bg-red-600">
                        Update
                    </button>
                </div>

            </form>
        </div>
    </div>
@endsection

