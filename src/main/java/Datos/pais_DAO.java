package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.pais_JB;
public class pais_DAO extends Conexion{

    //segmento de código para poder hacer un registro en la BD
    public boolean registrar(pais_JB pais_d) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO pais (Nombre, Continente, Cantidad_Clubes) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais_d.getNombre());
            ps.setString(2, pais_d.getContinente());
            ps.setInt(3, pais_d.getCantidad_clubes());

            ps.execute();

            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(pais_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String pais_d) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        //String sql = "delete from citas where (pacientes.nombre).NomComp = ? AND (pacientes.nombre).Paterno = ? AND (pacientes.nombre).Materno = ?";

        String sql = "delete from pais where ID_P=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(pais_d));


            ps.execute();

            close(ps);
            close(con);
            System.out.println("Eliminado con exito");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(pais_JB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no eliminado");
            return false;
        }
    }

    public List<pais_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from pais";
        List<pais_JB> Allpacientes = new ArrayList<pais_JB>();
        //Pacientes_JB paci = new Pacientes_JB();


        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                pais_JB pais = new pais_JB();

                pais.getID_P(rs.getString(1));
                String nombre = rs.getString(2);
                String continente = rs.getString(3);
                int cantidad_club = 0;

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

                pais.setNombre(nombre);
                pais.setContinente(continente);
                pais.setCantidad_clubes(cantidad_club);


                Allpacientes.add(pais);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Allpacientes;
    }

    public boolean modificar(pais_JB pais){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update pais set nombre = ?, continente = ? , cantidad_clubes = ? where id_p = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            ps.setString(2, pais.getContinente());
            ps.setInt(3, pais.getCantidad_clubes());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(pais_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
