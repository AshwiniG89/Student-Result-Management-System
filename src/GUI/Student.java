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
public class Student extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    public Student() {
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

        jLabel1 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        rollNo_TextField = new javax.swing.JTextField();
        rollNoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Page");
        setMaximumSize(new java.awt.Dimension(550, 400));
        setMinimumSize(new java.awt.Dimension(550, 400));
        setPreferredSize(new java.awt.Dimension(550, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icons_ResultManagement/icons8-schoolboy-at-a-desk-30.png"))); // NOI18N
        jLabel1.setText("   Student");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 230, 60));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icons_ResultManagement/icons8-search-30.png"))); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 110, 40));

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icons_ResultManagement/icons8-close-30.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 110, 40));
        getContentPane().add(rollNo_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 130, 170, -1));

        rollNoLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        rollNoLabel.setText("Roll No.");
        getContentPane().add(rollNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 130, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icons_ResultManagement/schoolPic2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String rollNo = rollNo_TextField.getText();
        try{
            Connection con = ConnectionProviderCode.getcon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs =st.executeQuery("SELECT * FROM result WHERE rollNo ='"+rollNo+"' ");
            
            if(!rs.first()){
                JOptionPane.showMessageDialog(null,"RollNo. doesn't exist");
            }
            else{
                setVisible(false);
                StudentResultPage frame = new StudentResultPage(rollNo);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit","submit",JOptionPane.YES_NO_OPTION);
        
        if(response == 0){
            setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JTextField rollNo_TextField;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
