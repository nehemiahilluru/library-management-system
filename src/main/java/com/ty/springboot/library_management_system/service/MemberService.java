package com.ty.springboot.library_management_system.service;

import com.ty.springboot.library_management_system.entity.Member;
import com.ty.springboot.library_management_system.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public Member getById(Long id){
        Optional<Member> opt = memberRepository.findById(id);
        if(opt.isPresent()) return opt.get();
        throw new RuntimeException("Id not found");
    }

    public Member save(Member member){
       return memberRepository.save(member);
    }

    public Member update(Long id ,Member member){
        boolean exists = memberRepository.existsById(id);
        if(!exists) throw new RuntimeException("Id not found");
        return memberRepository.save(member);
    }

    public void delete(Long id){
        boolean exists = memberRepository.existsById(id);
        if(!exists) throw new RuntimeException("Id not found");
        memberRepository.deleteById(id);
    }
}
