package fooddelivery.infra;

import fooddelivery.domain.*;
import fooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderViewViewHandler {


    @Autowired
    private OrderViewRepository orderViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_CREATE_1 (@Payload Paid paid) {
        try {

            if (!paid.validate()) return;

            // view 객체 생성
            OrderView orderView = new OrderView();
            // view 객체에 이벤트의 Value 를 set 함
            orderView.setOrderId(paid.getOrderId());
            orderView.setStatus("주문됨");
            // view 레파지 토리에 save
            orderViewRepository.save(orderView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                List<OrderView> orderViewList = orderViewRepository.findByOrderId(deliveryStarted.getOrderId());
                for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setStatus("배달시작됨");
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelled_then_UPDATE_2(@Payload PaymentCancelled paymentCancelled) {
        try {
            if (!paymentCancelled.validate()) return;
                // view 객체 조회

                List<OrderView> orderViewList = orderViewRepository.findByOrderId(paymentCancelled.getOrderId());
                for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setStatus("주문취소됨");
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCancelled_then_UPDATE_3(@Payload DeliveryCancelled deliveryCancelled) {
        try {
            if (!deliveryCancelled.validate()) return;
                // view 객체 조회

                List<OrderView> orderViewList = orderViewRepository.findByOrderId(deliveryCancelled.getOrderId());
                for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setStatus("배달취소됨");
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

