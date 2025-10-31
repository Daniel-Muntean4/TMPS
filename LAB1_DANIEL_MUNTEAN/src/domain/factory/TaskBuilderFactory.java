package domain.factory;

import domain.models.TaskBuilder;

public abstract class TaskBuilderFactory {
    public abstract TaskBuilder createTask();
}
