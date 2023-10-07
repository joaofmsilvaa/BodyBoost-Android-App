<div>
    <p x-data="{ show: true}"
       x-init="setTimeout(() => show = false, 5000)"
       x-show="show"
       x-transition
       class="fixed bg-gray-800 text-white py-2 px-4 rounded-xl bottom-3 right-3 text-sm">
        {{session()->get('success')}}
    </p>
</div>
