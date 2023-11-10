package com.ssafy.web9to6.dto;

import com.ssafy.web9to6.domain.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AwardsDto {
    private final Long id;
    private final Users user;
    private final String award_org;
    private final String award_title;
    private final String award_date;
    private final String award_prize;
    private final String award_detail;

}
