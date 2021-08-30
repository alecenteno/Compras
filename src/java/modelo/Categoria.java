package modelo;

/**
 *
 * @author Alejandra Centeno
 */
public class Categoria {
    
    public int idCate;
    public String nombre_cate;
    public String descripcion;

    public Categoria(int id) {
        this.idCate = id;
    }

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public String getNombre_cate() {
        return nombre_cate;
    }

    public void setNombre_cate(String nombre_cate) {
        this.nombre_cate = nombre_cate;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
