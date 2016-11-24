package com.sqisland.tutorial.recipes.data.local;

public interface Favorites {
  boolean get(String id);
  boolean toggle(String id);
}