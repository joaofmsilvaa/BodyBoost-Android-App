package com.example.bodyboost.nutricion;

import android.content.Context;
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
import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.DaysAdapter;
import com.example.bodyboost.R;

import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder> {

    private List<Meals> mealsList;

    public MealsAdapter(List<Meals> mealsList) {
        this.mealsList = mealsList;
    }

    @NonNull
    @Override
    public MealsAdapter.MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_meals, parent, false);
        return new MealsAdapter.MealsViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.MealsViewHolder holder, int position) {
        Meals meals = this.mealsList.get(position);
        holder.recipeNameTextView.setText(meals.mealName);
        holder.recipeDescTextView.setText(meals.mealsShortDescription);

        Glide.with(holder.rootView.getContext()).load(meals.getMealImage()).into(holder.mealImageView);

        holder.recipeCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedRecipe = holder.getAdapterPosition();
                NavDirections action = com.example.bodyboost.nutricion.nutricionFragmentDirections.actionNutricionFragmentToFragmentRecipe(selectedRecipe);
                Navigation.findNavController(v).navigate(action);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }


    public class MealsViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        Context context;
        TextView recipeNameTextView;
        TextView recipeDescTextView;
        TextView recipeCard;
        ImageView mealImageView;

        public MealsViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.rootView = itemView;
            this.context = context;
            recipeNameTextView = rootView.findViewById(R.id.recipeNameTextView);
            recipeDescTextView = rootView.findViewById(R.id.recipeDescTextView);
            mealImageView = rootView.findViewById(R.id.mealImageView);
            recipeCard = rootView.findViewById(R.id.recipeCard);

        }
    }
}
