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
import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.DaysAdapter;
import com.example.bodyboost.R;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private List<Ingredients> ingredientsList;

    public IngredientAdapter(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    @NonNull
    @Override
    public IngredientAdapter.IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ingredients, parent, false);
        return new IngredientAdapter.IngredientViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientAdapter.IngredientViewHolder holder, int position) {
        Ingredients ingredients = this.ingredientsList.get(position);
        AppDatabase db = AppDatabase.getInstance(holder.context);

        holder.ingredientNameTextView.setText(ingredients.ingredientName);
        holder.ingredientQuantityTextView.setText(db.getMealIngredientsDao().getQuantityById(ingredients.ingredientsId));

    }

    @Override
    public int getItemCount() {
        return ingredientsList.size();
    }


    public class IngredientViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        Context context;
        TextView ingredientNameTextView;
        TextView ingredientQuantityTextView;

        public IngredientViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.rootView = itemView;
            ingredientNameTextView = rootView.findViewById(R.id.ingredientNameTextView);
            ingredientQuantityTextView = rootView.findViewById(R.id.ingredientQuantityTV);


        }
    }
}
