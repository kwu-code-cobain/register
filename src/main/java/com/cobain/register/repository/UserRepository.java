package com.cobain.register.repository;

import com.cobain.register.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Register, Integer> {

}
