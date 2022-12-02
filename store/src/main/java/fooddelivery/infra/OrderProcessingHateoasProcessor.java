package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OrderProcessingHateoasProcessor implements RepresentationModelProcessor<EntityModel<OrderProcessing>>  {

    @Override
    public EntityModel<OrderProcessing> process(EntityModel<OrderProcessing> model) {

        
        return model;
    }
    
}
