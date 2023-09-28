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

<x-main-section/>

<section class="justify-center p-5 my-8">
    <div>
        <h1 class="text-4xl font-bold text-center my-5 w-">Services</h1>
    </div>
    <x-services/>
</section>


<section class="justify-center p-5 my-8">
    <div>
        <h1 class="text-4xl font-bold text-center my-5 w-">About us</h1>
    </div>
    <div class="justify-center flex-1 max-w-6xl py-4 mx-auto lg:py-6 md:px-6">
        <div class="flex flex-wrap ">
            <div class="w-full pr-4 mb-10 lg:w-1/2 lg:mb-0">
                <h2 class="mt-2 mb-6 text-2xl font-bold dark:text-gray-300">
                    We are two students with the dream of creating the best workout app</h2>
                <p class="mb-10 text-lg text-justify">
                    The objectives of the project arose from the desire to help
                    people who do not have access to gyms or nutritional counseling
                    due to geographical or financial reasons. We believe that
                    everyone should have access to quality resources to adopt a
                    healthy lifestyle and achieve their goals. By creating an
                    application that offers personalized workout plans and healthy
                    recipes, the project aims to provide access regardless of their
                    geographical location or financial situation.</p>

            </div>

            <div class="w-full px-8 mb-10 lg:w-1/2 lg:mb-0">
                <div class="relative shadow-xl ">
                    <img src="images/IPBejaESTIG.jpg" alt="ESTIG Logo" class="relative z-10 object-cover w-full h-full rounded">
                </div>

            </div>
        </div>
    </div>
</section>

{{--<x-footer/>--}}

</body>

</html>
