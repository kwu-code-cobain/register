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
        this.deleteService = deleteService;
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> userDeleteById(@RequestParam(name = "id") String id) {
        deleteService.userDeleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping("/deletebyusername")
    public ResponseEntity<String> userDeleteByName(@RequestParam(name = "username") String username) {
        deleteService.userDeleteByName(username);
        return ResponseEntity.ok("Deleted");
    }

}
