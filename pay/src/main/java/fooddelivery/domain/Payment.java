package fooddelivery.domain;

import fooddelivery.domain.PaymentCancelled;
import fooddelivery.PayApplication;
import javax.persistence.*;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Long id;

    private Long orderId;

    private Long price;

    private String action;


    @PrePersist
    public void onPrePersist(){
        if ("cancel".equals(action)) {
            PaymentCancelled paymentCancelled = new PaymentCancelled();
            BeanUtils.copyProperties(this, paymentCancelled);
            paymentCancelled.publish();
        } else {
            Paid paid = new Paid();
            BeanUtils.copyProperties(this, paid);
    
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    paid.publish();
                }
            });
        }
    }

    @PostPersist
    public void onPostPersist(){


        // PaymentCancelled paymentCancelled = new PaymentCancelled(this);
        // paymentCancelled.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PayApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }


    public static void cancelPayment(OrderCancelled orderCancelled){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        PaymentCancelled paymentCancelled = new PaymentCancelled(payment);
        paymentCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process */
        
        repository().findByOrderId(orderCancelled.getId()).ifPresent(payment->{
            
            payment.setAction("cancel"); // do something
            repository().save(payment);

            PaymentCancelled paymentCancelled = new PaymentCancelled(payment);
            paymentCancelled.publishAfterCommit();

         });
        

        
    }


}
