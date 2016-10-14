package com.sqisland.tutorial.recipes.ui.recipe;

import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

public class RecipeActivityTest {
  @Rule
  public ActivityTestRule<RecipeActivity> activityRule
      = new ActivityTestRule<>(RecipeActivity.class);

  @Test
  public void recipeNotFound() {
    onView(withId(R.id.description))
        .check(matches(withText(R.string.recipe_not_found)));
    onView(withId(R.id.title))
        .check(matches(not(isDisplayed())));
  }
}