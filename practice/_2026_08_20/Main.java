package _2026_08_20;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main{

    // ────────── ① 정상: equals·hashCode 둘 다 email 기준 ──────────
    static class GoodMember {
        private final String email;                       // final — 저장 후 변경 불가

        GoodMember(String email) { this.email = email; }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;               // 같은 객체면 즉시 true
            if (!(other instanceof GoodMember t)) return false;  // 타입 검사 + null 방어
            return Objects.equals(email, t.email);        // 필드끼리 비교
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(email);               // equals에 쓴 필드와 동일하게
        }
    }

    // ────────── ② 깨진 것: equals는 맞는데 hashCode가 어긋남 ──────────
    static class BrokenMember {
        private final String email;

        BrokenMember(String email) { this.email = email; }

        @Override
        public boolean equals(Object other) {             // equals는 ①과 완전히 동일
            if (this == other) return true;
            if (!(other instanceof BrokenMember t)) return false;
            return Objects.equals(email, t.email);
        }

        @Override
        public int hashCode() {
            return super.hashCode();                      // ⚠️ Object 기본 = 객체마다 다른 값
        }
    }

    // ────────── ③ 저장 후 필드를 바꾸는 경우 ──────────
    static class MutableMember {
        private String email;                             // ⚠️ final이 아님

        MutableMember(String email) { this.email = email; }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof MutableMember t)) return false;
            return Objects.equals(email, t.email);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(email);
        }
    }

    public static void main(String[] args) {

        // ① 계약을 지킨 경우
        Set<GoodMember> good = new HashSet<>();
        good.add(new GoodMember("a@test.com"));
        good.add(new GoodMember("a@test.com"));            // 같은 값을 한 번 더
        System.out.println("① Good   size = " + good.size());     // 기대: 1

        // ② hashCode 계약을 깬 경우
        Set<BrokenMember> broken = new HashSet<>();
        broken.add(new BrokenMember("a@test.com"));
        broken.add(new BrokenMember("a@test.com"));        // 같은 값인데도...
        System.out.println("② Broken size = " + broken.size());   // 기대: 2 ← 중복 제거 실패

        // ③ 저장 후 필드를 바꾼 경우
        Set<MutableMember> mutable = new HashSet<>();
        MutableMember m = new MutableMember("a@test.com");
        mutable.add(m);                                    // a@test.com 기준 버킷에 저장
        m.email = "b@test.com";                            // 저장한 뒤에 값 변경!

        System.out.println("③ contains(m) = " + mutable.contains(m));  // 기대: false
        System.out.println("③ size        = " + mutable.size());       // 기대: 1
        System.out.println("③ remove(m)   = " + mutable.remove(m));    // 기대: false ← 지울 수도 없음
    }
}
