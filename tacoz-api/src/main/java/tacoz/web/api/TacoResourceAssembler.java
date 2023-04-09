package tacoz.web.api;

//import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import tacoz.Taco;

public class TacoResourceAssembler
        extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {

        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateModel(Taco taco) {

        return new TacoResource(taco);
    }

    @Override
    public TacoResource toModel(Taco taco) {

        return createModelWithId(taco.getId(), taco);
    }

}
