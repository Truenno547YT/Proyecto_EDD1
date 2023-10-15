package Funciones;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.graphicGraph.*;
import estructuras.NodoUsuario;
import estructuras.ListaRelaciones;
import Main.main;
import estructuras.ListaUsuarios;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrés Díaz, Luis Rivera y Ana Blanco
 */
public class funciones {

	public static void leer_archivo() throws FileNotFoundException {
		
		try{
			Scanner lector = new Scanner(main.selectedFile);
//			System.out.println("Seleccion Exitosa, Ubicacion:" + main.selectedFile); //Eliminar luego
			StringBuilder data = new StringBuilder();
            while (lector.hasNextLine()) {
				String data_ln = lector.nextLine();
				data.append(data_ln);
			}
            
            // Se arma la estructura principal que son las lista de usuarios
            String usuarios_split = data.toString().split("relaciones")[0];
			String[] usuarios_split2 = usuarios_split.split("usuarios");
			String[] usuarios_split3 = usuarios_split2[1].split("@");
			for (int i =1; i < usuarios_split3.length; i++) {
				String to_insert = "@" + usuarios_split3[i];
				main.lista_usuarios.InsertLast(to_insert);
				
            }
            
            
            // Se crea la lista de relaciones y se agregan en los respectivos nodos que le corresponde de la lista principal
            
            String relaciones_split = data.toString().split("relaciones")[1];
			String[] wait = relaciones_split.split("@");
            
            
			for (int j = 0; j < (Integer)main.lista_usuarios.getSize() ; j++){
				NodoUsuario usuario = main.lista_usuarios.searchByIndex(j);
                String str = (String)usuario.getData();
                String usuario_sin = str.split("@")[1];
                ListaRelaciones relaciones = new ListaRelaciones();
                
                for (int i = 1; i < wait.length; i = i+2){
     
                    String usuarioarray = wait[i].split(",")[0];
                  
                    if(usuario_sin.equals(usuarioarray)){
                        String to_insert = "@" + wait[i+1];
                        relaciones.InsertLast(to_insert);
                    }
                    
				}
               
                usuario.setAdyList(relaciones);
            } 
            
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erorr!!!! No has cargado el archivo correcto");
		}
	
	}

		
}