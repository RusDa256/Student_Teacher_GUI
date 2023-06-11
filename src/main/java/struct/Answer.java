package struct;

public class Answer {
    private String text;
    private int isTrue;
    private int addPointsIfChoose;
    private int addPointsIfUnChoose;

    public Answer(String text, int isTrue, int addPointsIfChoose, int addPointsIfUnChoose) {
        this.text = text;
        this.isTrue = isTrue;
        this.addPointsIfChoose = addPointsIfChoose;
        this.addPointsIfUnChoose = addPointsIfUnChoose;
    }

    public String getText() {
        return text;
    }

    public int getAddPointsIfChoose() {
        return addPointsIfChoose;
    }
}
