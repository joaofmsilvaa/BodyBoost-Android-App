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

</head>
<body class="antialiased">

<x-navbar/>

<section class="justify-center p-5 my-8">
    <div class="p-8 overflow-hidden mt-8 w-full">
        <div class="flex justify-center">
            <h1 class="text-2xl font-semibold mt-5">Stay up to date with the most <span class="text-red-600">Up-To-Date</span> news related to <span class="text-red-600">Sports</span></h1>
        </div>

        <x-search content="Find news about football, basketball, baseball..."/>
    </div>
</section>

<section class="justify-center p-5 my-8">
    <div class="p-8 overflow-hidden mt-8 w-full">
        @if($news->count() > 0)
            @foreach($news as $new)
                <p class="my-3">{{$new->title}}</p>
            @endforeach

        @else
            <p class="my-3 text-center">No news yet</p>
        @endif

    </div>
</section>


<x-footer/>

</body>

</html>
