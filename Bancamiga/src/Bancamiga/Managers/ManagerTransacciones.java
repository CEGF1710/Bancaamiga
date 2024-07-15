
package Bancamiga.Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import Bancamiga.Transacciones.PilaTransacciones;

public class ManagerTransacciones {

    PilaTransacciones transacciones;
    LocalDate fecha;

    public ManagerTransacciones(PilaTransacciones trans) {
        transacciones = trans;
        fecha = null;
    }

    public boolean exportarTransacciones(File archivoTaquilla) {
        if (archivoTaquilla.exists()) {
            try {
                System.out.println("Detectado archivo de taquilla.");
                Scanner scannerFecha = new Scanner(archivoTaquilla);
                fecha = LocalDate.parse(scannerFecha.nextLine());
                scannerFecha.close();
                String nuevoArchivoNombre = "./taquilla " + fecha.getDayOfMonth() + "-" + fecha.getMonthValue() + "-" + fecha.getYear() + ".log";
                File nuevoArchivo = new File(nuevoArchivoNombre);
                archivoTaquilla.renameTo(nuevoArchivo);
                System.out.println("Archivo de taquilla existente renombrado satisfactoriamente.");
                fecha = fecha.plusDays(1);
            } catch (FileNotFoundException ex) {
                System.out.println("Archivo de taquilla no encontrado.");
                return false;
            }
        } else {
            fecha = LocalDate.now();
        }
        try {
            FileWriter fw = new FileWriter(archivoTaquilla);
            fw.write(fecha.toString());
            fw.write(System.getProperty("line.separator"));
            while (!transacciones.esVacia()) {
                fw.write(transacciones.desapilar().getTransaccion().toString());
                if (!transacciones.esVacia()) {
                    fw.write(System.getProperty("line.separator"));
                }
            }
            fw.close();

        } catch (IOException ex) {
            System.out.println("Error con respecto al archivo de taquilla.");
        }
        System.out.println("Archivo de taquilla creado.");
        return true;
    }
}
