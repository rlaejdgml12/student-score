public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "김동희";
        student1.score = 90;

        Student student2 = new Student();
        student2.name = "홍길동";
        student2.score = 80;

        System.out.println("이름 : " + student1.name + " 점수 : " + student1.score);
        System.out.println("이름 : " + student2.name + " 점수 : " + student2.score);
    }
}
