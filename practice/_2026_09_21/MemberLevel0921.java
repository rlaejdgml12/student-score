package _2026_09_21;

class Member {
    private int level;
    private static final int MAX_LEVEL = 10;

    int getLevel(){
        return this.level;
    }

    void levelUp(){
        if(getLevel() >= MAX_LEVEL) {
            throw new IllegalStateException("최대 레벨입니다.");
        }
        this.level++;
    }
}

public class MemberLevel0921 {

    public static void main(String[] args) {
        Member member = new Member();
        for(int i = 0; i < 11; i++){
            member.levelUp();
        }
    }
}
