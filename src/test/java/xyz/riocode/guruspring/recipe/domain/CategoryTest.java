package xyz.riocode.guruspring.recipe.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }


    @Test
    public void getId() {
        Long id = 4L;

        category.setId(id);

        assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {
        String description = "Description";
        category.setDescription(description);

        assertEquals("Description", category.getDescription());

    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipes.add(recipe1);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipes.add(recipe2);

        category.setRecipes(recipes);

        assertEquals(2, category.getRecipes().size());

    }
}