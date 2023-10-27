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

	public void InsertBegin(T data) {
		NodoUsuario nodo = new NodoUsuario(data);
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
		NodoUsuario nodo = new NodoUsuario(data);
		if (isEmpty()) {
			this.setpFirst(nodo);
			this.setpLast(nodo);
		} else {
			this.pLast.setPnext(nodo);
			this.pLast = nodo;
		}
		this.size++;
	}

	public void print() {
		NodoUsuario pAux = this.getpFirst();
		while (pAux != null) {
			System.out.println("\n"+pAux.getData());
            String lista = pAux.getAdyList().print();
            System.out.println("Lista adyacente: "+ lista + "\n");
			pAux = pAux.getPnext();
		}
	}
    
    //    Buscar por indices
    public NodoUsuario<T> searchByIndex(int index){
        NodoUsuario<T> pAux = this.pFirst;
        int count = 0;
        
        while(pAux != null && count != index){
            pAux = pAux.getPnext();
            count++;
        }
        
        if(pAux != null){
            return pAux;
        }else{
            return null;
        }
    }
    
    
    //    Buscar información por el indice
    public String returnIndexData(int index){
        NodoUsuario<T> returnedNode = this.searchByIndex(index);
        
        if(returnedNode == null){
            return null;
        }else{
            return (String)returnedNode.getData();
        }
    }
    
    public T getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getData();
            }else{
                NodoUsuario aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return (T) aux.getData();
            }
        }
        return null;
    }

	public void resetList() {
		this.pFirst = null;
		this.pLast = null;
		this.size = 0; 
	}

public boolean buscar(T referencia) {
        NodoUsuario aux = this.pFirst;
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

public void EliminarPorReferencia(T referencia) {
        if (buscar(referencia)) {
            if (this.pFirst.getData().equals(referencia)) {
                this.pFirst = this.pFirst.getPnext();
            } else {
                NodoUsuario<T> aux = this.pFirst;
                while (!aux.getPnext().getData().equals(referencia)) {
                    aux = aux.getPnext();

                }
                NodoUsuario siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);
            }
            size--;
        }
    }

public NodoUsuario buscarNodo(T referencia) {
        NodoUsuario aux = this.pFirst;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (aux.getData().equals(referencia)) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return aux;

    }
}
