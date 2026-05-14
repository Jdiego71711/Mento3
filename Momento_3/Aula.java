package model;

import exception.HorarioConflictivoException;

public class Aula {

    private String nombre;

    private boolean[][] horarios;

    public Aula(String nombre) {

        this.nombre = nombre;

        horarios = new boolean[7][24];
    }

    public void reservar(
            int dia,
            int hora,
            int duracion)
            throws HorarioConflictivoException {

        for(int i = hora;
            i < hora + duracion;
            i++) {

            if(horarios[dia][i]) {

                throw new
                        HorarioConflictivoException(
                        "Horario ocupado"
                );
            }
        }

        for(int i = hora;
            i < hora + duracion;
            i++) {

            horarios[dia][i] = true;
        }
    }

    public void liberar(
            int dia,
            int hora,
            int duracion) {

        for(int i = hora;
            i < hora + duracion;
            i++) {

            horarios[dia][i] = false;
        }
    }

    public boolean consultarDisponibilidad(
            int dia,
            int hora) {

        return !horarios[dia][hora];
    }
}