
package ModelDAO;
import Interface.Venta_Interface;
import Models.Venta;
import Connection.Conexion;
import Models.Cliente;
import Models.DetalleVenta;
import Models.Pagos;
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
    Venta v;
    DetalleVenta dv;
    Pagos p;

    

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
    public int registerVenta(Venta v) {
         int idVenta = 0 ;
         
        String queryInsert = "INSERT INTO ventas (idcliente, fecha_venta, num_venta, tipocomprobante) VALUES (?,?,?,?)";
    
        try (Connection connec = conexion.getConexion();
             PreparedStatement ps = connec.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, v.getIdcliente());
            ps.setString(2, v.getFecha_venta());
            ps.setInt(3, v.getNumVenta());
            ps.setString(4, v.getTipoComprobante());
            ps.executeUpdate();
        
           // connec.close();
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idVenta = generatedKeys.getInt(1);
                }
        }
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
       return idVenta;
    }

    @Override
    public boolean registerDetalle(DetalleVenta dv) {
        try{
            String queryInsertDetalle = "INSERT INTO detalle_ventas (idproducto, idventa, cantidad, precio_venta) VALUES (?,?,?,?)";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryInsertDetalle);
            ps.setString(1, dv.getIdproducto());
            ps.setString(2, dv.getIdventa());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecio_venta());

            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
       return false;
        
    }

    @Override
    public boolean registerPagos(Pagos p) {
           try{
            String queryInsertPgo = "INSERT INTO pagos(idventa, tipopago, fecha_pago) VALUES (?,?,?)";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryInsertPgo);
            ps.setString(1, p.getIdventa());
            ps.setString(2, p.getTipoPago());
            ps.setString(3, p.getFechaPago());
     
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
       return false;
       
    }
    




  
    
}
