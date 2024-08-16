package com.cobain.register.service;


import com.cobain.register.Dto.RegisterDto.RegisterRequestDto;
import com.cobain.register.Dto.RegisterDto.RegisterResponseDto;
import com.cobain.register.entity.Register;
import com.cobain.register.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class RegisterService {

    private final UserRepository repository;

    public RegisterService(UserRepository repository) {
        this.repository = repository;   // @autowired 안쓰고 의존성 주입하는 방법 (생성자 주입 )

    }

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        Register register = new Register();
        register.setRegisterTime(LocalDateTime.now());
        repository.save(register);

        return new RegisterResponseDto(register.getId(), register.getPassword(), register.getUserName(),
                   register.getPhoneNumber(), register.getRegisterTime());

    }

}
