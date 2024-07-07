
package Interface;

import Models.Venta;
import Models.Cliente;
import Models.Producto;
import java.util.ArrayList;

public interface Venta_Interface {
    public Cliente searchCliente(String dni);
    public Producto searchProduct(String codigo);
  //  public boolean registerVenta(Venta v);
    
    
}
