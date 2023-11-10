package com.ssafy.web9to6.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "exp")
@NoArgsConstructor
@Getter
public class
Experiences {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Users user;

    @Column(nullable = false)
    private String exp_org_name;

    @Column(nullable = false)
    private String exp_org_period;

    @Column(nullable = false)
    private String exp_org_type;

    @Column(nullable = false)
    private String exp_org_role;

    @Column(nullable = true)
    private String exp_org_detail;

    @Builder  // 빌더 패턴 클래스 생성. 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함
    public Experiences(Users user, String exp_org_name, String exp_org_period, String exp_org_type, String exp_org_role, String exp_org_detail) {
        this.user = user;
        this.exp_org_detail = exp_org_detail;
        this.exp_org_name = exp_org_name;
        this.exp_org_period = exp_org_period;
        this.exp_org_role = exp_org_role;
        this.exp_org_type = exp_org_type;
    }
}