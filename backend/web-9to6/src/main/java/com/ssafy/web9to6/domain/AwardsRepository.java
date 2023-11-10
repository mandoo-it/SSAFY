package com.ssafy.web9to6.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

public interface AwardsRepository extends JpaRepository<Awards, Long> {
}
