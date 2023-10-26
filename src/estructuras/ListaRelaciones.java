/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Ana Blanco, Andrés Diaz, Luis Rivera.
 */
public class ListaRelaciones<T> {

    private NodoRelacion<T> pFirst;
    private NodoRelacion<T> pLast;
    private int size;

    //Constructor
    public ListaRelaciones() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    //Getters and Setters
    public NodoRelacion<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodoRelacion<T> pFirst) {
        this.pFirst = pFirst;
    }

    public NodoRelacion<T> getpLast() {
        return pLast;
    }

    public void setpLast(NodoRelacion<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // FUNCIONES DE LA LISTA
    public boolean isEmpty() {
        return this.pFirst == null;
    }

    public void InsertBegin(T data) {
        NodoRelacion nodo = new NodoRelacion(data);

        if (isEmpty()) {
            this.setpFirst(nodo);
            this.setpLast(nodo);
        } else {
            nodo.setPnext(this.getpFirst());
            this.setpFirst(nodo);
        }
        size++;
    }

    public void InsertLast(T data) {
        NodoRelacion nodo = new NodoRelacion(data);
        if (isEmpty()) {
            this.setpFirst(nodo);
            this.setpLast(nodo);
        } else {
            this.pLast.setPnext(nodo);
            this.pLast = nodo;
        }
        this.size++;
    }

    public String print() {
        NodoRelacion pAux = this.getpFirst();
        String list = "";
        while (pAux != null) {
            list = list + " - " + (String) pAux.getData();
            pAux = pAux.getPnext();
        }

        return list;
    }

    public void EliminarPorReferenciaRelacion(T referencia) {
        if (buscar(referencia)) {
            if (this.pFirst.getData().equals(referencia)) {
                this.pFirst = this.pFirst.getPnext();
            } else {
                NodoRelacion<T> aux = this.pFirst;
                while (!aux.getPnext().getData().equals(referencia)) {
                    aux = aux.getPnext();
                }
                NodoRelacion siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);
            }
            size--;
        }
    }

    public boolean buscar(T referencia) {
        NodoRelacion aux = this.pFirst;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (aux.getData().equals(referencia)) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return encontrado;

    }
}
