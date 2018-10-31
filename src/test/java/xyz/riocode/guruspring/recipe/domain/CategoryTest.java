package xyz.riocode.guruspring.recipe.domain;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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

    @Ignore
    @Test
    public void getDescription() {
    }

    @Ignore
    @Test
    public void getRecipes() {
    }
}