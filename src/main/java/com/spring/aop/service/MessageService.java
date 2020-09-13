package com.spring.aop.service;

import com.spring.aop.model.Message;
import com.spring.aop.vm.MessageVm;

public interface MessageService {

    Message createMessage(MessageVm messageVm);
}
