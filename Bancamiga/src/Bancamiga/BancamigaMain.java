package Bancamiga;

import java.io.File;
import java.util.Scanner;
import Bancamiga.Managers.ManagersEntrada;
import Bancamiga.Managers.ManagerClientesPendientes;
import Bancamiga.Managers.ManagerTransacciones;
import Bancamiga.Banco.Taquilla;
import Bancamiga.Clientes.ColaClientes;
import Bancamiga.Transacciones.PilaTransacciones;

public class BancamigaMain {

    public static void main(String[] args) {
        File clientes = new File("./clientes.in");
        File clientesPendientes = new File("./clientes_pendientes.in");
        File reporteTaquilla = new File("./taquilla.log");
        Scanner scan = new Scanner(System.in);
        
        boolean resultado;
        boolean salir = false;
        while (salir == false) {
            menu();
            String op = menuSeleccion(scan);
            switch (op) {
                case "0":
                    salir = true;
                    break;
                case "1":
                    System.out.println("-------------------------------------------");
                    resultado = iniciar(clientes, clientesPendientes, reporteTaquilla);
                    if (resultado == true) {
                        System.out.println("Jornada Terminada.");
                    } else {
                        System.out.println("Error de entrada: No se pudo finalizar la jornada.");
                    }
                    System.out.println("-------------------------------------------");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Taquilla de Bancaamiga");
        System.out.println("");
        System.out.println("1. Comenzar Jornada.");
        System.out.println("0. Salir");
        System.out.println("");
        System.out.print("Seleccion: ");
    }

    public static boolean iniciar(File clientes, File clientesPendientes, File reporteTaquilla) {
        ManagersEntrada me = new ManagersEntrada();
        ColaClientes cola = me.prepararClientes(clientesPendientes, clientes);
        if (cola==null) {
            return false;
        }
        Taquilla taquilla = new Taquilla(cola);
        taquilla.atender();
        ColaClientes pendientes = taquilla.getPendientes();
        if (!pendientes.esVacia()) {
            ManagerClientesPendientes msp = new ManagerClientesPendientes(pendientes);
            msp.guardarClientes(clientesPendientes);
            System.out.println("Datos de Clientes Pendientes guardados con exito.");
        }
        PilaTransacciones transacciones = taquilla.getTransacciones();
        ManagerTransacciones mst = new ManagerTransacciones(transacciones);
        mst.exportarTransacciones(reporteTaquilla);
        return true;
    }

    public static String menuSeleccion(Scanner scan) {
        boolean exito = false;
        String seleccion = "";
        while (exito == false) {
            seleccion = scan.nextLine();
            if (!seleccion.equals("1") && !seleccion.equals("0")) {
                System.out.println("");
                System.out.println("Seleccion invalida.");
                System.out.println("");
                menu();
            } else {
                exito = true;
            }
        }
        return seleccion;

    }
}
