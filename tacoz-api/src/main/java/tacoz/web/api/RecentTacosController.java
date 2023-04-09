package tacoz.web.api;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;



import java.util.List;

import org.springframework.data.rest.webmvc.RepositoryRestController;
//import org.springframework.hateoas.Resources;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;
//import reactor.core.publisher.Mono;
import tacoz.Taco;
import tacoz.data.TacoRepository;

@RepositoryRestController
public class RecentTacosController extends CollectionModel<TacoResource>{

    private TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(path="/tacos/recent", produces="application/hal+json")
    public Mono<ResponseEntity<CollectionModel<TacoResource>>> recentTacos() {
        return tacoRepo.findAll()
                .take(12)
                .collectList()
                .map(tacos -> {
                    List<TacoResource> tacoResources =
                            //new TacoResourceAssembler().toModel(tacos);
                            (List<TacoResource>) new TacoResourceAssembler().toModel((Taco) tacos);

                    CollectionModel<TacoResource> recentResources =
                         CollectionModel.of(tacoResources);

                    recentResources.add(
                            linkTo(methodOn(RecentTacosController.class).recentTacos())
                                    .withRel("recents"));

                    return new ResponseEntity<>(recentResources, HttpStatus.OK);
                });
    }

}
