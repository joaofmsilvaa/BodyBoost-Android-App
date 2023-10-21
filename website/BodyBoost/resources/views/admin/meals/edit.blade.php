@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Edit meal</h1>
            <form method="POST" action="/admin/meals/{{$meal->id}}" enctype="multipart/form-data">
                @csrf
                @method('PATCH')

                <div class="mt-3">
                    <label for="name"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Thumbnail</label>
                    <div class="flex-col mt-6">
                        <div class="my-3">
                            @if(isset($meal->thumbnail))
                                <div
                                    class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                                    <a href="/nutrition/{{$meal->id}}">
                                        <img id="image_preview"
                                             alt="Meal thumbnail" class="rounded-t-lg h-60 w-full object-cover rounded"
                                             src="{{ asset('storage/' . $meal->thumbnail) }}" alt="">
                                    </a>
                                </div>
                            @else
                                <div
                                    class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                                    <a href="/nutrition/{{$meal->id}}">
                                        <img id="image_preview"
                                             alt="Meal thumbnail" class="rounded-t-lg h-60 w-full object-cover rounded"
                                             src="/{{$meal->thumbnail}}" alt="">
                                    </a>
                                </div>
                            @endif
                        </div>
                        <div>
                            <x-form.formInput name="thumbnail" type="file"/>
                        </div>
                    </div>
                </div>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
                <x-form.formInput name="name" value="{{$meal->name}}"/>

                <div class="mt-3">
                    <label for="name"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Excerpt</label>
                    <x-form.textarea name="excerpt">{{$meal->excerpt}}</x-form.textarea>
                </div>

                <div class="mt-3">
                    <label for="name"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Recipe</label>
                    <x-form.textarea name="recipe">{{$meal->recipe}}</x-form.textarea>
                </div>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Cook time (minutes)</label>
                <x-form.formInput name="cook_time" value="{{$meal->cook_time}}" type="number"/>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Preparation time (minutes)</label>
                <x-form.formInput name="prep_time" value="{{$meal->prep_time}}" type="number"/>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Servings</label>
                <x-form.formInput name="servings" value="{{$meal->servings}}" type="number"/>


                <div class="mr-2">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Dietary
                        Type</label>
                    <select name="dietary_types_id" id="dietary_types_id">
                        @php
                            $dietaryTypes = App\Models\DietaryTypes::all();
                        @endphp

                        @foreach($dietaryTypes as $dietaryType)
                            <option value="{{$dietaryType->id}}"
                                {{old('dietary_types_id', $meal->dietary_types_id) == $dietaryType->id ? 'selected' : ''}}>
                                {{ucwords($dietaryType->name)}}</option>
                        @endforeach

                    </select>

                    @error('dietary_types_id')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="mr-2">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Meal
                        Type</label>
                    <select name="meal_types_id" id="meal_types_id">
                        @php
                            $mealTypes = App\Models\MealType::all();
                        @endphp

                        @foreach($mealTypes as $mealType)
                            <option value="{{$mealType->id}}"
                                {{old('category_id', $meal->meal_types_id) == $mealType->id ? 'selected' : ''}}>
                                {{ucwords($mealType->name)}}</option>
                        @endforeach

                    </select>

                    @error('category')
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

    <script>
        const profileImageInput = document.getElementById('thumbnail');
        const imagePreview = document.getElementById('image_preview1');


        profileImageInput.addEventListener('change', function (event) {
            const file = event.target.files[0];

            if (file) {
                const reader = new FileReader();

                reader.onload = function(e) {
                    imagePreview.src = e.target.result;
                    imagePreview.style.display = 'block';
                }

                reader.readAsDataURL(file);
            } else {
                imagePreview.src = '#';
                imagePreview.style.display = 'none';
            }
        });
    </script>

@endsection

