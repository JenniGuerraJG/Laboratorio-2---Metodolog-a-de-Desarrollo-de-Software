
package com.mycompany.laboratorio2programacionpares;

public class Caballo implements metodosRegistrar {
    public String nombreCaballo;
    public int edadCaballo;
    public String razaCaballo;
    public String sexoCaballo;
    public String colorCaballo;
    public String propietarioCaballo;

    public Caballo(String nombreCaballo, int edadCaballo, String razaCaballo, String sexoCaballo, String colorCaballo, String propietarioCaballo) {
        this.nombreCaballo = nombreCaballo;
        this.edadCaballo = edadCaballo;
        this.razaCaballo = razaCaballo;
        this.sexoCaballo = sexoCaballo;
        this.colorCaballo = colorCaballo;
        this.propietarioCaballo = propietarioCaballo;
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

    @Override
    public void registro() {
       
    }

    @Override
    public void mostrarDetalles() {
        
    }
    
    
    
}
