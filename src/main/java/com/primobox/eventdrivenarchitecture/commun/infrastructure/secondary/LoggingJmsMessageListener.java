package com.primobox.eventdrivenarchitecture.commun.infrastructure.secondary;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.apache.activemq.artemis.jms.client.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingJmsMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(LoggingJmsMessageListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            var messageJson = message.getBody(String.class);
            var topicName = ((ActiveMQTopic) message.getJMSDestination()).getTopicName();
            logger.debug(topicName + " -> " + messageJson);
        } catch (JMSException jmsException) {
            throw new RuntimeException(jmsException.getMessage(), jmsException);
        }
    }
}
