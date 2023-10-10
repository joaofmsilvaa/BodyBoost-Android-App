@props(['content'])

<form class="z-index-0">
    <div class="space-y-2 lg:space-y-0 lg:space-x-4 mt-8">
        <div class="flex justify-center">
            <div class="flex w-3/4 lg:inline-flex items-center bg-gray-100 rounded-xl px-3 py-2">
                <form method="GET" action="/" class="w-3/4">
                    @if(request('item'))
                        <input type="hidden" name="item" value="{{ request('item') }}">
                    @endif
                    <input type="text"
                           name="search"
                           placeholder="{{$content}}"
                           class="bg-transparent placeholder-black font-semibold text-sm w-full"
                           value="{{request('search')}}"
                    >
                        <button type="submit" class="ml-2">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 style="fill: rgb(239 68 68);">
                                <path
                                    d="M10 18a7.952 7.952 0 0 0 4.897-1.688l4.396 4.396 1.414-1.414-4.396-4.396A7.952 7.952 0 0 0 18 10c0-4.411-3.589-8-8-8s-8 3.589-8 8 3.589 8 8 8zm0-14c3.309 0 6 2.691 6 6s-2.691 6-6 6-6-2.691-6-6 2.691-6 6-6z"></path>
                            </svg>
                        </button>
                </form>
            </div>
        </div>
    </div>
</form>
