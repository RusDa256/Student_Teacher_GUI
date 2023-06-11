package server;

import struct.Test;
import javax.jws.WebService;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebService
public class AutomaticTest implements IAutomaticTest {
    private static int IdOfTest = 0;
    private int curQuestion;
    private static ArrayList<Test> Tests = new ArrayList<>();


    public AutomaticTest() {
        setDefaultTest();
    }

    @Override
    public int createTest(String name) {
        Tests.add(new Test(IdOfTest, name));
        return IdOfTest++;
    }

    @Override
    public int addQuestion(String nameQuestion, int idTest) {
        for(int i = 0; i < IdOfTest; i++) {
            if(Tests.get(i).getId() == idTest){
                return Tests.get(i).addNewQuestion(nameQuestion);
            }
        }
        return 0;
    }

    @Override
    public void addAnswer(int idTest, int idQuestion, String text, int isTrue,
                           int addPointsIfChoose, int addPointsIfUnChoose) {
        for(int i = 0; i < IdOfTest; i++) {
            if(Tests.get(i).getId() == idTest){
                Tests.get(i).getQuestionById(idQuestion).setAnswer(text, isTrue, addPointsIfChoose, addPointsIfUnChoose);
            }
        }
    }

    @Override
    public String[] getAllTests() {
        String[] res = new String[IdOfTest];
        for(int i = 0; i < IdOfTest; i++){
            res[i] = "[" + Tests.get(i).getId() + "] " + Tests.get(i).getName();
        }
        return res;
    }

    @Override
    public String[] startTest(int idTest) {
        String[] res = new String[0];
        curQuestion = 0;
        for(int i = 0; i < IdOfTest; i++) {
            if(Tests.get(i).getId() == idTest){
                res = new String[1];
                res[0] = Tests.get(i).getQuestionById(curQuestion).getText();

                String[] ans = Tests.get(i).getQuestionById(curQuestion).getAnswers();
                List<String> resultList = new ArrayList<>(res.length + ans.length);
                Collections.addAll(resultList, res);
                Collections.addAll(resultList, ans);
                String[] resultArray = (String[]) Array.newInstance(res.getClass().getComponentType(), 0);
                curQuestion++;
                return resultList.toArray(resultArray);
            }
        }
        return res;
    }

    @Override
    public String[] getNextQuestion(int idTest) {
        String[] res = new String[0];
        for(int i = 0; i < IdOfTest; i++) {
            if(Tests.get(i).getId() == idTest){
                res = new String[1];
                res[0] = Tests.get(i).getQuestionById(curQuestion).getText();

                String[] ans = Tests.get(i).getQuestionById(curQuestion).getAnswers();
                List<String> resultList = new ArrayList<>(res.length + ans.length);
                Collections.addAll(resultList, res);
                Collections.addAll(resultList, ans);
                String[] resultArray = (String[]) Array.newInstance(res.getClass().getComponentType(), 0);
                curQuestion++;
                return resultList.toArray(resultArray);
            }
        }
        return res;
    }

    @Override
    public int checkAnswer(int idTest, int idQuestion, int idAnswer) {
        for(int i = 0; i < IdOfTest; i++) {
            if(Tests.get(i).getId() == idTest){
                return Tests.get(i).getQuestionById(idQuestion).checkAnswer(idAnswer);
            }
        }
        return 0;
    }

    @Override
    public int getCountQuestionByIdTest(int idTest) {
        for(int i = 0; i < IdOfTest; i++) {
            if(Tests.get(i).getId() == idTest){
                return Tests.get(i).getCountQuestion();
            }
        }
        return 0;
    }

    private void setDefaultTest() {
        Tests.add(new Test(IdOfTest++, "Back to School"));
        Tests.get(IdOfTest - 1).addNewQuestion("5 + 7 = ?");
        Tests.get(IdOfTest - 1).addNewQuestion("Формула силы тяжести:");
        Tests.get(IdOfTest - 1).addNewQuestion("Столица Бразилии?");
        Tests.get(IdOfTest - 1).addNewQuestion("Что такое cucumber?");

        addAnswer(IdOfTest - 1, 0, "0", 0, -1, 0);
        addAnswer(IdOfTest - 1, 0, "22", 0, -1, 0);
        addAnswer(IdOfTest - 1, 0, "12", 1, 3, 0);
        addAnswer(IdOfTest - 1, 0, "112", 0, -1, 0);

        addAnswer(IdOfTest - 1, 1, "m + m", 0, 0, 0);
        addAnswer(IdOfTest - 1, 1, "m*g", 1, 3, 0);
        addAnswer(IdOfTest - 1, 1, "m*m*m", 0, 0, 0);

        addAnswer(IdOfTest - 1, 2, "Кстово", 0, 0, 0);
        addAnswer(IdOfTest - 1, 2, "Бразилия", 0, -1, 0);
        addAnswer(IdOfTest - 1, 2, "Бразилиа", 1, 5, 0);

        addAnswer(IdOfTest - 1, 3, "тыква", 0, 0, 0);
        addAnswer(IdOfTest - 1, 3, "кукумбер", 1, 1, 0);
        addAnswer(IdOfTest - 1, 3, "черепаха", 0, -1, 0);
        addAnswer(IdOfTest - 1, 3, "огурец", 1, 2, 0);
    }
}
