package Datos;

import Modelo.equipo_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class equipo_DAO extends Conexion{
    public boolean registrar(equipo_JB equipoJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO equipo (Campeonatos_parti, Copas_ganadas, Cantidad_jugadores, Jugada_especial) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipoJB.getCampeonatos_parti());
            ps.setInt(2, equipoJB.getCopas_ganadas());
            ps.setInt(3, equipoJB.getCantidad_jugadores());
            ps.setString(4, equipoJB.getJugada_especial());

            ps.execute();

            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(equipo_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String equipoJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from equipo where id_e = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(equipoJB));


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(equipo_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<equipo_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from equipo";
        List<equipo_JB> Allequipos = new ArrayList<equipo_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                equipo_JB equipoJB = new equipo_JB();

                //String id = rs.getString(1);
                int campeonatos_parti = rs.getInt(2);
                int copas_ganadas = rs.getInt(3);
                int cantidad_jugadores = rs.getInt(4);
                String jugada_especial = rs.getString(5);

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

                equipoJB.setCampeonatos_parti(campeonatos_parti);
                equipoJB.setCopas_ganadas(copas_ganadas);
                equipoJB.setCantidad_jugadores(cantidad_jugadores);
                equipoJB.setJugada_especial(jugada_especial);



                Allequipos.add(equipoJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Allequipos;
    }

    public boolean modificar(equipo_JB equipoJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update equipo set campeonatos_parti = ?, copas_ganadas = ?, cantidad_jugadores = ?, jugada_especial = ?  where id_e = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipoJB.getCampeonatos_parti());
            ps.setInt(2, equipoJB.getCopas_ganadas());
            ps.setInt(3, equipoJB.getCantidad_jugadores());
            ps.setString(4, equipoJB.getJugada_especial());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(equipo_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
