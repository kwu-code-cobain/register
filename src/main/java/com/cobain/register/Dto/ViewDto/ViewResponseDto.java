package com.cobain.register.Dto.ViewDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViewResponseDto {

    private String id;

    private String userName;

    private String phoneNumber;

    private LocalDateTime registerTime;
}
