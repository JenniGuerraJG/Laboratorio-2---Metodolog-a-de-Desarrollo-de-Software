package com.mycompany.laboratorio2programacionpares;

public class Caballo implements metodosRegistrar {
    private String nombreCaballo;
    private int edadCaballo;
    private String razaCaballo;
    private String sexoCaballo;
    private String colorCaballo;
    private String propietarioCaballo;
    private int numeroCaballo;

    public Caballo(String nombreCaballo, int edadCaballo, String razaCaballo, String sexoCaballo, String colorCaballo, String propietarioCaballo, int numeroCaballo) {
        this.nombreCaballo = nombreCaballo;
        this.edadCaballo = edadCaballo;
        this.razaCaballo = razaCaballo;
        this.sexoCaballo = sexoCaballo;
        this.colorCaballo = colorCaballo;
        this.propietarioCaballo = propietarioCaballo;
        this.numeroCaballo = numeroCaballo;
    }

    public String getNombreCaballo() {
        return nombreCaballo;
    }

    public void setNombreCaballo(String nombreCaballo) {
        this.nombreCaballo = nombreCaballo;
    }

    public int getEdadCaballo() {
        return edadCaballo;
    }

    public void setEdadCaballo(int edadCaballo) {
        this.edadCaballo = edadCaballo;
    }

    public String getRazaCaballo() {
        return razaCaballo;
    }

    public void setRazaCaballo(String razaCaballo) {
        this.razaCaballo = razaCaballo;
    }

    public String getSexoCaballo() {
        return sexoCaballo;
    }

    public void setSexoCaballo(String sexoCaballo) {
        this.sexoCaballo = sexoCaballo;
    }

    public String getColorCaballo() {
        return colorCaballo;
    }

    public void setColorCaballo(String colorCaballo) {
        this.colorCaballo = colorCaballo;
    }

    public String getPropietarioCaballo() {
        return propietarioCaballo;
    }

    public void setPropietarioCaballo(String propietarioCaballo) {
        this.propietarioCaballo = propietarioCaballo;
    }

    public int getNumeroCaballo() {
        return numeroCaballo;
    }

    public void setNumeroCaballo(int numeroCaballo) {
        this.numeroCaballo = numeroCaballo;
    }

    @Override
    public void registro() {
        // Implementación del método registro
    }

    @Override
    public void mostrarDetalles() {
        // Implementación del método mostrarDetalles
    }
}