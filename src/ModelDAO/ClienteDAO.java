
package ModelDAO;

import Connection.Conexion;
import Interface.Cliente_Interface;
import Models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements Cliente_Interface{
    Conexion conexion = new Conexion();
    Connection connec;
    PreparedStatement ps;
    ResultSet rs;
    Cliente cli;
    
     ArrayList<Cliente> vectorClient = new ArrayList<>();

    @Override
    public boolean crearCliente(Cliente cliente) {
        try{
            String queryInsert = "INSERT INTO clientes (nombre, dni, create_at) VALUES (?,?,?)";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryInsert);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            ps.setString(3, cliente.getCreate_at());
            
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
        
        return false;
     
    }

    @Override
    public Cliente listOne(String dni) {
        
           try{
            String queryInsert = "SELECT * FROM clientes WHERE dni = "+dni;
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryInsert);
            rs = ps.executeQuery();
            while(rs.next()){
                cli = new Cliente();
                cli.setNombre(rs.getString("nombre"));
                cli.setDni(rs.getString("dni"));
            }

            connec.close();
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
        
        return cli ;
       
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
           try{
            String queryUpdate = "UPDATE clientes SET nombre=?, dni=? WHERE dni="+cliente.getDni();
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryUpdate);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
        
        return false;
     
       
    }

    @Override
    public boolean eliminarCliente(String dni) {
             try{
                 
            String queryDelete = "DELETE FROM clientes WHERE  dni= "+cli.getDni();
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryDelete);
  
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
        
        return false;
 
    }

    @Override
    public ArrayList<Cliente> listarClientes() {
        try{
            String querySelect = "SELECT * FROM clientes";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(querySelect);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cli = new Cliente();
                cli.setNombre(rs.getString("nombre"));
                cli.setDni(rs.getString("dni"));
                cli.setCreate_at(rs.getString("create_at"));
                vectorClient.add(cli);
            }
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
        
        return vectorClient ;
        
    }
    
    
    
}
