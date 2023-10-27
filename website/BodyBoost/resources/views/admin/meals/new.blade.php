@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Create meal</h1>
            <form method="POST" action="/admin/meals/create/" enctype="multipart/form-data">
                @csrf
                @method('POST')

                <div class="flex flex-col items-center mt-6">
                    <div class="flex flex-col mt-6 items-center">
                        <div class="flex-1">
                            <x-form.formInput name="thumbnail" type="file"/>
                        </div>
                    </div>

                    <div class="flex-1 lg:mr-8" id="div_preview1">
                        <img src="#"
                             id="image_preview1"
                             class="rounded-xl"
                             style="display: none">

                        <figcaption
                            class="mt-2 text-sm text-center text-gray-500 dark:text-gray-400">
                            Meal thumbnail preview
                        </figcaption>
                    </div>

                </div>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
                <x-form.formInput name="name" placeholder="Meal name..."/>

                <div class="mt-3">
                    <label for="excerpt"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Excerpt</label>
                    <x-form.textarea name="excerpt" placeholder="A short excerpt that captivates the users attention"></x-form.textarea>
                </div>

                <div class="mt-3">
                    <label for="recipe"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Recipe</label>
                    <x-form.textarea name="recipe" placeholder="Start by mixing up the..."></x-form.textarea>
                </div>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Cook time (minutes)</label>
                <x-form.formInput name="cook_time" placeholder="10,20,30..." type="number"/>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Preparation time (minutes)</label>
                <x-form.formInput name="prep_time" placeholder="10,20,30..." type="number"/>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Servings</label>
                <x-form.formInput name="servings" placeholder="2,4,8..." type="number"/>

                <label for="calories" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Calories</label>
                <x-form.formInput name="calories" placeholder="300,400..." type="number"/>

                <div class="mr-2">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Dietary
                        Type</label>
                    <select name="dietary_types_id" id="dietary_types_id">
                        @php
                            $dietaryTypes = App\Models\DietaryTypes::all();
                        @endphp

                        @foreach($dietaryTypes as $dietaryType)
                            <option value="{{$dietaryType->id}}"
                                {{old('dietary_types_id') == $dietaryType->id ? 'selected' : ''}}>
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
                                {{old('meal_types_id') == $mealType->id ? 'selected' : ''}}>
                                {{ucwords($mealType->name)}}</option>
                        @endforeach

                    </select>

                    @error('meal_types_id')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="flex justify-end mt-2 border-t border-gray-300">
                    <button type="submit"
                            class="bg-red-500 mt-2 text-white uppercase font-semibold text-xs py-2 px-10 rounded-2xl hover:bg-red-600">
                        Create
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

