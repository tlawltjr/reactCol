package com.fullstack.react.service;

import com.fullstack.react.DTO.TodoDTO;
import com.fullstack.react.entity.TodoEntity;
import com.fullstack.react.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    //create메서드 구현
    //기본적인 기능은 save()와 findUserId()를 통한 데이터 입출입니다.
    public TodoDTO create(final TodoEntity todoEntity) {

        validate(todoEntity);

        todoRepository.save(todoEntity);

        String saved = todoEntity.getId();

        System.out.println("entity id :"+todoEntity.getId());


        return new TodoDTO(todoEntity);
    }
    public void validate(final TodoEntity todoEntity){
        if(todoEntity == null) {
            System.out.println("entity is null");
            throw new RuntimeException("entity is null");
        }else if(todoEntity.getUserId() == null) {
            System.out.println("userId is null");
            throw new RuntimeException("userId is null");
        }
    }





    public String todoService() {
        TodoEntity todoEntity = TodoEntity.builder().title("todo 해보쟈~").build();
        todoRepository.save(todoEntity);
        TodoEntity savedEntity = todoRepository.findById(todoEntity.getId()).get();
        return savedEntity.getTitle();
    }
}
