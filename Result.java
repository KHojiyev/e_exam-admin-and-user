package Module2_OOP.ExtraTasks.Lesson11;

public class Result {
    private User user;
    private String subject;
    private double score;
    private int sumOfQuestiions;

    public Result(User user, String subject, double score, int sumOfQuestiions) {
        this.user = user;
        this.subject = subject;
        this.score = score;
        this.sumOfQuestiions = sumOfQuestiions;
    }

    public int getSumOfQuestiions() {
        return sumOfQuestiions;
    }

    public void setSumOfQuestiions(int sumOfQuestiions) {
        this.sumOfQuestiions = sumOfQuestiions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
