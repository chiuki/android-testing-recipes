package com.sqisland.tutorial.recipes.injection;

import com.sqisland.tutorial.recipes.data.local.Favorites;

import java.util.HashMap;

public class InMemoryFavorites implements Favorites {
  private HashMap<String, Boolean> values = new HashMap<>();

  @Override
  public boolean get(String id) {
    Boolean value = values.get(id);
    return value == null ? false : value;
  }

  @Override
  public boolean toggle(String id) {
    boolean value = get(id);
    values.put(id, !value);
    return !value;
  }
}