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

                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Title</label>
                <x-form.formInput name="title" value="{{$news->title}}"/>

                <div class="mt-3">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Excerpt</label>
                    <x-form.textarea name="excerpt">{{$news->excerpt}}</x-form.textarea>
                </div>

                <div class="mt-3">
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Body</label>
                    <x-form.textarea name="body">{{$meal->body}}</x-form.textarea>
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

                    @error('category')
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

@endsection

