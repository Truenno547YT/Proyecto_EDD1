/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Ana Blanco
 */
public class Pila<T> {
    private NodoRelacion<T> pCima;
    private int size;

    public Pila() {
        this.pCima = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.pCima == null;
    }

    public void push(T data) {
        NodoRelacion nodo = new NodoRelacion(data);
        if (this.isEmpty()) {
            this.pCima = nodo;
        } else {
            nodo.setPnext(this.pCima);
            this.pCima = nodo;
        }
        this.size++;
    }

    public NodoRelacion<T> pop() {
        NodoRelacion<T> node = this.pCima;
        if (!this.isEmpty()) {
            this.pCima = this.pCima.getPnext();
            size--;
        }
        return node;
    }

    public void search(T data) {
        if (!this.isEmpty()) {
            NodoRelacion<T> pAux = this.pop();
            T aux = pAux.getData();
            if (aux == data) {
                System.out.println("El dato existe");
            } else {
                this.search(data);
            }
            this.push(pAux.getData());
        } else {
            System.out.println("Elemento No Encontrado");
        }
    }

    public void submerge(T data) {
        if (!this.isEmpty()) {
            NodoRelacion<T> pAux = this.pop();
            T aux = pAux.getData();
            this.submerge(data);
            this.push(pAux.getData());
        } else {
            this.push(data);
        }
    }

    public void reverse() {
        if (!this.isEmpty()) {
            NodoRelacion<T> pAux = this.pop();
            T aux = pAux.getData();
            this.reverse();
            this.submerge(aux);
        }
    }

    public void print() {
        this.print("");

    }

    private void print(String string) {
        if (!this.isEmpty()) {
            NodoRelacion<T> pAux = this.pop();
            T aux = pAux.getData();
            string += "(" + aux + ")->";
            this.print(string);
            this.push(pAux.getData());
        } else {
            System.out.println(string + "//");
        }
    }

    public NodoRelacion<T> getpCima() {
        return pCima;
    }

    public void setpCima(NodoRelacion<T> pCima) {
        this.pCima = pCima;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
