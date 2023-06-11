package struct;

import java.util.ArrayList;

public class Test {
    private int id;
    private String name;
    private int countQuestion;
    private ArrayList<Question> Questions = new ArrayList<>();

    public Test(int id, String name){
        this.id = id;
        this.name = name;
        this.countQuestion = 0;
    }

    public int addNewQuestion(String text){
        this.Questions.add(new Question(countQuestion, text, id));
        return countQuestion++;
    }
    public Question getQuestionById(int idQuestion){
        return Questions.get(idQuestion);
    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return  this.name;
    }

    public int getCountQuestion() {
        return countQuestion;
    }
}
