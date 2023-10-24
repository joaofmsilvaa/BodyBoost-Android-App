@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500">Edit Exercise</h1>
            <form method="POST" action="/admin/exercises/{{$exercise->id}}" enctype="multipart/form-data">
                @csrf
                @method('PATCH')

                <label for="exerciseName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
                <x-form.formInput name="exerciseName" value="{{$exercise->exerciseName}}"/>

                <div class="mt-3">
                    <label for="exerciseDescription" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Description</label>
                    <x-form.textarea name="exerciseDescription">{{$exercise->exerciseDescription}}</x-form.textarea>
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

