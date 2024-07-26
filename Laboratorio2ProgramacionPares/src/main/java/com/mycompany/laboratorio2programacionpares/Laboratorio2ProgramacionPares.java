package com.mycompany.laboratorio2programacionpares;

import java.util.Scanner;

public class Laboratorio2ProgramacionPares {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int menu = 0;

        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("   R E G I S T R O  C A R R E R A  D E  C A B A L L O S");
            System.out.println("                           ---");
            System.out.println("----------------------------------------------------------");
            System.out.println("1. Registrar Caballo");
            System.out.println("2. Ingresar tiempos de los caballos");
            System.out.println("3. Mostrar el caballo ganador");
            System.out.println("4. Salir");
            System.out.println("----------------------------------------------------------");
            System.out.println("Seleccione una opcion: ");          
            while (true) {
                try {
                    String entrada = scann.nextLine();
                    menu = Integer.parseInt(entrada);
                    if (menu < 1 || menu > 4) {
                        System.out.println("Opcion erronea, ingrese una opcion entre 1 y 4: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opcion erronea, ingrese una opcion entre 1 y 4: ");
                }
            }
            switch (menu) {
                case 1:
                    CaballoCarrera.registrarCaballo();
                    break;
                case 2:
                    CaballoCarrera.ingresarTiempo();
                    break;
                case 3:
                    CaballoCarrera.mostrarGanador();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (menu != 4);
    }
}