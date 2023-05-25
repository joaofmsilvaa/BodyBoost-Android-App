package com.example.bodyboost.Feed_classes;

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
        return new com.example.bodyboost.Feed_classes.FeedAdapter.FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.bodyboost.Feed_classes.FeedAdapter.FeedViewHolder holder, int position) {
        Feed news = newsList.get(position);

        holder.newsTitleTextView.setText(news.newsTitle);
        holder.newsDescriptionTextView.setText(news.newsSmallDescription);

        Glide.with(holder.rootView.getContext()).load(news.getNewsImg()).into(holder.newsImageView);

        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedNew = holder.getAdapterPosition();
                selectedNew ++;
                NavDirections action = com.example.bodyboost.Feed_classes.feedFragmentDirections.actionFeedFragmentToNewsFragment(selectedNew);
                Navigation.findNavController(v).navigate(action);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView newsTitleTextView;
        TextView newsDescriptionTextView;
        ImageView newsImageView;

        TextView newsCard;

        public FeedViewHolder(@NonNull View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.newsTitleTextView = rootView.findViewById(R.id.newsTitleTextView);
            this.newsDescriptionTextView = rootView.findViewById(R.id.newsDescriptionTextView);
            this.newsImageView = rootView.findViewById(R.id.newsImageView);
            this.newsCard = rootView.findViewById(R.id.newsCard);

        }
    }
}