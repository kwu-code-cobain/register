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
        this.repository = repository;
    }

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        Register register = new Register();
        register.setId(registerRequestDto.getId());
        register.setPassword(registerRequestDto.getPassword());
        register.setUserName(registerRequestDto.getUserName());
        register.setPhoneNumber(registerRequestDto.getPhoneNumber());
        register.setRegisterTime(LocalDateTime.now());

        repository.save(register);

        return new RegisterResponseDto(
                register.getId(),
                register.getPassword(),
                register.getUserName(),
                register.getPhoneNumber(),
                register.getRegisterTime()
        );
    }

}
