package com.ssafy.web9to6.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersResponseDtoTest {
    @Test
    public void testLombok(){
        // given
        String user_id = "test";
        String user_password = "1234";
        String user_name = "test";
        String user_email = "test@ssafy.com";
        String user_phone = "010-1111-2222";

        // when
        UsersResponseDto dto = new UsersResponseDto(user_id, user_password, user_name, user_email, user_phone); // lombok에 의해 객체 자동 생성

        // then
        assertThat(dto.getUser_id()).isEqualTo(user_id);
        assertThat(dto.getUser_password()).isEqualTo(user_password);
        assertThat(dto.getUser_name()).isEqualTo(user_name);
        assertThat(dto.getUser_email()).isEqualTo(user_email);
        assertThat(dto.getUser_phone()).isEqualTo(user_phone);
    }
}
