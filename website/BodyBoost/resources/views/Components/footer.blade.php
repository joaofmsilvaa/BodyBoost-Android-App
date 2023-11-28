<div class="w-full bg-gray-300 mt-12 py-12 align-center rounded-t-xl">
    <div class="flex justify-center">
        <div class="mt-10">
            <pannel>
                <h5 class="text-3xl">Stay in touch with the latest news</h5>
                <p class="text-sm text-center">Promise to keep the inbox clean. No bugs.</p>
            </pannel>

            <div class="relative mt-5 inline-block w-full lg:bg-gray-200 rounded-full">

                <form method="POST" action="/newsletter" class="lg:flex text-sm">
                    @csrf
                    <div class="lg:py-3 lg:px-5 flex items-center w-full">

                        <input id="email" type="text" name="email" placeholder="Your email address"
                               class="lg:bg-transparent pl-4 focus-within:outline-none w-full">

                    </div>

                    <button type="submit"
                            class="relative transition-colors duration-300 bg-red-600 hover:bg-red-700 mt-4 lg:mt-0 lg:ml-3 rounded-full text-xs font-semibold text-white uppercase py-3 px-8">
                        Subscribe
                    </button>
                </form>

            </div>
        </div>
    </div>
</div>
    <footer class="bg-gray-900 ">
        <div class="mx-auto w-full max-w-screen-xl p-4 py-6 lg:py-8">
            <div class="md:flex md:justify-between">
                <div class="mb-6 md:mb-0">
                    <a href="/" class="flex items-center">
                        <img src="/images/logo_branco.png" class="h-12 mr-3" alt="BodyBoost Logo" />
                    </a>
                </div>
                <div class="grid grid-cols-2 gap-8 sm:gap-6 sm:grid-cols-3">
                    <div>
                        <h2 class="mb-6 text-sm font-semibold uppercase text-white">Resources</h2>
                        <ul class="text-gray-400 font-medium">
                            <li class="mb-4">
                                <a href="https://tailwindcss.com/" class="hover:underline">Tailwind CSS</a>
                            </li>
                            <li class="mb-4">
                                <a href="https://laravel.com/" class="hover:underline">Laravel</a>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <h2 class="mb-6 text-sm font-semibold uppercase text-white">Follow us</h2>
                        <ul class="text-gray-400 font-medium">
                            <li class="mb-4">
                                <a href="https://github.com/JOao7640/" class="hover:underline ">João Silva's Github</a>
                            </li>
                            <li class="mb-4">
                                <a href="https://github.com/IM-SaiNt-LuKe" class="hover:underline ">João Santos' Github</a>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <h2 class="mb-6 text-sm font-semibold uppercase text-white">Legal</h2>
                        <ul class="text-gray-400 font-medium">
                            <li class="mb-4">
                                <a href="privacy-police" class="hover:underline">Privacy Policy</a>
                            </li>
                            <li>
                                <a href="terms" class="hover:underline">Terms &amp; Conditions</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <hr class="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />
            <div class="sm:flex sm:items-center sm:justify-between">
          <span class="text-sm sm:text-center text-gray-400">© 2023 <a href="/" class="hover:underline">BodyBoost™</a>. All Rights Reserved.
          </span>
                <div class="flex mt-4 space-x-5 sm:justify-center sm:mt-0">
                    <a href="https://github.com/JOao7640/BodyBoost-Android-App" class="text-gray-500 hover:text-white">
                        <svg class="w-4 h-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                            <path fill-rule="evenodd" d="M10 .333A9.911 9.911 0 0 0 6.866 19.65c.5.092.678-.215.678-.477 0-.237-.01-1.017-.014-1.845-2.757.6-3.338-1.169-3.338-1.169a2.627 2.627 0 0 0-1.1-1.451c-.9-.615.07-.6.07-.6a2.084 2.084 0 0 1 1.518 1.021 2.11 2.11 0 0 0 2.884.823c.044-.503.268-.973.63-1.325-2.2-.25-4.516-1.1-4.516-4.9A3.832 3.832 0 0 1 4.7 7.068a3.56 3.56 0 0 1 .095-2.623s.832-.266 2.726 1.016a9.409 9.409 0 0 1 4.962 0c1.89-1.282 2.717-1.016 2.717-1.016.366.83.402 1.768.1 2.623a3.827 3.827 0 0 1 1.02 2.659c0 3.807-2.319 4.644-4.525 4.889a2.366 2.366 0 0 1 .673 1.834c0 1.326-.012 2.394-.012 2.72 0 .263.18.572.681.475A9.911 9.911 0 0 0 10 .333Z" clip-rule="evenodd"/>
                        </svg>
                        <span class="sr-only">GitHub project</span>
                    </a>
                </div>
            </div>
        </div>
    </footer>


