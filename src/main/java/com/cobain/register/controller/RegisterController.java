package com.cobain.register.controller;

import com.cobain.register.Dto.RegisterDto.RegisterRequestDto;
import com.cobain.register.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;   // @autowired 안쓰고 의존성 주입하는 방법 (생성자 주입 )
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto) {
        registerService.register(registerRequestDto);
        return ResponseEntity.ok("회원가입에 성공했습니다.");
    }
}
