package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.RecipeStore;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipePresenter implements RecipeContract.Listener {
  private final RecipeStore store;
  private final Favorites favorites;
  private final RecipeContract.View view;

  private Recipe recipe = null;

  public RecipePresenter(RecipeStore store, Favorites favorites, RecipeContract.View view) {
    this.store = store;
    this.favorites = favorites;
    this.view = view;
  }

  public void loadRecipe(String id) {
    recipe = store.getRecipe(id);
    if (recipe == null) {
      view.showRecipeNotFoundError();
    } else {
      view.setTitle(recipe.title);
      view.setDescription(recipe.description);
      view.setFavorite(favorites.get(recipe.id));
    }
  }

  @Override
  public void toggleFavorite() {
    if (recipe == null) {
      throw new IllegalStateException("Need to load a valid recipe first");
    }
    boolean favorite = favorites.toggle(recipe.id);
    view.setFavorite(favorite);
  }
}