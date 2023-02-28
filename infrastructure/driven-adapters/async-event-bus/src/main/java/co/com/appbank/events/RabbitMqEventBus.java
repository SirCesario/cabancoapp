package co.com.appbank.events;




import co.com.appbank.events.data.Notification;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.serializer.JSONMapper;
import co.com.appbank.usecase.gateways.EventBus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventBus implements EventBus {

    public static final String EXCHANGE = "core-clients-events";
    public static final String ROUTING_KEY = "events.routing.key";
    private final RabbitTemplate rabbitTemplate;
    private final JSONMapper serializer;


    public RabbitMqEventBus(RabbitTemplate rabbitTemplate,  JSONMapper serializer) {
        this.serializer = serializer;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(DomainEvent event){
        var notification = new Notification(
                event.getClass().getTypeName(),
                serializer.writeToJson(event)
        );
        rabbitTemplate.convertAndSend(
                this.EXCHANGE, this.ROUTING_KEY, notification.serialize().getBytes()
        );
    }

    @Override
    public void publishError(Throwable errorEvent){
    }
}
