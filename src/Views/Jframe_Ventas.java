
package Views;

import ModelDAO.ProductoDAO;
import Models.Cliente;
import Models.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ModelDAO.VentaDAO;
import Models.DetalleVenta;
import Models.Pagos;
import Models.Venta;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;


public class Jframe_Ventas extends javax.swing.JFrame {
    
    DefaultTableModel tableV = new DefaultTableModel();
    DefaultTableModel tableBuscar = new DefaultTableModel();
    
    VentaDAO vd = new VentaDAO();
    ProductoDAO pd = new ProductoDAO();
    Cliente cli;
    Producto pro;
    private int numVenta = 1;
    private String idcliente;

    
    public Jframe_Ventas() {
        initComponents();
         setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
         this.setLocationRelativeTo(this);
         txtCodigoP.setVisible(false);
         generarNumVenta();
         mostrarCabecera();
         mostrarCabeceraBuscar();
         listarProductos();
         
        
        tablePbuscar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mouse_evt){
                JTable table = (JTable) mouse_evt.getSource();
                Point point = mouse_evt.getPoint();
                
                int filas = table.rowAtPoint(point);
                if(mouse_evt.getClickCount() == 1){
                    String codigo = tablePbuscar.getValueAt(tablePbuscar.getSelectedRow(), 0).toString();
                    String producto = tablePbuscar.getValueAt(tablePbuscar.getSelectedRow(), 1).toString();
                    String precio = tablePbuscar.getValueAt(tablePbuscar.getSelectedRow(), 6).toString();           
                    String stock = tablePbuscar.getValueAt(tablePbuscar.getSelectedRow(), 5).toString();  
                   
                    txtProductoB.setText(producto);
                    txtPrecioPro.setText(precio);
                    txtStockPro.setText(stock);
                    txtCodigoP.setText(codigo);
                   
                }   
                
                
            }           
        });
 
    }
    
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNumVenta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPrecioPro = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();
        txtScliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtStockPro = new javax.swing.JTextField();
        btnScliente = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtCantidadPro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtClienteB = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProductoB = new javax.swing.JTextField();
        cbComprobante = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePbuscar = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbTipoP = new javax.swing.JComboBox<>();
        txtCodigoP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNumVenta.setEnabled(false);

        jLabel16.setText("PRECIO:");

        jLabel12.setText("DNI CLIENTE:");

        txtPrecioPro.setEnabled(false);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregarP.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbVentas);

        jLabel17.setText("STOCK:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setText("CONTROL DE VENTAS");

        txtStockPro.setEnabled(false);

        btnScliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnScliente.setText("Buscar Cliente");
        btnScliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSclienteActionPerformed(evt);
            }
        });

        jLabel18.setText("CANTIDAD:");

        jLabel14.setText("CLIENTE:");

        txtClienteB.setEnabled(false);

        jLabel15.setText("PRODUCTO: ");

        jLabel11.setText("NRO. VENTA: ");

        txtProductoB.setEnabled(false);

        cbComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOLETA", "FACTURA" }));

        jLabel1.setText("COMPROBANTE:");

        btnGenerarVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Monto a pagar:");

        txtTotal.setEnabled(false);

        jLabel3.setText("Da doble click en las filas para seleccionar un producto..");

        tablePbuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePbuscar.getTableHeader().setResizingAllowed(false);
        tablePbuscar.getTableHeader().setReorderingAllowed(false);
        tablePbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePbuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePbuscar);

        jLabel4.setText("TIPO PAGO:");

        cbTipoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "TARJETA", "YAPE", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtScliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnScliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtClienteB, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(98, 98, 98)
                                        .addComponent(txtCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(192, 192, 192))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cbTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(102, 102, 102)
                                                    .addComponent(jLabel2)
                                                    .addGap(158, 158, 158))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                    .addComponent(jLabel15)
                                                                    .addGap(98, 98, 98))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                    .addComponent(txtProductoB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(25, 25, 25)))
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtPrecioPro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(26, 26, 26)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtStockPro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(34, 34, 34)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtCantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(18, 18, 18)
                                                            .addComponent(btnAgregar))
                                                        .addComponent(btnGenerarVenta))
                                                    .addGap(23, 23, 23)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(402, 402, 402)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtScliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnScliente)
                    .addComponent(jLabel14)
                    .addComponent(txtClienteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProductoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStockPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(cbTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarVenta))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSclienteActionPerformed
        String dni = txtScliente.getText();
        cli = new Cliente();
        cli = vd.searchCliente(dni);
        
        if(cli == null){
            JOptionPane.showMessageDialog(this, "El cliente no existe");
        }else{
            txtClienteB.setText(cli.getNombre());
            
            //Capturamos el idcliente para la venta
             idcliente = cli.getIdcliente();
            
            cli = new Cliente();
            cli = null;
        }
        
    }//GEN-LAST:event_btnSclienteActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String codigo = txtCodigoP.getText();
        String producto = txtProductoB.getText();
        Double precio = Double.parseDouble(txtPrecioPro.getText());
        int cantidad = Integer.parseInt(txtCantidadPro.getText());
        Double total = precio * cantidad;
        
        tableV.addRow(new Object[]{codigo, producto, precio, cantidad, total});
        resetProduct();
         
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablePbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePbuscarMouseClicked
        if(evt.getClickCount() == 2){
            int filaSelect = tablePbuscar.getSelectedRow();
            if(filaSelect != -1){
                String producto = tableBuscar.getValueAt(filaSelect, 0).toString();

                System.out.println(producto);
            }
        }
    }//GEN-LAST:event_tablePbuscarMouseClicked

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = df.format(d);
        String tipoComprob = (String) cbComprobante.getSelectedItem();
        
        Venta venta = new Venta();
        venta.setIdcliente(idcliente);
        venta.setFecha_venta(fechaActual);
        venta.setNumVenta(Integer.parseInt(txtNumVenta.getText()));
        venta.setTipoComprobante(tipoComprob);
        
        int idVenta = vd.registerVenta(venta);
        
        
        DetalleVenta detalle = new DetalleVenta();
        ArrayList<DetalleVenta> detalleVector = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbVentas.getModel();
        
        for(int i= 0; i < model.getRowCount(); i++){
             detalle = new DetalleVenta();
             
            detalle.setIdproducto((String) model.getValueAt(i, 0));
            detalle.setIdventa(String.valueOf(idVenta));
            detalle.setCantidad((int) model.getValueAt(i, 3));
            detalle.setPrecio_venta((double) model.getValueAt(i, 4));
            
            detalleVector.add(detalle);
        }
        
        for (DetalleVenta det : detalleVector) {
            vd.registerDetalle(det);
        }
        
        
        Pagos pago = new Pagos();
        String tipoPago = (String) cbTipoP.getSelectedItem();
        pago.setIdventa(String.valueOf(idVenta));
        pago.setTipoPago(tipoPago);
        pago.setFechaPago(fechaActual);
        
        vd.registerPagos(pago);
        
        JOptionPane.showMessageDialog(this, "Venta registrada con exito");
        resetForm();
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    
    
    
    
    public void listarProductos(){
        
        ArrayList<Producto> vp = new ArrayList<>();
        vp = pd.ListProduct();
        
        tableBuscar.setRowCount(0);
        
        for(int i=0 ; i<vp.size(); i++){
            Object dataProduct[] = 
            {vp.get(i).getCodigo(),
            vp.get(i).getNombreP(),
            vp.get(i).getMarca(),
            vp.get(i).getModelo(),
            vp.get(i).getTipo(),
            vp.get(i).getStock(),
            vp.get(i).getPrecio()};
            
            tableBuscar.addRow(dataProduct);
            
        }
    }
    public void generarNumVenta(){
        
        String num = String.format("%05d", numVenta);
        txtNumVenta.setText(num);
        numVenta ++;
        
    }
    
    public void mostrarCabecera(){
        tableV.addColumn("CODIGO");
        tableV.addColumn("PRODUCTO");
        tableV.addColumn("PRECIO");
        tableV.addColumn("CANTIDAD");
        tableV.addColumn("TOTAL");
        tableV.addColumn("QUITAR");
        tbVentas.setModel(tableV);
    }
    
    public void mostrarCabeceraBuscar(){
        tableBuscar.addColumn("Codigo");
        tableBuscar.addColumn("Producto");
        tableBuscar.addColumn("Marca");
        tableBuscar.addColumn("Modelo");
        tableBuscar.addColumn("Tipo");
        tableBuscar.addColumn("Stock");
        tableBuscar.addColumn("Precio");
        tablePbuscar.setModel(tableBuscar);
        
    }
    
    public void resetProduct(){
        txtProductoB.setText(null);
        txtCodigoP.setText(null);
        txtPrecioPro.setText(null);
        txtStockPro.setText(null);
        txtCantidadPro.setText(null);
    }
    
    public void resetForm(){
        txtScliente.setText(null);
        txtClienteB.setText(null);
        cbComprobante.setSelectedIndex(0);
        cbTipoP.setSelectedIndex(0);
        tableV.setRowCount(0);
        
        
    }

    

    
    
    
    public static void main(String args[]) {
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jframe_Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnScliente;
    private javax.swing.JComboBox<String> cbComprobante;
    private javax.swing.JComboBox<String> cbTipoP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablePbuscar;
    private javax.swing.JTable tbVentas;
    private javax.swing.JTextField txtCantidadPro;
    private javax.swing.JTextField txtClienteB;
    private javax.swing.JTextField txtCodigoP;
    private javax.swing.JTextField txtNumVenta;
    private javax.swing.JTextField txtPrecioPro;
    private javax.swing.JTextField txtProductoB;
    private javax.swing.JTextField txtScliente;
    private javax.swing.JTextField txtStockPro;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
