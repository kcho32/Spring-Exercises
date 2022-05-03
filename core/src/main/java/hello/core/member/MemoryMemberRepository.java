package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// db확정이 안되었기 때문에 메모리를 사용 -> 휘발성
public class MemoryMemberRepository implements MemberRepository {

    // 그냥 HashMap보단 Conquerer Hashmap 사용 추천
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
