package Datos;

import Modelo.participante_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class participante_DAO extends Conexion{

    public boolean registrar(participante_JB partiJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO pais (Nombre, Continente, Cantidad_Clubes) VALUES (?,ROW(?,?,?),?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, partiJB.getCurp());
            ps.setString(2, partiJB.getNombre());
            ps.setString(3, partiJB.getAp_paterno());
            ps.setString(4, partiJB.getAp_materno());
            ps.setInt(5, partiJB.getCampeonatos_jug());
            ps.setInt(6, partiJB.getR_nacionalidad());
            ps.setInt(7, partiJB.getEdad());
            ps.setFloat(8, partiJB.getPeso());
            ps.setFloat(9, partiJB.getAltura());

            ps.execute();

            /*private int campeonatos_jug;
    private int r_nacionalidad;
    private int edad;
    private float peso;
    private float altura;*/
            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(participante_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String partiJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from participante where CURP = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(partiJB));


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

    public List<participante_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from participante";
        List<participante_JB> Allparticipante = new ArrayList<participante_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                participante_JB partiJB = new participante_JB();

                String curp = rs.getString(1);
                String nombre = rs.getString(2);
                String ap_paterno = rs.getString(3);
                String ap_materno = rs.getString(4);
                int campeonatos_play = rs.getInt(5);
                int r_nacionalidad = rs.getInt(6);
                int edad = rs.getInt(7);
                float peso = rs.getFloat(8);
                float altura = rs.getFloat(9);

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

                partiJB.setCurp(curp);
                partiJB.setNombre(nombre);
                partiJB.setAp_paterno(ap_paterno);
                partiJB.setAp_materno(ap_materno);
                partiJB.setCampeonatos_jug(campeonatos_play);
                partiJB.setR_nacionalidad(r_nacionalidad);
                partiJB.setEdad(edad);
                partiJB.setPeso(peso);
                partiJB.setAltura(altura);


                Allparticipante.add(partiJB);

            }
            close(rs);
            close(ps);
            close(con);



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Allpacientes.forEach(System.out::println);
        return Allparticipante;
    }

    public boolean modificar(participante_JB partiJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update participante set curp = ?, nombre = ROW(?,?,?), campeonatos_play = ?, r_nacionalidad = ?, edad = ?, peso = ?, altura = ? where id_p = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, partiJB.getCurp());
            ps.setString(2, partiJB.getNombre());
            ps.setString(3, partiJB.getAp_paterno());
            ps.setString(4, partiJB.getAp_materno());
            ps.setInt(5, partiJB.getCampeonatos_jug());
            ps.setInt(6, partiJB.getR_nacionalidad());
            ps.setInt(7, partiJB.getEdad());
            ps.setFloat(8, partiJB.getPeso());
            ps.setFloat(9, partiJB.getAltura());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entre al dao y realiza la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(participante_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
