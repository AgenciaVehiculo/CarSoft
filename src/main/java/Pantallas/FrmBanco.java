/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Banco;
import Clases.Cliente;
import Clases.Detalle_Banco_Cliente;
import Clases.Empleado;
import Clases.FacturaJRADATASOURCE;
import Clases.HistoricoPrecioPieza;
import Clases.HistoricoPrecioVehiculos;
import Clases.Marca;
import Clases.Persona;
import Clases.PiezaFactura;
import Clases.PrestamoJRDataSource;
import Clases.RazonSocial;
import Clases.Tipo_Documento;
import Clases.VehiculoFactura;
import Clases.informacionFiscal;
import FormModales.ModalBanco;
import FormModales.ModalCliente;
import JPAController.BancoJpaController;
import JPAController.ClienteJpaController;
import JPAController.Detalle_Banco_ClienteJpaController;
import JPAController.PersonaJpaController;
import JPAController.Tipo_DocumentoJpaController;
import com.mycompany.carsoft.RUN;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public final class FrmBanco extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("CarSoft");
    BancoJpaController BancoDao = new BancoJpaController(emf);
    ClienteJpaController ClienteDao = new ClienteJpaController(emf);
    PersonaJpaController PersonaDao = new PersonaJpaController(emf);
    Detalle_Banco_ClienteJpaController DetalleBancoClienteDao = new Detalle_Banco_ClienteJpaController(emf);
    Tipo_DocumentoJpaController TipoDocumentodao = new Tipo_DocumentoJpaController(emf);
    
    String empNomb;

    public String getEmpNomb() {
        return empNomb;
    }

    public void setEmpNomb(String empNomb) {
        this.empNomb = empNomb;
    }
    
    
    public FrmBanco() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        createTableBanco();
        createComboBoxBanco();
        btnDesactivar.setEnabled(false);
        createTablePrestamo();
        createComboCliente();
        createComboIDBancoPrestamo();
        createComboBoxPrestamo();
        txtFechaFinalPrestamo.setEnabled(false);
        btnModificar1.setEnabled(false);
        btnModificar.setEnabled(false);
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.getContentPane().setBackground(new Color(0, 75, 143));
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.btnAgregar.setBackground( new Color(14, 209, 69));
        this.btnSalir.setBackground( new Color(236, 28, 36));
        this.btnModificar.setBackground( new Color(14, 209, 69));
        this.btnLimpiar.setBackground( new Color(14, 209, 69));
        this.btnDesactivar.setBackground( new Color(14, 209, 69));
        this.btnDesactivar1.setBackground( new Color(14, 209, 69));
        this.btnRegresar.setBackground( new Color(14, 209, 69));
        tblBanco.setForeground(Color.WHITE);
        tblBanco.setBackground(Color.BLACK);
        this.btnAgregar1.setBackground( new Color(14, 209, 69));
        btnAgregar2.setBackground( new Color(14, 209, 69));
        btnAgregar3.setBackground( new Color(14, 209, 69));
        btnAgregar4.setBackground( new Color(14, 209, 69));
        btnAgregar5.setBackground( new Color(14, 209, 69));
        this.btnSalir1.setBackground( new Color(236, 28, 36));
        this.btnModificar1.setBackground( new Color(14, 209, 69));
        this.btnLimpiar1.setBackground( new Color(14, 209, 69));
        this.btnRegresar1.setBackground( new Color(14, 209, 69));
        tblPrestamo.setForeground(Color.WHITE);
        tblPrestamo.setBackground(Color.BLACK);
        btnBuscar.setBackground( new Color(14, 209, 69));
        btnBuscar1.setBackground( new Color(14, 209, 69));
        btnBuscar2.setBackground( new Color(14, 209, 69));
        btnDesactivar1.setEnabled(false);
        habilitarAgregarPrestamo();
       // comboFilter(String.valueOf(cmbIDBancoPrestamo1.getSelectedIndex()));
        //Bancomostrar();
        //createComboIDBancoPrestamoFilter();
        //cmbrealeased();
        createComboIDBancoPrestamo();
    }

private void btnActivarDesactivarBanco(){
        Banco temp = new Banco();
        temp = BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar.setText("Desactivar");  
        btnDesactivar.setEnabled(true);
        }
        else{
            btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar.setText("Activar");
            btnDesactivar.setEnabled(true);
        }
        }
private void habilitarAgregarPrestamo(){
        //Validacion de agregar
        if(ClienteDao.getClienteCount()!=0 || BancoDao.getBancoCount()!=0){
            btnAgregar.setEnabled(true);
        }
        else{
            
        }
        //Fin de validacion agregar
    }
private void createComboBoxBanco(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDBanco.setModel(modelo);
        List<Banco> temp = BancoDao.findBancoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getId_banco());
        });
        }
private void createComboBoxPrestamo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDPrestamo.setModel(modelo);
        List<Detalle_Banco_Cliente> temp = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getNumero_prestamo());
        });
        }

    private void createComboCliente(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDClientePrestamo.setModel(modelo);
        List<Cliente> temp = ClienteDao.findClienteEntities();
        List<Persona> temp2 = PersonaDao.findPersonaEntities();
        modelo.addElement("Seleccione...");
        for(Cliente tpp: temp){
            for(Persona tp: temp2){
                if(tpp.getId_Persona()==tp.getId_persona()){
            modelo.addElement(tpp.getId_cliente()+". "+tp.getNombre() +" "+tp.getApellido()); 
                }
            }
        }               
    }


        private void createComboIDBancoPrestamo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDBancoPrestamo.setModel(modelo);
        List<Banco> temp = BancoDao.findBancoEntities();
        modelo.addElement("Seleccione...");
        temp.forEach((tp) -> {
            modelo.addElement(tp.getId_banco()+". "+tp.getNombre_banco());
        });
                }
 /*       
       public void createComboIDBancoPrestamoFilter(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDBancoPrestamo1.setModel(modelo);
        List<Banco> temp = BancoDao.findBancoEntities();
        for(Banco tp: temp){
            modelo.addElement(tp.getNombre_banco());
        }
                }
       
       public void cmbrealeased(){
               cmbIDBancoPrestamo1.addKeyListener(new KeyAdapter() {
                                                                public void keyReleased(final java.awt.event.KeyEvent e) {
                                                                        repaint();
                                                                        comboFilter(String.valueOf(cmbIDBancoPrestamo1.getSelectedIndex()));
                                                                }
                                                                });
}
    /**
     *
     * @param enteredText
     */
/*
    public void comboFilter(String enteredText) {
        
    List<Banco> temp = BancoDao.findBancoEntities();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    //model.removeAllElements();
    //cmbIDBancoPrestamo1.setModel(model);
    for(int i=0;i<BancoDao.findBancoEntities().size();i++){
    //if(txtDocumento.getText().toLowerCase().equals(Personadao.findPersona(i+1).getDocumento_id())){
    //for (int i = 0; i > BancoDao.findBancoEntities().size(); i++) {
       // if(txtDocumento.getText().toLowerCase().equals(Personadao.findPersona(i+1).getDocumento_id())){
        if (BancoDao.findBanco(i+1).getNombre_banco().contains(enteredText.toLowerCase())) {
            Banco Banco = null;
            temp.add(Banco);
            //model.addElement(BancoDao.findBanco(i+1).getNombre_banco());
            
            
        }

    }
    if (BancoDao.findBancoEntities().size() > 0) {

       /* for (String s: filterArray){
            model.addElement(s);
        }*/
/*       for(Banco tp: temp){
            model.addElement(tp.getNombre_banco());
        }
        
        cmbIDBancoPrestamo1.setSelectedIndex(Integer.parseInt(enteredText));
    
}
       }*/
         

         
private void createTableBanco(){
        DefaultTableModel modelo = (DefaultTableModel) tblBanco.getModel();
        tblBanco.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Banco");
        modelo.addColumn("Nombre Banco");
        modelo.addColumn("Nombre Contacto");
        modelo.addColumn("Teléfono del Contacto");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Estado");*/
        
        List<Banco> temp = BancoDao.findBancoEntities();
        for(Banco tp : temp)
        modelo.addRow(
                    new Object[]{
                        tp.getId_banco(),
                        tp.getNombre_banco(),
                        tp.getNombre_contacto(),
                        tp.getTelefono_contacto(),
                        tp.getCorreo_electronico(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }

public boolean createTableBancoTest(){
        DefaultTableModel modelo = (DefaultTableModel) tblBanco.getModel();
        tblBanco.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Banco");
        modelo.addColumn("Nombre Banco");
        modelo.addColumn("Nombre Contacto");
        modelo.addColumn("Teléfono del Contacto");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Estado");*/
        
        List<Banco> temp = BancoDao.findBancoEntities();
        for(Banco tp : temp)
        modelo.addRow(
                    new Object[]{
                        tp.getId_banco(),
                        tp.getNombre_banco(),
                        tp.getNombre_contacto(),
                        tp.getTelefono_contacto(),
                        tp.getCorreo_electronico(),
                        (tp.isEstado())?"Activo":"Inactivo"
            }); 
        return true;
    }
private void createTablePrestamo(){
        DefaultTableModel modelo = (DefaultTableModel) tblPrestamo.getModel();
        tblPrestamo.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("N° de Préstamo");
        modelo.addColumn("Banco");
        modelo.addColumn("Cliente");
        modelo.addColumn("Monto del Préstamo");
        modelo.addColumn("N° de Cuotas");
        modelo.addColumn("Valor Total del Interés");
        modelo.addColumn("Tasa de Interés");
        modelo.addColumn("Valor Capital");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
        modelo.addColumn("Estado");*/
        
        List<Banco> tempb = BancoDao.findBancoEntities();
        int auxidbanco =0;
        String auxbanco="";
        String auxnombrebanco="";
        List<Detalle_Banco_Cliente> tempdbc = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        List<Persona> tempo = PersonaDao.findPersonaEntities();
        String auxdocumento = "";
        List<Cliente> temp = ClienteDao.findClienteEntities();
        String aux1="";
        List<Tipo_Documento> temp2 = TipoDocumentodao.findTipo_DocumentoEntities();
        String auxclientenombre="";
        String auxclienteapellido="";
        String auxNombreApellido="";
        String auxcliente="";
        String auxfecha="";
        String auxfechab="";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        DecimalFormat formato2 = new DecimalFormat("#.00",separadoresPersonalizados);
            for(Detalle_Banco_Cliente dbc : tempdbc){
                
                for(Banco b : tempb){
                if(dbc.getId_banco()==b.getId_banco()){
                    auxidbanco=(b.getId_banco());
                    auxnombrebanco=(b.getNombre_banco());
                    auxbanco =((b.getId_banco())+ ". " + b.getNombre_banco());
                }
                    for(Cliente cc : temp){
                        if(dbc.getId_cliente()==cc.getId_cliente()){
                    
                        for(Persona p : tempo){   
                            if(p.getId_persona()== cc.getId_Persona()){
                            auxdocumento=(p.getDocumento_id());
                            auxclientenombre=(p.getNombre());
                            auxclienteapellido=(p.getApellido());
                            auxNombreApellido= auxclientenombre+" "+auxclienteapellido;
                            auxcliente=(dbc.getId_cliente() + ". " + auxNombreApellido);
                            auxfecha=(dbc.getFecha_inicio().substring(8, 10)+"/"+dbc.getFecha_inicio().substring(5, 7)+"/"+dbc.getFecha_inicio().substring(0, 4));
                                for(Tipo_Documento tp : temp2){
                                    if(tp.getId_Tipo_Documento() == p.getID_tipo_documento()){
                                    aux1=tp.getDocumento();
                                    }
                                }
                            }   
                        }
                    }
                }
            }
            if(dbc.getFecha_final()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(dbc.getFecha_final().substring(8, 10)+"/"+dbc.getFecha_final().substring(5, 7)+"/"+dbc.getFecha_final().substring(0, 4));
                                    } 
            
            modelo.addRow(
                    new Object[]{
                        dbc.getNumero_prestamo(),
                        auxbanco,
                        auxcliente,
                        String.format("%,.2f",dbc.getMonto_prestamo()),
                        dbc.getCuota(),
                        String.format("%,.2f",dbc.getValor_interes()),
                        String.format("%,.2f",dbc.getTasa_interes()),
                        String.format("%,.2f",dbc.getValor_capital()),
                        auxfecha,
                        auxfechab,
                        dbc.isEstado()?"Activo":"Inactivo"
                      
            });  
    
        }
        }
public boolean createTablePrestamoTest(){
        DefaultTableModel modelo = (DefaultTableModel) tblPrestamo.getModel();
        tblPrestamo.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("N° de Préstamo");
        modelo.addColumn("Banco");
        modelo.addColumn("Cliente");
        modelo.addColumn("Monto del Préstamo");
        modelo.addColumn("N° de Cuotas");
        modelo.addColumn("Valor Total del Interés");
        modelo.addColumn("Tasa de Interés");
        modelo.addColumn("Valor Capital");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
        modelo.addColumn("Estado");*/
        
        List<Banco> tempb = BancoDao.findBancoEntities();
        int auxidbanco =0;
        String auxbanco="";
        String auxnombrebanco="";
        List<Detalle_Banco_Cliente> tempdbc = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        List<Persona> tempo = PersonaDao.findPersonaEntities();
        String auxdocumento = "";
        List<Cliente> temp = ClienteDao.findClienteEntities();
        String aux1="";
        List<Tipo_Documento> temp2 = TipoDocumentodao.findTipo_DocumentoEntities();
        String auxclientenombre="";
        String auxclienteapellido="";
        String auxNombreApellido="";
        String auxcliente="";
        String auxfecha="";
        String auxfechab="";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        DecimalFormat formato2 = new DecimalFormat("#.00",separadoresPersonalizados);
            for(Detalle_Banco_Cliente dbc : tempdbc){
                
                for(Banco b : tempb){
                if(dbc.getId_banco()==b.getId_banco()){
                    auxidbanco=(b.getId_banco());
                    auxnombrebanco=(b.getNombre_banco());
                    auxbanco =((b.getId_banco())+ ". " + b.getNombre_banco());
                }
                    for(Cliente cc : temp){
                        if(dbc.getId_cliente()==cc.getId_cliente()){
                    
                        for(Persona p : tempo){   
                            if(p.getId_persona()== cc.getId_Persona()){
                            auxdocumento=(p.getDocumento_id());
                            auxclientenombre=(p.getNombre());
                            auxclienteapellido=(p.getApellido());
                            auxNombreApellido= auxclientenombre+" "+auxclienteapellido;
                            auxcliente=(dbc.getId_cliente() + ". " + auxNombreApellido);
                            auxfecha=(dbc.getFecha_inicio().substring(8, 10)+"/"+dbc.getFecha_inicio().substring(5, 7)+"/"+dbc.getFecha_inicio().substring(0, 4));
                                for(Tipo_Documento tp : temp2){
                                    if(tp.getId_Tipo_Documento() == p.getID_tipo_documento()){
                                    aux1=tp.getDocumento();
                                    }
                                }
                            }   
                        }
                    }
                }
            }
            if(dbc.getFecha_final()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(dbc.getFecha_final().substring(8, 10)+"/"+dbc.getFecha_final().substring(5, 7)+"/"+dbc.getFecha_final().substring(0, 4));
                                    } 
            
            modelo.addRow(
                    new Object[]{
                        dbc.getNumero_prestamo(),
                        auxbanco,
                        auxcliente,
                        String.format("%,.2f",dbc.getMonto_prestamo()),
                        dbc.getCuota(),
                        String.format("%,.2f",dbc.getValor_interes()),
                        String.format("%,.2f",dbc.getTasa_interes()),
                        String.format("%,.2f",dbc.getValor_capital()),
                        auxfecha,
                        auxfechab,
                        dbc.isEstado()?"Activo":"Inactivo"
                      
            });  
    
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cmbIDBanco = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtCorreoBanco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelContacto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreContacto = new javax.swing.JTextField();
        txtNombreBanco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBanco = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnAgregar2 = new javax.swing.JButton();
        btnAgregar3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JButton();
        cmbIDPrestamo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPrestamo = new javax.swing.JTable();
        btnSalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbIDBancoPrestamo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbIDClientePrestamo = new javax.swing.JComboBox<>();
        txtMontoPrestamo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCuotasPrestamo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTasaPrestamo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtFechaFinalPrestamo = new javax.swing.JFormattedTextField();
        btnLimpiar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        btnBuscar2 = new javax.swing.JButton();
        btnDesactivar1 = new javax.swing.JButton();
        btnAgregar4 = new javax.swing.JButton();
        btnAgregar5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbIDBanco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDBancoItemStateChanged(evt);
            }
        });
        cmbIDBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDBancoActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Banco:");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCorreoBanco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoBancoFocusLost(evt);
            }
        });
        txtCorreoBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoBancoKeyTyped(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Correo electrónico:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Teléfono del Contacto:");

        txtTelContacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelContactoFocusLost(evt);
            }
        });
        txtTelContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelContactoKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre del Contacto:");

        txtNombreContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreContactoKeyTyped(evt);
            }
        });

        txtNombreBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBancoActionPerformed(evt);
            }
        });
        txtNombreBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBancoKeyTyped(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre del Banco:");

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        tblBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Banco", "Nombre Banco", "Nombre Contacto", "Teléfono del Contacto", "Correo electrónico", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBancoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBanco);

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Banco");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnAgregar2.setText("Generar Reporte PDF");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnAgregar3.setText("Generar Reporte Excel");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(640, 640, 640)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbIDBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnBuscar)))
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCorreoBanco)
                                            .addComponent(txtTelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cmbIDBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCorreoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar)
                            .addComponent(btnDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnRegresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar2)
                            .addComponent(btnAgregar3))))
                .addGap(94, 94, 94))
        );

        jTabbedPane1.addTab("Banco", jPanel1);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Préstamos");

        btnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar1.setText("Agregar");
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        cmbIDPrestamo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPrestamoItemStateChanged(evt);
            }
        });
        cmbIDPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDPrestamoActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("N° de Préstamo:");

        tblPrestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° de Préstamo", "Banco", "Cliente", "Monto del Préstamo", "N° de Cuotas", "Valor Total del Interés", "Tasa de Interés", "Valor Capital", "Fecha Inicio", "Fecha Final", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrestamoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPrestamo);
        if (tblPrestamo.getColumnModel().getColumnCount() > 0) {
            tblPrestamo.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblPrestamo.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblPrestamo.getColumnModel().getColumn(8).setPreferredWidth(40);
            tblPrestamo.getColumnModel().getColumn(9).setPreferredWidth(40);
            tblPrestamo.getColumnModel().getColumn(10).setPreferredWidth(60);
        }

        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Banco:");

        cmbIDBancoPrestamo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDBancoPrestamoItemStateChanged(evt);
            }
        });
        cmbIDBancoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDBancoPrestamoActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Cliente:");

        cmbIDClientePrestamo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDClientePrestamoItemStateChanged(evt);
            }
        });
        cmbIDClientePrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDClientePrestamoActionPerformed(evt);
            }
        });

        txtMontoPrestamo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoPrestamoFocusLost(evt);
            }
        });
        txtMontoPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoPrestamoKeyTyped(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Monto del Préstamo:");

        txtCuotasPrestamo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCuotasPrestamoFocusLost(evt);
            }
        });
        txtCuotasPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuotasPrestamoKeyTyped(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cuotas del Préstamo:");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Tasa de Interés:");

        txtTasaPrestamo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTasaPrestamoFocusLost(evt);
            }
        });
        txtTasaPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTasaPrestamoKeyTyped(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Fecha Final del Préstamo:");

        txtFechaFinalPrestamo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaFinalPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinalPrestamoActionPerformed(evt);
            }
        });
        txtFechaFinalPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaFinalPrestamoKeyTyped(evt);
            }
        });

        btnLimpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        btnModificar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar1.setText("Modificar");
        btnModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnBuscar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar2.setText("Buscar");
        btnBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar1.setText("Desactivar");
        btnDesactivar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar1ActionPerformed(evt);
            }
        });

        btnAgregar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnAgregar4.setText("Generar Reporte PDF");
        btnAgregar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });

        btnAgregar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnAgregar5.setText("Generar Reporte Excel");
        btnAgregar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAgregar1)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnModificar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar1))
                            .addComponent(cmbIDPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDBancoPrestamo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbIDClientePrestamo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscar2)
                                    .addComponent(btnBuscar1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCuotasPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTasaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtMontoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaFinalPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnDesactivar1))
                        .addGap(0, 159, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(452, 452, 452)
                                .addComponent(btnSalir1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAgregar4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregar5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar1)))))
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir1))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbIDPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtMontoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtFechaFinalPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbIDBancoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtCuotasPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbIDClientePrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtTasaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar1)
                    .addComponent(btnModificar1)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar4)
                        .addComponent(btnAgregar5))
                    .addComponent(btnRegresar1))
                .addGap(72, 72, 72))
        );

        jTabbedPane1.addTab("Préstamos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbIDBancoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDBancoItemStateChanged

    if(cmbIDBanco.getSelectedIndex()==0){
        txtNombreBanco.setText("");
        txtNombreContacto.setText("");
        txtTelContacto.setText("");
        txtCorreoBanco.setText("");
        }
        else{
        Banco tp;
        tp=BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
        txtNombreBanco.setText(tp.getNombre_banco());
        txtNombreContacto.setText(tp.getNombre_contacto());
        txtTelContacto.setText(tp.getTelefono_contacto());
        txtCorreoBanco.setText(tp.getCorreo_electronico());
        btnActivarDesactivarBanco();
        }
    }//GEN-LAST:event_cmbIDBancoItemStateChanged

    private void cmbIDBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDBancoActionPerformed

    public int btnAgregarActionPerfomed(String txtNombreBanco,String txtNombreContacto, String txtTelContacto,String txtCorreoBanco){                           
//        if(cmbIDBanco.getSelectedIndex()!=0){
//           // JOptionPane.showMessageDialog(null, "El ID Banco siempre debe estar en el ITEM de Nuevo para agregar un nuevo Banco","Error!", JOptionPane.ERROR_MESSAGE);
//            cmbIDBanco.setSelectedIndex(0);
//        }
//        else{
//
//        }
        if("".equals(txtNombreBanco.trim()) ){
            //JOptionPane.showMessageDialog(null,"El campo del nombre del Banco esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            
        }
        if (ValidacionTresletras(txtNombreBanco)){
                //JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Banco la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                       // txtNombreBanco.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        if((txtNombreBanco.length()<3)){
            //JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 3 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            
        }
        if((txtNombreBanco.length()>20)){
            //JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 20 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            
        }
        if (!ValidacionNombreMayuscula(txtNombreBanco.trim())){
               // JOptionPane.showMessageDialog(null,"El nombre del Banco debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                        //txtNombreBanco.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        
        if("".equals(txtNombreContacto.trim())){
               // JOptionPane.showMessageDialog(null, "El campo del nombre del Contacto esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;   
            }
            else{
                         
            }
        if(txtNombreContacto.length()<10){
                //JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 10 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;   
            }
            else{
                         
            }
        if(txtNombreContacto.length()>45){
               // JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 50 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;   
            }
            else{
                         
            }
        if (!ValidacionNombreMayuscula(txtNombreContacto.trim())){
               // JOptionPane.showMessageDialog(null,"El nombre del Contacto debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                        //txtNombreContacto.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        if (ValidacionTresletras(txtNombreContacto)){
               // JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Contacto la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        //txtNombreContacto.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        if("".equals(txtTelContacto.trim())) {
             //  JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el teléfono del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
           else{
           }
        if(txtTelContacto.length()<8) {
              // JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 digítos","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
           else{
           }
        if(txtTelContacto.length()>8) {
               //JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 números como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
           else{
           }
           if (!telefono(txtTelContacto)){
//           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
//           txtTelContacto.requestFocus();
           return 0;
            }else{
           
            }
           
           if("".equals(txtCorreoBanco.trim())){
               //JOptionPane.showMessageDialog(null, "El campo de  correo electrónico del Banco esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return 0;
           }
            else{
           }
           
           if(txtCorreoBanco.length()<13){
               //JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 13 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
               return 0;
           }
            else{
           }
           if(txtCorreoBanco.length()>35){
               //JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 35 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
               return 0;
           }
            else{
           }
           if (!correo(txtCorreoBanco)){
            //JOptionPane.showMessageDialog(null,"Formato de correo electrónico incorrecto","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }else{
        }
        
        if("".equals(txtNombreBanco) ){
            //JOptionPane.showMessageDialog(null,"El campo del nombre del Banco esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<BancoDao.findBancoEntities().size();i++){
                if(txtNombreBanco.toLowerCase().equals(BancoDao.findBanco(i+1).getNombre_banco())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este Banco registrado en el sistema","Error!", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return 0;
                } else {
                }
            }
            if(flag){
                return 0;
            }
            else{
                Banco cc = new Banco();
                cc.setEstado(true);
                cc.setNombre_banco(txtNombreBanco);
                cc.setNombre_contacto(txtNombreContacto);
                cc.setTelefono_contacto(txtTelContacto);
                cc.setCorreo_electronico(txtCorreoBanco);
                /*try {
                    BancoDao.create(cc);
                } catch (Exception ex) {
                    Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
                }*/
               // Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
               // JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
//                cmbIDBanco.setSelectedIndex(1);
//                cmbIDBanco.setSelectedIndex(0);
//                createTableBanco();
//                createComboBoxBanco();
//                createComboIDBancoPrestamo();
//                btnDesactivar.setEnabled(false);
//                btnAgregar.setEnabled(true);
//                btnModificar.setEnabled(false);
            }
        }
        return 100;
    }
    
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try{
        if(cmbIDBanco.getSelectedIndex()!=0){
            JOptionPane.showMessageDialog(null, "El ID Banco siempre debe estar en el ITEM de Nuevo para agregar un nuevo Banco","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDBanco.setSelectedIndex(0);
        }
        else{

        }
        if("".equals(txtNombreBanco.getText().trim()) ){
            JOptionPane.showMessageDialog(null,"El campo del nombre del Banco esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if (ValidacionTresletras(txtNombreBanco.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Banco la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreBanco.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if((txtNombreBanco.getText().length()<3)){
            JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 3 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if((txtNombreBanco.getText().length()>20)){
            JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 20 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if (!ValidacionNombreMayuscula(txtNombreBanco.getText().trim())){
                JOptionPane.showMessageDialog(null,"El nombre del Banco debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreBanco.requestFocus(); 
                        return;
                    }else{
                        
                     }
        
        if("".equals(txtNombreContacto.getText().trim())){
                JOptionPane.showMessageDialog(null, "El campo del nombre del Contacto esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
        if(txtNombreContacto.getText().length()<10){
                JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 10 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
        if(txtNombreContacto.getText().length()>45){
                JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 50 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
        if (!ValidacionNombreMayuscula(txtNombreContacto.getText().trim())){
                JOptionPane.showMessageDialog(null,"El nombre del Contacto debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreContacto.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if (ValidacionTresletras(txtNombreContacto.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Contacto la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreContacto.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtTelContacto.getText().trim())) {
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el teléfono del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
        if(txtTelContacto.getText().length()<8) {
               JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 digítos","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
        if(txtTelContacto.getText().length()>8) {
               JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 números como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
           if (!telefono(txtTelContacto.getText())){
           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           txtTelContacto.requestFocus();
           return;
            }else{
           
            }
           
           if("".equals(txtCorreoBanco.getText().trim())){
               JOptionPane.showMessageDialog(null, "El campo de  correo electrónico del Banco esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{
           }
           
           if(txtCorreoBanco.getText().length()<13){
               JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 13 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{
           }
           if(txtCorreoBanco.getText().length()>35){
               JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 35 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{
           }
           if (!correo(txtCorreoBanco.getText())){
            JOptionPane.showMessageDialog(null,"Formato de correo electrónico incorrecto","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
        }
        
        if("".equals(txtNombreBanco.getText()) ){
            //JOptionPane.showMessageDialog(null,"El campo del nombre del Banco esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<BancoDao.findBancoEntities().size();i++){
                if(txtNombreBanco.getText().toLowerCase().equals(BancoDao.findBanco(i+1).getNombre_banco())){
                    JOptionPane.showMessageDialog(null, "Ya existe este Banco registrado en el sistema","Error!", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                Banco cc = new Banco();
                cc.setEstado(true);
                cc.setNombre_banco(txtNombreBanco.getText());
                cc.setNombre_contacto(txtNombreContacto.getText());
                cc.setTelefono_contacto(txtTelContacto.getText());
                cc.setCorreo_electronico(txtCorreoBanco.getText());
                
                    BancoDao.create(cc);
                
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
//                cmbIDBanco.setSelectedIndex(1);
                cmbIDBanco.setSelectedIndex(0);
                createTableBanco();
                createComboBoxBanco();
                createComboIDBancoPrestamo();
                btnDesactivar.setEnabled(false);
                btnAgregar.setEnabled(true);
                btnModificar.setEnabled(false);
            }
        }
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"BancoAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
private boolean correo(String correo_elec){

        Pattern pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        Matcher mat =pat.matcher(correo_elec);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
    private void txtCorreoBancoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoBancoFocusLost

    }//GEN-LAST:event_txtCorreoBancoFocusLost
 private boolean ValidacionTresletras(String Validar){
        
        Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*|.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*|.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            Matcher mat = pat.matcher(Validar);
            
            if(mat.matches()){
                return true;   
            }
            else{
               return false; 
            }
    }
    private void txtCorreoBancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoBancoKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c != 'ñ' && c != '.' && c != ';' && c != ',' && c != '#'&& c!='@' && c != ':'&& c != '-')&&(c < '0' || c > '9')&&(c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú') && (c!=KeyEvent.VK_SPACE)){

            evt.consume();

        }
              
        if (txtCorreoBanco.getText().length() >= 35){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_txtCorreoBancoKeyTyped

    private void txtTelContactoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelContactoFocusLost

    }//GEN-LAST:event_txtTelContactoFocusLost

   private boolean telefono(String tel){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[2|3|7|8|9]{1}[0-9]{2,10}$");
        mat =pat.matcher(tel);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }

    }
private boolean ValidacionRangoTasaInteres(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("([0][.][0][5]|[0][.][0][5-9]|[0][.][1-3][0-9]|[0][.][4][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
private boolean ValidacionRangoMontoPrestamo(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([5][,][0][0][0][.][0][0]|[5-9][,][0-9][0-9][0-9][.][0-9][0-9]|[1-9][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[1-9][0-9][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[1][,][0][0][0][,][0][0][0][.][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
private boolean ValidacionRangoCuotas(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("([2]|[2-9]|[1-9][0-9]|[1-3][0-9][0-9]|[4][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
private boolean ValidacionNumeros(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }

    
    
    private void txtTelContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelContactoKeyTyped

                 char c = evt.getKeyChar();
        String Texto = txtTelContacto.getText();
        //JOptionPane.showMessageDialog(null,c);
        if((c < '0' || c > '9')){

            evt.consume();

        }
              
        if (txtTelContacto.getText().length() >= 8){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_txtTelContactoKeyTyped

    private void txtNombreContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreContactoKeyTyped
char c = evt.getKeyChar();
        if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z' && c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }
              
        if (txtNombreContacto.getText().length() >= 50){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_txtNombreContactoKeyTyped

    private void txtNombreBancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBancoKeyTyped
char c = evt.getKeyChar();
        if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z' && c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }
              
        if (txtNombreBanco.getText().length() >= 25){
        
        evt.consume();
        
        }
        
        
    }//GEN-LAST:event_txtNombreBancoKeyTyped

    public int btnModificarActionPerfomed(int cmbIDBanco,String txtNombreBanco,String txtNombreContacto, String txtTelContacto,String txtCorreoBanco){
        if(cmbIDBanco==0){
            //JOptionPane.showMessageDialog(null, "Banco no encontrado");
        }
        else{
if("".equals(txtNombreBanco.trim()) ){
            //JOptionPane.showMessageDialog(null,"El campo del nombre del Banco esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            
        }
        if (ValidacionTresletras(txtNombreBanco)){
                //JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Banco la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        //txtNombreBanco.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        if((txtNombreBanco.length()<3)){
            //JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 3 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            
        }
        if((txtNombreBanco.length()>20)){
            //JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 20 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            
        }
        if (!ValidacionNombreMayuscula(txtNombreBanco)){
//                JOptionPane.showMessageDialog(null,"El nombre del Banco debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
//                        txtNombreBanco.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        
        if("".equals(txtNombreContacto.trim())){
                //JOptionPane.showMessageDialog(null, "El campo del nombre del Contacto esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;   
            }
            else{
                         
            }
        if(txtNombreContacto.length()<10){
                //JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 10 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;   
            }
            else{
                         
            }
        if(txtNombreContacto.length()>45){
                //JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 50 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;   
            }
            else{
                         
            }
        if (!ValidacionNombreMayuscula(txtNombreContacto)){
//                JOptionPane.showMessageDialog(null,"El nombre del Contacto debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
//                        txtNombreContacto.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        if (ValidacionTresletras(txtNombreContacto)){
                //JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Contacto la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        //txtNombreContacto.requestFocus(); 
                        return 0;
                    }else{
                        
                     }
        if("".equals(txtTelContacto.trim())) {
              // JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el teléfono del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
           else{
           }
        if(txtTelContacto.length()<8) {
              // JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 números como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
           else{
           }
        if(txtTelContacto.length()>8) {
             //  JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 números como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
           else{
           }
           if (!telefono(txtTelContacto)){
           //JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           //txtTelContacto.requestFocus();
           return 0;
            }else{
           
            }
           
           if("".equals(txtCorreoBanco.trim())){
               //JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del Banco","Error!", JOptionPane.ERROR_MESSAGE);
               return 0;
           }
            else{
           }
           
           if(txtCorreoBanco.length()<13){
//               JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 13 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
               return 0;
           }
            else{
           }
           if(txtCorreoBanco.length()>35){
               //JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 35 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
               return 0;
           }
            else{
           }
           if (!correo(txtCorreoBanco)){
            //JOptionPane.showMessageDialog(null,"Formato de correo electrónico incorrecto","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }else{
        }
if("".equals(txtCorreoBanco)){
               //JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del Banco","Error!", JOptionPane.ERROR_MESSAGE);
               return 0;
           }
            else{

            Banco tp = new Banco();
            tp.setEstado(true);
            tp=BancoDao.findBanco(cmbIDBanco);
            tp.setNombre_banco(txtNombreBanco);
            tp.setNombre_contacto(txtNombreContacto);
            tp.setTelefono_contacto(txtTelContacto);
            tp.setCorreo_electronico(txtCorreoBanco);
                  /*  try {
                        BancoDao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
//                Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
//                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
//                cmbIDBanco.setSelectedIndex(1);
//                cmbIDBanco.setSelectedIndex(0);
//                createTableBanco();
//                btnDesactivar.setEnabled(false);
//                btnAgregar.setEnabled(true);
//                btnModificar.setEnabled(false);
        }
}
        return 100;
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try{
        
        if(cmbIDBanco.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Banco no encontrado");
        }
        else{
if("".equals(txtNombreBanco.getText().trim()) ){
            JOptionPane.showMessageDialog(null,"El campo del nombre del Banco esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if (ValidacionTresletras(txtNombreBanco.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Banco la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreBanco.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if((txtNombreBanco.getText().length()<3)){
            JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 3 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if((txtNombreBanco.getText().length()>20)){
            JOptionPane.showMessageDialog(null,"El nombre del Banco solo puede tener 20 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if (!ValidacionNombreMayuscula(txtNombreBanco.getText())){
                JOptionPane.showMessageDialog(null,"El nombre del Banco debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreBanco.requestFocus(); 
                        return;
                    }else{
                        
                     }
        
        if("".equals(txtNombreContacto.getText().trim())){
                JOptionPane.showMessageDialog(null, "El campo del nombre del Contacto esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
        if(txtNombreContacto.getText().length()<10){
                JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 10 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
        if(txtNombreContacto.getText().length()>45){
                JOptionPane.showMessageDialog(null, "El nombre del Contacto solo puede tener 50 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
        if (!ValidacionNombreMayuscula(txtNombreContacto.getText())){
                JOptionPane.showMessageDialog(null,"El nombre del Contacto debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreContacto.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if (ValidacionTresletras(txtNombreContacto.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Contacto la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreContacto.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtTelContacto.getText().trim())) {
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el teléfono del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
        if(txtTelContacto.getText().length()<8) {
               JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 números como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
        if(txtTelContacto.getText().length()>8) {
               JOptionPane.showMessageDialog(null, "El teléfono del Contacto solo puede tener 8 números como máximo","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
           if (!telefono(txtTelContacto.getText())){
           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           txtTelContacto.requestFocus();
           return;
            }else{
           
            }
           
           if("".equals(txtCorreoBanco.getText().trim())){
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del Banco","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{
           }
           
           if(txtCorreoBanco.getText().length()<13){
               JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 13 caracteres como mínimo","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{
           }
           if(txtCorreoBanco.getText().length()>35){
               JOptionPane.showMessageDialog(null, "El correo electrónico del Banco solo puede tener 35 caracteres como máximo","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{
           }
           if (!correo(txtCorreoBanco.getText())){
            JOptionPane.showMessageDialog(null,"Formato de correo electrónico incorrecto","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
        }
if("".equals(txtCorreoBanco.getText())){
               //JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del Banco","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{

            Banco tp = new Banco();
            tp.setEstado(true);
            tp=BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
            tp.setNombre_banco(txtNombreBanco.getText());
            tp.setNombre_contacto(txtNombreContacto.getText());
            tp.setTelefono_contacto(txtTelContacto.getText());
            tp.setCorreo_electronico(txtCorreoBanco.getText());
                    try {
                        BancoDao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                cmbIDBanco.setSelectedIndex(1);
                cmbIDBanco.setSelectedIndex(0);
                createTableBanco();
                btnDesactivar.setEnabled(false);
                btnAgregar.setEnabled(true);
                btnModificar.setEnabled(false);
        }
}
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"Banco+Modificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //        cmbIDCliente.setSelectedIndex(1);
        try{
        cmbIDBanco.setSelectedIndex(0);
        createTableBanco();
        createComboBoxBanco();
        btnDesactivar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnBuscar.setEnabled(true);
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"BancoLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //JOptionPane.showMessageDialog(null,"Datos limpiados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public boolean DesactivarBanco(){
        Banco temp;
        temp = BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Banco Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Banco Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            BancoDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableBanco();
        btnActivarDesactivarBanco();
        btnDesactivar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        return true;
    }
    
    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        try{
        Banco temp;
        temp = BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Banco Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Banco Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        try {
            BancoDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableBanco();
        btnActivarDesactivarBanco();
        btnDesactivar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"BancoDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void tblBancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBancoMouseClicked
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnBuscar.setEnabled(false);
        int column=0;
        int fila = tblBanco.getSelectedRow();
        if (fila > -1){
            cmbIDBanco.setSelectedIndex(Integer.parseInt(tblBanco.getModel().getValueAt(fila, column).toString()));
            txtNombreBanco.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));
            txtNombreContacto.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));
            txtTelContacto.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));
            txtCorreoBanco.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));

            btnActivarDesactivarBanco();
        }
    }//GEN-LAST:event_tblBancoMouseClicked

    private void BuscarBanco1(){
        if("".equals(txtNombreBanco.getText())){
            JOptionPane.showMessageDialog(null,"El campo de nombre del banco esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
     
        }
        List<Banco> tempp = BancoDao.findBancoEntities();
        boolean bandera = false;
            for(Banco e: tempp) {
                if((e.getNombre_banco()).equalsIgnoreCase(txtNombreBanco.getText()) || BancoDao.equals(e)){
                    cmbIDBanco.setSelectedItem(e.getId_banco());
                    //txtNombreBanco.setText(e.getNombre_banco());
                    txtNombreContacto.setText(e.getNombre_contacto());
                    txtTelContacto.setText(e.getTelefono_contacto());
                    txtCorreoBanco.setText(e.getCorreo_electronico());
                    bandera=true;
                    
                }  
                else{
                          
                }
                
            }
            if(!bandera){
                    JOptionPane.showMessageDialog(null,"El banco que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE);
                }
            

}
   public boolean BuscarBancoTest(){
        if("".equals(txtNombreBanco.getText())){
            //JOptionPane.showMessageDialog(null,"El campo de nombre del banco esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
     
        }
        List<Banco> tempp = BancoDao.findBancoEntities();
        boolean bandera = false;
            for(Banco e: tempp) {
                if((e.getNombre_banco()).equalsIgnoreCase(txtNombreBanco.getText()) || BancoDao.equals(e)){
                    cmbIDBanco.setSelectedItem(e.getId_banco());
                    //txtNombreBanco.setText(e.getNombre_banco());
                    txtNombreContacto.setText(e.getNombre_contacto());
                    txtTelContacto.setText(e.getTelefono_contacto());
                    txtCorreoBanco.setText(e.getCorreo_electronico());
                    bandera=true;
                    
                }  
                else{
                          
                }
                
            }
            if(!bandera){
                    //JOptionPane.showMessageDialog(null,"El banco que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;

}
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    public int btnAgrear1ActionPerfomed(int cmbIDPrestamo,int cmbIDBancoPrestamo,int cmbIDClientePrestamo,String txtMontoPrestamo,String txtCuotasPrestamo,String txtTasaPrestamo){
        Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
        List<Detalle_Banco_Cliente> temporal = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        if(cmbIDPrestamo==0){    
            }
           else{ 
           }
        if(cmbIDBancoPrestamo==0){
            //JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Banco","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        Banco tempoc;
        tempoc = BancoDao.findBanco(cmbIDBancoPrestamo);
        if(tempoc.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Banco esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        
        for(Detalle_Banco_Cliente tp: temporal){
        if(tp.getId_cliente()==cmbIDClientePrestamo||tp.isEstado()==false){
           // JOptionPane.showMessageDialog(null,"Este Cliente todavia tiene un Préstamo activo","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        }
        if(cmbIDClientePrestamo==0){
           // JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Cliente","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        Cliente tempop;
        tempop = ClienteDao.findCliente(cmbIDClientePrestamo);
        if(tempop.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este cliente esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        if("".equals(txtMontoPrestamo)){
            //JOptionPane.showMessageDialog(null, "El campo Monto del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
           if (!ValidacionRangoMontoPrestamo(txtMontoPrestamo)){
           //JOptionPane.showMessageDialog(null,"El rango de Monto del Préstamo solo puede estar entre 5,000.00-1,000,000.00","Error!", JOptionPane.ERROR_MESSAGE);
           //txtMontoPrestamo.requestFocus();
           return 0;
            }else{
           
            }
        if("".equals(txtCuotasPrestamo)){
            //JOptionPane.showMessageDialog(null, "El campo Cuotas del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
           if (!ValidacionRangoCuotas(txtCuotasPrestamo)){
//           JOptionPane.showMessageDialog(null,"El rango de Cuotas del Préstamo solo puede estar entre 2-400","Error!", JOptionPane.ERROR_MESSAGE);
//           txtCuotasPrestamo.requestFocus();
           return 0;
            }else{
           
            }
        
        if("".equals(txtTasaPrestamo)){
            //JOptionPane.showMessageDialog(null, "El campo Tasa de Interés esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        if (!ValidacionRangoTasaInteres(txtTasaPrestamo)){
//           JOptionPane.showMessageDialog(null,"El rango de Tasa de Interés solo puede estar entre 0.05-0.40","Error!", JOptionPane.ERROR_MESSAGE);
//           txtTasaPrestamo.requestFocus();
           return 0;
            }else{
           
            }
           
           temp.setNumero_prestamo(DetalleBancoClienteDao.getDetalle_Banco_ClienteCount()+1);
           temp.setEstado(true);
           temp.setId_banco(cmbIDBancoPrestamo);
           temp.setId_cliente(cmbIDClientePrestamo);
           double auxmonto=(Double.parseDouble(txtMontoPrestamo.replace(",", "").replace(",", "").trim()));
           temp.setMonto_prestamo(auxmonto);
           double auxtasa=(Double.parseDouble(txtTasaPrestamo.replace(",", "").replace(",", "").trim()));
           temp.setTasa_interes(auxtasa);
           int auxcuota=(Integer.parseInt(txtCuotasPrestamo.trim()));
           temp.setCuota(auxcuota);
           temp.setValor_interes(auxmonto*(auxtasa)*(auxtasa));
           temp.setValor_capital((auxmonto*(auxtasa)*(auxtasa))+auxmonto);
           Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<9)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
           //JOptionPane.showMessageDialog(null,aux2);
           switch(aux2){
            case "01":
                    aux2= "01";
                    break;
                    case "02":
                    aux2= "02";
                    break;case "03":
                    aux2= "03";
                    break;case "04":
                    aux2= "04";
                    break;case "05":
                   aux2= "05";
                    break;case "06":
                    aux2= "06";
                    break;case "07":
                    aux2= "07";
                    break;case "08":
                    aux2= "08";
                    break;case "09":
                    aux2= "09";
                    break;
            case "010":
                    aux2= "10";
                    break;
            case "011":
                   aux2= "11";
                    break;      
            case "012":
                    aux2= "12";
                    break;
                    default:
                    break;
        }
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           temp.setFecha_inicio(fecha1);
           
        /*try {
            DetalleBancoClienteDao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
        }*/
//         cmbIDPrestamo.setSelectedIndex(1);
//        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
//        JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
//           cmbIDPrestamo.setSelectedIndex(0);
//           createTablePrestamo();
//           createComboIDBancoPrestamo();
//           createComboCliente();
//           btnAgregar1.setEnabled(true);
//           btnModificar1.setEnabled(false);
//           LimpiarPre();
           return 100;
    }
    
    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed

        try{
        Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
        List<Detalle_Banco_Cliente> temporal = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        if(cmbIDPrestamo.getSelectedIndex()==0){    
            }
           else{ 
           }
        if(cmbIDBancoPrestamo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Banco","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Banco tempoc;
        tempoc = BancoDao.findBanco(cmbIDBancoPrestamo.getSelectedIndex());
        if(tempoc.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"Este Banco esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        
        for(Detalle_Banco_Cliente tp: temporal){
        if(tp.getId_cliente()==cmbIDClientePrestamo.getSelectedIndex()||tp.isEstado()==false){
            JOptionPane.showMessageDialog(null,"Este Cliente todavia tiene un Préstamo activo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        }
        if(cmbIDClientePrestamo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Cliente","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Cliente tempop;
        tempop = ClienteDao.findCliente(cmbIDClientePrestamo.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"Este cliente esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if("".equals(txtMontoPrestamo.getText())){
            JOptionPane.showMessageDialog(null, "El campo Monto del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
           if (!ValidacionRangoMontoPrestamo(txtMontoPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El rango de Monto del Préstamo solo puede estar entre 5,000.00-1,000,000.00","Error!", JOptionPane.ERROR_MESSAGE);
           txtMontoPrestamo.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtCuotasPrestamo.getText())){
            JOptionPane.showMessageDialog(null, "El campo Cuotas del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
           if (!ValidacionRangoCuotas(txtCuotasPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El rango de Cuotas del Préstamo solo puede estar entre 2-400","Error!", JOptionPane.ERROR_MESSAGE);
           txtCuotasPrestamo.requestFocus();
           return;
            }else{
           
            }
        
        if("".equals(txtTasaPrestamo.getText())){
            JOptionPane.showMessageDialog(null, "El campo Tasa de Interés esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionRangoTasaInteres(txtTasaPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El rango de Tasa de Interés solo puede estar entre 0.05-0.40","Error!", JOptionPane.ERROR_MESSAGE);
           txtTasaPrestamo.requestFocus();
           return;
            }else{
           
            }
           
           temp.setNumero_prestamo(DetalleBancoClienteDao.getDetalle_Banco_ClienteCount()+1);
           temp.setEstado(true);
           temp.setId_banco(cmbIDBancoPrestamo.getSelectedIndex());
           temp.setId_cliente(cmbIDClientePrestamo.getSelectedIndex());
           double auxmonto=(Double.parseDouble(txtMontoPrestamo.getText().replace(",", "").replace(",", "").trim()));
           temp.setMonto_prestamo(auxmonto);
           double auxtasa=(Double.parseDouble(txtTasaPrestamo.getText().replace(",", "").replace(",", "").trim()));
           temp.setTasa_interes(auxtasa);
           int auxcuota=(Integer.parseInt(txtCuotasPrestamo.getText().trim()));
           temp.setCuota(auxcuota);
           temp.setValor_interes(auxmonto*(auxtasa)*(auxtasa));
           temp.setValor_capital((auxmonto*(auxtasa)*(auxtasa))+auxmonto);
           Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<9)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
           //JOptionPane.showMessageDialog(null,aux2);
           switch(aux2){
            case "01":
                    aux2= "01";
                    break;
                    case "02":
                    aux2= "02";
                    break;case "03":
                    aux2= "03";
                    break;case "04":
                    aux2= "04";
                    break;case "05":
                   aux2= "05";
                    break;case "06":
                    aux2= "06";
                    break;case "07":
                    aux2= "07";
                    break;case "08":
                    aux2= "08";
                    break;case "09":
                    aux2= "09";
                    break;
            case "010":
                    aux2= "10";
                    break;
            case "011":
                   aux2= "11";
                    break;      
            case "012":
                    aux2= "12";
                    break;
                    default:
                    break;
        }
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           temp.setFecha_inicio(fecha1);
           
        
            DetalleBancoClienteDao.create(temp);
        
//         cmbIDPrestamo.setSelectedIndex(1);
        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
        JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
           cmbIDPrestamo.setSelectedIndex(0);
           createTablePrestamo();
           createComboIDBancoPrestamo();
           createComboCliente();
           btnAgregar1.setEnabled(true);
           btnModificar1.setEnabled(false);
           LimpiarPre();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PrestamoAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void cmbIDPrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPrestamoItemStateChanged
        if(cmbIDPrestamo.getSelectedIndex()==0){
        }
        else{
        Detalle_Banco_Cliente tp;
        tp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
        }
    }//GEN-LAST:event_cmbIDPrestamoItemStateChanged

    private boolean ValidacionFechaDDMMYYYY(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?:(?:(?:0[1-9]|1\\d|2[0-8])[/](?:0[1-9]|1[0-2])|(?:29|30)[/](?:0[13-9]|1[0-2])|31[/](?:0[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\\d|0?[1-9]\\d{2}|[1-9]\\d{3})|29[/]0?2[/](?:\\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
        private boolean ValidacionNombreMayuscula(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.{3,40}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean ValidacionFechaDMYYYY(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?:(?:(?:0?[1-9]|1\\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\\d|0?[1-9]\\d{2}|[1-9]\\d{3})|29[/]0?2[/](?:\\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
    private void cmbIDPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPrestamoActionPerformed
    private void setFechatxt(){
        
        Calendar fecha = new GregorianCalendar();
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        
        txtFechaFinalPrestamo.setText(aux1+"-"+aux2+"-"+aux3);
        
    }
    private void tblPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrestamoMouseClicked
        btnAgregar1.setEnabled(false);
        btnModificar1.setEnabled(true);
        btnBuscar1.setEnabled(false);
        btnBuscar2.setEnabled(false);
        txtFechaFinalPrestamo.setEnabled(true);
        btnDesactivar1.setEnabled(true);
        int column=0;
        int fila = tblPrestamo.getSelectedRow();
        if (fila > -1){
            DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
            separadoresPersonalizados.setDecimalSeparator('.');
            DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
            Detalle_Banco_Cliente temp = DetalleBancoClienteDao.findDetalle_Banco_Cliente(Integer.parseInt(tblPrestamo.getModel().getValueAt(fila, column).toString()));
            List<Cliente> tempc = ClienteDao.findClienteEntities();
            List<Persona> tempp = PersonaDao.findPersonaEntities();
            List<Banco> tempb = BancoDao.findBancoEntities();
            String auxfechab="";
            for (Banco b : tempb) {
                if(b.getId_banco()!=temp.getId_banco()){
                } else {
                    for (Cliente cc : tempc) {
                        if(temp.getId_cliente()==cc.getId_cliente()){
                            for (Persona pp : tempp) {
                                if(pp.getId_persona()!=cc.getId_Persona()){
                                } else {
                                    cmbIDPrestamo.setSelectedIndex((temp.getNumero_prestamo()));
                                    cmbIDBancoPrestamo.setSelectedItem((b.getId_banco()+". "+b.getNombre_banco()));
                                    cmbIDClientePrestamo.setSelectedItem((cc.getId_cliente()+". "+pp.getNombre()+" "+pp.getApellido()));
                                    txtMontoPrestamo.setText(String.format("%,.2f",temp.getMonto_prestamo()));
                                    txtCuotasPrestamo.setText(String.valueOf(temp.getCuota()));
                                    txtTasaPrestamo.setText(String.format("%,.2f",temp.getTasa_interes()));
                                    if(temp.getFecha_final()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(temp.getFecha_final().substring(8, 10)+"/"+temp.getFecha_final().substring(5, 7)+"/"+temp.getFecha_final().substring(0, 4));
                                    }
                                    txtFechaFinalPrestamo.setText(auxfechab);
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }//GEN-LAST:event_tblPrestamoMouseClicked

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        
        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed

       // FrmMenu m = new FrmMenu();
       // m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void cmbIDBancoPrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDBancoPrestamoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDBancoPrestamoItemStateChanged

    private void cmbIDBancoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDBancoPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDBancoPrestamoActionPerformed

    private void cmbIDClientePrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDClientePrestamoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDClientePrestamoItemStateChanged

    private void cmbIDClientePrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDClientePrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDClientePrestamoActionPerformed

    private void txtMontoPrestamoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoPrestamoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoPrestamoFocusLost

    private void txtMontoPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoPrestamoKeyTyped

                 
                char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '.' && c != ',')){

            evt.consume();

        }
        if (txtMontoPrestamo.getText().length() >= 12){
        
        evt.consume();
        }
    
         /*if((evt.getKeyChar() == 22)){
        
            Txt_ApellidoCliente.setText(Texto.substring(0, 20));
                    
        }*/
          
        /*if (Txt_ApellidoCliente.getText().length() == 1){

            char mayuscula = Texto.charAt(0);
            Texto = Character.toUpperCase(mayuscula)+ Texto.substring(1,Texto.length());
            Txt_ApellidoCliente.setText(Texto);

        }*/
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoPrestamoKeyTyped

    private void txtCuotasPrestamoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCuotasPrestamoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuotasPrestamoFocusLost

    private void txtCuotasPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuotasPrestamoKeyTyped
char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (txtCuotasPrestamo.getText().length() >= 4){
        
        evt.consume();
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuotasPrestamoKeyTyped

    private void txtTasaPrestamoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTasaPrestamoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTasaPrestamoFocusLost

    private void txtTasaPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTasaPrestamoKeyTyped

        char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '.')){

            evt.consume();

        }
        if (txtTasaPrestamo.getText().length() >= 4){
        
        evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTasaPrestamoKeyTyped
private void LimpiarPre(){
        cmbIDPrestamo.setSelectedIndex(0);
        cmbIDBancoPrestamo.setSelectedIndex(0);
        cmbIDClientePrestamo.setSelectedIndex(0);
        txtMontoPrestamo.setText("");
        txtCuotasPrestamo.setText("");
        txtTasaPrestamo.setText("");
        txtFechaFinalPrestamo.setText("");
        createTablePrestamo();
        createComboBoxPrestamo();
        btnBuscar1.setEnabled(true);
        btnBuscar2.setEnabled(true);
        
        
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnDesactivar1.setEnabled(false);
}
    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        try{
        LimpiarPre();}
        catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PrestamoLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    public int btnModificar1ActionPerfomed(int cmbIDPrestamo,int cmbIDBancoPrestamo,int cmbIDClientePrestamo,String txtMontoPrestamo,String txtCuotasPrestamo,String txtTasaPrestamo, String txtFechaFinalPrestamo){
        Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
        List<Detalle_Banco_Cliente> temporal = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();                
        if(cmbIDPrestamo==0){    
            }
           else{ 
           }
if(cmbIDBancoPrestamo==0){
            //JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Banco","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        Banco tempoc;
        tempoc = BancoDao.findBanco(cmbIDBancoPrestamo);
        if(tempoc.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Banco esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        if(cmbIDClientePrestamo==0){
            //JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Cliente","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        Cliente tempop;
        tempop = ClienteDao.findCliente(cmbIDClientePrestamo);
        if(tempop.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este cliente esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        if("".equals(txtMontoPrestamo)){
           //JOptionPane.showMessageDialog(null, "El campo Monto del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
           if (!ValidacionRangoMontoPrestamo(txtMontoPrestamo)){
//           JOptionPane.showMessageDialog(null,"El rango de Monto del Préstamo solo puede estar entre 5,000.00-1,000,000.00","Error!", JOptionPane.ERROR_MESSAGE);
//           txtMontoPrestamo.requestFocus();
           return 0;
            }else{
           
            }
        if("".equals(txtCuotasPrestamo)){
            //JOptionPane.showMessageDialog(null, "El campo Cuotas del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
           if (!ValidacionRangoCuotas(txtCuotasPrestamo)){
//           JOptionPane.showMessageDialog(null,"El rango de Cuotas del Préstamo solo puede estar entre 2-400","Error!", JOptionPane.ERROR_MESSAGE);
//           txtCuotasPrestamo.requestFocus();
           return 0;
            }else{
           
            }
        
        if("".equals(txtTasaPrestamo)){
            //JOptionPane.showMessageDialog(null, "El campo Tasa de Interés esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        if (!ValidacionRangoTasaInteres(txtTasaPrestamo)){
//           JOptionPane.showMessageDialog(null,"El rango de Tasa de Interés solo puede estar entre 0.05-0.40","Error!", JOptionPane.ERROR_MESSAGE);
//           txtTasaPrestamo.requestFocus();
           return 0;
            }else{
           
            }
        if("".equals(txtTasaPrestamo)){
            //JOptionPane.showMessageDialog(null, "El campo de Fecha Final del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        if (!ValidacionFechaDDMMYYYY(txtFechaFinalPrestamo)){
//           JOptionPane.showMessageDialog(null,"El Formato de fecha es Incorrecto! El formato debe ser DD/MM/YYYY","Error!", JOptionPane.ERROR_MESSAGE);
//           txtFechaFinalPrestamo.requestFocus();
           return 0;
            }else{
            }
           //temp.setNumero_prestamo(DetalleBancoClienteDao.getDetalle_Banco_ClienteCount());
           temp.setId_banco(cmbIDBancoPrestamo);
           temp.setId_cliente(cmbIDClientePrestamo);
           temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo);
           //temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDBancoPrestamo.getSelectedIndex());
           //temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDClientePrestamo.getSelectedIndex());
           double auxmonto=(Double.parseDouble(txtMontoPrestamo.replace(",", "").replace(",", "").trim()));
           temp.setMonto_prestamo(auxmonto);
           double auxtasa=(Double.parseDouble(txtTasaPrestamo.replace(",", "").replace(",", "").trim()));
           temp.setTasa_interes(auxtasa);
           int auxcuota=(Integer.parseInt(txtCuotasPrestamo.trim()));
           temp.setCuota(auxcuota);
           temp.setValor_interes(auxmonto*(auxtasa)*(auxtasa));
           temp.setValor_capital((auxmonto*(auxtasa)*(auxtasa))+auxmonto);
           String auxfecha="";
           String auxfechafinal="";
           String anio="";
           String mes="";
           String dia="";
           auxfecha=txtFechaFinalPrestamo;
           anio=auxfecha.substring(6,10);
           mes=auxfecha.substring(3,5);
           dia=auxfecha.substring(0,2);
           auxfechafinal=anio+"-"+mes+"-"+dia;
           
        LocalDate f1,f2 ;
        LocalDate fechaActual = LocalDate.now();
        for(Detalle_Banco_Cliente tempp : temporal){
            if(cmbIDPrestamo==tempp.getNumero_prestamo()){
            f1 = LocalDate.parse(tempp.getFecha_inicio());
            f2 = LocalDate.parse(auxfechafinal);
            if(f2.isBefore(fechaActual)){
               // JOptionPane.showMessageDialog(null,"La Fecha Final debe ser después de la Fecha Inicial","Error!", JOptionPane.ERROR_MESSAGE);   
                return 0;
            } 
            }
        }
           temp.setFecha_final(auxfechafinal);
           
        /*try {
            DetalleBancoClienteDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
        }*/
//           Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
//           JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
//           cmbIDPrestamo.setSelectedIndex(0);
//           createTablePrestamo();
//           createComboIDBancoPrestamo();
//           createComboCliente();
//           LimpiarPre();
//           btnAgregar1.setEnabled(true);
//           btnModificar1.setEnabled(false);
        return 100;
    }
    
    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed

        try{
        Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
        List<Detalle_Banco_Cliente> temporal = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();                
        if(cmbIDPrestamo.getSelectedIndex()==0){    
            }
           else{ 
           }
if(cmbIDBancoPrestamo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Banco","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Banco tempoc;
        tempoc = BancoDao.findBanco(cmbIDBancoPrestamo.getSelectedIndex());
        if(tempoc.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"Este Banco esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(cmbIDClientePrestamo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Cliente","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Cliente tempop;
        tempop = ClienteDao.findCliente(cmbIDClientePrestamo.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"Este cliente esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if("".equals(txtMontoPrestamo.getText())){
            JOptionPane.showMessageDialog(null, "El campo Monto del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
           if (!ValidacionRangoMontoPrestamo(txtMontoPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El rango de Monto del Préstamo solo puede estar entre 5,000.00-1,000,000.00","Error!", JOptionPane.ERROR_MESSAGE);
           txtMontoPrestamo.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtCuotasPrestamo.getText())){
            JOptionPane.showMessageDialog(null, "El campo Cuotas del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
           if (!ValidacionRangoCuotas(txtCuotasPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El rango de Cuotas del Préstamo solo puede estar entre 2-400","Error!", JOptionPane.ERROR_MESSAGE);
           txtCuotasPrestamo.requestFocus();
           return;
            }else{
           
            }
        
        if("".equals(txtTasaPrestamo.getText())){
            JOptionPane.showMessageDialog(null, "El campo Tasa de Interés esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionRangoTasaInteres(txtTasaPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El rango de Tasa de Interés solo puede estar entre 0.05-0.40","Error!", JOptionPane.ERROR_MESSAGE);
           txtTasaPrestamo.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtTasaPrestamo.getText())){
            JOptionPane.showMessageDialog(null, "El campo de Fecha Final del Préstamo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionFechaDDMMYYYY(txtFechaFinalPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El Formato de fecha es Incorrecto! El formato debe ser DD/MM/YYYY","Error!", JOptionPane.ERROR_MESSAGE);
           txtFechaFinalPrestamo.requestFocus();
           return;
            }else{
            }
           //temp.setNumero_prestamo(DetalleBancoClienteDao.getDetalle_Banco_ClienteCount());
           temp.setId_banco(cmbIDBancoPrestamo.getSelectedIndex());
           temp.setId_cliente(cmbIDClientePrestamo.getSelectedIndex());
           temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
           //temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDBancoPrestamo.getSelectedIndex());
           //temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDClientePrestamo.getSelectedIndex());
           double auxmonto=(Double.parseDouble(txtMontoPrestamo.getText().replace(",", "").replace(",", "").trim()));
           temp.setMonto_prestamo(auxmonto);
           double auxtasa=(Double.parseDouble(txtTasaPrestamo.getText().replace(",", "").replace(",", "").trim()));
           temp.setTasa_interes(auxtasa);
           int auxcuota=(Integer.parseInt(txtCuotasPrestamo.getText().trim()));
           temp.setCuota(auxcuota);
           temp.setValor_interes(auxmonto*(auxtasa)*(auxtasa));
           temp.setValor_capital((auxmonto*(auxtasa)*(auxtasa))+auxmonto);
           String auxfecha="";
           String auxfechafinal="";
           String anio="";
           String mes="";
           String dia="";
           auxfecha=txtFechaFinalPrestamo.getText();
           anio=auxfecha.substring(6,10);
           mes=auxfecha.substring(3,5);
           dia=auxfecha.substring(0,2);
           auxfechafinal=anio+"-"+mes+"-"+dia;
           
        LocalDate f1,f2 ;
        LocalDate fechaActual = LocalDate.now();
        for(Detalle_Banco_Cliente tempp : temporal){
            if(cmbIDPrestamo.getSelectedIndex()==tempp.getNumero_prestamo()){
            f1 = LocalDate.parse(tempp.getFecha_inicio());
            f2 = LocalDate.parse(auxfechafinal);
            if(f2.isBefore(fechaActual)){
                JOptionPane.showMessageDialog(null,"La Fecha Final debe ser después de la Fecha Inicial","Error!", JOptionPane.ERROR_MESSAGE);   
                return;
            } 
            }
        }
           temp.setFecha_final(auxfechafinal);
           
        
            DetalleBancoClienteDao.edit(temp);
        
           Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
           JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
           cmbIDPrestamo.setSelectedIndex(0);
           createTablePrestamo();
           createComboIDBancoPrestamo();
           createComboCliente();
           LimpiarPre();
           btnAgregar1.setEnabled(true);
           btnModificar1.setEnabled(false);
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PrestamoModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void txtNombreBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBancoActionPerformed
        
    }//GEN-LAST:event_txtNombreBancoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
        BuscarBanco1();
        }catch(Exception e){
        try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"BancoBuscar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }//GEN-LAST:event_btnBuscarActionPerformed
private void BuscarBanco2(){
        /*List<Banco> tempp = BancoDao.findBancoEntities();
        boolean bandera = false;
            for(Banco e: tempp) {
                if((e.getNombre_banco()).equalsIgnoreCase(txtIDNombreBancoP.getText())){
                    cmbIDBancoPrestamo.setSelectedIndex(e.getId_banco());
                    bandera=true;
                }  
                else{                         
                }
            }
            if(!bandera){
                    JOptionPane.showMessageDialog(null,"El banco que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE);
                }*/
        ModalBanco temp2 = new ModalBanco(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        cmbIDBancoPrestamo.setSelectedItem(temp2.getId()+". "+temp2.getNombre());
        //txtIDNombreBancoP.setText((temp2.getNombre()));
}
    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

        try{
        BuscarBanco2();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"BancoBuscar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed
private void BuscarCiente(){
        /*List<Detalle_Banco_Cliente> temp = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        boolean bandera = false;
        Persona temp3 = new Persona();
        Cliente temp2 = new Cliente();
        if("".equals(txtIDNombreCliente.getText())){
            JOptionPane.showMessageDialog(null,"El campo de nombre de cliente esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{   
        } 
                for(Detalle_Banco_Cliente c : temp){
                    temp2=ClienteDao.findCliente(c.getId_cliente());
                    temp3=PersonaDao.findPersona(temp2.getId_Persona());   
                    String auxNombre=(temp3.getNombre()+" "+temp3.getApellido());
                    if (auxNombre.equals(txtIDNombreCliente.getText())){
                    cmbIDClientePrestamo.setSelectedIndex(temp2.getId_cliente());
                    bandera=true;
                    }
                    else{                 
                    }
                }        
                if(!bandera){
                        JOptionPane.showMessageDialog(null,"El Cliente que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE); 
                    }*/
        ModalCliente temp2 = new ModalCliente(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        cmbIDClientePrestamo.setSelectedItem(temp2.getId()+". "+temp2.getNombre()+" "+temp2.getApellido());
}
    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        try{
        BuscarCiente();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh;
                fh = new FileHandler("./"+"PrestamoBuscarCliente"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void txtFechaFinalPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinalPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinalPrestamoActionPerformed
private void btnActivarDesactivarPrestamo(){
        Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
        temp = DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar1.setText("Desactivar");  
        btnDesactivar1.setEnabled(true);
        }
        else{
            btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar1.setText("Activar");
            btnDesactivar1.setEnabled(true);
        }
        }
    private void btnDesactivar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar1ActionPerformed

        try{
        Detalle_Banco_Cliente temp;
        temp = DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Préstamo Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Préstamo Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        try {
            DetalleBancoClienteDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablePrestamo();
        btnActivarDesactivarPrestamo();
        btnDesactivar1.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        LimpiarPre();
        }catch(Exception e){
        try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PrestamoDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnDesactivar1ActionPerformed
public boolean DesactivarPrestamo(){
       Detalle_Banco_Cliente temp;
        temp = DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Préstamo Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Préstamo Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            DetalleBancoClienteDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTablePrestamo();
        btnActivarDesactivarPrestamo();
        btnDesactivar1.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        LimpiarPre();
        return true;
}
    private void txtFechaFinalPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaFinalPrestamoKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '/')){

            evt.consume();

        }
        if (txtFechaFinalPrestamo.getText().length() >= 10){
        
        evt.consume();
        }
    }//GEN-LAST:event_txtFechaFinalPrestamoKeyTyped

    private void generarReporteBanco() throws JRException, SQLException, ClassNotFoundException, IOException, ClassNotFoundException, SQLException{
        
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteBanco.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Bancos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
    }
    
    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed

        try {
            generarReporteBanco();
            // TODO add your handling code here:
        } catch (JRException | SQLException | ClassNotFoundException | IOException e) {
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"BancoReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void generarReporteBancoExcel() throws ClassNotFoundException, SQLException, JRException, IOException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteBanco.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteBanco.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteBanco.xlsx");
        p.start();
            
    }
    
    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed

        try {
            generarReporteBancoExcel();
            // TODO add your handling code here:
        } catch (ClassNotFoundException | SQLException | JRException | IOException e) {
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"BancoReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    public void generarReportePrestamo() throws JRException, IOException{
        Object [][] arrayDetallesFactura;
        int contador = 0;
        List<Detalle_Banco_Cliente> arregloPrestamo = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        //List<PiezaFactura> arregloPiezas = new ArrayList<>();
        contador=arregloPrestamo.size();
        /*List<PiezaFactura> piezaFTemp = piezaFacturaDao.findPiezaFacturaEntities();
        for(PiezaFactura pf : piezaFTemp){
            if(pf.getIdFactura()==f.getIDFactura()){
                arregloPiezas.add(pf);
                contador++;
            }*/
        
        
        
        
        
        
        arrayDetallesFactura = new Object[contador][8];
        
        
        for(int i = 0;i<arregloPrestamo.size();i++){
            arrayDetallesFactura[i][0]=String.valueOf(i+1);
            arrayDetallesFactura[i][1]= BancoDao.findBanco(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getId_banco()).getNombre_banco();
            arrayDetallesFactura[i][2]= PersonaDao.findPersona(ClienteDao.findCliente(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getId_cliente()).getId_Persona()).getNombre()+" "+PersonaDao.findPersona(ClienteDao.findCliente(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getId_cliente()).getId_Persona()).getApellido();
            arrayDetallesFactura[i][3]= String.valueOf(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getMonto_prestamo());
            arrayDetallesFactura[i][4]= String.valueOf(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getCuota());
            arrayDetallesFactura[i][5]= String.valueOf(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getTasa_interes());
            arrayDetallesFactura[i][6]= DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getFecha_inicio();
            arrayDetallesFactura[i][7]= (DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getFecha_final()==null)? " ": DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getFecha_final();
        }

          
        
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
               
        
        
        //Persona pp = PersonaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        /*param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());*/
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportPrestamo.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,PrestamoJRDataSource.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
//            JasperViewer view = new JasperViewer(print, false);
//            view.setVisible(true);
//            view.setTitle("Factura" + Integer.parseInt("1"));
            File pdf = File.createTempFile("Reporte de Prestamos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
            ProcessBuilder p = new ProcessBuilder();
            p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
            p.start();
    }
        
    
    
    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed
        
        try {
            generarReportePrestamo();
        } catch (JRException | IOException e) {
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh;
                fh = new FileHandler("./"+"PrestamoReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void generarReportePrestamoExcel() throws IOException, JRException{
        Object [][] arrayDetallesFactura;
        int contador = 0;
        List<Detalle_Banco_Cliente> arregloPrestamo = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        //List<PiezaFactura> arregloPiezas = new ArrayList<>();
        contador=arregloPrestamo.size();
        /*List<PiezaFactura> piezaFTemp = piezaFacturaDao.findPiezaFacturaEntities();
        for(PiezaFactura pf : piezaFTemp){
            if(pf.getIdFactura()==f.getIDFactura()){
                arregloPiezas.add(pf);
                contador++;
            }*/
        
        
        
        
        
        
        arrayDetallesFactura = new Object[contador][8];
        
        
        for(int i = 0;i<arregloPrestamo.size();i++){
            arrayDetallesFactura[i][0]=String.valueOf(i+1);
            arrayDetallesFactura[i][1]= BancoDao.findBanco(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getId_banco()).getNombre_banco();
            arrayDetallesFactura[i][2]= PersonaDao.findPersona(ClienteDao.findCliente(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getId_cliente()).getId_Persona()).getNombre()+" "+PersonaDao.findPersona(ClienteDao.findCliente(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getId_cliente()).getId_Persona()).getApellido();
            arrayDetallesFactura[i][3]= String.valueOf(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getMonto_prestamo());
            arrayDetallesFactura[i][4]= String.valueOf(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getCuota());
            arrayDetallesFactura[i][5]= String.valueOf(DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getTasa_interes());
            arrayDetallesFactura[i][6]= DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getFecha_inicio();
            arrayDetallesFactura[i][7]= (DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getFecha_final()==null)? " ": DetalleBancoClienteDao.findDetalle_Banco_Cliente(i+1).getFecha_final();
        }

          
        
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
               
        
        
        //Persona pp = PersonaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        /*param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());*/
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportPrestamo.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,PrestamoJRDataSource.getDataSource(arrayDetallesFactura));
            
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reportePrestamo.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reportePrestamo.xlsx");
        p.start();
            
            
    }
    
    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed

        try {
            generarReportePrestamoExcel();
            // TODO add your handling code here:
        } catch (IOException | JRException e) {
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmBanco.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PrestamoReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar5ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnAgregar5;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnDesactivar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    public javax.swing.JComboBox<String> cmbIDBanco;
    private javax.swing.JComboBox<String> cmbIDBancoPrestamo;
    private javax.swing.JComboBox<String> cmbIDClientePrestamo;
    public javax.swing.JComboBox<String> cmbIDPrestamo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBanco;
    private javax.swing.JTable tblPrestamo;
    private javax.swing.JTextField txtCorreoBanco;
    private javax.swing.JTextField txtCuotasPrestamo;
    private javax.swing.JFormattedTextField txtFechaFinalPrestamo;
    private javax.swing.JTextField txtMontoPrestamo;
    public javax.swing.JTextField txtNombreBanco;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtTasaPrestamo;
    private javax.swing.JTextField txtTelContacto;
    // End of variables declaration//GEN-END:variables
}
