@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Edit meal</h1>
            <form method="POST" action="/admin/exercise-steps/{{$exerciseStep->id}}" enctype="multipart/form-data">
                @csrf
                @method('PATCH')

                <div class="mt-3">
                    <label for="image"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Image</label>
                    <div class="flex-col mt-6">
                        <div class="my-3">
                            @if(isset($exerciseStep->image))
                                <div
                                    class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                                    <a>
                                        <img id="image_preview"
                                             alt="Step Image" class="rounded-t-lg h-60 w-full object-cover rounded"
                                             src="{{ asset('storage/' . $exerciseStep->image) }}" alt="">
                                    </a>
                                </div>
                            @else
                                <div
                                    class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                                    <a>
                                        <img id="image_preview"
                                             alt="Step Image" class="rounded-t-lg h-60 w-full object-cover rounded"
                                             src="{{ asset('storage/' . $exerciseStep->image) }}" alt="">
                                    </a>
                                </div>
                            @endif
                        </div>
                        <div>
                            <x-form.formInput name="image" type="file"/>
                        </div>
                    </div>
                </div>

                <div class="mr-2">
                    <label for="exercise_id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Exercise</label>
                    <select name="exercise_id" id="exercise_id">
                        @php
                            $exercises = App\Models\Exercise::all();
                        @endphp

                        @foreach($exercises as $exercise)
                            <option value="{{$exercise->id}}"
                                {{old('exercise_id', $exerciseStep->exercise_id) == $exercise->id ? 'selected' : ''}}>
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

