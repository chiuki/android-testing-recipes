package com.sqisland.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;
import com.sqisland.tutorial.recipes.injection.RecipeApplication;

public class RecipeActivity extends AppCompatActivity {
  public static final String KEY_ID = "id";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe);

    final TextView titleView = (TextView) findViewById(R.id.title);
    TextView descriptionView = (TextView) findViewById(R.id.description);

    RecipeStore store = new RecipeStore(this, "recipes");
    String id = getIntent().getStringExtra(KEY_ID);
    final Recipe recipe = store.getRecipe(id);
    
    if (recipe == null) {
      titleView.setVisibility(View.GONE);
      descriptionView.setText(R.string.recipe_not_found);
      return;
    }

    RecipeApplication app = (RecipeApplication) getApplication();
    final Favorites favorites = app.getFavorites();
    boolean favorite = favorites.get(recipe.id);

    titleView.setText(recipe.title);
    titleView.setSelected(favorite);
    titleView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        boolean result = favorites.toggle(recipe.id);
        titleView.setSelected(result);
      }
    });

    descriptionView.setText(recipe.description);
  }
}