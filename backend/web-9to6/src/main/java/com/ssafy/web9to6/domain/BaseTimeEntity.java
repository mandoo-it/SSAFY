package com.ssafy.web9to6.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // JPA Entity가 BaseTimeEntity를 상속할 때, 필드들을 컬럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity에 Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate // Entity 생성 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 값 변경 시간 자동 저장
    private LocalDateTime modifiedDate;
}
