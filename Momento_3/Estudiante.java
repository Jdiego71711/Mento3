package model;

import java.util.LinkedList;

public class Estudiante extends Persona {

    private int semestre;

    private Double[][] notas;

    private LinkedList<String> historial;

    public Estudiante(String nombre,
                      String id,
                      String email,
                      int semestre) {

        super(nombre, id, email);

        this.semestre = semestre;

        notas = new Double[10][20];

        historial = new LinkedList<>();
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + nombre);

        System.out.println(
                "ID: " + id);

        System.out.println(
                "Semestre: " + semestre);
    }

    public void registrarNota(
            int semestre,
            int materia,
            Double nota) {

        notas[semestre][materia] = nota;
    }

    public double calcularPromedio() {

        double suma = 0;

        int contador = 0;

        for(int i = 0; i < 10; i++) {

            for(int j = 0; j < 20; j++) {

                if(notas[i][j] != null) {

                    suma += notas[i][j];

                    contador++;
                }
            }
        }

        return contador == 0
                ? 0
                : suma / contador;
    }
}