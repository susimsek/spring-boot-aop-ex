package com.spring.aop.aspect;

import com.spring.aop.listener.EntityCreatedEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Aspect
public class EventPublishingAspect {

	ApplicationEventPublisher eventPublisher;

	@AfterReturning(value = "execution(public * org.springframework.data.repository.Repository+.save*(..))", returning = "entity")
	public void publishEntityCreatedEvent(JoinPoint jp, Object entity) throws Throwable {
		String entityName = entity.getClass().getSimpleName();
		if (!entityName.endsWith("EntityNamesToBeExcluded")) {
			eventPublisher.publishEvent(new EntityCreatedEvent(entity));
		}
	}
}