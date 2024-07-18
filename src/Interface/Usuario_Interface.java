
package Interface;
import Models.Usuario;
import java.util.ArrayList;

public interface Usuario_Interface {
    public Usuario login(String username, String password);
     public boolean createUser(Usuario usuario);
    public boolean updateUser(Usuario usuario);
    public boolean deleteUser(String idusuario);
    public Usuario listOne(String idusuario);
    public ArrayList<Usuario> listarUsuarios();
}
