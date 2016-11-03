package com.sqisland.tutorial.recipes.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecipeViewHolder extends RecyclerView.ViewHolder {
  public final TextView textView;
  public RecipeViewHolder(View itemView) {
    super(itemView);
    textView = (TextView) itemView;
  }
}