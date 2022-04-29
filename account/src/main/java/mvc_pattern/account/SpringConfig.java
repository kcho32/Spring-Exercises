package mvc_pattern.account;

import mvc_pattern.account.repository.JdbcMemberRepository;
import mvc_pattern.account.repository.MemberRepository;
import mvc_pattern.account.repository.MemoryMemberRepository;
import mvc_pattern.account.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
/**
 * 수동적으로 빈을 컨테이너에 올려주는 방법
 * memberService를 올린다고 하고 필요한 매개변수 또한 같이 설정해준다
 */