package Modelo;

import java.io.Serializable;
import java.util.SplittableRandom;

public class jugadasprohibidas_JB implements Serializable {
    private String nombre;
    private String comentario;
    private int r_partido;

    public jugadasprohibidas_JB() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getR_partido() {
        return r_partido;
    }

    public void setR_partido(int r_partido) {
        this.r_partido = r_partido;
    }
}
