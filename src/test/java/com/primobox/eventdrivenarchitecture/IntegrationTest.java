package com.primobox.eventdrivenarchitecture;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.primobox.eventdrivenarchitecture.commun.infrastructure.mom.EvenementsEmisListenerExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = EventDrivenArchitectureApplication.class)
@ExtendWith(value = EvenementsEmisListenerExtension.class)
public @interface IntegrationTest {
}
