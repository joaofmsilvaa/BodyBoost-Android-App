package com.example.bodyboost.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.bodyboost.models.Feed;
import com.example.bodyboost.R;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private List<Feed> newsList;

    public FeedAdapter(List<Feed> News) {
        this.newsList = News;
    }

    @NonNull
    @Override
    public FeedAdapter.FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        return new FeedAdapter.FeedViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.FeedViewHolder holder, int position) {
        Feed news = newsList.get(position);

        holder.newsTitleTextView.setText(news.getNewsTitle());
        holder.newsDescriptionTextView.setText(news.getNewsSmallDescription());
        holder.newsDateTextView.setText(news.newsDate);
        holder.websiteNameTextView.setText("Source: " + news.sourceWebsite);

        holder.websiteNameTextView.setPaintFlags(holder.websiteNameTextView.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);


        Glide.with(holder.rootView.getContext()).load(news.getNewsImg()).into(holder.newsImageView);

        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedNew = holder.getAdapterPosition();
                selectedNew ++;
                NavDirections action = com.example.bodyboost.views.feedFragmentDirections.actionFeedFragmentToNewsFragment(selectedNew);
                Navigation.findNavController(v).navigate(action);
            }
        });

        holder.websiteNameTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(news.sourceLink));
                                holder.context.startActivity(viewIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {

        Context context;
        View rootView;
        TextView newsTitleTextView;
        TextView newsDescriptionTextView;
        TextView newsDateTextView;
        ImageView newsImageView;
        TextView websiteNameTextView;
        TextView newsCard;

        public FeedViewHolder(@NonNull View rootView, Context context) {
            super(rootView);
            this.context = context;
            this.rootView = rootView;
            this.newsTitleTextView = rootView.findViewById(R.id.newsTitleTextView);
            this.newsDescriptionTextView = rootView.findViewById(R.id.newsDescriptionTextView);
            this.newsDateTextView = rootView.findViewById(R.id.newsDateTextView);
            this.websiteNameTextView = rootView.findViewById(R.id.textView14);
            this.newsImageView = rootView.findViewById(R.id.newsImageView);
            this.newsCard = rootView.findViewById(R.id.newsCard);

        }
    }
}