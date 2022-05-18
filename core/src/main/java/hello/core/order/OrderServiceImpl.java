package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책 변경, OCP 위반, 클라이언트 코드에(OrderserviceImpl) 영향을 미침
    //인터페이스에만 의존해야한다.
    //private final DiscountPolicy discountPolicy = new FixDiscountPoilcy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //해결 -> 인터페이스에만 의존, nullpointexception 발생
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
