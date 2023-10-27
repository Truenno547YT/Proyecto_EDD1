/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Funciones.Kosaraju;
import Main.main;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import estructuras.NodoUsuario;
import Funciones.funciones;
import static Main.main.lista_usuarios;
import estructuras.ListaRelaciones;
import estructuras.NodoRelacion;
import java.awt.HeadlessException;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.graphstream.ui.view.Viewer;
import estructuras.ListaUsuarios;
import org.graphstream.algorithm.ConnectedComponents;
import java.util.Random;

/**
 *
 * @author Andrés Díaz, Luis Rivera y Ana Blanco
 */
public class Main_interface extends javax.swing.JFrame {

    Graph grafo = new SingleGraph("Red Social");

    public static Modificar_interfaz v2;

    /**
     * Creates new form FIle_Chooser
     */
    public Main_interface(Modificar_interfaz v21) {
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
        VerGrafo = new javax.swing.JButton();
        leer_archivo = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        componentes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(181, 176, 193));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VerGrafo.setBackground(new java.awt.Color(255, 255, 204));
        VerGrafo.setText("Ver Grafo");
        VerGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerGrafoActionPerformed(evt);
            }
        });
        jPanel2.add(VerGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 350, 30));

        leer_archivo.setBackground(new java.awt.Color(255, 255, 204));
        leer_archivo.setText("Cargar datos de usuarios");
        leer_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leer_archivoActionPerformed(evt);
            }
        });
        jPanel2.add(leer_archivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 350, 30));

        modificar.setBackground(new java.awt.Color(255, 255, 204));
        modificar.setText("Modificar datos de usuario");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel2.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 350, 30));

        componentes.setBackground(new java.awt.Color(255, 255, 204));
        componentes.setText("Componentes fuertemente conectados");
        componentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentesActionPerformed(evt);
            }
        });
        jPanel2.add(componentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 350, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bienvenido al sistema (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void componentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentesActionPerformed
        /**
         * *
         * Descripción: Acá se genera una lista con los componenetes fuertemente
         * conectados y se muestran por medio de la librería.
         *
         * @author: Ana Blanco
         * @version: 26/10/2023
         *
         */
        // TODO add your handling code here:
        try {
            ListaRelaciones totalscc = Kosaraju.stronglyConnectedComponents(main.lista_usuarios);

            for (NodoRelacion pAux = totalscc.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
                String comp = "";
                ListaRelaciones pAuxreal = (ListaRelaciones) pAux.getData();
                Random random = new Random();
                int nextInt = random.nextInt(0xffffff + 1);
                String colorCode = String.format("#%06x", nextInt);
                String random_color = colorCode;
                for (NodoRelacion pAux2 = pAuxreal.getpFirst(); pAux2 != null; pAux2 = pAux2.getPnext()) {
                    comp = pAux2.getData().toString();
                    grafo.getNode(comp).setAttribute("ui.style", "fill-color: " + colorCode + ";");
                }
            }

            Viewer viewer = grafo.display();

            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La base de datos está vacía, tienes que cargar la información primero");
        }
    }//GEN-LAST:event_componentesActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        /**
         * *
         * Descripción: Acá se da acceso a la nueva interfaz donde están las
         * opciones de eliminar, agregar y guardar cambios.
         *
         * @author: Ana Blanco
         * @version: 26/10/2023
         *
         */
        Modificar_interfaz v2 = new Modificar_interfaz();
        v2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_modificarActionPerformed

    private void leer_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leer_archivoActionPerformed
        // TODO add your handling code here:
        /**
         * *
         * Descripción: Esto se encarga de leer el archivotxt
         *
         * @author: Andrés Diaz
         * @version: 26/10/2023
         *
         */
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(jPanel2);
            File selectedFile = fileChooser.getSelectedFile();
            main.selectedFile = fileChooser.getSelectedFile();
            funciones.leer_archivo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erorr!!!! No has cargado el archivo correcto");
        }


            for (NodoUsuario pAux = main.lista_usuarios.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
                grafo.addNode(pAux.getData().toString()).setAttribute("ui.label", pAux.getData().toString());
            }

            for (NodoUsuario pAux = main.lista_usuarios.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
                String nodo1 = (String) pAux.getData();
                for (NodoRelacion pAux1 = pAux.getAdyList().getpFirst(); pAux1 != null; pAux1 = pAux1.getPnext()) {
                    String nodo2 = (String) pAux1.getData();
                    grafo.addEdge(nodo1 + nodo2, nodo1, nodo2, true);
                }
	    }

            String styleSheet = "node{"
                    + "text-mode: normal; text-alignment: center;text-size: 15;"
                    + "size: 30px; text-padding: 10;shape:circle; fill-color:gray;} "
                    + ""
                    + "edge{"
                    + "shape: cubic-curve; arrow-shape:diamond; arrow-size: 10; "
                    + "fill-mode: dyn-plain; fill-color: black; text-size: 10; text-alignment: under;}";

            grafo.setAttribute("ui.stylesheet", styleSheet);
            System.setProperty("org.graphstream.ui.renderer",
                    "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
    }//GEN-LAST:event_leer_archivoActionPerformed

    private void VerGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerGrafoActionPerformed
        // TODO add your handling code here:

        /**
         * *
         * Descripción: Aquí se descarga la información de la estructura del
         * grafo y se le ingresa a la librería para mostrarlo.
         *
         * @author: Ana Blanco y Andrés Díaz
         * @version: 26/10/2023
         *
         */


        if (grafo.getNodeCount() != 0) {
		for (int i = 0; i < grafo.getNodeCount(); i++) {
			grafo.getNode(i).setAttribute("ui.style", "fill-color:gray;");
			
		}
	}
        grafo.setStrict(false);
        grafo.setAutoCreate(true);

        if (!main.lista_usuarios.isEmpty()) {
		System.out.println("too fino");
	}else{	
            JOptionPane.showMessageDialog(null, "No se ha cargado ningún archivo!");
	    return;
	}
            


            Viewer viewer = grafo.display();

            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

    

    }//GEN-LAST:event_VerGrafoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Main_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_interface(v2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VerGrafo;
    private javax.swing.JButton componentes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton leer_archivo;
    private javax.swing.JButton modificar;
    // End of variables declaration//GEN-END:variables
}
