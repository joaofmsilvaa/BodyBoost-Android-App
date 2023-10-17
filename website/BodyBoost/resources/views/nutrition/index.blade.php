@extends ('components.nutricion-layout')

@section('header')
    <x-navbar/>
@endsection

@section('content')

    <section class="justify-center p-5 mt-8">
        <div class="overflow-hidden mt-8">
            <div class="flex justify-center">
                <h1 class="text-2xl font-semibold mt-5">We offer you the most
                    <span class="text-red-600">Delicious</span> and
                    <span class="text-red-600">Healthy</span> recipes on the internet !</h1>
            </div>

            <x-search :content="$searchContent"/>

            <x-dropdown-div :dietary_Types="$dietary_Types" :meal_Types="$meal_Types"/>

        </div>
    </section>

    <section class="justify-center p-5 my-8">
        @if($meals->count() > 0)
            <div class="lg:grid lg:grid-cols-3 px-3">
                @foreach($meals as $meal)
                    <x-meal_card :meal="$meal"/>
                @endforeach
            </div>
        @else
            <p class="my-3 text-center">No meals yet</p>
        @endif
    </section>

@endsection

