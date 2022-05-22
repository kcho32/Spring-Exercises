package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //자동 선택시에 alt enter하면 ;까지 작성됨 편함 ㅋㅋ
    private final MemberRepository memberRepository;

    @Autowired // 생성자에 붙임으로 자동으로 의존관계 주입 ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
