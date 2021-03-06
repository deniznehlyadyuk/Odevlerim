package stokmalzememodul.Forms;

import stokmalzememodul.Malzeme;
import static javax.swing.JOptionPane.showMessageDialog;

public class MalzemeCikarForm extends FormLayout {

    /**
     * Creates new form MalzemeCikarForm
     */
    public MalzemeCikarForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GeriDonButton = new javax.swing.JButton();
        malzemeIdTextField = new javax.swing.JTextField();
        malzemeIdLabel = new javax.swing.JLabel();
        silButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GeriDonButton.setText("Geri Dön");
        GeriDonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeriDonButtonActionPerformed(evt);
            }
        });

        malzemeIdLabel.setText("Malzeme Id");

        silButton.setText("Sil");
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GeriDonButton)
                        .addGap(18, 18, 18)
                        .addComponent(silButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(malzemeIdLabel)
                        .addGap(18, 18, 18)
                        .addComponent(malzemeIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(malzemeIdLabel)
                    .addComponent(malzemeIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GeriDonButton)
                    .addComponent(silButton))
                .addContainerGap(325, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeriDonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeriDonButtonActionPerformed
        MalzemeForm form = new MalzemeForm();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_GeriDonButtonActionPerformed

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        int malzemeId=0;
        try {
            malzemeId = Integer.parseInt(malzemeIdTextField.getText());
        } catch(Exception e) {
            showMessageDialog(null, "Hatalı id girişi.");
            malzemeIdTextField.setText("");
            return;
        }
        Malzeme malzeme = new Malzeme(malzemeId);
        malzeme.Sil();
        malzemeIdTextField.setText("");
        showMessageDialog(null, "İşlem gerçekleştirildi.");
    }//GEN-LAST:event_silButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MalzemeCikarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MalzemeCikarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MalzemeCikarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MalzemeCikarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MalzemeCikarForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GeriDonButton;
    private javax.swing.JLabel malzemeIdLabel;
    private javax.swing.JTextField malzemeIdTextField;
    private javax.swing.JButton silButton;
    // End of variables declaration//GEN-END:variables
}
