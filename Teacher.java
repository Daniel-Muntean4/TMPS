public class Teacher implements ITeach, IAskQuestions, IReplyQuestion{
    @Override
    public String askQuestion() {
        return "a;";
    }
    @Override
    public String replyQuestion() {
        return "*Replies to students questions*";
    }

    @Override
    public void teach(String lesson) {
        System.out.println("Teaching the lesson nr. " + lesson);

    }
}
