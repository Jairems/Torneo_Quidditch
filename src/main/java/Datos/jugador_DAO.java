package Datos;

import Modelo.arbitro_JB;
import Modelo.jugador_JB;
import Modelo.participante_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jugador_DAO extends Conexion{
    public boolean registrar(jugador_JB jugadorJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO jugador (Curp, Nombre, Campeonatos_play, r_nacionalidad, edad, peso, altura, nivel_juego, equipo_pertenece, r_posicion) VALUES (?,ROW(?,?,?),?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, jugadorJB.getCurp());
            ps.setString(2, jugadorJB.getNombre());
            ps.setString(3, jugadorJB.getAp_paterno());
            ps.setString(4, jugadorJB.getAp_materno());
            ps.setInt(5, jugadorJB.getCampeonatos_jug());
            ps.setInt(6, jugadorJB.getR_nacionalidad());
            ps.setInt(7, jugadorJB.getEdad());
            ps.setFloat(8, jugadorJB.getPeso());
            ps.setFloat(9, jugadorJB.getAltura());
            ps.setInt(10, jugadorJB.getNivel_juego());
            ps.setInt(11, jugadorJB.getEquipo_pertenece());
            ps.setInt(12, jugadorJB.getR_posicion());

            ps.execute();


            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(jugador_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


    }

    public boolean eliminar_PorUser(String jugadorJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from jugador where CURP = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jugadorJB));


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(participante_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<jugador_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from jugador";
        List<jugador_JB> Alljugador = new ArrayList<jugador_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                jugador_JB jugadorJB = new jugador_JB();

                //String curp = rs.getString(1);
                String nombre = rs.getString(2);
                String ap_paterno = rs.getString(3);
                String ap_materno = rs.getString(4);
                int campeonatos_play = rs.getInt(5);
                int r_nacionalidad = rs.getInt(6);
                int edad = rs.getInt(7);
                float peso = rs.getFloat(8);
                float altura = rs.getFloat(9);
                int nivel_juego = rs.getInt(10);
                int equipo_pertenece = rs.getInt(11);
                int r_posicion = rs.getInt(12);


                /*int iaux = 0;

                for (int i = 0; i < rs.getString(2).length(); i++) {
                    // System.out.println("For valor: "+ i);
                    if ((nombre.charAt(i) == ',') && iaux != 0){
                        apellido_p += nombre.substring(iaux, i);
                        apellido_m += nombre.substring(i+1, nombre.length()-1);
                        break;
                    }

                    if ((nombre.charAt(i) == ',') && iaux == 0){
                        nombreA += rs.getString(2).substring(1, i);
                        // nombre = nombre.substring(i + 1, nombre.length() - 1);
                        iaux = i+1;
                    }
                }*/

                jugadorJB.setCurp(jugadorJB.getCurp());
                jugadorJB.setNombre(nombre);
                jugadorJB.setAp_paterno(ap_paterno);
                jugadorJB.setAp_materno(ap_materno);
                jugadorJB.setCampeonatos_jug(campeonatos_play);
                jugadorJB.setR_nacionalidad(r_nacionalidad);
                jugadorJB.setEdad(edad);
                jugadorJB.setPeso(peso);
                jugadorJB.setAltura(altura);
                jugadorJB.setNivel_juego(nivel_juego);
                jugadorJB.setEquipo_pertenece(equipo_pertenece);
                jugadorJB.setR_posicion(r_posicion);


                Alljugador.add(jugadorJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Alljugador;
    }

    public boolean modificar(jugador_JB jugadorJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update jugador set curp = ?, nombre = ROW(?,?,?), campeonatos_play = ?, r_nacionalidad = ?, edad = ?, peso = ?, altura = ?, direccion = ?, tel_contac = ? where jugador = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, jugadorJB.getCurp());
            ps.setString(2, jugadorJB.getNombre());
            ps.setString(3, jugadorJB.getAp_paterno());
            ps.setString(4, jugadorJB.getAp_materno());
            ps.setInt(5, jugadorJB.getCampeonatos_jug());
            ps.setInt(6, jugadorJB.getR_nacionalidad());
            ps.setInt(7, jugadorJB.getEdad());
            ps.setFloat(8, jugadorJB.getPeso());
            ps.setFloat(9, jugadorJB.getAltura());
            ps.setInt(10, jugadorJB.getNivel_juego());
            ps.setInt(11, jugadorJB.getEquipo_pertenece());
            ps.setInt(12, jugadorJB.getR_posicion());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realizé la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(participante_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
