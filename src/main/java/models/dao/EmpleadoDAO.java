package models.dao;

import config.Conexion;
import models.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpleadoDAO {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Empleado> ListarTodos(){
        ArrayList<Empleado> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "select * from empleado";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Empleado obj = new Empleado();
                obj.setId(rs.getInt("id"));
                obj.setNombres(rs.getString("nombres"));
                obj.setApellidos(rs.getString("apellidos"));
                obj.setFechaIngreso(rs.getString("fecha_ingreso"));
                obj.setSueldo(rs.getDouble("sueldo"));
                lista.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    public int registrar(Empleado obj){
        int result = 0;

        try {
            cn = Conexion.getConnection();
            String sql = "insert into empleado(nombres, apellidos, fecha_ingreso, sueldo) values (?, ?, ?, ?)";
            ps = cn.prepareStatement(sql);

            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getFechaIngreso());
            ps.setDouble(4, obj.getSueldo());

            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public int actualizar(Empleado obj){
        int result = 0;

        try {
            cn = Conexion.getConnection();
            String sql = "update empleado set nombres = ? , apellidos = ?, fecha_ingreso = ?, sueldo = ? where id = ?";
            ps = cn.prepareStatement(sql);

            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getFechaIngreso());
            ps.setDouble(4, obj.getSueldo());
            ps.setInt(5, obj.getId());

            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }
}
