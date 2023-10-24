@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Create Exercise step</h1>
            <form method="POST" action="/admin/exercise-steps/create/" enctype="multipart/form-data">
                @csrf
                @method('POST')

                <div class="flex flex-col items-center mt-6">
                    <div class="flex-1 lg:mr-8" id="div_preview1">
                        <img src="#"
                             id="image_preview1"
                             class="rounded-xl"
                             style="display: none">

                        <figcaption
                            class="mt-2 text-sm text-center text-gray-500 dark:text-gray-400">
                            Step image preview
                        </figcaption>
                    </div>
                    <div class="flex flex-col mt-6 items-center">
                        <div class="flex-1">
                            <x-form.formInput name="image" type="file"/>
                        </div>
                    </div>
                </div>

                <div class="mr-2">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Dietary
                        Type</label>
                    <select name="exercise_id" id="exercise_id">
                        @php
                            $exercises = App\Models\Exercise::all();
                        @endphp

                        @foreach($exercises as $exercise)
                            <option value="{{$exercise->id}}"
                                {{old('exercise_id') == $exercise->id ? 'selected' : ''}}>
                                {{ucwords($exercise->exerciseName)}}</option>
                        @endforeach

                    </select>

                    @error('exercise_id')
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

