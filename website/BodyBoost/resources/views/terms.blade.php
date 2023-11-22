

<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>BodyBoost</title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=figtree:400,600&display=swap" rel="stylesheet"/>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

    <!-- JS -->
    <script src="//unpkg.com/alpinejs" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/xjei76kbizfjo1f2974ozkdl8tkdjgb2jrmi8pvkjphg2uob/tinymce/6/tinymce.min.js"
            referrerpolicy="origin"></script>

    <!-- JS -->
    <script src="//unpkg.com/alpinejs" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <!-- ... Tinymce ... -->
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/xjei76kbizfjo1f2974ozkdl8tkdjgb2jrmi8pvkjphg2uob/tinymce/6/tinymce.min.js"
            referrerpolicy="origin"></script>

</head>
<body class="antialiased">

<x-navbar/>

<section class="justify-center p-5 my-8 flex">
    <div class="p-8 mt-10 overflow-hidden w-3/4 rounded-xl bg-gray-100">
        <div>
            <h2 class="text-bold text-3xl">BodyBoost Terms and Conditions</h2>
            <p class="mt-5 text-sm text-gray-500 font-bold">Last Updated: <span class="text-red-500">22/11/2023</span></p>
            <ul class="mt-5">
                <li>
                    <strong>1. Acceptance of Terms:</strong>
                    <ul>
                        <li>1.1 Agreement:
                            <ul>
                                <li>By using BodyBoost, you agree to these Terms of Use and our Privacy Policy.</li>
                            </ul>
                        </li>
                        <li>1.2 Updates:
                            <ul>
                                <li>We may update these terms periodically. Continued use constitutes acceptance of the updated terms. In case of changes to our terms of use, we will notify you.</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>2. Use of the Service:</strong>
                    <ul>
                        <li>2.1 Access:
                            <ul>
                                <li>We advise our users to have an age higher than 15, because there are some experienced exercises here, and we don't want anyone to meet the Bloody intern (IP).</li>
                            </ul>
                        </li>
                        <li>2.2 Account:
                            <ul>
                                <li>You are responsible for maintaining the confidentiality of your account credentials.</li>
                            </ul>
                        </li>
                        <li>2.3 User Conduct:
                            <ul>
                                <li>Users must comply with applicable laws and regulations. Just use the app for your domestic use.</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>3. Content and Intellectual Property:</strong>
                    <ul>
                        <li>3.1 Ownership:
                            <ul>
                                <li>BodyBoost and its content are owned by us. All rights reserved. We do not allow any plagiarism of our hard work. If we learn that’s the case, we will have to take legal measures.</li>
                            </ul>
                        </li>
                        <li>3.2 User Content:
                            <ul>
                                <li>By submitting content, you grant BodyBoost a non-exclusive license to use, modify, and distribute it (mostly from support tickets).</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>4. Prohibited Conduct:</strong>
                    <ul>
                        <li>4.1 Restrictions:
                            <ul>
                                <li>Users must not engage in illegal, harmful, or disruptive behavior related to the app.</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>5. Termination:</strong>
                    <ul>
                        <li>5.1 Termination by User:
                            <ul>
                                <li>Users can terminate their account at any time and their data will be deleted from our database.</li>
                            </ul>
                        </li>
                        <li>5.2 Termination by BodyBoost:
                            <ul>
                                <li>We reserve the right to terminate accounts for violations of these terms (but we like to have a positive mind about our grinding users!).</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>6. Disclaimers:</strong>
                    <ul>
                        <li>6.1 No Warranty:
                            <ul>
                                <li>BodyBoost is provided "as is" without warranties.</li>
                            </ul>
                        </li>
                        <li>6.2 Limitation of Liability:
                            <ul>
                                <li>We are not liable for any damages arising from the use of BodyBoost. If you believe an exercise is causing harm in any way, please submit a ticket to our support team; they will gladly oblige.</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>7. Governing Law:</strong>
                    <ul>
                        <li>These terms are governed by the law</li>
                    </ul>
                </li>
                <li>
                    <strong>8. Changes to Terms:</strong>
                    <ul>
                        <li>We reserve the right to modify these terms. Changes will be communicated through the application.</li>
                    </ul>
                </li>
                <li>
                    <strong>9. Contact:</strong>
                    <ul>
                        <li>If you have questions about these terms, please contact us at sup@bodyboost.pt</li>
                    </ul>
                </li>
            </ul>
            <p class="mt-5 text-sm text-gray-500 font-bold">Terms and conditions written by <a class="text-red-500" href="https://github.com/HeavyFromTF2">Martim Dias</a></p>
        </div>
    </div>
</section>

<x-footer/>


@if(session()->has('success'))
    <x-flash/>
@endif

</body>

</html>

