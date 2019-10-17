package demo.springboot.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        log.info("send：" + message );
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME,message);
    }
}
