package com.example.bodyboost.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.databaseModels.FeedDao;
import com.example.bodyboost.R;
import com.example.bodyboost.viewmodels.MealsViewModel;
import com.example.bodyboost.viewmodels.NewsViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link feedFragment} factory method to
 * create an instance of this fragment.
 */
public class feedFragment extends Fragment {

    private FeedAdapter adapter;
    private NewsViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.feedRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        viewModel.getNews().observe(getViewLifecycleOwner(), news -> {

            adapter = new FeedAdapter(news);
            recyclerView.setAdapter(adapter);
        });
    }
}