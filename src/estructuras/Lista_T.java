/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author truenno
 */
public class Lista_T<T> {
	
	private Nodo<T> pFirst;
	private Nodo<T> pLast;
	private int size;

	public Lista_T() {
		this.pFirst = null;
		this.pLast = null;
		this.size = 0;
	}

	public Nodo<T> getpFirst() {
		return pFirst;
	}

	public void setpFirst(Nodo<T> pFirst) {
		this.pFirst = pFirst;
	}

	public Nodo<T> getpLast() {
		return pLast;
	}

	public void setpLast(Nodo<T> pLast) {
		this.pLast = pLast;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	

	public boolean isEmpty() {
		return size == 0;
	}

	public void InsertBegin(T data) {
		Nodo nodo = new Nodo(data);
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
		Nodo nodo = new Nodo(data);
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
		Nodo pAux = this.getpFirst();
		while (pAux != null) {
			System.out.println(pAux.getData());
			pAux = pAux.getPnext();
		}
	}


	
}
