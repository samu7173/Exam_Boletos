/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion_sorteo_examen;

/**
 *
 * @author samue
 */
public class Euromillon extends Boleto{
    public Euromillon() {
    }

    public Euromillon(String numeroBoleto, String fecha) {
        super("EUROMILLON", numeroBoleto, fecha, 50, 23, 5);
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
