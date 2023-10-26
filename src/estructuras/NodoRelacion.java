/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Ana Blanco, Andrés Dias y Luis Rivera.
 */
public class NodoRelacion<T> {

    private T data;
    private NodoRelacion pnext;

    public NodoRelacion(T data) {
        this.data = data;
        this.pnext = null;
    }

    //Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoRelacion getPnext() {
        return pnext;
    }

    public void setPnext(NodoRelacion pnext) {
        this.pnext = pnext;
    }

}
