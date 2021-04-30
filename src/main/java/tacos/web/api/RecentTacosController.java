package tacos.web.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import tacos.Taco;
import tacos.data.TacoRepository;

@RepositoryRestController
public class RecentTacosController {

    @Autowired
    private TacoRepository tacoRepository;

    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<TacoEntityModel>> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());

        List<Taco> tacos = tacoRepository.findAll(page).getContent();

        CollectionModel<TacoEntityModel> recentModels = new TacoEntityModelAssembler().toCollectionModel(
            tacos
        );

        recentModels.add(
            linkTo(methodOn(RecentTacosController.class).recentTacos()).withRel("recents")
        );

        return new ResponseEntity<>(recentModels, HttpStatus.OK);
    }

}
