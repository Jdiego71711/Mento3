// ======================================================
// PROYECTO: SISTEMA UNIVERSITARIO
// CLASE PRINCIPAL
// Archivo: MenuConsola.java
// ======================================================

package util;

import model.*;
import service.*;
import exception.*;

import java.util.Scanner;

public class MenuConsola {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EstudianteService estudianteService =
                new EstudianteService();

        UndoRedoService undoRedoService =
                new UndoRedoService();

        RutaService rutaService =
                new RutaService();

        BatchService batchService =
                new BatchService();

        Aula aula101 = new Aula("101");

        Materia calculo =
                new Materia(
                        "CALC101",
                        "Calculo I",
                        3,
                        4
                );

        int opcion;

        do {

            System.out.println("\n============================================================");
            System.out.println("PLANIFICACION ACADEMICA - SISTEMA UNIVERSITARIO");
            System.out.println("============================================================");

            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Agregar prerequisito");
            System.out.println("6. Inscribir estudiante");
            System.out.println("7. Mostrar cola espera");
            System.out.println("8. Reservar aula");
            System.out.println("9. Consultar disponibilidad");
            System.out.println("10. Agregar conexion");
            System.out.println("11. Ruta mas corta");
            System.out.println("12. Registrar nota");
            System.out.println("13. Ver reporte");
            System.out.println("14. Deshacer");
            System.out.println("15. Rehacer");
            System.out.println("16. Procesar CSV");
            System.out.println("17. Salir");

            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // ============================================
                // REGISTRAR ESTUDIANTE
                // ============================================

                case 1:

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = sc.nextInt();

                    Estudiante estudiante =
                            new Estudiante(
                                    nombre,
                                    id,
                                    email,
                                    semestre
                            );

                    estudianteService.registrar(estudiante);

                    undoRedoService.guardarOperacion(
                            "Registrar estudiante"
                    );

                    System.out.println(
                            "Estudiante registrado"
                    );

                    break;

                // ============================================
                // BUSCAR
                // ============================================

                case 2:

                    System.out.print("ID: ");

                    String buscar =
                            sc.nextLine();

                    Estudiante encontrado =
                            estudianteService.buscar(
                                    buscar
                            );

                    if(encontrado != null) {

                        encontrado.mostrarInformacion();

                    } else {

                        System.out.println(
                                "No encontrado"
                        );
                    }

                    break;

                // ============================================
                // LISTAR
                // ============================================

                case 3:

                    estudianteService.listar();

                    break;

                // ============================================
                // ELIMINAR
                // ============================================

                case 4:

                    System.out.print("ID: ");

                    String eliminar =
                            sc.nextLine();

                    estudianteService.eliminar(
                            eliminar
                    );

                    undoRedoService.guardarOperacion(
                            "Eliminar estudiante"
                    );

                    System.out.println(
                            "Eliminado"
                    );

                    break;

                // ============================================
                // PREREQUISITO
                // ============================================

                case 5:

                    System.out.print(
                            "Prerequisito: ");

                    String pre =
                            sc.nextLine();

                    calculo.agregarPreRequisito(pre);

                    break;

                // ============================================
                // INSCRIBIR
                // ============================================

                case 6:

                    System.out.print(
                            "ID estudiante: ");

                    String idIns =
                            sc.nextLine();

                    Estudiante e =
                            estudianteService.buscar(
                                    idIns
                            );

                    if(e != null) {

                        calculo.inscribir(e);

                        undoRedoService.guardarOperacion(
                                "Inscribir estudiante"
                        );
                    }

                    break;

                // ============================================
                // COLA ESPERA
                // ============================================

                case 7:

                    for(Estudiante est :
                            calculo.getColaEspera()) {

                        System.out.println(
                                est.getNombre()
                        );
                    }

                    break;

                // ============================================
                // RESERVAR
                // ============================================

                case 8:

                    try {

                        System.out.print("Dia: ");
                        int dia = sc.nextInt();

                        System.out.print("Hora: ");
                        int hora = sc.nextInt();

                        System.out.print("Duracion: ");
                        int duracion = sc.nextInt();

                        aula101.reservar(
                                dia,
                                hora,
                                duracion
                        );

                        System.out.println(
                                "Reserva exitosa"
                        );

                    } catch (
                            HorarioConflictivoException ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                // ============================================
                // DISPONIBILIDAD
                // ============================================

                case 9:

                    System.out.print("Dia: ");
                    int d = sc.nextInt();

                    System.out.print("Hora: ");
                    int h = sc.nextInt();

                    boolean disponible =
                            aula101.consultarDisponibilidad(
                                    d,
                                    h
                            );

                    if(disponible) {

                        System.out.println(
                                "Disponible"
                        );

                    } else {

                        System.out.println(
                                "Ocupado"
                        );
                    }

                    break;

                // ============================================
                // CONEXION
                // ============================================

                case 10:

                    System.out.print("Origen: ");
                    int o = sc.nextInt();

                    System.out.print("Destino: ");
                    int des = sc.nextInt();

                    System.out.print("Distancia: ");
                    int dis = sc.nextInt();

                    rutaService.agregarConexion(
                            o,
                            des,
                            dis
                    );

                    break;

                // ============================================
                // DIJKSTRA
                // ============================================

                case 11:

                    System.out.print(
                            "Origen: ");

                    int origen =
                            sc.nextInt();

                    rutaService.dijkstra(
                            origen
                    );

                    break;

                // ============================================
                // REGISTRAR NOTA
                // ============================================

                case 12:

                    System.out.print("ID: ");

                    String idNota =
                            sc.nextLine();

                    Estudiante estNota =
                            estudianteService.buscar(
                                    idNota
                            );

                    if(estNota != null) {

                        System.out.print(
                                "Semestre: ");

                        int sem =
                                sc.nextInt();

                        System.out.print(
                                "Materia: ");

                        int mat =
                                sc.nextInt();

                        System.out.print(
                                "Nota: ");

                        double nota =
                                sc.nextDouble();

                        estNota.registrarNota(
                                sem,
                                mat,
                                nota
                        );

                        System.out.println(
                                "Nota registrada"
                        );
                    }

                    break;

                // ============================================
                // REPORTE
                // ============================================

                case 13:

                    System.out.print("ID: ");

                    String rep =
                            sc.nextLine();

                    Estudiante repEst =
                            estudianteService.buscar(rep);

                    if(repEst != null) {

                        repEst.mostrarInformacion();

                        System.out.println(
                                "Promedio: "
                                + repEst.calcularPromedio()
                        );
                    }

                    break;

                // ============================================
                // DESHACER
                // ============================================

                case 14:

                    undoRedoService.deshacer();

                    break;

                // ============================================
                // REHACER
                // ============================================

                case 15:

                    undoRedoService.rehacer();

                    break;

                // ============================================
                // CSV
                // ============================================

                case 16:

                    System.out.print(
                            "Ruta CSV: ");

                    String ruta =
                            sc.nextLine();

                    batchService.cargarCSV(ruta);

                    batchService.procesar();

                    break;

                // ============================================
                // SALIR
                // ============================================

                case 17:

                    System.out.println(
                            "Saliendo..."
                    );

                    break;
            }

        } while(opcion != 17);

        sc.close();
    }
}