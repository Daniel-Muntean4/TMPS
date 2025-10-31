package domain;


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
