package Datos;

import Modelo.posicion_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class posicion_DAO extends Conexion{
    public boolean registrar(posicion_JB posicionJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO posicion (nombre, descripcion) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, posicionJB.getNombre_pos());
            ps.setString(2, posicionJB.getDescripcion());

            ps.execute();

            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(posicion_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String posicionJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from posicion where id_pos = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(posicionJB));


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(posicion_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<posicion_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from posicion";
        List<posicion_JB> Allposiciones = new ArrayList<posicion_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                posicion_JB posicionJB = new posicion_JB();

                posicionJB.setNombre_pos(rs.getString(2));
                posicionJB.setDescripcion(rs.getString(3));

                Allposiciones.add(posicionJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Allposiciones;
    }

    public boolean modificar(posicion_JB posicionJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update posicion set Nombre = ?, Descripcion = ? where id_pos = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, posicionJB.getNombre_pos());
            ps.setString(2, posicionJB.getDescripcion());
            ps.setInt(3, Integer.parseInt(posicionJB.getID()));

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(posicion_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
