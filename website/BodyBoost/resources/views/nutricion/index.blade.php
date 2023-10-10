@props(['meals'])

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

    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>

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

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

    <style>
        .carousel-container {
            width: 1000px;
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
            width: 1000px;
            height: 500px;
            margin: auto;
        }

        nav {
            z-index: 40;
        }
    </style>

    <script>
        $(document).ready(function () {
            $('.carousel').slick({
                slidesToShow: 1,
                slidesToScroll: 1,
                autoplay: true,
                autoplaySpeed: 2000,
                arrows: false,
                dots: true,
            });
        });
    </script>

</head>
<body class="antialiased">

<x-navbar/>

<section class="justify-center mt-4">
    <div class="p-8 overflow-hidden mt-4 w-full">
        <x-meal_carousel/>
    </div>
</section>

<section class="justify-center p-5">
    <div class="overflow-hidden">

        <x-search content="Find meals, drinks, desserts..."/>
    </div>
</section>

<section class="justify-center p-5 my-8">
    @if($meals->count() > 0)
        <div class="lg:grid lg:grid-cols-3">
            @foreach($meals as $meal)
                <x-meal_card :meal="$meal"/>
            @endforeach
        </div>
    @else
        <p class="my-3 text-center">No meals yet</p>
    @endif
</section>


<x-footer/>

</body>

</html>
