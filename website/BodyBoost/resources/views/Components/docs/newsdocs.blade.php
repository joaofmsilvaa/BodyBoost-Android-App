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
                            <a href="http://localhost:8000/api/news"><strong class="font-semibold">Endpoint:</strong> http://localhost:8000/api/news</a>
                            <p><strong class="font-semibold">Method:</strong> <span class="text-blue-600">GET</span></p>

                            <p class="mt-4">Returns all the news and their details</p>

                            <h3 class="mt-4 font-bold">Parameters</h3>
                            <p>None</p>

                            <h3 class="mt-4 font-bold">Example of response</h3>

                            <pre class="bg-gray-200 p-4 rounded-md overflow-x-auto">
<code class="text-sm">
{
  "data": [
    {
      "id": 8,
      "title": "Suso: ‘I could understand Gerrard but Carragher was incredible",
      "category": "Interview",
      "thumbnail": "thumbnails/Y6HpfTLmPNJaSI057bZJGRI8WRHUr6Ld0BvbdP44.jpg",
      "excerpt": "When Suso glances across at the 11 men lined up on the other side of the tunnel on Tuesday evening, the guy with the armband wearing No 8 will look familiar. Nine years have passed, it was brief and much has changed, but the hair hasn’t.",
      "body": "When Suso glances across…there was the language.",
      "source": "https://www.theguardian.com/football/2023/oct/23/suso-i-could-understand-gerrard-but-carragher-was-incredible-sevilla-arsenal",
      "created_at": "25 Oct 2023"
    },
    {
      "id": 7,
      "title": "Virgil van Dijk loves F1 too’: Trent Alexander-Arnold’s need for speed",
      "category": "Interview",
      "thumbnail": "thumbnails/KVp2J9OoNxP4SBlM4TVR7VEOwOkv1PZZneUBexYZ.jpg",
      "excerpt": "Rank, it seems, still has its privileges. For Trent Alexander-Arnold that means on the Liverpool coach his teammates are out of luck if they want to watch something that clashes with Formula One",
      "body": "Rank, it seems, still ha…e laughing in the end.",
      "source": "https://www.theguardian.com/sport/2023/oct/22/virgil-van-dijk-loves-f1-trent-alexander-arnold-alpine",
      "created_at": "25 Oct 2023"
    }
  ]
}

</code>
        </pre>

                            <h3 class="mt-4 font-bold">Field description</h3>

                            <ul class="list-disc pl-6">
                                <li><strong>id</strong> (int): The unique identifier of the news.</li>
                                <li><strong>title</strong> (string): title of the news.</li>
                                <li><strong>category</strong> (string): Category ( e.g., Interview</li>
                                <li><strong>thumbnail</strong> (string): URL of the news thumbnail.</li>
                                <li><strong>source</strong> (string): URL of the news source website.</li>
                                <li><strong>created_at</strong> (string): News creation date.</li>
                            </ul>


                        </div>
                    </div>


                    <x-baseurl/>

                </div>
            </div>
        </div>
    </div>
</div>


