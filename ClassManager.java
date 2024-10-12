import java.util.Scanner;

public class ClassManager  {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();
        CoolTeacher coolTeacher = new CoolTeacher();
        Double l = Math.random()*10;
        String lesson = l + "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is the teacher cool?(true,false): ");
        Boolean CoolTeacher = scanner.nextBoolean();
        if (CoolTeacher) {
            coolTeacher.teach(lesson);
            coolTeacher.tellJoke();
        }
        student.listen();
        System.out.println("Who has a Question? (Student or Teacher or None)");
        String question = scanner.nextLine().toLowerCase();
        if (question=="student") {
            student.askQuestion();
            teacher.replyQuestion();
        }
        else if (question=="teacher") {
            teacher.askQuestion();
            student.replyQuestion();
        }
        else {
            System.out.println("Class has finished");
        }

    }

}
