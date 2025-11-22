/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciosdata_hora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jorge-victor
 */
public class ExerciciosData_Hora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LocalDate data1 = LocalDate.now();
        Instant data3 = Instant.now();
        Instant data4 = Instant.parse("2025-11-22T01:30:26Z");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/yyyy/MM");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/yyyy/MM HH:mm").withZone(ZoneId.systemDefault());

        LocalDate data2 = LocalDate.parse("20/2024/12", fmt1);

        int ano = 2024;
        int dia = 12;
        int mes = 8;

        LocalDate data = LocalDate.of(ano, mes, dia); // criar usando variaveisã
        
        // converter global -> local
        
        LocalDate d1 = LocalDate.ofInstant(data4, ZoneId.systemDefault());
        LocalDateTime d2 = LocalDateTime.ofInstant(data4, ZoneId.of("America/Panama"));
        
        /*for(String s: ZoneId.getAvailableZoneIds())
        {
            System.out.println(s);
        }*/
        
        System.out.println(d1);
        System.out.println(d2);

        System.out.println(data1.format(fmt1));// Imprimir em formato diferente mostrar a data
        System.out.println(data1); // imprime no formato ISO (por padrão)
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(data);
        System.out.println(data4);
        System.out.println(fmt2.format(data4)); // para converter uma data hora global sempre devemos informar o timeZone
    }

}
