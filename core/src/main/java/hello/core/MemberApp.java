package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServie;
import hello.core.order.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberServie memberServie = appConfig.memberServie();
        //MemberServie memberServie = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberServie.join(member);

        Member findMember = memberServie.findMember(1L);

        System.out.println("new memberA = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
