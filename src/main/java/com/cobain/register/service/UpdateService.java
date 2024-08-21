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
        this.userRepository = userRepository;   // @Autowired 안 쓰고 의존성 주입하는 방법 (생성자 주입)
    }

    public UpdateResponseDto userUpdateById(String id, UpdateRequestDto updateRequestDto) {
        Register update = userRepository.findById(id);
        if (update == null) {
            throw new NullPointerException("회원이 존재하지 않습니다");
        }
        update.setPassword(updateRequestDto.getPassword()); // 제목 수정
        update.setUserName(updateRequestDto.getUserName());
        update.setPhoneNumber(updateRequestDto.getUserName());// 내용 수정

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
        update.setPassword(updateRequestDto.getPassword()); // 제목 수정
        update.setUserName(updateRequestDto.getUserName());
        update.setPhoneNumber(updateRequestDto.getUserName());// 내용 수정

        return new UpdateResponseDto(
                update.getId(),
                update.getPassword(),
                update.getUserName(),
                update.getPhoneNumber(),
                update.getRegisterTime());
    }

}
