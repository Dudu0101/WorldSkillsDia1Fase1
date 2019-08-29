/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;

/**
 *
 * @author javam2019
 */
public class JfrmAddUsuario extends javax.swing.JFrame {

    /**
     * Creates new form JfrmAddUsuario
     */
    public JfrmAddUsuario() {
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

        jBtnGrpEstado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtNameAdd = new javax.swing.JTextField();
        jTxtApellidAdd = new javax.swing.JTextField();
        jTxtTelAdd = new javax.swing.JTextField();
        jTxtDireccionAdd = new javax.swing.JTextField();
        jTxtCorreoAdd = new javax.swing.JTextField();
        jTxtContrasenia = new javax.swing.JTextField();
        jFtxtFechaAdd = new javax.swing.JFormattedTextField();
        jBtnGuardarAdd = new javax.swing.JButton();
        jBtnCancelarAdd = new javax.swing.JButton();
        jLblNombreError = new javax.swing.JLabel();
        jLblApellidoError = new javax.swing.JLabel();
        jLblTelError = new javax.swing.JLabel();
        jLblDireccionError = new javax.swing.JLabel();
        jLblFechaError = new javax.swing.JLabel();
        jRbtnActivoAdd = new javax.swing.JRadioButton();
        jRbtnInactivoAdd = new javax.swing.JRadioButton();
        jLblErrorEstado = new javax.swing.JLabel();
        jLblErrorContra = new javax.swing.JLabel();
        jLblCorreoError = new javax.swing.JLabel();
        jLblCorreoError1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 30)); // NOI18N
        jLabel1.setText("Agregar Usuario");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Nombre(s):");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Apellido(s):");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setText("Télefono:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setText("Dirección:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("Correo:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Fecha Nacimiento:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("Contraseña: ");

        jTxtNameAdd.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jTxtApellidAdd.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTxtApellidAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtApellidAddActionPerformed(evt);
            }
        });

        jTxtTelAdd.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jTxtDireccionAdd.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTxtDireccionAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDireccionAddActionPerformed(evt);
            }
        });

        jTxtCorreoAdd.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jTxtContrasenia.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTxtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtContraseniaActionPerformed(evt);
            }
        });

        try {
            jFtxtFechaAdd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFtxtFechaAdd.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jBtnGuardarAdd.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jBtnGuardarAdd.setText("Guardar");
        jBtnGuardarAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarAddActionPerformed(evt);
            }
        });

        jBtnCancelarAdd.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jBtnCancelarAdd.setText("Cancelar");

        jBtnGrpEstado.add(jRbtnActivoAdd);
        jRbtnActivoAdd.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRbtnActivoAdd.setText("Activo");

        jBtnGrpEstado.add(jRbtnInactivoAdd);
        jRbtnInactivoAdd.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRbtnInactivoAdd.setText("Inactivo");

        jLblErrorEstado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        jLblCorreoError.setText("Correo Invalido");

        jLblCorreoError1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLblCorreoError1.setText("Año-Mes-DIa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblCorreoError)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(168, 168, 168)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel2)
                            .addGap(12, 12, 12)
                            .addComponent(jTxtNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jLabel3)
                            .addGap(12, 12, 12)
                            .addComponent(jTxtApellidAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jLabel4)
                            .addGap(12, 12, 12)
                            .addComponent(jTxtTelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel5)
                            .addGap(12, 12, 12)
                            .addComponent(jTxtDireccionAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel6)
                            .addGap(12, 12, 12)
                            .addComponent(jTxtCorreoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel8)
                            .addGap(12, 12, 12)
                            .addComponent(jTxtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(123, 123, 123)
                            .addComponent(jRbtnActivoAdd)
                            .addGap(134, 134, 134)
                            .addComponent(jRbtnInactivoAdd))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(jLblErrorEstado))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(jBtnGuardarAdd)
                            .addGap(158, 158, 158)
                            .addComponent(jBtnCancelarAdd))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel7)
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLblCorreoError1)
                                .addComponent(jFtxtFechaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(jTxtNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTxtApellidAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTxtTelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTxtDireccionAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTxtCorreoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLblCorreoError)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jFtxtFechaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLblCorreoError1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8))
                    .addComponent(jTxtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRbtnActivoAdd)
                    .addComponent(jRbtnInactivoAdd))
                .addComponent(jLblErrorEstado)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnGuardarAdd)
                    .addComponent(jBtnCancelarAdd))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtApellidAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtApellidAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtApellidAddActionPerformed

    private void jTxtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtContraseniaActionPerformed

    private void jTxtDireccionAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDireccionAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDireccionAddActionPerformed

    private void jBtnGuardarAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnGuardarAddActionPerformed

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
            java.util.logging.Logger.getLogger(JfrmAddUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmAddUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmAddUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmAddUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmAddUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnCancelarAdd;
    private javax.swing.ButtonGroup jBtnGrpEstado;
    public javax.swing.JButton jBtnGuardarAdd;
    public javax.swing.JFormattedTextField jFtxtFechaAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLblApellidoError;
    public javax.swing.JLabel jLblCorreoError;
    public javax.swing.JLabel jLblCorreoError1;
    public javax.swing.JLabel jLblDireccionError;
    public javax.swing.JLabel jLblErrorContra;
    public javax.swing.JLabel jLblErrorEstado;
    public javax.swing.JLabel jLblFechaError;
    public javax.swing.JLabel jLblNombreError;
    public javax.swing.JLabel jLblTelError;
    public javax.swing.JRadioButton jRbtnActivoAdd;
    public javax.swing.JRadioButton jRbtnInactivoAdd;
    public javax.swing.JTextField jTxtApellidAdd;
    public javax.swing.JTextField jTxtContrasenia;
    public javax.swing.JTextField jTxtCorreoAdd;
    public javax.swing.JTextField jTxtDireccionAdd;
    public javax.swing.JTextField jTxtNameAdd;
    public javax.swing.JTextField jTxtTelAdd;
    // End of variables declaration//GEN-END:variables
}
