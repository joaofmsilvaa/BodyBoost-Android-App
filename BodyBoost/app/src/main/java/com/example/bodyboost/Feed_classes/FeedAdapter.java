package com.example.bodyboost.Feed_classes;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.bodyboost.Exercise_classes.DaysFragmentDirections;
import com.example.bodyboost.R;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<com.example.bodyboost.Feed_classes.FeedAdapter.FeedViewHolder> {

    private List<Feed> newsList;

    public FeedAdapter(List<Feed> News) {
        this.newsList = News;
    }

    @NonNull
    @Override
    public com.example.bodyboost.Feed_classes.FeedAdapter.FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        return new com.example.bodyboost.Feed_classes.FeedAdapter.FeedViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.bodyboost.Feed_classes.FeedAdapter.FeedViewHolder holder, int position) {
        Feed news = newsList.get(position);

        holder.newsTitleTextView.setText(news.newsTitle);
        holder.newsDescriptionTextView.setText(news.newsSmallDescription);
        holder.newsDateTextView.setText(news.newsDate);
        holder.websiteNameTextView.setText("Source: " + news.sourceWebsite);

        Glide.with(holder.rootView.getContext()).load(news.getNewsImg()).into(holder.newsImageView);

        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedNew = holder.getAdapterPosition();
                selectedNew ++;
                NavDirections action = com.example.bodyboost.Feed_classes.feedFragmentDirections.actionFeedFragmentToNewsFragment(selectedNew);
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