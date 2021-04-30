package tacos.web.api;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import tacos.Ingredient;

public class IngredientEntityModelAssembler
        extends RepresentationModelAssemblerSupport<Ingredient, IngredientEntityModel> {

    public IngredientEntityModelAssembler() {
        super(IngredientController.class, IngredientEntityModel.class);
    }

    @Override
    protected IngredientEntityModel instantiateModel(Ingredient entity) {
        return new IngredientEntityModel(entity);
    }

    @Override
    public IngredientEntityModel toModel(Ingredient entity) {
        return createModelWithId(entity.getId(), entity);
    }

}
