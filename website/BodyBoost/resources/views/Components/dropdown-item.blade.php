@props(['active' => false])

@php
    $classes = 'block text-left px-3 text-sm leading-6 hover:bg-red-600 focus:bg-red-500 rounded-xl text-white focus:text-white';

    if ($active){
        $classes .= ' bg-gray-600 text-white';
    }

@endphp

<a {{$attributes(['class' => $classes])}}> {{$slot}}</a>
