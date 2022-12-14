/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import ConnectionProvider.ConnectionProviderCode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author harish
 */
public class UpdateStudentResult extends javax.swing.JFrame {

    /**
     * Creates new form UpdateStudentResult
     */
    public UpdateStudentResult() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rollNo_label = new javax.swing.JLabel();
        rollNo_textField = new javax.swing.JTextField();
        serchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        englishMarks_textField = new javax.swing.JTextField();
        physicsMarks_textField = new javax.swing.JTextField();
        chemistryMarks_textField = new javax.swing.JTextField();
        mathsMarks_textField = new javax.swing.JTextField();
        computerMarks_textField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(550, 500));
        setMinimumSize(new java.awt.Dimension(550, 500));
        setPreferredSize(new java.awt.Dimension(550, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rollNo_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        rollNo_label.setText("Roll No.");
        getContentPane().add(rollNo_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 41, -1, -1));
        getContentPane().add(rollNo_textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 38, 114, -1));

        serchButton.setText("Search");
        serchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(serchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 38, -1, -1));

        jLabel2.setText("English");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 104, -1, -1));

        jLabel3.setText("Physics");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 151, -1, -1));

        jLabel4.setText("Chemistry");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 197, -1, -1));

        jLabel5.setText("Mathematics");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 245, -1, -1));

        jLabel6.setText("Computer Science");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 304, -1, -1));
        getContentPane().add(englishMarks_textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 162, -1));
        getContentPane().add(physicsMarks_textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 162, -1));
        getContentPane().add(chemistryMarks_textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 162, -1));
        getContentPane().add(mathsMarks_textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 162, -1));
        getContentPane().add(computerMarks_textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 162, -1));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icons_ResultManagement/schoolPic2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchButtonActionPerformed
        // TODO add your handling code here:
        String rollNo = rollNo_textField.getText();
        try{
            Connection con = ConnectionProviderCode.getcon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //ResultSet rs =st.executeQuery("SELECT * FROM result WHERE rollNo ='"+rollNo+"'");
            ResultSet rs =st.executeQuery("SELECT * FROM result WHERE rollNo ='"+rollNo+"'");
            
            if(!rs.first()){
                JOptionPane.showMessageDialog(null,"RollNo. doesn't exist");
            }
            else{
            rollNo_textField.setEditable(false);
            englishMarks_textField.setText(rs.getString(2));
            physicsMarks_textField.setText(rs.getString(3));
            chemistryMarks_textField.setText(rs.getString(4));
            mathsMarks_textField.setText(rs.getString(5));
            computerMarks_textField.setText(rs.getString(6));
           // jTextField7.setText(rs.getString(7));
            // in resultset(rs) data will be stored in array form so indexing in done 1,2,3,..
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }//GEN-LAST:event_serchButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String rollNo = rollNo_textField.getText();
        int english = Integer.parseInt(englishMarks_textField.getText());
        int physics = Integer.parseInt(physicsMarks_textField.getText());
        int chemistry = Integer.parseInt(chemistryMarks_textField.getText());
        int maths =Integer.parseInt( mathsMarks_textField.getText());
        int computer = Integer.parseInt(computerMarks_textField.getText());
        int total=english+physics+chemistry+maths+computer;

        try{
            Connection con = ConnectionProviderCode.getcon();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE result SET english="+english+",physics="+physics+",chemistry="+chemistry+",maths="+maths+",computer="+computer+",total="+total+"WHERE rollNo='"+rollNo+"'");
            JOptionPane.showMessageDialog(null,"Added successfully");
            setVisible(false);
            UpdateStudentResult frame =new UpdateStudentResult();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        // int response = JOptionPane.showConfirmDialog(null,"You sure you want to Exit");
         int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit","submit",JOptionPane.YES_NO_OPTION);
        
        if(response == 0){
            setVisible(false);
    }                             
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStudentResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chemistryMarks_textField;
    private javax.swing.JTextField computerMarks_textField;
    private javax.swing.JTextField englishMarks_textField;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField mathsMarks_textField;
    private javax.swing.JTextField physicsMarks_textField;
    private javax.swing.JLabel rollNo_label;
    private javax.swing.JTextField rollNo_textField;
    private javax.swing.JButton serchButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
