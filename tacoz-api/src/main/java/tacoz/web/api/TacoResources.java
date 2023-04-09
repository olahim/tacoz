package tacoz.web.api;

import java.util.List;

//import org.springframework.hateoas.Resources;
import org.springframework.hateoas.CollectionModel;

public class TacoResources extends CollectionModel<TacoResource> {

    public TacoResources(List<TacoResource> tacoResources) {

        super(tacoResources);
    }
}
