package Datos;

import Modelo.estadio_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class estadio_DAO extends Conexion{
    public boolean registrar(estadio_JB estadioJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO estadio (capacidad, r_hotel) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estadioJB.getCapacidad());
            ps.setInt(2, estadioJB.getR_hotel());


            ps.execute();

            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(estadio_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String estadioJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from estadio where id_estd = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(estadioJB));


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(estadio_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<estadio_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from estadio";
        List<estadio_JB> Allestadios = new ArrayList<estadio_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                estadio_JB estadioJB = new estadio_JB();

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

                estadioJB.setCapacidad(rs.getInt(1));
                estadioJB.setR_hotel(rs.getInt(2));



                Allestadios.add(estadioJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Allestadios;
    }

    public boolean modificar(estadio_JB estadioJb){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update estadio set capacidad = ?, r_hotel = ?, where id_estd = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estadioJb.getCapacidad());
            ps.setInt(2, estadioJb.getR_hotel());


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(estadio_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
