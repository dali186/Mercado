package com.dali186.Mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dali186.Mercado.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	@Query("SELECT m FROM Member m WHERE m.id = :id")
	Member findByMemberId(@Param("id") String id);
}
