package Modelo;

import java.io.Serializable;

public class pais_JB implements Serializable {
    private int ID_P;
    private String nombre;
    private String continente;
    private int cantidad_clubes;

    public pais_JB() {
    }

    public int getID_P(String string) {
        return ID_P;
    }

    public void setID_P(int ID_P) {
        this.ID_P = ID_P;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getCantidad_clubes() {
        return cantidad_clubes;
    }

    public void setCantidad_clubes(int cantidad_clubes) {
        this.cantidad_clubes = cantidad_clubes;
    }
}



