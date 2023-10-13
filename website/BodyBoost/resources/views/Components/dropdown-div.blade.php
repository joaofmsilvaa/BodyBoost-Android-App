@props(['dietary_Types', 'meal_Types'])

<div class="flex justify-center">
    <div class="flex justify-start mt-4 w-3/4">
        <div>
            <x-dropdown :dietary_Types="$dietary_Types"/>
            <x-mealtype-dropdown :meal_Types="$meal_Types"/>
        </div>
    </div>
</div>
