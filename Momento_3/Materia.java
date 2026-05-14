package model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Materia {

    private String codigo;
    private String nombre;
    private int cupos;
    private int inscritos;
    private int creditos;

    private LinkedList<String> prerequisitos;

    private Queue<Estudiante> colaEspera;

    public Materia(String codigo,
                   String nombre,
                   int cupos,
                   int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.creditos = creditos;

        prerequisitos =
                new LinkedList<>();

        colaEspera =
                new ArrayDeque<>();
    }

    public void agregarPreRequisito(
            String pre) {

        prerequisitos.add(pre);
    }

    public void inscribir(
            Estudiante estudiante) {

        if(inscritos < cupos) {

            inscritos++;

            System.out.println(
                    estudiante.getNombre()
                    + " inscrito");

        } else {

            colaEspera.offer(estudiante);

            System.out.println(
                    "Materia llena");
        }
    }

    public void liberarCupo() {

        inscritos--;

        if(!colaEspera.isEmpty()) {

            Estudiante e =
                    colaEspera.poll();

            inscritos++;

            System.out.println(
                    "Asignado a "
                    + e.getNombre());
        }
    }

    public Queue<Estudiante>
    getColaEspera() {

        return colaEspera;
    }

    public LinkedList<String>
    getPrerequisitos() {

        return prerequisitos;
    }
}