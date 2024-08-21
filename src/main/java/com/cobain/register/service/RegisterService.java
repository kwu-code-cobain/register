package com.cobain.register.service;

import com.cobain.register.Dto.RegisterDto.RegisterRequestDto;
import com.cobain.register.Dto.RegisterDto.RegisterResponseDto;
import com.cobain.register.entity.Register;
import com.cobain.register.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class RegisterService {

    private final UserRepository repository;

    public RegisterService(UserRepository repository) {
        this.repository = repository;   // @Autowired 안 쓰고 의존성 주입하는 방법 (생성자 주입)
    }

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        Register register = new Register();
        register.setId(registerRequestDto.getId()); // 입력된 ID 설정
        register.setPassword(registerRequestDto.getPassword()); // 입력된 비밀번호 설정
        register.setUserName(registerRequestDto.getUserName()); // 입력된 사용자 이름 설정
        register.setPhoneNumber(registerRequestDto.getPhoneNumber()); // 입력된 전화번호 설정
        register.setRegisterTime(LocalDateTime.now()); // 등록 시간 설정

        repository.save(register);

        // 입력된 정보를 그대로 반환하는 로직
        return new RegisterResponseDto(
                register.getId(),
                register.getPassword(),
                register.getUserName(),
                register.getPhoneNumber(),
                register.getRegisterTime()
        );
    }

}
