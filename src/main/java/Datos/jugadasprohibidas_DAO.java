package Datos;

import Modelo.jugadasprohibidas_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jugadasprohibidas_DAO extends Conexion{
    public boolean registrar(jugadasprohibidas_JB jugadasJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO equipo (nombre, comentario, r_partido) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, jugadasJB.getNombre());
            ps.setString(2, jugadasJB.getComentario());
            ps.setInt(3, jugadasJB.getR_partido());

            ps.execute();

            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(jugadasprohibidas_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String jugadasJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from jugadas_prohibidas where id_jp = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jugadasJB));


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(jugadasprohibidas_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<jugadasprohibidas_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from jugadas_prohibidas";
        List<jugadasprohibidas_JB> Alljugadas = new ArrayList<jugadasprohibidas_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                jugadasprohibidas_JB jugadasJB = new jugadasprohibidas_JB();

                jugadasJB.setNombre(rs.getString(1));
                jugadasJB.setComentario(rs.getString(2));
                jugadasJB.setR_partido(rs.getInt(3));




                Alljugadas.add(jugadasJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Alljugadas;
    }

    public boolean modificar(jugadasprohibidas_JB jugadasJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update jugadas_prohibidas set Nombre, Comentario, R_partido  where id_e = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, jugadasJB.getNombre());
            ps.setString(2, jugadasJB.getComentario());
            ps.setInt(3, jugadasJB.getR_partido());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(jugadasprohibidas_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
