package tacoz.web.api;

//import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import tacoz.Ingredient;


@Component
class IngredientResourceAssembler extends
        RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {


    public IngredientResourceAssembler() {

        super(IngredientController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientResource instantiateModel(
            Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }

}