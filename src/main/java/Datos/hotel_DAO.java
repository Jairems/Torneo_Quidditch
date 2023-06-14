package Datos;

import Modelo.hotel_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hotel_DAO extends Conexion{
    public boolean registrar(hotel_JB hotelJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO equipo (RFC, nombre, direccion, tel) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, hotelJB.getRFC());
            ps.setString(2, hotelJB.getNombre());
            ps.setString(3, hotelJB.getDireccion());
            ps.setString(4, hotelJB.getTel());

            ps.execute();

            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(hotel_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String hotelJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from hotel where RFC = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, hotelJB);


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(hotel_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<hotel_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from hotel";
        List<hotel_JB> Allhoteles = new ArrayList<hotel_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                hotel_JB hotelJB = new hotel_JB();

                hotelJB.setRFC(rs.getString(1));
                hotelJB.setNombre(rs.getString(2));
                hotelJB.setDireccion(rs.getString(3));
                hotelJB.setTel(rs.getString(4));

                Allhoteles.add(hotelJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Allhoteles;
    }

    public boolean modificar(hotel_JB hotelJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update hotel set RFC = ?, nombre = ?, direccion = ?, tel = ?  where RFC = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, hotelJB.getRFC());
            ps.setString(2, hotelJB.getNombre());
            ps.setString(3, hotelJB.getDireccion());
            ps.setString(4, hotelJB.getTel());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(hotel_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
