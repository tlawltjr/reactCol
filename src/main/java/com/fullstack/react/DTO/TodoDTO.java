package com.fullstack.react.DTO;

import com.fullstack.react.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoDTO {
    private String id;
    private String userId;
    private String title;
    private boolean done;


    //나중에 EntityToDTO 변환 메서드 작성 하겠지만
    //그게 왜 필요한 지에 대한 에시를 위해 생성자에서 필드를 초기화 하도록 할게요.

    //아래 생성자를 호출하기 위해서 반드시 Entity를 파람으로 줘야하는데
    //그렇게 되면 Entity의 내용을 그대로 받아내는 DTO 객체가 자동 생성됩니다.
    //즉 아래 생성자는 EntityToDTO와 같은 기능을 합니다.
    public TodoDTO(TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.userId = entity.getUserId();
        this.done = entity.isDone();
    }
    public static TodoEntity toEntity(final TodoDTO dto) {
        return TodoEntity.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .title(dto.getTitle()).
                done(dto.isDone())
                .build();
    }


}
