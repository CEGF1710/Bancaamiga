
package Bancamiga.Clientes;

import Bancamiga.Solicitudes.ColaSolicitudes;
import Bancamiga.Banco.Persona;


public class Cliente extends Persona{
    ColaSolicitudes solicitudes;
    boolean terceraEdad;
    boolean discapacidad;
    
    public Cliente(String cedula_identidad, String p_nombre, String s_nombre, String p_apellido, String s_apellido, int edad_años){
        this.Cedulas = cedula_identidad;
        this.primerNombre = p_nombre;
        this.segundoNombre = s_nombre;
        this.primerApellido = p_apellido;
        this.segundoApellido = s_apellido;
        this.edad = edad_años;
        if(edad_años >= 60){
            terceraEdad = true;
        } else {
            terceraEdad = false;
        }
        this.solicitudes = new ColaSolicitudes();
    }
    
    //Getters
    
    public ColaSolicitudes getSolicitudes() {
        return this.solicitudes;
    }
    
    public int getNumeroSolicitudes(){
        return solicitudes.cantidadNodos();
    }
    
    public boolean getTerceraEdad(){
        return this.terceraEdad;
    }
    
    public boolean getDiscapacidad(){
        return this.discapacidad;
    }
    
     
    //Setters
    
    public void setSolicitudes(ColaSolicitudes solicitudesNuevas) {
        this.solicitudes = solicitudesNuevas;
    }
    
    public void setDiscapacidad(boolean estado) {
        this.discapacidad = estado;
    }
    
    //Demás métodos
    
    public boolean haySolicitudesPendientes() {
        return !solicitudes.esVacia();
    }
    
    public void encolarSolicitud(char operacion){
       solicitudes.encolar(operacion);
    }
    
    public char verSolicitud() {
        return solicitudes.vistazo().getSolicitud();
    }
    
    public char procesarSolicitud(){
        return solicitudes.desencolar().getSolicitud();
    }
    
    public String getNombreCompleto(){
        StringBuilder sb = new StringBuilder();
        sb.append(primerNombre);
        if(!segundoNombre.equals("")){
            sb.append(" ").append(segundoNombre);
        }
        if(!primerApellido.equals("")){
            sb.append(" ").append(primerApellido);
        }
        if(!segundoApellido.equals("")){
            sb.append(" ").append(segundoApellido);
        }
        return sb.toString();
       
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.Cedulas).append(" ");
        sb.append(this.primerNombre);
        if(!this.segundoNombre.equals("")) {
            sb.append("_");
            sb.append(this.segundoNombre);
        }
        if(!this.primerApellido.equals("")) {
            sb.append("_");
            sb.append(this.primerApellido);
        }
        if(!this.segundoApellido.equals("")) {
            sb.append("_");
            sb.append(this.segundoApellido);
        }
        sb.append(" ");
        sb.append(edad);
        sb.append(" ");
        sb.append(this.solicitudes.toString());
        sb.append("");
        return sb.toString();   
    }
    
}
