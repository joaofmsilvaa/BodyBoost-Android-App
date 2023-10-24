@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Edit Exercise Set</h1>
            <form method="POST" action="/admin/exercise-sets/{{$exerciseSet->id}}" enctype="multipart/form-data">
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
                                {{old('exercise_id', $exerciseSet->exercise_id) == $exercise->id ? 'selected' : ''}}>
                                {{ucwords($exercise->name)}}</option>
                        @endforeach

                    </select>

                    @error('exercise_id')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror

                </div>

                <div class="mt-3">
                    <label for="dayId" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Day Id</label>
                    <x-form.formInput name="dayId" value="{{$exerciseSet->dayId}}" type="number" placeholder="1 ( monday ), 2 ( tuesday )..."/>
                    @error('dayId')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="mt-3">
                    <label for="orderIndex" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Order Index</label>
                    <x-form.formInput name="orderIndex" value="{{$exerciseSet->orderIndex}}" type="number"/>
                    @error('orderIndex')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="mt-3">
                    <label for="repetitions" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Repetitions</label>
                    <x-form.formInput name="repetitions" value="{{$exerciseSet->repetitions}}" type="number"/>
                    @error('repetitions')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="mt-3">
                    <label for="time" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Time</label>
                    <x-form.formInput name="time" value="{{$exerciseSet->time}}" type="number"/>
                    @error('time')
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

