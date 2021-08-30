package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Categoria;
import modelo.Producto;

/**
 *
 * @author Alejandra Centeno
 */
public class ProductosDao {
    Conexion conn;
    
    public ProductosDao(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insert(Producto producto){
        
        String sql = "INSERT INTO producto VALUES(?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, producto.getId_prod());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4,producto.getStock());
            ps.setInt(5, producto.getCategoria());
            ps.setDate(6, producto.getFechaVence());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public List<Producto> listAll() throws SQLException{
        
        List<Producto> productos = new LinkedList<>();
        Producto p;
 
        String sql = "select p.idProducto, p.nombre_producto, p.precio, p.stock, p.id_categoria, cat.nombre_categoria, p.fecha_caducidad from compras.producto p inner join categoria cat where p.id_categoria = cat.idCategoria";
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                p = new Producto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre_producto"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCategoria(rs.getInt("id_categoria"));
                p.setNombreCat(rs.getString("nombre_categoria"));
                p.setFechaVence(rs.getDate("fecha_caducidad"));
                productos.add(p);
            }
            
            return productos;
        }catch(SQLException e ){
            System.err.println(" Excepcion " + e );
            return null;
        }
    }
    
    public List<Producto> SelectById(int id) throws SQLException{
        String sql = "select p.idProducto, p.nombre_producto, p.precio, p.stock, c.nombre_categoria, p.fecha_caducidad from compras.producto p inner join categoria c on p.id_categoria = c.idCategoria where p.idProducto = ?";
        
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Producto p;
            Categoria c;
            
            List<Producto> productos = new LinkedList<>();
            while(rs.next()){
                p = new Producto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre_producto"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setNombreCat(rs.getString("nombre_categoria"));
                p.setFechaVence(rs.getDate("fecha_caducidad"));
                productos.add(p);
            }
            return productos;
        } catch(Exception e){
            return null;
        }
    }
}
