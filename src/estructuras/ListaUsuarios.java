/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *  Esta es la estructura pricipal del grafo.
 * 
 * @author Andrés Díaz, Luis Rivera y Ana Blanco
 */
public class ListaUsuarios<T> {
	
	private NodoUsuario<T> pFirst;
	private NodoUsuario<T> pLast;
	private int size;

	public ListaUsuarios() {
		this.pFirst = null;
		this.pLast = null;
		this.size = 0;
	}
        
        // Getters and Setters

	public NodoUsuario<T> getpFirst() {
		return pFirst;
	}

	public void setpFirst(NodoUsuario<T> pFirst) {
		this.pFirst = pFirst;
	}

	public NodoUsuario<T> getpLast() {
		return pLast;
	}

	public void setpLast(NodoUsuario<T> pLast) {
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

	public void InsertBegin(T data, ListaRelaciones list) {
		NodoUsuario nodo = new NodoUsuario(data, list);
		if (isEmpty()) {
			this.setpFirst(nodo);
			this.setpLast(nodo);
		} else {
			nodo.setPnext(this.getpFirst());
			this.setpFirst(nodo);
		}
		size++;
	}


	public void InsertLast(T data, ListaRelaciones list) {
		NodoUsuario nodo = new NodoUsuario(data, list);
		if (isEmpty()) {
			this.setpFirst(nodo);
			this.setpLast(nodo);
		} else {
			this.pLast.setPnext(nodo);
			this.pLast = nodo;
		}
		size++;
	}

	public void print() {
		NodoUsuario pAux = this.getpFirst();
		while (pAux != null) {
			System.out.println(pAux.getData());
			pAux = pAux.getPnext();
		}
	}


	
}
