package Modelo;

import java.io.Serializable;

public class equipo_JB implements Serializable {
    private int campeonatos_parti;
    private int copas_ganadas;
    private int cantidad_jugadores;
    private String jugada_especial;

    public equipo_JB() {
    }

    public int getCampeonatos_parti() {
        return campeonatos_parti;
    }

    public void setCampeonatos_parti(int campeonatos_parti) {
        this.campeonatos_parti = campeonatos_parti;
    }

    public int getCopas_ganadas() {
        return copas_ganadas;
    }

    public void setCopas_ganadas(int copas_ganadas) {
        this.copas_ganadas = copas_ganadas;
    }

    public int getCantidad_jugadores() {
        return cantidad_jugadores;
    }

    public void setCantidad_jugadores(int cantidad_jugadores) {
        this.cantidad_jugadores = cantidad_jugadores;
    }

    public String getJugada_especial() {
        return jugada_especial;
    }

    public void setJugada_especial(String jugada_especial) {
        this.jugada_especial = jugada_especial;
    }
}
