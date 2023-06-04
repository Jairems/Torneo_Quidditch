package Modelo;

public class jugador_JB extends participante_JB {
    private int nivel_juego;
    private int equipo_pertenece;
    private int r_posicion;
    //private int r_equipo;

    public jugador_JB() {
    }

    public int getNivel_juego() {
        return nivel_juego;
    }

    public void setNivel_juego(int nivel_juego) {
        this.nivel_juego = nivel_juego;
    }

    public int getEquipo_pertenece() {
        return equipo_pertenece;
    }

    public void setEquipo_pertenece(int equipo_pertenece) {
        this.equipo_pertenece = equipo_pertenece;
    }

    public int getR_posicion() {
        return r_posicion;
    }

    public void setR_posicion(int r_posicion) {
        this.r_posicion = r_posicion;
    }
}
