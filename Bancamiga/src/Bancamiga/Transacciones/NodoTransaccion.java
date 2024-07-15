/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancamiga.Transacciones;

public class NodoTransaccion {

    Transaccion transaccion;
    NodoTransaccion siguiente;

    //Métodos constructores.
    //Nodo sin transaccion apuntando a nulo
    public NodoTransaccion() {
        transaccion = null;
        siguiente = null;
    }

    //Nodo sin transaccion apuntando a otro nodo.
    public NodoTransaccion(NodoTransaccion sig) {
        this.transaccion = null;
        this.siguiente = sig;
    }

    //Nodo con transaccion apuntando nulo.
    public NodoTransaccion(Transaccion tran) {
        this.transaccion = tran;
        this.siguiente = null;
    }

    //Nodo con transaccion apuntando a otro nodo.
    public NodoTransaccion(Transaccion tran, NodoTransaccion sig) {
        this.transaccion = tran;
        this.siguiente = sig;
    }

    //Métodos accesores (getters)
    public Transaccion getTransaccion() {
        return this.transaccion;
    }

    public NodoTransaccion getSiguiente() {
        return this.siguiente;
    }

    //Métodos mutadores (setters)
    public void setTransaccion(Transaccion tran) {
        this.transaccion = tran;
    }

    public void setSiguiente(NodoTransaccion sig) {
        this.siguiente = sig;
    }
}
