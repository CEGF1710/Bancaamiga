
package Bancamiga.Banco;

import Bancamiga.Clientes.Cliente;
import Bancamiga.Transacciones.Transaccion;
import Bancamiga.Clientes.ColaClientes;
import Bancamiga.Transacciones.PilaTransacciones;

/* Esta clase representa a la unica taquilla disponible según el enunciado.

Cada taquilla tiene un espacio para atender a clientes, una cola de clientes a los que atienda,
una pila de transacciones realizadas, y lleva el conteo del horario global.*/
public class Taquilla {

    Cliente atendiendo;
    ColaClientes cola;
    ColaClientes pendientes;
    PilaTransacciones transaccionesEfectuadas;
    TiempoActual hora;
    boolean jornadaTerminada;

    public Taquilla(ColaClientes clientes) {
        atendiendo = null;
        cola = clientes;
        hora = new TiempoActual(8);
        transaccionesEfectuadas = new PilaTransacciones();
        jornadaTerminada = false;
        pendientes = new ColaClientes();
    }

    public boolean hayClientesEnCola() {
        return !cola.esVacia();
    }
    public boolean JornadaTerminada() {
        return jornadaTerminada;
    }
    public void terminarJornada() {
        jornadaTerminada = true;
    }
    public void rotarCliente() {
        atendiendo = (Cliente) cola.desencolar().getCliente();
    }
    
    public void rotarConPrioridad(){
        atendiendo = (Cliente) cola.desencolarConPrioridad().getCliente();
    }
    
    public boolean hayPendientes(){
        return !pendientes.esVacia();
    }
    
    public ColaClientes getPendientes() {
        return pendientes;
    }
    
    public PilaTransacciones getTransacciones(){
        return transaccionesEfectuadas;
    }
    public int duracionSolicitudMinutos(char solicitud) {
        int minutos;
        switch (solicitud) {
            case 'A':
                minutos = 5;
                break;
            case 'R':
                minutos = 4;
                break;
            case 'D':
                minutos = 3;
                break;
            case 'P':
                minutos = 2;
                break;
            case 'C':
                minutos = 1;
                break;
            case '0':
                minutos = 0;
                break;
            default:
                minutos = 0;
                break;
        }
        return minutos;
    }
    public int duracionSolicitudSegundos(char solicitud) {
        int segundos;

        switch (solicitud) {

            case 'C':
                segundos = 30;
                break;
            default:
                segundos = 0;
                break;
        }
        return segundos;
    }

    public void atender(){
        boolean hayTiempo = true;
        int conteoPrioridad = 0;
        boolean prioridad;
        while(!JornadaTerminada() && hayClientesEnCola()) {
            if (conteoPrioridad == 4) {
                if(cola.hayPrioridad()) {
                    prioridad = true;
                    rotarConPrioridad();
                    conteoPrioridad = 0;
                    System.out.println("Se han atendido a 4 clientes no prioritarios. Atendiendo a cliente prioritario con cedula " + atendiendo.Cedulas +" ("+atendiendo.getNombreCompleto()+")");
                } else {
                    prioridad = cola.vista().getPrioridad();
                    rotarCliente();
                    conteoPrioridad = 0;
                }
            } else {
                prioridad = cola.vista().getPrioridad();
                rotarCliente();
            }
            
            if (prioridad == false) {
                conteoPrioridad++;
            }
            
            while(atendiendo.haySolicitudesPendientes() && hayTiempo) {
                hayTiempo = atenderSolicitudCliente();
            }
            
            if(!hayTiempo) {
                pendientes.encolar(atendiendo, prioridad);
                if(hayClientesEnCola()){
                    encolarPendientes();
                }
            }
        }
    }
    
    public void encolarPendientes(){
        boolean prioridad;
        if(hayClientesEnCola()) {
            while(!cola.esVacia()){
                prioridad = cola.vista().getPrioridad();
                pendientes.encolar(cola.desencolar().getCliente(), prioridad);
            }
        }
    }
    
    public boolean atenderSolicitudCliente() {
        char operacion = atendiendo.verSolicitud();
        int minutos = duracionSolicitudMinutos(operacion);
        int segundos = duracionSolicitudSegundos(operacion);
        
        Transaccion tran = new Transaccion(atendiendo, hora, operacion);
        boolean exito = hora.incrementarTiempo(minutos,segundos);
        if (!exito) {
            terminarJornada();
            return false;
        } else {
            boolean prioridadCliente = atendiendo.getDiscapacidad() || atendiendo.getTerceraEdad();
            atendiendo.procesarSolicitud();
            tran.setHoraFinal(hora);
            tran.setPrioridad(prioridadCliente);
            if(prioridadCliente == true) {
                if (atendiendo.getTerceraEdad() == true){
                    tran.setDescripcionPrioridad("Tercera edad");
                } else {
                    tran.setDescripcionPrioridad("Discapacitado/Problemas prioritarios");
                }
            }
            transaccionesEfectuadas.apilar(tran);
            return true;
        }

    }

}
