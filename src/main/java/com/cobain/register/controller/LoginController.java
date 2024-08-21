package com.cobain.register.controller;


import com.cobain.register.Dto.LoginDto.LoginRequestDto;
import com.cobain.register.service.LoginService;
import com.cobain.register.service.UpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;   // @autowired 안쓰고 의존성 주입하는 방법 (생성자 주입 )
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        boolean loginTest = loginService.login(loginRequestDto.getId(), loginRequestDto.getPassword());

        if (loginTest) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 틀렸습니다.");
        }
    }
}
