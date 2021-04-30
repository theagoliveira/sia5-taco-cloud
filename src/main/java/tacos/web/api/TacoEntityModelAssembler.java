package tacos.web.api;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import tacos.Taco;

public class TacoEntityModelAssembler
        extends RepresentationModelAssemblerSupport<Taco, TacoEntityModel> {

    public TacoEntityModelAssembler() {
        super(DesignTacoController.class, TacoEntityModel.class);
    }

    @Override
    protected TacoEntityModel instantiateModel(Taco entity) {
        return new TacoEntityModel(entity);
    }

    @Override
    public TacoEntityModel toModel(Taco entity) {
        return createModelWithId(entity.getId(), entity);
    }

}
