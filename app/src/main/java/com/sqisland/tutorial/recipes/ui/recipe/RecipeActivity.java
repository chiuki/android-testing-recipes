package com.sqisland.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.injection.RecipeApplication;

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View {
  public static final String KEY_ID = "id";

  private TextView titleView;
  private TextView descriptionView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe);
    
    titleView = (TextView) findViewById(R.id.title);
    descriptionView = (TextView) findViewById(R.id.description);

    RecipeStore store = new RecipeStore(this, "recipes");

    RecipeApplication app = (RecipeApplication) getApplication();
    Favorites favorites = app.getFavorites();

    final RecipePresenter presenter = new RecipePresenter(store, favorites, this);

    String id = getIntent().getStringExtra(KEY_ID);
    presenter.loadRecipe(id);

    titleView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.toggleFavorite();
      }
    });
  }

  @Override
  public void showRecipeNotFoundError() {
    titleView.setVisibility(View.GONE);
    descriptionView.setText(R.string.recipe_not_found);
  }

  @Override
  public void setTitle(String title) {
    titleView.setText(title);
  }

  @Override
  public void setDescription(String description) {
    descriptionView.setText(description);
  }

  @Override
  public void setFavorite(boolean favorite) {
    titleView.setSelected(favorite);
  }
}