package com.sqisland.tutorial.recipes.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
  private final RecipeStore store;

  public RecipeAdapter(RecipeStore store) {
    this.store = store;
  }

  @Override
  public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(
        R.layout.list_item, parent, false);
    return new RecipeViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final RecipeViewHolder holder, final int position) {
    final Recipe recipe = store.recipes.get(position);
    holder.textView.setText(recipe.title);
  }

  @Override
  public int getItemCount() {
    return store.recipes.size();
  }
}