package com.spring.aop.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EntityCreationEventListener implements ApplicationListener<EntityCreatedEvent> {

	@Async
	@Override
	public void onApplicationEvent(EntityCreatedEvent event) {
		log.info("Created instance: " + event.getSource().toString());
	}
}