package tacos.web.api;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import tacos.Ingredient;
import tacos.Ingredient.Type;

@Relation(value = "ingredient", collectionRelation = "ingredients")
public class IngredientEntityModel extends RepresentationModel<EntityModel<Ingredient>> {

    @Getter
    private final String name;

    @Getter
    private final Type type;

    public IngredientEntityModel(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}
