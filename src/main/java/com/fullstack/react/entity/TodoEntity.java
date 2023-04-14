package com.fullstack.react.entity;

import lombok.Data;

@Data
public class TodoEntity {
    private String id;
    private String title;
    private boolean done;
}
