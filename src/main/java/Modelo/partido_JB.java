package Modelo;

import java.io.Serializable;

public class partido_JB implements Serializable {
    private int r_ganador;
    private int r_estadio;

    public partido_JB() {
    }

    public int getR_ganador() {
        return r_ganador;
    }

    public void setR_ganador(int r_ganador) {
        this.r_ganador = r_ganador;
    }

    public int getR_estadio() {
        return r_estadio;
    }

    public void setR_estadio(int r_estadio) {
        this.r_estadio = r_estadio;
    }
}
