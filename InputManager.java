import java.util.Scanner;

class InputManager {
    private Scanner scanner;

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public boolean isCoolTeacher() {
        System.out.print("Is the teacher cool? (true/false): ");
        return scanner.nextBoolean();
    }

    public String getQuestion() {
        System.out.println("Who has a question? (Student or Teacher or None)");
        scanner.nextLine(); // Consume leftover newline
        return scanner.nextLine().toLowerCase();
    }
}

