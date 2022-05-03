package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //자동 선택시에 alt enter하면 ;까지 작성됨 편함 ㅋㅋ
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
