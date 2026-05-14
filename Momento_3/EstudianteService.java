package service;

import model.Estudiante;

import java.util.HashMap;

public class EstudianteService {

    private HashMap<String,
            Estudiante> estudiantes;

    public EstudianteService() {

        estudiantes =
                new HashMap<>();
    }

    public void registrar(
            Estudiante estudiante) {

        estudiantes.put(
                estudiante.getId(),
                estudiante
        );
    }

    public Estudiante buscar(
            String id) {

        return estudiantes.get(id);
    }

    public void eliminar(
            String id) {

        estudiantes.remove(id);
    }

    public void listar() {

        for(Estudiante e :
                estudiantes.values()) {

            e.mostrarInformacion();

            System.out.println(
                    "Promedio: "
                    + e.calcularPromedio()
            );

            System.out.println(
                    "-------------");
        }
    }
}