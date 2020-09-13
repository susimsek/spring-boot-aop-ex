package com.spring.aop.service;

import com.spring.aop.model.Message;
import com.spring.aop.respository.MessageRepository;
import com.spring.aop.vm.MessageVm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class MessageServiceImpl implements MessageService {

    MessageRepository messageRepository;
    ModelMapper modelMapper;

    @Override
    public Message createMessage(MessageVm messageVm) {
        Message message=modelMapper.map(messageVm,Message.class);
        return messageRepository.save(message);
    }
}
