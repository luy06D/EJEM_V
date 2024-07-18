
package Models;

public class DetalleVenta {
    private String iddetalleV;
    private String idproducto;
    private String idventa;
    private int cantidad;
    private double precio_venta;

    public String getIddetalleV() {
        return iddetalleV;
    }

    public void setIddetalleV(String iddetalleV) {
        this.iddetalleV = iddetalleV;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getIdventa() {
        return idventa;
    }

    public void setIdventa(String idventa) {
        this.idventa = idventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
}
