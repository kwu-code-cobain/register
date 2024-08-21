package com.cobain.register.service;

import com.cobain.register.entity.Register;
import com.cobain.register.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;   // @Autowired 안 쓰고 의존성 주입하는 방법 (생성자 주입)
    }

    public boolean login(String id, String password) {
        Optional<Register> userOptional = userRepository.findByUserId(id);

        if (userOptional.isEmpty()) {
            return false; // 사용자가 존재하지 않음
        }

        Register user = userOptional.get();
        // 패스워드가 일치하는지 확인
        return user.getPassword().equals(password);
    }
}
