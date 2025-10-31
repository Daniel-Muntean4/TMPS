package domain.models;

import domain.Task;

public class TaskBuilder {
    String title;
    String content;
    String date;
    boolean finished;

    public TaskBuilder() {
    }
    
    public TaskBuilder setTitle(String title){
        this.title = title;
        return this;
    }
    public TaskBuilder setContent(String content){
        this.content = content;
        return this;
    }
    public TaskBuilder setDate(String date){
        this.date = date;
        return this;
    }
    public TaskBuilder setFinished(){
        this.finished = true;
        return this;
    }
    
    public Task build(){
        return new Task(title,content,date,finished);
    }

}
