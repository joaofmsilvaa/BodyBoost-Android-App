@props(['name'])

<div class="mt-6">

    <textarea name="{{$name}}"
              class="border border-gray-200 p-2 w-full rounded"
              for="{{$name}}"
              >{{$slot ?? old($name)}}</textarea>

    @error($name)
    <p class="text-red-500 text-xs mt-2">{{$message}}</p>
    @enderror
</div>
