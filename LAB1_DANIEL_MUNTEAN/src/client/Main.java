package client;
import domain.factory.NumericDateTaskFactory;
import domain.factory.TextualDateTaskFactory;
import domain.models.TaskBuilder;
import domain.singleton.TaskCounter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskBuilder taskBuilder = new TaskBuilder(); // Builder of tasks
        TaskCounter taskCounter = TaskCounter.getInstance();
        Scanner scanner = new Scanner(System.in);
        NumericDateTaskFactory numericDateTaskFactory = new NumericDateTaskFactory();
        TextualDateTaskFactory textualDateTaskFactory = new TextualDateTaskFactory();
        // Singleton that counts how many tasks were completed 
        while (true){
            taskCounter.addPendingTask();
            System.out.println("'numeric' date or 'textual'");

            String dateType = scanner.nextLine().toLowerCase();
        
            if(dateType.equals("numeric")){
                taskBuilder =numericDateTaskFactory.createTask();
            }
            else{
                taskBuilder = (TaskBuilder) textualDateTaskFactory.createTask();
            }
            
            System.out.println("Introduce the title");
            String title = scanner.nextLine();
            taskBuilder.setTitle(title);
            System.out.println("Introduce the content");
            String content = scanner.nextLine();
            taskBuilder.setContent(content);
            System.out.println("Start doing the task, when you finish it write any character and press enter, if u didnt finish just press enter");
            String input = scanner.nextLine();
            if(!input.isBlank()){
            taskBuilder.setFinished(); 
            taskCounter.substractPendingTask();
        }
            Object task = taskBuilder.build();
            System.out.println("");
            System.out.println(task);
            System.out.println("Completed tasks: "+taskCounter.getCompletedCount()+". Uncompleted tasks: "+taskCounter.getPendingCount());
            System.out.println("Continue doing new tasks?(y/n)");
            String newTask = scanner.nextLine();
            if (!newTask.equals("y")){
                break;
            }
        }
    }
}
// tasks 
