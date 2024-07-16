
package Views;

import Models.Producto;
import Models.Venta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ModelDAO.ProductoDAO;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;


public class Jframe_listaProducts extends javax.swing.JFrame {

    
    DefaultTableModel table = new DefaultTableModel();
    ProductoDAO pd = new ProductoDAO();
    Jframe_Ventas ventas_frame = new Jframe_Ventas();

    
    public Jframe_listaProducts() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(this);
        mostrarCabecera();
        listarProductos();
        

        tablePbuscar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mouse_evt){
                JTable table = (JTable) mouse_evt.getSource();
                Point point = mouse_evt.getPoint();
                
                int filas = table.rowAtPoint(point);
                if(mouse_evt.getClickCount() == 1){
                    String producto = tablePbuscar.getValueAt(tablePbuscar.getSelectedRow(), 0).toString();
                    String precio = tablePbuscar.getValueAt(tablePbuscar.getSelectedRow(), 5).toString();           
                    String stock = tablePbuscar.getValueAt(tablePbuscar.getSelectedRow(), 4).toString();  
                   
                    ventas_frame.productSeleccionado(producto, stock, precio);     
                    dispose(); 
                }   
                
                
            }           
        });
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePbuscar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        (tablePbuscar).setFocusable(false);
        (tablePbuscar) = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablePbuscar.getTableHeader().setResizingAllowed(false);
        tablePbuscar.getTableHeader().setReorderingAllowed(false);
        tablePbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePbuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePbuscar);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione un producto de la lista dando doble click ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePbuscarMouseClicked
        if(evt.getClickCount() == 2){
            int filaSelect = tablePbuscar.getSelectedRow();
            if(filaSelect != -1){
                String producto = table.getValueAt(filaSelect, 0).toString();
                
                System.out.println(producto);
            }
        }
    }//GEN-LAST:event_tablePbuscarMouseClicked

        public void listarProductos(){
        
        ArrayList<Producto> vp = new ArrayList<>();
        vp = pd.ListProduct();
        
        table.setRowCount(0);
        
        for(int i=0 ; i<vp.size(); i++){
            Object dataProduct[] = 
            {vp.get(i).getNombreP(),
            vp.get(i).getMarca(),
            vp.get(i).getModelo(),
            vp.get(i).getTipo(),
            vp.get(i).getStock(),
            vp.get(i).getPrecio()};
            
            table.addRow(dataProduct);
            
        }
    }
        
    
    public void mostrarCabecera(){
        table.addColumn("Producto");
        table.addColumn("Marca");
        table.addColumn("Modelo");
        table.addColumn("Tipo");
        table.addColumn("Stock");
        table.addColumn("Precio");
        tablePbuscar.setModel(table);
        
    }
    
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jframe_listaProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe_listaProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe_listaProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe_listaProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jframe_listaProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePbuscar;
    // End of variables declaration//GEN-END:variables
}
