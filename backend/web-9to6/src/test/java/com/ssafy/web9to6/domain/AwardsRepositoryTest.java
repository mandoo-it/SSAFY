package com.ssafy.web9to6.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardsRepositoryTest {
    @Autowired
    AwardsRepository ar;

    //DB에 접근할 수 있게 해준다.
    @PersistenceContext
    EntityManager em;

    @After // 단위 테스트 끝난 후에 실행될 메소드 지정. 없으면 안 끝남
    public void afterTest(){ }

    @Test
    public void testRegistrationAwards(){
        Users user = em.find(Users.class, "test");
        String award_org = "삼성";
        String award_title = "빅스비 경진 대회";
        String award_date = "2011-32-23";
        String award_prize = "금상";
        String award_detail = "우승따리";

        ar.save(Awards.builder()
                .user(user)
                .award_date(award_date)
                .award_detail(award_detail)
                .award_org(award_org)
                .award_prize(award_prize)
                .award_title(award_title)
                .build()
        );

        List<Awards> list = ar.findAll();

        Awards awd = list.get(list.size()-1);
        assertThat(awd.getAward_date()).isEqualTo(award_date);
        assertThat(awd.getAward_detail()).isEqualTo(award_detail);
        assertThat(awd.getAward_org()).isEqualTo(award_org);
        assertThat(awd.getAward_prize()).isEqualTo(award_prize);
        assertThat(awd.getAward_title()).isEqualTo(award_title);
        assertThat(awd.getUser().getUser_id()).isEqualTo(user.getUser_id());
    }
}
