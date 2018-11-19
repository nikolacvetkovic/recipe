package xyz.riocode.guruspring.recipe.services;

import xyz.riocode.guruspring.recipe.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();


}
