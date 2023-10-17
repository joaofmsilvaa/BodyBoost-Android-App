@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')
    <div class="mt-8">
        <x-settings heading="Manage Meals">
            <div class="overflow-x-auto">
                @if($meals->count() > 0)
                    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead
                            class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 flex-1">
                        <tr>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Id
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Name
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Dietary Type
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Meal Type
                            </th>
                            <th scope="col" class="w-10 px-6 py-3">
                                Excerpt
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
                        @foreach($meals as $meal)
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <p >{{$meal->id}}</p>
                                </td>
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <a href="/meals/{{$meal->slug}}">{{$meal->name}}</a>
                                </td>
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <a href="/meals/{{$meal->slug}}">{{$meal->dietaryType->name}}</a>
                                </td>
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <a href="/meals/{{$meal->slug}}">{{$meal->mealType->name}}</a>
                                </td>
                                <td class="w-1/12 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <a href="/meals/{{$meal->slug}}">{{$meal->excerpt}}</a>
                                </td>
                                <td class="w-1/6 px-6 py-4">
                                    <p class="text-sm">{{$meal->created_at}}</p>
                                </td>
                                <td class="px-6 py-4">
                                    <a href="/admin/meals/{{$meal->id}}/edit"
                                       class="text-blue-500 hover:text-blue-600">Edit</a>
                                </td>

                                <td class="px-6 py-4">
                                    <form action="/admin/meals/{{$meal->id}}" method="post">
                                        @csrf
                                        @method('DELETE')

                                        <button class="text-red-500 hover:text-red-600"
                                                onclick="return confirm('By clicking \'ok\' you confirm that you are aware that the meal \'{{$meal->name}}\' will be permanently deleted?')">
                                            Delete
                                        </button>

                                    </form>
                                </td>
                            </tr>
                        @endforeach
                        </tbody>
                    </table>
                @else
                    <p class="text-center text-lg text-gray-500">No Meals yet. Come back later</p>
                @endif
            </div>

            <div class="p-3">
                {{$meals->links()}}
            </div>

        </x-settings>
    </div>

@endsection

