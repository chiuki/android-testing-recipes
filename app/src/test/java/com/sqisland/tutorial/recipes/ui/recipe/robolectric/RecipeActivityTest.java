package com.sqisland.tutorial.recipes.ui.recipe.robolectric;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.BuildConfig;
import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.ui.recipe.RecipeActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk=22)
public class RecipeActivityTest {
  @Test
  public void recipeNotFound() {
    Activity activity = Robolectric.setupActivity(RecipeActivity.class);

    assertEquals("Recipes", activity.getTitle());

    TextView titleView = (TextView) activity.findViewById(R.id.title);
    assertEquals(View.GONE, titleView.getVisibility());

    TextView descriptionView = (TextView) activity.findViewById(R.id.description);
    assertEquals("Recipe not found", descriptionView.getText());
  }

  @Test
  public void carrots() {
    Intent intent = new Intent();
    intent.putExtra(RecipeActivity.KEY_ID, "creamed_carrots");

    Activity activity = Robolectric.buildActivity(RecipeActivity.class, intent).setup().get();

    TextView titleView = (TextView) activity.findViewById(R.id.title);
    assertEquals("Creamed Carrots", titleView.getText());
  }
}