package com.cobain.register.Dto.RegisterDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequestDto {


    private String id;

    private String userName;

    private String password;

    private String phoneNumber;


}
