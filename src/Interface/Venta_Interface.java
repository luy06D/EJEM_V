
package Interface;

import Models.Venta;
import Models.Cliente;
import Models.Producto;
import Models.DetalleVenta;
import Models.Pagos;
import java.util.ArrayList;

public interface Venta_Interface {
    public Cliente searchCliente(String dni);
    public int registerVenta(Venta v);
    public boolean registerDetalle(DetalleVenta dv);
    public boolean registerPagos(Pagos p);
    
    
}
