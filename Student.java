public class Student implements IListenLesson, IReplyQuestion, IAskQuestions{

    @Override
    public String askQuestion() {
        return "*Ask question to teacher*";
    }

    @Override
    public void listen() {
        System.out.println("*Listens to the class*");
    }

    @Override
    public String replyQuestion() {
        return "*Reply question to teacher*";
    }
}
