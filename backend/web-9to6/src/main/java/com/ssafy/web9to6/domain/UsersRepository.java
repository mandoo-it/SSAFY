/* DAO in MyBatis
 *  JPA에선 Repository라고 부르며, interface로 생성
 * */

package com.ssafy.web9to6.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> { // <Entity 클래스, PK 타입>
//    List<Users> findAllUsersDesc();
}
