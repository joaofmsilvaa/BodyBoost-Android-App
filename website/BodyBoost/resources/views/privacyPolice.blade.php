

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
            <h2 class="text-bold text-3xl">BodyBoost Privacy Policy</h2>
            <p class="mt-5 text-sm text-gray-500 font-bold">Last Updated: <span class="text-red-500">21/11/2023</span></p>
            <ul class="mt-5">
                <li>
                    <strong>1. Information Collected:</strong>
                    <ul>
                        <li>1.1 Registration Information:
                            <ul>
                                <li>Name</li>
                                <li>Email address</li>
                                <li>Date of birth</li>
                                <li>Gender</li>
                                <li>Other profile information</li>
                            </ul>
                        </li>
                        <li>1.2 Exercise Information:
                            <ul>
                                <li>Workout data, including exercise type, duration, and intensity</li>
                                <li>Progress over time</li>
                            </ul>
                        </li>
                        <li>1.3 Technical Information:
                            <ul>
                                <li>Device type</li>
                                <li>Operating system</li>
                                <li>Device identifiers</li>
                                <li>IP address</li>
                                <li>Browser information</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>2. Use of Information:</strong>
                    <ul>
                        <li>2.1 Personalization of Experience:
                            <ul>
                                <li>Personalized workout recommendations based on your profile and exercise history.</li>
                            </ul>
                        </li>
                        <li>2.2 Service Improvement:
                            <ul>
                                <li>Data analysis to enhance the quality of service, features, and content.</li>
                            </ul>
                        </li>
                        <li>2.3 Communications:
                            <ul>
                                <li>Sending information about updates, new features, and special offers (with opt-out option).</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>3. Sharing of Information:</strong>
                    <ul>
                        <li>3.1 Business Partners:
                            <ul>
                                <li>Data sharing with service providers assisting in the operation and improvement of the application.</li>
                            </ul>
                        </li>
                        <li>3.2 Anonymization of Data:
                            <ul>
                                <li>Sharing aggregated and anonymized data for research and analysis.</li>
                            </ul>
                        </li>
                        <li>3.3 Legal Compliance:
                            <ul>
                                <li>Disclosure of information as required by law or to protect our legal rights.</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>4. Security:</strong>
                    <ul>
                        <li>We implement security measures to protect your information against unauthorized access and misuse. We used methods to guarantee that no one would steal your data.</li>
                    </ul>
                </li>
                <li>
                    <strong>5. Your Rights:</strong>
                    <ul>
                        <li>5.1 Access and Correction:
                            <ul>
                                <li>You can access and correct your profile information at any time.</li>
                            </ul>
                        </li>
                        <li>5.2 Account Deletion:
                            <ul>
                                <li>Option to delete your account and associated data.</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <strong>6. Children:</strong>
                    <ul>
                        <li>BodyBoost is not intended for children under 15, and we do not knowingly collect personal information from children.</li>
                    </ul>
                </li>
                <li>
                    <strong>7. Changes to the Policy:</strong>
                    <ul>
                        <li>We reserve the right to modify this policy at any time. Changes will be notified through the application or other means.</li>
                    </ul>
                </li>
                <li>
                    <strong>8. Contact:</strong>
                    <ul>
                        <li>If you have questions about this policy, please contact us at "sup@bodyboost.pt".</li>
                    </ul>
                </li>
            </ul>
            <p class="mt-5 text-sm text-gray-500 font-bold">Privacy policy written by <a class="text-red-500" href="https://github.com/HeavyFromTF2">Martim Dias</a></p>
        </div>
    </div>
</section>

<x-footer/>


@if(session()->has('success'))
    <x-flash/>
@endif

</body>

</html>

