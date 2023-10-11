@props(['meal'])

<div class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                <a href="/nutrition/{{$meal->id}}">
                    <img class="rounded-t-lg h-60 w-full object-cover rounded" src="{{$meal->thumbnail}}" alt="">
                </a>
                <div class="p-5 h-40">
                    <a href="/nutrition/{{$meal->id}}">
                        <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white text-center">
                            {{$meal->name}}</h5>
                    </a>
                    <p class="mb-3 font-normal text-gray-700 dark:text-gray-400">{{$meal->excerpt}}</p>
                </div>
            </div>
