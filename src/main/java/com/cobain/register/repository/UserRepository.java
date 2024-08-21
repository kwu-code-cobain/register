package com.cobain.register.repository;

import com.cobain.register.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Register, Integer> {

    Register findById(String id);

    Register findByUserName(String userName);

    @Query("SELECT r FROM Register r WHERE r.id = :userId")
    Optional<Register> findByUserId(@Param("userId") String userId);


    void deleteById(String id);
}
