package tacoz.web.api;

import java.util.Date;
import java.util.List;

//import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.RepresentationModel;
//import org.springframework.hateoas.core.Relation;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import tacoz.Ingredient;
import tacoz.Taco;

@Relation(value="taco", collectionRelation="tacos")
public class TacoResource extends RepresentationModel<TacoResource> {

    private static final IngredientResourceAssembler
            ingredientAssembler = new IngredientResourceAssembler();

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<IngredientResource> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients =
                //ingredientAssembler.toModel(taco.getIngredients());
                (List<IngredientResource>) ingredientAssembler.toModel((Ingredient) taco.getIngredients());
    }

}
