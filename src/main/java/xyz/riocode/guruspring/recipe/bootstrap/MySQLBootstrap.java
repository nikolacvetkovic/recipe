package xyz.riocode.guruspring.recipe.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import xyz.riocode.guruspring.recipe.domain.Category;
import xyz.riocode.guruspring.recipe.domain.UnitOfMeasure;
import xyz.riocode.guruspring.recipe.repositories.CategoryRepository;
import xyz.riocode.guruspring.recipe.repositories.UnitOfMeasureRepository;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class MySQLBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public MySQLBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(categoryRepository.count() == 0L) {
            log.debug("Loading categories");
            loadCategories();
        }

        if(unitOfMeasureRepository.count() == 0L) {
            log.debug("Loading UOMs");
            loadUom();
        }
    }

    private void loadCategories(){
        Category americanCategory = new Category();
        americanCategory.setDescription("American");
        categoryRepository.save(americanCategory);

        Category italianCategory = new Category();
        italianCategory.setDescription("Italian");
        categoryRepository.save(italianCategory);

        Category mexicanCategory = new Category();
        mexicanCategory.setDescription("Mexican");
        categoryRepository.save(mexicanCategory);

        Category fastFoodCategory = new Category();
        fastFoodCategory.setDescription("Fast Food");
        categoryRepository.save(fastFoodCategory);
    }

    private void loadUom(){

        UnitOfMeasure eachUom = new UnitOfMeasure();
        eachUom.setDescription("Each");
        unitOfMeasureRepository.save(eachUom);

        UnitOfMeasure tableSpoonUom = new UnitOfMeasure();
        tableSpoonUom.setDescription("Tablespoon");
        unitOfMeasureRepository.save(tableSpoonUom);

        UnitOfMeasure teapoonUom = new UnitOfMeasure();
        teapoonUom.setDescription("Teaspoon");
        unitOfMeasureRepository.save(teapoonUom);

        UnitOfMeasure dashUom = new UnitOfMeasure();
        dashUom.setDescription("Dash");
        unitOfMeasureRepository.save(dashUom);

        UnitOfMeasure pintUom = new UnitOfMeasure();
        pintUom.setDescription("Pint");
        unitOfMeasureRepository.save(pintUom);

        UnitOfMeasure cupUom = new UnitOfMeasure();
        cupUom.setDescription("Cup");
        unitOfMeasureRepository.save(cupUom);

        UnitOfMeasure ounceUom = new UnitOfMeasure();
        ounceUom.setDescription("Ounce");
        unitOfMeasureRepository.save(ounceUom);

        UnitOfMeasure pinchUom = new UnitOfMeasure();
        pinchUom.setDescription("Pinch");
        unitOfMeasureRepository.save(pinchUom);

    }
}
