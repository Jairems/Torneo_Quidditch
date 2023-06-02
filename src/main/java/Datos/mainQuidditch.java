package Datos;

import Modelo.pais_JB;

public class mainQuidditch {
    public static void main(String[] args) {
        pais_JB paisJB = new pais_JB();
        pais_DAO paisDAO = new pais_DAO();

        Conexion conn = new Conexion();
        conn.getConexion();

        paisJB.setNombre("EEUU");
        paisJB.setContinente("Andoniano");
        paisJB.setCantidad_clubes(4);

        paisDAO.registrar(paisJB);

        System.out.println(paisJB.getNombre());
    }
}
