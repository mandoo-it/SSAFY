package com.ssafy.web9to6.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {
    @Autowired
    UsersRepository usersRepository;

    @After // 단위 테스트 끝난 후에 실행될 메소드 지정. 없으면 안 끝남
    public void afterTest(){ }

    @Test
    public void testRegistrationUser(){
        // given
        String user_id = "test";
        String user_password = "1234";
        String user_name = "test";
        String user_email = "test@ssafy.com";
        String user_phone = "010-1111-2222";

        usersRepository.save(Users.builder().user_id(user_id)
                                            .user_password(user_password)
                                            .user_name(user_name)
                                            .user_email(user_email)
                                            .user_phone(user_phone)
                                            .build());

        // when
        List<Users> usersList = usersRepository.findAll();

        // then
        Users user = usersList.get(0);
        assertThat(user.getUser_id()).isEqualTo(user_id);
        assertThat(user.getUser_password()).isEqualTo(user_password);
        assertThat(user.getUser_name()).isEqualTo(user_name);
        assertThat(user.getUser_email()).isEqualTo(user_email);
        assertThat(user.getUser_phone()).isEqualTo(user_phone);
    }
}
