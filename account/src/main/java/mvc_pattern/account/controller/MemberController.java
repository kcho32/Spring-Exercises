package mvc_pattern.account.controller;

import mvc_pattern.account.domain.Member;
import mvc_pattern.account.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

//    private final MemberService memberService = new MemberService(); -> 이런 식으로 하면 객체가 너무 많이 생기게 됨
    private final MemberService memberService;

    @Autowired //container에서 memberService 가져오기 생성자를 통해서 들어오는 방법 -> 추천
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

//    @Autowired //setter 주입
//    public setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    } -> 다른 사람이 불러올 수 있기 때문에 조심심

//   @Autowired private MemberService memberService; //필드멤버 주입도 가능하지만 비추
}

/**
 * Controller는 어쩔 수 없이 애노테이션 사용해야됨
 */