package com.spring.aop.controller;

import com.spring.aop.model.Message;
import com.spring.aop.service.MessageService;
import com.spring.aop.vm.MessageVm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/versions/1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class MessageController {

    MessageService messageService;

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.OK)
    public Message createMessage(@Valid @RequestBody MessageVm messageVm){
        return messageService.createMessage(messageVm);
    }
}
