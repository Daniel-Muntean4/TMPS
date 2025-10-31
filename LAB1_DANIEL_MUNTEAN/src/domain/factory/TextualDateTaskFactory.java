package domain.factory;

import domain.models.TaskBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextualDateTaskFactory extends TaskBuilderFactory{
    @Override
    public TaskBuilder createTask() {
        TaskBuilder taskBuilder = new TaskBuilder();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd ' of ' MMMM ', ' yyyy" );
        String formattedDate = today.format(formatter);

        taskBuilder.setDate(formattedDate);
        return taskBuilder;
    }
}
