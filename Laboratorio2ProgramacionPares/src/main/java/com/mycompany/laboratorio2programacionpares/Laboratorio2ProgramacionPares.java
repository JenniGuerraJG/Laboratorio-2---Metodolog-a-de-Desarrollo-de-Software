
package com.mycompany.laboratorio2programacionpares;

import java.util.Scanner;

public class Laboratorio2ProgramacionPares {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int menu;
        do{
        System.out.println("----------------------------------------------------------");
        System.out.println("   R E G I S T R O  C A R R E R A  D E  C A B A L L O S");
        System.out.println("                           ---");
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Registrar Caballo en la carrera");
        System.out.println("2. Ganador de la carrera");
        System.out.println("3. Salir ");
        System.out.println("----------------------------------------------------------");
        menu = scann.nextInt();
        switch(menu){
            case 1:
                break;
            case 2:
                break;
            default:
               System.out.println("Ingrese una opcion correcta (1-3)");
               break;
        }
        }while(menu !=3);
    }
}
