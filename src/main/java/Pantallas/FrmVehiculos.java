/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Acceso;
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
    
    public FrmVehiculos(Acceso a) {
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
            
            
            try{
            
            btnAgregar1.setVisible(a.getPermisoSeccionMarcaAgregar());
            btnModificar1.setVisible(a.getPermisoSeccionMarcaModificar());
            btnDesactivar1.setVisible(a.getPermisoSeccionMarcaDesactivar());
            jButton1.setVisible(a.getPermisoSeccionMarcaReportePdf());
            jButton2.setVisible(a.getPermisoSeccionMarcaReporteExcel());
            
            btnAgregar2.setVisible(a.getPermisoSeccionColorAgregar());
            btnModificar2.setVisible(a.getPermisoSeccionColorModificar());
            btnDesactivar2.setVisible(a.getPermisoSeccionColorDesactivar());
            jButton3.setVisible(a.getPermisoSeccionColorReportePdf());
            jButton4.setVisible(a.getPermisoSeccionColorReporteExcel());
            
            btnAgregar3.setVisible(a.getPermisoSeccionTipoVehiculoAgregar());
            btnModificar3.setVisible(a.getPermisoSeccionTipoVehiculoModificar());
            btnDesactivar3.setVisible(a.getPermisoSeccionTipoVehiculoDesactivar());
            jButton5.setVisible(a.getPermisoSeccionTipoVehiculoReportePdf());
            jButton6.setVisible(a.getPermisoSeccionTipoVehiculoReporteExcel());
          
            btnAgregar4.setVisible(a.getPermisoSeccionTipoCabinaAgregar());
            btnModificar4.setVisible(a.getPermisoSeccionTipoCabinaModificar());
            btnDesactivar4.setVisible(a.getPermisoSeccionTipoCabinaDesactivar());
            jButton7.setVisible(a.getPermisoSeccionTipoCabinaReportePdf());
            jButton8.setVisible(a.getPermisoSeccionTipoCabinaReporteExcel());
            
             btnAgregar5.setVisible(a.getPermisoSeccionTipoCombustibleAgregar());
            btnModificar5.setVisible(a.getPermisoSeccionTipoCombustibleModificar());
            btnDesactivar5.setVisible(a.getPermisoSeccionTipoCombustibleDesactivar());
            jButton9.setVisible(a.getPermisoSeccionTipoCombustibleReportePdf());
            jButton10.setVisible(a.getPermisoSeccionTipoCombustibleReporteExcel());

             btnAgregar6.setVisible(a.getPermisoSeccionTipoTransmisionAgregar());
            btnModificar6.setVisible(a.getPermisoSeccionTipoTransmisionModificar());
            btnDesactivar6.setVisible(a.getPermisoSeccionTipoTransmisionDesactivar());
            jButton13.setVisible(a.getPermisoSeccionTipoTransmisionReportePdf());
            jButton14.setVisible(a.getPermisoSeccionTipoTransmisionReporteExcel());
            
            btnAgregar7.setVisible(a.getPermisoSeccionVehiculosAgregar());
            btnModificar7.setVisible(a.getPermisoSeccionVehiculosModificar());
            btnDesactivar7.setVisible(a.getPermisoSeccionVehiculosDesactivar());
            jButton15.setVisible(a.getPermisoSeccionVehiculosReportePdf());
            jButton16.setVisible(a.getPermisoSeccionVehiculosReporteExcel());
            
            btnAgregar8.setVisible(a.getPermisoSeccionNumeroAsientosAgregar());
            btnModificar8.setVisible(a.getPermisoSeccionNumeroAsientosModificar());
            btnDesactivar8.setVisible(a.getPermisoSeccionNumeroAsientosDesactivar());
            jButton11.setVisible(a.getPermisoSeccionNumeroAsientosReportePdf());
            jButton12.setVisible(a.getPermisoSeccionNumeroAsientosReporteExcel());
            
            jButton17.setVisible(a.getPermisoSeccionBuscarVehiculoReportePdf());
            jButton18.setVisible(a.getPermisoSeccionBuscarVehiculoExcel());
            btnBuscar.setVisible(a.getPermisoSeccionBuscarVehiculoBuscar());
            
            jButton19.setVisible(a.getPermisoSeccionHistorialPreciosVehiculoReportePdf());
            jButton20.setVisible(a.getPermisoSeccionHistorialPreciosVehiculoReporteExcel());
            cmbPrecioHistorico.setVisible(a.getPermisoSeccionHistorialPreciosVehiculoBuscar());
            
            //Codigo de usuario
        }catch(Exception e){
            //Acceso desde el root
        }
            
            
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

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chkMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMarcaItemStateChanged(evt);
            }
        });
        jPanel2.add(chkMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 68, -1, 28));

        chkColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkColorItemStateChanged(evt);
            }
        });
        jPanel2.add(chkColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 114, -1, 28));

        chkTipoVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTipoVehiculoItemStateChanged(evt);
            }
        });
        jPanel2.add(chkTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, 28));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Marca:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 74, 102, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Color:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 120, 102, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Tipo de Vehículo:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 176, 102, -1));

        cmbMarcaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Chevrolet", "Honda" }));
        cmbMarcaBusqueda.setEnabled(false);
        jPanel2.add(cmbMarcaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 68, 102, 28));

        cmbColorBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negro", "Rojo", "Azul", " " }));
        cmbColorBusqueda.setEnabled(false);
        jPanel2.add(cmbColorBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 114, 102, 28));

        cmbTipoVehiculoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deportivo", "Comercial", " " }));
        cmbTipoVehiculoBusqueda.setEnabled(false);
        jPanel2.add(cmbTipoVehiculoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 102, 28));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Tipo de Gasolina:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 74, 137, -1));

        cmbGasolinaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diesel", " " }));
        cmbGasolinaBusqueda.setEnabled(false);
        jPanel2.add(cmbGasolinaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 68, 113, 28));

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
        jPanel2.add(chkTipoGasolina, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 68, -1, 28));

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

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 278, 1270, 184));

        btnRegresar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar8.setText("Regresar");
        btnRegresar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar8ActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 598, -1, -1));

        btnSalir8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir8.setText("Salir");
        btnSalir8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir8ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, -1, -1));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Búsqueda por Filtro");
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, 35));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 114, 113, 39));

        labelempleado.setText("jLabel1");
        jPanel2.add(labelempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 400, -1, -1));

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton19.setText("Generar Reporte PDF");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 480, -1, -1));

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton20.setText("Generar Reporte Excel");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 480, -1, -1));

        jTabbedPane1.addTab("Búsqueda por filtro", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbIDMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDMarcaItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbIDMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 99, 91, 25));

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("ID Marca:");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 98, 92, 23));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Nueva marca:");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 139, 92, 23));

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });
        jPanel3.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 140, 212, 25));

        btnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar1.setText("Agregar");
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 196, -1, -1));

        btnModificar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar1.setText("Modificar");
        btnModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 193, -1, -1));

        btnLimpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 193, -1, 41));

        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar1.setText("Desactivar");
        btnDesactivar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnDesactivar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 194, -1, -1));

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

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 275, 842, 203));

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 605, -1, -1));

        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1241, 0, -1, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Nueva Marca");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 11, -1, 35));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton1.setText("Generar Reporte PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 515, -1, 43));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton2.setText("Generar Reporte Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 515, -1, 43));

        jTabbedPane1.addTab("Marca", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbIDColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDColorItemStateChanged(evt);
            }
        });
        jPanel4.add(cmbIDColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 119, 93, -1));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("ID Color");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 119, 74, 23));

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Nuevo Color:");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 160, -1, 23));

        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });
        jPanel4.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 160, 212, -1));

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 224, -1, -1));

        btnModificar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 221, -1, -1));

        btnLimpiar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnLimpiar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 221, -1, 41));

        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar2.setText("Desactivar");
        btnDesactivar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnDesactivar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 222, -1, -1));

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

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 307, 767, 203));

        btnRegresar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setText("Regresar");
        btnRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1185, 595, -1, -1));

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1245, 13, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Nuevo Color");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 0, -1, 35));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton3.setText("Generar Reporte PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 528, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton4.setText("Generar Reporte Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 528, -1, -1));

        jTabbedPane1.addTab("Color", jPanel4);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbIDTipoVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoVehiculoItemStateChanged(evt);
            }
        });
        jPanel6.add(cmbIDTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 106, 93, -1));

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("ID Tipo de Vehículo:");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 106, 131, 23));

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Nuevo Tiipo de Vehículo:");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 147, 131, 23));

        txtTipoVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoVehiculoKeyTyped(evt);
            }
        });
        jPanel6.add(txtTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 147, 200, -1));

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar3.setText("Agregar");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 208, -1, -1));

        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 205, -1, -1));

        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnLimpiar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 205, -1, 41));

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnDesactivar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 206, -1, -1));

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

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 287, 898, 203));

        btnRegresar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar3.setText("Regresar");
        btnRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnRegresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1197, 600, -1, -1));

        btnSalir3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir3.setText("Salir");
        btnSalir3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1257, 15, -1, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Nuevo de Tipo de Vehículo");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 13, -1, 35));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton5.setText("Generar Reporte PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 532, -1, 43));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton6.setText("Generar Reporte Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 532, -1, 43));

        jTabbedPane1.addTab("Tipo de Vehículo", jPanel6);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("ID Tipo de Cabina:");
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 118, 130, 23));

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Nuevo Tipo de Cabina:");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 159, -1, 23));

        txtTipoCabina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoCabinaKeyTyped(evt);
            }
        });
        jPanel7.add(txtTipoCabina, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 159, 203, -1));

        btnAgregar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar4.setText("Agregar");
        btnAgregar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });
        jPanel7.add(btnAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 203, -1, -1));

        btnModificar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar4.setText("Modificar");
        btnModificar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar4ActionPerformed(evt);
            }
        });
        jPanel7.add(btnModificar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 200, -1, -1));

        btnLimpiar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar4.setText("Limpiar");
        btnLimpiar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar4ActionPerformed(evt);
            }
        });
        jPanel7.add(btnLimpiar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 200, -1, 41));

        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar4.setText("Desactivar");
        btnDesactivar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar4ActionPerformed(evt);
            }
        });
        jPanel7.add(btnDesactivar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 201, -1, -1));

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

        jPanel7.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 282, 840, 203));

        btnRegresar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar4.setText("Regresar");
        btnRegresar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar4ActionPerformed(evt);
            }
        });
        jPanel7.add(btnRegresar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1169, 600, -1, -1));

        btnSalir4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir4.setText("Salir");
        btnSalir4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });
        jPanel7.add(btnSalir4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1229, 0, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Nuevo Tipo de Cabina");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 13, -1, 35));

        cmbPiezaClave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(cmbPiezaClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 118, 136, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton7.setText("Generar Reporte PDF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 524, -1, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton8.setText("Generar Reporte Excel");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 524, -1, -1));

        jTabbedPane1.addTab("Tipo de Cabina", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbIDTipoGasolina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoGasolinaItemStateChanged(evt);
            }
        });
        jPanel8.add(cmbIDTipoGasolina, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 110, 93, -1));

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("ID Tipo de Combustible:");
        jPanel8.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 110, -1, 23));

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Tipo de Combustible:");
        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 151, 138, 23));

        txtTipoGasolina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoGasolinaKeyTyped(evt);
            }
        });
        jPanel8.add(txtTipoGasolina, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 151, 193, -1));

        btnAgregar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar5.setText("Agregar");
        btnAgregar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });
        jPanel8.add(btnAgregar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 206, -1, -1));

        btnModificar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar5.setText("Modificar");
        btnModificar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar5ActionPerformed(evt);
            }
        });
        jPanel8.add(btnModificar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 203, -1, -1));

        btnLimpiar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar5.setText("Limpiar");
        btnLimpiar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar5ActionPerformed(evt);
            }
        });
        jPanel8.add(btnLimpiar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 203, -1, 41));

        btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar5.setText("Desactivar");
        btnDesactivar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar5ActionPerformed(evt);
            }
        });
        jPanel8.add(btnDesactivar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 204, -1, -1));

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

        jPanel8.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 280, 864, 203));

        btnRegresar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar5.setText("Regresar");
        btnRegresar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar5ActionPerformed(evt);
            }
        });
        jPanel8.add(btnRegresar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1211, 589, -1, -1));

        btnSalir5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });
        jPanel8.add(btnSalir5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1271, 13, -1, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Nuevo Tipo de Combustible");
        jPanel8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 19, -1, 35));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton9.setText("Generar Reporte PDF");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 524, -1, 43));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton10.setText("Generar Reporte Excel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 524, -1, 43));

        jTabbedPane1.addTab("Tipo de Combustible", jPanel8);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("ID Número de Asientos:");
        jPanel9.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 107, 153, 23));

        cmbIDNumeroAsientos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDNumeroAsientosItemStateChanged(evt);
            }
        });
        jPanel9.add(cmbIDNumeroAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 107, 91, -1));

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Nuevo Número de Asientos:");
        jPanel9.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 148, 153, 23));

        txtNumeroAsientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroAsientosKeyTyped(evt);
            }
        });
        jPanel9.add(txtNumeroAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 148, 172, -1));

        btnAgregar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar8.setText("Agregar");
        btnAgregar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar8ActionPerformed(evt);
            }
        });
        jPanel9.add(btnAgregar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 205, -1, -1));

        btnModificar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar8.setText("Modificar");
        btnModificar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar8ActionPerformed(evt);
            }
        });
        jPanel9.add(btnModificar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 205, -1, -1));

        btnLimpiar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar8.setText("Limpiar");
        btnLimpiar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar8ActionPerformed(evt);
            }
        });
        jPanel9.add(btnLimpiar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 205, -1, 41));

        btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar8.setText("Desactivar");
        btnDesactivar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar8ActionPerformed(evt);
            }
        });
        jPanel9.add(btnDesactivar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 206, -1, -1));

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

        jPanel9.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 284, 828, 203));

        btnSalir9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir9.setText("Salir");
        btnSalir9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir9ActionPerformed(evt);
            }
        });
        jPanel9.add(btnSalir9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1251, 13, -1, -1));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Nuevo Número de Asientos");
        jPanel9.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 19, -1, 35));

        btnRegresar9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar9.setText("Regresar");
        btnRegresar9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar9ActionPerformed(evt);
            }
        });
        jPanel9.add(btnRegresar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1191, 599, -1, -1));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton11.setText("Generar Reporte PDF");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 528, -1, 43));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton12.setText("Generar Reporte Excel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 529, -1, -1));

        jTabbedPane1.addTab("Número de Asientos", jPanel9);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbIDTipoTransmision.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoTransmisionItemStateChanged(evt);
            }
        });
        jPanel5.add(cmbIDTipoTransmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 108, 93, -1));

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("ID Tipo de Transmisión:");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 108, 132, 23));

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Tipo de Transmisión:");
        jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 138, 132, 23));

        txtTipoTransmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoTransmisionKeyTyped(evt);
            }
        });
        jPanel5.add(txtTipoTransmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 138, 177, -1));

        btnAgregar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar6.setText("Agregar");
        btnAgregar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar6ActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 182, -1, -1));

        btnModificar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar6.setText("Modificar");
        btnModificar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar6ActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 179, -1, -1));

        btnLimpiar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar6.setText("Limpiar");
        btnLimpiar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar6ActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 179, -1, 41));

        btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar6.setText("Desactivar");
        btnDesactivar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar6ActionPerformed(evt);
            }
        });
        jPanel5.add(btnDesactivar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 180, -1, -1));

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

        jPanel5.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 261, 780, 203));

        btnRegresar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar6.setText("Regresar");
        btnRegresar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar6ActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegresar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1194, 617, -1, -1));

        btnSalir6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir6.setText("Salir");
        btnSalir6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir6ActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1254, 13, -1, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Nuevo Tipo de Transmisión");
        jPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 19, -1, 35));

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton13.setText("Generar Reporte PDF");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 490, -1, -1));

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton14.setText("Generar Reporte Excel");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 490, -1, -1));

        jTabbedPane1.addTab("Tipo de Transmisión", jPanel5);

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Vehículo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 86, 107, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Modelo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 148, 107, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 117, 107, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Color");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 179, 107, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de Vehículo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 179, 107, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tipo de Combustible:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 241, 107, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Número Asientos:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 83, 148, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tipo de Cabina:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 117, 148, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tipo de Transmisión:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 148, 144, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cantidad de cilindraje:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 179, 142, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 117, 117, -1));

        jPanel1.add(cmbColorVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 173, 139, 28));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 344, 1295, 183));

        jPanel1.add(cmbMarcaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 111, 139, 28));

        jPanel1.add(cmbTipoVehiculoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 173, 149, 28));

        jPanel1.add(cmbCabinaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 111, 147, 28));

        jPanel1.add(cmbTransmisionVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 142, 147, 28));

        jPanel1.add(cmbGasolinaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 235, 139, 28));

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
        jPanel1.add(txtVin, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 142, 139, 28));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Lps.");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 117, 50, -1));

        btnLimpiar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar7.setText("Limpiar");
        btnLimpiar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 285, -1, 41));

        btnDesactivar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar7.setText("Desactivar");
        btnDesactivar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesactivar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 286, -1, -1));

        btnModificar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar7.setText("Modificar");
        btnModificar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 285, -1, -1));

        btnAgregar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar7.setText("Agregar");
        btnAgregar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 285, -1, -1));

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
        jPanel1.add(cmbIDVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 80, 91, 28));

        txtCilindraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCilindrajeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCilindrajeKeyTyped(evt);
            }
        });
        jPanel1.add(txtCilindraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 173, 147, 28));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Stock:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 148, 117, -1));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Stock Mínimo:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 241, 144, -1));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Stock Máximo:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 86, 117, -1));

        btnSalir7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir7.setText("Salir");
        btnSalir7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, -1, -1));

        btnRegresar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar7.setText("Regresar");
        btnRegresar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 616, -1, -1));

        jLabel45.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Vehículos");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, 35));

        jPanel1.add(cmbNumAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 80, 147, 28));

        ftxtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftxtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtStockKeyTyped(evt);
            }
        });
        jPanel1.add(ftxtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 142, 147, 28));

        ftxtStockMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftxtStockMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtStockMinimoKeyTyped(evt);
            }
        });
        jPanel1.add(ftxtStockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 235, 147, 28));

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
        jPanel1.add(ftxtStockMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 80, 158, 28));

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 111, 158, 28));

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton15.setText("Generar Reporte PDF");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 558, -1, -1));

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton16.setText("Generar Reporte Excel");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 558, -1, -1));

        jTabbedPane1.addTab("Vehículos", jPanel1);

        jPanel10.setBackground(new java.awt.Color(0, 75, 143));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir10.setText("Salir");
        btnSalir10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir10ActionPerformed(evt);
            }
        });
        jPanel10.add(btnSalir10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1256, 10, -1, -1));

        btnRegresar10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar10.setText("Regresar");
        btnRegresar10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar10ActionPerformed(evt);
            }
        });
        jPanel10.add(btnRegresar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 595, -1, -1));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Precio Historico de Vehículos");
        jPanel10.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 8, -1, 35));

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton17.setText("Generar Reporte PDF");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 377, -1, -1));

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton18.setText("Generar Reporte Excel");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 377, -1, -1));

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

        jPanel10.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 160, 1270, 187));

        cmbPrecioHistorico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPrecioHistoricoItemStateChanged(evt);
            }
        });
        jPanel10.add(cmbPrecioHistorico, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 88, 223, 30));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Vehiculo:");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 88, 102, 30));

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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculoReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            Reporte_Vehiculopdf();
        } catch (ClassNotFoundException | IOException | SQLException | JRException e) {
            
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculoReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
        try{
        AgregarVehiculos();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculoAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar7ActionPerformed

    private void btnModificar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar7ActionPerformed
        try{
            ModificarVehiculo();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculoModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar7ActionPerformed

    private void btnDesactivar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar7ActionPerformed
        try{
            DesactivarVehiculo();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculoDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDesactivar7ActionPerformed

    private void btnLimpiar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar7ActionPerformed
        try{
        limpiar();
        btnModificar7.setEnabled(false);
        btnAgregar7.setEnabled(true);
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculoLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TransmisionReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            Reporte_Tipo_Transmisionpdf();
        } catch (ClassNotFoundException | IOException | SQLException | JRException e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TransmisionReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        try{
        DesactivarTransmision();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TransmisionDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDesactivar6ActionPerformed

    private void btnLimpiar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar6ActionPerformed
        try{
        LimpiarNuevoTipoTransmision();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TransmisionLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLimpiar6ActionPerformed

    private void btnModificar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar6ActionPerformed
        try{
        ModificarTransmision();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TransmisionModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar6ActionPerformed

    private void btnAgregar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar6ActionPerformed
        try{
            AgregarTransmision();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TransmisionAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"AsientosReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            Reporte_Numero_Asientospdf();
        } catch (ClassNotFoundException | IOException | SQLException | JRException e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"AsientosReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        try{
        DesactivarNumeroAsientos();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"AsientosDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDesactivar8ActionPerformed

    private void btnLimpiar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar8ActionPerformed
        //  cmbIDNumeroAsientos.setSelectedIndex(1);
        try{
        LimpiarNuevoNumeroAsientos();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"AsientosLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnLimpiar8ActionPerformed

    private void btnModificar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar8ActionPerformed

        try{
        ModificarNumeroAsientos();
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
               fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"AsientosModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar8ActionPerformed

    private void btnAgregar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar8ActionPerformed
        try{
        AgregarNumeroAsientos();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"AsientosAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CombustibleReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            Reporte_Tipo_Gasolinapdf();
        } catch (ClassNotFoundException | IOException | JRException | SQLException e) {
            
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CombustibleReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        try{
        DesactivarTipoCombustible();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CombustibleDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDesactivar5ActionPerformed

    private void btnLimpiar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar5ActionPerformed
        try{
        LimpiarNuevoTipoGasolina();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CombustibleLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLimpiar5ActionPerformed

    private void btnModificar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar5ActionPerformed

        try{
        ModificarTipoCombustible();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CombustibleModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar5ActionPerformed

    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed
        try{
        AgregarTipoCombustible();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CombustibleAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoCabinaReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            Reporte_Tipo_Cabinapdf();
        } catch (ClassNotFoundException | IOException | SQLException | JRException e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoCabinaReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        try{
            DesactivarTipoCabina();
            
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoCabinaDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDesactivar4ActionPerformed

    private void btnLimpiar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar4ActionPerformed
        // cmbIDTipoCabina.setSelectedIndex(1);
        try{
        LimpiarNuevoTipoCabina();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoCabinaLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnLimpiar4ActionPerformed

    private void btnModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar4ActionPerformed
        try{
        ModificarTipoCabina();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoCabinaModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar4ActionPerformed

    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed

        try{
        AgregarTipoCabina();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoCabinaAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoVehiculoReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Reporte_Tipo_Vehiculopdf();
        } catch (ClassNotFoundException | IOException | JRException | SQLException e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoVehiculoReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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
       try{
        DesactivarTipoVehiculo();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoVehiculoDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        try{
        LimpiarNuevoTipoVehiculo();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoVehiculoLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        
        try {
            ModificarTipoVehiculo();
        } catch (Exception e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoVehiculoModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed

        try{
        AgregarTipoVehiculo();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoVehiculoAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh;
                fh = new FileHandler("./"+"ColorReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
             } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Reporte_Colorpdf();
        } catch (ClassNotFoundException | IOException | SQLException | JRException e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"ColorReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        try{
        DesactivarColor();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"ColorDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDesactivar2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        try{
        LimpiarNuevoColor();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"ColorLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        try{
        ModificarColor();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"ColorModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed

        try{
        AgregarColor();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"ColorAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"MarcaReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Reporte_Marcapdf();
        } catch (ClassNotFoundException | IOException | SQLException | JRException e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"MarcaReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        try{
        DesactivarMarca();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"MarcaDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDesactivar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        try{
        //cmbIDMarca.setSelectedIndex(1);
        LimpiarMarca();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"MarcaLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        try{
        ModificarMarca();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"MarcaModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        try{
        AgregarMarca();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"MarcaAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        try{
        createTableBusqueda();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculosBuscarVehiculo"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
        
        
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        
        JasperReport reporte = null;
        
            reporte = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Historico_Precio_Vehiculo.jrxml");
        
        HashMap param = new HashMap();
        param.put("Empleado", labelempleado.getText());
        JasperPrint print = null;
        
            print = JasperFillManager.fillReport(reporte, param,con);
            //JasperViewer.viewReport(print);
        
            net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPrecioVehiculos.xlsx");

        
            exporter.exportReport();
        
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPrecioVehiculos.xlsx");
        
        
            p.start();
        }catch (Exception e) {
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"HistorialPrecioVehiculoReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        try{   
        
            Class.forName("com.mysql.jdbc.Driver");
        
        
           
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = null;
        
            reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_Historico_Precio_Vehiculo.jrxml");
        
        HashMap param = new HashMap();
         param.put("Empleado", labelempleado.getText());

         JasperPrint print= null;
        
                print = JasperFillManager.fillReport(reporteFactura, param,con);
                //JasperViewer.viewReport(print);
        
        
        File pdf = null;
       
            pdf = File.createTempFile("Reporte Historico Precios Vehículos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        
            p.start();
        
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"HistorialPrecioVehiculoReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        try{
        if(tbBusqueda.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No hay ningún Vehículo en la tabla","Error!",0);
            return;
        }
        else{
            
        }

            
            Class.forName("com.mysql.jdbc.Driver");
        
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        
        JasperReport reporteFactura = null;
        
            reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Reporte_BuscarVehiculos.jrxml");
        
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
        
                print = JasperFillManager.fillReport(reporteFactura, param,con);
                //JasperViewer.viewReport(print);
        
        
        File pdf = null;
        
            pdf = File.createTempFile("Reporte Buscar Vehiculos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        
        
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        
            p.start();
        
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculosBuscarReportePDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
   try {
            ReporteBuscarVehiculos();
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
                fecha1 = aux1+""+aux2+""+aux3+"-"+fecha.get(Calendar.HOUR_OF_DAY)+""+fecha.get(Calendar.MINUTE)+""+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmVehiculos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VehiculosBuscarReporteExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
    public boolean AgregarMarca() throws Exception{
    
        
        
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
                
                Marcadao.create(m);
                
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
public boolean ModificarMarca() throws Exception{
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
                    
                        Marcadao.edit(m);
                    
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
}public boolean DesactivarMarca() throws Exception{
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
        
            Marcadao.edit(temp);
        
        createTableMarca();
        btnActivarDesactivarMarca();
        LimpiarMarca();
        btnDesactivar1.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        return true;
}public boolean AgregarColor() throws Exception{
    
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
                
                Colorrdao.create(cc);
                
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
}public boolean ModificarColor() throws Exception{
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
                    
                        Colorrdao.edit(cc);
                    
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
}public boolean DesactivarColor() throws Exception{
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
        
         Colorrdao.edit(temp);
        
        createTableColor();
        btnActivarDesactivarColor();
        LimpiarNuevoColor();
        btnDesactivar2.setEnabled(false);
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
        return true;
}public boolean AgregarTipoVehiculo() throws Exception{
    
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
                
                    TipoVehiculodao.create(tp);
                
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
}public boolean ModificarTipoVehiculo() throws Exception{
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
                    
                       TipoVehiculodao.edit(tp);
                    
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
}public boolean DesactivarTipoVehiculo() throws Exception{
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
       
         TipoVehiculodao.edit(temp);
        
        createTableTipoVehiculo();
        btnActivarDesactivarTipoVehiculo();
        LimpiarNuevoTipoVehiculo();
        btnDesactivar3.setEnabled(false);
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        return true;
}public boolean AgregarTipoCabina() throws Exception{
    
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
               
                TipoCabinadao.create(tp);
                
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
}public boolean ModificarTipoCabina() throws Exception{
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
                   
                    TipoCabinadao.edit(tp);
                   
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
}public boolean DesactivarTipoCabina() throws Exception{
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
        
        TipoCabinadao.edit(temp);
        
        createTableTipoCabina();
        btnActivarDesactivarTipoCabina();
        LimpiarNuevoTipoCabina();
        return true;
}public boolean AgregarTipoCombustible() throws Exception{
    
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
                
                TipoGasolinadao.create(tp);
                
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
}public boolean ModificarTipoCombustible() throws Exception{
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
                   
                        TipoGasolinadao.edit(tp);
                    
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
}public boolean DesactivarTipoCombustible() throws Exception{
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
        
        TipoGasolinadao.edit(temp);
        
        createTableTipoGasolina();
        btnActivarDesactivarTipoGasolina();
        LimpiarNuevoTipoGasolina();
        return true;
}public boolean AgregarTransmision()throws Exception{
    
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
                
                    TipoTransmisiondao.create(tp);
                
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
}public boolean ModificarTransmision() throws Exception{
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
                    
                       TipoTransmisiondao.edit(tp);
                    
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
}public boolean DesactivarTransmision() throws Exception{
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
            TipoTransmisiondao.edit(temp);
        
        createTableTipoTransmision();
        btnActivarDesactivarTipoTransmision();
        LimpiarNuevoTipoTransmision();
        return true;
}public boolean DesactivarVehiculo()throws Exception{
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
        
            vehiculoDao.edit(temp);
       
        createTableVehiculosAgregar();
        btnActivarDesactivarVehiculo();
        limpiar();
        return true;
}public boolean ModificarVehiculo() throws Exception{
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
           
       
            vehiculoDao.edit(temp);
        
           
       
        
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
        
        
           
                historicoPrecioVehiculoDao.edit(temp2);
            
            
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
}public boolean AgregarVehiculos()throws Exception{
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
           
        
            vehiculoDao.create(temp);
        
           
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
    }  public boolean AgregarNumeroAsientos() throws Exception{
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
                
                    NumeroAsientosdao.create(tp);
                
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
}public boolean ModificarNumeroAsientos()throws Exception{
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
                   
                    NumeroAsientosdao.edit(tp);
                    
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
}public boolean DesactivarNumeroAsientos()throws Exception{
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
        
        NumeroAsientosdao.edit(temp);
        
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
