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
                            <a href="http://localhost:8000/api/meals"><strong class="font-semibold">Endpoint:</strong> http://localhost:8000/api/meals</a>
                            <p><strong class="font-semibold">Method:</strong> <span class="text-blue-600">GET</span></p>

                            <p class="mt-4">Returns all the meals and their details</p>

                            <h3 class="mt-4 font-bold">Parameters</h3>
                            <p>None</p>

                            <h3 class="mt-4 font-bold">Example of response</h3>

                            <pre class="bg-gray-200 p-4 rounded-md overflow-x-auto">
<code class="text-sm">
{
  "data": [
    {
      "id": 6,
      "name": "Green Detox Smoothie",
      "dietary_type": "Vegan",
      "meal_type": "Drink",
      "excerpt": "Kickstart your day with this nutritious Green Detox Smoothie. Packed with vitamins, fiber, and antioxidants, it's a refreshing way to boost your energy and support your health.",
      "recipe": "Place the spinach, cucumber, green apple, lemon juice, and ginger in a blender.\r\n\r\n    Add water or coconut water to the blender.\r\n\r\n    If desired, add ice cubes for a colder smoothie.\r\n\r\n    Blend until smooth and well combined.\r\n\r\n    Pour into a glass and enjoy your Green Detox Smoothie!",
      "prep_time": "5.00",
      "cook_time": "0.00",
      "servings": 2,
      "calories": 150,
      "thumbnail": "thumbnails/i2T1D2LO0tTE4juDX3lqmtbOJOAhmLPlbmJUeu5M.jpg",
      "created_at": "2023-10-27T07:48:25.000000Z"
    },
    {
      "id": 5,
      "name": "Lemon Garlic Butter Shrimp Pasta",
      "dietary_type": "Non Vegetarian",
      "meal_type": "Dinner / Lunch",
      "excerpt": "Delight in the exquisite combination of succulent shrimp, zesty lemon, and creamy garlic-infused butter with our Lemon Garlic Butter Shrimp Pasta...",
      "recipe": "For the Shrimp:\r\n\r\nIn a large skillet, heat the butter ...\r\n\r\nFor the Pasta:\r\n\r\nIn a separate large pot, bring water to a boil, and add a pinch of salt. Cook the pasta according to the package instructions until al dente...\r\n\r\nServe hot, garnished with additional chopped parsley and lemon zest if desired.",
      "prep_time": "20.00",
      "cook_time": "15.00",
      "servings": 4,
      "calories": 380,
      "thumbnail": "thumbnails/nf3Ynk1T1cToI436vOBUmBcnRumAMCZS0UQPEmkK.jpg",
      "created_at": "2023-10-26T12:43:56.000000Z"
    }
  ]
}

</code>
        </pre>

                            <h3 class="mt-4 font-bold">Field description</h3>

                            <ul class="list-disc pl-6">
                                <li><strong>id</strong> (int): The unique identifier of the recipe.</li>
                                <li><strong>name</strong> (string): Name of the recipe.</li>
                                <li><strong>dietary_type</strong> (string): Dietary type (e.g., Vegan).</li>
                                <li><strong>meal_type</strong> (string): Meal type (e.g., Drink).</li>
                                <li><strong>excerpt</strong> (string): A brief description of the recipe.</li>
                                <li><strong>recipe</strong> (string): Detailed steps to prepare the smoothie.</li>
                                <li><strong>prep_time</strong> (string): Preparation time in minutes.</li>
                                <li><strong>cook_time</strong> (string): Cooking time in minutes.</li>
                                <li><strong>servings</strong> (int): Number of servings.</li>
                                <li><strong>calories</strong> (int): Caloric value per serving.</li>
                                <li><strong>thumbnail</strong> (string): URL of the recipe thumbnail.</li>
                                <li><strong>created_at</strong> (string): Recipe creation date.</li>
                            </ul>


                        </div>
                    </div>


                    <x-baseurl/>

                </div>
            </div>
        </div>
    </div>
</div>

