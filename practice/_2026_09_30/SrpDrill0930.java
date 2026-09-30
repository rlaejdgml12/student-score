package _2026_09_30;

public class SrpDrill0930 {

    // ===== 셋업 (연습 대상이 아닙니다. 그대로 사용하세요) =====
    record MemberRequest(String email) {}

    record Member(String email) {
        static Member register(String email) {
            return new Member(email);
        }
    }

    interface MemberRepository     { void save(Member member); }
    interface WelcomeMessageSender { void send(Member member); }
    interface AuditLogger          { void logRegistration(Member member); }

    class MemberRegistrationService{
        private final MemberRepository repository;
        private final WelcomeMessageSender sender;
        private final AuditLogger logger;

        MemberRegistrationService(MemberRepository repository, WelcomeMessageSender sender, AuditLogger logger){
            this.repository = repository;
            this.sender = sender;
            this.logger = logger;
        }

        void register(MemberRequest request){
            Member member = Member.register(request.email());
            repository.save(member);
            sender.send(member);
            logger.logRegistration(member);
        }

    }


    public static void main(String[] args) {

    }
}
