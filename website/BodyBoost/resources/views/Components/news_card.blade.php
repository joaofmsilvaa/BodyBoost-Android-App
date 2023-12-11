@props(['news'])
<div class="max-w-xl mt-4 mx-2 rounded-lg overflow-hidden shadow-lg transform transition-transform duration-300 hover:scale-105">
    <img src="{{ asset('storage/' . $news->thumbnail) }}" alt="News Article" class="w-full h-48 object-cover">
    <div class="px-6 py-4">
        <div class="font-bold text-xl mb-2">
            <a href="/news/{{$news->id}}">
                {{$news->title}}
            </a>
        </div>
        <div class="font-bold text-lg text-red-500">
            {{$news->category->name}}
        </div>
        <p class="text-gray-600 text-base">
            {{$news->excerpt}}
        </p>
        <p class="text-gray-500 text-sm mt-4">Published {{$news->created_at->diffForHumans()}}</p>
    </div>
    <div class="px-6 pb-4">
        <a href="/news/{{$news->id}}" class="text-red-500 hover:underline">Read More</a>
    </div>
</div>
