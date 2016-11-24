package com.sqisland.tutorial.recipes.injection;

import android.app.Application;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.SharedPreferencesFavorites;

public class RecipeApplication extends Application {
  private Favorites favorites = null;

  public Favorites getFavorites() {
    if (favorites == null) {
      favorites = new SharedPreferencesFavorites(this);
    }
    return favorites;
  }
}