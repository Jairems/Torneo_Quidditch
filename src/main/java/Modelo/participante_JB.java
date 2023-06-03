package Modelo;

import java.io.Serializable;

public class participante_JB implements Serializable {
    private String curp;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private int campeonatos_jug;
    private int r_nacionalidad;
    private int edad;
    private float peso;
    private float altura;

    public participante_JB() {

    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public int getCampeonatos_jug() {
        return campeonatos_jug;
    }

    public void setCampeonatos_jug(int campeonatos_jug) {
        this.campeonatos_jug = campeonatos_jug;
    }

    public int getR_nacionalidad() {
        return r_nacionalidad;
    }

    public void setR_nacionalidad(int r_nacionalidad) {
        this.r_nacionalidad = r_nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
