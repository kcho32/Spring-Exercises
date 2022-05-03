package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    // 할당하는 MemberServiceImpl은 구현체인데 사용하기 때문에 결국 DIP를 지키지 못함 -> 구현체 의존해버림
    // -> 변경이 있을 때 문제가 발생할 가능성이 큼
    // 이 문제는 추후 해결

    @Test
    void join() {
        //given -> 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when ->
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        // assertj에서 불러오기
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
