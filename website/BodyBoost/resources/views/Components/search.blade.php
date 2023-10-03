<form class="z-index-0">
    <div class="space-y-2 lg:space-y-0 lg:space-x-4 mt-8">
        <div class="flex w-full lg:inline-flex items-center bg-gray-100 rounded-xl px-3 py-2">
            <form method="GET" action="/" class="w-full">
                @if(request('category'))
                    <input type="hidden" name="category" value="{{ request('category') }}">
                @endif
                <input type="text"
                       name="search"
                       placeholder="Find something"
                       class="bg-transparent placeholder-black font-semibold text-sm w-full"
                       value="{{request('search')}}"
                >
            </form>
        </div>
    </div>
</form>
