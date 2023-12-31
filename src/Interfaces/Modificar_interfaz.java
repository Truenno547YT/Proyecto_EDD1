/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Funciones.funciones;
import static Funciones.funciones.leer_archivo;
import Main.main;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.Main_interface;
import javax.swing.JOptionPane;
import estructuras.*;

/**
 *
 * @author Ana Blanco
 */
public class Modificar_interfaz extends javax.swing.JFrame {

    public static Main_interface v1;

    /**
     * Creates new form Modificar_interfaz
     */
    public Modificar_interfaz() {
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

        jPanel2 = new javax.swing.JPanel();
        AgregarUsuario = new javax.swing.JButton();
        EliminarUsuario = new javax.swing.JButton();
        Guardartxt = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(188, 164, 211));
        setMinimumSize(new java.awt.Dimension(550, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(181, 176, 193));
        jPanel2.setVerifyInputWhenFocusTarget(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AgregarUsuario.setBackground(new java.awt.Color(255, 255, 204));
        AgregarUsuario.setText("Agregar usuario ");
        AgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(AgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 130, 130));

        EliminarUsuario.setBackground(new java.awt.Color(255, 255, 204));
        EliminarUsuario.setText("Eliminar  usuario ");
        EliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(EliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 130, 130));

        Guardartxt.setBackground(new java.awt.Color(255, 255, 204));
        Guardartxt.setText("Guardar cambio");
        Guardartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardartxtActionPerformed(evt);
            }
        });
        jPanel2.add(Guardartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 130, 130));

        Back.setBackground(new java.awt.Color(255, 255, 204));
        Back.setText("Regresar");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel2.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 16, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bienvenido al sistema (2.).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 552, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        /**
         * *
         * Descripción: Con esta función se regresa a la ventan principal
         *
         * @author: Ana Blanco
         * @version: 26/10/2023
         *
         */
        Main_interface v1 = new Main_interface(this);
        v1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void GuardartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardartxtActionPerformed
        /**
         * *
         * Descripción: Con este botón, accionas la función de guardar
         * información que se encuentra en el archivo funciones.
         *
         * @author: Ana Blanco
         * @version: 26/10/2023
         *
         */

        if (main.lista_usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe cargar primero la base de datos para guardar cambios");
        } else {
            funciones.escribir_archivo();
        }

    }//GEN-LAST:event_GuardartxtActionPerformed

    private void EliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarUsuarioActionPerformed

        /**
         * *
         * Descripción: Con este botón, se da acceso a la ventana de eliminar
         * usuario
         *
         * @author: Ana Blanco
         * @version: 26/10/2023
         *
         */
        EliminarUsuario eliminar = new EliminarUsuario();
        eliminar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_EliminarUsuarioActionPerformed

    private void AgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarUsuarioActionPerformed

        /**
         * *
         * Descripción: Con este botón, se da acceso a la ventana de agregar
         * usuario
         *
         * @author: Ana Blanco
         * @version: 26/10/2023
         *
         */
        AgregarUsuario agregar = new AgregarUsuario(this);
        agregar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AgregarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarUsuario;
    private javax.swing.JButton Back;
    private javax.swing.JButton EliminarUsuario;
    private javax.swing.JButton Guardartxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
