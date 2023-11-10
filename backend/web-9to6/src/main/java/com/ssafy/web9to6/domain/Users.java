package com.ssafy.web9to6.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Collection;

@Getter
@NoArgsConstructor  // 기본 생성자 자동 추가
@Entity(name="users")  // JPA annotation. DB 작업 시, 실제 쿼리 대신 Entity 클래스를 수정해서 작업. 클래스의 카멜케이스 이름으로 매핑(ex. SalesManager.java -> sales_manager table)
public class Users {

    @Id // table의 PK
    private String user_id; // 회원 ID

    @Column(nullable = false)
    private String user_password; // 회원 비밀번호

    @Column(nullable = false)
    private String user_name; // 회원 이름

    @Column(nullable = false)
    private String user_email; // 회원 이메일

    @Column
    private String user_phone; // 회원 핸드폰번호

//    @Builder  // 빌더 패턴 클래스 생성. 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함
//    public Users(String user_id, String user_password, String user_name, String user_email) {
//        this.user_id = user_id;
//        this.user_password = user_password;
//        this.user_name = user_name;
//        this.user_email = user_email;
//    }

    @Builder  // 빌더 패턴 클래스 생성. 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함
    public Users(String user_id, String user_password, String user_name, String user_email, String user_phone) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
    }
}
