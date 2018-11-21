package xyz.riocode.guruspring.recipe.services;

import xyz.riocode.guruspring.recipe.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);
    void deleteIngredientById(Long recipeId, Long ingredientId);

}
