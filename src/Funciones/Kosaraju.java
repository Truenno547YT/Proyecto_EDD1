/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import estructuras.ListaRelaciones;
import estructuras.ListaUsuarios;
import estructuras.Pila;
import Main.main;
import estructuras.NodoRelacion;
import estructuras.NodoUsuario;

/**
 *
 * @author Ana Blanco
 */
public class Kosaraju {

    public static ListaRelaciones stronglyConnectedComponents(ListaUsuarios grafo) {
        
        /***
         *Descripción: Esta es la estructura principal del Kosaraju, retorna una lista donde cada 
         *nodo contiene la lista de componentes fuertemente conectados.
         *@author: Ana Blanco
         *@version: 26/10/2023
         * */

        ListaRelaciones visited = new ListaRelaciones();
        Pila pila = new Pila();
        LlenarOrden(main.lista_usuarios.getpFirst().getData().toString(), visited, pila, grafo);
        pila.push(main.lista_usuarios.getpFirst().getData());
        visited.resetList();
        ListaUsuarios traspuesto = new ListaUsuarios<NodoUsuario>();
        invertir_relaciones(traspuesto);
        ListaRelaciones totalscc = new ListaRelaciones();

        while (!pila.isEmpty()) {
            NodoRelacion pCima2 = pila.pop();
            NodoUsuario pCima = BuscarNodo(pCima2.getData().toString(), traspuesto);
            if (!visited.contains(pCima.getData().toString())) {
                ListaRelaciones sccActual = new ListaRelaciones();
                LlenarSCC(pCima, visited, sccActual, traspuesto);
                sccActual.InsertLast(pCima.getData());
                totalscc.InsertLast(sccActual);
            }
        }

        
        return totalscc;

    }

    public static void invertir_relaciones(ListaUsuarios lista_usuariosInvertidos) {
        
        /***
         *Descripción: Esto se encarga de invertir el grafo pasado por como parametro
         * Fué realizado por Andrés Diaz.
         *@author: Ana Blanco
         *@version: 26/10/2023
         * */

        if (lista_usuariosInvertidos.getSize() == 0) {
            if (!main.lista_usuarios.isEmpty()) {
                for (NodoUsuario pAux = main.lista_usuarios.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
                    String usuario = pAux.getData().toString();
                    lista_usuariosInvertidos.InsertLast(usuario);
                }
                for (NodoUsuario pAux = lista_usuariosInvertidos.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
                    ListaRelaciones lista_relacion = new ListaRelaciones<NodoRelacion>();
                    pAux.setAdyList(lista_relacion);
                }

                for (NodoUsuario pAux = lista_usuariosInvertidos.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
                    for (NodoUsuario pAux1 = main.lista_usuarios.getpFirst(); pAux1 != null; pAux1 = pAux1.getPnext()) {
                        for (NodoRelacion pAux2 = pAux1.getAdyList().getpFirst(); pAux2 != null; pAux2 = pAux2.getPnext()) {
                            if (pAux.getData().toString().equalsIgnoreCase(pAux2.getData().toString())) {
                                pAux.getAdyList().InsertLast(pAux1.getData().toString());
                            }
                        }
                    }
                }

            }
        } else {
            lista_usuariosInvertidos.resetList();
            invertir_relaciones(lista_usuariosInvertidos);
        }
    }

    private static void LlenarSCC(NodoUsuario nodo, ListaRelaciones visited, ListaRelaciones sccActual, ListaUsuarios traspuesto) {
        
        /***
         *Descripción: Esto se encarga de llenar el nodo que  
         *contiene los componentes fuertemente conectados.
         *@author: Ana Blanco
         *@version: 26/10/2023
         * */
        
        visited.InsertLast(nodo.getData());

        ListaRelaciones adyacentes = nodo.getAdyList();
        NodoRelacion adyacenteActual = adyacentes.getpFirst();

        while (adyacenteActual != null) {
            if (!visited.contains(adyacenteActual.getData().toString())) {
                NodoUsuario principal = BuscarNodo(adyacenteActual.getData().toString(), traspuesto);
                LlenarSCC(principal, visited, sccActual, traspuesto);
                sccActual.InsertLast(principal.getData());
            }
            adyacenteActual = adyacenteActual.getPnext();
        }

    }

    private static void LlenarOrden(String origen, ListaRelaciones visited, Pila pila, ListaUsuarios grafo) {
        
        /***
         *Descripción: Esta función se encarga realizar el recorrido a profundidad del grafo por completo
         *Además, de llenar la pila con la que trabaja el algoritmo.
         *@author: Ana Blanco
         *@version: 26/10/2023
         * */

        visited.InsertLast(origen);
        NodoUsuario nodo = BuscarNodo(origen, grafo);
        ListaRelaciones ady = nodo.getAdyList();
        NodoRelacion nodoady = ady.getpFirst();

        while (nodoady != null) {
            if (!visited.contains(nodoady.getData().toString())) {
                NodoUsuario principal = BuscarNodo(nodoady.getData().toString(), grafo);
                LlenarOrden(principal.getData().toString(), visited, pila, grafo);
                pila.push(principal.getData().toString());
            }
            nodoady = nodoady.getPnext();
        }

    }

    public static NodoUsuario BuscarNodo(String valor, ListaUsuarios grafo) {

        /***
         *Descripción: Esta función se encarga de buscar un nodo dentro del grafo 
         * que se le pase como parametro a partir de un valor dado
         *@author: Ana Blanco
         *@version: 26/10/2023
         * */
        
        for (NodoUsuario pAux = grafo.getpFirst(); pAux != null; pAux = pAux.getPnext()) {
            if (pAux.getData().toString().equals(valor)) {
                return pAux;
            }
        }
        return null;
    }
}
