package com.spring.aop.vm;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class MessageVm {

    @NotBlank
    String name;
}
