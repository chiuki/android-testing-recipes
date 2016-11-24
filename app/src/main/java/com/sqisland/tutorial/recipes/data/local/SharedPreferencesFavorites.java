package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesFavorites {
  private final SharedPreferences pref;

  public SharedPreferencesFavorites(Context context) {
    pref = context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE);
  }

  public boolean get(String id) {
    return pref.getBoolean(id, false);
  }

  public boolean toggle(String id) {
    boolean favorite = get(id);
    put(id, !favorite);
    return !favorite;
  }

  private void put(String id, boolean favorite) {
    SharedPreferences.Editor editor = pref.edit();
    if (favorite) {
      editor.putBoolean(id, true);
    } else {
      editor.remove(id);
    }
    editor.apply();
  }
}