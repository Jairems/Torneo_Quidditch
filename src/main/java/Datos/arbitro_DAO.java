package Datos;

import Modelo.arbitro_JB;
import Modelo.participante_JB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class arbitro_DAO extends Conexion{

    public boolean registrar(arbitro_JB arbiJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();
        System.out.println();

        String sql = "INSERT INTO pais (Curp, Nombre, Campeonatos_play, r_nacionalidad, edad, peso, altura, direccion, tel_contac) VALUES (?,ROW(?,?,?),?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, arbiJB.getCurp());
            ps.setString(2, arbiJB.getNombre());
            ps.setString(3, arbiJB.getAp_paterno());
            ps.setString(4, arbiJB.getAp_materno());
            ps.setInt(5, arbiJB.getCampeonatos_jug());
            ps.setInt(6, arbiJB.getR_nacionalidad());
            ps.setInt(7, arbiJB.getEdad());
            ps.setFloat(8, arbiJB.getPeso());
            ps.setFloat(9, arbiJB.getAltura());
            ps.setString(10, arbiJB.getDireccion());
            ps.setString(11, arbiJB.getTel_contac());

            ps.execute();


            close(ps);
            close(con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(arbitro_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar_PorUser(String arbiJB) {
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "delete from arbitro where CURP = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(arbiJB));


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

    public List<arbitro_JB> SelectAll (){
        PreparedStatement ps= null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from participante";
        List<arbitro_JB> Allparticipante = new ArrayList<arbitro_JB>();

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                arbitro_JB arbiJB = new arbitro_JB();

                String curp = rs.getString(1);
                String nombre = rs.getString(2);
                String ap_paterno = rs.getString(3);
                String ap_materno = rs.getString(4);
                int campeonatos_play = rs.getInt(5);
                int r_nacionalidad = rs.getInt(6);
                int edad = rs.getInt(7);
                float peso = rs.getFloat(8);
                float altura = rs.getFloat(9);
                String direccion = rs.getString(10);
                String tel_contac = rs.getString(11);


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

                arbiJB.setCurp(curp);
                arbiJB.setNombre(nombre);
                arbiJB.setAp_paterno(ap_paterno);
                arbiJB.setAp_materno(ap_materno);
                arbiJB.setCampeonatos_jug(campeonatos_play);
                arbiJB.setR_nacionalidad(r_nacionalidad);
                arbiJB.setEdad(edad);
                arbiJB.setPeso(peso);
                arbiJB.setAltura(altura);
                arbiJB.setDireccion(direccion);
                arbiJB.setTel_contac(tel_contac);


                Allparticipante.add(arbiJB);

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

    public boolean modificar(arbitro_JB arbiJB){
        PreparedStatement ps= null;
        Connection con = getConexion();

        String sql = "update arbitro set curp = ?, nombre = ROW(?,?,?), campeonatos_play = ?, r_nacionalidad = ?, edad = ?, peso = ?, altura = ?, direccion = ?, tel_contac = ? where curp = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, arbiJB.getCurp());
            ps.setString(2, arbiJB.getNombre());
            ps.setString(3, arbiJB.getAp_paterno());
            ps.setString(4, arbiJB.getAp_materno());
            ps.setInt(5, arbiJB.getCampeonatos_jug());
            ps.setInt(6, arbiJB.getR_nacionalidad());
            ps.setInt(7, arbiJB.getEdad());
            ps.setFloat(8, arbiJB.getPeso());
            ps.setFloat(9, arbiJB.getAltura());
            ps.setString(10, arbiJB.getDireccion());
            ps.setString(11, arbiJB.getTel_contac());

            ps.execute();

            close(ps);
            close(con);
            System.out.println("Entré al dao y realizé la modificación");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(participante_JB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
