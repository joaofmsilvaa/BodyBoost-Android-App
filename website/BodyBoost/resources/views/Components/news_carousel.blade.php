@props(['news'])
<section class="justify-center pt-8 mt-8">
    <!--News Carousel-->
    <div class="carousel-container">
        <div class="px-6 py-4">

            <div class="carousel">

                @foreach($news as $new)
                    <!--News Carousel 1 -->
                    <div>
                        <div class="font-bold text-xl text-red-600 mb-2">{{$new->title}}</div>
                        <img src="{{ asset('storage/' . $new->thumbnail) }}" alt="Carousel News" class="w-full h-48 object-cover">
                        <p class="text-gray-600 text-base">
                            {{$new->excerpt}}
                        </p>
                        <p class="text-gray-500 text-sm mt-4">Published {{$new->created_at->diffForHumans()}}</p>
                        <div class="px-6 pb-4">
                            <a href="carousel_article.html" class="text-red-500 hover:underline">Read More</a>
                        </div>
                    </div>
                @endforeach
            </div>
        </div>
    </div>
</section>
