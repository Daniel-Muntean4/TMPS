package domain.singleton;
public class TaskCounter {
    // eager initialization, we create the object at class creation, not when you need it
    private static final TaskCounter taskCounter = new TaskCounter();
    Integer pendingCount=0;
    Integer completedCount=0;
    private TaskCounter() {
    }
    // for creating object:
    
    public static TaskCounter getInstance(){
               // multithreading option
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

}
