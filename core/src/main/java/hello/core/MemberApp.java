package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemberServie;

public class MemberApp {
    public static void main(String[] args) {
        MemberServie memberServie = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberServie.join(member);

        Member findMember = memberServie.findMember(1L);

        System.out.println("new memberA = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
