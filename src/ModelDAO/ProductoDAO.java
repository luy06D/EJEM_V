
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
        String atributos = "idproducto, nombreP, marca, modelo, precio, stock, tipo, garantia, create_at";
        try{
            String queryInsert = "INSERT INTO Productos (" +atributos+ " ) VALUES (?,?,?,?,?,?,?,?,?)";
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
            ps.setString(9, p.getCreate_at());
            
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
       return false;
    }

    @Override
    public boolean updateProduct(Producto p) {
         
        try{
              String queryUpdate = "UPDATE productos SET nombreP=?, marca=?, modelo=?, precio=?, stock=?,"
                      + " tipo=?, garantia=?  WHERE idproducto= "+p.getCodigo();

            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryUpdate);
           // ps.setString(1, p.getCodigo());
            ps.setString(1, p.getNombreP());
            ps.setString(2, p.getMarca());
            ps.setString(3, p.getModelo());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getTipo());
            ps.setString(7, p.getGarantia());
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
       return false;
       
    }

    @Override
    public boolean deleteProduct(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto listOne(String codigo) {
        try {
            String queryListOne = "SELECT * FROM productos where idproducto = "+codigo;
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryListOne);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new Producto();
                p.setCodigo(rs.getString("idproducto"));
                p.setNombreP(rs.getString("nombreP"));
                p.setMarca(rs.getString("marca"));
                p.setModelo(rs.getString("modelo"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setTipo(rs.getString("tipo"));
                p.setGarantia(rs.getString("garantia"));
                
            }
            connec.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public ArrayList<Producto> ListProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
