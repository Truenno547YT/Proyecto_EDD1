/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import estructuras.Lista_T;
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
 * @author truenno
 */
public class main {
public static Lista_T lista_usuarios = new Lista_T(); 
public static Lista_T lista_relaciones = new Lista_T();
public static Lista_T lista_adyacencia = new Lista_T();
public static File selectedFile;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Main_interface.main(args);
    }
    
}
