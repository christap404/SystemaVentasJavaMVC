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
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    //OPERACIONES CRUD
    public List listar() {
        String sql = "Select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(3));
                pr.setPrecio(rs.getDouble(2));              
                pr.setStock(rs.getInt(4));
                pr.setEst(rs.getString(5));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Producto pr) {
        String sql = "insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setDouble(2, Double.valueOf(pr.getPrecio()));
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getEst());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Producto listarId(int id) {
        Producto pr = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEst(rs.getString(5));      
            }
        } catch (Exception e) {
        }
        return pr;
    }

    public int actualizar(Producto pr) {
        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setString(2, Double.toString(pr.getPrecio()));
            ps.setString(3, Integer.toString(pr.getStock()));
            ps.setString(4, pr.getEst());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.getConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
