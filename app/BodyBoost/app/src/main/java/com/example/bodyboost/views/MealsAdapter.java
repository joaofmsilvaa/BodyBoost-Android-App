package com.example.bodyboost.views;

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
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.w3c.dom.Text;

import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder> {

    private List<Meals> mealsList;

    // Create the constructor of the mealsAdapter that needs a list of meals as a parameter
    public MealsAdapter(List<Meals> mealsList) {
        this.mealsList = mealsList;
    }

    @NonNull
    @Override
    public MealsAdapter.MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout of the meals list
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_meals, parent, false);
        return new MealsAdapter.MealsViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.MealsViewHolder holder, int position) {
        // Store the current meal of the adapter
        Meals meals = this.mealsList.get(position);

        // Set the current information's in the textviews
        holder.recipeNameTextView.setText(meals.getMealName());
        holder.recipeDescTextView.setText(meals.getMealsShortDescription());
        holder.caloriesTextView.setText(meals.getCalories() + " cal");

        holder.dietaryTypeTV.setText(meals.getDietary_type());
        holder.mealTypeTv.setText(meals.getMeal_type());

        // Load the meals image in the imageview
        Picasso.get().load("http://10.0.2.2:8000/storage/" + meals.getMealImage()).into(holder.mealImageView);

        // Navigate to the nutritionFragment of the selectedRecipe
        holder.recipeCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedRecipe = meals.getMealId();
                NavDirections action = com.example.bodyboost.views.nutricionFragmentDirections.actionNutricionFragmentToFragmentRecipe(selectedRecipe);
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
        TextView caloriesTextView;
        TextView dietaryTypeTV;
        TextView mealTypeTv;
        ImageView mealImageView;

        public MealsViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.rootView = itemView;
            this.context = context;
            recipeNameTextView = rootView.findViewById(R.id.recipeNameTextView);
            recipeDescTextView = rootView.findViewById(R.id.recipeDescTextView);
            mealImageView = rootView.findViewById(R.id.mealImageView);
            recipeCard = rootView.findViewById(R.id.recipeCard);
            caloriesTextView = rootView.findViewById(R.id.caloriesTextView);
            dietaryTypeTV = rootView.findViewById(R.id.textView17);
            mealTypeTv = rootView.findViewById(R.id.textView19);

        }
    }
}
