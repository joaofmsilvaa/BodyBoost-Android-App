@props(['news'])

    <!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>BodyBoost</title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=figtree:400,600&display=swap" rel="stylesheet"/>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

    <!-- JS -->
    <script src="//unpkg.com/alpinejs" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/xjei76kbizfjo1f2974ozkdl8tkdjgb2jrmi8pvkjphg2uob/tinymce/6/tinymce.min.js"
            referrerpolicy="origin"></script>

    <!-- JS -->
    <script src="//unpkg.com/alpinejs" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <!-- ... Tinymce ... -->
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/xjei76kbizfjo1f2974ozkdl8tkdjgb2jrmi8pvkjphg2uob/tinymce/6/tinymce.min.js"
            referrerpolicy="origin"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <style>.carousel-container {
            width: 800px;
            height: 500px;
            margin: 0 auto; /* Center the carousel horizontally */
            position: relative;
            z-index: 0;
        }

        .carousel {
            width: 100%;
            height: 100%;
        }

        .carousel img {
            object-fit: cover;
            width: 1000px;
            height: 300px;
            margin: 0;
        }

        nav {
            z-index: 40;
        }</style>


</head>
<body class="antialiased">

<x-navbar/>


<section class="justify-center pb-5">
    <div class="w-full">
        <div class="mt-12">
            <main class="pt-8 pb-4 lg:pt-16 md:pt-24 bg-white dark:bg-gray-900 antialiased">
                <div class="flex justify-between px-4 mx-auto max-w-screen-xl ">
                    <article class="mx-auto w-full max-w-4xl format format-sm sm:format-base lg:format-lg format-blue dark:format-invert">
                        <header class="mb-4 lg:mb-6 not-format">
                            <img src="{{ asset('storage/' . $news->thumbnail) }}" alt="News Article" class="w-full h-48 object-cover rounded">
                            <h1 class="mb-4 text-3xl font-extrabold leading-tight text-gray-900 lg:mb-6 lg:text-4xl dark:text-white">{{$news->title}}</h1>
                            <address class="flex items-center mb-6 not-italic">
                                <div class="inline-flex items-center mr-3 text-sm text-gray-900 dark:text-white">
                                    <div>
                                        <p class="text-xl font-bold text-red-600 dark:text-white">{{$news->category->name}}</p>
                                        <a href="{{$news->source}}" class="text-lg border-b-2 border-red-500 transition-transform duration-300 transform hover:border-red-700 text-gray-900 dark:text-white">Source</a>
                                        <p class="text-base text-gray-500 dark:text-gray-400"><time>{{$news->created_at->diffForHumans()}}</time></p>
                                    </div>
                                </div>
                            </address>
                        </header>
                        <x-pannel>
                            <p class="lead text-lg">{{$news->excerpt}}</p>
                            <p class="mt-4 text-justify">{!! nl2br($news->body) !!}</p>
                        </x-pannel>

                        </article>
                </div>
            </main>
        </div>
    </div>
</section>


<x-footer/>

</body>

<script>
    $(document).ready(function () {
        $('.carousel').slick({
            slidesToShow: 1,
            slidesToSlide: 1,
            autoplay: true,
            autoplaySpeed: 2000,
            arrows: false,
            dots: true,
            pauseOnFocus: false,
            pauseOnHover: false,
            pauseOnDotsHover: false,
        });
    });
</script>

</html>
