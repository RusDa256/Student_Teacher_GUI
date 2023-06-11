package frame;

import server.IAutomaticTest;

public class TeacherFrame extends javax.swing.JFrame {
    private static IAutomaticTest proxy;
    private int idOfTest;
    private String[] allTests;
    private boolean creatingTest = false;
    private boolean addingQuetion = false;
    private int idQuestion;
    private boolean isClickAddQuestion = false;

    public TeacherFrame(IAutomaticTest proxy) {
        this.proxy = proxy;
        initComponents();
        setSize(450, 250);
        setVisible(true);
        setTitle("Преподаватель");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bAllTests = new javax.swing.JButton();
        bCreateTest = new javax.swing.JButton();
        bAddQuestoin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        textField = new javax.swing.JTextField();
        bOkTf = new javax.swing.JButton();
        bRight = new javax.swing.JButton();
        bWrong = new javax.swing.JButton();

        bCreateTest.setText("Создать тест");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("МЕНЮ"));

        bAllTests.setText("Все тесты");
        bAllTests.setPreferredSize(new java.awt.Dimension(83, 25));
        bAllTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAllTestsActionPerformed(evt);
            }
        });

        bCreateTest.setText("Создать тест");
        bCreateTest.setPreferredSize(new java.awt.Dimension(98, 25));
        bCreateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateTestActionPerformed(evt);
            }
        });

        bAddQuestoin.setText("Добавить вопрос");
        bAddQuestoin.setPreferredSize(new java.awt.Dimension(125, 25));
        bAddQuestoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddQuestoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCreateTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAllTests, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAddQuestoin, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bCreateTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAddQuestoin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAllTests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textArea.setColumns(16);
        textArea.setFont(new java.awt.Font("Segoe UI", 1, 12));
        textArea.setRows(11);
        jScrollPane1.setViewportView(textArea);

        textField.setFont(new java.awt.Font("Segoe UI", 1, 12));
        textField.setVisible(false);

        bOkTf.setText("OK");
        bOkTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkTfActionPerformed(evt);
            }
        });
        bOkTf.setVisible(false);

        bRight.setBackground(new java.awt.Color(255, 102, 102));
        bRight.setText("-");
        bRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWrongActionPerformed(evt);
            }
        });
        bRight.setVisible(false);

        bWrong.setBackground(new java.awt.Color(0, 204, 0));
        bWrong.setText("+");
        bWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRightActionPerformed(evt);
            }
        });
        bWrong.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bWrong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRight, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bOkTf, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bOkTf)
                            .addComponent(bRight)
                            .addComponent(bWrong))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void bCreateTestActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.setText("Введите название теста" + "\n\n\n\n\n\n" + "-------------------->>>");
        textField.setVisible(true);
        bOkTf.setVisible(true);
        creatingTest = true;
        bRight.setVisible(false);
        bWrong.setVisible(false);
    }

    private void bAddQuestoinActionPerformed(java.awt.event.ActionEvent evt) {
        setAllTests();
        textArea.setText(textArea.getText() + "\n\nВведите цифру нужного теста");
        textField.setVisible(true);
        bOkTf.setVisible(true);
        bRight.setVisible(false);
        bWrong.setVisible(false);
        addingQuetion = true;
        isClickAddQuestion = true;
    }

    private void bAllTestsActionPerformed(java.awt.event.ActionEvent evt) {
        setAllTests();
        textField.setVisible(false);
        bRight.setVisible(false);
        bWrong.setVisible(false);
    }

    private void bOkTfActionPerformed(java.awt.event.ActionEvent evt) {
        if(creatingTest) {
            idOfTest = proxy.createTest(textField.getText());
            textArea.setText("Тест успешно создан!" + "\n\n" + "[" + idOfTest
                    + "] " + textField.getText() + "\n\n" + "<OK> - добавить вопрос");
            textField.setText("");
            creatingTest = false;
            addingQuetion = true;
        } else if(addingQuetion){
            textArea.setText("Введите вопрос");
            if(!textField.getText().equals("") && !isClickAddQuestion){
                idQuestion = proxy.addQuestion(textField.getText(), idOfTest);
                textArea.setText("Вопрос успешно добавлен!" + "\n\n" + "[" + idQuestion
                + "] " + textField.getText() + "\n\n" + "Введите вариант ОТВЕТА" + "\n\n"
                        + "--------->>>" + "\n\n" + "[+] - правильный" + "\n" + "[-] - неправильный ");
                textField.setText("");
                addingQuetion = false;
                bRight.setVisible(true);
                bWrong.setVisible(true);
                bOkTf.setVisible(false);
            }else if(isClickAddQuestion){
                idOfTest = Integer.parseInt(textField.getText());
                textField.setText("");
                isClickAddQuestion = false;
            }
        }
    }

    private void bRightActionPerformed(java.awt.event.ActionEvent evt) {
        proxy.addAnswer(idOfTest, idQuestion, textField.getText(), 1, 3, 0);
        textArea.setText("Ответ успешно добавлен!" + "\n\n" + textField.getText()
                + "\n[ВЕРНО] +3 балла\n\nДобавьте новый вопрос");
        textField.setText("");
    }

    private void bWrongActionPerformed(java.awt.event.ActionEvent evt) {
        proxy.addAnswer(idOfTest, idQuestion, textField.getText(), 0, -1, 0);
        textArea.setText("Ответ успешно добавлен!" + "\n\n" + textField.getText()
                + "\n[НЕВЕРНО] -1 балл\n\n\n\nДобавьте новый ответ");
        textField.setText("");
    }

    private void setAllTests(){
        allTests = proxy.getAllTests();
        String res = "Все тесты:";
        for(String test : allTests){
            res += "\n" + test;
        }
        textArea.setText(res);
    }


    private javax.swing.JButton bAddQuestoin;
    private javax.swing.JButton bAllTests;
    private javax.swing.JButton bCreateTest;
    private javax.swing.JButton bOkTf;
    private javax.swing.JButton bRight;
    private javax.swing.JButton bWrong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField textField;
}
