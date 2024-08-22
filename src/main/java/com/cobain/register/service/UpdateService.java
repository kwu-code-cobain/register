package com.cobain.register.service;

import com.cobain.register.Dto.UpdateDto.UpdateRequestDto;
import com.cobain.register.Dto.UpdateDto.UpdateResponseDto;
import com.cobain.register.entity.Register;
import com.cobain.register.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class UpdateService {

    private final UserRepository userRepository;

    public UpdateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UpdateResponseDto userUpdateById(String id, UpdateRequestDto updateRequestDto) {
        Register update = userRepository.findById(id);
        if (update == null) {
            throw new NullPointerException("회원이 존재하지 않습니다");
        }
        update.setPassword(updateRequestDto.getPassword());
        update.setUserName(updateRequestDto.getUserName());
        update.setPhoneNumber(updateRequestDto.getUserName());

        return new UpdateResponseDto(
                update.getId(),
                update.getPassword(),
                update.getUserName(),
                update.getPhoneNumber(),
                update.getRegisterTime());
    }

    public UpdateResponseDto userUpdateByUserName(String userName, UpdateRequestDto updateRequestDto) {
        Register update = userRepository.findByUserName(userName);
        if (update == null) {
            throw new NullPointerException("회원이 존재하지 않습니다");
        }
        update.setPassword(updateRequestDto.getPassword());
        update.setUserName(updateRequestDto.getUserName());
        update.setPhoneNumber(updateRequestDto.getUserName());

        return new UpdateResponseDto(
                update.getId(),
                update.getPassword(),
                update.getUserName(),
                update.getPhoneNumber(),
                update.getRegisterTime());
    }

}
