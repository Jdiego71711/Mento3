package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Queue;
import java.util.ArrayDeque;

public class BatchService {

    private Queue<String> cola;

    public BatchService() {

        cola =
                new ArrayDeque<>();
    }

    public void cargarCSV(
            String ruta) {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(ruta)
                    );

            String linea;

            while((linea =
                    br.readLine())
                    != null) {

                cola.offer(linea);
            }

            br.close();

        } catch (Exception e) {

            System.out.println(
                    "Error archivo"
            );
        }
    }

    public void procesar() {

        while(!cola.isEmpty()) {

            System.out.println(
                    cola.poll()
            );
        }
    }
}