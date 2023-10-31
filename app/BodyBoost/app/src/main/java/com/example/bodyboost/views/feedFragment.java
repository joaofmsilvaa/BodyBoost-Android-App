package com.example.bodyboost.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.Feed;
import com.example.bodyboost.models.databaseModels.FeedDao;
import com.example.bodyboost.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link feedFragment} factory method to
 * create an instance of this fragment.
 */
public class feedFragment extends Fragment {

    private FeedAdapter adapter;
    private AppDatabase db;
    private FeedDao feedDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain an instance of ReportDatabase and ReportDao
        db = AppDatabase.getInstance(getContext());
        feedDao = db.getFeedDao();

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

        List<Feed> getAll = feedDao.getAll();
        adapter = new FeedAdapter(getAll);

        recyclerView.setAdapter(adapter);
    }
}