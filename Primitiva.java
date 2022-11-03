/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion_sorteo_examen;

/**
 *
 * @author samue
 */
public class Primitiva extends Boleto{
    public Primitiva() {
    }

    public Primitiva(String numeroBoleto, String fecha) {
        super("PRIMITIVA",numeroBoleto, fecha, 49, 10, 6);
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
