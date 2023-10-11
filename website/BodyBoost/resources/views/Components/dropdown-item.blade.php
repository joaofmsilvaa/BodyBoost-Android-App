@props(['active' => false])

@php
    $classes = 'block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white';

    if ($active){
        $classes .= ' bg-gray-600 text-white';
    }

@endphp

<a {{$attributes(['class' => $classes])}}
> {{$slot}}</a>
