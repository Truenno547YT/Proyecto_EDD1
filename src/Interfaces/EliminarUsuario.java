/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import estructuras.*;
import Funciones.funciones;
import Main.main;
import javax.swing.*;

/**
 *
 * @author Ana Blanco
 */
public class EliminarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form EliminarUsuario
     */
    public EliminarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
             NodoUsuario aux = main.lista_usuarios.getpFirst();
        for (int i = 0; i < main.lista_usuarios.getSize(); i++) {
            ComboBox.addItem(aux.getData().toString());
            aux = aux.getPnext();
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                Back = new javax.swing.JButton();
                ComboBox = new javax.swing.JComboBox<>();
                Eliminar = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(181, 176, 193));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                Back.setText("Regresar");
                Back.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                BackActionPerformed(evt);
                        }
                });
                jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

                ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                jPanel1.add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 210, -1));

                Eliminar.setText("Eliminar");
                Eliminar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                EliminarActionPerformed(evt);
                        }
                });
                jPanel1.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bienvenido al sistema (4).png"))); // NOI18N
                jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Modificar_interfaz v2 = new Modificar_interfaz();
        v2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

        private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
                // TODO add your handling code here:
     JOptionPane.showMessageDialog(null, "El susuario: " + ComboBox.getSelectedItem().toString() + ", sera eliminado");
        String usuario = ComboBox.getSelectedItem().toString();
        funciones.EliminarUsuario(usuario);
        }//GEN-LAST:event_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarUsuario().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton Back;
        private javax.swing.JComboBox<String> ComboBox;
        private javax.swing.JButton Eliminar;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        // End of variables declaration//GEN-END:variables
}
