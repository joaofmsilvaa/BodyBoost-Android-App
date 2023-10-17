@props(['name', 'type' => 'text'])

<div class="mb-6">

    <input class="border border-gray-200 p-2 w-full rounded"
           type="{{$type}}"
           name="{{$name}}"
           id="{{$name}}"
        {{$attributes(['value' => old($name)]) }}
    >

    @error($name)
    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
    @enderror
</div>
