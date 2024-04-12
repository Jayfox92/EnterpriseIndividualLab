package com.jayfox.jfenterpriseindividuallab.repositories;

import com.jayfox.jfenterpriseindividuallab.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
