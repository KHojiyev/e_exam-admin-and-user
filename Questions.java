package Module2_OOP.ExtraTasks.Lesson11;

public class Questions {
    private String text;
    private Answer answers;


    public Questions(String text, Answer answers) {
        this.text = text;
        this.answers = answers;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer getAnswers() {
        return answers;
    }

    public void setAnswers(Answer answers) {
        this.answers = answers;
    }

}
