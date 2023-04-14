package com.fullstack.react.controller;

import com.fullstack.react.DTO.ResponseDTO;
import com.fullstack.react.DTO.TodoDTO;
import com.fullstack.react.entity.TodoEntity;
import com.fullstack.react.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    //여기에 Service로 활용할 클래스의 변수를 선언하고 컨트롤러에게 빈 생성 및 주입을 하라고
    //어노테이션 선언
    @Autowired
    private TodoService todoService;

    @GetMapping("/test")
    private ResponseEntity test(){
        //그럼 위 service의 내용을 응답body에 넣어서 200 ok로 응답하는 로직 구햔
        String msg = todoService.todoService();
        List<String> list= new ArrayList<>();
        list.add(msg);
        ResponseDTO<String> dto = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(dto);
    }

    private ResponseEntity<ResponseDTO<String>> todoService(@RequestBody TodoDTO dto){
        try{
            String tempUserId = "temp_user";

            //DTO를 Entity로 변환합니다.
            TodoEntity entity = TodoDTO.toEntity(dto);

            //id를 null로 초기화
            entity.setId(null);

            //위 임시 UserId를 세팅함
            entity.setUserId(tempUserId);

            TodoDTO dto2 = todoService.create(entity);

            List<TodoDTO> list= new ArrayList<>();
            list.add(dto2);

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(list).build();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
