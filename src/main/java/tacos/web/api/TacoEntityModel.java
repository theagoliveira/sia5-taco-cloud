package tacos.web.api;

import java.util.Date;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import tacos.Taco;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoEntityModel extends RepresentationModel<EntityModel<Taco>> {

    private static final IngredientEntityModelAssembler ingredientAssembler = new IngredientEntityModelAssembler();

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final CollectionModel<IngredientEntityModel> ingredients;

    public TacoEntityModel(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
    }

}
