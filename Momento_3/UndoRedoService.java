package service;

import java.util.Stack;

public class UndoRedoService {

    private Stack<String>
            pilaDeshacer;

    private Stack<String>
            pilaRehacer;

    public UndoRedoService() {

        pilaDeshacer =
                new Stack<>();

        pilaRehacer =
                new Stack<>();
    }

    public void guardarOperacion(
            String op) {

        pilaDeshacer.push(op);
    }

    public void deshacer() {

        if(pilaDeshacer.isEmpty()) {

            System.out.println(
                    "Nada para deshacer"
            );

            return;
        }

        String op =
                pilaDeshacer.pop();

        pilaRehacer.push(op);

        System.out.println(
                "Deshacer: " + op
        );
    }

    public void rehacer() {

        if(pilaRehacer.isEmpty()) {

            System.out.println(
                    "Nada para rehacer"
            );

            return;
        }

        String op =
                pilaRehacer.pop();

        pilaDeshacer.push(op);

        System.out.println(
                "Rehacer: " + op
        );
    }
}