package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImp implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MeberRepository.class) //@Component가 붙어있으면 컴포넌트 스캔이
    //자동으로 빈으로 등록해주지만 의존관계까지 자동으로 설정해주지 않기 때문에 @Autowired를 사용하여 설정
    public MemberServiceImp(MemberRepository memberRepository) {
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

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
