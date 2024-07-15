/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bancamiga.Transacciones;

import Bancamiga.Clientes.Cliente;
import Bancamiga.Banco.TiempoActual;

/*Esta clase representa una transacción realizada en una taquilla, y guarda toda
la información pertinente: datos del cliente, hora de realización, tipo de
solicitud, etc.*/
public class Transaccion {
    String cliente;
    String cedulaCliente;
    String hora;
    String tipoSolicitud;
    String horaFinalización;
    boolean prioridad;
    String descripcionPrioridad;
    char codigoSolicitud;
    
    public Transaccion(Cliente cliente, TiempoActual hora, char solicitud) {
        this.cliente = cliente.getNombreCompleto();
        cedulaCliente = cliente.getCedula();
        this.hora = hora.toString();
        switch(solicitud){
            case 'A': tipoSolicitud = "Actualización de libretas";
            break;
            case 'R': tipoSolicitud = "Retiro";
            break;
            case 'D': tipoSolicitud = "Depósito";
            break;
            case 'P': tipoSolicitud = "Pago de servicios";
            break;
            case 'C': tipoSolicitud = "Consulta de movimientos";
            break;
            case '0': tipoSolicitud = "Sin operación";
            break;
            default: tipoSolicitud = "Error en código de operación";
            break;
        }
        codigoSolicitud = solicitud;
        prioridad = false;
    }
    
    public void setPrioridad(boolean estado){
        prioridad = estado;
    }
    
    public void setDescripcionPrioridad(String descPrioridad){
        descripcionPrioridad = descPrioridad;
    }
    
    public void setHoraFinal(TiempoActual hora) {
        horaFinalización = hora.toString();
    }
    
    public String getHoraFinal(){
        return horaFinalización;
    }
    
    public String getNombreCliente(){
        return cliente;
    }
    
    public String getCedula() {
        return cedulaCliente;
    }
    
    public String getHoraTransaccion(){
        return hora;
    }
    
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }
    
    public char getCodigoSolicitud(){
        return codigoSolicitud;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------------\n");
        sb.append("Cedula del cliente: ").append(cedulaCliente).append(".\n");
        sb.append("Nombre del cliente: ").append(cliente).append(".\n");
        sb.append("Estado de prioridad: ");
        if(prioridad) {
            sb.append("Ciente prioritario.\n");
            sb.append("Prioridad por: ").append(descripcionPrioridad).append("\n");
        } else {
            sb.append("Cliente no prioritario.\n");
        }
        sb.append("Hora de inicio de transacción: ").append(hora).append(" (hora militar).\n");
        sb.append("Hora de finalización de transacci´ón: ").append(horaFinalización).append(" (hora militar)\n");
        sb.append("Tipo de solicitud: ").append(tipoSolicitud).append(" (código de operación: ").append(codigoSolicitud).append(").");
        return sb.toString();
    }
    
}
