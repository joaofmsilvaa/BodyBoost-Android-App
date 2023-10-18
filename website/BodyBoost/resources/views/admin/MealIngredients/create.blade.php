@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')
    <div class="mt-8">
        <x-settings heading="Manage Meal Ingredients">
            <div class="overflow-x-auto">
                @if($mealIngredients->count() > 0)
                    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead
                            class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 flex-1">
                        <tr>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Ingredient Id
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Meal Id
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Amount ( kg )
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Measure
                            </th>
                            <th scope="col" class="w-1/6 px-6 py-3">
                                Time ( minutes )
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
                        @foreach($mealIngredients as $mealIngredient)
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <p >{{$mealIngredient->ingredients_id}}</p>
                                </td>
                                <td class="w-1/6 px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <p>{{$mealIngredient->meal_id}}</p>
                                </td>
                                <td class="w-1/6 px-6 py-4">
                                    <p class="text-sm">{{$mealIngredient->amount}}</p>
                                </td>
                                <td class="w-1/6 px-6 py-4">
                                    <p class="text-sm">{{$mealIngredient->measure}}</p>
                                </td>
                                <td class="w-1/6 px-6 py-4">
                                    @if(isset($mealIngredient->time))
                                        <p class="text-sm">{{$mealIngredient->time}}</p>
                                    @else
                                        <p class="text-gray-600 italic">Null</p>
                                    @endif
                                </td>
                                <td class="w-1/6 px-6 py-4">
                                    <p class="text-sm">{{$mealIngredient->created_at}}</p>
                                </td>
                                <td class="px-6 py-4">
                                    <a href="/admin/meal-ingredients/{{$mealIngredient->id}}/edit"
                                       class="text-blue-500 hover:text-blue-600">Edit</a>
                                </td>

                                <td class="px-6 py-4">
                                    <form action="/admin/meal-ingredients/{{$mealIngredient->id}}" method="post">
                                        @csrf
                                        @method('DELETE')

                                        <button class="text-red-500 hover:text-red-600"
                                                onclick="return confirm('By clicking \'ok\' you confirm that you are aware that the ingredient \'{{$mealIngredient->ingredients->name}}\' will be removed from the meal \'{{$mealIngredient->meal->name}}\'?')">
                                            Delete
                                        </button>

                                    </form>
                                </td>
                            </tr>
                        @endforeach
                        </tbody>
                    </table>
                @else
                    <p class="text-center text-lg text-gray-500">No Meal Ingredients yet. Come back later</p>
                @endif
            </div>

            <div class="p-3">
                {{$mealIngredients->links()}}
            </div>

        </x-settings>
    </div>

@endsection

