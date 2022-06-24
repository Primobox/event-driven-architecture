package com.primobox.eventdrivenarchitecture.commun.infrastructure.configuration;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.infrastructure.secondary.LoggingJmsMessageListener;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;

@Configuration
public class JmsListenerConfiguration implements JmsListenerConfigurer {
    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        var classpath = new ClassPathScanningCandidateComponentProvider(false);
        var filtreDesEvenements = new AssignableTypeFilter(Evenement.class);
        classpath.addIncludeFilter(filtreDesEvenements);
        var nomsDesClassesDesEvenements =
                classpath.findCandidateComponents("com.primobox.eventdrivenarchitecture")
                        .stream()
                        .map(BeanDefinition::getBeanClassName)
                        .toList();
        nomsDesClassesDesEvenements.forEach(nomDeClasse -> {
            var loggingEndpoint = new SimpleJmsListenerEndpoint();
            loggingEndpoint.setId("logging-" + nomDeClasse);
            loggingEndpoint.setDestination(nomDeClasse);
            loggingEndpoint.setMessageListener(new LoggingJmsMessageListener());

            registrar.registerEndpoint(loggingEndpoint);
        });
    }
}
