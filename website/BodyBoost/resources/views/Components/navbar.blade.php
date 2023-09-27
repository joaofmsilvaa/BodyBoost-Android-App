@props(['agent'])

<nav class="fixed z-40 right-0 left-0 top-0 w-full bg-white p-5 border-b-2">
    <div class="px-8 w-full flex items-center flex justify-between items-center">
        <div>
            <a href="/">
                <img class="w-28 h-auto" src="images/logo.png">
            </a>
        </div>

        <div>
            @auth
                <x-dropdown>
                    <x-slot name="trigger">
                        <button class="text-xs font-bold uppercase">Welcome, {{auth()->user()->name}}!</button>
                    </x-slot>

                    @can('admin')
                        <x-dropdown-item href="/admin/dashboard">Dashboard</x-dropdown-item>
                    @endcan

                    <x-dropdown-item href="/profile/{{auth()->user()->id}}">Profile</x-dropdown-item>

                    <x-dropdown-item href="/posts/create">New
                        post
                    </x-dropdown-item>

                    <x-dropdown-item href="/bookmarks/">Bookmarks</x-dropdown-item>

                    <x-dropdown-item href="#" x-data="{}"
                                     @click.prevent="document.querySelector('#logout-form').submit()">Log out
                    </x-dropdown-item>


                    <form id="logout-form" method="POST" action="/logout" class="hidden">
                        @csrf
                    </form>
                </x-dropdown>

            @else
                <a href="/register" class="text-xs font-bold mr-3 uppercase">Register</a>
                <a href="/login" class="text-xs font-bold uppercase">Log In</a>
            @endauth

        </div>
    </div>
</nav>
