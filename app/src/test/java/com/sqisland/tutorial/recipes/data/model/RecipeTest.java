package com.sqisland.tutorial.recipes.data.model;

import org.junit.Test;

import java.io.InputStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

public class RecipeTest {
  @Test
  public void water() {
    InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
    Recipe recipe = Recipe.readFromStream(stream);
    assertNotNull(recipe);
    assertEquals("water", recipe.id);
    assertEquals("Water", recipe.title);
    assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);
  }

  @Test
  public void noId() {
    InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/no_id.txt");
    Recipe recipe = Recipe.readFromStream(stream);
    assertNull(recipe);
  }

  @Test
  public void mixed() {
    InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");
    Recipe recipe = Recipe.readFromStream(stream);
    assertNotNull(recipe);
    assertEquals("punch", recipe.id);
    assertEquals("Punch", recipe.title);
    assertEquals("Juice of 3 lemons\n" +
        "1 orange\n" +
        "1 pint grape juice\n" +
        "1 cup sugar\n" +
        "1 cup water\n" +
        "1 pine apple juice\n" +
        "Mix all together and strain. Add large piece of ice.", recipe.description);
  }
}