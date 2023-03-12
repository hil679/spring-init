package hello.springinit;
import hello.springinit.repository.MemberRepository;
import hello.springinit.repository.MemoryMemberRepository;
import hello.springinit.service.MemberService;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
