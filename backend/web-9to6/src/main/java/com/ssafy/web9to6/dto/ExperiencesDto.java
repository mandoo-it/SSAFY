package com.ssafy.web9to6.dto;

import com.ssafy.web9to6.domain.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class ExperiencesDto {
    private final Long id;
    private final Users user;
    private final String exp_org_name;
    private final String exp_org_period;
    private final String exp_org_type;
    private final String exp_org_role;
    private final String exp_org_detail;
}
