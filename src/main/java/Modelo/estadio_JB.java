package Modelo;

import java.io.Serializable;

public class estadio_JB implements Serializable {
    private int capacidad;
    private int r_hotel;

    public estadio_JB() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getR_hotel() {
        return r_hotel;
    }

    public void setR_hotel(int r_hotel) {
        this.r_hotel = r_hotel;
    }
}
