package com.spring.aop.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Entity
@Table(name = "messages")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @NonNull
    @NotBlank
    String name;
}