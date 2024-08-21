package com.cobain.register.controller;

import com.cobain.register.service.DeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class DeleteController {

    private final DeleteService deleteService;

    public DeleteController(DeleteService deleteService) {
        this.deleteService = deleteService;   // @autowired 안쓰고 의존성 주입하는 방법 (생성자 주입 )
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> userDeleteById(@RequestParam(name = "id") String id) {
        deleteService.userDeleteById(id); // id로 게시물 삭제
        return ResponseEntity.ok("Deleted"); // 성공 메시지 반환
    }

    @DeleteMapping("/deletebyusername")
    public ResponseEntity<String> userDeleteByName(@RequestParam(name = "username") String username) {
        deleteService.userDeleteByName(username); // id로 게시물 삭제
        return ResponseEntity.ok("Deleted"); // 성공 메시지 반환
    }

}
