package Bancamiga.Solicitudes;


public class ColaSolicitudes{
    
    private NodoSolicitud tope;
    private int max = 5;
    private int conteo;
        
    public ColaSolicitudes(){
        tope = null;
        conteo = 0;
    }
    
    public boolean esVacia(){
        return this.tope == null;
    }
    
    public boolean esLlena(){
        return this.conteo == this.max;
    }
    
    public int cantidadNodos(){
        return this.conteo;
    }
    
    public NodoSolicitud vistazo(){
        return this.tope;
    }
    
    public void vaciar() {
        this.tope = null;
        this.conteo = 0;
    }
    
    public void encolar(char solicitud) {
        if(esLlena()) {
            System.out.println("Cola llena");
        } else {
            NodoSolicitud nodo = new NodoSolicitud(Character.toUpperCase(solicitud));
            if (esVacia()){
                tope = nodo;
                conteo++;
            } else {
                NodoSolicitud auxiliar = tope;
                while(auxiliar.getSiguiente() != null) {
                    auxiliar = auxiliar.getSiguiente();
                }
                auxiliar.setSiguiente(nodo);
                conteo++;
            }
        }
    }
    
    public NodoSolicitud desencolar(){
        if(esVacia()){
            System.out.println("Cola vacia.");
            return null;
        } else {
            NodoSolicitud retornable = tope;
            tope = tope.siguiente;
            conteo--;
            return retornable;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (esVacia()) {
            return "[]";
        } else {
            NodoSolicitud aux = new NodoSolicitud();
            aux = tope;
            while(aux.siguiente != null) {
                sb.append(aux.solicitud).append("-");
                aux = aux.getSiguiente();
            }
            sb.append(aux.solicitud);
        }
        return sb.toString();
    }
    
}
