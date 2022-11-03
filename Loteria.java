/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package solucion_sorteo_examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author samue
 */
public class Loteria {
    static int ultimoBoletoGenerado = 1;
    static byte opcion;
    static Scanner sc = new Scanner(System.in);
    static Pattern comprobarFecha = Pattern.compile("(\\d{1,2})/(\\d{1,2})/(\\d{4})");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       menuPrincipal();
    }
    
    //pera generar numero de boleto
    static String generarNumeroBoleto() {
        StringBuilder numBoleto = new StringBuilder(String.valueOf(ultimoBoletoGenerado));
        ultimoBoletoGenerado++;
        for (int i = 0; i < 6; i++) {
            if (numBoleto.length() == 6) {
                return numBoleto.toString();
            }
            numBoleto.insert(0, "0");
        }

        return numBoleto.toString();
    }
    //Comprobaciones para la fecha
    static boolean comprobarDia(String dia) {
        int diaNumero = Integer.parseInt(dia);

        return diaNumero > 0 && diaNumero < 31;
    }

    static boolean comprobarMes(String mes) {
        int mesNumero = Integer.parseInt(mes);

        return mesNumero > 0 && mesNumero <= 12;
    }
    static private String preguntarFecha() {
        String fecha = "";
        boolean salidaFecha = true;

        do {
            System.out.println("Introduzca la fecha del sorteo respetando el siguiente formato -> dd/mm/yyyy: ");

            fecha = sc.next();

            Matcher m = comprobarFecha.matcher(fecha);

            if (m.find() && comprobarDia(m.group(1)) && comprobarMes(m.group(2))) {
                salidaFecha = false;
            } else {
                System.out.println("Formato de fecha incorrecto o fecha mal no valida");
            }

        } while (salidaFecha);

        return fecha;
    }
    //procesos para leer o escribir en un fichero y mostrarlo por consola
    static void buscarBoleto() {
        System.out.println("Escriba el numero de su boleto");

        String boleto = sc.next();

        File fichero = new File(boleto + ".bol");

        if (fichero.exists()) {
            Scanner leer = null;
            try {
                leer = new Scanner(fichero);
                while (leer.hasNextLine()) {
                    String linea = leer.nextLine();

                    System.out.println(linea);
                }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (leer != null) {
                        leer.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
    static void imprimirBoleto(Boleto boleto) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(boleto.getNumeroBoleto() + ".bol");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(boleto);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    //si desea imprimir boleto
    static void Elegirimprimir(Boleto boleto) {
        boolean condicion = true;
        do {
            System.out.println("Desea imprimir el boleto?");
            System.out.println("1. Si");
            System.out.println("2. No");

            try {
                opcion = sc.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("ERROR. Escoja una de las opciones numericas presentadas");
                sc.nextLine();
            }finally {
            switch (opcion) {
                case 1 -> {
                    imprimirBoleto(boleto);
                    condicion = false;
                }

                case 2 -> {
                    System.out.println("No se imprimira");
                    condicion = false;
                }
                default -> {
                    System.out.println("Escoja un opcion valida");
                }
            }
        }} while (condicion);

    }
    //Menu para generar el tipo de boleto
    static private void menuGenerar() {
        boolean salida = true;
        do {
            System.out.println("¿Qué boleto desea generar?");
            System.out.println("1. Primitiva");
            System.out.println("2. El Gordo");
            System.out.println("3. Euromillones");
            System.out.println("4. Volver al menu anterior");

            try {
                opcion = sc.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("ERROR. Escoja una de las opciones numericas presentadas");
                sc.nextLine();
            } finally {

                switch (opcion) {
                    case 1 -> {
                        Primitiva pri = new Primitiva(generarNumeroBoleto(), preguntarFecha());
                        System.out.println(pri);
                        Elegirimprimir(pri);
                    }

                    case 2 -> {
                        El_Gordo gordo = new El_Gordo(generarNumeroBoleto(), preguntarFecha());
                        System.out.println(gordo);
                        Elegirimprimir(gordo);
                    }

                    case 3 -> {
                        Euromillon euro = new Euromillon(generarNumeroBoleto(), preguntarFecha());
                        System.out.println(euro);
                        Elegirimprimir(euro);
                    }

                    case 4 -> {
                        System.out.println("\nVolviendo al menu principal...");
                        salida = false;
                    }
                    default -> {
                        System.out.println("Opcion no valida. Escoja de nuevo");
                    }
                }

            }
        } while (salida);
    }
    //Menu Principal
    static private void menuPrincipal() {

        do {
            System.out.println("¿Qué quiere hacer?");
            System.out.println("1. Generar Boleto");
            System.out.println("2. Buscar boleto");
            System.out.println("3. Salir");

            try {
                opcion = sc.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("ERROR. Escoja una de las opciones numericas presentadas");
                sc.nextLine();
            } finally {

                switch (opcion) {
                    case 1 -> {
                        menuGenerar();
                    }

                    case 2 -> {
                        buscarBoleto();
                    }

                    case 3 -> {
                        System.out.println("Saliendo de la aplicacion...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Opcion no valida. Escoja de nuevo");
                    }
                }

            }
        } while (true);

    }
}
