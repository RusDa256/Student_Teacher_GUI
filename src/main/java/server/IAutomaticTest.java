package server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IAutomaticTest {

    @WebMethod
    public int createTest(String name);

    @WebMethod
    public int addQuestion(String nameQuestion, int idTest);

    @WebMethod
    public void addAnswer(int idTest, int idQuestion, String text, int isTrue,
                           int addPointsIfChoose, int addPointsIfUnChoose);

    @WebMethod
    public String[] getAllTests();

    @WebMethod
    public String[] startTest(int idTest);

    @WebMethod
    public String[] getNextQuestion(int idTest);

    @WebMethod
    public int checkAnswer(int idTest, int idQuestion, int answer);

    @WebMethod
    public int getCountQuestionByIdTest(int idTest);

}
