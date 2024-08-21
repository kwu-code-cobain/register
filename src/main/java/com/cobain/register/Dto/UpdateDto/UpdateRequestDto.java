package com.cobain.register.Dto.UpdateDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRequestDto {


    private String password;

    private String phoneNumber;

    private String userName;
}
