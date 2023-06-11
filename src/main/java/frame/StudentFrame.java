package frame;

import server.IAutomaticTest;
import java.util.HashMap;
import java.util.Map;

public class StudentFrame extends javax.swing.JFrame {
    private static IAutomaticTest proxy;
    private String[] allTests;
    private int curSumPoints;
    private int idOfTest;
    private int countQuestion;
    private int curNumberOfQuestion = 1;
    private static Map<Integer, Integer> resPointsTest = new HashMap<>(); // 1st - id теста, 2nd - кол-во баллов
    
    public StudentFrame(IAutomaticTest proxy) {
        this.proxy = proxy;
        initComponents();
        setSize(470, 300);
        setVisible(true);
        setTitle("Студент");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ShowTests = new javax.swing.JButton();
        showResult = new javax.swing.JButton();
        startTest = new javax.swing.JButton();
        chooseTestForStart = new javax.swing.JComboBox<>();
        labelChooseTest = new javax.swing.JLabel();
        testOK = new javax.swing.JButton();
        comboBoxAnswers = new javax.swing.JComboBox<>();
        labelChooseAnswer = new javax.swing.JLabel();
        bChooseAnswer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_ShowTests = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("МЕНЮ"));

        ShowTests.setText("Тесты");
        ShowTests.setActionCommand("showTests");
        ShowTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowTestsActionPerformed(evt);
            }
        });

        showResult.setText("Мои результаты");
        showResult.setActionCommand("showResalts");
        showResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showResultActionPerformed(evt);
            }
        });

        startTest.setText("Начать тест");
        startTest.setActionCommand("startTest");
        startTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ShowTests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ShowTests, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(startTest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showResult, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chooseTestForStart.setFont(new java.awt.Font("Segoe UI", 1, 11));
        chooseTestForStart.setVisible(false);

        labelChooseTest.setText("Выберите тест");
        labelChooseTest.setVisible(false);

        testOK.setText("ОК");
        testOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testOKActionPerformed(evt);
            }
        });
        testOK.setVisible(false);

        comboBoxAnswers.setVisible(false);

        labelChooseAnswer.setText("Ваш ответ");
        labelChooseAnswer.setVisible(false);

        bChooseAnswer.setText("OK");
        bChooseAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChooseAnswerActionPerformed(evt);
            }
        });
        bChooseAnswer.setVisible(false);

        tf_ShowTests.setColumns(18);
        tf_ShowTests.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        tf_ShowTests.setRows(14);
        tf_ShowTests.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tf_ShowTests);
        tf_ShowTests.getAccessibleContext().setAccessibleParent(null);
        //tf_ShowTests.setEnabled(false); // изменяет цвет текста  (?)

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 9, Short.MAX_VALUE)
                                .addComponent(labelChooseAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bChooseAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelChooseTest)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseTestForStart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(testOK, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelChooseAnswer)
                                .addGap(12, 12, 12)
                                .addComponent(comboBoxAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bChooseAnswer)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chooseTestForStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelChooseTest)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void ShowTestsActionPerformed(java.awt.event.ActionEvent evt) {
        setAllTests();
        chooseTestForStart.setVisible(false);
        labelChooseTest.setVisible(false);
        testOK.setVisible(false);
    }

    private void showResultActionPerformed(java.awt.event.ActionEvent evt) {
        tf_ShowTests.setText("Результаты всех тестов:");

        for(int i = 0; i < resPointsTest.size(); i++){
            int tmp_idTest = (int) resPointsTest.keySet().toArray()[i];
            tf_ShowTests.setText(tf_ShowTests.getText() + "\n" + "[" + tmp_idTest + "]" + " = "
                    + resPointsTest.get(tmp_idTest) + " балла(ов)");
        }
    }

    private void startTestActionPerformed(java.awt.event.ActionEvent evt) {
        allTests = proxy.getAllTests();
        chooseTestForStart.removeAllItems();
        for(String test : allTests){
            chooseTestForStart.addItem(test);
        }
        testOK.setVisible(true);
        labelChooseTest.setVisible(true);
        chooseTestForStart.setVisible(true);
    }

    private void testOKActionPerformed(java.awt.event.ActionEvent evt) {
        testOK.setVisible(false);
        labelChooseTest.setVisible(false);
        chooseTestForStart.setVisible(false);

        idOfTest = chooseTestForStart.getSelectedItem().toString().charAt(1) - '0';

        String[] qAndAnsw = proxy.startTest(idOfTest);
        writeQuestionAndAnswers(qAndAnsw);
        
        comboBoxAnswers.removeAllItems();
        for(int i = 1; i < qAndAnsw.length; i++){
            comboBoxAnswers.addItem(String.valueOf(i));
        }
        curSumPoints = 0;

        bChooseAnswer.setVisible(true);
        comboBoxAnswers.setVisible(true);
        labelChooseAnswer.setVisible(true);
    }

    private void bChooseAnswerActionPerformed(java.awt.event.ActionEvent evt) {
        int answer = Integer.parseInt(comboBoxAnswers.getSelectedItem().toString());
        curSumPoints += proxy.checkAnswer(idOfTest, curNumberOfQuestion - 1,answer - 1);
        countQuestion = proxy.getCountQuestionByIdTest(idOfTest);

        if(curNumberOfQuestion == countQuestion){
            curNumberOfQuestion = 1;
            resPointsTest.put(idOfTest, curSumPoints);

            bChooseAnswer.setVisible(false);
            comboBoxAnswers.setVisible(false);
            labelChooseAnswer.setVisible(false);

            tf_ShowTests.setText("Результат теста " + "\n" + "[" + curSumPoints + "]" + " балла(ов)");
            return;
        }
        curNumberOfQuestion++;
        
        String[] qAndAnsw = proxy.getNextQuestion(idOfTest);
        writeQuestionAndAnswers(qAndAnsw);
        
        comboBoxAnswers.removeAllItems();
        for(int i = 1; i < qAndAnsw.length; i++){
            comboBoxAnswers.addItem(String.valueOf(i));
        }
    }

    private void writeQuestionAndAnswers(String[] qAndAnsw) { // выводит в консоль вопрос и варианты ответа
        tf_ShowTests.setText("");
        for(int i = 0; i < qAndAnsw.length; i++){
            if( i != 0){
                tf_ShowTests.setText(tf_ShowTests.getText() + "\n" + i + ") " + qAndAnsw[i]);
            } else {
                tf_ShowTests.setText(qAndAnsw[i]);
            }
        }
    }

    private void setAllTests(){
        allTests = proxy.getAllTests();
        String res = "Все тесты:";
        for(String test : allTests){
            res += "\n" + test;
        }
        tf_ShowTests.setText(res);
    }

    private javax.swing.JButton ShowTests;
    private javax.swing.JButton bChooseAnswer;
    private javax.swing.JComboBox<String> chooseTestForStart;
    private javax.swing.JComboBox<String> comboBoxAnswers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelChooseAnswer;
    private javax.swing.JLabel labelChooseTest;
    private javax.swing.JButton showResult;
    private javax.swing.JButton startTest;
    private javax.swing.JButton testOK;
    private javax.swing.JTextArea tf_ShowTests;
}
