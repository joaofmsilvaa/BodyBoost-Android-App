@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <div class="flex justify-center mt-8 p-8">
        <div class="p-8 w-3/4 justify-center bg-gray-50 rounded-xl">
            <h1 class="text-xl text-red-500" >Edit News</h1>
            <form method="POST" action="/admin/news/{{$news->id}}" enctype="multipart/form-data">
                @csrf
                @method('PATCH')

                <div class="mt-3">
                    <label for="name"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Thumbnail</label>
                    <div class="flex-col mt-6">
                        <div class="my-3">
                            @if(isset($news->thumbnail))
                                <div
                                    class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                                    <a href="/news/{{$news->id}}">
                                        <img id="image_preview"
                                             alt="News thumbnail" class="rounded-t-lg h-60 w-full object-cover rounded"
                                             src="{{ asset('storage/' . $news->thumbnail) }}" alt="">
                                    </a>
                                </div>
                            @else
                                <div
                                    class="transition duration-300 hover:bg-gray-200 m-2 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                                    <a href="/nutrition/{{$news->id}}">
                                        <img id="image_preview"
                                             alt="News thumbnail" class="rounded-t-lg h-60 w-full object-cover rounded"
                                             src="/{{$news->thumbnail}}" alt="">
                                    </a>
                                </div>
                            @endif
                        </div>
                        <div>
                            <x-form.formInput name="thumbnail" type="file"/>
                        </div>
                    </div>
                </div>

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Title</label>
                <x-form.formInput name="title" value="{{$news->title}}"/>

                <label for="slug" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Slug</label>
                <x-form.formInput name="slug" value="{{$news->slug}}"/>

                <label for="source" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Source</label>
                <x-form.formInput name="source" value="{{$news->source}}"/>


                <div class="mt-3">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Excerpt</label>
                    <x-form.textarea name="excerpt">{{$news->excerpt}}</x-form.textarea>
                </div>

                <div class="mt-3">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Body</label>
                    <x-form.textarea name="body">{{$news->body}}</x-form.textarea>
                </div>

                <div class="mr-2 mt-2">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Category</label>
                    <select name="category_id" id="category_id">
                        @php
                            $categories = App\Models\Category::all();
                        @endphp

                        @foreach($categories as $category)
                            <option value="{{$category->id}}"
                                {{old('category_id', $news->category_id) == $category->id ? 'selected' : ''}}>
                                {{ucwords($category->name)}}</option>
                        @endforeach

                    </select>

                    @error('category_id')
                    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
                    @enderror
                </div>

                <div class="flex justify-end mt-2 border-t border-gray-300">
                    <button type="submit"
                            class="bg-red-500 mt-2 text-white uppercase font-semibold text-xs py-2 px-10 rounded-2xl hover:bg-red-600">
                        Update
                    </button>
                </div>

            </form>
        </div>
    </div>

    <script>
        const profileImageInput = document.getElementById('thumbnail');
        const imagePreview = document.getElementById('image_preview1');


        profileImageInput.addEventListener('change', function (event) {
            const file = event.target.files[0];

            if (file) {
                const reader = new FileReader();

                reader.onload = function(e) {
                    imagePreview.src = e.target.result;
                    imagePreview.style.display = 'block';
                }

                reader.readAsDataURL(file);
            } else {
                imagePreview.src = '#';
                imagePreview.style.display = 'none';
            }
        });
    </script>

@endsection

