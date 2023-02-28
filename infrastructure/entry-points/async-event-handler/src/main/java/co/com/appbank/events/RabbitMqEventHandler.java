package co.com.appbank.events;


import co.com.appbank.JSONMapper;
import co.com.appbank.JSONMapperImpl;
import co.com.appbank.events.data.Notification;
import co.com.appbank.model.events.ClienteCreado;
import co.com.appbank.usecase.ClienteCreadoUseCase;
import co.com.appbank.usecase.command.ClienteCreadoCommand;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
public class RabbitMqEventHandler {

    public static final String EVENTS_QUEUE = "events.queue";

    private final Logger logger = Logger.getLogger("RabbitMqEventHandler");
    private final JSONMapper mapper = new JSONMapperImpl();

    private final ClienteCreadoUseCase useCase;

    public RabbitMqEventHandler(ClienteCreadoUseCase useCase) {
        this.useCase = useCase;
    }

    @RabbitListener(queues = EVENTS_QUEUE)
    public void listener(String message) throws ClassNotFoundException {
        Notification notification = Notification.from(message);
        if(notification.getType()
                .equals("co.com.alpha.bcb.model.post.events.PostCreated")){
            logger.info(notification.toString());
            this.useCase.apply(Mono
                    .just((ClienteCreadoCommand) mapper.readFromJson(notification.getBody(),
                            ClienteCreado.class)))
                    .subscribe();
        }else{
            logger.info("we currently don't have a listener for that event " +notification.toString());
        }
    }
}
