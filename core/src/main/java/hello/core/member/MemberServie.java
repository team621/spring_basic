package hello.core.member;

public interface MemberServie {

    void join(Member member);

    Member findMember(Long memberId);
}
