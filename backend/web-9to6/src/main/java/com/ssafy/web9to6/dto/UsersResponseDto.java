package com.ssafy.web9to6.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsersResponseDto {
    private final String user_id;
    private final String user_password;
    private final String user_name;
    private final String user_email;
    private final String user_phone;
}
