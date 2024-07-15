
package Bancamiga.Clientes;


/* Una lista de clientes para propositos de revision de entrada. */
public class ListaClientes {
    NodoCliente tope;
    int conteo;
    int conteoPrioridad;

    public ListaClientes() {
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

    public NodoCliente vistazo() {
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
    
    public void agregarAlFinal(Cliente cliente, boolean prioridad) {
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
    
    public Cliente buscar(String cedula){
        if(esVacia()) {
            return null;
        }       
        NodoCliente auxiliar;
        auxiliar = tope;
        while(auxiliar != null) {
            if(auxiliar.getCliente().getCedula().equals(cedula)){
                return auxiliar.getCliente();
            }
            auxiliar = auxiliar.getSiguiente();
        }       
        return null;
    }
}
