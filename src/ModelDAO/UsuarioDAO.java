
package ModelDAO;

import Models.Usuario;
import Connection.Conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.Usuario_Interface;
import java.util.ArrayList;

public class UsuarioDAO implements Usuario_Interface {
    
     Conexion conexion = new Conexion();
    Connection connec;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u;
  
    
    ArrayList<Usuario> vectorUsu = new ArrayList<>();

    @Override
    public Usuario login(String username, String password) {
        try{
            String queryValidar = "SELECT * FROM usuarios WHERE nom_user = ? AND claveacceso = ?";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryValidar);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                u = new Usuario();
                u.setIdusuario(rs.getString("idusuario"));
                u.setNom_user(rs.getString("nom_user"));
                u.setClaveacceso(rs.getString("claveacceso"));
            }  
            
        }catch(Exception e){
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return u;
  
    }

    @Override
    public boolean createUser(Usuario usuario) {
        
        try{
            String queryInsert = "INSERT INTO usuarios (nom_user, claveacceso) VALUES (?,?)";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryInsert);
            ps.setString(1, usuario.getNom_user());
            ps.setString(2, usuario.getClaveacceso());
         
            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
        
        return false;

    }

    @Override
    public boolean updateUser(Usuario usuario) {
        try{
              String queryUpdate = "UPDATE usuarios SET nom_user=?, claveacceso=? WHERE idusuario= "+u.getIdusuario();

            connec = conexion.getConexion();
            ps = connec.prepareStatement(queryUpdate);
            ps.setString(1, u.getNom_user());
            ps.setString(2, u.getClaveacceso());

            ps.executeUpdate();
            connec.close();
            
        }catch(Exception e){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
       return false;
    }

    @Override
    public boolean deleteUser(String idusuario) {
        try{
           String queryDelete = "DELETE FROM usuarios WHERE idusuario ="+ u.getIdusuario();
           connec = conexion.getConexion();
           ps = connec.prepareStatement(queryDelete);
           ps.executeUpdate();
           connec.close();
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e); 
        }
        
        return false;
    }

    @Override
    public Usuario listOne(String idusuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        try{
            String querySelect = "SELECT * FROM usuarios";
            connec = conexion.getConexion();
            ps = connec.prepareStatement(querySelect);
            rs = ps.executeQuery();
            
            while(rs.next()){
                u = new Usuario();
                u.setIdusuario(rs.getString("idusuario"));
                u.setNom_user(rs.getString("nom_user"));
                u.setClaveacceso(rs.getString("claveacceso"));
     
                vectorUsu.add(u);
            }
            
        }catch(Exception e){
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null , e);
        }
        
        return vectorUsu ;
    }
    
    
    
}
