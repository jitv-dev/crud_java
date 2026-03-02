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
                if (cn != null){
                    cn.close();
                }
                if (rs != null){
                    cn.close();
                }
                if (ps != null){
                    cn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
}
