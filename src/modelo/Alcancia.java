/*
 * To change this license header, choose License Headers in 
Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Jhon Nash
 */
public class Alcancia {
    private int numCetavo;
    private int numPeso;
    private int numDosPeos;
    private int numCincoPesos;
    private int numDiezPesos;
    /*valores de monedas*/
    private Moneda centavo;
    private Moneda peso;
    private Moneda dosPesos;
    private Moneda cincoPesos;
    private Moneda diezPesos;
    private Calendar calendario;
    
    private Propietario propietario;
    private String fecha;

    public Alcancia() {
        this.numCetavo = 0;
        this.numPeso = 0;
        this.numDosPeos = 0;
        this.numCincoPesos = 0;
        this.numDiezPesos = 0;
        this.centavo =  new Moneda(.5);
        this.peso = new Moneda(1.0);
        this.dosPesos = new Moneda(2.0);
        this.cincoPesos = new Moneda(5);
        this.diezPesos = new Moneda(10);
        this.propietario = null;
        this.fecha = null;
    }

    public int getNumCetavo() {
        return numCetavo;
    }

    public void setNumCetavo(int numCetavo) {
        this.numCetavo = this.numCetavo + numCetavo;
    }

    public int getNumPeso() {
        return numPeso;
    }

    public void setNumPeso(int numPeso) {
        this.numPeso = this.numPeso + numPeso;
    }

    public int getNumDosPeos() {
        return numDosPeos;
    }

    public void setNumDosPeos(int numDosPeos) {
        this.numDosPeos = this.numDosPeos + numDosPeos;
    }

    public int getNumCincoPesos() {
        return numCincoPesos;
    }

    public void setNumCincoPesos(int numCincoPesos) {
        this.numCincoPesos = this.numCincoPesos + numCincoPesos;
    }

    public int getNumDiezPesos() {
        return numDiezPesos;
    }

    public void setNumDiezPesos(int numDiezPesos) {
        this.numDiezPesos = this.numDiezPesos + numDiezPesos;
    }

    public Moneda getCentavo() {
        return centavo;
    }

    public void setCentavo(Moneda centavo) {
        this.centavo = centavo;
    }

    public Moneda getPeso() {
        return peso;
    }

    public void setPeso(Moneda peso) {
        this.peso = peso;
    }

    public Moneda getDosPesos() {
        return dosPesos;
    }

    public void setDosPesos(Moneda dosPesos) {
        this.dosPesos = dosPesos;
    }

    public Moneda getCincoPesos() {
        return cincoPesos;
    }

    public void setCincoPesos(Moneda cincoPesos) {
        this.cincoPesos = cincoPesos;
    }

    public Moneda getDiezPesos() {
        return diezPesos;
    }

    public void setDiezPesos(Moneda diezPesos) {
        this.diezPesos = diezPesos;
    }
    
    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public double calculaTotal(){
        double total=0.0;
            total = (this.numCetavo* this.centavo.getValor())
                    + (this.numPeso*this.peso.getValor()) + 
                    (this.numDosPeos*dosPesos.getValor()) + 
                    (this.numCincoPesos*this.cincoPesos.getValor())+
                    (this.numDiezPesos*this.diezPesos.getValor()); 
        return total;
    }
    
    public String getCalendario(){
        String cadena = null;
        String dia = null;
        String mes = null;
        String anio = null;
        
        this.calendario = Calendar.getInstance();
        dia =  Integer.toString(calendario.get(Calendar.DATE));
        mes = Integer.toString(calendario.get(Calendar.MONTH));
        anio = Integer.toString(calendario.get(Calendar.YEAR));
        cadena = ""+dia+"-"+mes+"-"+anio;
        return cadena;
    }
}
