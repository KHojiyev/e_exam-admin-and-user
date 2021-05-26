package Module2_OOP.ExtraTasks.Lesson11;

public class Subject {
    private String name;
    private Questions question;

    public Subject(String name, Questions question) {
        this.name = name;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }
}
