package struct;

import java.util.ArrayList;

public class Question {
    private int id;
    private String text;
    private int idOwnTest;
    private ArrayList<Answer> Answers = new ArrayList<>();

    public Question(int id, String text, int idOwnTest){
        this.id = id;
        this.text = text;
        this.idOwnTest = idOwnTest;
    }

    public void setAnswer(String text, int isTrue, int addPointsIfChoose, int addPointsIfUnChoose){
        Answers.add(new Answer(text, isTrue, addPointsIfChoose, addPointsIfUnChoose));
    }

    public String[] getAnswers(){
        String[] res = new String[Answers.size()];
        for(int i = 0; i < Answers.size();i++){
            res[i] = Answers.get(i).getText();
        }
        return res;
    }

    public int checkAnswer(int idAnswer){
        return Answers.get(idAnswer).getAddPointsIfChoose();
    }

    public String getText() {
        return text;
    }
}
