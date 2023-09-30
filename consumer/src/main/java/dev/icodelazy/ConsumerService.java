package dev.icodelazy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    public static final String KAFKA_ID = "knotify";
    public static final String KAFKA_TOPIC = "notification";

    @KafkaListener(id = KAFKA_ID, topics = KAFKA_TOPIC)
    public void receiveMessage(@Payload Notification notification,
                               @Header(KafkaHeaders.RECEIVED_KEY) String key) {

        log.info("key:{} | notification:{}", key, notification);

    }
}
