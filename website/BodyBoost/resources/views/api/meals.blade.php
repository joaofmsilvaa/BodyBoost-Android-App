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

    <script>
        function copyFunction() {
            // Copy the text inside the text field
            navigator.clipboard.writeText("http://localhost:8000/api");

            // Alert the copied text
            alert("Base url copied");
        }
    </script>


</head>
<body class="antialiased">

<x-navbar/>
<div class="flex">
    <x-sidebar/>
    <x-docs.mealdocs/>
</div>

<x-footer/>

@if(session()->has('success'))
    <x-flash/>
@endif

</body>

</html>
