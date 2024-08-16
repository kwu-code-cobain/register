package com.cobain.register.controller;

import com.cobain.register.Dto.RegisterDto.RegisterRequestDto;
import com.cobain.register.Dto.RegisterDto.RegisterResponseDto;
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
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto) {
        RegisterResponseDto response = registerService.register(registerRequestDto);
        return ResponseEntity.ok(response);
    }
}
