
package Bancamiga.Clientes;


/*

La prioridad se implementó como un booleano.*/

public class NodoCliente {
    Cliente cliente;
    NodoCliente siguiente;
    boolean prioridad;
    
    //Constructores.
        
        //Nodo sin cliente apuntando a nulo
        
        public NodoCliente(){
            cliente = null;
            siguiente = null;
            prioridad = false;
        }
        
        //Nodo sin clienteapuntando a otro nodo.
        
        public NodoCliente(NodoCliente sig, boolean prioridad){
            this.cliente = null;
            this.siguiente = sig;
            this.prioridad = prioridad;
        }
        
        //Cliente apuntando nulo.
        
        public NodoCliente(Cliente cliente, boolean prioridad){
            this.cliente = cliente;
            this.siguiente = null;
            this.prioridad = prioridad;
        }
        
        //Nodo con cliente apuntando a otro nodo.
        
        public NodoCliente(Cliente cliente, NodoCliente sig, boolean prioridad){
            this.cliente = cliente;
            this.siguiente = sig;
            this.prioridad = prioridad;
        }
        
    //Métodos accesores (getters)
        
        public Cliente getCliente(){
            return this.cliente;
        }
        
        public NodoCliente getSiguiente(){
            return this.siguiente;
        }
        
        public boolean getPrioridad() {
            return this.prioridad;
        }
        
    //Métodos mutadores (setters)
        
        public void setCliente(Cliente cli){
            this.cliente = cli;
        }
        
        public void setSiguiente(NodoCliente sig){
            this.siguiente = sig;
        }
        
        public void setPrioridad(boolean prioridad){
            this.prioridad = prioridad;
        }
}
