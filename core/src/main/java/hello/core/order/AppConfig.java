package hello.core.order;

import hello.core.discount.FixDiscountPoilcy;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemberServie;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberServie memberServie(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPoilcy());
    }
}
