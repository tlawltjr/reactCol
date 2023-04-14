package com.fullstack.react.controller;

import com.fullstack.react.DTO.ResponseDTO;
import com.fullstack.react.DTO.TestRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/testMap")
    public String test(){

        return "hi";
    }

    //요청시에 파라미터를 전달할 때 파라미터 매핑하는 방법(어노테이션)을 알아봅니다
    //@PathVariable : /지정된 uri 패스이후에 오는 파라미터를 특정 타입으로 자동 매핑해주는 어노테이션임
    @GetMapping("/{id}")
    public String testPathVariable(@PathVariable(required = false) int id) {

        return "안녕하세요 "+ id +"님";
    }

    //json으로 request 하는 요청을 처리하는 메서드 정의합니다.
    @GetMapping("/testRequestBody")
    public String testRequestBody(@RequestBody TestRequestDTO testRequestDTO) {

        return "요청 body 의 JSON 데이터를 분석한 내용  " +
                " id= "+testRequestDTO.getId() +
                " msg= "+testRequestDTO.getMessage();
    }

    //응답을 json 으로 주는 어노테이션을 이용해 봅니다.
    //@ResponseBody 를 사용하는데 이 인스턴스는 컨트롤러에서 얻어낸 응답 Data 를 JSON으로 바꿔서
    //응답해주는 객체입니다. JSON으로 데이터를 응답할때 간단히 사용가능
    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testResponseBody() {

        List<String> list= new ArrayList<>();
        list.add("안녕하세요 이 내용은 ResponseDTO내용입니다.");
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().data(list).build();
        return responseDTO;
    }

    //ResponseEntity 요청 정보를 header 정보와 같이 보낼 수 있는 API
    //헤더를 직접 조작 가능합니다.
    //헤더를 조작할 때는 HTTP의 헤더 속성을 나열하면 되고
    //내용을 보낼때는 body()메서드 내에 보내질 내용을 같이 보내면 됩니다.
    @GetMapping("/testResponseEntity")
    public ResponseEntity<String> testResponseEntity() {
        return ResponseEntity.ok("안녕하세요");
    }

}
