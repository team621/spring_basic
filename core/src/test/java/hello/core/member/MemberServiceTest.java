package hello.core.member;

import hello.core.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {

    MemberServie memberServie;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberServie = appConfig.memberService();
    }


    @Test
    void join(){
        //given
        Member member = new Member(1L,"MemberA", Grade.VIP);
        //when
        memberServie.join(member);
        Member findMember = memberServie.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
