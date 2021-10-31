/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;


import Clases.Detalle_Banco_Cliente;
import Clases.HistoricoPrecioPieza;
import Clases.HistoricoPrecioVehiculos;
import Clases.Marca;
import Clases.Numero_Asientos;
import Clases.Pieza;
import Clases.TipoCabina;
import Clases.TipoGasolina;
import Clases.TipoVehiculo;
import Clases.Tipo_color;
import Clases.Vehiculo;
import Clases.transmision;
import JPAController.HistoricoPrecioVehiculosJpaController;


import JPAController.MarcaJpaController;
import JPAController.Numero_AsientosJpaController;
import JPAController.TipoCabinaJpaController;
import JPAController.TipoGasolinaJpaController;
import JPAController.TipoVehiculoJpaController;
import JPAController.Tipo_colorJpaController;
import JPAController.VehiculoJpaController;
import JPAController.transmisionJpaController;
import static Pantallas.FrmMenu.labelEmple1;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class FrmVehiculos extends javax.swing.JFrame {

    /**
     * Creates new form FrmVehiculos
     */
    
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("CarSoft");
    MarcaJpaController Marcadao = new MarcaJpaController(emf);
    Tipo_colorJpaController Colorrdao = new Tipo_colorJpaController(emf);
    TipoCabinaJpaController TipoCabinadao = new TipoCabinaJpaController(emf);
    TipoGasolinaJpaController TipoGasolinadao = new TipoGasolinaJpaController(emf);
    transmisionJpaController TipoTransmisiondao = new transmisionJpaController(emf);
    TipoVehiculoJpaController TipoVehiculodao = new TipoVehiculoJpaController(emf);
    Numero_AsientosJpaController NumeroAsientosdao = new Numero_AsientosJpaController(emf);
    VehiculoJpaController vehiculoDao = new VehiculoJpaController(emf);
    HistoricoPrecioVehiculosJpaController historicoPrecioVehiculoDao = new HistoricoPrecioVehiculosJpaController(emf);
    Connection con;
    String empNomb;
    public String getEmpNomb(){
        return empNomb;
    }
    
    public void setEmpNomb(String empNomb){
        this.empNomb = empNomb;
    }
    
    public FrmVehiculos() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(0, 75, 143));
        setlabelEmpleado(String.valueOf(labelEmple1.getText()));
        btnDesactivar1.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        btnDesactivar4.setEnabled(false);
        btnDesactivar5.setEnabled(false);
        btnDesactivar6.setEnabled(false);
        btnDesactivar7.setEnabled(false);
        btnDesactivar8.setEnabled(false);
        btnAgregar7.setEnabled(false);
        btnModificar1.setEnabled(false);
        btnModificar2.setEnabled(false);
        btnModificar3.setEnabled(false);
        btnModificar4.setEnabled(false);
        btnModificar5.setEnabled(false);
        btnModificar6.setEnabled(false);
        btnModificar7.setEnabled(false);
        btnModificar8.setEnabled(false);
        this.btnAgregar1.setBackground( new Color(14, 209, 69));
        this.btnSalir1.setBackground( new Color(236, 28, 36));
        this.btnModificar1.setBackground( new Color(14, 209, 69));
        this.btnLimpiar1.setBackground( new Color(14, 209, 69));
        this.btnDesactivar1.setBackground( new Color(14, 209, 69));
        this.btnRegresar1.setBackground( new Color(14, 209, 69));
        this.btnAgregar2.setBackground( new Color(14, 209, 69));
        this.btnSalir2.setBackground( new Color(236, 28, 36));
        this.btnModificar2.setBackground( new Color(14, 209, 69));
        this.btnLimpiar2.setBackground( new Color(14, 209, 69));
        this.btnDesactivar2.setBackground( new Color(14, 209, 69));
        this.btnRegresar2.setBackground( new Color(14, 209, 69));
        
        this.btnAgregar3.setBackground( new Color(14, 209, 69));
        this.btnSalir3.setBackground( new Color(236, 28, 36));
        this.btnModificar3.setBackground( new Color(14, 209, 69));
        this.btnLimpiar3.setBackground( new Color(14, 209, 69));
        this.btnDesactivar3.setBackground( new Color(14, 209, 69));
        this.btnRegresar3.setBackground( new Color(14, 209, 69));
        
        this.btnAgregar4.setBackground( new Color(14, 209, 69));
        this.btnSalir4.setBackground( new Color(236, 28, 36));
        this.btnModificar4.setBackground( new Color(14, 209, 69));
        this.btnLimpiar4.setBackground( new Color(14, 209, 69));
        this.btnDesactivar4.setBackground( new Color(14, 209, 69));
        this.btnRegresar4.setBackground( new Color(14, 209, 69));
        
        this.btnAgregar5.setBackground( new Color(14, 209, 69));
        this.btnSalir5.setBackground( new Color(236, 28, 36));
        this.btnModificar5.setBackground( new Color(14, 209, 69));
        this.btnLimpiar5.setBackground( new Color(14, 209, 69));
        this.btnDesactivar5.setBackground( new Color(14, 209, 69));
        this.btnRegresar5.setBackground( new Color(14, 209, 69));
        
        this.btnAgregar6.setBackground( new Color(14, 209, 69));
        this.btnSalir6.setBackground( new Color(236, 28, 36));
        this.btnModificar6.setBackground( new Color(14, 209, 69));
        this.btnLimpiar6.setBackground( new Color(14, 209, 69));
        this.btnDesactivar6.setBackground( new Color(14, 209, 69));
        this.btnRegresar6.setBackground( new Color(14, 209, 69));
        
        this.btnAgregar7.setBackground( new Color(14, 209, 69));
        this.btnSalir7.setBackground( new Color(236, 28, 36));
        this.btnModificar7.setBackground( new Color(14, 209, 69));
        this.btnLimpiar7.setBackground( new Color(14, 209, 69));
        this.btnDesactivar7.setBackground( new Color(14, 209, 69));
        this.btnRegresar7.setBackground( new Color(14, 209, 69));
        
        this.btnAgregar8.setBackground( new Color(14, 209, 69));
        this.btnSalir8.setBackground( new Color(236, 28, 36));
        this.btnSalir10.setBackground( new Color(236, 28, 36));
        this.btnModificar8.setBackground( new Color(14, 209, 69));
        this.btnLimpiar8.setBackground( new Color(14, 209, 69));
        this.btnDesactivar8.setBackground( new Color(14, 209, 69));
        this.btnRegresar8.setBackground( new Color(14, 209, 69));
        btnRegresar10.setBackground( new Color(14, 209, 69));
        jButton17.setBackground( new Color(14, 209, 69));
        jButton18.setBackground( new Color(14, 209, 69));
        jButton1.setBackground( new Color(14, 209, 69));
        jButton2.setBackground( new Color(14, 209, 69));
        jButton3.setBackground( new Color(14, 209, 69));
        jButton4.setBackground( new Color(14, 209, 69));
        jButton5.setBackground( new Color(14, 209, 69));
        jButton6.setBackground( new Color(14, 209, 69));
        jButton7.setBackground( new Color(14, 209, 69));
        jButton8.setBackground( new Color(14, 209, 69));
        jButton9.setBackground( new Color(14, 209, 69));
        jButton10.setBackground( new Color(14, 209, 69));
        jButton11.setBackground( new Color(14, 209, 69));
        jButton12.setBackground( new Color(14, 209, 69));
        jButton13.setBackground( new Color(14, 209, 69));
        jButton14.setBackground( new Color(14, 209, 69));
        jButton15.setBackground( new Color(14, 209, 69));
        jButton16.setBackground( new Color(14, 209, 69));
        jButton19.setBackground( new Color(14, 209, 69));
        jButton20.setBackground( new Color(14, 209, 69));
        
        this.btnRegresar9.setBackground( new Color(14, 209, 69));
        this.btnSalir9.setBackground( new Color(236, 28, 36));
        btnSalir1.setAlignmentX(700);
        btnSalir1.setAlignmentY(20);
        
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.jPanel4.setBackground( new Color(0, 75, 143));
        this.jPanel5.setBackground( new Color(0, 75, 143));
        this.jPanel6.setBackground( new Color(0, 75, 143));
        this.jPanel7.setBackground( new Color(0, 75, 143));
        this.jPanel8.setBackground( new Color(0, 75, 143));
        this.jPanel9.setBackground( new Color(0, 75, 143));
        this.jTabbedPane1.setBackground( new Color(0, 75, 143));
        this.btnBuscar.setBackground( new Color(14, 209, 69));
        createTableMarca();
        createComboBoxMarca();
        createTableColor();
        createComboBoxColor();
        createTableTipoVehiculo();
        createComboBoxTipoVehiculo();
        createTableTipoCabina();
        createComboBoxTipoCabina();
        createTableTipoGasolina();
        createComboBoxTipoGasolina();
        createTableTipoTransmision();
        createComboBoxTipoTransmision();
        createTableNumeroAsientos();
        createComboBoxNumeroAsientos();
        createcmbIDVehiculo();
        habilitarAgregarVehiculo();
        createcmbMarcaVehiculo();
        createcmbColorVehiculo();
        createcmbTipoVehiculoVehiculo();
        createcmbTipoCabinaVehiculo();
        createcmbTipoGasolinaVehiculo();
        createcmbTipoTransmisionVehiculo();
        createNumAsientosVehiculo();
        habilitarAgregarVehiculo();
        createTableVehiculosAgregar();
        createcmbIDVehiculo();
        createcmbMarcaBusqueda();
        createcmbColorBusqueda();
        createcmbTipoGasolinaBusqueda();
        createcmbTipoVehiculoBusqueda();
        createComboVehiculo();
             tbBusqueda.setForeground(Color.WHITE);
            tbBusqueda.setBackground(Color.BLACK);
            jTbHistorialPrecio.setForeground(Color.WHITE);
             jTbHistorialPrecio.setBackground(Color.BLACK);
            tblMarca.setForeground(Color.WHITE);
            tblMarca.setBackground(Color.BLACK);
            
            tblColor.setForeground(Color.WHITE);
            tblColor.setBackground(Color.BLACK);
            
            tblTipoVehiculo.setForeground(Color.WHITE);
            tblTipoVehiculo.setBackground(Color.BLACK);
            
            tblTipoCabina.setForeground(Color.WHITE);
            tblTipoCabina.setBackground(Color.BLACK);
            
            tblTipoGasolina.setForeground(Color.WHITE);
            tblTipoGasolina.setBackground(Color.BLACK);
            
            tblNumeroAsientos.setForeground(Color.WHITE);
            tblNumeroAsientos.setBackground(Color.BLACK);
            
            tbAgregarVehiculo.setForeground(Color.WHITE);
            tbAgregarVehiculo.setBackground(Color.BLACK);
            
            tblTipoTransmision.setForeground(Color.WHITE);
            tblTipoTransmision.setBackground(Color.BLACK);
    }
    private void createcmbMarcaBusqueda(){
        //cmbMarcaBusqueda
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbMarcaBusqueda.setModel(modelo);
        List<Marca> temp = Marcadao.findMarcaEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getMarca());
        });
    }
    public void setlabelEmpleado(String valor){
        //IniciodeSesion i = new IniciodeSesion();
        //String valor = i.labelEmple1.getText();
        labelempleado.setText(valor);
    }
    
    private void createTableVehiculosAgregar(){
        DefaultTableModel modelo = (DefaultTableModel) tbAgregarVehiculo.getModel();
        tbAgregarVehiculo.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Vehiculo");
        
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Color");
        modelo.addColumn("Tipo de Combustible");
        modelo.addColumn("Tipo de Vehiculo");
        modelo.addColumn("Número de asientos");
        modelo.addColumn("Cilindraje");
        modelo.addColumn("Stock");
        modelo.addColumn("Stock Maximo");
        modelo.addColumn("Stock Minimo");
        modelo.addColumn("Precio");*/
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        //List<Marca> tempMarca = Marcadao.findMarcaEntities();
        //List<Numero_Asientos> tempAsientos = NumeroAsientosdao.findNumero_AsientosEntities();
        //++++++List<TipoCabina> tempCabina = TipoCabinadao.findTipoCabinaEntities(); // Añadir cabina para el tercer sprint
        //List<TipoGasolina> tempGasolina = TipoGasolinadao.findTipoGasolinaEntities();
        //List<Tipo_color> tempColor = Colorrdao.findTipo_colorEntities();
        List<HistoricoPrecioVehiculos> tempPrecio = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        
        String aux1="";
        String aux2="";
        String aux3="";
        String aux4="";
        String aux5="";
        String aux555="";
        String aux55="";
       // String aux6="";
        double aux7=0.00;
        
        for(Vehiculo e : temp){
            aux1 = Marcadao.findMarca(e.getId_marca()).getMarca() ;
            aux2 = Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color();
            aux3 = TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina();
            aux4 = TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo();
            aux5= NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos();
            aux55= TipoCabinadao.findTipoCabina(e.getId_tipo_cabina()).getTipoCabina();
            aux555= TipoTransmisiondao.findtransmision(e.getId_transmision()).getTransmision();
            for(HistoricoPrecioVehiculos xd : tempPrecio){
                if(e.getId_vehiculo()== xd.getId_vehiculo() && xd.getFechaFinal()==null){
                    aux7=xd.getPrecio();
                }
            }
            
            modelo.addRow(new Object[]{
                e.getId_vehiculo(),
                aux1,e.getVin(),
                aux2,
                aux3,
                aux4,
                aux5,
                aux55,
                aux555,
                String.format("%,.2f",e.getTotal_cilindraje()),
                e.getStock(),
                e.getStock_maximo(),
                e.getStock_minimo(),
                String.format("%,.2f",aux7),
                (e.isEstado())? "Activo" : "Inactivo"
                    
                
            });
        }
    }
    
    public void createComboVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbPrecioHistorico.setModel(modelo);
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        List<Marca> tempp = Marcadao.findMarcaEntities();
        modelo.addElement("Seleccione...");
        for (Vehiculo tpp : temp){     
            for(Marca tp : tempp){
            if(tpp.getId_marca()== tp.getIdMarca()){
            modelo.addElement(tpp.getId_vehiculo()+". "+tp.getMarca()+" ("+tpp.getVin()+"-"+tpp.getTotal_cilindraje()+")");
            }         
            //return;
        }
        }
                }
        public void crearTbHistorialPrecio(){
        DefaultTableModel modelo = (DefaultTableModel) jTbHistorialPrecio.getModel();
        
        
        
        
        jTbHistorialPrecio.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        
        
        /*modelo.addColumn("ID Precio Historico");
        modelo.addColumn("ID pieza");
        modelo.addColumn("Pieza");
        modelo.addColumn("Caracteristica");
        modelo.addColumn("Precio");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        modelo.addColumn("Estado");*/
        
        List<Vehiculo> temp2 = vehiculoDao.findVehiculoEntities();
        List<HistoricoPrecioVehiculos> temp = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        String aux1="";
        String aux2="";
        String aux3="";
        String aux4="";
        String aux5="";
        String auxFecha1 = "";
        String auxFecha2 = "";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        for(HistoricoPrecioVehiculos e : temp){
            if(e.getId_vehiculo()==(cmbPrecioHistorico.getSelectedIndex())){
            for(Vehiculo tp : temp2){
                if(tp.getId_vehiculo() == e.getId_vehiculo()){
                    aux1 = Marcadao.findMarca(tp.getId_marca()).getMarca() ;
                    aux2 = Colorrdao.findTipo_color(tp.getId_tipo_color()).getTipo_color();
                    aux3 = TipoGasolinadao.findTipoGasolina(tp.getId_tipo_gasolina()).getTipoGasolina();
                    aux4 = TipoVehiculodao.findTipoVehiculo(tp.getId_tipo_vehiculo()).getTipoVehiculo();
                    aux5= NumeroAsientosdao.findNumero_Asientos(tp.getId_numero_asientos()).getNumero_Asientos();
                    auxFecha2="";
                    auxFecha1 = e.getFechaInicial().substring(8, 10)+"/"+e.getFechaInicial().substring(5,7)+"/"+e.getFechaInicial().substring(0, 4);
                    if(e.getFechaFinal()!=null){
                        auxFecha2 = e.getFechaFinal().substring(8, 10)+"/"+e.getFechaFinal().substring(5,7)+"/"+e.getFechaFinal().substring(0, 4);
                    }
                    
                    modelo.addRow(new Object[]{
                                  e.getIdPrecioHistorico(),
                                  tp.getId_vehiculo(),
                                  tp.getVin(),
                                  aux1,
                                  aux2,
                                  aux3,
                                  aux4,
                                  aux5,
                                  tp.getTotal_cilindraje(),
                                  String.format("%,.2f",e.getPrecio()),
                                  auxFecha1,
                                  auxFecha2,
                                  (tp.isEstado())? "Activo":"Inactivo"});
        
        }
            }
        }
        }
            
    }
    private void createcmbIDVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDVehiculo.setModel(modelo);
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_vehiculo());
        });
    }
    
    private void habilitarAgregarVehiculo(){
        //Validacion de agregar
        if(Marcadao.getMarcaCount()!=0 && Colorrdao.getTipo_colorCount()!=0 && TipoCabinadao.getTipoCabinaCount()!=0 && TipoGasolinadao.getTipoGasolinaCount()!=0 && TipoTransmisiondao.gettransmisionCount()!=0 && TipoVehiculodao.getTipoVehiculoCount()!=0 && NumeroAsientosdao.getNumero_AsientosCount()!=0){
            btnAgregar7.setEnabled(true);
        }
        else{
            
        }
        //Fin de validacion agregar
        
        
        
        
        
    }
    
    private void createNumAsientosVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbNumAsientos.setModel(modelo);
        List<Numero_Asientos> temp = NumeroAsientosdao.findNumero_AsientosEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getNumero_Asientos());
        });
    }
    
    private void createcmbTipoTransmisionVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbTransmisionVehiculo.setModel(modelo);
        List<transmision> temp = TipoTransmisiondao.findtransmisionEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTransmision());
        });
    }
    
    private void createcmbTipoGasolinaBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbGasolinaBusqueda.setModel(modelo);
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoGasolina());
        });
    }
    
    private void createcmbTipoGasolinaVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbGasolinaVehiculo.setModel(modelo);
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoGasolina());
        });
    }
    
    private void createcmbTipoCabinaVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbCabinaVehiculo.setModel(modelo);
        List<TipoCabina> temp = TipoCabinadao.findTipoCabinaEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoCabina());
        });
    }
    
    private void createcmbTipoVehiculoBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbTipoVehiculoBusqueda.setModel(modelo);
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoVehiculo());
        });
    }
    
    private void createcmbTipoVehiculoVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbTipoVehiculoVehiculo.setModel(modelo);
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoVehiculo());
        });
    }
        
    private void createcmbMarcaVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbMarcaVehiculo.setModel(modelo);
        List<Marca> temp = Marcadao.findMarcaEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getMarca());
        });
    }
    
    private void createcmbColorBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbColorBusqueda.setModel(modelo);
        List<Tipo_color > temp = Colorrdao.findTipo_colorEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipo_color());
        });
    }
    
    private void createcmbColorVehiculo(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbColorVehiculo.setModel(modelo);
        List<Tipo_color > temp = Colorrdao.findTipo_colorEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipo_color());
        });
}
    public void btnActivarDesactivarMarca(){
        Marca temp = new Marca();
        temp = Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar1.setText("Desactivar");  
        btnDesactivar1.setEnabled(true);
        }
        else{
            btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar1.setText("Activar");
            btnDesactivar1.setEnabled(true);
        }
        }
    
    public void createComboBoxMarca(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDMarca.setModel(modelo);
        List<Marca> temp = Marcadao.findMarcaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getIdMarca());
        });
    }
        
    public void createTableMarca(){
        DefaultTableModel modelo = (DefaultTableModel) tblMarca.getModel();
        tblMarca.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Marca");
        modelo.addColumn("Marca");
        modelo.addColumn("Estado");*/
        
        List<Marca> temp = Marcadao.findMarcaEntities();
        
        for(Marca tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdMarca(),
                        tp.getMarca(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void cmbIDMarca(){
        if(cmbIDMarca.getSelectedIndex()==0){
            txtMarca.setText("");
            btnDesactivar1.setEnabled(false);

        }
        else{
            Marca m;
            m=Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
            txtMarca.setText(m.getMarca());
            btnActivarDesactivarMarca();
        }
    }
    
    public void btnActivarDesactivarColor(){
        Tipo_color temp = new Tipo_color();
        temp = Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar2.setText("Desactivar");  
        btnDesactivar2.setEnabled(true);
        }
        else{
            btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar2.setText("Activar");
            btnDesactivar2.setEnabled(true);
        }
        }
    
    public void createComboBoxColor(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDColor.setModel(modelo);
        List<Tipo_color > temp = Colorrdao.findTipo_colorEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_tipo_color());
        });
    }
        
    public void createTableColor(){
        DefaultTableModel modelo = (DefaultTableModel) tblColor.getModel();
        tblColor.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Color");
        modelo.addColumn("Color");
        modelo.addColumn("Estado");*/
        
        List<Tipo_color> temp = Colorrdao.findTipo_colorEntities();
        
        for(Tipo_color tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_tipo_color(),
                        tp.getTipo_color(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoVehiculo(){
        TipoVehiculo temp = new TipoVehiculo();
        temp = TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar3.setText("Desactivar");  
        btnDesactivar3.setEnabled(true);
        }
        else{
            btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar3.setText("Activar");
            btnDesactivar3.setEnabled(true);
        }
        }
    public void btnActivarDesactivarVehiculo(){
        Vehiculo temp = new Vehiculo();
        temp = vehiculoDao.findVehiculo(cmbIDVehiculo.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar7.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar7.setText("Desactivar");  
        btnDesactivar7.setEnabled(true);
        }
        else{
            btnDesactivar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar7.setText("Activar");
            btnDesactivar7.setEnabled(true);
        }
        }
    
    public void createComboBoxTipoVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDTipoVehiculo.setModel(modelo);
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getIdTipoVehiculo());
        });
    }
        
    public void createTableTipoVehiculo(){
        DefaultTableModel modelo = (DefaultTableModel) tblTipoVehiculo.getModel();
        tblTipoVehiculo.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Tipo Vehiculo");
        modelo.addColumn("Tipo Vehiculo");
        modelo.addColumn("Estado");*/
        
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        
        for(TipoVehiculo tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdTipoVehiculo(),
                        tp.getTipoVehiculo(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoCabina(){
        TipoCabina temp = new TipoCabina();
        temp = TipoCabinadao.findTipoCabina(cmbPiezaClave.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar4.setText("Desactivar");  
        btnDesactivar4.setEnabled(true);
        }
        else{
            btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar4.setText("Activar");
            btnDesactivar4.setEnabled(true);
        }
        }
    
    private void createComboBoxTipoCabina(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbPiezaClave.setModel(modelo);
        List<TipoCabina> temp = TipoCabinadao.findTipoCabinaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getIdTipoCabina());
        });
    }
        
    public void createTableTipoCabina(){
        DefaultTableModel modelo = (DefaultTableModel) tblTipoCabina.getModel();;
        tblTipoCabina.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
       /* modelo.addColumn("ID Tipo Cabina");
        modelo.addColumn("Tipo Cabina");
        modelo.addColumn("Estado");*/
        
        List<TipoCabina> temp = TipoCabinadao.findTipoCabinaEntities();
        
        for(TipoCabina tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdTipoCabina(),
                        tp.getTipoCabina(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoGasolina(){
        TipoGasolina temp = new TipoGasolina();
        temp = TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar5.setText("Desactivar");  
        btnDesactivar5.setEnabled(true);
        }
        else{
            btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar5.setText("Activar");
            btnDesactivar5.setEnabled(true);
        }
        }
    
    public void createComboBoxTipoGasolina(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDTipoGasolina.setModel(modelo);
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getIdTipoGasolina());
        });
    }
        
    public void createTableTipoGasolina(){
        DefaultTableModel modelo = (DefaultTableModel) tblTipoGasolina.getModel();
        tblTipoGasolina.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Tipo Gasolina");
        modelo.addColumn("Tipo Gasolina");
        modelo.addColumn("Estado");*/
        
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        
        for(TipoGasolina tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdTipoGasolina(),
                        tp.getTipoGasolina(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoTransmision(){
        transmision temp = new transmision();
        temp = TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar6.setText("Desactivar");  
        btnDesactivar6.setEnabled(true);
        }
        else{
            btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar6.setText("Activar");
            btnDesactivar6.setEnabled(true);
        }
        }
    
    public void createComboBoxTipoTransmision(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDTipoTransmision.setModel(modelo);
        List<transmision> temp = TipoTransmisiondao.findtransmisionEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_transmision());
        });
    }
        
    public void createTableTipoTransmision(){
        DefaultTableModel modelo = (DefaultTableModel) tblTipoTransmision.getModel();
        tblTipoTransmision.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Tipo Transmision");
        modelo.addColumn("Tipo Transmision");
        modelo.addColumn("Estado");*/
        
        List<transmision> temp = TipoTransmisiondao.findtransmisionEntities();
        
        for(transmision tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_transmision(),
                        tp.getTransmision(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarNumeroAsientos(){
        Numero_Asientos temp = new Numero_Asientos();
        temp = NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar8.setText("Desactivar");  
        btnDesactivar8.setEnabled(true);
        }
        else{
            btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar8.setText("Activar");
            btnDesactivar8.setEnabled(true);
        }
        }
    
    public void createComboBoxNumeroAsientos(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDNumeroAsientos.setModel(modelo);
        List<Numero_Asientos> temp = NumeroAsientosdao.findNumero_AsientosEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_Numero_Asientos());
        });
    }
        
    public void createTableNumeroAsientos(){
        DefaultTableModel modelo = (DefaultTableModel) tblNumeroAsientos.getModel();
        tblNumeroAsientos.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Número de Asientos");
        modelo.addColumn("Número de Asientos");
        modelo.addColumn("Estado");*/
        
        List<Numero_Asientos> temp = NumeroAsientosdao.findNumero_AsientosEntities();
        
        for(Numero_Asientos tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_Numero_Asientos(),
                        tp.getNumero_Asientos(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
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
        jPanel2 = new javax.swing.JPanel();
        chkMarca = new javax.swing.JCheckBox();
        chkColor = new javax.swing.JCheckBox();
        chkTipoVehiculo = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbMarcaBusqueda = new javax.swing.JComboBox<>();
        cmbColorBusqueda = new javax.swing.JComboBox<>();
        cmbTipoVehiculoBusqueda = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbGasolinaBusqueda = new javax.swing.JComboBox<>();
        chkTipoGasolina = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBusqueda = new javax.swing.JTable();
        btnRegresar8 = new javax.swing.JButton();
        btnSalir8 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        labelempleado = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cmbIDMarca = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        btnAgregar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        btnDesactivar1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMarca = new javax.swing.JTable();
        btnRegresar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cmbIDColor = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        btnAgregar2 = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnDesactivar2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblColor = new javax.swing.JTable();
        btnRegresar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cmbIDTipoVehiculo = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTipoVehiculo = new javax.swing.JTextField();
        btnAgregar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        btnDesactivar3 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTipoVehiculo = new javax.swing.JTable();
        btnRegresar3 = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtTipoCabina = new javax.swing.JTextField();
        btnAgregar4 = new javax.swing.JButton();
        btnModificar4 = new javax.swing.JButton();
        btnLimpiar4 = new javax.swing.JButton();
        btnDesactivar4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTipoCabina = new javax.swing.JTable();
        btnRegresar4 = new javax.swing.JButton();
        btnSalir4 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        cmbPiezaClave = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        cmbIDTipoGasolina = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtTipoGasolina = new javax.swing.JTextField();
        btnAgregar5 = new javax.swing.JButton();
        btnModificar5 = new javax.swing.JButton();
        btnLimpiar5 = new javax.swing.JButton();
        btnDesactivar5 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTipoGasolina = new javax.swing.JTable();
        btnRegresar5 = new javax.swing.JButton();
        btnSalir5 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        cmbIDNumeroAsientos = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        txtNumeroAsientos = new javax.swing.JTextField();
        btnAgregar8 = new javax.swing.JButton();
        btnModificar8 = new javax.swing.JButton();
        btnLimpiar8 = new javax.swing.JButton();
        btnDesactivar8 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblNumeroAsientos = new javax.swing.JTable();
        btnSalir9 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        btnRegresar9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cmbIDTipoTransmision = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtTipoTransmision = new javax.swing.JTextField();
        btnAgregar6 = new javax.swing.JButton();
        btnModificar6 = new javax.swing.JButton();
        btnLimpiar6 = new javax.swing.JButton();
        btnDesactivar6 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTipoTransmision = new javax.swing.JTable();
        btnRegresar6 = new javax.swing.JButton();
        btnSalir6 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbColorVehiculo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAgregarVehiculo = new javax.swing.JTable();
        cmbMarcaVehiculo = new javax.swing.JComboBox<>();
        cmbTipoVehiculoVehiculo = new javax.swing.JComboBox<>();
        cmbCabinaVehiculo = new javax.swing.JComboBox<>();
        cmbTransmisionVehiculo = new javax.swing.JComboBox<>();
        cmbGasolinaVehiculo = new javax.swing.JComboBox<>();
        txtVin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnLimpiar7 = new javax.swing.JButton();
        btnDesactivar7 = new javax.swing.JButton();
        btnModificar7 = new javax.swing.JButton();
        btnAgregar7 = new javax.swing.JButton();
        cmbIDVehiculo = new javax.swing.JComboBox<>();
        txtCilindraje = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnSalir7 = new javax.swing.JButton();
        btnRegresar7 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        cmbNumAsientos = new javax.swing.JComboBox<>();
        ftxtStock = new javax.swing.JFormattedTextField();
        ftxtStockMinimo = new javax.swing.JFormattedTextField();
        ftxtStockMaximo = new javax.swing.JFormattedTextField();
        txtPrecio = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnSalir10 = new javax.swing.JButton();
        btnRegresar10 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTbHistorialPrecio = new javax.swing.JTable();
        cmbPrecioHistorico = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        chkMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMarcaItemStateChanged(evt);
            }
        });

        chkColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkColorItemStateChanged(evt);
            }
        });

        chkTipoVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTipoVehiculoItemStateChanged(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Marca:");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Color:");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Tipo de Vehículo:");

        cmbMarcaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Chevrolet", "Honda" }));
        cmbMarcaBusqueda.setEnabled(false);

        cmbColorBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negro", "Rojo", "Azul", " " }));
        cmbColorBusqueda.setEnabled(false);

        cmbTipoVehiculoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deportivo", "Comercial", " " }));
        cmbTipoVehiculoBusqueda.setEnabled(false);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Tipo de Gasolina:");

        cmbGasolinaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diesel", " " }));
        cmbGasolinaBusqueda.setEnabled(false);

        chkTipoGasolina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTipoGasolinaItemStateChanged(evt);
            }
        });
        chkTipoGasolina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTipoGasolinaActionPerformed(evt);
            }
        });

        tbBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        tbBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vehículo", "Marca", "Modelo", "Color", "Combustible", "Tipo de Vehículo", "Número de Asientos", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbBusqueda);

        btnRegresar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar8.setText("Regresar");
        btnRegresar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar8ActionPerformed(evt);
            }
        });

        btnSalir8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir8.setText("Salir");
        btnSalir8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir8ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Búsqueda por Filtro");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        labelempleado.setText("jLabel1");

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton19.setText("Generar Reporte PDF");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton20.setText("Generar Reporte Excel");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(jLabel46)
                        .addGap(410, 410, 410)
                        .addComponent(btnSalir8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1200, 1200, 1200)
                        .addComponent(btnRegresar8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cmbTipoVehiculoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkTipoVehiculo))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(cmbMarcaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(chkMarca)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(cmbColorBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(chkColor)))
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(cmbGasolinaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(chkTipoGasolina))
                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton19)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(952, 952, 952)
                    .addComponent(labelempleado)
                    .addContainerGap(1179, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir8))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cmbMarcaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cmbColorBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbTipoVehiculoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chkMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(cmbGasolinaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkTipoGasolina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkColor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(80, 80, 80)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addComponent(btnRegresar8)
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(400, 400, 400)
                    .addComponent(labelempleado)
                    .addContainerGap(401, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Búsqueda por filtro", jPanel2);

        cmbIDMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDMarcaItemStateChanged(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("ID Marca:");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Nueva marca:");

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });

        btnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar1.setText("Agregar");
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
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

        btnLimpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
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

        tblMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Marca", "Marca", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarcaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblMarcaMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tblMarca);

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Nueva Marca");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton1.setText("Generar Reporte PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton2.setText("Generar Reporte Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cmbIDMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(btnAgregar1)
                            .addGap(18, 18, 18)
                            .addComponent(btnModificar1)
                            .addGap(18, 18, 18)
                            .addComponent(btnLimpiar1)
                            .addGap(18, 18, 18)
                            .addComponent(btnDesactivar1))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(353, 353, 353)
                            .addComponent(btnSalir1))))
                .addContainerGap(831, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir1))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cmbIDMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar1))
                    .addComponent(btnModificar1)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnDesactivar1)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(btnRegresar1)
                .addGap(167, 167, 167))
        );

        jTabbedPane1.addTab("Marca", jPanel3);

        cmbIDColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDColorItemStateChanged(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("ID Color");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Nuevo Color:");

        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        btnModificar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnLimpiar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar2.setText("Desactivar");
        btnDesactivar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar2ActionPerformed(evt);
            }
        });

        tblColor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Color", "Color", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblColorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblColorMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(tblColor);

        btnRegresar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setText("Regresar");
        btnRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Nuevo Color");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton3.setText("Generar Reporte PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton4.setText("Generar Reporte Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnAgregar2)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar2)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar2))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbIDColor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(17, 17, 17)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(624, 624, 624)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(478, 478, 478)
                        .addComponent(btnSalir2)))
                .addContainerGap(827, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalir2))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar2))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar2)
                        .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDesactivar2)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(btnRegresar2)
                .addGap(177, 177, 177))
        );

        jTabbedPane1.addTab("Color", jPanel4);

        cmbIDTipoVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoVehiculoItemStateChanged(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("ID Tipo de Vehículo:");

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Nuevo Tiipo de Vehículo:");

        txtTipoVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoVehiculoKeyTyped(evt);
            }
        });

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar3.setText("Agregar");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });

        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });

        tblTipoVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tipo Vehículo", "Tipo Vehículo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTipoVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoVehiculoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoVehiculoMouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(tblTipoVehiculo);

        btnRegresar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar3.setText("Regresar");
        btnRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar3ActionPerformed(evt);
            }
        });

        btnSalir3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir3.setText("Salir");
        btnSalir3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir3ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Nuevo de Tipo de Vehículo");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton5.setText("Generar Reporte PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton6.setText("Generar Reporte Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbIDTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnAgregar3)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar3)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar3)))
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar3))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(551, 551, 551)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar3)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(396, 396, 396)
                                .addComponent(btnSalir3)))))
                .addContainerGap(815, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir3)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar3))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar3)
                        .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDesactivar3)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(btnRegresar3)
                .addGap(172, 172, 172))
        );

        jTabbedPane1.addTab("Tipo de Vehículo", jPanel6);

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("ID Tipo de Cabina:");

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Nuevo Tipo de Cabina:");

        txtTipoCabina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoCabinaKeyTyped(evt);
            }
        });

        btnAgregar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar4.setText("Agregar");
        btnAgregar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });

        btnModificar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar4.setText("Modificar");
        btnModificar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar4ActionPerformed(evt);
            }
        });

        btnLimpiar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar4.setText("Limpiar");
        btnLimpiar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar4ActionPerformed(evt);
            }
        });

        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar4.setText("Desactivar");
        btnDesactivar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar4ActionPerformed(evt);
            }
        });

        tblTipoCabina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tipo Cabina", "Tipo Cabina", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTipoCabina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoCabinaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoCabinaMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(tblTipoCabina);

        btnRegresar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar4.setText("Regresar");
        btnRegresar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar4ActionPerformed(evt);
            }
        });

        btnSalir4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir4.setText("Salir");
        btnSalir4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Nuevo Tipo de Cabina");

        cmbPiezaClave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton7.setText("Generar Reporte PDF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton8.setText("Generar Reporte Excel");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnAgregar4)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar4)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar4))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel37))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPiezaClave, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipoCabina, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar4))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(531, 531, 531)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(444, 444, 444)
                        .addComponent(btnSalir4)))
                .addContainerGap(843, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir4))
                .addGap(70, 70, 70)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPiezaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoCabina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar4)
                            .addComponent(btnLimpiar4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar4))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(btnRegresar4)
                .addGap(172, 172, 172))
        );

        jTabbedPane1.addTab("Tipo de Cabina", jPanel7);

        cmbIDTipoGasolina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoGasolinaItemStateChanged(evt);
            }
        });

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("ID Tipo de Combustible:");

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Tipo de Combustible:");

        txtTipoGasolina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoGasolinaKeyTyped(evt);
            }
        });

        btnAgregar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar5.setText("Agregar");
        btnAgregar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });

        btnModificar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar5.setText("Modificar");
        btnModificar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar5ActionPerformed(evt);
            }
        });

        btnLimpiar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar5.setText("Limpiar");
        btnLimpiar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar5ActionPerformed(evt);
            }
        });

        btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar5.setText("Desactivar");
        btnDesactivar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar5ActionPerformed(evt);
            }
        });

        tblTipoGasolina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tipo de Combustible", "Tipo de Combustible", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTipoGasolina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoGasolinaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoGasolinaMouseEntered(evt);
            }
        });
        jScrollPane8.setViewportView(tblTipoGasolina);

        btnRegresar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar5.setText("Regresar");
        btnRegresar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar5ActionPerformed(evt);
            }
        });

        btnSalir5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Nuevo Tipo de Combustible");

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton9.setText("Generar Reporte PDF");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton10.setText("Generar Reporte Excel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar5))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(btnAgregar5)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar5)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar5))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbIDTipoGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTipoGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar5))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(513, 513, 513)
                                .addComponent(jLabel41)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(348, 348, 348)
                        .addComponent(btnSalir5)))
                .addGap(808, 808, 808))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDTipoGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalir5)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar5))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar5)
                        .addComponent(btnLimpiar5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDesactivar5)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(btnRegresar5)
                .addGap(183, 183, 183))
        );

        jTabbedPane1.addTab("Tipo de Combustible", jPanel8);

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("ID Número de Asientos:");

        cmbIDNumeroAsientos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDNumeroAsientosItemStateChanged(evt);
            }
        });

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Nuevo Número de Asientos:");

        txtNumeroAsientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroAsientosKeyTyped(evt);
            }
        });

        btnAgregar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar8.setText("Agregar");
        btnAgregar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar8ActionPerformed(evt);
            }
        });

        btnModificar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar8.setText("Modificar");
        btnModificar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar8ActionPerformed(evt);
            }
        });

        btnLimpiar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar8.setText("Limpiar");
        btnLimpiar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar8ActionPerformed(evt);
            }
        });

        btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar8.setText("Desactivar");
        btnDesactivar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar8ActionPerformed(evt);
            }
        });

        tblNumeroAsientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Número de Asientos", "Nuevo Número de Asientos", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNumeroAsientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNumeroAsientosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblNumeroAsientosMouseEntered(evt);
            }
        });
        jScrollPane10.setViewportView(tblNumeroAsientos);

        btnSalir9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir9.setText("Salir");
        btnSalir9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir9ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Nuevo Número de Asientos");

        btnRegresar9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar9.setText("Regresar");
        btnRegresar9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar9ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton11.setText("Generar Reporte PDF");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton12.setText("Generar Reporte Excel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnAgregar8)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar8)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar8)
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar8))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbIDNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(536, 536, 536)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar9)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(402, 402, 402)
                                .addComponent(btnSalir9)))))
                .addContainerGap(821, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir9))
                .addGap(53, 53, 53)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar8)
                    .addComponent(btnModificar8)
                    .addComponent(btnLimpiar8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar8))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(btnRegresar9)
                .addGap(173, 173, 173))
        );

        jTabbedPane1.addTab("Número de Asientos", jPanel9);

        cmbIDTipoTransmision.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoTransmisionItemStateChanged(evt);
            }
        });

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("ID Tipo de Transmisión:");

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Tipo de Transmisión:");

        txtTipoTransmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoTransmisionKeyTyped(evt);
            }
        });

        btnAgregar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar6.setText("Agregar");
        btnAgregar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar6ActionPerformed(evt);
            }
        });

        btnModificar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar6.setText("Modificar");
        btnModificar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar6ActionPerformed(evt);
            }
        });

        btnLimpiar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar6.setText("Limpiar");
        btnLimpiar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar6ActionPerformed(evt);
            }
        });

        btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar6.setText("Desactivar");
        btnDesactivar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar6ActionPerformed(evt);
            }
        });

        tblTipoTransmision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tipo Transmisión", " Tipo Transmisión", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTipoTransmision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoTransmisionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoTransmisionMouseEntered(evt);
            }
        });
        jScrollPane9.setViewportView(tblTipoTransmision);

        btnRegresar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar6.setText("Regresar");
        btnRegresar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar6ActionPerformed(evt);
            }
        });

        btnSalir6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir6.setText("Salir");
        btnSalir6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir6ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Nuevo Tipo de Transmisión");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton13.setText("Generar Reporte PDF");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton14.setText("Generar Reporte Excel");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(btnAgregar6)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnModificar6)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLimpiar6))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbIDTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addComponent(btnDesactivar6))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel44)
                                    .addGap(462, 462, 462))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jButton13)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton14)))
                                    .addGap(412, 412, 412)))
                            .addComponent(btnSalir6)))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalir6)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar6)
                            .addComponent(btnLimpiar6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar6))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addComponent(btnRegresar6)
                .addGap(153, 153, 153))
        );

        jTabbedPane1.addTab("Tipo de Transmisión", jPanel5);

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Vehículo:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Modelo:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Marca:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Color");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de Vehículo:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tipo de Combustible:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Número Asientos:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tipo de Cabina:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tipo de Transmisión:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cantidad de cilindraje:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio:");

        tbAgregarVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vehículo", "Marca", "Modelo", "Color", "Combustible", "TipoVehículo", "N. de Asientos", "Cabina", "Transmisión", "Cilindraje", "Stock", "Stock Máximo", "Stock Mínimo", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAgregarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAgregarVehiculoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAgregarVehiculo);
        if (tbAgregarVehiculo.getColumnModel().getColumnCount() > 0) {
            tbAgregarVehiculo.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbAgregarVehiculo.getColumnModel().getColumn(9).setPreferredWidth(90);
        }

        txtVin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVinActionPerformed(evt);
            }
        });
        txtVin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVinKeyTyped(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Lps.");

        btnLimpiar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar7.setText("Limpiar");
        btnLimpiar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar7ActionPerformed(evt);
            }
        });

        btnDesactivar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar7.setText("Desactivar");
        btnDesactivar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar7ActionPerformed(evt);
            }
        });

        btnModificar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar7.setText("Modificar");
        btnModificar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar7ActionPerformed(evt);
            }
        });

        btnAgregar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar7.setText("Agregar");
        btnAgregar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar7ActionPerformed(evt);
            }
        });

        cmbIDVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDVehiculoItemStateChanged(evt);
            }
        });
        cmbIDVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDVehiculoActionPerformed(evt);
            }
        });

        txtCilindraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCilindrajeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCilindrajeKeyTyped(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Stock:");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Stock Mínimo:");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Stock Máximo:");

        btnSalir7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir7.setText("Salir");
        btnSalir7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir7ActionPerformed(evt);
            }
        });

        btnRegresar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar7.setText("Regresar");
        btnRegresar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar7ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Vehículos");

        ftxtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftxtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtStockKeyTyped(evt);
            }
        });

        ftxtStockMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftxtStockMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtStockMinimoKeyTyped(evt);
            }
        });

        ftxtStockMaximo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftxtStockMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtStockMaximoActionPerformed(evt);
            }
        });
        ftxtStockMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtStockMaximoKeyTyped(evt);
            }
        });

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton15.setText("Generar Reporte PDF");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton16.setText("Generar Reporte Excel");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(810, 810, 810)
                        .addComponent(jLabel45)
                        .addGap(336, 336, 336)
                        .addComponent(btnSalir7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cmbMarcaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cmbIDVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbNumAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtStockMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCabinaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecio)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbTipoVehiculoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ftxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1190, 1190, 1190)
                        .addComponent(btnRegresar7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgregar7)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(cmbColorVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtVin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(cmbGasolinaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ftxtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbTransmisionVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCilindraje))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnLimpiar7)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDesactivar7)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(586, 586, 586))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir7))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addComponent(cmbIDVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNumAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ftxtStockMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMarcaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCabinaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTransmisionVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(ftxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbColorVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCilindraje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel5)
                        .addComponent(cmbTipoVehiculoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbGasolinaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftxtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar7)
                        .addComponent(btnAgregar7))
                    .addComponent(btnLimpiar7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnDesactivar7)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(btnRegresar7))
        );

        jTabbedPane1.addTab("Vehículos", jPanel1);

        jPanel10.setBackground(new java.awt.Color(0, 75, 143));

        btnSalir10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir10.setText("Salir");
        btnSalir10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir10ActionPerformed(evt);
            }
        });

        btnRegresar10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar10.setText("Regresar");
        btnRegresar10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar10ActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Precio Historico de Vehículos");

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton17.setText("Generar Reporte PDF");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton18.setText("Generar Reporte Excel");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jTbHistorialPrecio.setBackground(new java.awt.Color(0, 0, 0));
        jTbHistorialPrecio.setForeground(new java.awt.Color(255, 255, 255));
        jTbHistorialPrecio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Vehículo", "Modelo", "Marca", "Color", "Combustible", "Tipo Vehículo", "Cilindraje", "Precio", "Desde", "Hasta", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTbHistorialPrecio);
        if (jTbHistorialPrecio.getColumnModel().getColumnCount() > 0) {
            jTbHistorialPrecio.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTbHistorialPrecio.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTbHistorialPrecio.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTbHistorialPrecio.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTbHistorialPrecio.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTbHistorialPrecio.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTbHistorialPrecio.getColumnModel().getColumn(9).setPreferredWidth(40);
            jTbHistorialPrecio.getColumnModel().getColumn(10).setPreferredWidth(40);
            jTbHistorialPrecio.getColumnModel().getColumn(11).setPreferredWidth(40);
        }

        cmbPrecioHistorico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPrecioHistoricoItemStateChanged(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Vehiculo:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1190, 1190, 1190)
                        .addComponent(btnRegresar10))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton18))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbPrecioHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(542, 542, 542)
                        .addComponent(jLabel58)
                        .addGap(374, 374, 374)
                        .addComponent(btnSalir10)))
                .addContainerGap(816, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir10)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPrecioHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(177, 177, 177)
                .addComponent(btnRegresar10))
        );

        jTabbedPane1.addTab("Historial Precio de Vehículos", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        /*        if(jTabbedPane1.getSelectedIndex()==4){
            createComboBoxTipoCabina();
        }
        else if(jTabbedPane1.getSelectedIndex()==8){
            createcmbTipoCabinaVehiculo();
            createNumAsientosVehiculo();
        }*/

        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
            Reporte_Vehiculoexcel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            Reporte_Vehiculopdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped

        char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '.' && c != ',') && (c!=8)){

            evt.consume();

        }
        if (txtPrecio.getText().length() >= 12){

            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void ftxtStockMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtStockMaximoKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (ftxtStockMaximo.getText().length() >= 5){

            evt.consume();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ftxtStockMaximoKeyTyped

    private void ftxtStockMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtStockMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtStockMaximoActionPerformed

    private void ftxtStockMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtStockMinimoKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (ftxtStockMinimo.getText().length() >= 5){

            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtStockMinimoKeyTyped

    private void ftxtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtStockKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (ftxtStock.getText().length() >= 5){

            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtStockKeyTyped

    private void btnRegresar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar7ActionPerformed
        //FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar7ActionPerformed

    private void btnSalir7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir7ActionPerformed

    private void txtCilindrajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCilindrajeKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '.' ) ){

            evt.consume();

        }

        if (txtCilindraje.getText().length() >= 5){

            evt.consume();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCilindrajeKeyTyped

    private void txtCilindrajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCilindrajeKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCilindrajeKeyPressed

    private void cmbIDVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDVehiculoActionPerformed

    private void cmbIDVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDVehiculoItemStateChanged
        /*  if(cmbIDVehiculo.getSelectedIndex()==0){
            limpiar();
            btnModificar7.setEnabled(false);
            btnAgregar7.setEnabled(true);
        }
        else{
            Vehiculo temp = new Vehiculo();
            temp = vehiculoDao.findVehiculo(cmbIDVehiculo.getSelectedIndex());
            cmbMarcaVehiculo.setSelectedIndex(temp.getId_marca());
            cmbColorVehiculo.setSelectedIndex(temp.getId_tipo_color());
            cmbTipoVehiculoVehiculo.setSelectedIndex(temp.getId_tipo_vehiculo());
            cmbGasolinaVehiculo.setSelectedIndex(temp.getId_tipo_gasolina());
            cmbNumAsientos.setSelectedIndex(temp.getId_numero_asientos());
            cmbCabinaVehiculo.setSelectedIndex(temp.getId_tipo_cabina());
            cmbTransmisionVehiculo.setSelectedIndex(temp.getId_transmision());
            txtCilindraje.setText(String.valueOf(temp.getTotal_cilindraje()));
            ftxtStock.setText(String.valueOf(temp.getStock()));
            ftxtStockMaximo.setText(String.valueOf(temp.getStock_maximo()));
            ftxtStockMinimo.setText(String.valueOf(temp.getStock_minimo()));
            txtVin.setText(temp.getVin());

            List<HistoricoPrecioVehiculos> temp2 = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
            for(HistoricoPrecioVehiculos e : temp2)
            {
                if(e.getId_vehiculo()==cmbIDVehiculo.getSelectedIndex() && e.getFechaFinal()==null){
                    txtPrecio.setText(String.valueOf(e.getPrecio()));
                }
            }

            btnModificar7.setEnabled(true);
            btnAgregar7.setEnabled(false);

        }*/

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDVehiculoItemStateChanged

    private void btnAgregar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar7ActionPerformed
        AgregarVehiculos();
    }//GEN-LAST:event_btnAgregar7ActionPerformed

    private void btnModificar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar7ActionPerformed

    }//GEN-LAST:event_btnModificar7ActionPerformed

    private void btnDesactivar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar7ActionPerformed

    }//GEN-LAST:event_btnDesactivar7ActionPerformed

    private void btnLimpiar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar7ActionPerformed

        limpiar();
        btnModificar7.setEnabled(false);
        btnAgregar7.setEnabled(true);

    }//GEN-LAST:event_btnLimpiar7ActionPerformed

    private void txtVinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVinKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c != '-' && c != '+' && c != '&' && c != '#' && c != '$' ) && (c < '0' || c > '9')  &&(c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }

        if (txtVin.getText().length() >= 25){

            evt.consume();

        }
    }//GEN-LAST:event_txtVinKeyTyped

    private void txtVinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVinActionPerformed

    private void tbAgregarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAgregarVehiculoMouseClicked
        btnAgregar7.setEnabled(false);
        btnModificar7.setEnabled(true);
        btnDesactivar7.setEnabled(true);
        int column = 0;
        int fila = tbAgregarVehiculo.getSelectedRow();
        if (fila > -1){
            cmbIDVehiculo.setSelectedIndex(Integer.parseInt(tbAgregarVehiculo.getModel().getValueAt(fila, column).toString()));
            Vehiculo temp = vehiculoDao.findVehiculo(Integer.parseInt(tbAgregarVehiculo.getModel().getValueAt(fila, column).toString()));
            cmbMarcaVehiculo.setSelectedIndex(temp.getId_marca());
            cmbColorVehiculo.setSelectedIndex(temp.getId_tipo_color());
            cmbTipoVehiculoVehiculo.setSelectedIndex(temp.getId_tipo_vehiculo());
            cmbGasolinaVehiculo.setSelectedIndex(temp.getId_tipo_gasolina());
            cmbNumAsientos.setSelectedIndex(temp.getId_numero_asientos());
            cmbCabinaVehiculo.setSelectedIndex(temp.getId_tipo_cabina());
            cmbTransmisionVehiculo.setSelectedIndex(temp.getId_transmision());
            txtCilindraje.setText(String.format("%,.0f", temp.getTotal_cilindraje()));
            ftxtStock.setText(String.valueOf(temp.getStock()));
            ftxtStockMaximo.setText(String.valueOf(temp.getStock_maximo()));
            ftxtStockMinimo.setText(String.valueOf(temp.getStock_minimo()));
            txtVin.setText(temp.getVin());
            List<HistoricoPrecioVehiculos> tempc = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
            for(HistoricoPrecioVehiculos hp: tempc){
                if(hp.getId_vehiculo()==temp.getId_vehiculo()){
                    //txtPrecio.setText(String.valueOf(tbAgregarVehiculo.getValueAt(fila, 11)));
                    double precio=hp.getPrecio();
                    txtPrecio.setText(String.format("%,.2f",precio));
                }
            }

            //btnActivarDesactivarPieza();
            btnModificar7.setEnabled(true);
            btnAgregar7.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbAgregarVehiculoMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            Reporte_Tipo_Transmisionexcel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            Reporte_Tipo_Transmisionpdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnSalir6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir6ActionPerformed

    private void btnRegresar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar6ActionPerformed
        // FrmMenu m = new FrmMenu();
        //   m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar6ActionPerformed

    private void tblTipoTransmisionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoTransmisionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoTransmisionMouseEntered

    private void tblTipoTransmisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoTransmisionMouseClicked
        btnAgregar6.setEnabled(false);
        btnModificar6.setEnabled(true);
        btnDesactivar6.setEnabled(true);
        int column=0;
        int fila = tblTipoTransmision.getSelectedRow();
        if (fila > -1){
            cmbIDTipoTransmision.setSelectedIndex(Integer.parseInt(tblTipoTransmision.getModel().getValueAt(fila, column).toString()));
            txtTipoTransmision.setText(String.valueOf(tblTipoTransmision.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }
    }//GEN-LAST:event_tblTipoTransmisionMouseClicked

    private void btnDesactivar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar6ActionPerformed
        DesactivarTransmision();
    }//GEN-LAST:event_btnDesactivar6ActionPerformed

    private void btnLimpiar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar6ActionPerformed
        LimpiarNuevoTipoTransmision();
    }//GEN-LAST:event_btnLimpiar6ActionPerformed

    private void btnModificar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar6ActionPerformed
        ModificarTransmision();
    }//GEN-LAST:event_btnModificar6ActionPerformed

    private void btnAgregar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar6ActionPerformed

    }//GEN-LAST:event_btnAgregar6ActionPerformed

    private void txtTipoTransmisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoTransmisionKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }

        if (txtTipoTransmision.getText().length() >= 15){

            evt.consume();

        }
    }//GEN-LAST:event_txtTipoTransmisionKeyTyped

    private void cmbIDTipoTransmisionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoTransmisionItemStateChanged
        if(cmbIDTipoTransmision.getSelectedIndex()==0){
            txtTipoTransmision.setText("");
            btnDesactivar6.setEnabled(false);

        }
        else{
            transmision tp;
            tp=TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
            txtTipoTransmision.setText(tp.getTransmision());
            btnActivarDesactivarTipoTransmision();
        }
    }//GEN-LAST:event_cmbIDTipoTransmisionItemStateChanged

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            Reporte_Numero_Asientosexcel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            Reporte_Numero_Asientospdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnRegresar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar9ActionPerformed
        // FrmMenu m = new FrmMenu();
        // m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar9ActionPerformed

    private void btnSalir9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir9ActionPerformed

    private void tblNumeroAsientosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNumeroAsientosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNumeroAsientosMouseEntered

    private void tblNumeroAsientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNumeroAsientosMouseClicked
        btnAgregar8.setEnabled(false);
        btnModificar8.setEnabled(true);
        btnDesactivar8.setEnabled(true);
        int column=0;
        int fila = tblNumeroAsientos.getSelectedRow();
        if (fila > -1){
            cmbIDNumeroAsientos.setSelectedIndex(Integer.parseInt(tblNumeroAsientos.getModel().getValueAt(fila, column).toString()));
            txtNumeroAsientos.setText(String.valueOf(tblNumeroAsientos.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }
    }//GEN-LAST:event_tblNumeroAsientosMouseClicked

    private void btnDesactivar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar8ActionPerformed
        DesactivarNumeroAsientos();
    }//GEN-LAST:event_btnDesactivar8ActionPerformed

    private void btnLimpiar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar8ActionPerformed
        //  cmbIDNumeroAsientos.setSelectedIndex(1);
        LimpiarNuevoNumeroAsientos();

    }//GEN-LAST:event_btnLimpiar8ActionPerformed

    private void btnModificar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar8ActionPerformed
        ModificarNumeroAsientos();
    }//GEN-LAST:event_btnModificar8ActionPerformed

    private void btnAgregar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar8ActionPerformed
        AgregarNumeroAsientos();

    }//GEN-LAST:event_btnAgregar8ActionPerformed

    private void txtNumeroAsientosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroAsientosKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9') ){

            evt.consume();

        }

        if (txtNumeroAsientos.getText().length() >= 2){

            evt.consume();

        }
    }//GEN-LAST:event_txtNumeroAsientosKeyTyped

    private void cmbIDNumeroAsientosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDNumeroAsientosItemStateChanged
        if(cmbIDNumeroAsientos.getSelectedIndex()==0){
            txtNumeroAsientos.setText("");
            btnDesactivar8.setEnabled(false);

        }
        else{
            Numero_Asientos tp;
            tp=NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
            txtNumeroAsientos.setText(tp.getNumero_Asientos());
            btnActivarDesactivarNumeroAsientos();
        }
    }//GEN-LAST:event_cmbIDNumeroAsientosItemStateChanged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            Reporte_Tipo_Gasolinaexcel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            Reporte_Tipo_Gasolinapdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnSalir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir5ActionPerformed

    private void btnRegresar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar5ActionPerformed
        // FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar5ActionPerformed

    private void tblTipoGasolinaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoGasolinaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoGasolinaMouseEntered

    private void tblTipoGasolinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoGasolinaMouseClicked
        btnAgregar5.setEnabled(false);
        btnModificar5.setEnabled(true);
        btnDesactivar5.setEnabled(true);
        int column=0;
        int fila = tblTipoGasolina.getSelectedRow();
        if (fila > -1){
            cmbIDTipoGasolina.setSelectedIndex(Integer.parseInt(tblTipoGasolina.getModel().getValueAt(fila, column).toString()));
            txtTipoGasolina.setText(String.valueOf(tblTipoGasolina.getValueAt(fila, ++column)));
            btnActivarDesactivarTipoGasolina();
        }
    }//GEN-LAST:event_tblTipoGasolinaMouseClicked

    private void btnDesactivar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar5ActionPerformed
        DesactivarTipoCombustible();
    }//GEN-LAST:event_btnDesactivar5ActionPerformed

    private void btnLimpiar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar5ActionPerformed
        LimpiarNuevoTipoGasolina();
    }//GEN-LAST:event_btnLimpiar5ActionPerformed

    private void btnModificar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar5ActionPerformed
        ModificarTipoCombustible();
    }//GEN-LAST:event_btnModificar5ActionPerformed

    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed
        AgregarTipoCombustible();
    }//GEN-LAST:event_btnAgregar5ActionPerformed

    private void txtTipoGasolinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoGasolinaKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }

        if (txtTipoGasolina.getText().length() >= 8){

            evt.consume();

        }
    }//GEN-LAST:event_txtTipoGasolinaKeyTyped

    private void cmbIDTipoGasolinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoGasolinaItemStateChanged
        if(cmbIDTipoGasolina.getSelectedIndex()==0){
            txtTipoGasolina.setText("");
            btnDesactivar5.setEnabled(false);

        }
        else{
            TipoGasolina tp;
            tp=TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
            txtTipoGasolina.setText(tp.getTipoGasolina());
            btnActivarDesactivarTipoGasolina();
        }
    }//GEN-LAST:event_cmbIDTipoGasolinaItemStateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            Reporte_Tipo_Cabinaexcel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            Reporte_Tipo_Cabinapdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir4ActionPerformed

    private void btnRegresar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar4ActionPerformed
        //FrmMenu m = new FrmMenu();
        // m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar4ActionPerformed

    private void tblTipoCabinaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoCabinaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoCabinaMouseEntered

    private void tblTipoCabinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoCabinaMouseClicked
        btnAgregar4.setEnabled(false);
        btnModificar4.setEnabled(true);
        btnDesactivar4.setEnabled(true);
        int column=0;
        int fila = tblTipoCabina.getSelectedRow();
        if (fila > -1){
            cmbPiezaClave.setSelectedIndex(Integer.parseInt(tblTipoCabina.getModel().getValueAt(fila, column).toString()));
            txtTipoCabina.setText(String.valueOf(tblTipoCabina.getValueAt(fila, ++column)));
            btnActivarDesactivarTipoCabina();
        }
    }//GEN-LAST:event_tblTipoCabinaMouseClicked

    private void btnDesactivar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar4ActionPerformed

    }//GEN-LAST:event_btnDesactivar4ActionPerformed

    private void btnLimpiar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar4ActionPerformed
        // cmbIDTipoCabina.setSelectedIndex(1);
        LimpiarNuevoTipoCabina();

    }//GEN-LAST:event_btnLimpiar4ActionPerformed

    private void btnModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar4ActionPerformed
        ModificarTipoCabina();
    }//GEN-LAST:event_btnModificar4ActionPerformed

    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed
        AgregarTipoCabina();
    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void txtTipoCabinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoCabinaKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }

        if (txtTipoCabina.getText().length() >= 14){

            evt.consume();

        }
    }//GEN-LAST:event_txtTipoCabinaKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            Reporte_Tipo_Vehiculoexcel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Reporte_Tipo_Vehiculopdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir3ActionPerformed

    private void btnRegresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar3ActionPerformed
        // FrmMenu m = new FrmMenu();
        // m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar3ActionPerformed

    private void tblTipoVehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoVehiculoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoVehiculoMouseEntered

    private void tblTipoVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoVehiculoMouseClicked
        btnAgregar3.setEnabled(false);
        btnModificar3.setEnabled(true);
        btnDesactivar3.setEnabled(true);
        int column=0;
        int fila = tblTipoVehiculo.getSelectedRow();
        if (fila > -1){
            cmbIDTipoVehiculo.setSelectedIndex(Integer.parseInt(tblTipoVehiculo.getModel().getValueAt(fila, column).toString()));
            txtTipoVehiculo.setText(String.valueOf(tblTipoVehiculo.getValueAt(fila, ++column)));
            btnActivarDesactivarTipoCabina();
        }
    }//GEN-LAST:event_tblTipoVehiculoMouseClicked

    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
        DesactivarTipoVehiculo();
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        LimpiarNuevoTipoVehiculo();
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        ModificarTipoVehiculo();
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        AgregarTipoVehiculo();
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void txtTipoVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoVehiculoKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }

        if (txtTipoVehiculo.getText().length() >= 9){

            evt.consume();

        }
    }//GEN-LAST:event_txtTipoVehiculoKeyTyped

    private void cmbIDTipoVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoVehiculoItemStateChanged
        if(cmbIDTipoVehiculo.getSelectedIndex()==0){
            txtTipoVehiculo.setText("");
            btnDesactivar3.setEnabled(false);

        }
        else{
            TipoVehiculo tp;
            tp=TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
            txtTipoVehiculo.setText(tp.getTipoVehiculo());
            btnActivarDesactivarTipoVehiculo();
        }
    }//GEN-LAST:event_cmbIDTipoVehiculoItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Reporte_Colorexcel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Reporte_Colorpdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        //FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void tblColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblColorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblColorMouseEntered

    private void tblColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblColorMouseClicked
        btnAgregar2.setEnabled(false);
        btnModificar2.setEnabled(true);
        btnDesactivar2.setEnabled(true);
        int column=0;
        int fila = tblColor.getSelectedRow();
        if (fila > -1){
            cmbIDColor.setSelectedIndex(Integer.parseInt(tblColor.getModel().getValueAt(fila, column).toString()));
            txtColor.setText(String.valueOf(tblColor.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }
    }//GEN-LAST:event_tblColorMouseClicked

    private void btnDesactivar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar2ActionPerformed
        DesactivarColor();
    }//GEN-LAST:event_btnDesactivar2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        LimpiarNuevoColor();
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed

    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        AgregarColor();
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }

        if (txtColor.getText().length() >= 10){

            evt.consume();

        }
    }//GEN-LAST:event_txtColorKeyTyped

    private void cmbIDColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDColorItemStateChanged
        if(cmbIDColor.getSelectedIndex()==0){
            txtColor.setText("");
            btnDesactivar2.setEnabled(false);

        }
        else{
            Tipo_color cc;
            cc=Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
            txtColor.setText(cc.getTipo_color());
            btnActivarDesactivarColor();
        }
    }//GEN-LAST:event_cmbIDColorItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Reporte_Marcaexcel();
        } catch (ClassNotFoundException | SQLException | JRException | IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Reporte_Marcapdf();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        // FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void tblMarcaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMarcaMouseEntered

    private void tblMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcaMouseClicked
        btnAgregar1.setEnabled(false);
        btnModificar1.setEnabled(true);
        btnDesactivar1.setEnabled(true);
        int column=0;
        int fila = tblMarca.getSelectedRow();
        if (fila > -1){
            cmbIDMarca.setSelectedIndex(Integer.parseInt(tblMarca.getModel().getValueAt(fila, column).toString()));
            txtMarca.setText(String.valueOf(tblMarca.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }
    }//GEN-LAST:event_tblMarcaMouseClicked

    private void btnDesactivar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar1ActionPerformed
        DesactivarMarca();
    }//GEN-LAST:event_btnDesactivar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        //cmbIDMarca.setSelectedIndex(1);
        LimpiarMarca();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        ModificarMarca();

    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        AgregarMarca();
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }

        if (txtMarca.getText().length() >= 10){

            evt.consume();

        }
    }//GEN-LAST:event_txtMarcaKeyTyped

    private void cmbIDMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDMarcaItemStateChanged
        cmbIDMarca();
    }//GEN-LAST:event_cmbIDMarcaItemStateChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        createTableBusqueda();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalir8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir8ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir8ActionPerformed

    private void btnRegresar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar8ActionPerformed
        //  FrmMenu m = new FrmMenu();
        // m.setVisible(true);
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar8ActionPerformed

    private void chkTipoGasolinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTipoGasolinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTipoGasolinaActionPerformed

    private void chkTipoGasolinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTipoGasolinaItemStateChanged
        if(chkTipoGasolina.isSelected()){
            cmbGasolinaBusqueda.enable(true);
        }
        else{
            cmbGasolinaBusqueda.enable(false);
        }
        createcmbTipoGasolinaBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTipoGasolinaItemStateChanged

    private void chkTipoVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTipoVehiculoItemStateChanged

        if(chkTipoVehiculo.isSelected()){
            cmbTipoVehiculoBusqueda.enable(true);

        }
        else{
            cmbTipoVehiculoBusqueda.enable(false);
        }
        createcmbTipoVehiculoBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTipoVehiculoItemStateChanged

    private void chkColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkColorItemStateChanged
        if(chkColor.isSelected()){
            cmbColorBusqueda.enable(true);
        }
        else{
            cmbColorBusqueda.enable(false);
        }
        createcmbColorBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkColorItemStateChanged

    private void chkMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMarcaItemStateChanged
        if(chkMarca.isSelected()){
            //createcmbMarcaBusqueda();
            cmbMarcaBusqueda.enable(true);
        }
        else{
            //createcmbMarcaBusqueda();
            cmbMarcaBusqueda.enable(false);
        }
        createcmbMarcaBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMarcaItemStateChanged

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
         try{
   Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperReport reporte = null;
        try {
            reporte = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Historico_Precio_Vehiculo.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap param = new HashMap();
        param.put("Empleado", labelempleado.getText());
        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(reporte, param,con);
            //JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPrecioVehiculos.xlsx");

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPrecioVehiculos.xlsx");
        
        try {
            p.start();
        }catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
           try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperReport reporteFactura = null;
        try {
            reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Historico_Precio_Vehiculo.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap param = new HashMap();
         param.put("Empleado", labelempleado.getText());

         JasperPrint print= null;
        try {
                print = JasperFillManager.fillReport(reporteFactura, param,con);
                //JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File pdf = null;
        try {
            pdf = File.createTempFile("Reporte Historico Precios Vehículos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        } catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        } catch (FileNotFoundException | JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        try {
            p.start();
        } catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void btnRegresar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar10ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar10ActionPerformed

    private void btnSalir10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir10ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir10ActionPerformed

    private void cmbPrecioHistoricoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPrecioHistoricoItemStateChanged
        crearTbHistorialPrecio();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPrecioHistoricoItemStateChanged

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
               if(tbBusqueda.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No hay ningún Vehículo en la tabla","Error!",0);
            return;
        }
        else{
            
        }

            try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperReport reporteFactura = null;
        try {
            reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_BuscarVehiculos.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap param = new HashMap();
         param.put("Empleado",labelempleado.getText());
        param.put("ID", tbBusqueda.getModel().getValueAt(0, 0).toString());
        param.put("Marca", tbBusqueda.getModel().getValueAt(0, 1).toString());
        param.put("Modelo",tbBusqueda.getModel().getValueAt(0, 2).toString());
        param.put("Color", tbBusqueda.getModel().getValueAt(0, 3).toString());
        param.put("Combustible", tbBusqueda.getModel().getValueAt(0, 4).toString());
        param.put("TipoVehiculo", tbBusqueda.getModel().getValueAt(0, 5).toString());
        param.put("NumAsientos", tbBusqueda.getModel().getValueAt(0, 6).toString());
        param.put("Precio", tbBusqueda.getModel().getValueAt(0, 7).toString());
        param.put("Estado", tbBusqueda.getModel().getValueAt(0, 8).toString());
         JasperPrint print= null;
        try {
                print = JasperFillManager.fillReport(reporteFactura, param,con);
                //JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File pdf = null;
        try {
            pdf = File.createTempFile("Reporte Buscar Vehiculos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        } catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        } catch (FileNotFoundException | JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        try {
            p.start();
        } catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
   try {
            ReporteBuscarVehiculos();
        } catch (ClassNotFoundException | SQLException | JRException | IOException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton20ActionPerformed
public void ReporteBuscarVehiculos()  throws ClassNotFoundException, SQLException, JRException, IOException{
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_marcaexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_BuscarVehiculos.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_marcaexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteBuscarVehiculo.xlsx");
       

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteBuscarVehiculo.xlsx");
        p.start();
}
    public boolean AgregarMarca(){
    
        
        
        if(cmbIDMarca.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Marca siempre debe estar en el ITEM de Nuevo para agregar un nueva Marca","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDMarca.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtMarca.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para la Marca","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtMarca.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para la Marca es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtMarca.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para la Marca es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if (!ValidacionNombreMayusculaYDemasMinus(txtMarca.getText())){
            //JOptionPane.showMessageDialog(null,"La Marca debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtMarca.requestFocus();
            return false;
        }else{

        }
        
        if (ValidacionTresLetrasSeguidas(txtMarca.getText())){        
                        //JOptionPane.showMessageDialog(null,"No se Admite en la Marca la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtMarca.requestFocus(); 
                        return false;            
        }
        else{      
                     }
        if("".equals(txtMarca.getText())){
            //JOptionPane.showMessageDialog(null, "Ingrese la Marca");
            return false;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<Marcadao.findMarcaEntities().size();i++){
                //System.out.println(i);
                if(txtMarca.getText().toLowerCase().equals(Marcadao.findMarca(i+1).getMarca().toLowerCase())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Marca esta registrada en el sistema");
                    flag=true;
                    return false;
                } else {
                }
            }
            if(flag){
                return false;
            }
            else{
                Marca m = new Marca();
                m.setEstado(true);
                m.setMarca(txtMarca.getText());
                /*try {
                    Marcadao.create(m);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                //cmbIDMarca.setSelectedIndex(1);
                cmbIDMarca.setSelectedIndex(0);
                createTableMarca();
                createComboBoxMarca();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbMarcaVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(1);
                btnAgregar1.setEnabled(true);
                btnModificar1.setEnabled(false);
                btnDesactivar2.setEnabled(false);
                LimpiarMarca();
            }
        }
        return true;
}
    boolean ValidacionNombreMayusculaYDemasMinus(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.{3,40}$)[A-ZÑÁÉÍÓÚ][a-zñáéíóú]+(?: [a-zñáéíóúA-ZÑÁÉÍÓÚ]+)?+(?: [a-zñáéíóúA-ZÑÁÉÍÓÚ]+)?$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
}
public boolean ModificarMarca(){
    if(cmbIDMarca.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null, "Tipo de Marca no encontrada");
            return false;
        }
        else{
            if("".equals(txtMarca.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para la Marca","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtMarca.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para la Marca es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtMarca.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para la Marca es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if (!ValidacionNombreMayusculaYDemasMinus(txtMarca.getText())){
            //JOptionPane.showMessageDialog(null,"La Marca debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtMarca.requestFocus();
            return false;
        }else{

        }
        
        if (ValidacionTresLetrasSeguidas(txtMarca.getText())){        
                        //JOptionPane.showMessageDialog(null,"No se Admite en la Marca la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtMarca.requestFocus(); 
                        return false;            
        }
        else{      
                     }
            if("".equals(txtMarca.getText())){
                //JOptionPane.showMessageDialog(null, "Marca no puede ir vacio");
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<Marcadao.findMarcaEntities().size();i++){
                    //System.out.println(i);
                    if(txtMarca.getText().toLowerCase().equals(Marcadao.findMarca(i+1).getMarca().toLowerCase())){
                        //JOptionPane.showMessageDialog(null, "Ya existe esta Marca registrada en el sistema");
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    Marca m;
                    m=Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
                    m.setMarca(txtMarca.getText());
                    /*try {
                        Marcadao.edit(m);
                    } catch (Exception ex) {
                        Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                   // cmbIDMarca.setSelectedIndex(1);
                   Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                    cmbIDMarca.setSelectedIndex(0);
                    createTableMarca();
                    createComboBoxMarca();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbMarcaVehiculo();
                    this.jTabbedPane1.setSelectedIndex(1);
                    btnAgregar1.setEnabled(true);
                btnModificar1.setEnabled(false);
                btnDesactivar1.setEnabled(false);
                LimpiarMarca();
                }
            }
        }
    return true;
}
    public void LimpiarMarca(){
    cmbIDMarca.setSelectedIndex(0);
    txtMarca.setText("");
        createTableMarca();
        createComboBoxMarca();
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnDesactivar1.setEnabled(false);
}public boolean DesactivarMarca(){
            Marca temp;
        temp = Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Marca Desactivada exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Marca Activada exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            Marcadao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableMarca();
        btnActivarDesactivarMarca();
        LimpiarMarca();
        btnDesactivar1.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        return true;
}public boolean AgregarColor(){
    
        if(cmbIDColor.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Color siempre debe estar en el ITEM de Nuevo para agregar un nuevo Color","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDColor.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtColor.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Color","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtColor.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Color es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtColor.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Color es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtColor.getText())){
            //JOptionPane.showMessageDialog(null,"El Color debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtColor.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtColor.getText())){        
                 //JOptionPane.showMessageDialog(null,"No se Admite en el color la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtColor.requestFocus(); 
                        return false;   
        }
        else{
                        
                     }
        if("".equals(txtColor.getText())){
            //JOptionPane.showMessageDialog(null, "Ingrese el Color que es");
            return false;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<Colorrdao.findTipo_colorEntities().size();i++){
                //System.out.println(i);
                if(txtColor.getText().toLowerCase().equals(Colorrdao.findTipo_color(i+1).getTipo_color().toLowerCase())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este Color esta registrado en el sistema");
                    flag=true;
                    return false;
                } else {
                }
            }
            if(flag){
                return false;
            }
            else{
                Tipo_color cc = new Tipo_color();
                cc.setEstado(true);
                cc.setTipo_color(txtColor.getText());
                /*try {
                    Colorrdao.create(cc);
                } catch (Exception ex) {
                    Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                //cmbIDColor.setSelectedIndex(1);
                cmbIDColor.setSelectedIndex(0);
                createTableColor();
                createComboBoxColor();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbColorVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(2);
                LimpiarNuevoColor();
                btnAgregar2.setEnabled(true);
                btnModificar2.setEnabled(false);
            }
        }
        return true;
}public boolean ModificarColor(){
           if(cmbIDColor.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null, "Color no encontrado");
            return false;
        }
        else{
            if("".equals(txtColor.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Color","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtColor.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Color es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtColor.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Color es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtColor.getText())){
            //JOptionPane.showMessageDialog(null,"El Color debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtColor.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtColor.getText())){        
                 //JOptionPane.showMessageDialog(null,"No se Admite en el color la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtColor.requestFocus(); 
                        return false;   
        }
        else{
                        
                     }
            if("".equals(txtColor.getText())){
                //JOptionPane.showMessageDialog(null, "Color no puede ir vacio");
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<Colorrdao.findTipo_colorEntities().size();i++){
                    //System.out.println(i);
                    if(txtColor.getText().toLowerCase().equals(Colorrdao.findTipo_color(i+1).getTipo_color().toLowerCase())){
                        //JOptionPane.showMessageDialog(null, "Ya existe este Color registrado en el sistema");
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    Tipo_color cc;
                    cc=Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
                    cc.setTipo_color(txtColor.getText());
                    /*try {
                        Colorrdao.edit(cc);
                    } catch (Exception ex) {
                        Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    //cmbIDColor.setSelectedIndex(1);
                    Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                    cmbIDColor.setSelectedIndex(0);
                    createTableColor();
                    createComboBoxColor();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbColorVehiculo();
                    this.jTabbedPane1.setSelectedIndex(2);
                    LimpiarNuevoColor();
                btnAgregar2.setEnabled(true);
                btnModificar2.setEnabled(false);
                btnDesactivar2.setEnabled(false);
                }
            }
        }
           return true;
}
    public void LimpiarNuevoColor(){
        cmbIDColor.setSelectedIndex(0);
        txtColor.setText("");
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        createTableColor();
        createComboBoxColor();
}public boolean DesactivarColor(){
    Tipo_color temp;
        temp = Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Color Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Color Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            Colorrdao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableColor();
        btnActivarDesactivarColor();
        LimpiarNuevoColor();
        btnDesactivar2.setEnabled(false);
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
        return true;
}public boolean AgregarTipoVehiculo(){
    
        if(cmbIDTipoVehiculo.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Tipo de Vehículo siempre debe estar en el ITEM de Nuevo para agregar un nuevo Tipo de Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDTipoVehiculo.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtTipoVehiculo.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoVehiculo.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de Vehículo es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoVehiculo.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Vehículo es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoVehiculo.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Vehículo debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoVehiculo.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoVehiculo.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Vehículo la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoVehiculo.requestFocus(); 
            return false;
        
        }else{
                        
                        
                     }
        if("".equals(txtTipoVehiculo.getText())){
            //JOptionPane.showMessageDialog(null, "Ingrese el tipo de  Vehículo que es");
            return false;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoVehiculodao.findTipoVehiculoEntities().size();i++){
                //System.out.println(i);
                if(txtTipoVehiculo.getText().toLowerCase().equals(TipoVehiculodao.findTipoVehiculo(i+1).getTipoVehiculo().toLowerCase())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este tipo de  Vehículo registrado en el sistema");
                    flag=true;
                    return false;
                } else {
                }
            }
            if(flag){
                return false;
            }
            else{
                TipoVehiculo tp = new TipoVehiculo();
                tp.setEstado(true);
                tp.setTipoVehiculo(txtTipoVehiculo.getText());
                /*try {
                    TipoVehiculodao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
           //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                //cmbIDTipoVehiculo.setSelectedIndex(1);
                cmbIDTipoVehiculo.setSelectedIndex(0);
                createTableTipoVehiculo();
                createComboBoxTipoVehiculo();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoVehiculoVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(3);
                habilitarAgregarVehiculo();
                LimpiarNuevoTipoVehiculo();
                btnAgregar3.setEnabled(true);
                btnModificar3.setEnabled(false);
                
            }
        }
        return true;
}public boolean ModificarTipoVehiculo(){
    if(cmbIDTipoVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null, "Tipo de  Vehículo no encontrado");
            return false;
        }
        else{
           if("".equals(txtTipoVehiculo.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoVehiculo.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de Vehículo es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoVehiculo.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Vehículo es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoVehiculo.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Vehículo debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoVehiculo.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoVehiculo.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Vehículo la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoVehiculo.requestFocus(); 
            return false;
        
        }else{
                        
                        
                     }
            if("".equals(txtTipoVehiculo.getText())){
                //JOptionPane.showMessageDialog(null, "Tipo de  Vehículo no puede ir vacio");
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoVehiculodao.findTipoVehiculoEntities().size();i++){
                    //System.out.println(i);
                    if(txtMarca.getText().toLowerCase().equals(TipoVehiculodao.findTipoVehiculo(i+1).getTipoVehiculo().toLowerCase())){
                        //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Vehículo esta registrado en el sistema");
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    TipoVehiculo tp;
                    tp=TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
                    tp.setTipoVehiculo(txtTipoVehiculo.getText());
                    /*try {
                        TipoVehiculodao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    //cmbIDTipoVehiculo.setSelectedIndex(1);
                    Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                    cmbIDTipoVehiculo.setSelectedIndex(0);
                    createTableTipoVehiculo();
                    createComboBoxTipoVehiculo();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoVehiculoVehiculo();
                    this.jTabbedPane1.setSelectedIndex(3);
                    LimpiarNuevoTipoVehiculo();
                    btnAgregar3.setEnabled(true);
                    btnModificar3.setEnabled(false);
                    btnDesactivar3.setEnabled(false);
                }
            }
        }
    return true;
}
    public void LimpiarNuevoTipoVehiculo(){
    cmbIDTipoVehiculo.setSelectedIndex(0);
    txtTipoVehiculo.setText("");
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        createTableTipoVehiculo();
        createComboBoxTipoVehiculo();
}public boolean DesactivarTipoVehiculo(){
     TipoVehiculo temp;
        temp = TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Vehículo Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Vehículo Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            TipoVehiculodao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(TipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableTipoVehiculo();
        btnActivarDesactivarTipoVehiculo();
        LimpiarNuevoTipoVehiculo();
        btnDesactivar3.setEnabled(false);
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        return true;
}public boolean AgregarTipoCabina(){
    
        if(cmbPiezaClave.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Tipo de Cabina siempre debe estar en el ITEM de Nuevo para agregar un nuevo Tipo de Cabina","Error!", JOptionPane.ERROR_MESSAGE);
            cmbPiezaClave.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtTipoCabina.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Cabina","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoCabina.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de Cabina es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoCabina.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Cabina es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoCabina.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Cabina debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoCabina.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoCabina.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Cabina la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtTipoCabina.requestFocus(); 
                        return false;
        }
        else{
                        
                     }
        if("".equals(txtTipoCabina.getText())){
            //JOptionPane.showMessageDialog(null, "Ingrese el tipo de Cabina que es");
            return false;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoCabinadao.findTipoCabinaEntities().size();i++){
                //System.out.println(i);
                if(txtTipoCabina.getText().toLowerCase().equals(TipoCabinadao.findTipoCabina(i+1).getTipoCabina().toLowerCase())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Cabina registrada en el sistema");
                    flag=true;
                    return false;
                } else {
                }
            }
            if(flag){
                return false;
            }
            else{
                TipoCabina tp = new TipoCabina();
                tp.setEstado(true);
                tp.setTipoCabina(txtTipoCabina.getText());
                /*try {
                    TipoCabinadao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                //cmbIDTipoCabina.setSelectedIndex(1);
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
           //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                cmbPiezaClave.setSelectedIndex(0);
                createTableTipoCabina();
                createComboBoxTipoCabina();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoCabinaVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(4);
                LimpiarNuevoTipoCabina();
            }
        }
        return true;
}public boolean ModificarTipoCabina(){
   if(cmbPiezaClave.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Cabina no encontrada");
        }
        else{
            if("".equals(txtTipoCabina.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Cabina","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoCabina.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de Cabina es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoCabina.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Cabina es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoCabina.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Cabina debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoCabina.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoCabina.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Cabina la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtTipoCabina.requestFocus(); 
                        return false;
        }
        else{
                        
                     }
            if("".equals(txtTipoCabina.getText())){
                //JOptionPane.showMessageDialog(null, "Tipo de cabina no puede ir vacia");
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoCabinadao.findTipoCabinaEntities().size();i++){
                    //System.out.println(i);
                    if(txtTipoCabina.getText().toLowerCase().equals(TipoCabinadao.findTipoCabina(i+1).getTipoCabina().toLowerCase())){
                        //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Cabina ya esta registrado en el sistema");
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    TipoCabina tp;
                    tp=TipoCabinadao.findTipoCabina(cmbPiezaClave.getSelectedIndex());
                    tp.setTipoCabina(txtTipoCabina.getText());
                    /*try {
                        TipoCabinadao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoCabina.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                   // cmbIDTipoCabina.setSelectedIndex(1);
                   Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                    cmbPiezaClave.setSelectedIndex(0);
                    createTableTipoCabina();
                    createComboBoxTipoCabina();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoCabinaVehiculo();
                    this.jTabbedPane1.setSelectedIndex(4);
                    LimpiarNuevoTipoCabina();
                }
            }
        }
   return true;
}
    public void LimpiarNuevoTipoCabina(){
    cmbPiezaClave.setSelectedIndex(0);
    txtTipoCabina.setText("");
        btnAgregar4.setEnabled(true);
        btnModificar4.setEnabled(false);
        btnDesactivar4.setEnabled(false);
        createTableTipoCabina();
        createComboBoxTipoCabina();
}public boolean DesactivarTipoCabina(){
     TipoCabina temp;
        temp = TipoCabinadao.findTipoCabina(cmbPiezaClave.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Cabina Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Cabina Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            TipoCabinadao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(TipoCabina.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableTipoCabina();
        btnActivarDesactivarTipoCabina();
        LimpiarNuevoTipoCabina();
        return true;
}public boolean AgregarTipoCombustible(){
    
        if(cmbIDTipoGasolina.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Tipo de Combustible siempre debe estar en el ITEM de Nuevo para agregar un nuevo Tipo de Gasolina","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDTipoGasolina.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtTipoGasolina.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Combustible","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoGasolina.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de Combustible es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoGasolina.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Combustible es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoGasolina.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Combustible debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoGasolina.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoGasolina.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Combustible la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoGasolina.requestFocus(); 
            return false;
        
        }else{
                        
                     }
        if("".equals(txtTipoGasolina.getText())){
            //JOptionPane.showMessageDialog(null, "Ingrese el tipo de Gasolina que es");
            return false;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoGasolinadao.findTipoGasolinaEntities().size();i++){
                //System.out.println(i);
                if(txtTipoGasolina.getText().toLowerCase().equals(TipoGasolinadao.findTipoGasolina(i+1).getTipoGasolina().toLowerCase())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Combustible registrado en el sistema");
                    flag=true;
                    return false;
                } else {
                }
            }
            if(flag){
                return false;
            }
            else{
                TipoGasolina tp = new TipoGasolina();
                tp.setEstado(true);
                tp.setTipoGasolina(txtTipoGasolina.getText());
                /*try {
                    TipoGasolinadao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                //cmbIDTipoGasolina.setSelectedIndex(1);
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                cmbIDTipoGasolina.setSelectedIndex(0);
                createTableTipoGasolina();
                createComboBoxTipoGasolina();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoGasolinaVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(5);
                LimpiarNuevoTipoGasolina();
                
            }
        }
        return true;
}public boolean ModificarTipoCombustible(){
    if(cmbIDTipoGasolina.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null, "Tipo de Combustible no encontrado");
            return false;
        }
        else{
            if("".equals(txtTipoGasolina.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Combustible","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoGasolina.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de Combustible es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoGasolina.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Combustible es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoGasolina.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Combustible debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoGasolina.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoGasolina.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Combustible la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoGasolina.requestFocus(); 
            return false;
        
        }else{
                        
                     }
            if("".equals(txtTipoGasolina.getText())){
                //JOptionPane.showMessageDialog(null, "Tipo de Gasolina no puede ir vacio");
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoGasolinadao.findTipoGasolinaEntities().size();i++){
                    //System.out.println(i);
                    if(txtMarca.getText().toLowerCase().equals(TipoGasolinadao.findTipoGasolina(i+1).getTipoGasolina().toLowerCase())){
                        //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Combustible registrado en el sistema");
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    TipoGasolina tp;
                    tp=TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
                    tp.setTipoGasolina(txtTipoGasolina.getText());
                    /*try {
                        TipoGasolinadao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoGasolina.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    //cmbIDTipoGasolina.setSelectedIndex(1);
                    cmbIDTipoGasolina.setSelectedIndex(0);
                    createTableTipoGasolina();
                    createComboBoxTipoGasolina();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoGasolinaVehiculo();
                    this.jTabbedPane1.setSelectedIndex(5);
                    LimpiarNuevoTipoGasolina();
                }
            }
        }return true;
}
    public void LimpiarNuevoTipoGasolina(){
    cmbIDTipoGasolina.setSelectedIndex(0);
    txtTipoGasolina.setText("");
        btnAgregar5.setEnabled(true);
        btnModificar5.setEnabled(false);
        btnDesactivar5.setEnabled(false);
        createTableTipoGasolina();
        createComboBoxTipoGasolina();
}public boolean DesactivarTipoCombustible(){
    TipoGasolina temp;
        temp = TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Combustible Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Combustible Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            TipoGasolinadao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(TipoGasolina.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableTipoGasolina();
        btnActivarDesactivarTipoGasolina();
        LimpiarNuevoTipoGasolina();
        return true;
}public boolean AgregarTransmision(){
    
        if(cmbIDTipoTransmision.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Tipo de Transmisión siempre debe estar en el ITEM de Nuevo para agregar un nuevo Tipo de Transmisión","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDTipoTransmision.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtTipoTransmision.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Transmisión","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoTransmision.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el cargo es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoTransmision.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Transmisión es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoTransmision.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Transmisión debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoTransmision.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoTransmision.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Transmisión la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoTransmision.requestFocus(); 
            return false;
        }else{
                        
                     }
        if("".equals(txtTipoTransmision.getText())){
            //JOptionPane.showMessageDialog(null, "Ingrese el tipo de Transmisión que es");
            return false;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoTransmisiondao.findtransmisionEntities().size();i++){
                //System.out.println(i);
                if(txtTipoTransmision.getText().toLowerCase().equals(TipoTransmisiondao.findtransmision(i+1).getTransmision().toLowerCase())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Transmisión esta registrada en el sistema");
                    flag=true;
                    return false;
                } 
                else {
                }
            }
            if(flag){
                return false;
            }
            else{
                transmision tp = new transmision();
                tp.setEstado(true);
                tp.setTransmision(txtTipoTransmision.getText());
                /*try {
                    TipoTransmisiondao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }*/
               // cmbIDTipoTransmision.setSelectedIndex(1);
               Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
           //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                cmbIDTipoTransmision.setSelectedIndex(0);
                createTableTipoTransmision();
                createComboBoxTipoTransmision();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoTransmisionVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(7);
                LimpiarNuevoTipoTransmision();
            }
        }
        return true;
}public boolean ModificarTransmision(){
           if(cmbIDTipoTransmision.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null, "Tipo de Transmisión no encontrado");
            return false;
        }
        else{
            if("".equals(txtTipoTransmision.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Tipo de Transmisión","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(txtTipoTransmision.getText().length()<3){
            //JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el cargo es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoTransmision.getText().length()>25){
            //JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Transmisión es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }

        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoTransmision.getText())){
            //JOptionPane.showMessageDialog(null,"El Tipo de Transmisión debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoTransmision.requestFocus();
            return false;
        }else{

        }
        if (ValidacionTresLetrasSeguidas(txtTipoTransmision.getText())){        
            //JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Transmisión la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoTransmision.requestFocus(); 
            return false;
        }else{
                        
                     }
            if("".equals(txtTipoTransmision.getText())){
                //JOptionPane.showMessageDialog(null, "Tipo de Transmisión no puede ir vacio");
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoTransmisiondao.findtransmisionEntities().size();i++){
                    //System.out.println(i);
                    if(txtTipoTransmision.getText().toLowerCase().equals(TipoTransmisiondao.findtransmision(i+1).getTransmision().toLowerCase())){
                        //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Transmisión esta registrado en el sistema");
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    transmision tp;
                    tp=TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
                    tp.setTransmision(txtTipoTransmision.getText());
                    /*try {
                        TipoTransmisiondao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(transmision.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    //cmbIDTipoTransmision.setSelectedIndex(1);
                    Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                    cmbIDTipoTransmision.setSelectedIndex(0);
                    createTableTipoTransmision();
                    createComboBoxTipoTransmision();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoTransmisionVehiculo();
                    this.jTabbedPane1.setSelectedIndex(7);
                    LimpiarNuevoTipoTransmision();
                }
            }
        }
           return true;
}
    public void LimpiarNuevoTipoTransmision(){
    cmbIDTipoTransmision.setSelectedIndex(0);
    txtTipoTransmision.setText("");
        btnAgregar6.setEnabled(true);
        btnModificar6.setEnabled(false);
        btnDesactivar6.setEnabled(false);
        createTableTipoTransmision();
        createComboBoxTipoTransmision();
}public boolean DesactivarTransmision(){
    transmision temp;
        temp = TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Transmisión Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de Transmisión Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            TipoTransmisiondao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(transmision.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableTipoTransmision();
        btnActivarDesactivarTipoTransmision();
        LimpiarNuevoTipoTransmision();
        return true;
}public boolean DesactivarVehiculo(){
            Vehiculo temp;
        temp = vehiculoDao.findVehiculo(cmbIDVehiculo.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de pieza Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Tipo de pieza Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            vehiculoDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableVehiculosAgregar();
        btnActivarDesactivarVehiculo();
        limpiar();
        return true;
}public boolean ModificarVehiculo(){
if(cmbMarcaVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione una marca","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        else{
            
        }
        if(cmbMarcaVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione una marca","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        else{
            
        }
        Marca m;
        m = Marcadao.findMarca(cmbMarcaVehiculo.getSelectedIndex());
        if(m.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Esta Marca esta Desactivada","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtVin.getText().equals("")){
            //JOptionPane.showMessageDialog(null,"El campo de Modelo del Vehículo esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        if(txtVin.getText().length()<3){
            //JOptionPane.showMessageDialog(null,"Modelo no puede contener menos de 3 letras","Error!",JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        if(txtVin.getText().length()>15){
            //JOptionPane.showMessageDialog(null,"Modelo solo puede contener hasta 15 letras","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
         if (!ValidacionNombreMayusculaYDemasMinus(txtVin.getText())){
            //JOptionPane.showMessageDialog(null,"El Modelo debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtVin.requestFocus();
            return false;
        }else{

        }
        
        if(cmbColorVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione una Color","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        Tipo_color co;
        co = Colorrdao.findTipo_color(cmbColorVehiculo.getSelectedIndex());
        if(co.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Color esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(cmbTipoVehiculoVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione el Tipo de Vehículo","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        TipoVehiculo tpv;
        tpv = TipoVehiculodao.findTipoVehiculo(cmbTipoVehiculoVehiculo.getSelectedIndex());
        if(tpv.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Vehículo esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        
        if(cmbGasolinaVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione un Tipo de Gasolina","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        TipoGasolina tpg;
        tpg = TipoGasolinadao.findTipoGasolina(cmbGasolinaVehiculo.getSelectedIndex());
        if(tpg.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Gasolina esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(cmbNumAsientos.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione el Número de Asientos","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        Numero_Asientos nt;
        nt = NumeroAsientosdao.findNumero_Asientos(cmbNumAsientos.getSelectedIndex());
        if(nt.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Número de Asientos esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(cmbCabinaVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione un Tipo de Cabina","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        TipoCabina tpc;
        tpc = TipoCabinadao.findTipoCabina(cmbCabinaVehiculo.getSelectedIndex());
        if(tpc.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Cabina esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        
        if(cmbTransmisionVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione el Tipo de Transmisión","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        transmision tpt;
        tpt = TipoTransmisiondao.findtransmision(cmbTransmisionVehiculo.getSelectedIndex());
        if(tpt.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Transmisión esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        
        //Validacion de cilindraje
        if("".equals(txtCilindraje.getText())){
            //JOptionPane.showMessageDialog(null, "Por favor, ingresar un cilindraje","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }    
        if(Integer.parseInt(txtCilindraje.getText())<0 || Integer.parseInt(txtCilindraje.getText())>18 ){
            //JOptionPane.showMessageDialog(null, "Cilindraje ingresado no valido\nSugrencias:\n4\n6\n8\n16","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        //Fin validacion de cilindraje
        //Validacion de stock
        if("".equals(ftxtStock.getText())){
               //JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad de Stock actual del vehículo","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if((Integer.parseInt(ftxtStock.getText())==0)){
               //JOptionPane.showMessageDialog(null, "El Stock actual no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if (!ValidacionRangoStockVehiculo(ftxtStock.getText())){
            //JOptionPane.showMessageDialog(null,"El rango de Stock de Vehículos solo puede estar entre 1-200","Error!", JOptionPane.ERROR_MESSAGE);
            ftxtStock.requestFocus();
            return false;
        }else{

        }
        if("".equals(ftxtStockMinimo.getText())){
               //JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad de Stock Mínimo que puede haber de este Vehiculo","",0);
               return false;
           }
           else{
               
           }
        if((Integer.parseInt(ftxtStockMinimo.getText())<1)){
               //JOptionPane.showMessageDialog(null, "El Stock Mínimo actual no puedo ser menor que uno","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if(Double.parseDouble(ftxtStock.getText())<Integer.parseInt(ftxtStockMinimo.getText())){
               //JOptionPane.showMessageDialog(null, "El Stock no puede ser menor al Stock Mínimo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           if("".equals(ftxtStockMaximo.getText())){
               //JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad Máxima de Stock que puede haber de este Vehículo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           else{
               
           }
           if((Integer.parseInt(ftxtStockMaximo.getText())==0)){
               //JOptionPane.showMessageDialog(null, "El Stock Máximo no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
           if (!ValidacionRangoStockVehiculo(ftxtStockMaximo.getText())){
            //JOptionPane.showMessageDialog(null,"El rango de Stock de Vehículos solo puede estar entre 1-200","Error!", JOptionPane.ERROR_MESSAGE);
            ftxtStockMaximo.requestFocus();
            return false;
            }else{

            }
           
           if(Integer.parseInt(ftxtStockMinimo.getText()) >= Integer.parseInt(ftxtStockMaximo.getText())){
               //JOptionPane.showMessageDialog(null, "El Stock Mínimo no puede ser igual o mayor al stock Máximo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           else{
            }
           if("".equals(txtPrecio.getText())){
               //JOptionPane.showMessageDialog(null,"Por favor ingrese el Precio del Vehículo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           else{
               
           }
           if (!ValidacionRangoPrecioVehiculo(txtPrecio.getText())){
            //JOptionPane.showMessageDialog(null,"El rango de Precio del Vehículo solo puede estar entre 50,000.00-800,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecio.requestFocus();
            return false;
            }else{

            }
           Vehiculo temp = new Vehiculo();
           temp.setEstado(true);
           temp.setId_marca(cmbMarcaVehiculo.getSelectedIndex());
           temp.setId_numero_asientos(cmbNumAsientos.getSelectedIndex());
           temp.setId_tipo_cabina(cmbCabinaVehiculo.getSelectedIndex());
           temp.setId_tipo_color(cmbColorVehiculo.getSelectedIndex());
           temp.setId_tipo_gasolina(cmbGasolinaVehiculo.getSelectedIndex());
           temp.setId_tipo_vehiculo(cmbTipoVehiculoVehiculo.getSelectedIndex());
           temp.setId_transmision(cmbTransmisionVehiculo.getSelectedIndex());
           temp.setStock(Integer.parseInt(ftxtStock.getText()));
           temp.setStock_maximo(Integer.parseInt(ftxtStockMaximo.getText()));
           temp.setStock_minimo(Integer.parseInt(ftxtStockMinimo.getText()));
           temp.setId_vehiculo(cmbIDVehiculo.getSelectedIndex());
           
           
           
           temp.setTotal_cilindraje(Double.parseDouble(txtCilindraje.getText()));
           temp.setVin(txtVin.getText());
           
        /*try {
            vehiculoDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
           
       
        
        HistoricoPrecioVehiculos temp2 = new HistoricoPrecioVehiculos();   
        List<HistoricoPrecioVehiculos> t1 = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        
        for(HistoricoPrecioVehiculos e : t1){
            if(e.getId_vehiculo()==cmbIDVehiculo.getSelectedIndex() && e.getFechaFinal()==null){
                temp2 = e;
            }
        }
        
        
        
        if(temp2.getPrecio()!=Double.parseDouble(txtPrecio.getText().replace(",", "").replace(",", "").replace("%.2f%n", ""))){
        temp2.setEstado(true);
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        if(fecha.get(Calendar.DAY_OF_MONTH)==1){
            aux2=(fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH))) : Integer.toString(fecha.get(Calendar.MONTH));
            aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1);
        }
        else{
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1);
        }
        fecha1 = aux1+aux2+aux3;
        temp2.setFechaFinal(fecha1);
        double aux=(Double.parseDouble(txtPrecio.getText().replace(",", "").replace(",", "").trim()));
        //double aux=Float.parseFloat(txtPrecio.getText().trim());
        //temp2.setPrecio(aux);
       // temp2.setId_vehiculo(cmbIDVehiculo.getSelectedIndex());
        
        
            /*try {
                historicoPrecioVehiculoDao.edit(temp2);
            } catch (Exception ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            aux1 = Integer.toString(fecha.get(Calendar.YEAR));
            aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
            aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
            fecha1 = aux1+aux2+aux3;
            
           HistoricoPrecioVehiculos temp3 = new HistoricoPrecioVehiculos();
           temp3.setId_vehiculo(cmbIDVehiculo.getSelectedIndex());
           temp3.setFechaInicial(fecha1);
           temp3.setEstado(true);
           double auxs=(Double.parseDouble(txtPrecio.getText().replace(",", "").replace(",", "").trim()));
           temp3.setPrecio(auxs);
           
           //historicoPrecioVehiculoDao.create(temp3);
            
            
        }
        Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
        //JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
        createTableVehiculosAgregar();
        createcmbIDVehiculo();
        limpiar();
        return true;
}public boolean AgregarVehiculos(){
     if(cmbIDVehiculo.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Vehículo siempre debe estar en el ITEM de Nuevo para agregar un Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDVehiculo.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if(cmbMarcaVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione una marca","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        else{
            
        }
        Marca m;
        m = Marcadao.findMarca(cmbMarcaVehiculo.getSelectedIndex());
        if(m.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Esta Marca esta Desactivada","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtVin.getText().equals("")){
            //JOptionPane.showMessageDialog(null,"El campo de Modelo del Vehículo esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        if(txtVin.getText().length()<3){
            //JOptionPane.showMessageDialog(null,"Modelo no puede contener menos de 3 letras","Error!",JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        if(txtVin.getText().length()>15){
            //JOptionPane.showMessageDialog(null,"Modelo solo puede contener hasta 15 letras","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
         if (!ValidacionNombreMayusculaYDemasMinus(txtVin.getText())){
            //JOptionPane.showMessageDialog(null,"El Modelo debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtVin.requestFocus();
            return false;
        }else{

        }
        
        if(cmbColorVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione una Color","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        Tipo_color co;
        co = Colorrdao.findTipo_color(cmbColorVehiculo.getSelectedIndex());
        if(co.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Color esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(cmbTipoVehiculoVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione el Tipo de Vehículo","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        TipoVehiculo tpv;
        tpv = TipoVehiculodao.findTipoVehiculo(cmbTipoVehiculoVehiculo.getSelectedIndex());
        if(tpv.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Vehículo esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        
        if(cmbGasolinaVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione un Tipo de Gasolina","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        TipoGasolina tpg;
        tpg = TipoGasolinadao.findTipoGasolina(cmbGasolinaVehiculo.getSelectedIndex());
        if(tpg.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Gasolina esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(cmbNumAsientos.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione el Número de Asientos","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        Numero_Asientos nt;
        nt = NumeroAsientosdao.findNumero_Asientos(cmbNumAsientos.getSelectedIndex());
        if(nt.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Número de Asientos esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(cmbCabinaVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione un Tipo de Cabina","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        TipoCabina tpc;
        tpc = TipoCabinadao.findTipoCabina(cmbCabinaVehiculo.getSelectedIndex());
        if(tpc.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Cabina esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        
        if(cmbTransmisionVehiculo.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null,"Seleccione el Tipo de Transmisión","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        transmision tpt;
        tpt = TipoTransmisiondao.findtransmision(cmbTransmisionVehiculo.getSelectedIndex());
        if(tpt.isEstado()!=true){
            //JOptionPane.showMessageDialog(null,"Este Tipo de Transmisión esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        
        //Validacion de cilindraje
        if("".equals(txtCilindraje.getText())){
            //JOptionPane.showMessageDialog(null, "Por favor, ingresar un cilindraje","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }    
        if(Integer.parseInt(txtCilindraje.getText())<0 || Integer.parseInt(txtCilindraje.getText())>18 ){
            //JOptionPane.showMessageDialog(null, "Cilindraje ingresado no valido\nSugrencias:\n4\n6\n8\n16","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
        }
        //Fin validacion de cilindraje
        //Validacion de stock
        if("".equals(ftxtStock.getText())){
               //JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad de Stock actual del vehículo","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if((Integer.parseInt(ftxtStock.getText())==0)){
               //JOptionPane.showMessageDialog(null, "El Stock actual no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if (!ValidacionRangoStockVehiculo(ftxtStock.getText())){
            //JOptionPane.showMessageDialog(null,"El rango de Stock de Vehículos solo puede estar entre 1-200","Error!", JOptionPane.ERROR_MESSAGE);
            ftxtStock.requestFocus();
            return false;
        }else{

        }
        if("".equals(ftxtStockMinimo.getText())){
               //JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad de Stock Mínimo que puede haber de este Vehiculo","",0);
               return false;
           }
           else{
               
           }
        if((Integer.parseInt(ftxtStockMinimo.getText())<1)){
               //JOptionPane.showMessageDialog(null, "El Stock Mínimo actual no puedo ser menor que uno","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if(Double.parseDouble(ftxtStock.getText())<Integer.parseInt(ftxtStockMinimo.getText())){
               //JOptionPane.showMessageDialog(null, "El Stock no puede ser menor al Stock Mínimo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           if("".equals(ftxtStockMaximo.getText())){
               //JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad Máxima de Stock que puede haber de este Vehículo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           else{
               
           }
           if((Integer.parseInt(ftxtStockMaximo.getText())==0)){
               //JOptionPane.showMessageDialog(null, "El Stock Máximo no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
           if (!ValidacionRangoStockVehiculo(ftxtStockMaximo.getText())){
            //JOptionPane.showMessageDialog(null,"El rango de Stock de Vehículos solo puede estar entre 1-200","Error!", JOptionPane.ERROR_MESSAGE);
            ftxtStockMaximo.requestFocus();
            return false;
            }else{

            }
           
           if(Integer.parseInt(ftxtStockMinimo.getText()) >= Integer.parseInt(ftxtStockMaximo.getText())){
               //JOptionPane.showMessageDialog(null, "El Stock Mínimo no puede ser igual o mayor al stock Máximo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           else{
            }
           if("".equals(txtPrecio.getText())){
               //JOptionPane.showMessageDialog(null,"Por favor ingrese el Precio del Vehículo","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           else{
               
           }
           if (!ValidacionRangoPrecioVehiculo(txtPrecio.getText())){
            //JOptionPane.showMessageDialog(null,"El rango de Precio del Vehículo solo puede estar entre 50,000.00-800,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecio.requestFocus();
            return false;
            }else{

            }
           
           
           Vehiculo temp = new Vehiculo();
           temp.setEstado(true);
           temp.setId_marca(cmbMarcaVehiculo.getSelectedIndex());
           temp.setId_numero_asientos(cmbNumAsientos.getSelectedIndex());
           temp.setId_tipo_cabina(cmbCabinaVehiculo.getSelectedIndex());
           temp.setId_tipo_color(cmbColorVehiculo.getSelectedIndex());
           temp.setId_tipo_gasolina(cmbGasolinaVehiculo.getSelectedIndex());
           temp.setId_tipo_vehiculo(cmbTipoVehiculoVehiculo.getSelectedIndex());
           temp.setId_transmision(cmbTransmisionVehiculo.getSelectedIndex());
           temp.setStock(Integer.parseInt(ftxtStock.getText()));
           temp.setStock_maximo(Integer.parseInt(ftxtStockMaximo.getText()));
           temp.setStock_minimo(Integer.parseInt(ftxtStockMinimo.getText()));
           
           
           
           temp.setTotal_cilindraje(Double.parseDouble(txtCilindraje.getText()));
           temp.setVin(txtVin.getText());
           
        /*try {
            vehiculoDao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
           
        HistoricoPrecioVehiculos temp2 = new HistoricoPrecioVehiculos();   
        
        temp2.setEstado(true);
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        fecha1 = aux1+aux2+aux3;
        temp2.setFechaInicial(fecha1);
        double aux=(Double.parseDouble(txtPrecio.getText().replace(",", "").replace(",", "").trim()));
        //double aux=Float.parseFloat(txtPrecio.getText().trim());
        temp2.setPrecio(aux);
        temp2.setId_vehiculo(vehiculoDao.getVehiculoCount());
        
        
        /*historicoPrecioVehiculoDao.create(temp2);*/
        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
        //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        
        createTableVehiculosAgregar();
        createcmbIDVehiculo();
        limpiar();
        return true;
}
    private void limpiar(){
        txtVin.setText("");
        txtCilindraje.setText("");
        ftxtStock.setText("0");
        ftxtStockMaximo.setText("0");
        ftxtStockMinimo.setText("0");
        txtPrecio.setText("");
        //cmbColorVehiculo.setSelectedIndex(0);
        cmbTransmisionVehiculo.setSelectedIndex(0);
        cmbTipoVehiculoVehiculo.setSelectedIndex(0);
        cmbGasolinaVehiculo.setSelectedIndex(0);
        cmbCabinaVehiculo.setSelectedIndex(0);
        cmbNumAsientos.setSelectedIndex(0);
        cmbMarcaVehiculo.setSelectedIndex(0);
        cmbIDVehiculo.setSelectedIndex(0);
        cmbColorVehiculo.setSelectedIndex(0);
        //createTableVehiculosAgregar();
        //createcmbIDVehiculo();
        btnAgregar7.setEnabled(true);
        btnModificar7.setEnabled(false);
        btnDesactivar7.setEnabled(false);
        
    }
 public boolean ValidacionRangoStockVehiculo(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([1]|[2-9]|[1-9][0-9]|[1][0-9][0-9]|[2][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }  
 public boolean ValidacionRangoPrecioVehiculo(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([5-9][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[1-7][0-9][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[8][0][0][,][0][0][0][.][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }  public boolean AgregarNumeroAsientos(){
    if(cmbIDNumeroAsientos.getSelectedIndex()!=0){
            //JOptionPane.showMessageDialog(null, "El ID Número de Asientos siempre debe estar en el ITEM de Nuevo para agregar un nuevo Número de Asientos","Error!", JOptionPane.ERROR_MESSAGE);
            cmbIDNumeroAsientos.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtNumeroAsientos.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Número de Asientos","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if((Integer.parseInt(txtNumeroAsientos.getText())<=2)||(Integer.parseInt(txtNumeroAsientos.getText())>=24)){
            //JOptionPane.showMessageDialog(null,"El Número de Asientos no pueder ser mayor a 24","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if("".equals(txtNumeroAsientos.getText())){
            //JOptionPane.showMessageDialog(null, "Ingrese el Número de Asientos que es");
           return false;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<NumeroAsientosdao.findNumero_AsientosEntities().size();i++){
                //System.out.println(i);
                if(txtNumeroAsientos.getText().toLowerCase().equals(NumeroAsientosdao.findNumero_Asientos(i+1).getNumero_Asientos().toLowerCase())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este Número de Asientos registrado en el sistema");
                    flag=true;
                    return false;
                } else {
                }
            }
            if(flag){
                return false;
            }
            else{
                Numero_Asientos tp = new Numero_Asientos();
                tp.setEstado(true);
                tp.setNumero_Asientos(txtNumeroAsientos.getText());
                /*try {
                    NumeroAsientosdao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                //cmbIDNumeroAsientos.setSelectedIndex(1);
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                cmbIDNumeroAsientos.setSelectedIndex(0);
                createTableNumeroAsientos();
                createComboBoxNumeroAsientos();
                this.jTabbedPane1.setSelectedIndex(8);
                createNumAsientosVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(6);
                LimpiarNuevoNumeroAsientos();
            }
        }
        return true;
}public boolean ModificarNumeroAsientos(){
    if(cmbIDNumeroAsientos.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(null, "Número de Asientos no encontrado");
            return false;
        }
        else{
           if("".equals(txtNumeroAsientos.getText())){
            //JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Número de Asientos","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if((Integer.parseInt(txtNumeroAsientos.getText())<=2)||(Integer.parseInt(txtNumeroAsientos.getText())>=24)){
            //JOptionPane.showMessageDialog(null,"El Número de Asientos no pueder ser mayor a 24","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
            if("".equals(txtNumeroAsientos.getText())){
                //JOptionPane.showMessageDialog(null, "Número de Asientos no puede ir vacio");
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<NumeroAsientosdao.findNumero_AsientosEntities().size();i++){
                    //System.out.println(i);
                    if(((txtNumeroAsientos.getText())).equals((NumeroAsientosdao.findNumero_Asientos(i+1).getNumero_Asientos()))){
                        //JOptionPane.showMessageDialog(null, "Ya existe este Número de Asientos registrado en el sistema");
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    Numero_Asientos tp;
                    tp=NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
                    tp.setNumero_Asientos(txtNumeroAsientos.getText());
                    /*try {
                        NumeroAsientosdao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoGasolina.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    //cmbIDNumeroAsientos.setSelectedIndex(1);
                    Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                //JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                    cmbIDNumeroAsientos.setSelectedIndex(0);
                    createTableNumeroAsientos();
                    createComboBoxNumeroAsientos();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createNumAsientosVehiculo();
                    this.jTabbedPane1.setSelectedIndex(6);
                    LimpiarNuevoNumeroAsientos();
                }
            }
        }
    return true;
}
    public void LimpiarNuevoNumeroAsientos(){
    cmbIDNumeroAsientos.setSelectedIndex(0);
    txtNumeroAsientos.setText("");
        btnAgregar8.setEnabled(true);
        btnModificar8.setEnabled(false);
        btnDesactivar8.setEnabled(false);
        createTableNumeroAsientos();
        createComboBoxNumeroAsientos();
}public boolean DesactivarNumeroAsientos(){
    Numero_Asientos temp;
        temp = NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            //JOptionPane.showMessageDialog(null,"Número de Asientos Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            //JOptionPane.showMessageDialog(null,"Número de Asientos Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        /*try {
            NumeroAsientosdao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(transmision.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        createTableNumeroAsientos();
        btnActivarDesactivarNumeroAsientos();
        LimpiarNuevoNumeroAsientos();
        return true;
}boolean ValidacionTresLetrasSeguidas(String Marca){
        
            Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*|.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*|.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            Matcher mat = pat.matcher(Marca);
            
            if(mat.matches()){
                //JOptionPane.showMessageDialog(null, "Por favor, ingrese la marca valida","Error",JOptionPane.ERROR_MESSAGE);
                return true;   
            }
            else{
               return false; 
            }
    } public void Reporte_Marcapdf() throws ClassNotFoundException, IOException, SQLException, JRException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Marcapdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteMarca_1.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Marcapdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Marca"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Marcaexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_marcaexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteMarca_1.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_marcaexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteMarca.xlsx");
       

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteMarca.xlsx");
        p.start();
}public void Reporte_Colorpdf() throws ClassNotFoundException, IOException, SQLException, JRException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Colorpdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Color.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Colorpdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Color"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Colorexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Colorexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Color.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Colorexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteColor.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteColor.xlsx");
        p.start();
}public void Reporte_Tipo_Vehiculopdf() throws ClassNotFoundException, IOException, JRException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Vehiculopdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Vehiculo.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Vehiculopdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Tipo de Vehiculo"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Tipo_Vehiculoexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Vehiculoexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Vehiculo.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Vehiculoexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reportetipovehiculo.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reportetipovehiculo.xlsx");
        p.start();
}public void Reporte_Tipo_Cabinapdf() throws ClassNotFoundException, IOException, SQLException, JRException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Cabinapdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Cabina.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Cabinapdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Tipo de Cabina"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Tipo_Cabinaexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Cabinaexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Cabina.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Cabinaexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteCabina.xlsx");
            

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteCabina.xlsx");
        p.start();
}public void Reporte_Tipo_Gasolinapdf() throws ClassNotFoundException, IOException, JRException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Gasolinapdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Gasolina.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Gasolinapdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Tipo de Gasolina"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Tipo_Gasolinaexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Gasolinaexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Tipo_Gasolina.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Gasolinaexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME,"C:\\CarSoft-Version-2.1\\Reportes\\reporteGasolina.xlsx");
            

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteGasolina.xlsx");
        p.start();
}public void Reporte_Numero_Asientospdf() throws ClassNotFoundException, IOException, SQLException, JRException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Numero_Asientospdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Numero_Asientos.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Numero_Asientospdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Tipo de Numero de Asientos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Numero_Asientosexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Numero_Asientosexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Numero_Asientos.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Numero_Asientosexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteAsientos.xlsx");
          

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteAsientos.xlsx");
        p.start();
}public void Reporte_Tipo_Transmisionpdf() throws ClassNotFoundException, IOException, SQLException, JRException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Transmisionpdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Transmision.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Transmisionpdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Tipo de Transmision"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Tipo_Transmisionexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Tipo_Transmisionexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Transmision.jrxml.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Tipo_Transmisionexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteTransmision.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteTransmision.xlsx");
        p.start();
}public void Reporte_Vehiculopdf() throws ClassNotFoundException, IOException, SQLException, JRException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Vehiculopdf = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Vehiculos.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Vehiculopdf, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Vehiculo"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
      }public void Reporte_Vehiculoexcel() throws ClassNotFoundException, SQLException, JRException, IOException{
    Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporte_Vehiculoexcel = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Vehiculos.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporte_Vehiculoexcel, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteVehiculos.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteVehiculos.xlsx");
        p.start();
}
    private void createTableBusqueda(){
        if(!chkMarca.isSelected()&& !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected() && !chkColor.isSelected()){
            JOptionPane.showMessageDialog(null,"No ha Marcado ningún Checkbox","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(chkMarca.isSelected()&& cmbMarcaBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ninguna Marca","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(chkTipoGasolina.isSelected()&& cmbGasolinaBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Tipo de Gasolina","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(chkTipoVehiculo.isSelected()&& cmbTipoVehiculoBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Tipo de Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(chkColor.isSelected()&& cmbColorBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Color","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        DefaultTableModel modelo = (DefaultTableModel) tbBusqueda.getModel();
        tbBusqueda.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID");
        
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Color");
        modelo.addColumn("Combustible");
        modelo.addColumn("Tipo de vehiculo");
        modelo.addColumn("Numero de asientos");
        modelo.addColumn("Precio");*/
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        
       


        

        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        List<HistoricoPrecioVehiculos> temp2 = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        Double aux = 0.0;
        if(chkMarca.isSelected() && !chkColor.isSelected() && !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                 ,(e.isEstado())? "Activo":"Inactivo"
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() && !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                           ,(e.isEstado())? "Activo":"Inactivo"
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() && chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                ,(e.isEstado())? "Activo":"Inactivo"         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() && !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                       ,(e.isEstado())? "Activo":"Inactivo"                 
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                             ,(e.isEstado())? "Activo":"Inactivo"
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                             ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                        ,(e.isEstado())? "Activo":"Inactivo"              
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                                    ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                             ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                       ,(e.isEstado())? "Activo":"Inactivo"             
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex()) &&  e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                             ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                             ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                             ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==cmbTipoVehiculoBusqueda.getSelectedIndex() && e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                             ,(e.isEstado())? "Activo":"Inactivo"
                        });
                        }
                    }
                }
            }
        }
        
        
    }
public boolean BuscarVehiculosTest(){
    if(!chkMarca.isSelected()&& !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected() && !chkColor.isSelected()){
            JOptionPane.showMessageDialog(null,"No ha Marcado ningún Checkbox","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(chkMarca.isSelected()&& cmbMarcaBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ninguna Marca","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(chkTipoGasolina.isSelected()&& cmbGasolinaBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Tipo de Gasolina","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(chkTipoVehiculo.isSelected()&& cmbTipoVehiculoBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Tipo de Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(chkColor.isSelected()&& cmbColorBusqueda.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningún Color","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        DefaultTableModel modelo = (DefaultTableModel) tbBusqueda.getModel();
        tbBusqueda.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID");
        
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Color");
        modelo.addColumn("Combustible");
        modelo.addColumn("Tipo de vehiculo");
        modelo.addColumn("Numero de asientos");
        modelo.addColumn("Precio");*/
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        
       


        

        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        List<HistoricoPrecioVehiculos> temp2 = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        Double aux = 0.0;
        if(chkMarca.isSelected() && !chkColor.isSelected() && !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() && !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() && chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() && !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex()) &&  e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==cmbTipoVehiculoBusqueda.getSelectedIndex() && e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                String.format("%,.2f",aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        return true;
}    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnAgregar5;
    private javax.swing.JButton btnAgregar6;
    private javax.swing.JButton btnAgregar7;
    private javax.swing.JButton btnAgregar8;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesactivar1;
    private javax.swing.JButton btnDesactivar2;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnDesactivar4;
    private javax.swing.JButton btnDesactivar5;
    private javax.swing.JButton btnDesactivar6;
    private javax.swing.JButton btnDesactivar7;
    private javax.swing.JButton btnDesactivar8;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnLimpiar4;
    private javax.swing.JButton btnLimpiar5;
    private javax.swing.JButton btnLimpiar6;
    private javax.swing.JButton btnLimpiar7;
    private javax.swing.JButton btnLimpiar8;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnModificar4;
    private javax.swing.JButton btnModificar5;
    private javax.swing.JButton btnModificar6;
    private javax.swing.JButton btnModificar7;
    private javax.swing.JButton btnModificar8;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnRegresar10;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnRegresar3;
    private javax.swing.JButton btnRegresar4;
    private javax.swing.JButton btnRegresar5;
    private javax.swing.JButton btnRegresar6;
    private javax.swing.JButton btnRegresar7;
    private javax.swing.JButton btnRegresar8;
    private javax.swing.JButton btnRegresar9;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir10;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JButton btnSalir4;
    private javax.swing.JButton btnSalir5;
    private javax.swing.JButton btnSalir6;
    private javax.swing.JButton btnSalir7;
    private javax.swing.JButton btnSalir8;
    private javax.swing.JButton btnSalir9;
    private javax.swing.JCheckBox chkColor;
    public javax.swing.JCheckBox chkMarca;
    private javax.swing.JCheckBox chkTipoGasolina;
    private javax.swing.JCheckBox chkTipoVehiculo;
    public javax.swing.JComboBox<String> cmbCabinaVehiculo;
    private javax.swing.JComboBox<String> cmbColorBusqueda;
    public javax.swing.JComboBox<String> cmbColorVehiculo;
    private javax.swing.JComboBox<String> cmbGasolinaBusqueda;
    public javax.swing.JComboBox<String> cmbGasolinaVehiculo;
    public javax.swing.JComboBox<String> cmbIDColor;
    public javax.swing.JComboBox<String> cmbIDMarca;
    public javax.swing.JComboBox<String> cmbIDNumeroAsientos;
    public javax.swing.JComboBox<String> cmbIDTipoGasolina;
    public javax.swing.JComboBox<String> cmbIDTipoTransmision;
    public javax.swing.JComboBox<String> cmbIDTipoVehiculo;
    public javax.swing.JComboBox<String> cmbIDVehiculo;
    public javax.swing.JComboBox<String> cmbMarcaBusqueda;
    public javax.swing.JComboBox<String> cmbMarcaVehiculo;
    public javax.swing.JComboBox<String> cmbNumAsientos;
    public javax.swing.JComboBox<String> cmbPiezaClave;
    private javax.swing.JComboBox<String> cmbPrecioHistorico;
    private javax.swing.JComboBox<String> cmbTipoVehiculoBusqueda;
    public javax.swing.JComboBox<String> cmbTipoVehiculoVehiculo;
    public javax.swing.JComboBox<String> cmbTransmisionVehiculo;
    public javax.swing.JFormattedTextField ftxtStock;
    public javax.swing.JFormattedTextField ftxtStockMaximo;
    public javax.swing.JFormattedTextField ftxtStockMinimo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTbHistorialPrecio;
    public javax.swing.JLabel labelempleado;
    private javax.swing.JTable tbAgregarVehiculo;
    private javax.swing.JTable tbBusqueda;
    private javax.swing.JTable tblColor;
    private javax.swing.JTable tblMarca;
    private javax.swing.JTable tblNumeroAsientos;
    private javax.swing.JTable tblTipoCabina;
    private javax.swing.JTable tblTipoGasolina;
    private javax.swing.JTable tblTipoTransmision;
    private javax.swing.JTable tblTipoVehiculo;
    public javax.swing.JTextField txtCilindraje;
    public javax.swing.JTextField txtColor;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtNumeroAsientos;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtTipoCabina;
    public javax.swing.JTextField txtTipoGasolina;
    public javax.swing.JTextField txtTipoTransmision;
    public javax.swing.JTextField txtTipoVehiculo;
    public javax.swing.JTextField txtVin;
    // End of variables declaration//GEN-END:variables

}
