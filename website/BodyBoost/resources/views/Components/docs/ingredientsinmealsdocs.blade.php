<div class="flex-initial justify-center pt-8 pr-8 pb-8 overflow-hidden w-9/12" id="inicio">
    <div class="flex justify-center items-center mt-5 pt-8 pb-8 pr-8">
        <div class="container mx-auto m-5">
            <div class="py-8">
                <div class="flex flex-col justify-center lg:flex-row">
                    <div class="p-5 lg:w-6/12 text-center lg:text-left">
                        <h1 class="text-3xl font-semibold mt-5 flex">
                            API Reference
                        </h1>
                        <div>
                            <a><strong class="font-semibold">Endpoint:</strong>
                                http://localhost:8000/api/meals/{id}/meal-ingredients</a>
                            <p><strong class="font-semibold">Method:</strong> <span class="text-blue-600">GET</span></p>

                            <p class="mt-4">Returns the relation between the meal and the ingredient, indicating the
                                measure of the ingredients in the desired meal</p>

                            <h3 class="mt-4 font-bold">Parameters</h3>
                            <p>Id of the desired meal</p>

                            <h3 class="mt-4 font-bold">Example of response</h3>

                            <pre class="bg-gray-200 p-4 rounded-md overflow-x-auto">
<code class="text-sm">
{
  "data": [
    {
        "id": 2,
        "ingredients_id": 2,
        "meal_id": 1,
        "name": "1 cup"
    },
    {
        "id": 4,
        "ingredients_id": 4,
        "meal_id": 1,
        "name": "1 can ( 15 oz )"
    }
  ]
}

</code>
        </pre>

                            <h3 class="mt-4 font-bold">Field description</h3>

                            <ul class="list-disc pl-6">
                                <li><strong>id</strong> (int): The unique identifier of the "meal-ingredient".</li>
                                <li><strong>ingredients_id</strong> (int): Identifier of the ingredient</li>
                                <li><strong>meal_id</strong> (int): Identifier of the meal</li>
                                <li><strong>name</strong> (String): Amount of the certain ingredient used in the meal</li>
                            </ul>


                        </div>
                    </div>


                    <x-baseurl/>

                </div>
            </div>
        </div>
    </div>
</div>




