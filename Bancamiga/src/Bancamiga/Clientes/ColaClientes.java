
package Bancamiga.Clientes;


/* Esta estructura representa a la cola de clientes que esperan para ser
atendidos en una Taquilla de Banesco.*/
public class ColaClientes {

    NodoCliente tope;
    int conteo;
    int conteoPrioridad;

    public ColaClientes() {
        tope = null;
        conteo = 0;
        conteoPrioridad = 0;
    }

    public boolean esVacia() {
        return tope == null;
    }

    public int cantidadNodos() {
        return conteo;
    }

    public int cantidadNodosPrioridad() {
        return conteoPrioridad;
    }

    public NodoCliente vista() {
        return tope;
    }

    public boolean hayPrioridad() {
        return conteoPrioridad > 0;
    }

    public void vaciar() {
        tope = null;
        conteo = 0;
        conteoPrioridad = 0;
    }

    public void encolar(Cliente cliente, boolean prioridad) {
        NodoCliente nodo = new NodoCliente(cliente, prioridad);
        if (esVacia()) {
            tope = nodo;
            conteo++;
        } else {
            NodoCliente auxiliar = tope;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nodo);
            conteo++;
            if (prioridad == true) {
                conteoPrioridad++;
            }
        }
    }

    public NodoCliente desencolar() {
        if (esVacia()) {
            return null;
        } else {
            NodoCliente retornable = tope;
            tope = tope.getSiguiente();
            conteo--;
            if (retornable.getPrioridad() == true) {
                conteoPrioridad--;
            }
            return retornable;
        }
    }

    ;
    
    public NodoCliente desencolarConPrioridad() {
        if (esVacia()) {
            return null;
        }

        if (!hayPrioridad()) {
            return null;
        }
        
        int tempConteo = conteo;
        int tempConteo2 = conteoPrioridad;
        
        ColaClientes colaAuxiliar = new ColaClientes();
        NodoCliente retornable = null;
        NodoCliente nodoAuxiliar;
        boolean encontrado = false;

        while (!esVacia() && !encontrado) {
            nodoAuxiliar = vista();
            if (nodoAuxiliar.getPrioridad() == true) {
                retornable = nodoAuxiliar;
                desencolar();
                encontrado = true;
            } else {
                colaAuxiliar.encolar(nodoAuxiliar.getCliente(), nodoAuxiliar.getPrioridad());
                desencolar();
            }
        }
        
        if (!esVacia()) {
            while(!esVacia()) {
                nodoAuxiliar = desencolar();
                colaAuxiliar.encolar(nodoAuxiliar.getCliente(), nodoAuxiliar.getPrioridad());
            } 
        }
        
        tope = colaAuxiliar.tope;
        conteo = tempConteo;
        conteoPrioridad = tempConteo2;
        conteoPrioridad--;
        conteo--;
        return retornable;
    }
    

}
