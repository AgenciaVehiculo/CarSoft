/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

import Clases.Cargo_empleado;
import Clases.Cliente;
import Clases.Empleado;
import Clases.HistoricoCargo_empleado;
import Clases.HistoricoPrecioPieza;
import Clases.HistoricoSueldo_empleado;
import Clases.Persona;
import Clases.Pieza;
import Clases.TipoPieza;
import Clases.Tipo_Documento;
import JPAController.Cargo_empleadoJpaController;
import JPAController.ClienteJpaController;
import JPAController.EmpleadoJpaController;
import JPAController.HistoricoCargo_empleadoJpaController;
import JPAController.HistoricoPrecioPiezaJpaController;
import JPAController.HistoricoSueldo_empleadoJpaController;
import JPAController.PersonaJpaController;
import JPAController.PiezaJpaController;
import JPAController.TipoPiezaJpaController;
import JPAController.Tipo_DocumentoJpaController;
import Pantallas.Ventas;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kur013
 */
public class ModalEmpleado extends javax.swing.JDialog {

    /**
     * Creates new form ModalPiezas
     */
    
    Tipo_DocumentoJpaController TipoDocumentodao = new Tipo_DocumentoJpaController();
    EmpleadoJpaController Empleadodao = new EmpleadoJpaController();
    PersonaJpaController Personadao = new PersonaJpaController();
    HistoricoSueldo_empleadoJpaController HistoricoSueldoDao = new HistoricoSueldo_empleadoJpaController();
    HistoricoCargo_empleadoJpaController HistoricoCargoDao = new HistoricoCargo_empleadoJpaController();
    Cargo_empleadoJpaController CargoDao = new Cargo_empleadoJpaController();
    int id = 0;
    String nombre ="";
    String apellido="";
    public ModalEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

     private void crearTableBusquedaCliente(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblempleadosbusqueda.setModel(modelo);
        modelo.addColumn("ID Empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Tipo Documento");
        modelo.addColumn("Documento");
        modelo.addColumn("Cargo");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Estado");
        boolean bandera = false;
        List<Persona> tempo = Personadao.findPersonaEntities();
        String auxNombre="";
        String auxApellido="";
        String auxDireccion="";
        String auxCorreo="";
        String auxTelefono="";
        String auxDocumento="";
        List<Empleado> temp = Empleadodao.findEmpleadoEntities();
        String aux1="";
        
        String auxfecharegistro="";
        List<Tipo_Documento> temp2 = TipoDocumentodao.findTipo_DocumentoEntities();
        int aux=0;
        List<HistoricoSueldo_empleado> temp3 = HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities();
        double auxSueldo=0;
        List<HistoricoCargo_empleado> tempc = HistoricoCargoDao.findHistoricoCargo_empleadoEntities();
        int auxCargo=0;
        String auxfecha="";
        List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        String auxCargoEmp = null;
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("###,###,###,###.00",separadoresPersonalizados);
        
            for(Empleado cc : temp){
            for(Persona p : tempo){
                String auxNombreCompleto=(p.getNombre()+" "+p.getApellido());
                if(auxNombreCompleto.equalsIgnoreCase(txtNombreBusqueda.getText())){
                    auxNombre=(p.getNombre());
                    auxApellido=(p.getApellido());
                    auxDireccion=(p.getDireccion());
                    auxCorreo=p.getCorreo_electroncio();
                    auxTelefono=p.getTelefono();
                    auxDocumento=p.getDocumento_id();
                    auxfecha=(cc.getFecha_ingreso().substring(8, 10)+"/"+cc.getFecha_ingreso().substring(5, 7)+"/"+cc.getFecha_ingreso().substring(0, 4));
                    for(Tipo_Documento tp : temp2){
                if(tp.getId_Tipo_Documento() == p.getID_tipo_documento()){
                    aux1=(tp.getId_Tipo_Documento()+". "+tp.getDocumento());
                }
            }
                    
                for(HistoricoCargo_empleado hce : tempc){
                if(hce.getId_empleado() == cc.getId_Empleado()){
                    if(hce.getFecha_final()==null){
                        auxCargo=(hce.getId_cargo());
                        }
                    for(Cargo_empleado tp : tempce){
                    if(tp.getId_cargo()== hce.getId_cargo()){
                    auxCargoEmp=(hce.getId_cargo()+". "+tp.getCargo());
                        }   
                    }
                }
                    }
                    
            for(HistoricoSueldo_empleado hse : temp3){
                if(hse.getId_empleado() == cc.getId_Empleado()){
                    if(hse.getFecha_final()==null){
                        auxSueldo=hse.getSueldo();
                        }
                    }
                }
            
            
            modelo.addRow(
                    new Object[]{
                        cc.getId_Empleado(),
                        auxNombre,
                        auxApellido,
                        auxTelefono,
                        auxDireccion,
                        auxCorreo,
                        auxfecha,
                        aux1,
                        auxDocumento,
                        auxCargoEmp,
                        String.format("%,.2f",auxSueldo),
                        cc.isEstado()? "Activo" : "Inactivo",
                        //(cc.isEstado())?"Activo":"Inactivo"
                      
            });  
            
            
            bandera=true;
            
                }
            else{
                
            }
            }
        }
        
        if(!bandera){
            JOptionPane.showMessageDialog(null,"No se encontro ningun cliente");
        }   
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblempleadosbusqueda = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(720, 500));

        jPanel3.setMaximumSize(new java.awt.Dimension(1250, 1250));
        jPanel3.setLayout(null);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(70, 130, 70, 30);
        jPanel3.add(txtNombreBusqueda);
        txtNombreBusqueda.setBounds(120, 130, 160, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(290, 120, 130, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Seleccionar.png"))); // NOI18N
        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(290, 180, 130, 40);

        tblempleadosbusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Apellidos", "Teléfono", "Dirección", "Correo electrónico", "Fecha Registro", "Tipo Documento", "Documento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblempleadosbusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblempleadosbusquedaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblempleadosbusqueda);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(30, 250, 1160, 220);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Busqueda de Empleados");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(610, 10, 310, 35);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearTableBusquedaCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public int getId() {
        return id;
        
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = tblempleadosbusqueda.getSelectedRow();
        id=(int) tblempleadosbusqueda.getValueAt(selectedRow, 0);
        nombre =(String) tblempleadosbusqueda.getValueAt(selectedRow, 1);
        apellido= (String)tblempleadosbusqueda.getValueAt(selectedRow, 2);
        this.dispose(); 
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblempleadosbusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblempleadosbusquedaMouseClicked
        
    }//GEN-LAST:event_tblempleadosbusquedaMouseClicked

    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblempleadosbusqueda;
    private javax.swing.JTextField txtNombreBusqueda;
    // End of variables declaration//GEN-END:variables
}
