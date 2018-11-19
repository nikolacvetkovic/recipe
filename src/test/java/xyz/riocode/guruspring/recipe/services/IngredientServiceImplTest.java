package xyz.riocode.guruspring.recipe.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import xyz.riocode.guruspring.recipe.commands.IngredientCommand;
import xyz.riocode.guruspring.recipe.converters.IngredientToIngredientCommand;
import xyz.riocode.guruspring.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import xyz.riocode.guruspring.recipe.domain.Ingredient;
import xyz.riocode.guruspring.recipe.domain.Recipe;
import xyz.riocode.guruspring.recipe.repositories.RecipeRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class IngredientServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    IngredientToIngredientCommand ingredientToIngredientCommand;
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    IngredientServiceImpl ingredientService;

    Recipe recipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        ingredientService = new IngredientServiceImpl(recipeRepository, ingredientToIngredientCommand);
        recipe = new Recipe();
        recipe.setId(1L);
    }

    @Test
    public void findByRecipeIdAndIngredientId() {
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);
        recipe.addIngredient(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);
        recipe.addIngredient(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);
        recipe.addIngredient(ingredient3);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 2L);

        assertEquals(Long.valueOf(2), ingredientCommand.getId());
        assertEquals(Long.valueOf(1), ingredientCommand.getRecipeId());
    }
}