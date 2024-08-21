package com.cobain.register.Dto.UpdateDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateResponseDto {



    private String id;

    private String userName;

    private String password;

    private String phoneNumber;

    private LocalDateTime registerTime;
}
