package Funciones;

import static Interfaces.Main_interface.grafo;
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
import estructuras.NodoRelacion;
import java.io.PrintWriter;
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

        try {
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
            for (int i = 1; i < usuarios_split3.length; i++) {
                String to_insert = "@" + usuarios_split3[i];
                main.lista_usuarios.InsertLast(to_insert);

            }

            // Se crea la lista de relaciones y se agregan en los respectivos nodos que le corresponde de la lista principal
            String relaciones_split = data.toString().split("relaciones")[1];
            String[] wait = relaciones_split.split("@");

            for (int j = 0; j < (Integer) main.lista_usuarios.getSize(); j++) {
                NodoUsuario usuario = main.lista_usuarios.searchByIndex(j);
                String str = (String) usuario.getData();
                String usuario_sin = str.split("@")[1];
                ListaRelaciones relaciones = new ListaRelaciones();

                for (int i = 1; i < wait.length; i = i + 2) {

                    String usuarioarray = wait[i].split(",")[0];

                    if (usuario_sin.equals(usuarioarray)) {
                        String to_insert = "@" + wait[i + 1];
                        relaciones.InsertLast(to_insert);
                    }

                }

                usuario.setAdyList(relaciones);
            }

            JOptionPane.showMessageDialog(null, "Ha ingresado la información correctamente");

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erorr!!!! No has cargado el archivo correcto");
        }

    }

    public static void invertir_relaciones(ListaUsuarios lista_usuariosInvertidos) {

	     main.lista_usuarios.print();
	    System.out.println("-------------");
if(lista_usuariosInvertidos.getSize()== 0) {
        if(!main.lista_usuarios.isEmpty()){
            for (NodoUsuario pAux = main.lista_usuarios.getpFirst() ; pAux !=null; pAux = pAux.getPnext() ) {
		    String usuario = pAux.getData().toString();
		    lista_usuariosInvertidos.InsertLast(usuario);
            }
	for(NodoUsuario pAux = lista_usuariosInvertidos.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
		    ListaRelaciones lista_relacion = new ListaRelaciones<NodoRelacion>();
		    pAux.setAdyList(lista_relacion);
	}

	    for(NodoUsuario pAux = lista_usuariosInvertidos.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
			   for (NodoUsuario pAux1 =main.lista_usuarios.getpFirst(); pAux1 != null; pAux1 = pAux1.getPnext()) {
			    	for(NodoRelacion pAux2 = pAux1.getAdyList().getpFirst(); pAux2 != null; pAux2 = pAux2.getPnext()){
		    			if (pAux.getData().toString().equalsIgnoreCase(pAux2.getData().toString())){
						pAux.getAdyList().InsertLast(pAux1.getData().toString());
				}else {
						
					}
			}		
		    }
	    } 
	
    }
    }else{
		lista_usuariosInvertidos.resetList();
		invertir_relaciones(lista_usuariosInvertidos);
	}
    
	lista_usuariosInvertidos.print();
    }

 public static void escribir_archivo(){  
        
        String guardar = "usuarios\n";
        
            if(!main.lista_usuarios.isEmpty()){
                
                NodoUsuario pAux = main.lista_usuarios.getpFirst();
        
                for (int i = 0; i < main.lista_usuarios.getSize(); i++) {
                    guardar += pAux.getData() + "\n";
                    pAux = pAux.getPnext();
                }
        
                guardar += "relaciones\n";
        
                pAux =  main.lista_usuarios.getpFirst();
        
                for (int i = 0; i < main.lista_usuarios.getSize(); i++) {
                    String name = (String) pAux.getData();
                    NodoRelacion adyacente = pAux.getAdyList().getpFirst();
            
                    for (int j = 0; j < pAux.getAdyList().getSize() ; j++) {
                        guardar = guardar + name + "," + adyacente.getData()+ "\n";
                        adyacente = adyacente.getPnext();
                    }
                    pAux = pAux.getPnext();
                }
        
                
            }else{
                JOptionPane.showMessageDialog(null, "No hay información para actualizar");
            }
            
        try{
                PrintWriter pw = new PrintWriter("test\\datos.txt");
                pw.print(guardar);
                pw.close();
                JOptionPane.showMessageDialog(null, "Se ha guardado la información exitosamente!");
                
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No es posible guardar la información");
        }
        
    }
    



    public static void AgregarNuevo(String usuario_nuevo, String relacion) {

        if (main.lista_usuarios.buscar(usuario_nuevo)) {
            JOptionPane.showMessageDialog(null, "El Usuario ya se encuentra en la lista");
        }
        main.lista_usuarios.InsertLast(usuario_nuevo);
        NodoUsuario pAux = main.lista_usuarios.getpLast();
        ListaRelaciones relaciones = new ListaRelaciones();
        for (int i = 0; i < relacion.split(",").length; i++) {
            if (relacion.split(",")[i].charAt(0) != '@') {
                relacion.split(",")[i] = "@" + relacion.split(",")[i];
                System.out.println(relacion.split(",")[i].charAt(0));
            }
            System.out.println(relacion.split(",")[i]);
        }
        relaciones.InsertLast(relacion);
        pAux.setAdyList(relaciones);

    }

    public static void EliminarUsuario(String usuario) {
        main.lista_usuarios.EliminarPorReferencia(usuario);
        NodoUsuario aux = main.lista_usuarios.getpFirst();
        while (aux != null) {
            aux.getAdyList().EliminarPorReferenciaRelacion(usuario);
            aux = aux.getPnext();
        }

        main.lista_usuarios.print();

    }
}
