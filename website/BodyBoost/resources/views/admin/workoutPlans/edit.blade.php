@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Edit Workout plan</h1>
            <form method="POST" action="/admin/workout-plans/{{$workoutPlan->id}}" enctype="multipart/form-data">
                @csrf
                @method('PATCH')

                <div class="mr-2">
                    <label for="exercise_id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Exercise</label>
                    <select name="exercise_id" id="exercise_id">
                        @php
                            $exercises = App\Models\Exercise::all();
                        @endphp

                        @foreach($exercises as $exercise)
                            <option value="{{$exercise->id}}"
                                {{old('exercise_id', $workoutPlan->exercise_id) == $exercise->id ? 'selected' : ''}}>
                                {{ucwords($exercise->exerciseName)}}</option>
                        @endforeach

                    </select>

                    @error('exercise_id')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror

                </div>

                <div class="mt-3">
                    <label for="dayId" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Day Id</label>
                    <x-form.formInput name="dayId" value="{{$workoutPlan->dayId}}" type="number" placeholder="1 ( monday ), 2 ( tuesday )..."/>
                    @error('dayId')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="mt-3">
                    <label for="type" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Type</label>
                    <x-form.formInput name="type" value="{{$workoutPlan->type}}"/>
                    @error('type')
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

