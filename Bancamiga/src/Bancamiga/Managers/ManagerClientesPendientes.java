
package Bancamiga.Managers;

import java.io.File;
import Bancamiga.Clientes.ColaClientes;
import java.io.FileWriter;
import java.io.IOException;



public class ManagerClientesPendientes {
    ColaClientes pendientes;
    
    public ManagerClientesPendientes(ColaClientes colaPendientes){
        pendientes = colaPendientes;
    }
    
    public boolean guardarClientes(File archivo){
        try {
            FileWriter fw = new FileWriter(archivo);
            StringBuilder sb;
            String datosCliente;
            boolean prioridadCliente;
            while (!pendientes.esVacia()){
                sb = new StringBuilder();
                prioridadCliente = pendientes.vista().getPrioridad();
                sb.append(pendientes.desencolar().getCliente().toString());
                if(prioridadCliente == true) {
                    sb.append(" ");
                    sb.append('1');
                } else {
                    sb.append(" ");
                    sb.append('0');
                }
                datosCliente = sb.toString();
                fw.write(datosCliente);
                if(!pendientes.esVacia()){
                    fw.write(System.getProperty("line.separator"));
                }
            }
            fw.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Error al operar sobre 'clientes_pendientes.in'");
            return false;
        }
    }
}
