<section class="py-8 py-8 max-w-full mt-12">

    <h1 class="text-lg font-bold mb-8 pb-2 border-b">
        {{$heading}}
    </h1>

    <div class="flex items-center">
        <aside class="w-full mb-6">
            <div>
                <ul class="flex">
                    <h4 class="font-semibold">Users links:</h4>
                    <li class="px-3">
                        <a href="/admin/users" class="{{request()->is('admin/users') ? 'text-red-500' : ''}}">All Users</a>
                    </li>
                </ul>
            </div>
            <div>
                <ul class="flex">
                    <h4 class="font-semibold">Meals links:</h4>
                    <li class="px-3">
                        <a href="/admin/meals" class="{{request()->is('admin/meals') ? 'text-red-500' : ''}}">All Meals</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/meal-types" class="{{request()->is('admin/meal-types') ? 'text-red-500' : ''}}">All Meals Types</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/dietary-types" class="{{request()->is('admin/dietary-types') ? 'text-red-500' : ''}}">All Dietary Types</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/meal-ingredients" class="{{request()->is('admin/meal-ingredients') ? 'text-red-500' : ''}}">All Meal Ingredients</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/ingredients" class="{{request()->is('admin/ingredients') ? 'text-red-500' : ''}}">All Ingredients</a>
                    </li>
                </ul>
            </div>
            <div>
                <ul class="flex">
                    <h4 class="font-semibold">News links:</h4>
                    <li class="px-3">
                        <a href="/admin/news" class="{{request()->is('admin/news') ? 'text-red-500' : ''}}">All News</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/categories" class="{{request()->is('admin/categories') ? 'text-red-500' : ''}}">All Categories</a>
                    </li>
                </ul>
            </div>


            <div>
                <ul class="flex">
                    <h4 class="font-semibold">Workout links:</h4>
                    <li class="px-3">
                        <a href="/admin/exercises" class="{{request()->is('admin/exercises') ? 'text-red-500' : ''}}">All Exercises</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/exercise-sets" class="{{request()->is('admin/exercise-sets') ? 'text-red-500' : ''}}">All Exercise Sets</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/exercise-steps" class="{{request()->is('admin/exercise-steps') ? 'text-red-500' : ''}}">All Exercise Steps</a>
                    </li>
                    <li class="px-3">
                        <a href="/admin/workout-plans" class="{{request()->is('admin/workout-plans') ? 'text-red-500' : ''}}">All Workout Plans</a>
                    </li>
                </ul>
            </div>

        </aside>
    </div>

    <main>
        <x-pannel>
            {{$slot}}
        </x-pannel>
    </main>

</section>
