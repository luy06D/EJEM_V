
package Interface;
import Models.Producto;
import java.util.ArrayList;

public interface Producto_Interface {
    public boolean insertProduct(Producto p);
    public boolean updateProduct(Producto p);
    public boolean deleteProduct(String codigo);
    public Producto listOne (String codigo);
    public ArrayList<Producto> ListProduct();
    
}
