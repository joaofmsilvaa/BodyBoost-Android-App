<!-- Navbar goes here -->
<nav class="fixed bg-red-500 shadow-lg right-0 left-0 top-0 w-full">
    <div class="max-w-6xl mx-auto px-4">
        <div class="flex justify-between">
            <div class="flex space-x-7">
                <div>
                    <!-- Website Logo -->
                    <a href="#" class="flex items-center py-4 px-2">
                        <img class="w-28 h-auto" src="images/logo.png">
                    </a>
                </div>
                <!-- Primary Navbar items -->
                <div class="hidden md:flex items-center space-x-1">
                    <a href="" class="{{request()->is('/') ? 'py-4 px-2 text-white border-b-4 border-white font-semibold' : 'py-4 px-2 text-white font-semibold hover:text-gray-500 transition duration-300'}}">Home</a>
                    <a href="" class="{{request()->is('/nutricion') ? 'py-4 px-2 text-white border-b-4 border-white font-semibold' : 'py-4 px-2 text-white font-semibold hover:text-gray-500 transition duration-300'}}">Nutrition</a>
                    <a href="" class="{{request()->is('/news') ? 'py-4 px-2 text-white border-b-4 border-white font-semibold' : 'py-4 px-2 text-white font-semibold hover:text-gray-500 transition duration-300'}}">News</a>
                    <a href="" class="{{request()->is('/store') ? 'py-4 px-2 text-white border-b-4 border-white font-semibold' : 'py-4 px-2 text-white font-semibold hover:text-gray-500 transition duration-300'}}">Store</a>
                </div>
            </div>


            <div class="hidden md:flex items-center space-x-3 ">

                @auth
                    <a href="/dashboard" class="py-2 px-2 font-medium text-white rounded hover:text-gray-500 transition duration-300">
                        Welcome, {{auth()->user()->name}}!
                    </a>
                    {{--<x-dropdown>
                        <x-slot name="trigger">
                            <button class="py-2 px-2 font-medium text-white rounded hover:bg-gray-100 hover:text-red-500 transition duration-300">
                                Welcome, {{auth()->user()->name}}!
                            </button>
                        </x-slot>

                        @can('admin')
                            <x-dropdown-item href="/admin/dashboard">Dashboard</x-dropdown-item>
                        @endcan

                        <x-dropdown-item href="/profile">Profile</x-dropdown-item>

                        <x-dropdown-item href="/bookmarks/">Bookmarks</x-dropdown-item>

                        <x-dropdown-item href="#" x-data="{}"
                                         @click.prevent="document.querySelector('#logout-form').submit()">Log out
                        </x-dropdown-item>


                        <form id="logout-form" method="POST" action="/logout" class="hidden">
                            @csrf
                        </form>
                    </x-dropdown>--}}

                @else
                    <a href="/login"
                       class="py-2 px-2 font-medium text-white rounded hover:text-gray-500 transition duration-300">Log
                        In</a>
                    <a href="/register"
                       class="py-2 px-2 font-medium text-white rounded  hover:text-gray-500 transition duration-300">Sign
                        Up</a>
                @endauth
            </div>
            <!-- Mobile menu button -->
            <div class="md:hidden flex items-center">
                <button class="outline-none mobile-menu-button">
                    <svg class=" w-6 h-6 text-white hover:text-gray-500 "
                         x-show="!showMenu"
                         fill="none"
                         stroke-linecap="round"
                         stroke-linejoin="round"
                         stroke-width="2"
                         viewBox="0 0 24 24"
                         stroke="currentColor"
                    >
                        <path d="M4 6h16M4 12h16M4 18h16"></path>
                    </svg>
                </button>
                @auth
                    <a href="/dashboard" class="py-2 px-2 font-medium text-white rounded hover:text-gray-500 transition duration-300">
                        Welcome, {{auth()->user()->name}}!
                    </a>
                @else
                    <a href="/login"
                       class="py-2 px-2 font-medium text-gray-500 rounded hover:bg-red-500 hover:text-white transition duration-300">Log
                        In</a>
                    <a href="/register"
                       class="py-2 px-2 font-medium text-gray-500 rounded hover:bg-red-500 hover:text-white transition duration-300">Sign
                        Up</a>
                @endauth
            </div>
        </div>
    </div>
    <!-- mobile menu -->
    <div class="hidden">
        <ul class="text-right">
            <li class="active"><a href="/" class="block text-sm px-2 py-4 text-white bg-red-500 font-semibold">Home</a>
            </li>
            <li><a href="#services" class="block text-sm px-2 py-4 hover:bg-gray-100 hover:text-red-500 transition duration-300">Services</a></li>
            <li><a href="#about" class="block text-sm px-2 py-4 hover:bg-gray-100 hover:text-red-500 transition duration-300">About</a></li>
            <li><a href="#contact" class="block text-sm px-2 py-4 hover:bg-gray-100 hover:text-red-500 transition duration-300">Contact Us</a></li>
        </ul>
    </div>
    <script>
        let btn = document.querySelector("button.mobile-menu-button");
        let menu = document.querySelector(".mobile-menu");

        btn.addEventListener("click", () => {
            menu.classList.toggle("hidden");
        });
    </script>
</nav>