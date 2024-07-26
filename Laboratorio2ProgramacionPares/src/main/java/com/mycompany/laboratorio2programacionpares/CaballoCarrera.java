package com.mycompany.laboratorio2programacionpares;

import java.util.ArrayList;
import java.util.Scanner;

public class CaballoCarrera {
    private int numero;
    private String tiempoCarrera;

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
        boolean tiempoValido = false;

        while (!tiempoValido) {
            System.out.println("Ingrese el tiempo del caballo número " + numero + " (en formato minutos:segundos:milisegundos):");
            tiempoCarrera = scann.nextLine();

            if (tiempoCarrera.matches("\\d{1,2}:\\d{1,2}:\\d{1,3}")) {
                tiempoValido = true;
                System.out.println("Tiempo registrado.");
            } else {
                System.out.println("Formato de tiempo inválido, ingrese el tiempo en el formato correcto (1:30:500).");
            }
        }
    }

    public static void registrarCaballo() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Ingrese el nombre del caballo:");
        String nombre = scann.nextLine();
        while (nombre.isEmpty() || !nombre.matches("[a-zA-Z ]+")) {
            System.out.println("Nombre invalido, ingrese el nombre del caballo usando solo letras:");
            nombre = scann.nextLine();
        }
        int edad = 0;
        while (true) {
            System.out.println("Ingrese la edad del caballo:");
            try {
                edad = Integer.parseInt(scann.nextLine());
                if (edad <= 0 || edad > 60) {
                    System.out.println("La edad debe ser un numero positivo y no mayor a 60.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida, ingrese un numero entero para la edad.");
            }
        }
        System.out.println("Ingrese la raza del caballo:");
        String raza = scann.nextLine();
        while (raza.isEmpty()) {
            System.out.println("La raza esta vacia, ingrese la raza del caballo:");
            raza = scann.nextLine();
        }
        System.out.println("Ingrese el sexo del caballo (Macho/Hembra):");
        String sexo = scann.nextLine();
        while (!sexo.equalsIgnoreCase("Macho") && !sexo.equalsIgnoreCase("Hembra")) {
            System.out.println("Entrada inválida, ingrese el sexo del caballo (Macho/Hembra):");
            sexo = scann.nextLine();
        }
        System.out.println("Ingrese el color del caballo:");
        String color = scann.nextLine();
        while (color.isEmpty() || !color.matches("[a-zA-Z ]+")) {
            System.out.println("Campo invalido, ingrese el color del caballo usando solo letras:");
            color = scann.nextLine();
        }
        System.out.println("Ingrese el nombre del propietario:");
        String propietario = scann.nextLine();
        while (propietario.isEmpty() || !propietario.matches("[a-zA-Z ]+")) {
            System.out.println("Nombre invalido, ingrese el nombre del propietario usando solo letras:");
            propietario = scann.nextLine();
        }
        int numero = 0;
        while (true) {
            System.out.println("Ingrese el numero del caballo:");
            try {
                numero = Integer.parseInt(scann.nextLine());
                if (numero <= 0) {
                    System.out.println("El numero debe ser positivo.");
                } else {
                    boolean numeroExiste = false;
                    for (Caballo caballo : caballosRegistrados) {
                        if (caballo.getNumeroCaballo() == numero) {
                            numeroExiste = true;
                            break;
                        }
                    }
                    if (numeroExiste) {
                        System.out.println("El numero de caballo ya existe, ingrese uno nuevo.");
                    } else {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero entero para el numero del caballo.");
            }
        }

        Caballo nuevoCaballo = new Caballo(nombre, edad, raza, sexo, color, propietario, numero);
        caballosRegistrados.add(nuevoCaballo);
        caballosEnCarrera.add(new CaballoCarrera(numero));
        System.out.println("Caballo registrado exitosamente.");
    }

    public static void ingresarTiempo() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Ingrese el numero del caballo para registrar el tiempo:");
        int numeroTiempo = 0;
        while (true) {
            try {
                numeroTiempo = Integer.parseInt(scann.nextLine());
                if (numeroTiempo <= 0) {
                    System.out.println("Por favor, ingrese un número positivo para el numero del caballo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero entero para el numero del caballo.");
            }
        }

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
            if (caballo.getTiempoCarrera() != null) {
                long tiempoEnMs = convertirATiempoEnMs(caballo.getTiempoCarrera());
                if (tiempoEnMs < menorTiempo) {
                    menorTiempo = tiempoEnMs;
                    ganador = caballo;
                }
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