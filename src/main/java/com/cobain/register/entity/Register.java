package com.cobain.register.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity

public class Register {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String password;

    private String userName;

    private String phoneNumber;

    @CreatedDate
    @Column(name = "register_time", updatable = false) //데이터베이스에 있는 write_time 과 매핑 , updatable = false 는 초기값 설정후 변경하지 않음)
    private LocalDateTime registerTime;

}