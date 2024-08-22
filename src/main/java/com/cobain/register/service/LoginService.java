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
        this.userRepository = userRepository;
    }

    public boolean login(String id, String password) {
        Optional<Register> userOptional = userRepository.findByUserId(id);

        if (userOptional.isEmpty()) {
            return false;
        }

        Register user = userOptional.get();

        return user.getPassword().equals(password);
    }
}
