/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion_sorteo_examen;

/**
 *
 * @author samue
 */
public class El_Gordo extends Boleto{
    public El_Gordo() {
    }
//(String titulo, String numeroBoleto, String fecha, int rangoNumeros, int rangoNumerosEspeciales, int cantidadNumeros)
    public El_Gordo(String numeroBoleto, String fecha) {
        super("EL GORDO", numeroBoleto, fecha, 54, 10, 5);
    }
    @Override
    public String toString() {
        return "**********************************"+
               "\n\t"+ this.getTitulo() +
               "\n**********************************"+
               "\nNumero de boleto: "+this.getNumeroBoleto()+
               "\nFecha del sorteo: "+this.getFecha()+
               "\n**********************************"+
               "\nApuesta: "+this.getApuesta()+
               "\nEstrellas: "+this.getreintegros()+
               "\n**********************************";
    }
    
    
}
