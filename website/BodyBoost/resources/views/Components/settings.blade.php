<section class="py-8 py-8 max-w-full mt-12">

    <h1 class="text-lg font-bold mb-8 pb-2 border-b">
        {{$heading}}
    </h1>

    <div class="flex items-center">
        <aside class="w-full flex mb-6">
            <h4 class="font-semibold">Links:</h4>
            <ul class="flex">
                <li class="px-3">
                    <a href="/admin/users" class="{{request()->is('admin/users') ? 'text-red-500' : ''}}">All Users</a>
                </li>
                <li class="px-3">
                    <a href="/admin/meals" class="{{request()->is('admin/meals') ? 'text-red-500' : ''}}">All Meals</a>
                </li>
                <li class="px-3">
                    <a href="/admin/ingredients" class="{{request()->is('admin/ingredients') ? 'text-red-500' : ''}}">All Ingredients</a>
                </li>
                <li class="px-3">
                    <a href="/admin/news" class="{{request()->is('admin/news') ? 'text-red-500' : ''}}">All News</a>
                </li>
            </ul>
        </aside>
    </div>

    <main>
        <x-pannel>
            {{$slot}}
        </x-pannel>
    </main>

</section>
