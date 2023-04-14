package com.fullstack.react.DTO;

import com.fullstack.react.entity.TodoEntity;

public class TodoDTO {
    private String id;
    private String title;
    private boolean done;


    //나중에 EntityToDTO 변환 메서드 작성 하겠지만
    //그게 왜 필요한 지에 대한 에시를 위해 생성자에서 필드를 초기화 하도록 할게요.
    public TodoDTO(TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }


}
