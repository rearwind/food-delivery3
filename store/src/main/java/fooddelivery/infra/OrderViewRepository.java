package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderViews", path="orderViews")
public interface OrderViewRepository extends PagingAndSortingRepository<OrderView, Long> {

    List<OrderView> findByOrderId(Long orderId);


    
}
