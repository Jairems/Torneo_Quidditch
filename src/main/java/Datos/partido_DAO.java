package Datos;

//import Modelo.partido_JB;

import Modelo.partido_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class partido_DAO extends Conexion{
    public boolean registrar(partido_JB partidoJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO partido (r_ganador, r_estadio) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, partidoJB.getR_ganador());
            ps.setInt(2, partidoJB.getR_estadio());

            ps.execute();

            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(partido_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String partidoJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from partido where id_partido = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(partidoJB));


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(partido_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<partido_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from partido";
        List<partido_JB> Allpartidos = new ArrayList<partido_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                partido_JB partidoJB = new partido_JB();

                partidoJB.setR_ganador(rs.getInt(2));
                partidoJB.setR_estadio(rs.getInt(3));

                Allpartidos.add(partidoJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Allpartidos;
    }

    public boolean modificar(partido_JB partidoJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update partido set R_ganador, R_estadio where id_partido = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, partidoJB.getR_ganador());
            ps.setInt(2, partidoJB.getR_estadio());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(partido_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
