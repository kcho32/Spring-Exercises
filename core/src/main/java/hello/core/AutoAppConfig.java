package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", //탐색 시작 위치
        //basePackage = "hello.core.member", // member 패키지 내부에서 탐색
        //basePackageClasses = AutoAppConfig.class, // 내 패키지 -> hello.core
        //default는 프로젝트 최상단 -> 현재 최상단은 hello.core -> 최상단에서 AppConfig
        //현재 CoreApplication이 있는 곳이 최상단 -> ComponentScan이 존재
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //@Component 빈을 찾아 등록을 해준다
        //AppConfig는 제외한다 -> @Configuration도 컴포넌트이기 때문
        // 예제 코드를 남기기 살리기 위해 작성
)
public class AutoAppConfig {
//    수동으로 빈을 등록하면 오버라이딩 함 -> 수동으로 하면 오류가 났을 때 해결하기 힘듬 -> 이제 오버라이딩하면 스프링부트에서 에러처리함
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository basicScan() {
//        return new MemoryMemberRepository();
//    }
}
