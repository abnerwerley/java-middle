package com.token.services.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Parent {

    @Id
    private Long id;
    private String name;

    public Parent(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
