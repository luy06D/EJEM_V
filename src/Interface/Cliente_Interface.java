
package Interface;
import Models.Cliente;
import java.util.ArrayList;

public interface Cliente_Interface {
    
    public boolean crearCliente(Cliente cliente);
    public boolean actualizarCliente(Cliente cliente);
    public boolean eliminarCliente(String idcliente);
    public Cliente listOne(String idcliente);
    public ArrayList<Cliente> listarClientes();
    
}
