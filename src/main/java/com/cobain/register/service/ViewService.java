package com.cobain.register.service;

import com.cobain.register.Dto.ViewDto.ViewResponseDto;
import com.cobain.register.entity.Register;
import com.cobain.register.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ViewService {

    private final UserRepository userRepository;

    public ViewService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public ViewResponseDto userViewById(String id) {
        Register view = userRepository.findById(id);
        if(view == null) {
            throw new NullPointerException("회원이 존재하지 않습니다.");
        }
        return new ViewResponseDto(
                view.getId(),
                view.getUserName(),
                view.getPhoneNumber(),
                view.getRegisterTime());
    }

    public ViewResponseDto userViewByName(String userName) {
        Register view = userRepository.findByUserName(userName);
        if (view == null) {
            throw new NullPointerException("회원이 존재하지 않습니다");
        }
        return new ViewResponseDto(
                view.getId(),
                view.getUserName(),
                view.getPhoneNumber(),
                view.getRegisterTime());
    }
}
