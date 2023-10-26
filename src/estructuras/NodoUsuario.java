/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Andrés Díaz, Luis Rivera y Ana Blanco
 */
public class NodoUsuario<T> {

    private T data;
    private NodoUsuario pnext;
    private ListaRelaciones AdyList;

    public NodoUsuario(T data) {
        this.data = data;
        this.pnext = null;
        this.AdyList = null;
    }
    // Getters and Setters

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoUsuario getPnext() {
        return pnext;
    }

    public void setPnext(NodoUsuario pnext) {
        this.pnext = pnext;
    }

    public ListaRelaciones getAdyList() {
        return AdyList;
    }

    public void setAdyList(ListaRelaciones AdyList) {
        this.AdyList = AdyList;
    }

}
