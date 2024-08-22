package com.cobain.register.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity

public class Register {

    @Id
    private String id;

    private String password;

    private String userName;

    private String phoneNumber;

    @CreatedDate
    @Column(name = "register_time")
    private LocalDateTime registerTime;

}