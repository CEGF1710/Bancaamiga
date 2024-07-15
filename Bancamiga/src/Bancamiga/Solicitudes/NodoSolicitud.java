package Bancamiga.Solicitudes;

   /* 
    Leyenda:
    A,a = Actualización de libretas.
    R,r = Retiro.
    D,d = Depósito.
    P,p = Pago de servicios.
    C,c = Consulta de movimientos.
    0 = Sin operación.
    */
    public class NodoSolicitud{
        char solicitud;
        NodoSolicitud siguiente;
        
        
        //Nodo sin solicitud apuntando a nulo
        
        public NodoSolicitud(){
            solicitud = '0';
            siguiente = null;
        }
        
        //Nodo sin solicitudapuntando a otro nodo.
        
        public NodoSolicitud(NodoSolicitud sig){
            this.solicitud = '0';
            this.siguiente = sig;
        }
        
        //Nodo con solicitud apuntando nulo.
        
        public NodoSolicitud(char sol){
            this.solicitud = sol;
            this.siguiente = null;
        }
        
        //Nodo con solicitud apuntando a otro nodo.
        
        public NodoSolicitud(char sol, NodoSolicitud sig){
            this.solicitud = sol;
            this.siguiente = sig;
        }
        
        //Métodos accesores (getters)
        
        public char getSolicitud(){
            return this.solicitud;
        }
        
        public NodoSolicitud getSiguiente(){
            return this.siguiente;
        }
        
        //Métodos mutadores (setters)
        
        public void setSolicitud(char sol){
            this.solicitud = sol;
        }
        
        public void setSiguiente(NodoSolicitud sig){
            this.siguiente = sig;
        }       
    }