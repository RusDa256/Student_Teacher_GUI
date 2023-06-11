package frame;

import server.IAutomaticTest;

public class ChooseRoleFrame extends javax.swing.JFrame {
    private static IAutomaticTest proxy;
    
    public ChooseRoleFrame(IAutomaticTest proxy) {
        this.proxy = proxy;
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chooseRoleLabel = new javax.swing.JLabel();
        bStudent = new javax.swing.JButton();
        bTeacher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseRoleLabel.setText("Выберите роль:");
        chooseRoleLabel.setAutoscrolls(true);

        bStudent.setText("СТУДЕНТ");
        bStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStudentActionPerformed(evt);
            }
        });

        bTeacher.setText("ПРЕПОДАВАТЕЛЬ");
        bTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeacherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bTeacher)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(chooseRoleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(chooseRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bStudent)
                    .addComponent(bTeacher))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void bStudentActionPerformed(java.awt.event.ActionEvent evt) {
        StudentFrame student = new StudentFrame(proxy);
        dispose();
    }

    private void bTeacherActionPerformed(java.awt.event.ActionEvent evt) {
        TeacherFrame teacher = new TeacherFrame(proxy);
        dispose();
    }

    private javax.swing.JButton bStudent;
    private javax.swing.JButton bTeacher;
    private javax.swing.JLabel chooseRoleLabel;
    private javax.swing.JPanel jPanel1;
}
