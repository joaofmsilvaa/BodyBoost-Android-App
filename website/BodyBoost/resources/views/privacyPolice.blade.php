

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
            <p class="mt-5 text-justify">Thank you for choosing BodyBoost for your fitness and well-being needs. This privacy policy is intended to inform our users about how we collect, use, share, and protect your personal information. By using our application, you agree to the practices outlined in this policy.

                1. Information Collected:

                1.1 Registration Information:

                Name
                Email address
                Date of birth
                Gender
                Other profile information
                1.2 Exercise Information:

                Workout data, including exercise type, duration, and intensity
                Progress over time
                1.3 Technical Information:

                Device type
                Operating system
                Device identifiers
                IP address
                Browser information
                2. Use of Information:

                2.1 Personalization of Experience:

                Personalized workout recommendations based on your profile and exercise history.
                2.2 Service Improvement:

                Data analysis to enhance the quality of service, features, and content.
                2.3 Communications:

                Sending information about updates, new features, and special offers (with opt-out option).
                3. Sharing of Information:

                3.1 Business Partners:

                Data sharing with service providers assisting in the operation and improvement of the application.
                3.2 Anonymization of Data:

                Sharing aggregated and anonymized data for research and analysis.
                3.3 Legal Compliance:

                Disclosure of information as required by law or to protect our legal rights.
                4. Security:

                We implement security measures to protect your information against unauthorized access and misuse. We used methods to guarentee that no one would steal your data, like using the CHATBOT HASH wombo combo.

                5. Your Rights:

                5.1 Access and Correction:

                You can access and correct your profile information at any time.
                5.2 Account Deletion:

                Option to delete your account and associated data.
                6. Children:

                BodyBoost is not intended for children under 13, and we do not knowingly collect personal information from children.

                7. Changes to the Policy:

                We reserve the right to modify this policy at any time. Changes will be notified through the application or other means.

                8. Contact:

                If you have questions about this policy, please contact us at "sup@bodyboost.pt".

                By continuing to use BodyBoost, you agree to this privacy policy.

                Thank you for trusting BodyBoost for your fitness and well-being goals!  (CHATBOT)
            </p>
            <p class="mt-5 text-sm text-gray-500 font-bold">Terms of service written by <a class="text-red-500" href="https://github.com/HeavyFromTF2">Martim Dias</a></p>
        </div>
    </div>
</section>

<x-footer/>


@if(session()->has('success'))
    <x-flash/>
@endif

</body>

</html>

