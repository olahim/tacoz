package tacoz.web.api;

//import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import tacoz.Ingredient;
import tacoz.Ingredient.Type;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    @Getter
    private String name;

    @Getter
    private Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}
