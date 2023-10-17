<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BodyBoost</title>
    <meta name="author" content="David Grzyb">
    <meta name="description" content="">

    <!-- Tailwind -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Karla:400,700&display=swap');
    </style>

    <!-- AlpineJS -->
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <!-- Font Awesome -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
            integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>
</head>
<body class="bg-white">

<x-navbar/>

<div class="container w-full flex flex-wrap py-6 justify-center mt-8">

    <!-- Post Section -->
    <section class="w-full md:w-2/3 flex flex-col items-center mt-8 px-2">

        <article class="flex flex-col w-full shadow my-4">
            <!-- Article Image -->
            <a class="px-2">
                <img src="/{{$meal->thumbnail}}">
            </a>
            <div class="bg-white flex flex-col justify-start p-6">
                <div class="flex">
                    <a href="/nutrition/?meal-type={{$meal->dietaryType->slug}}"
                       class="text-red-700 hover:text-red-300 text-sm font-bold uppercase pb-4">{{$meal->dietaryType->name}}</a>
                    <a href="/nutrition/?meal-type={{$meal->mealType->slug}}"
                       class="text-red-700 hover:text-red-300 text-sm font-bold uppercase pb-4 pl-4">{{$meal->mealType->name}}</a>
                </div>
                <p class="text-3xl font-bold hover:text-gray-700 pb-4">{{$meal->name}}</p>
                <h1 class="text-2xl font-bold pb-3">Recipe:</h1>
                <p class="pb-3">{{$meal->recipe}}</p>
            </div>
        </article>

    </section>

    <!-- Sidebar Section -->
    <aside class="w-full md:w-1/3 flex flex-col items-center px-2 mt-8">

        <div class="w-full bg-white shadow flex flex-col my-4 p-6">

            <p class="text-xl font-semibold pb-5">Ingredients:</p>
            @foreach($mealIngredients as $mealIngredient)
                <div class="flex">
                    <p class="pb-2">{{$mealIngredient->ingredients->name}}</p>
                    @if(isset($mealIngredient->amount))
                        <p class="pb-2 ml-2">{{$mealIngredient->amount}}</p>

                    @else
                        <p class="pb-2 ml-2">{{$mealIngredient->measure}}</p>
                    @endif

                </div>
            @endforeach
        </div>

    </aside>

</div>

<x-footer/>
</body>
</html>
