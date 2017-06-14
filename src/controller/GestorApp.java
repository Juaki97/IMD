package controller;

import model.Gestor;
import model.Participante;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by garci on 14/06/2017.
 */
public class GestorApp {
    Gestor gestor;

    public GestorApp(){
        gestor = new Gestor();
    }

    public void run() {
        int option;

        gestor.cargarParticipantes();

        while ((option = showMenu()) != 0) {
            switch (option) {
                case 1:
                    gestor.registarCliente(leerAtleta());
                    break;
                case 2:
                    if (gestor.longitud() > 0) {
                        gestor.consultarClasificaciones();
                    }
                    break;
                case 3:
                    if (gestor.longitud() > 0) {
                        gestor.consultarAtleta(getIdentificador());
                    }
                    break;
                case 4:
                    if (gestor.longitud() > 0) {
                        gestor.editarAtleta(getIdentificador());
                    }
                    break;
                case 5:
                    if (gestor.longitud() > 0) {
                        gestor.borrarAtleta(getIdentificador());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Muestra menú con las diferentes opciones para que el usuario indique
     * qué desea hacer.
     * @return
     */
    public int showMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("**********************************");
        System.out.println("* 1. Añadir marca                *");
        if (gestor.longitud()>0) {
            System.out.println("* 2. Consultar clasificaciones   *");
            System.out.println("* 3. Consultar info atleta       *");
            System.out.println("* 4. Editar inf atleta           *");
            System.out.println("* 5. Borrar Atleta               *");
        }
        System.out.println("* 0. Salir                       *");
        System.out.println("**********************************");

        System.out.println("Opción: ");

        /**
         * Te obliga a seleccionar siempre una opción correcta. En caso
         * contrario, te obligará a volver a elegir una.
         */
        try {
            option = input.nextInt();
            return option;
        }catch (InputMismatchException e){
            System.out.println("Opción inválida.");
        }
        return showMenu();
    }

    private int getIdentificador(){
        Scanner input = new Scanner(System.in);

        System.out.print("Dorsal: ");
        return input.nextInt();
    }

    private Participante leerAtleta(){
        return null;
    }

}