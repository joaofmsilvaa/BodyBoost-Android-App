<?php

namespace App\Http\Controllers;

use App\Models\News;
use Illuminate\Http\Request;

class NewsController extends Controller
{

    public function create()
    {
        $filters = request(['search']);

        $news = News::latest()
            ->filter($filters)
            ->paginate(15);


        return view('news.index', compact('news'));
    }

    public function show(News $news)
    {
        return view('news.show', compact('news'));
    }
}
