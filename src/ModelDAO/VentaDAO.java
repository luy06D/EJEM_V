
package ModelDAO;
import Interface.Venta_Interface;
import Models.Venta;
import Connection.Conexion;
import Models.Cliente;
import Models.Producto;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


public class VentaDAO implements Venta_Interface{
    
    Conexion conexion = new Conexion();
    Connection connec;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c;
    Producto p;
    
    

    @Override
    public Cliente searchCliente(String dni) {
        try{
            String searchClient = "SELECT * FROM clientes WHERE dni = "+dni;
           
            connec = conexion.getConexion();
            ps = connec.prepareStatement(searchClient);
            rs = ps.executeQuery();
            if(rs.next()){
                c = new Cliente();
                c.setIdcliente(rs.getString("idcliente"));
                c.setNombre(rs.getString("nombre"));
            }
            connec.close();
       
        }catch(Exception e){
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return c;
    }
    

    @Override
    public Producto searchProduct(String codigo) {
        try{
            String searchProduct = "SELECT * FROM productos WHERE idproducto ="+ codigo;
            
            connec = conexion.getConexion();
            ps = connec.prepareStatement(searchProduct);
            rs = ps.executeQuery();
            if(rs.next()){
                p = new Producto();
                p.setNombreP(rs.getString("nombreP"));
                p.setPrecio(Double.parseDouble(rs.getString("precio")));
                p.setStock(Integer.parseInt(rs.getString("stock")));
                
            }
            connec.close();
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return p;
    }



  
    
}
