package com.jayfox.jfenterpriseindividuallab.services;

import com.jayfox.jfenterpriseindividuallab.entities.Member;

import java.util.List;

public interface MemberServiceInterface {
    List<Member> getMembers();
    Member getMemberById(Long id);
    Member updateMember(Member member);
    Member addMember(Member member);
    void deleteMember(Long id);
}
