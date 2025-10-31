package domain.factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import domain.models.TaskBuilder;


public class NumericDateTaskFactory extends TaskBuilderFactory{

    @Override
    public TaskBuilder createTask() {
        TaskBuilder taskBuilder = new TaskBuilder();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);
        taskBuilder.setDate(formattedDate);
        return taskBuilder;
    }
    
}
