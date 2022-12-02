package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponGenerated extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String foodId;
    private String address;

    public CouponGenerated(OrderProcessing aggregate){
        super(aggregate);
    }
    public CouponGenerated(){
        super();
    }
}
