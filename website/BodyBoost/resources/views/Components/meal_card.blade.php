@props(['meal'])

<div
    class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
    <a href="/nutrition/{{$meal->id}}">
        <img class="rounded-t-lg h-60 w-full object-cover rounded" src="{{ asset('storage/' . $meal->thumbnail) }}" alt="">
    </a>
    <div class="p-5 h-auto">
        <a href="/nutrition/{{$meal->id}}">
            <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white text-center">{{$meal->name}}</h5>
        </a>
        <div class="flex space-x-4 justify-center">
            <div class="font-bold text-lg text-red-500">
                {{$meal->dietaryType->name}}
            </div>
            <div class="font-bold text-lg text-red-500">
                {{$meal->mealType->name}}
            </div>
        </div>
        <p class="mb-3 font-normal text-gray-700 dark:text-gray-400">{{$meal->excerpt}}</p>
        <div>
            <p class="text-gray-500 text-sm mt-4">Published {{$meal->created_at->diffForHumans()}}</p>
            <div class="px-6 pb-4 text-start">
                <a href="/nutrition/{{$meal->id}}" class="text-red-500 hover:underline">Read More</a>
            </div>
        </div>

    </div>
</div>
