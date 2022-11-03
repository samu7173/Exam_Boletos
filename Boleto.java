/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion_sorteo_examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author samue
 */
public class Boleto {
    private String titulo;

    private String numeroBoleto;

    private String fecha;

    private ArrayList<Integer> apuesta;

    private ArrayList<Integer> reintegros;

    private int rangoNumeros;

    private int cantidadNumeros;

    private int rangoreintegros;

    public Boleto() {
    }

    public Boleto(String titulo, String numeroBoleto, String fecha, int rangoNumeros, int rangoNumerosEspeciales, int cantidadNumeros) {
        this.titulo = titulo;
        this.numeroBoleto = numeroBoleto;
        this.fecha = fecha;
        this.rangoNumeros = rangoNumeros;
        this.rangoreintegros = rangoNumerosEspeciales;
        this.apuesta = new ArrayList<>();
        this.reintegros = new ArrayList<>();
        this.generarApuesta(cantidadNumeros);
    }
    

    public String getTitulo() {
        return titulo;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Integer> getApuesta() {
        return apuesta;
    }

    public void setApuesta(ArrayList<Integer> apuesta) {
        this.apuesta = apuesta;
    }

    public ArrayList<Integer> getreintegros() {
        return reintegros;
    }

    public void setreintegros(ArrayList<Integer> reintegros) {
        this.reintegros = reintegros;
    }

    public int getRangoNumeros() {
        return rangoNumeros;
    }

    public int getRangoNumerosEspeciales() {
        return rangoreintegros;
    }

    public int getCantidadNumeros() {
        return cantidadNumeros;
    }

    private void generarApuesta(int cantidadNumeros) {
        Random rng = new Random();
        int numero;
        for (int i = 0; i < cantidadNumeros; i++) {

            do {
                numero = rng.nextInt(this.getRangoNumeros()) + 1;
            } while (this.apuesta.contains(numero));

            this.apuesta.add(numero);
        }
        
        Collections.sort(this.apuesta);
        
        this.generarNumerosEspeciales();

    }

    public void generarNumerosEspeciales() {
        Random rng = new Random();
        int numero;

        if (this.getTitulo().equals("EUROMILLON")) {
            for (int i = 0; i < 2; i++) {
                do {
                    numero = rng.nextInt(this.getRangoNumerosEspeciales()) + 1;
                } while (this.apuesta.contains(numero));
                this.reintegros.add(numero);
            }
            
            Collections.sort(this.reintegros);

        } else {
            numero = rng.nextInt(this.getRangoNumerosEspeciales()) + 1;
            this.reintegros.add(numero);
        }
    }

    @Override
    public String toString() {
        return "**********************************"
                + "\n\t" + this.getTitulo()
                + "\n**********************************"
                + "\nNumero de boleto: " + this.getNumeroBoleto()
                + "\nFecha del sorteo: " + this.getFecha()
                + "\n**********************************"
                + "\nApuesta: " + this.getApuesta()
                + "\nReintegro: " + this.getreintegros()
                + "\n**********************************";
    }
}
