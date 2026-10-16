package com.ty.springboot.library_management_system.controller;

import com.ty.springboot.library_management_system.entity.Member;
import com.ty.springboot.library_management_system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> body = memberService.getAll();
        return new ResponseEntity<>(body , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
       Member body = memberService.getById(id);
        return new ResponseEntity<>(body,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member){
        Member body = memberService.save(member);
        return new ResponseEntity<>(body , HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id , @RequestBody Member member) {
        Member body = memberService.update(id,member);
        return new ResponseEntity<>(body , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable Long id){
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
