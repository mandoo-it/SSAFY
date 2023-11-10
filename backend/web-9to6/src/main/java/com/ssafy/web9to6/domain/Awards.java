package com.ssafy.web9to6.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="awards")
@Getter
@NoArgsConstructor
public class Awards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Users user;

    @Column(nullable = false)
    private String award_org;

    @Column(nullable = false)
    private  String award_title;

    @Column(nullable = false)
    private String award_date;

    @Column(nullable = false)
    private String award_prize;

    @Column(nullable = true)
    private String award_detail;

    @Builder
    public Awards(Users user, String award_org,String award_title, String award_detail, String award_date,String award_prize) {
        this.user = user;
        this.award_date = award_date;
        this.award_detail = award_detail;
        this.award_org = award_org;
        this.award_prize = award_prize;
        this.award_title = award_title;
    }



}
