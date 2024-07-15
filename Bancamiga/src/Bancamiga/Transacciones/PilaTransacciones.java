/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bancamiga.Transacciones;

import Bancamiga.Transacciones.NodoTransaccion;
import Bancamiga.Clientes.Cliente;
import Bancamiga.Banco.TiempoActual;

/* Esta clase representa a una pila de transacciones. Según el enunciado, se
debe mantener una lista de todas las transacciones realizadas, las cuales se
ordenan de ultimo a primero. Esto se puede lograr almacenando todas las tran
sacciones en una pila.

Se diferencia en una cola en que se inserta y remueve siempre por la cabeza.*/
public class PilaTransacciones {
    NodoTransaccion tope;
    int conteo;
    
    public PilaTransacciones(){
        tope = null;
        conteo = 0;
    }
    
    public boolean esVacia() {
        return tope == null;
    }
    
    public int getNumeroNodos(){
        return conteo;
    }
    
    public void vaciar(){
        tope = null;
        conteo = 0;
    }
    
    public NodoTransaccion vistazo(){
        return tope;
    }
    
    public void apilar(Transaccion transaccion) {
        NodoTransaccion nodo = new NodoTransaccion(transaccion);
        if (tope==null) {
            tope = nodo;
            conteo++;
        } else {
            NodoTransaccion nodoAux = tope;
            nodo.setSiguiente(nodoAux);
            tope = nodo;
            conteo++;
        }
    }
    
    public NodoTransaccion desapilar(){
        if(esVacia()){
            return null;
        } else {
            NodoTransaccion retornable = tope;
            tope = tope.getSiguiente();
            conteo--;
            return retornable;
        }
    }

}
