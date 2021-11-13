/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

import Clases.HistoricoPrecioPieza;
import Clases.Pieza;
import Clases.TipoPieza;
import JPAController.HistoricoPrecioPiezaJpaController;
import JPAController.PiezaJpaController;
import JPAController.TipoPiezaJpaController;
import Pantallas.Ventas;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.persistence.Persistence;
/**
 *
 * @author Kur013
 */
public class ModalPiezasCombo extends javax.swing.JDialog {

    /**
     * Creates new form ModalPiezas
     */
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("CarSoft");
    PiezaJpaController piezaDao = new PiezaJpaController(emf);
    HistoricoPrecioPiezaJpaController historicoPieza = new HistoricoPrecioPiezaJpaController(emf);
    TipoPiezaJpaController tipoPieza = new TipoPiezaJpaController(emf);
    int id = 0;
    String tipo="";
    String nombre="";
    
    public ModalPiezasCombo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jButton1.setBackground( new Color(14, 209, 69));
        this.jButton2.setBackground( new Color(14, 209, 69));
        this.btnRegresar.setBackground( new Color(14, 209, 69));
    }

     private void crearTableBusquedaPieza(){
         if("".equals(txtNombreBusqueda.getText().trim())){
            JOptionPane.showMessageDialog(null, "El campo para la Búsqueda de Piezas esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaBusqueda.getModel();
        tablaBusqueda.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");*/
        List<Pieza> temp = piezaDao.findPiezaEntities();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxPrecio=0;
        String aux1="";
        List<TipoPieza> temp2 = tipoPieza.findTipoPiezaEntities();
        List<HistoricoPrecioPieza> temp3 = historicoPieza.findHistoricoPrecioPiezaEntities();
        boolean bandera = false;
        for(Pieza p : temp){
            if(p.getNombre().equalsIgnoreCase(txtNombreBusqueda.getText())){
            for(TipoPieza p1 : temp2){
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza())
                    aux1=p1.getTipopieza();
                    
            }
            for(HistoricoPrecioPieza p2 : temp3){
                if(p2.getIdPieza() == p.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        auxPrecio=p2.getPrecio();
                    }
                }
            }
            
            modelo.addRow(new Object[]{
                p.getId_Pieza(),
                aux1,
                p.getNombre(),
                p.getCarateristica_Pieza(),
                String.format("%,.2f",auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });
            
            
            bandera=true;
            
            }
            else{
                
            }
        }
        
        if(!bandera){
            JOptionPane.showMessageDialog(null,"No se encontro ninguna Pieza","Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
    }
     
     public boolean BuscarPiezaTest(){
          if("".equals(txtNombreBusqueda.getText().trim())){
            //JOptionPane.showMessageDialog(null, "El campo para la Busqueda de Piezas esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaBusqueda.getModel();
        tablaBusqueda.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");*/
        List<Pieza> temp = piezaDao.findPiezaEntities();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxPrecio=0;
        String aux1="";
        List<TipoPieza> temp2 = tipoPieza.findTipoPiezaEntities();
        List<HistoricoPrecioPieza> temp3 = historicoPieza.findHistoricoPrecioPiezaEntities();
        boolean bandera = false;
        for(Pieza p : temp){
            if(p.getNombre().equalsIgnoreCase(txtNombreBusqueda.getText())){
            for(TipoPieza p1 : temp2){
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza())
                    aux1=p1.getTipopieza();
                    
            }
            for(HistoricoPrecioPieza p2 : temp3){
                if(p2.getIdPieza() == p.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        auxPrecio=p2.getPrecio();
                    }
                }
            }
            
            modelo.addRow(new Object[]{
                p.getId_Pieza(),
                aux1,
                p.getNombre(),
                p.getCarateristica_Pieza(),
                String.format("%,.2f",auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });
            
            
            bandera=true;
            
            }
            else{
                
            }
        }
        
        if(!bandera){
            //JOptionPane.showMessageDialog(null,"No se encontro ninguna Pieza");
            return false;
        }
        
        
        
        return true;
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreBusqueda = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(720, 500));

        jPanel3.setMaximumSize(new java.awt.Dimension(1250, 1250));
        jPanel3.setLayout(null);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(70, 130, 70, 30);

        txtNombreBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBusquedaKeyTyped(evt);
            }
        });
        jPanel3.add(txtNombreBusqueda);
        txtNombreBusqueda.setBounds(120, 130, 160, 30);

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pieza", "Tipo Pieza", "Nombre", "Características", "Precio", "Stock", "Stock Máximo", "Stock Mínimo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBusquedaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaBusqueda);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(30, 250, 1040, 183);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(290, 120, 140, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Seleccionar.png"))); // NOI18N
        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(290, 180, 140, 40);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Busqueda de Piezas");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(600, 10, 240, 35);

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar);
        btnRegresar.setBounds(893, 470, 170, 45);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jPanel3.add(jLabel15);
        jLabel15.setBounds(0, 0, 1400, 680);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaBusquedaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearTableBusquedaPieza();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public int getId() {
        return id;
        
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = tablaBusqueda.getSelectedRow();
        id=(int) tablaBusqueda.getValueAt(selectedRow, 0);
        tipo=(String)tablaBusqueda.getValueAt(selectedRow, 1);
        nombre=(String)tablaBusqueda.getValueAt(selectedRow, 2);
        this.dispose();
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNombreBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBusquedaKeyTyped
char c = evt.getKeyChar();
        if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z' && c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }
              
        if (txtNombreBusqueda.getText().length() >= 25){
        
        evt.consume();
        
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBusquedaKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //FrmMenu m = new FrmMenu();
        // m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tablaBusqueda;
    public javax.swing.JTextField txtNombreBusqueda;
    // End of variables declaration//GEN-END:variables
}
