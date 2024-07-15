package Bancamiga.Banco;


public class Persona {
    public String Cedulas;
    public String primerNombre;
    public String segundoNombre;
    public String primerApellido;
    public String segundoApellido;
    public int edad;
    
   
    //Getters.
    
    public String getCedula(){
        return this.Cedulas;
    }
    
    public String getPrimerNombre(){
        return this.primerNombre;
    }
    
    public String getSegundoNombre(){
        return this.segundoNombre;
    }
    
    public String getPrimerApellido(){
        return this.primerApellido;
    }
    
    public String getSegundoApellido(){
        return this.segundoApellido;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    //Setters.
    
    public void setCedula(String cedula_identidad){
        this.Cedulas = cedula_identidad;
    };
    
    public void setPrimerNombre(String p_nombre){
        this.primerNombre = p_nombre;
    };
    
    public void setSegundoNombre(String s_nombre){
        this.segundoNombre = s_nombre;
    };
    
    public void setPrimerApellido(String p_apellido){
        this.primerApellido = p_apellido;
    };
    
    public void setSegundoApellido(String s_apellido){
        this.segundoApellido = s_apellido;
    };
    
    public void setEdad(int edad_años){
        this.edad = edad_años;
    };
    
    //Impresión de datos como cadena de caracteres
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Cedula de Identidad: ").append(this.Cedulas).append(".\n");
        builder.append("Nombre: ").append(this.primerNombre).append(" ").append(this.segundoNombre).append(".\n");
        builder.append("Apellidos: ").append(this.primerApellido).append(" ").append(this.segundoApellido).append(".\n");
        builder.append("Edad: ").append(this.edad).append(" años.");
        return builder.toString();
    }
    
    
}
