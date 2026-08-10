package _2026_08_08;

import java.util.HashSet;
import java.util.Objects;

public class Main4 {
    static class NoHashPoint {
        int x, y;

        NoHashPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null || this.getClass() != obj.getClass()) return false;
            NoHashPoint other = (NoHashPoint) obj;
            return other.x == this.x && other.y == this.y;
        }

        // hashCode()는 일부러 오버라이드하지 않음!
    }

    public static void main(String[] args) {
        HashSet<NoHashPoint> set = new HashSet<>();
        set.add(new NoHashPoint(1, 1));
        set.add(new NoHashPoint(1, 1));

        System.out.println(set.size());
    }
}