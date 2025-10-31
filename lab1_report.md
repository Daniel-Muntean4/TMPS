# Topic: *Creational Design Patterns*
## Author: *Daniel Muntean* *FAF 232*
------
## Objectives:
__ 1. Study and understand the Creational Design Patterns .__
__ 2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms .__
__ 3. Use some creational design patterns for object instantiation in a sample project .__

## Some Theory:
The creational design patterns are concerned with the creation of objects increasing reuse of code and help adhering to SOLID principles.
__ 1. Singleton:__ restrict object creation to one instance.  
__ 2. Factory Method:__ creates object without specifying the exact class to create.  
__ 3. Abstract Factory:__ groups objects factories with a common theme. Used when: system should be idependent of how his products are created.  
__ 4. Builder:__ constructing complex object by separating construction and representation. Used when: algorithm fo creating complex object should be idependent of the parts that make up the object and how they're assembled and the construction process must allow different representation of the objects that are constructed.
__ 5. Prototype:__ creates clones by copying an existing object.
__ 6. Object pool:__ used when when cost of inititialization a class instance is high, rate of instanciation is high and the number of instanciations at a time is low.


## Creational Design Patterns implemented
Singleton, Factory Method and Builder

## Main tasks:
__1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

__2. Select a domain area for the sample project.__

__3. Define the main involved classes and think about what instantiation mechanisms are needed.__

__4. Based on the previous point, implement atleast 3 creational design patterns in your project.__

## Snippets
```
public class Task {
    private final String title;
    private final String content;
    private final String date;
    private final boolean finished;
     public Task(String title, String content, String date, boolean finished) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.finished= finished;
    }
    @Override
    public String toString(){
        return title +"\t"+date+"\tfinished:"+finished+"\n"+content;
    }
}
```
This is our class that is in model package, our program is based on tasks and their management and this is what tasks contain: title, content, date and if the task is finished.
```
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
```
Starting with the **Builder pattern**, we have made the object creation depending not on long constructors, but in set methods that can be added in any possible combination,
reducing the number of constructors and simplifying the creation. FInally when the object is ready we will build it, using the Task class constructor.
```
public abstract class TaskBuilderFactory {
    public abstract TaskBuilder createTask();
}
```
Above we have the **Factory Method** for building tasks, returning a Taskbuilder, because this factory only advances one step in the building of the object, 
but there are more than one implementation of this method. 
```
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
```
Above we have the implementation of TaskBuilderFactory, the date is set in a different way having the same input, there is also a TextualDateTaskFactory, but more could be added, making it Open for extension and closed for modification.
```
public class TaskCounter {
    private static final TaskCounter taskCounter = new TaskCounter();
    Integer pendingCount=0;
    Integer completedCount=0;
    private TaskCounter() {
    }
    public static TaskCounter getInstance(){
               return taskCounter;
    }
    public void addPendingTask(){
        pendingCount+=1;
    }
    public void substractPendingTask(){
        if(pendingCount>=1){
            pendingCount-=1;
            completedCount+=1;
        }
    }
    public Integer getPendingCount(){
        return this.pendingCount;
    }
    public Integer getCompletedCount(){
        return this.completedCount;
    }
```
Lastly our project has the **Singleton**, with eager initialization, we create the object at class creation, not when we need it, 
because we will always use the counter in our program, and we have only one instance, because we will never have more than one user. The getinstance() method is static because it can have only one instance, and is not initialized with new. We can't create two different objects because of this. Also there is a pending and completed counts that counts the task completion or incompletion.

## Implementation
This program allows a user to create tasks and to describe them, the tasks are set with the current user date, allowing to have different formats using Factory Method, also the user can see how many tasks he completed in total. 
It can be extended with more implemented date formats, and storing the data as in a database in a text file, in order to save the tasks over time, and being able to see reports of the history of comlpletion over time. 
That is a challenge that can be done with structural design patterns from the next laboratory.

