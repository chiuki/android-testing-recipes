package com.sqisland.tutorial.recipes.ui.recipe.robolectric;

import com.sqisland.tutorial.recipes.BuildConfig;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk=22)
public class RecipeActivityTest {
}