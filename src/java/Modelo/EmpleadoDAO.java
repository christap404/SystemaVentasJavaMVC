/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=?";
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setNom(rs.getNString("Nombres"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
            }
        } catch (Exception e) {
        }
        return em;
    }

    //OPERACIONES CRUD
    public List listar() {
        String sql = "Select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(5));
                em.setEstado(rs.getString(4));

                em.setUser(rs.getString(6));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Empleado em) {
        String sql = "insert into empleado(Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Empleado listarId(int id) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));

                em.setUser(rs.getString(6));

            }
        } catch (Exception e) {
        }
        return em;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());

            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
