package com.spring.aop.listener;

import org.springframework.context.ApplicationEvent;

public class EntityCreatedEvent extends ApplicationEvent {

	public EntityCreatedEvent(Object source) {
		super(source);
	}
}