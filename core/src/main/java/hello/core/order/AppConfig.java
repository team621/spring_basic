package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPoilcy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemberServie;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberServie memberServie(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        //return new FixDiscountPoilcy();
        return new RateDiscountPolicy();
    }
}