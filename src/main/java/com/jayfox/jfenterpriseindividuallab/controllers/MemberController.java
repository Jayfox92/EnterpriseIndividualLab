package com.jayfox.jfenterpriseindividuallab.controllers;

import com.jayfox.jfenterpriseindividuallab.entities.Member;
import com.jayfox.jfenterpriseindividuallab.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/members", method = RequestMethod.GET)
    @ResponseBody
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @RequestMapping(value = "/admin/member/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Member getMemberById(@PathVariable(value = "id") Long id) {
        return memberService.getMemberById(id);
    }

    @RequestMapping(value = "/admin/updatemember", method = RequestMethod.PUT)
    @ResponseBody
    public Member updateMember(@RequestBody Member member){
        return memberService.updateMember(member);
    }

    @RequestMapping(value = "/admin/addmember", method = RequestMethod.POST)
    @ResponseBody
    public Member addMember(@RequestBody Member member){
        return memberService.addMember(member);
    }

    @RequestMapping(value = "/admin/deletemember", method = RequestMethod.GET)
    public String deleteMemberView(Model model){
        model.addAttribute("members", memberService.getMembers());
        return "member-list";
    }

    @RequestMapping(value = "admin/deletemember/{id}", method = RequestMethod.GET)
    public String deleteMember(@PathVariable("id") Long id, Model model){
        memberService.deleteMember(id);
        model.addAttribute("members", memberService.getMembers());
        return "member-list";
    }
}
