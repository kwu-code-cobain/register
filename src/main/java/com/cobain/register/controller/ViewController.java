package com.cobain.register.controller;


import com.cobain.register.Dto.ViewDto.ViewResponseDto;
import com.cobain.register.service.UpdateService;
import com.cobain.register.service.ViewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class ViewController {

    private final ViewService userViewService;

    public ViewController(ViewService userViewService) {
        this.userViewService = userViewService;
    }

    @GetMapping("/viewbyid")
    public ResponseEntity<?> boardViewById(@RequestParam(name = "id") String id) {
        try {
            ViewResponseDto response = userViewService.userViewById(id);
            return ResponseEntity.ok(response);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/viewbyname")
    public ResponseEntity<?> boardViewByWriter(@RequestParam(name = "username") String username) {
        try {
            ViewResponseDto response = userViewService.userViewByName(username);
            return ResponseEntity.ok(response);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
