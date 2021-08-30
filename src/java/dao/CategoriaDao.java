/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Categoria;

/**
 *
 * @author Alejandra Centeno
 */
public class CategoriaDao {
    Conexion conn;
    
    public CategoriaDao(Conexion conn){
        this.conn = conn;
    }
    
    public List<Categoria> ListAll() throws SQLException{
        
        List<Categoria> categorias = new LinkedList<>();
        Categoria cate;
        
        String sql = "SELECT * FROM categoria";
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                cate = new Categoria(rs.getInt("idCategoria"));
                cate.setNombre_cate(rs.getString("nombre_categoria"));
                cate.setDescripcion(rs.getString("descripcion"));
                categorias.add(cate);
                
            }
            
            return categorias;
        }catch(Exception e ){
            System.err.println(" Excepcion " + e );
            return null;
        }
        
    }
    
}
