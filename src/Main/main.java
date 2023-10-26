/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import estructuras.ListaUsuarios;
import Interfaces.Main_interface;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author Andrés Díaz, Luis Rivera y Ana Blanco
 */
public class main {

    public static ListaUsuarios lista_usuarios = new ListaUsuarios();
    public static File selectedFile;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main_interface.main(args);
    }

}
