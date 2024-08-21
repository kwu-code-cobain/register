package com.cobain.register.service;

import com.cobain.register.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DeleteService {

    private final UserRepository userRepository;

    public DeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;   // @Autowired 안 쓰고 의존성 주입하는 방법 (생성자 주입)
    }


    public void userDeleteById(String id) {
        userRepository.deleteById(id);
    }

    public void userDeleteByName(String username) {
        userRepository.deleteById(username);
    }
}
