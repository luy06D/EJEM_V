
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
    
    
    
}
