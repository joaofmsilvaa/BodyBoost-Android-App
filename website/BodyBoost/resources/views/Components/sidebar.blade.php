<sidebar class="flex-none justify-center pl-8 pt-8 pb-8 overflow-hidden w-3/12" id="inicio">
    <div class="flex justify-center items-center mt-5 pt-8 pb-8 pl-8">
        <div class="container mx-auto m-5">
            <div class="py-8">
                <div class="flex flex-col justify-end lg:flex-row w-full">
                    <div class="py-8 text-center lg:text-left w-full">
                        <x-pannel class="flex-wrap w-full">
                            <h2 class="text-xl font-semibold mt-5 border-b-2 border-gray-900">
                                Documentation
                            </h2>
                            <div class="mt-5 flex flex-col">
                                <a class="{{request()->is('api') ? 'mt-2 border-2 border-gray-200 rounded px-2 py-1 bg-gray-200' : 'mt-2 border-2 border-gray-200 rounded px-2 py-1 transform transition-transform duration-300 hover:bg-gray-200'}}"
                                   href="/api">API Reference</a>
                                <a class="{{request()->is('api/docs/meals') ? 'mt-2 border-2 border-gray-200 rounded px-2 py-1 bg-gray-200' : 'mt-2 border-2 border-gray-200 rounded px-2 py-1 transform transition-transform duration-300 hover:bg-gray-200'}}"
                                   href="/api/docs/meals">Return all meals</a>
                                <a class="{{request()->is('api/docs/ingredients-meal') ? 'mt-2 border-2 border-gray-200 rounded px-2 py-1 bg-gray-200' : 'mt-2 border-2 border-gray-200 rounded px-2 py-1 transform transition-transform duration-300 hover:bg-gray-200'}}"
                                   href="/api/docs/ingredients-meal">Return the ingredients of a certain meal</a>
                                <a
                                    href="/api/docs/ingredients-in-meal"
                                    class="{{request()->is('api/docs/ingredients-in-meal') ? 'mt-2 border-2 border-gray-200 rounded px-2 py-1 bg-gray-200' : 'mt-2 border-2 border-gray-200 rounded px-2 py-1 transform transition-transform duration-300 hover:bg-gray-200'}}">Return
                                    the relations between the ingredient and
                                    the meal</a>
                                <a class="{{request()->is('api/docs/news') ? 'mt-2 border-2 border-gray-200 rounded px-2 py-1 bg-gray-200' : 'mt-2 border-2 border-gray-200 rounded px-2 py-1 transform transition-transform duration-300 hover:bg-gray-200'}}"
                                   href="/api/docs/news">Return all news</a>
                            </div>

                        </x-pannel>

                    </div>
                </div>
            </div>
        </div>
    </div>
</sidebar>


