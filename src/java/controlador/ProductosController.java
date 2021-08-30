/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CategoriaDao;
import dao.ProductosDao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import modelo.Categoria;
import modelo.Producto;

/**
 *
 * @author Alejandra Centeno
 */
public class ProductosController {
    
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Conexion c = new Conexion();
        ProductosDao pd = new ProductosDao(c);
        CategoriaDao ctd = new CategoriaDao(c);
        
        Producto p = new Producto(0);
        
        //// INSERTAR
        
        p.getId_prod();
        
        System.out.println("Ingrese Nombre del Producto: ");
        p.setNombre(scan.nextLine());
        
        System.out.println("Ingrese fecha de vencimiento (Ejemplo de formato: 2021-02-12)");
        p.setFechaVence(Date.valueOf(scan.nextLine()));
        
        System.out.println("Precio: ");
        p.setPrecio(scan.nextDouble());
        
        System.out.println("Stock: ");
        p.setStock(scan.nextInt());
        
        System.out.println("Ingrese el codigo de categoria: ");
        for(Categoria ca: ctd.ListAll()){
            
            System.out.println("Codigo: " + ca.getIdCate()+ " - " + ca.getNombre_cate());
        }
        p.setCategoria(scan.nextInt());
        
        boolean r = pd.insert(p);
        
        if(r){
            System.out.println("Insertado correctamente");
        }else{
            System.err.println("Problemas al insertar");
        }
       
       
//       //----------- LISTAR TODO -----------
//       for(Producto producto: pd.listAll()){
//           System.out.println("id   |  Nombre   |   Caducidad   |   precio  |   stock   | idCategoria  | Categoria");
//           System.out.println("-----------------------------------------------------------------------------------------");
//           System.out.println(producto.getId_prod()+ "     | " + producto.getNombre() + "   |  " + producto.getFechaVence() + "   |    " + producto.getPrecio() +  "    |   " + producto.getStock()+ "   |   " + producto.getCategoria() + "    |   " + producto.getNombreCat());
//        }


//        //------- BUSQUEDA POR ID -----------
//        System.out.println("Ingrese id de producto: ");
//        p.setId_prod(scan.nextInt());
//        
//        System.out.println(pd.SelectById(p.getId_prod()));
//        
//        for(Producto producto: pd.SelectById(p.getId_prod())){
//            System.out.println("id: " + producto.getId_prod());
//            System.out.println("Nombre:" + producto.getNombre());
//            System.out.println("Caducidad: " + producto.getFechaVence());
//            System.out.println("Precio: " + producto.getPrecio());
//            System.out.println("Stock: " + producto.getStock());
//        }
            

    }
    
}
