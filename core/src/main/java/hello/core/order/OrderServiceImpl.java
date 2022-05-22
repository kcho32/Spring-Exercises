package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
////    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    // 다만!! 이렇게 할 시, 서비스를 수정해버림 -> 확장에 열렸지만 변경을 하면 안되는 OCP에 위반 -> 구현까지 의존했기 때문(DIP 위반)
//    // 의존관계 때문에 OderServiceImpl까지 수정해야 됨 -> no good

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
    // 인터페이스만 의존 -> NullPoint Exception 나옴 -> 위 값들에는 Null이 들어가 있음 -> 실패!
    // 누군가가 이 서비스 구현체에 값을 넣어주어야한다.

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
