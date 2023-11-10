package com.ssafy.web9to6.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExperiencesRepositoryTest {
    @Autowired
    ExperiencesRepository er;

    //DB에 접근할 수 있게 해준다.
    @PersistenceContext
    EntityManager em;

    @After // 단위 테스트 끝난 후에 실행될 메소드 지정. 없으면 안 끝남
    public void afterTest(){ }

    @Test
    public void testRegistrationUser(){
       String exp_org_name = "빅스비";
       String exp_org_period = "2011-11-11";
       String exp_org_role = "백개발";
       String exp_org_detail = "세부사항";
       String exp_org_type = "대외활동";
       Users user = em.find(Users.class, "test");

       er.save(Experiences.builder()
               .exp_org_name(exp_org_name)
               .exp_org_period(exp_org_period)
               .exp_org_detail(exp_org_detail)
               .exp_org_role(exp_org_role)
               .exp_org_type(exp_org_type)
               .user(user)
               .build());



        // when
        List<Experiences> expList = er.findAll();

        // then
        Experiences exp = expList.get(expList.size() - 1);
        assertThat(exp.getExp_org_detail()).isEqualTo(exp_org_detail);
        assertThat(exp.getExp_org_name()).isEqualTo(exp_org_name);
        assertThat(exp.getExp_org_period()).isEqualTo(exp_org_period);
        assertThat(exp.getExp_org_role()).isEqualTo(exp_org_role);
        assertThat(exp.getExp_org_type()).isEqualTo(exp_org_type);
        assertThat(exp.getUser().getUser_id()).isEqualTo(user.getUser_id());
    }
}
