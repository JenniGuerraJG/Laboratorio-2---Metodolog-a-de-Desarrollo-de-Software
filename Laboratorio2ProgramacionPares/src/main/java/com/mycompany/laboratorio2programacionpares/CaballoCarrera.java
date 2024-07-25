package com.mycompany.caballocarrera;

import java.util.ArrayList;
import java.util.Scanner;

public class CaballoCarrera {
    private int numero;
    private String tiempoCarrera; // formato "minutos:segundos:milisegundos"
    
    private static ArrayList<Caballo> caballosRegistrados = new ArrayList<>();
    private static ArrayList<CaballoCarrera> caballosEnCarrera = new ArrayList<>();

    public CaballoCarrera(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getTiempoCarrera() {
        return tiempoCarrera;
    }

    public void registrarTiempo() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Ingrese el tiempo del caballo numero " + numero + " (formato minutos:segundos:milisegundos):");
        tiempoCarrera = scann.nextLine();
        System.out.println("Tiempo registrado.");
    }

    public static void registrarCaballo() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Ingrese el nombre del caballo:");
        String nombre = scann.nextLine();
        System.out.println("Ingrese la edad del caballo:");
        int edad = scann.nextInt();
        scann.nextLine(); 
        System.out.println("Ingrese la raza del caballo:");
        String raza = scann.nextLine();
        System.out.println("Ingrese el sexo del caballo:");
        String sexo = scann.nextLine();
        System.out.println("Ingrese el color del caballo:");
        String color = scann.nextLine();
        System.out.println("Ingrese el nombre del propietario:");
        String propietario = scann.nextLine();
        System.out.println("Ingrese el numero del caballo:");
        int numero = scann.nextInt();
        scann.nextLine(); // Consumir el salto de línea
        Caballo nuevoCaballo = new Caballo(nombre, edad, raza, sexo, color, propietario, numero);
        caballosRegistrados.add(nuevoCaballo);
        caballosEnCarrera.add(new CaballoCarrera(numero));
    }

    public static void ingresarTiempo() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Ingrese el numero del caballo para registrar el tiempo:");
        int numeroTiempo = scann.nextInt();
        scann.nextLine(); // Consumir el salto de línea
        boolean encontrado = false;
        for (CaballoCarrera carrera : caballosEnCarrera) {
            if (carrera.getNumero() == numeroTiempo) {
                carrera.registrarTiempo();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Caballo no encontrado.");
        }
    }

    public static void mostrarGanador() {
        if (caballosEnCarrera.isEmpty()) {
            System.out.println("No hay caballos en la carrera.");
        } else {
            CaballoCarrera ganador = CaballoCarrera.calcularGanador(caballosEnCarrera);
            if (ganador != null) {
                Caballo caballoGanador = null;
                for (Caballo caballo : caballosRegistrados) {
                    if (caballo.getNumeroCaballo() == ganador.getNumero()) {
                        caballoGanador = caballo;
                        break;
                    }
                }
                System.out.println("El ganador es el caballo numero " + ganador.getNumero() + " de color " + (caballoGanador != null ? caballoGanador.getColorCaballo() : "desconocido") + " con un tiempo de: " + ganador.getTiempoCarrera());
            } else {
                System.out.println("No hay tiempos registrados.");
            }
        }
    }

    public static CaballoCarrera calcularGanador(ArrayList<CaballoCarrera> caballos) {
        CaballoCarrera ganador = null;
        long menorTiempo = Long.MAX_VALUE;

        for (CaballoCarrera caballo : caballos) {
            long tiempoEnMs = convertirATiempoEnMs(caballo.getTiempoCarrera());
            if (tiempoEnMs < menorTiempo) {
                menorTiempo = tiempoEnMs;
                ganador = caballo;
            }
        }
        return ganador;
    }

    private static long convertirATiempoEnMs(String tiempo) {
        String[] partes = tiempo.split(":");
        int minutos = Integer.parseInt(partes[0]);
        int segundos = Integer.parseInt(partes[1]);
        int milisegundos = Integer.parseInt(partes[2]);
        return (minutos * 60000) + (segundos * 1000) + milisegundos;
    }
}
