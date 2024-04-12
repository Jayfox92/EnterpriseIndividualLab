package com.jayfox.jfenterpriseindividuallab.services;

import com.jayfox.jfenterpriseindividuallab.entities.Member;
import com.jayfox.jfenterpriseindividuallab.exceptions.ResourceNotFoundException;
import com.jayfox.jfenterpriseindividuallab.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements MemberServiceInterface{
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        if(memberRepository.existsById(id)){
            Optional<Member> existingMember = memberRepository.findById(id);
            if(existingMember.isPresent()){
                return existingMember.get();
            }
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }
        return null;
    }

    @Override
    public Member updateMember(Member member) {
        Member existingMember = memberRepository.findById(member.getId()).orElseThrow(()->new ResourceNotFoundException("Member", "id", member.getId()));
        existingMember.setFirstName(member.getFirstName());
        existingMember.setLastName(member.getLastName());
        if(member.getAddress() != null){
            existingMember.setAddress(member.getAddress());
        }
        existingMember.setEmail(member.getEmail());
        existingMember.setPhone(member.getPhone());
        existingMember.setDateOfBirth(member.getDateOfBirth());
        return memberRepository.save(existingMember);
    }

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
