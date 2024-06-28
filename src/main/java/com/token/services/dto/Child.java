package com.token.services.dto;

import lombok.Data;

@Data
public class Child {
    private Long id;
    private String name;
    private Long fatherId;
    private Long motherId;

    public Child(String name, Long fatherId, Long motherId) {
        this.name = name;
        this.fatherId = fatherId;
        this.motherId = motherId;
    }
}
