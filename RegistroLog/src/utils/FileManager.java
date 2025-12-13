/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import entities.Log;
import java.time.Instant;
import java.util.HashSet;

/**
 *
 * @author jorge-victor
 */
public class FileManager {

    public static Set<Log> readFile() {

        Set<Log> logs = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(" ");

                String name = fields[0];
                Instant instant = Instant.parse(fields[1]);

                logs.add(new Log(name, instant));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return logs;
    }
}

//                LocalDateTime teste = instant.atZone(ZoneId.of(("Africa/Luanda"))).toLocalDateTime();
//                System.out.println("Hr de angola " + teste);
