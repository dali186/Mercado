package com.dali186.Mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dali186.Mercado.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
