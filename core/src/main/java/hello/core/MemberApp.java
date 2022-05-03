package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    // psvm
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        // new Member(1L, "memberA", Grade.VIP); 작성후 ctrl alt v
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 일반적인 테스트 -> 비효율적 -> junit을 통한 테스트가 효율적
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
