@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')
    <div class="mt-8">
        <x-settings heading="Manage Exercise steps">
            <div class="bg-red-500 p-2 rounded-full text-white mb-2 flex justify-center w-1/6">
                <a href="/admin/exercise-steps/create">
                    Create Exercise Step
                </a>
                <div class="ml-2">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                         style="fill: rgb(255,255,255);">
                        <path d="M13 7h-2v4H7v2h4v4h2v-4h4v-2h-4z"></path>
                        <path d="M12 2C6.486 2 2 6.486 2 12s4.486 10 10 10 10-4.486 10-10S17.514 2 12 2zm0 18c-4.411 0-8-3.589-8-8s3.589-8 8-8 8 3.589 8 8-3.589 8-8 8z"></path>
                    </svg>
                </div>
            </div>
            <div class="overflow-x-auto">
                @if($exerciseSteps->count() > 0)
                    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead
                            class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 flex-1">
                        <tr>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Id
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Exercise Id
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Created At
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Edit
                            </th>
                            <th scope="col" class="w-1/6 px-3 py-3">
                                Delete
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        @foreach($exerciseSteps as $exerciseStep)
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <p >{{$exerciseStep->id}}</p>
                                </td>
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <p>{{$exerciseStep->exercise_id}}</p>
                                </td>
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <p>{{$exerciseStep->created_at}}</p>
                                </td>
                                <td class="px-6 py-4">
                                    <a href="/admin/exercise-steps/{{$exerciseStep->id}}/edit"
                                       class="text-blue-500 hover:text-blue-600">Edit</a>
                                </td>

                                <td class="px-6 py-4">
                                    <form action="/admin/exercise-steps/{{$exerciseStep->id}}" method="post">
                                        @csrf
                                        @method('DELETE')

                                        <button class="text-red-500 hover:text-red-600"
                                                onclick="return confirm('By clicking \'ok\' you confirm that you are aware that the step for the exercise \'{{$exerciseStep->exercises->name}}\' will be removed?')">
                                            Delete
                                        </button>

                                    </form>
                                </td>
                            </tr>
                        @endforeach
                        </tbody>
                    </table>
                @else
                    <p class="text-center text-lg text-gray-500">No Meal steps yet. Come back later</p>
                @endif
            </div>

            <div class="p-3">
                {{$exerciseSteps->links()}}
            </div>

        </x-settings>
    </div>

@endsection

