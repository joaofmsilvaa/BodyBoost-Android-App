package com.example.bodyboost.views;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bodyboost.models.AppDatabase;
import com.example.bodyboost.viewmodels.FeedDao;
import com.example.bodyboost.R;

public class NewsFragment extends Fragment{

    private AppDatabase db;
    private FeedDao feedDao;


    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = this.getContext();

        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());
        feedDao = db.getFeedDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Stores the given argument ( an ID of the selected new ) in the newsId variable
        int newsId = com.example.bodyboost.views.NewsFragmentArgs.fromBundle(getArguments()).getSelectedNew();

        ImageView newsImageView = view.findViewById(R.id.newsImageView2);
        TextView newsTitle = view.findViewById(R.id.newstitleTextView2);
        TextView newsSmallDescription = view.findViewById(R.id.newsSmallDescriptionTextView);
        TextView newsFullDescription = view.findViewById(R.id.newsDescriptionTextView2);
        TextView newsDateTextView = view.findViewById(R.id.newsDateTextView2);
        TextView newsWebsiteNameTextView = view.findViewById(R.id.websiteNameTextView);

        Glide.with(context).load(feedDao.getNewsImgById(newsId)).into(newsImageView);
        newsTitle.setText(feedDao.getNewsTitleById(newsId));
        newsSmallDescription.setText(feedDao.getNewsSmallDesById(newsId));
        newsFullDescription.setText(feedDao.getFullDesById(newsId));
        newsDateTextView.setText(feedDao.getNewsDateById(newsId));
        newsWebsiteNameTextView.setText("Source: " + feedDao.getWebsiteById(newsId));

        newsWebsiteNameTextView.setPaintFlags(newsWebsiteNameTextView.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);


        newsWebsiteNameTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(feedDao.getSourceLinkById(newsId)));
                context.startActivity(viewIntent);
            }
        });

        newsImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(feedDao.getSourceLinkById(newsId)));
                context.startActivity(viewIntent);
            }
        });


    }



}