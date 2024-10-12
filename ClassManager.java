public class ClassManager {
    private InputManager inputManager;
    private Teacher teacher;
    private Student student;

    public ClassManager(InputManager inputManager, Teacher teacher, Student student) {
        this.inputManager = inputManager;
        this.teacher = teacher;
        this.student = student;
    }

    public void startClass() {
        double lessonContent =  (Math.random() * 10);
        String lesson = lessonContent.toString();

        boolean isCool = inputManager.isCoolTeacher();
        if (isCool && teacher instanceof CoolTeacher) {
            CoolTeacher coolTeacher = (CoolTeacher) teacher;
            coolTeacher.teach(lesson);
            coolTeacher.tellJoke();
        } else {
            teacher.teach(lesson);
        }

        student.listen();
        String question = inputManager.getQuestion();

        if (question.equals("student")) {
            student.askQuestion();
            teacher.replyQuestion();
        } else if (question.equals("teacher")) {
            teacher.askQuestion();
            student.replyQuestion();
        } else {
            System.out.println("Class has finished.");
        }
    }
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        Teacher coolTeacher = new CoolTeacher(); // Can be replaced with different teacher types
        Student student = new Student();
        ClassManager classManager = new ClassManager(inputManager, coolTeacher, student);
        classManager.startClass();
    }
}