
package ModelDAO;

import Models.Producto;
import Connection.Conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.Producto_Interface;
import java.util.ArrayList;

public class ProductoDAO implements Producto_Interface{
    
    Conexion conexion = new Conexion();
    Connection connec;
    PreparedStatement ps;
    ResultSet rs;
    Producto p;
    ArrayList<Producto> vectorProduct = new ArrayList<>();
    
    

    @Override
    public boolean insertProduct(Producto p) {
        String atributos = "idproducto, nombreP, marca, modelo, precio, stock, tipo, garantia";
        try{
            String queryInsert = "INSERT INTO Productos (" +atributos+ " ) VALUES (?,?,?,?,?,?,?,?)";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryInsert);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombreP());
            ps.setString(3, p.getMarca());
            ps.setString(4, p.getModelo());
            ps.setDouble(5, p.getPrecio());
            ps.setInt(6, p.getStock());
            ps.setString(7, p.getTipo());
            ps.setString(8, p.getGarantia());
            
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
       return false;
    }

    @Override
    public boolean updateProduct(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteProduct(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto listOne(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> ListProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
