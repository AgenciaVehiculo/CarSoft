/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Acceso;
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
import Clases.Usuarios;
import Clases.Validaciones;
import Clases.VehiculoFactura;
import Clases.informacionFiscal;
import FormModales.ModalBanco;
import FormModales.ModalCliente;
import FormModales.ModalEmpleado;
import FormModales.ModalUsuario;
import JPAController.AccesoJpaController;
import JPAController.BancoJpaController;
import JPAController.ClienteJpaController;
import JPAController.Detalle_Banco_ClienteJpaController;
import JPAController.PersonaJpaController;
import JPAController.Tipo_DocumentoJpaController;
import JPAController.UsuariosJpaController;
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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
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
public final class FrmSeguridad1 extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("CarSoft");
    BancoJpaController BancoDao = new BancoJpaController(emf);
    ClienteJpaController ClienteDao = new ClienteJpaController(emf);
    PersonaJpaController PersonaDao = new PersonaJpaController(emf);
    
    Detalle_Banco_ClienteJpaController DetalleBancoClienteDao = new Detalle_Banco_ClienteJpaController(emf);
    Tipo_DocumentoJpaController TipoDocumentodao = new Tipo_DocumentoJpaController(emf);
    AccesoJpaController accesoDao = new AccesoJpaController(emf);
    UsuariosJpaController UsuariosDao = new UsuariosJpaController(emf);
    
    String empNomb;

    public String getEmpNomb() {
        return empNomb;
    }

    public void setEmpNomb(String empNomb) {
        this.empNomb = empNomb;
    }
    
    
    public FrmSeguridad1() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
         this.getContentPane().setBackground(new Color(0, 75, 143));
         this.jTabbedPane1.setBackground( new Color(0, 75, 143));
         this.jTabbedPane2.setBackground( new Color(0, 75, 143));
         this.jTabbedPane3.setBackground( new Color(0, 75, 143));
         this.jTabbedPane4.setBackground( new Color(0, 75, 143));
         this.jTabbedPane5.setBackground( new Color(0, 75, 143));
        Border redBorder= BorderFactory.createLineBorder(Color.BLACK, 3);
        /* this.jTabbedPane5.setBorder(redBorder);

         this.jTabbedPane4.setBorder(redBorder);
         this.jTabbedPane3.setBorder(redBorder);
         this.jTabbedPane2.setBorder(redBorder);
         this.jTabbedPane1.setBorder(redBorder);
         this.jPanel1.setBorder(redBorder);
         this.jPanel2.setBorder(redBorder);
         this.jPanel3.setBorder(redBorder);
         this.jPanel4.setBorder(redBorder);
         this.jPanel5.setBorder(redBorder);*/
        btnDesactivar.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        btnDesactivar4.setEnabled(false);
        btnDesactivar5.setEnabled(false);
        btnDesactivar6.setEnabled(false);
        btnDesactivar1.setEnabled(false);
        btnDesactivar7.setEnabled(false);
        btnDesactivar8.setEnabled(false);
        btnDesactivar9.setEnabled(false);
        btnDesactivar10.setEnabled(false);
        btnDesactivar11.setEnabled(false);
        btnDesactivar12.setEnabled(false);
        btnDesactivar13.setEnabled(false);
        btnDesactivar14.setEnabled(false);
        btnDesactivar15.setEnabled(false);
        btnDesactivar16.setEnabled(false);
        btnDesactivar17.setEnabled(false);
        btnDesactivar18.setEnabled(false);
        btnDesactivar19.setEnabled(false);
        btnDesactivar20.setEnabled(false);
        btnDesactivar21.setEnabled(false);
        btnDesactivar22.setEnabled(false);
        btnDesactivar23.setEnabled(false);
        btnDesactivar24.setEnabled(false);
        btnDesactivar25.setEnabled(false);
        btnDesactivar26.setEnabled(false);
        btnDesactivar27.setEnabled(false);
        btnDesactivar28.setEnabled(false);
        btnDesactivar29.setEnabled(false);
        btnDesactivar30.setEnabled(false);
        btnDesactivar31.setEnabled(false);
        btnDesactivar32.setEnabled(false);
        btnDesactivar33.setEnabled(false);
        btnDesactivar34.setEnabled(false);
        btnDesactivar35.setEnabled(false);
        btnDesactivar36.setEnabled(false);
        btnDesactivar37.setEnabled(false);
        btnDesactivar39.setEnabled(false);
        btnDesactivar40.setEnabled(false);
        btnDesactivar41.setEnabled(false);
        btnDesactivar42.setEnabled(false);
        btnDesactivar43.setEnabled(false);
        btnDesactivar44.setEnabled(false);
        btnDesactivar45.setEnabled(false);
        btnDesactivar46.setEnabled(false);
        btnDesactivar47.setEnabled(false);
        btnDesactivar48.setEnabled(false);
        btnDesactivar49.setEnabled(false);
        btnDesactivar50.setEnabled(false);
        btnDesactivar51.setEnabled(false);
        btnDesactivar52.setEnabled(false);
        btnDesactivar53.setEnabled(false);
        btnDesactivar54.setEnabled(false);
        btnDesactivar55.setEnabled(false);
        btnDesactivar56.setEnabled(false);
        btnDesactivar57.setEnabled(false);
        btnDesactivar58.setEnabled(false);
        btnDesactivar59.setEnabled(false);
        btnDesactivar60.setEnabled(false);
        btnDesactivar61.setEnabled(false);
        btnDesactivar62.setEnabled(false);
        btnDesactivar63.setEnabled(false);
        btnDesactivar64.setEnabled(false);
        btnDesactivar65.setEnabled(false);
        btnDesactivar66.setEnabled(false);
        btnDesactivar67.setEnabled(false);
        btnDesactivar68.setEnabled(false);
        btnDesactivar69.setEnabled(false);
        btnDesactivar70.setEnabled(false);
        btnDesactivar71.setEnabled(false);
        btnDesactivar72.setEnabled(false);
        btnDesactivar73.setEnabled(false);
        btnDesactivar74.setEnabled(false);
        btnDesactivar87.setEnabled(false);
        btnDesactivar88.setEnabled(false);
        btnDesactivar77.setEnabled(false);
        btnDesactivar78.setEnabled(false);
        btnDesactivar89.setEnabled(false);
        btnDesactivar80.setEnabled(false);
        btnDesactivar81.setEnabled(false);
        btnDesactivar82.setEnabled(false);
        btnDesactivar83.setEnabled(false);
        btnDesactivar84.setEnabled(false);
        btnDesactivar85.setEnabled(false);
        btnDesactivar86.setEnabled(false);
        btnDesactivar90.setEnabled(false);
        btnDesactivar91.setEnabled(false);
        btnDesactivar92.setEnabled(false);
        btnDesactivar93.setEnabled(false);
        btnDesactivar94.setEnabled(false);
        btnDesactivar96.setEnabled(false);
        btnDesactivar97.setEnabled(false);
        btnDesactivar102.setEnabled(false);
        btnDesactivar99.setEnabled(false);
        btnDesactivar100.setEnabled(false);
        btnDesactivar101.setEnabled(false);
        btnDesactivar103.setEnabled(false);
        btnDesactivar104.setEnabled(false);
        btnDesactivar105.setEnabled(false);
        btnDesactivar106.setEnabled(false);
        btnDesactivar107.setEnabled(false);
        btnDesactivar108.setEnabled(false);
        btnDesactivar109.setEnabled(false);
        btnDesactivar110.setEnabled(false);
        btnDesactivar111.setEnabled(false);
        btnDesactivar112.setEnabled(false);
        btnDesactivar113.setEnabled(false);
        btnDesactivar114.setEnabled(false);
        btnDesactivar115.setEnabled(false);
        btnDesactivar116.setEnabled(false);
        btnDesactivar117.setEnabled(false);
        btnDesactivar118.setEnabled(false);
        btnDesactivar119.setEnabled(false);
        btnDesactivar120.setEnabled(false);
        btnDesactivar121.setEnabled(false);
        btnDesactivar122.setEnabled(false);
        btnDesactivar123.setEnabled(false);
        btnDesactivar124.setEnabled(false);
        btnDesactivar125.setEnabled(false);
        btnDesactivar126.setEnabled(false);
        btnDesactivar127.setEnabled(false);
        btnDesactivar128.setEnabled(false);
        btnDesactivar129.setEnabled(false);
        btnDesactivar130.setEnabled(false);
        btnDesactivar131.setEnabled(false);
        btnDesactivar132.setEnabled(false);
        btnDesactivar133.setEnabled(false);
        btnDesactivar134.setEnabled(false);
        btnDesactivar135.setEnabled(false);
        btnDesactivar136.setEnabled(false);
        btnDesactivar137.setEnabled(false);
        btnDesactivar138.setEnabled(false);
        btnDesactivar139.setEnabled(false);
        btnDesactivar140.setEnabled(false);
        btnDesactivar148.setEnabled(false);
        btnDesactivar149.setEnabled(false);
        btnDesactivar150.setEnabled(false);
        btnDesactivar144.setEnabled(false);
        btnDesactivar145.setEnabled(false);
        btnDesactivar146.setEnabled(false);
        btnDesactivar147.setEnabled(false);
        btnDesactivar151.setEnabled(false);
        btnDesactivar152.setEnabled(false);
        btnDesactivar153.setEnabled(false);
        btnDesactivar154.setEnabled(false);
        btnDesactivar155.setEnabled(false);
        btnDesactivar156.setEnabled(false);
        
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.jPanel4.setBackground( new Color(0, 75, 143));
        this.jPanel5.setBackground( new Color(0, 75, 143));
        this.jPanel6.setBackground( new Color(0, 75, 143));
        this.jPanel7.setBackground( new Color(0, 75, 143));
        this.jPanel8.setBackground( new Color(0, 75, 143));
        this.jPanel9.setBackground( new Color(0, 75, 143));
        this.jPanel10.setBackground( new Color(0, 75, 143));
        jPanel11.setBackground( new Color(0, 75, 143));
        jPanel12.setBackground( new Color(0, 75, 143));
        jPanel13.setBackground( new Color(0, 75, 143));
        jPanel14.setBackground( new Color(0, 75, 143));
        jPanel15.setBackground( new Color(0, 75, 143));
        jPanel16.setBackground( new Color(0, 75, 143));
        jPanel17.setBackground( new Color(0, 75, 143));
        jPanel18.setBackground( new Color(0, 75, 143));
        jPanel19.setBackground( new Color(0, 75, 143));
        jPanel20.setBackground( new Color(0, 75, 143));
        jPanel21.setBackground( new Color(0, 75, 143));
        jPanel22.setBackground( new Color(0, 75, 143));
        jPanel23.setBackground( new Color(0, 75, 143));
        jPanel24.setBackground( new Color(0, 75, 143));
        jPanel25.setBackground( new Color(0, 75, 143));
        jPanel26.setBackground( new Color(0, 75, 143));
        jPanel27.setBackground( new Color(0, 75, 143));
        jPanel28.setBackground( new Color(0, 75, 143));
        jPanel29.setBackground( new Color(0, 75, 143));
        jPanel30.setBackground( new Color(0, 75, 143));
        jPanel31.setBackground( new Color(0, 75, 143));
        jPanel32.setBackground( new Color(0, 75, 143));
        jPanel33.setBackground( new Color(0, 75, 143));
        jPanel34.setBackground( new Color(0, 75, 143));
        jPanel35.setBackground( new Color(0, 75, 143));
        jPanel36.setBackground( new Color(0, 75, 143));
        jPanel37.setBackground( new Color(0, 75, 143));
        jPanel38.setBackground( new Color(0, 75, 143));
        jPanel39.setBackground( new Color(0, 75, 143));
        jPanel40.setBackground( new Color(0, 75, 143));
        jPanel41.setBackground( new Color(0, 75, 143));
        jPanel42.setBackground( new Color(0, 75, 143));
        jPanel43.setBackground( new Color(0, 75, 143));
        jPanel44.setBackground( new Color(0, 75, 143));
        jPanel45.setBackground( new Color(0, 75, 143));
        jPanel46.setBackground( new Color(0, 75, 143));
        jPanel47.setBackground( new Color(0, 75, 143));
        jPanel48.setBackground( new Color(0, 75, 143));
        jPanel49.setBackground( new Color(0, 75, 143));
        jPanel50.setBackground( new Color(0, 75, 143));
        jPanel51.setBackground( new Color(0, 75, 143));
        jPanel52.setBackground( new Color(0, 75, 143));
        jPanel53.setBackground( new Color(0, 75, 143));
        jPanel54.setBackground( new Color(0, 75, 143));
        jPanel55.setBackground( new Color(0, 75, 143));
        jPanel56.setBackground( new Color(0, 75, 143));
        jPanel62.setBackground( new Color(0, 75, 143));
        jPanel58.setBackground( new Color(0, 75, 143));
        jPanel59.setBackground( new Color(0, 75, 143));
        jPanel60.setBackground( new Color(0, 75, 143));
        jPanel61.setBackground( new Color(0, 75, 143));
        jPanel63.setBackground( new Color(0, 75, 143));
        jPanel64.setBackground( new Color(0, 75, 143));
        jPanel65.setBackground( new Color(0, 75, 143));
        jPanel74.setBackground( new Color(0, 75, 143));
        btnBuscar2.setBackground( new Color(14, 209, 69));
        btnDesactivar.setBackground( new Color(14, 209, 69));
        btnDesactivar1.setBackground( new Color(14, 209, 69));
        btnDesactivar2.setBackground( new Color(14, 209, 69));
        btnDesactivar3.setBackground( new Color(14, 209, 69));
        btnDesactivar4.setBackground( new Color(14, 209, 69));
        btnDesactivar5.setBackground( new Color(14, 209, 69));
        btnDesactivar6.setBackground( new Color(14, 209, 69));
        btnDesactivar11.setBackground( new Color(14, 209, 69));
        btnDesactivar12.setBackground( new Color(14, 209, 69));
        btnDesactivar9.setBackground( new Color(14, 209, 69));
        btnDesactivar10.setBackground( new Color(14, 209, 69));
        btnDesactivar15.setBackground( new Color(14, 209, 69));
        btnDesactivar13.setBackground( new Color(14, 209, 69));
        btnDesactivar14.setBackground( new Color(14, 209, 69));
        btnDesactivar16.setBackground( new Color(14, 209, 69));
        btnDesactivar17.setBackground( new Color(14, 209, 69));
        btnDesactivar18.setBackground( new Color(14, 209, 69));
        btnDesactivar19.setBackground( new Color(14, 209, 69));
        btnDesactivar20.setBackground( new Color(14, 209, 69));
        btnDesactivar21.setBackground( new Color(14, 209, 69));
        btnDesactivar22.setBackground( new Color(14, 209, 69));
        btnDesactivar23.setBackground( new Color(14, 209, 69));
        btnLimpiar.setBackground( new Color(14, 209, 69));
        btnDesactivar24.setBackground( new Color(14, 209, 69));
        btnDesactivar25.setBackground( new Color(14, 209, 69));
        btnDesactivar26.setBackground( new Color(14, 209, 69));
        btnDesactivar27.setBackground( new Color(14, 209, 69));
        btnDesactivar28.setBackground( new Color(14, 209, 69));
        btnDesactivar29.setBackground( new Color(14, 209, 69));
        btnDesactivar30.setBackground( new Color(14, 209, 69));
        btnDesactivar31.setBackground( new Color(14, 209, 69));
        btnDesactivar32.setBackground( new Color(14, 209, 69));
        btnDesactivar33.setBackground( new Color(14, 209, 69));
        btnDesactivar34.setBackground( new Color(14, 209, 69));
        btnDesactivar35.setBackground( new Color(14, 209, 69));
        btnDesactivar36.setBackground( new Color(14, 209, 69));
        btnDesactivar37.setBackground( new Color(14, 209, 69));
        btnDesactivar39.setBackground( new Color(14, 209, 69));
        btnDesactivar43.setBackground( new Color(14, 209, 69));
        btnDesactivar45.setBackground( new Color(14, 209, 69));
        btnDesactivar46.setBackground( new Color(14, 209, 69));
        btnDesactivar46.setBackground( new Color(14, 209, 69));
        btnDesactivar74.setBackground( new Color(14, 209, 69));
        btnDesactivar47.setBackground( new Color(14, 209, 69));
        btnDesactivar48.setBackground( new Color(14, 209, 69));
        btnDesactivar49.setBackground( new Color(14, 209, 69));
        btnDesactivar50.setBackground( new Color(14, 209, 69));
        btnDesactivar51.setBackground( new Color(14, 209, 69));
        btnDesactivar52.setBackground( new Color(14, 209, 69));
        btnDesactivar53.setBackground( new Color(14, 209, 69));
        btnDesactivar54.setBackground( new Color(14, 209, 69));
        btnDesactivar55.setBackground( new Color(14, 209, 69));
        btnDesactivar56.setBackground( new Color(14, 209, 69));
        btnDesactivar57.setBackground( new Color(14, 209, 69));
        btnDesactivar58.setBackground( new Color(14, 209, 69));
        btnDesactivar59.setBackground( new Color(14, 209, 69));
        btnDesactivar60.setBackground( new Color(14, 209, 69));
        btnDesactivar61.setBackground( new Color(14, 209, 69));
        btnDesactivar62.setBackground( new Color(14, 209, 69));
        btnDesactivar63.setBackground( new Color(14, 209, 69));
        btnDesactivar64.setBackground( new Color(14, 209, 69));
        btnDesactivar65.setBackground( new Color(14, 209, 69));
        btnDesactivar66.setBackground( new Color(14, 209, 69));
        btnDesactivar67.setBackground( new Color(14, 209, 69));
        btnDesactivar68.setBackground( new Color(14, 209, 69));
        btnDesactivar69.setBackground( new Color(14, 209, 69));
        btnDesactivar70.setBackground( new Color(14, 209, 69));
        btnDesactivar71.setBackground( new Color(14, 209, 69));
        btnDesactivar72.setBackground( new Color(14, 209, 69));
        btnDesactivar73.setBackground( new Color(14, 209, 69));
        btnDesactivar94.setBackground( new Color(14, 209, 69));

        btnDesactivar96.setBackground( new Color(14, 209, 69));
        btnDesactivar77.setBackground( new Color(14, 209, 69));
        btnDesactivar78.setBackground( new Color(14, 209, 69));
        btnDesactivar97.setBackground( new Color(14, 209, 69));
        btnDesactivar80.setBackground( new Color(14, 209, 69));
        btnDesactivar81.setBackground( new Color(14, 209, 69));
        btnDesactivar82.setBackground( new Color(14, 209, 69));
        btnDesactivar83.setBackground( new Color(14, 209, 69));
        btnDesactivar83.setBackground( new Color(14, 209, 69));
        btnDesactivar84.setBackground( new Color(14, 209, 69));
        btnDesactivar85.setBackground( new Color(14, 209, 69));
        btnDesactivar86.setBackground( new Color(14, 209, 69));
        btnDesactivar87.setBackground( new Color(14, 209, 69));
        btnDesactivar88.setBackground( new Color(14, 209, 69));
        btnDesactivar89.setBackground( new Color(14, 209, 69));
        btnDesactivar90.setBackground( new Color(14, 209, 69));
        btnDesactivar91.setBackground( new Color(14, 209, 69));
        btnDesactivar92.setBackground( new Color(14, 209, 69));
        btnDesactivar93.setBackground( new Color(14, 209, 69));
        btnDesactivar99.setBackground( new Color(14, 209, 69));
        btnDesactivar100.setBackground( new Color(14, 209, 69));
        btnDesactivar101.setBackground( new Color(14, 209, 69));
        btnDesactivar102.setBackground( new Color(14, 209, 69));
        btnDesactivar103.setBackground( new Color(14, 209, 69));
        btnDesactivar104.setBackground( new Color(14, 209, 69));
        btnDesactivar105.setBackground( new Color(14, 209, 69));
        btnDesactivar106.setBackground( new Color(14, 209, 69));
        btnDesactivar107.setBackground( new Color(14, 209, 69));
        btnDesactivar108.setBackground( new Color(14, 209, 69));
        btnDesactivar109.setBackground( new Color(14, 209, 69));
        btnDesactivar110.setBackground( new Color(14, 209, 69));
        btnDesactivar111.setBackground( new Color(14, 209, 69));
        btnDesactivar112.setBackground( new Color(14, 209, 69));
        btnDesactivar113.setBackground( new Color(14, 209, 69));
        btnDesactivar114.setBackground( new Color(14, 209, 69));
        btnDesactivar115.setBackground( new Color(14, 209, 69));
        btnDesactivar116.setBackground( new Color(14, 209, 69));
        btnDesactivar117.setBackground( new Color(14, 209, 69));
        btnDesactivar118.setBackground( new Color(14, 209, 69));
        btnDesactivar119.setBackground( new Color(14, 209, 69));
        btnDesactivar120.setBackground( new Color(14, 209, 69));
        btnDesactivar121.setBackground( new Color(14, 209, 69));
        btnDesactivar122.setBackground( new Color(14, 209, 69));
        btnDesactivar123.setBackground( new Color(14, 209, 69));
        btnDesactivar124.setBackground( new Color(14, 209, 69));
        btnDesactivar125.setBackground( new Color(14, 209, 69));
        btnDesactivar126.setBackground( new Color(14, 209, 69));
        btnDesactivar127.setBackground( new Color(14, 209, 69));
        btnDesactivar128.setBackground( new Color(14, 209, 69));
        btnDesactivar129.setBackground( new Color(14, 209, 69));
        btnDesactivar130.setBackground( new Color(14, 209, 69));
        btnDesactivar131.setBackground( new Color(14, 209, 69));
        btnDesactivar132.setBackground( new Color(14, 209, 69));
        btnDesactivar133.setBackground( new Color(14, 209, 69));
        btnDesactivar134.setBackground( new Color(14, 209, 69));
        btnDesactivar135.setBackground( new Color(14, 209, 69));
        btnDesactivar136.setBackground( new Color(14, 209, 69));
        btnDesactivar137.setBackground( new Color(14, 209, 69));
        btnDesactivar138.setBackground( new Color(14, 209, 69));
        btnDesactivar139.setBackground( new Color(14, 209, 69));
        btnDesactivar140.setBackground( new Color(14, 209, 69));

        btnDesactivar144.setBackground( new Color(14, 209, 69));
        btnDesactivar145.setBackground( new Color(14, 209, 69));
        btnDesactivar146.setBackground( new Color(14, 209, 69));
        btnDesactivar147.setBackground( new Color(14, 209, 69));
        btnDesactivar148.setBackground( new Color(14, 209, 69));
        btnDesactivar149.setBackground( new Color(14, 209, 69));
        btnDesactivar150.setBackground( new Color(14, 209, 69));
        btnDesactivar151.setBackground( new Color(14, 209, 69));
        btnDesactivar152.setBackground( new Color(14, 209, 69));
        btnDesactivar153.setBackground( new Color(14, 209, 69));
        btnDesactivar154.setBackground( new Color(14, 209, 69));
        btnDesactivar155.setBackground( new Color(14, 209, 69));
        btnDesactivar156.setBackground( new Color(14, 209, 69));
        
        
        
        
        
        
        
        
        
        btnRegresar.setBackground( new Color(14, 209, 69));
        btnSalir.setBackground( new Color(236, 28, 36));
        
        this.getContentPane().setBackground(new Color(0, 75, 143));
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        createComboBoxAcceso();
        createCombousuario();
        createTableAcceso();
    }
         private void createTableAcceso(){
        DefaultTableModel modelo = (DefaultTableModel) tblAcceso.getModel();
        tblAcceso.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Cargo");
        modelo.addColumn("Nuevo Cargo");
        modelo.addColumn("Estado");*/
        
         List<Acceso> temp = accesoDao.findAccesoEntities();
        List<Usuarios> temp2 = UsuariosDao.findUsuariosEntities();
       String nombre="";
        for(Acceso tpp: temp){
            for(Usuarios tp: temp2){
                if(tpp.getIdUsuario()==tp.getId_Usuario()){
            nombre=tp.getId_Nombre(); 
            modelo.addRow(
                    new Object[]{
                        tpp.getIdacceso(),
                        nombre
            });
                }
            }
        } 
    }
public boolean DesactivarMenuCliente() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoMenuClientes()){
            temp.setPermisoMenuClientes(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoMenuClientes(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarMenuCliente();

        return true;
        
}
public void btnActivarDesactivarMenuCliente(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoMenuClientes()){
        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar.setText("Desactivar");  
        btnDesactivar.setEnabled(true);
        }
        else{
            btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar.setText("Activar");
            btnDesactivar.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar.setEnabled(true);
        }
        }

public boolean DesactivarMenuEmpleado() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoMenuEmpleados()){
            temp.setPermisoMenuEmpleados(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoMenuEmpleados(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarMenuEmpleado();

        return true;
        
}
public void btnActivarDesactivarMenuEmpleado(){
         Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoMenuEmpleados()){
        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar1.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar1.setText("Desactivar");  
        btnDesactivar1.setEnabled(true);
        }
        else{
            btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar1.setText("Activar");
            btnDesactivar1.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar1.setEnabled(true);
        }
        }

public boolean DesactivarMenuBancos() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoMenuBancos()){
            temp.setPermisoMenuBancos(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoMenuBancos(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarMenuBancos();

        return true;
        
}
public void btnActivarDesactivarMenuBancos(){
         Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoMenuBancos()){
        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar3.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar3.setText("Desactivar");  
        btnDesactivar3.setEnabled(true);
        }
        else{
            btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar3.setText("Activar");
            btnDesactivar3.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar3.setEnabled(true);
        }
        }
public boolean DesactivarMenuVentas() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoMenuVentas()){
            temp.setPermisoMenuVentas(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoMenuVentas(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarMenuVentas();

        return true;
        
}
public void btnActivarDesactivarMenuVentas(){
         Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoMenuVentas()){
        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar2.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar2.setText("Desactivar");  
        btnDesactivar2.setEnabled(true);
        }
        else{
            btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar2.setText("Activar");
            btnDesactivar2.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar2.setEnabled(true);
        }
        }
public boolean DesactivarMenuPedidos() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoMenuPedidos()){
            temp.setPermisoMenuPedidos(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoMenuPedidos(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarMenuPedidos();

        return true;
        
}
public void btnActivarDesactivarMenuPedidos(){
         Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoMenuPedidos()){
        btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar5.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar5.setText("Desactivar");  
        btnDesactivar5.setEnabled(true);
        }
        else{
            btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar5.setText("Activar");
            btnDesactivar5.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar5.setEnabled(true);
        }
        }
public boolean DesactivarMenuPiezas() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoMenuPiezas()){
            temp.setPermisoMenuPiezas(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoMenuPiezas(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarMenuPiezas();

        return true;
        
}
public void btnActivarDesactivarMenuPiezas(){
         Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoMenuPiezas()){
        btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar6.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar6.setText("Desactivar");  
        btnDesactivar6.setEnabled(true);
        }
        else{
            btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar6.setText("Activar");
            btnDesactivar6.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar6.setEnabled(true);
        }
        }
public boolean DesactivarMenuVehiculos() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoMenuVehiculos()){
            temp.setPermisoMenuVehiculos(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoMenuVehiculos(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarMenuVehiculos();

        return true;
        
}
public void btnActivarDesactivarMenuVehiculos(){
         Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoMenuVehiculos()){
        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar4.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar4.setText("Desactivar");  
        btnDesactivar4.setEnabled(true);
        }
        else{
            btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar4.setText("Activar");
            btnDesactivar4.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar4.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionEmpleadosAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionEmpleadosAgregar()){
            temp.setPermisoSeccionEmpleadosAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionEmpleadosAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionEmpleadosAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionEmpleadosAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionEmpleadosAgregar()){
        btnDesactivar7.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar7.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar7.setText("Desactivar");  
        btnDesactivar7.setEnabled(true);
        }
        else{
            btnDesactivar7.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar7.setText("Activar");
            btnDesactivar7.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar7.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionEmpleadosModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionEmpleadosModificar()){
            temp.setPermisoSeccionEmpleadosModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionEmpleadosModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionEmpleadosModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionEmpleadosModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionEmpleadosModificar()){
        btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar8.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar8.setText("Desactivar");  
        btnDesactivar8.setEnabled(true);
        }
        else{
            btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar8.setText("Activar");
            btnDesactivar8.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar8.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionEmpleadosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionEmpleadosDesactivar()){
            temp.setPermisoSeccionEmpleadosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionEmpleadosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionEmpleadosDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionEmpleadosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionEmpleadosDesactivar()){
        btnDesactivar42.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar42.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar42.setText("Desactivar");  
        btnDesactivar42.setEnabled(true);
        }
        else{
            btnDesactivar42.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar42.setText("Activar");
            btnDesactivar42.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar42.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionEmpleadosBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionEmpleadosBuscar()){
            temp.setPermisoSeccionEmpleadosBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionEmpleadosBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionEmpleadosBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionEmpleadosBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionEmpleadosBuscar()){
        btnDesactivar40.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar40.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar40.setText("Desactivar");  
        btnDesactivar40.setEnabled(true);
        }
        else{
            btnDesactivar40.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar40.setText("Activar");
            btnDesactivar40.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar40.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionEmpleadosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionEmpleadosReportePdf()){
            temp.setPermisoSeccionEmpleadosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionEmpleadosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionEmpleadosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionEmpleadosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionEmpleadosReportePdf()){
        btnDesactivar41.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar41.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar41.setText("Desactivar");  
        btnDesactivar41.setEnabled(true);
        }
        else{
            btnDesactivar41.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar41.setText("Activar");
            btnDesactivar41.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar41.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionEmpleadosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionEmpleadosReporteExcel()){
            temp.setPermisoSeccionEmpleadosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionEmpleadosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionEmpleadosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionEmpleadosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionEmpleadosReporteExcel()){
        btnDesactivar44.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar44.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar44.setText("Desactivar");  
        btnDesactivar44.setEnabled(true);
        }
        else{
            btnDesactivar44.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar44.setText("Activar");
            btnDesactivar44.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar44.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionCargosAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCargosAgregar()){
            temp.setPermisoSeccionCargosAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCargosAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCargosAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCargosAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCargosAgregar()){
        btnDesactivar46.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar46.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar46.setText("Desactivar");  
        btnDesactivar46.setEnabled(true);
        }
        else{
            btnDesactivar46.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar46.setText("Activar");
            btnDesactivar46.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar46.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionCargosModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCargosModificar()){
            temp.setPermisoSeccionCargosModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCargosModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCargosModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCargosModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCargosModificar()){
        btnDesactivar80.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar80.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar80.setText("Desactivar");  
        btnDesactivar80.setEnabled(true);
        }
        else{
            btnDesactivar80.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar80.setText("Activar");
            btnDesactivar80.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar80.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionCargosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCargosDesactivar()){
            temp.setPermisoSeccionCargosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCargosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCargosDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCargosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCargosDesactivar()){
        btnDesactivar83.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar83.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar83.setText("Desactivar");  
        btnDesactivar83.setEnabled(true);
        }
        else{
            btnDesactivar83.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar83.setText("Activar");
            btnDesactivar83.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar83.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionCargosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCargosReportePdf()){
            temp.setPermisoSeccionCargosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCargosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCargosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCargosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCargosReportePdf()){
        btnDesactivar82.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar82.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar82.setText("Desactivar");  
        btnDesactivar82.setEnabled(true);
        }
        else{
            btnDesactivar82.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar82.setText("Activar");
            btnDesactivar82.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar82.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionCargosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCargosReporteExcel()){
            temp.setPermisoSeccionCargosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCargosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCargosReporteExcel();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionCargosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCargosReporteExcel()){
        btnDesactivar84.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar84.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar84.setText("Desactivar");  
        btnDesactivar84.setEnabled(true);
        }
        else{
            btnDesactivar84.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar84.setText("Activar");
            btnDesactivar84.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar84.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionUsuariosAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionUsuariosAgregar()){
            temp.setPermisoSeccionUsuariosAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionUsuariosAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionUsuariosAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionUsuariosAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionUsuariosAgregar()){
        btnDesactivar81.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar81.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar81.setText("Desactivar");  
        btnDesactivar81.setEnabled(true);
        }
        else{
            btnDesactivar81.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar81.setText("Activar");
            btnDesactivar81.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar81.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionUsuariosModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionUsuariosModificar()){
            temp.setPermisoSeccionUsuariosModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionUsuariosModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionUsuariosModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionUsuariosModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionUsuariosModificar()){
        btnDesactivar85.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar85.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar85.setText("Desactivar");  
        btnDesactivar85.setEnabled(true);
        }
        else{
            btnDesactivar85.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar85.setText("Activar");
            btnDesactivar85.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar85.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionUsuariosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionUsuariosDesactivar()){
            temp.setPermisoSeccionUsuariosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionUsuariosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionUsuariosDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionUsuariosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionUsuariosDesactivar()){
        btnDesactivar90.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar90.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar90.setText("Desactivar");  
        btnDesactivar90.setEnabled(true);
        }
        else{
            btnDesactivar90.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar90.setText("Activar");
            btnDesactivar90.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar90.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionUsuariosBuscarUsuario() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionUsuariosBuscarUsuario()){
            temp.setPermisoSeccionUsuariosBuscarUsuario(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionUsuariosBuscarUsuario(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionUsuariosBuscarUsuario();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionUsuariosBuscarUsuario(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionUsuariosBuscarUsuario()){
        btnDesactivar88.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar88.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar88.setText("Desactivar");  
        btnDesactivar88.setEnabled(true);
        }
        else{
            btnDesactivar88.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar88.setText("Activar");
            btnDesactivar88.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar88.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionUsuariosBuscarEmpleado() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionUsuariosBuscarEmpleado()){
            temp.setPermisoSeccionUsuariosBuscarEmpleado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionUsuariosBuscarEmpleado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionUsuariosBuscarEmpleado();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionUsuariosBuscarEmpleado(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionUsuariosBuscarEmpleado()){
        btnDesactivar86.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar86.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar86.setText("Desactivar");  
        btnDesactivar86.setEnabled(true);
        }
        else{
            btnDesactivar86.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar86.setText("Activar");
            btnDesactivar86.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar86.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionUsuariosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionUsuariosReportePdf()){
            temp.setPermisoSeccionUsuariosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionUsuariosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionUsuariosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionUsuariosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionUsuariosReportePdf()){
        btnDesactivar87.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar87.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar87.setText("Desactivar");  
        btnDesactivar87.setEnabled(true);
        }
        else{
            btnDesactivar87.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar87.setText("Activar");
            btnDesactivar87.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar87.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionUsuariosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionUsuariosReporteExcel()){
            temp.setPermisoSeccionUsuariosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionUsuariosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionUsuariosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionUsuariosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionUsuariosReporteExcel()){
        btnDesactivar89.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar89.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar89.setText("Desactivar");  
        btnDesactivar89.setEnabled(true);
        }
        else{
            btnDesactivar89.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar89.setText("Activar");
            btnDesactivar89.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar89.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionHistorialSueldosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialSueldosReportePdf()){
            temp.setPermisoSeccionHistorialSueldosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialSueldosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialSueldosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialSueldosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialSueldosReportePdf()){
        btnDesactivar94.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar94.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar94.setText("Desactivar");  
        btnDesactivar94.setEnabled(true);
        }
        else{
            btnDesactivar94.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar94.setText("Activar");
            btnDesactivar94.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar94.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionHistorialSueldosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialSueldosReporteExcel()){
            temp.setPermisoSeccionHistorialSueldosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialSueldosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialSueldosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialSueldosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialSueldosReporteExcel()){
        btnDesactivar96.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar96.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar96.setText("Desactivar");  
        btnDesactivar96.setEnabled(true);
        }
        else{
            btnDesactivar96.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar96.setText("Activar");
            btnDesactivar96.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar96.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionHistorialCargosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialCargosReportePdf()){
            temp.setPermisoSeccionHistorialCargosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialCargosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialCargosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialCargosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialCargosReportePdf()){
        btnDesactivar97.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar97.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar97.setText("Desactivar");  
        btnDesactivar97.setEnabled(true);
        }
        else{
            btnDesactivar97.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar97.setText("Activar");
            btnDesactivar97.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar97.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionHistorialCargosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialCargosReporteExcel()){
            temp.setPermisoSeccionHistorialCargosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialCargosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialCargosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialCargosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialCargosReporteExcel()){
        btnDesactivar99.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar99.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar99.setText("Desactivar");  
        btnDesactivar99.setEnabled(true);
        }
        else{
            btnDesactivar99.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar99.setText("Activar");
            btnDesactivar99.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar99.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionClientesAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionClientesAgregar()){
            temp.setPermisoSeccionClientesAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionClientesAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionClientesAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionClientesAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionClientesAgregar()){
        btnDesactivar13.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar13.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar13.setText("Desactivar");  
        btnDesactivar13.setEnabled(true);
        }
        else{
            btnDesactivar13.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar13.setText("Activar");
            btnDesactivar13.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar13.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionClientesModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionClientesModificar()){
            temp.setPermisoSeccionClientesModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionClientesModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionClientesModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionClientesModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionClientesModificar()){
        btnDesactivar23.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar23.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar23.setText("Desactivar");  
        btnDesactivar23.setEnabled(true);
        }
        else{
            btnDesactivar23.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar23.setText("Activar");
            btnDesactivar23.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar23.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionClientesDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionClientesDesactivar()){
            temp.setPermisoSeccionClientesDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionClientesDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionClientesDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionClientesDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionClientesDesactivar()){
        btnDesactivar24.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar24.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar24.setText("Desactivar");  
        btnDesactivar24.setEnabled(true);
        }
        else{
            btnDesactivar24.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar24.setText("Activar");
            btnDesactivar24.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar24.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionClientesBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionClientesBuscar()){
            temp.setPermisoSeccionClientesBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionClientesBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionClientesBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionClientesBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionClientesBuscar()){
        btnDesactivar26.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar26.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar26.setText("Desactivar");  
        btnDesactivar26.setEnabled(true);
        }
        else{
            btnDesactivar26.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar26.setText("Activar");
            btnDesactivar26.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar26.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionClientesReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionClientesReportePdf()){
            temp.setPermisoSeccionClientesReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionClientesReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionClientesReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionClientesReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionClientesReportePdf()){
        btnDesactivar25.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar25.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar25.setText("Desactivar");  
        btnDesactivar25.setEnabled(true);
        }
        else{
            btnDesactivar25.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar25.setText("Activar");
            btnDesactivar25.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar25.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionClientesReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionClientesReporteExcel()){
            temp.setPermisoSeccionClientesReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionClientesReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionClientesReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionClientesReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionClientesReporteExcel()){
        btnDesactivar27.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar27.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar27.setText("Desactivar");  
        btnDesactivar27.setEnabled(true);
        }
        else{
            btnDesactivar27.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar27.setText("Activar");
            btnDesactivar27.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar27.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoDocumentoAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoDocumentoAgregar()){
            temp.setPermisoSeccionTipoDocumentoAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoDocumentoAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoDocumentoAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoDocumentoAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoDocumentoAgregar()){
        btnDesactivar28.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar28.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar28.setText("Desactivar");  
        btnDesactivar28.setEnabled(true);
        }
        else{
            btnDesactivar28.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar28.setText("Activar");
            btnDesactivar28.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar28.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoDocumentoModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoDocumentoModificar()){
            temp.setPermisoSeccionTipoDocumentoModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoDocumentoModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoDocumentoModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoDocumentoModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoDocumentoModificar()){
        btnDesactivar29.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar29.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar29.setText("Desactivar");  
        btnDesactivar29.setEnabled(true);
        }
        else{
            btnDesactivar29.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar29.setText("Activar");
            btnDesactivar29.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar29.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoDocumentoDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoDocumentoDesactivar()){
            temp.setPermisoSeccionTipoDocumentoDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoDocumentoDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoDocumentoDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoDocumentoDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoDocumentoDesactivar()){
        btnDesactivar74.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar74.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar74.setText("Desactivar");  
        btnDesactivar74.setEnabled(true);
        }
        else{
            btnDesactivar74.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar74.setText("Activar");
            btnDesactivar74.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar74.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoDocumentoReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoDocumentoReportePdf()){
            temp.setPermisoSeccionTipoDocumentoReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoDocumentoReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoDocumentoReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoDocumentoReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoDocumentoReportePdf()){
        btnDesactivar32.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar32.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar32.setText("Desactivar");  
        btnDesactivar32.setEnabled(true);
        }
        else{
            btnDesactivar32.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar32.setText("Activar");
            btnDesactivar32.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar32.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoDocumentoReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoDocumentoReporteExcel()){
            temp.setPermisoSeccionTipoDocumentoReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoDocumentoReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoDocumentoReporteExcel();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionTipoDocumentoReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoDocumentoReporteExcel()){
        btnDesactivar31.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar31.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar31.setText("Desactivar");  
        btnDesactivar31.setEnabled(true);
        }
        else{
            btnDesactivar31.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar31.setText("Activar");
            btnDesactivar31.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar31.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionBancosAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBancosAgregar()){
            temp.setPermisoSeccionBancosAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBancosAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBancosAgregar();

        return true;
        
}


public void btnActivarDesactivarPermisoSeccionBancosAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBancosAgregar()){
        btnDesactivar9.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar9.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar9.setText("Desactivar");  
        btnDesactivar9.setEnabled(true);
        }
        else{
            btnDesactivar9.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar9.setText("Activar");
            btnDesactivar9.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar9.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBancosModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBancosModificar()){
            temp.setPermisoSeccionBancosModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBancosModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBancosModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBancosModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBancosModificar()){
        btnDesactivar10.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar10.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar10.setText("Desactivar");  
        btnDesactivar10.setEnabled(true);
        }
        else{
            btnDesactivar10.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar10.setText("Activar");
            btnDesactivar10.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar10.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBancosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBancosDesactivar()){
            temp.setPermisoSeccionBancosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBancosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBancosDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBancosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBancosDesactivar()){
        btnDesactivar14.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar14.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar14.setText("Desactivar");  
        btnDesactivar14.setEnabled(true);
        }
        else{
            btnDesactivar14.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar14.setText("Activar");
            btnDesactivar14.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar14.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBancosBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBancosBuscar()){
            temp.setPermisoSeccionBancosBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBancosBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBancosBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBancosBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBancosBuscar()){
        btnDesactivar16.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar16.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar16.setText("Desactivar");  
        btnDesactivar16.setEnabled(true);
        }
        else{
            btnDesactivar16.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar16.setText("Activar");
            btnDesactivar16.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar16.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBancosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBancosReportePdf()){
            temp.setPermisoSeccionBancosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBancosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBancosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBancosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBancosReportePdf()){
        btnDesactivar15.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar15.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar15.setText("Desactivar");  
        btnDesactivar15.setEnabled(true);
        }
        else{
            btnDesactivar15.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar15.setText("Activar");
            btnDesactivar15.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar15.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBancosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBancosReporteExcel()){
            temp.setPermisoSeccionBancosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBancosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBancosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBancosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBancosReporteExcel()){
        btnDesactivar19.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar19.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar19.setText("Desactivar");  
        btnDesactivar19.setEnabled(true);
        }
        else{
            btnDesactivar19.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar19.setText("Activar");
            btnDesactivar19.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar19.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPrestamosAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPrestamosAgregar()){
            temp.setPermisoSeccionPrestamosAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPrestamosAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPrestamosAgregar();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionPrestamosAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPrestamosAgregar()){
        btnDesactivar11.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar11.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar11.setText("Desactivar");  
        btnDesactivar11.setEnabled(true);
        }
        else{
            btnDesactivar11.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar11.setText("Activar");
            btnDesactivar11.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar11.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPrestamosModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPrestamosModificar()){
            temp.setPermisoSeccionPrestamosModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPrestamosModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPrestamosModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPrestamosModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPrestamosModificar()){
        btnDesactivar12.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar12.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar12.setText("Desactivar");  
        btnDesactivar12.setEnabled(true);
        }
        else{
            btnDesactivar12.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar12.setText("Activar");
            btnDesactivar12.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar12.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPrestamosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPrestamosDesactivar()){
            temp.setPermisoSeccionPrestamosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPrestamosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPrestamosDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPrestamosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPrestamosDesactivar()){
        btnDesactivar22.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar22.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar22.setText("Desactivar");  
        btnDesactivar22.setEnabled(true);
        }
        else{
            btnDesactivar22.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar22.setText("Activar");
            btnDesactivar22.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar22.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPrestamosBuscarBanco() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPrestamosBuscarBanco()){
            temp.setPermisoSeccionPrestamosBuscarBanco(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPrestamosBuscarBanco(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPrestamosBuscarBanco();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPrestamosBuscarBanco(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPrestamosBuscarBanco()){
        btnDesactivar20.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar20.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar20.setText("Desactivar");  
        btnDesactivar20.setEnabled(true);
        }
        else{
            btnDesactivar20.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar20.setText("Activar");
            btnDesactivar20.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar20.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionPrestamosBuscarCliente() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPrestamosBuscarCliente()){
            temp.setPermisoSeccionPrestamosBuscarCliente(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPrestamosBuscarCliente(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPrestamosBuscarCliente();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPrestamosBuscarCliente(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPrestamosBuscarCliente()){
        btnDesactivar17.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar17.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar17.setText("Desactivar");  
        btnDesactivar17.setEnabled(true);
        }
        else{
            btnDesactivar17.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar17.setText("Activar");
            btnDesactivar17.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar17.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPrestamosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPrestamosReportePdf()){
            temp.setPermisoSeccionPrestamosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPrestamosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPrestamosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPrestamosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPrestamosReportePdf()){
        btnDesactivar18.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar18.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar18.setText("Desactivar");  
        btnDesactivar18.setEnabled(true);
        }
        else{
            btnDesactivar18.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar18.setText("Activar");
            btnDesactivar18.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar18.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPrestamosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPrestamosReporteExcel()){
            temp.setPermisoSeccionPrestamosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPrestamosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPrestamosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPrestamosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPrestamosReporteExcel()){
        btnDesactivar21.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar21.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar21.setText("Desactivar");  
        btnDesactivar21.setEnabled(true);
        }
        else{
            btnDesactivar21.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar21.setText("Activar");
            btnDesactivar21.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar21.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionPedidosAgregarPieza() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPedidosAgregarPieza()){
            temp.setPermisoSeccionPedidosAgregarPieza(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPedidosAgregarPieza(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPedidosAgregarPieza();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionPedidosAgregarPieza(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPedidosAgregarPieza()){
        btnDesactivar33.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar33.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar33.setText("Desactivar");  
        btnDesactivar33.setEnabled(true);
        }
        else{
            btnDesactivar33.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar33.setText("Activar");
            btnDesactivar33.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar33.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPedidosAgregarVehiculo() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPedidosAgregarVehiculo()){
            temp.setPermisoSeccionPedidosAgregarVehiculo(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPedidosAgregarVehiculo(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPedidosAgregarVehiculo();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionPedidosAgregarVehiculo(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPedidosAgregarVehiculo()){
        btnDesactivar30.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar30.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar30.setText("Desactivar");  
        btnDesactivar30.setEnabled(true);
        }
        else{
            btnDesactivar30.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar30.setText("Activar");
            btnDesactivar30.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar30.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPedidosAgregarPedido() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPedidosAgregarPedido()){
            temp.setPermisoSeccionPedidosAgregarPedido(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPedidosAgregarPedido(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPedidosAgregarPedido();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionPedidosAgregarPedido(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPedidosAgregarPedido()){
        btnDesactivar35.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar35.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar35.setText("Desactivar");  
        btnDesactivar35.setEnabled(true);
        }
        else{
            btnDesactivar35.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar35.setText("Activar");
            btnDesactivar35.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar35.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPedidosBuscarPieza() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPedidosBuscarPieza()){
            temp.setPermisoSeccionPedidosBuscarPieza(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPedidosBuscarPieza(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPedidosBuscarPieza();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionPedidosBuscarPieza(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPedidosBuscarPieza()){
        btnDesactivar36.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar36.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar36.setText("Desactivar");  
        btnDesactivar36.setEnabled(true);
        }
        else{
            btnDesactivar36.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar36.setText("Activar");
            btnDesactivar36.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar36.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPedidosBuscarVehiculo() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPedidosBuscarVehiculo()){
            temp.setPermisoSeccionPedidosBuscarVehiculo(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPedidosBuscarVehiculo(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPedidosBuscarVehiculo();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionPedidosBuscarVehiculo(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPedidosBuscarVehiculo()){
        btnDesactivar37.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar37.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar37.setText("Desactivar");  
        btnDesactivar37.setEnabled(true);
        }
        else{
            btnDesactivar37.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar37.setText("Activar");
            btnDesactivar37.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar37.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionListadoPedidosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionListadoPedidosDesactivar()){
            temp.setPermisoSeccionListadoPedidosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionListadoPedidosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionListadoPedidosDesactivar();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionListadoPedidosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionListadoPedidosDesactivar()){
        btnDesactivar45.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar45.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar45.setText("Desactivar");  
        btnDesactivar45.setEnabled(true);
        }
        else{
            btnDesactivar45.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar45.setText("Activar");
            btnDesactivar45.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar45.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionListadoPedidosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionListadoPedidosReportePdf()){
            temp.setPermisoSeccionListadoPedidosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionListadoPedidosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionListadoPedidosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionListadoPedidosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionListadoPedidosReportePdf()){
        btnDesactivar39.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar39.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar39.setText("Desactivar");  
        btnDesactivar39.setEnabled(true);
        }
        else{
            btnDesactivar39.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar39.setText("Activar");
            btnDesactivar39.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar39.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionListadoPedidosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionListadoPedidosReporteExcel()){
            temp.setPermisoSeccionListadoPedidosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionListadoPedidosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionListadoPedidosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionListadoPedidosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionListadoPedidosReporteExcel()){
        btnDesactivar43.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar43.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar43.setText("Desactivar");  
        btnDesactivar43.setEnabled(true);
        }
        else{
            btnDesactivar43.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar43.setText("Activar");
            btnDesactivar43.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar43.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPiezasAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPiezasAgregar()){
            temp.setPermisoSeccionPiezasAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPiezasAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPiezasAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPiezasAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPiezasAgregar()){
        btnDesactivar47.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar47.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar47.setText("Desactivar");  
        btnDesactivar47.setEnabled(true);
        }
        else{
            btnDesactivar47.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar47.setText("Activar");
            btnDesactivar47.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar47.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPiezasModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPiezasModificar()){
            temp.setPermisoSeccionPiezasModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPiezasModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPiezasModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPiezasModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPiezasModificar()){
        btnDesactivar48.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar48.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar48.setText("Desactivar");  
        btnDesactivar48.setEnabled(true);
        }
        else{
            btnDesactivar48.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar48.setText("Activar");
            btnDesactivar48.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar48.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPiezasDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPiezasDesactivar()){
            temp.setPermisoSeccionPiezasDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPiezasDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPiezasDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPiezasDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPiezasDesactivar()){
        btnDesactivar51.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar51.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar51.setText("Desactivar");  
        btnDesactivar51.setEnabled(true);
        }
        else{
            btnDesactivar51.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar51.setText("Activar");
            btnDesactivar51.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar51.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionPiezasReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPiezasReportePdf()){
            temp.setPermisoSeccionPiezasReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPiezasReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPiezasReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPiezasReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPiezasReportePdf()){
        btnDesactivar50.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar50.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar50.setText("Desactivar");  
        btnDesactivar50.setEnabled(true);
        }
        else{
            btnDesactivar50.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar50.setText("Activar");
            btnDesactivar50.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar50.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionPiezasReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionPiezasReporteExcel()){
            temp.setPermisoSeccionPiezasReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionPiezasReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionPiezasReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionPiezasReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionPiezasReporteExcel()){
        btnDesactivar52.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar52.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar52.setText("Desactivar");  
        btnDesactivar52.setEnabled(true);
        }
        else{
            btnDesactivar52.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar52.setText("Activar");
            btnDesactivar52.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar52.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoPiezaAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPiezaAgregar()){
            temp.setPermisoSeccionTipoPiezaAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPiezaAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPiezaAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPiezaAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPiezaAgregar()){
        btnDesactivar49.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar49.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar49.setText("Desactivar");  
        btnDesactivar49.setEnabled(true);
        }
        else{
            btnDesactivar49.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar49.setText("Activar");
            btnDesactivar49.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar49.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoPiezaModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPiezaModificar()){
            temp.setPermisoSeccionTipoPiezaModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPiezaModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPiezaModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPiezaModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPiezaModificar()){
        btnDesactivar91.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar91.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar91.setText("Desactivar");  
        btnDesactivar91.setEnabled(true);
        }
        else{
            btnDesactivar91.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar91.setText("Activar");
            btnDesactivar91.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar91.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoPiezaDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPiezaDesactivar()){
            temp.setPermisoSeccionTipoPiezaDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPiezaDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPiezaDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPiezaDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPiezaDesactivar()){
        btnDesactivar93.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar93.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar93.setText("Desactivar");  
        btnDesactivar93.setEnabled(true);
        }
        else{
            btnDesactivar93.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar93.setText("Activar");
            btnDesactivar93.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar93.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoPiezaReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPiezaReportePdf()){
            temp.setPermisoSeccionTipoPiezaReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPiezaReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPiezaReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPiezaReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPiezaReportePdf()){
        btnDesactivar92.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar92.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar92.setText("Desactivar");  
        btnDesactivar92.setEnabled(true);
        }
        else{
            btnDesactivar92.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar92.setText("Activar");
            btnDesactivar92.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar92.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoPiezaReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPiezaReporteExcel()){
            temp.setPermisoSeccionTipoPiezaReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPiezaReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPiezaReporteExcel();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionTipoPiezaReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPiezaReporteExcel()){
        btnDesactivar100.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar100.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar100.setText("Desactivar");  
        btnDesactivar100.setEnabled(true);
        }
        else{
            btnDesactivar100.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar100.setText("Activar");
            btnDesactivar100.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar100.setEnabled(true);
        }
        }



public boolean DesactivarPermisoSeccionHistorialPreciosPiezaBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialPreciosPiezaBuscar()){
            temp.setPermisoSeccionHistorialPreciosPiezaBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialPreciosPiezaBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialPreciosPiezaBuscar()){
        btnDesactivar115.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar115.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar115.setText("Desactivar");  
        btnDesactivar115.setEnabled(true);
        }
        else{
            btnDesactivar115.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar115.setText("Activar");
            btnDesactivar115.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar115.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionHistorialPreciosPiezaReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialPreciosPiezaReportePdf()){
            temp.setPermisoSeccionHistorialPreciosPiezaReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialPreciosPiezaReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialPreciosPiezaReportePdf()){
        btnDesactivar114.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar114.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar114.setText("Desactivar");  
        btnDesactivar114.setEnabled(true);
        }
        else{
            btnDesactivar114.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar114.setText("Activar");
            btnDesactivar114.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar114.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionHistorialPreciosPiezaReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialPreciosPiezaReporteExcel()){
            temp.setPermisoSeccionHistorialPreciosPiezaReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialPreciosPiezaReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReporteExcel();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialPreciosPiezaReporteExcel()){
        btnDesactivar116.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar116.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar116.setText("Desactivar");  
        btnDesactivar116.setEnabled(true);
        }
        else{
            btnDesactivar116.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar116.setText("Activar");
            btnDesactivar116.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar116.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBuscarPiezaBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBuscarPiezaBuscar()){
            temp.setPermisoSeccionBuscarPiezaBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBuscarPiezaBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBuscarPiezaBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBuscarPiezaBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBuscarPiezaBuscar()){
        btnDesactivar109.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar109.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar109.setText("Desactivar");  
        btnDesactivar109.setEnabled(true);
        }
        else{
            btnDesactivar109.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar109.setText("Activar");
            btnDesactivar109.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar109.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionBuscarPiezaReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBuscarPiezaReportePdf()){
            temp.setPermisoSeccionBuscarPiezaReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBuscarPiezaReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBuscarPiezaReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBuscarPiezaReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBuscarPiezaReportePdf()){
        btnDesactivar108.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar108.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar108.setText("Desactivar");  
        btnDesactivar108.setEnabled(true);
        }
        else{
            btnDesactivar108.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar108.setText("Activar");
            btnDesactivar108.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar108.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBuscarPiezaReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBuscarPiezaReporteExcel()){
            temp.setPermisoSeccionBuscarPiezaReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBuscarPiezaReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBuscarPiezaReporteExcel();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionBuscarPiezaReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBuscarPiezaReporteExcel()){
        btnDesactivar110.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar110.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar110.setText("Desactivar");  
        btnDesactivar110.setEnabled(true);
        }
        else{
            btnDesactivar110.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar110.setText("Activar");
            btnDesactivar110.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar110.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionVehiculosAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVehiculosAgregar()){
            temp.setPermisoSeccionVehiculosAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVehiculosAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVehiculosAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionVehiculosAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVehiculosAgregar()){
        btnDesactivar53.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar53.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar53.setText("Desactivar");  
        btnDesactivar53.setEnabled(true);
        }
        else{
            btnDesactivar53.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar53.setText("Activar");
            btnDesactivar53.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar53.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionVehiculosModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVehiculosModificar()){
            temp.setPermisoSeccionVehiculosModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVehiculosModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVehiculosModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionVehiculosModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVehiculosModificar()){
        btnDesactivar54.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar54.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar54.setText("Desactivar");  
        btnDesactivar54.setEnabled(true);
        }
        else{
            btnDesactivar54.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar54.setText("Activar");
            btnDesactivar54.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar54.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionVehiculosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVehiculosDesactivar()){
            temp.setPermisoSeccionVehiculosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVehiculosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVehiculosDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionVehiculosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVehiculosDesactivar()){
        btnDesactivar56.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar56.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar56.setText("Desactivar");  
        btnDesactivar56.setEnabled(true);
        }
        else{
            btnDesactivar56.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar56.setText("Activar");
            btnDesactivar56.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar56.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionVehiculosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVehiculosReportePdf()){
            temp.setPermisoSeccionVehiculosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVehiculosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVehiculosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionVehiculosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVehiculosReportePdf()){
        btnDesactivar55.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar55.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar55.setText("Desactivar");  
        btnDesactivar55.setEnabled(true);
        }
        else{
            btnDesactivar55.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar55.setText("Activar");
            btnDesactivar55.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar55.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionVehiculosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVehiculosReporteExcel()){
            temp.setPermisoSeccionVehiculosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVehiculosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVehiculosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionVehiculosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVehiculosReporteExcel()){
        btnDesactivar57.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar57.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar57.setText("Desactivar");  
        btnDesactivar57.setEnabled(true);
        }
        else{
            btnDesactivar57.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar57.setText("Activar");
            btnDesactivar57.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar57.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionMarcaAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionMarcaAgregar()){
            temp.setPermisoSeccionMarcaAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionMarcaAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionMarcaAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionMarcaAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionMarcaAgregar()){
        btnDesactivar58.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar58.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar58.setText("Desactivar");  
        btnDesactivar58.setEnabled(true);
        }
        else{
            btnDesactivar58.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar58.setText("Activar");
            btnDesactivar58.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar58.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionMarcaModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionMarcaModificar()){
            temp.setPermisoSeccionMarcaModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionMarcaModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionMarcaModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionMarcaModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionMarcaModificar()){
        btnDesactivar101.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar101.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar101.setText("Desactivar");  
        btnDesactivar101.setEnabled(true);
        }
        else{
            btnDesactivar101.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar101.setText("Activar");
            btnDesactivar101.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar101.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionMarcaDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionMarcaDesactivar()){
            temp.setPermisoSeccionMarcaDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionMarcaDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionMarcaDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionMarcaDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionMarcaDesactivar()){
        btnDesactivar103.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar103.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar103.setText("Desactivar");  
        btnDesactivar103.setEnabled(true);
        }
        else{
            btnDesactivar103.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar103.setText("Activar");
            btnDesactivar103.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar103.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionMarcaReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionMarcaReportePdf()){
            temp.setPermisoSeccionMarcaReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionMarcaReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionMarcaReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionMarcaReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionMarcaReportePdf()){
        btnDesactivar102.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar102.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar102.setText("Desactivar");  
        btnDesactivar102.setEnabled(true);
        }
        else{
            btnDesactivar102.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar102.setText("Activar");
            btnDesactivar102.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar102.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionMarcaReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionMarcaReporteExcel()){
            temp.setPermisoSeccionMarcaReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionMarcaReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionMarcaReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionMarcaReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionMarcaReporteExcel()){
        btnDesactivar104.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar104.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar104.setText("Desactivar");  
        btnDesactivar104.setEnabled(true);
        }
        else{
            btnDesactivar104.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar104.setText("Activar");
            btnDesactivar104.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar104.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionColorAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionColorAgregar()){
            temp.setPermisoSeccionColorAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionColorAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionColorAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionColorAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionColorAgregar()){
        btnDesactivar59.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar59.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar59.setText("Desactivar");  
        btnDesactivar59.setEnabled(true);
        }
        else{
            btnDesactivar59.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar59.setText("Activar");
            btnDesactivar59.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar59.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionColorModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionColorModificar()){
            temp.setPermisoSeccionColorModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionColorModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionColorModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionColorModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionColorModificar()){
        btnDesactivar105.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar105.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar105.setText("Desactivar");  
        btnDesactivar105.setEnabled(true);
        }
        else{
            btnDesactivar105.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar105.setText("Activar");
            btnDesactivar105.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar105.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionColorDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionColorDesactivar()){
            temp.setPermisoSeccionColorDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionColorDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionColorDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionColorDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionColorDesactivar()){
        btnDesactivar107.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar107.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar107.setText("Desactivar");  
        btnDesactivar107.setEnabled(true);
        }
        else{
            btnDesactivar107.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar107.setText("Activar");
            btnDesactivar107.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar107.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionColorReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionColorReportePdf()){
            temp.setPermisoSeccionColorReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionColorReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionColorReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionColorReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionColorReportePdf()){
        btnDesactivar106.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar106.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar106.setText("Desactivar");  
        btnDesactivar106.setEnabled(true);
        }
        else{
            btnDesactivar106.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar106.setText("Activar");
            btnDesactivar106.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar106.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionColorReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionColorReporteExcel()){
            temp.setPermisoSeccionColorReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionColorReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionColorReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionColorReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionColorReporteExcel()){
        btnDesactivar120.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar120.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar120.setText("Desactivar");  
        btnDesactivar120.setEnabled(true);
        }
        else{
            btnDesactivar120.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar120.setText("Activar");
            btnDesactivar120.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar120.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoVehiculoAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoVehiculoAgregar()){
            temp.setPermisoSeccionTipoVehiculoAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoVehiculoAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoVehiculoAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoVehiculoAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoVehiculoAgregar()){
        btnDesactivar60.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar60.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar60.setText("Desactivar");  
        btnDesactivar60.setEnabled(true);
        }
        else{
            btnDesactivar60.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar60.setText("Activar");
            btnDesactivar60.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar60.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoVehiculoModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoVehiculoModificar()){
            temp.setPermisoSeccionTipoVehiculoModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoVehiculoModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoVehiculoModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoVehiculoModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoVehiculoModificar()){
        btnDesactivar121.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar121.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar121.setText("Desactivar");  
        btnDesactivar121.setEnabled(true);
        }
        else{
            btnDesactivar121.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar121.setText("Activar");
            btnDesactivar121.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar121.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoVehiculoDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoVehiculoDesactivar()){
            temp.setPermisoSeccionTipoVehiculoDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoVehiculoDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoVehiculoDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoVehiculoDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoVehiculoDesactivar()){
        btnDesactivar123.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar123.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar123.setText("Desactivar");  
        btnDesactivar123.setEnabled(true);
        }
        else{
            btnDesactivar123.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar123.setText("Activar");
            btnDesactivar123.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar123.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoVehiculoReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoVehiculoReportePdf()){
            temp.setPermisoSeccionTipoVehiculoReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoVehiculoReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoVehiculoReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoVehiculoReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoVehiculoReportePdf()){
        btnDesactivar122.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar122.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar122.setText("Desactivar");  
        btnDesactivar122.setEnabled(true);
        }
        else{
            btnDesactivar122.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar122.setText("Activar");
            btnDesactivar122.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar122.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoVehiculoReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoVehiculoReporteExcel()){
            temp.setPermisoSeccionTipoVehiculoReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoVehiculoReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoVehiculoReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoVehiculoReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoVehiculoReporteExcel()){
        btnDesactivar124.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar124.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar124.setText("Desactivar");  
        btnDesactivar124.setEnabled(true);
        }
        else{
            btnDesactivar124.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar124.setText("Activar");
            btnDesactivar124.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar124.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCabinaAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCabinaAgregar()){
            temp.setPermisoSeccionTipoCabinaAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCabinaAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCabinaAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCabinaAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCabinaAgregar()){
        btnDesactivar61.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar61.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar61.setText("Desactivar");  
        btnDesactivar61.setEnabled(true);
        }
        else{
            btnDesactivar61.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar61.setText("Activar");
            btnDesactivar61.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar61.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCabinaModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCabinaModificar()){
            temp.setPermisoSeccionTipoCabinaModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCabinaModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCabinaModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCabinaModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCabinaModificar()){
        btnDesactivar125.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar125.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar125.setText("Desactivar");  
        btnDesactivar125.setEnabled(true);
        }
        else{
            btnDesactivar125.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar125.setText("Activar");
            btnDesactivar125.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar125.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCabinaDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCabinaDesactivar()){
            temp.setPermisoSeccionTipoCabinaDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCabinaDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCabinaDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCabinaDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCabinaDesactivar()){
        btnDesactivar127.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar127.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar127.setText("Desactivar");  
        btnDesactivar127.setEnabled(true);
        }
        else{
            btnDesactivar127.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar127.setText("Activar");
            btnDesactivar127.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar127.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoCabinaReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCabinaReportePdf()){
            temp.setPermisoSeccionTipoCabinaReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCabinaReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCabinaReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCabinaReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCabinaReportePdf()){
        btnDesactivar126.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar126.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar126.setText("Desactivar");  
        btnDesactivar126.setEnabled(true);
        }
        else{
            btnDesactivar126.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar126.setText("Activar");
            btnDesactivar126.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar126.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCabinaReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCabinaReporteExcel()){
            temp.setPermisoSeccionTipoCabinaReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCabinaReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCabinaReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCabinaReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCabinaReporteExcel()){
        btnDesactivar128.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar128.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar128.setText("Desactivar");  
        btnDesactivar128.setEnabled(true);
        }
        else{
            btnDesactivar128.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar128.setText("Activar");
            btnDesactivar128.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar128.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCombustibleAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCombustibleAgregar()){
            temp.setPermisoSeccionTipoCombustibleAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCombustibleAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCombustibleAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCombustibleAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCombustibleAgregar()){
        btnDesactivar62.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar62.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar62.setText("Desactivar");  
        btnDesactivar62.setEnabled(true);
        }
        else{
            btnDesactivar62.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar62.setText("Activar");
            btnDesactivar62.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar62.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCombustibleModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCombustibleModificar()){
            temp.setPermisoSeccionTipoCombustibleModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCombustibleModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCombustibleModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCombustibleModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCombustibleModificar()){
        btnDesactivar129.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar129.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar129.setText("Desactivar");  
        btnDesactivar129.setEnabled(true);
        }
        else{
            btnDesactivar129.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar129.setText("Activar");
            btnDesactivar129.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar129.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCombustibleDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCombustibleDesactivar()){
            temp.setPermisoSeccionTipoCombustibleDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCombustibleDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCombustibleDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCombustibleDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCombustibleDesactivar()){
        btnDesactivar131.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar131.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar131.setText("Desactivar");  
        btnDesactivar131.setEnabled(true);
        }
        else{
            btnDesactivar131.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar131.setText("Activar");
            btnDesactivar131.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar131.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoCombustibleReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCombustibleReportePdf()){
            temp.setPermisoSeccionTipoCombustibleReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCombustibleReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCombustibleReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCombustibleReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCombustibleReportePdf()){
        btnDesactivar130.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar130.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar130.setText("Desactivar");  
        btnDesactivar130.setEnabled(true);
        }
        else{
            btnDesactivar130.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar130.setText("Activar");
            btnDesactivar130.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar130.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoCombustibleReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoCombustibleReporteExcel()){
            temp.setPermisoSeccionTipoCombustibleReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoCombustibleReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoCombustibleReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoCombustibleReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoCombustibleReporteExcel()){
        btnDesactivar132.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar132.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar132.setText("Desactivar");  
        btnDesactivar132.setEnabled(true);
        }
        else{
            btnDesactivar132.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar132.setText("Activar");
            btnDesactivar132.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar132.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionNumeroAsientosAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionNumeroAsientosAgregar()){
            temp.setPermisoSeccionNumeroAsientosAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionNumeroAsientosAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionNumeroAsientosAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionNumeroAsientosAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionNumeroAsientosAgregar()){
        btnDesactivar63.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar63.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar63.setText("Desactivar");  
        btnDesactivar63.setEnabled(true);
        }
        else{
            btnDesactivar63.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar63.setText("Activar");
            btnDesactivar63.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar63.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionNumeroAsientosModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionNumeroAsientosModificar()){
            temp.setPermisoSeccionNumeroAsientosModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionNumeroAsientosModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionNumeroAsientosModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionNumeroAsientosModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionNumeroAsientosModificar()){
        btnDesactivar133.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar133.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar133.setText("Desactivar");  
        btnDesactivar133.setEnabled(true);
        }
        else{
            btnDesactivar133.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar133.setText("Activar");
            btnDesactivar133.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar133.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionNumeroAsientosDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionNumeroAsientosDesactivar()){
            temp.setPermisoSeccionNumeroAsientosDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionNumeroAsientosDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionNumeroAsientosDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionNumeroAsientosDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionNumeroAsientosDesactivar()){
        btnDesactivar135.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar135.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar135.setText("Desactivar");  
        btnDesactivar135.setEnabled(true);
        }
        else{
            btnDesactivar135.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar135.setText("Activar");
            btnDesactivar135.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar135.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionNumeroAsientosReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionNumeroAsientosReportePdf()){
            temp.setPermisoSeccionNumeroAsientosReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionNumeroAsientosReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionNumeroAsientosReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionNumeroAsientosReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionNumeroAsientosReportePdf()){
        btnDesactivar134.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar134.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar134.setText("Desactivar");  
        btnDesactivar134.setEnabled(true);
        }
        else{
            btnDesactivar134.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar134.setText("Activar");
            btnDesactivar134.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar134.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionNumeroAsientosReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionNumeroAsientosReporteExcel()){
            temp.setPermisoSeccionNumeroAsientosReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionNumeroAsientosReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionNumeroAsientosReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionNumeroAsientosReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionNumeroAsientosReporteExcel()){
        btnDesactivar136.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar136.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar136.setText("Desactivar");  
        btnDesactivar136.setEnabled(true);
        }
        else{
            btnDesactivar136.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar136.setText("Activar");
            btnDesactivar136.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar136.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoTransmisionAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoTransmisionAgregar()){
            temp.setPermisoSeccionTipoTransmisionAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoTransmisionAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoTransmisionAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoTransmisionAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoTransmisionAgregar()){
        btnDesactivar64.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar64.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar64.setText("Desactivar");  
        btnDesactivar64.setEnabled(true);
        }
        else{
            btnDesactivar64.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar64.setText("Activar");
            btnDesactivar64.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar64.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoTransmisionModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoTransmisionModificar()){
            temp.setPermisoSeccionTipoTransmisionModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoTransmisionModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoTransmisionModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoTransmisionModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoTransmisionModificar()){
        btnDesactivar137.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar137.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar137.setText("Desactivar");  
        btnDesactivar137.setEnabled(true);
        }
        else{
            btnDesactivar137.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar137.setText("Activar");
            btnDesactivar137.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar137.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoTransmisionDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoTransmisionDesactivar()){
            temp.setPermisoSeccionTipoTransmisionDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoTransmisionDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoTransmisionDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoTransmisionDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoTransmisionDesactivar()){
        btnDesactivar139.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar139.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar139.setText("Desactivar");  
        btnDesactivar139.setEnabled(true);
        }
        else{
            btnDesactivar139.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar139.setText("Activar");
            btnDesactivar139.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar139.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoTransmisionReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoTransmisionReportePdf()){
            temp.setPermisoSeccionTipoTransmisionReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoTransmisionReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoTransmisionReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoTransmisionReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoTransmisionReportePdf()){
        btnDesactivar138.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar138.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar138.setText("Desactivar");  
        btnDesactivar138.setEnabled(true);
        }
        else{
            btnDesactivar138.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar138.setText("Activar");
            btnDesactivar138.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar138.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoTransmisionReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoTransmisionReporteExcel()){
            temp.setPermisoSeccionTipoTransmisionReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoTransmisionReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoTransmisionReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoTransmisionReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoTransmisionReporteExcel()){
        btnDesactivar140.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar140.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar140.setText("Desactivar");  
        btnDesactivar140.setEnabled(true);
        }
        else{
            btnDesactivar140.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar140.setText("Activar");
            btnDesactivar140.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar140.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionHistorialPreciosVehiculoBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialPreciosVehiculoBuscar()){
            temp.setPermisoSeccionHistorialPreciosVehiculoBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialPreciosVehiculoBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialPreciosVehiculoBuscar()){
        btnDesactivar118.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar118.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar118.setText("Desactivar");  
        btnDesactivar118.setEnabled(true);
        }
        else{
            btnDesactivar118.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar118.setText("Activar");
            btnDesactivar118.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar118.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialPreciosVehiculoReportePdf()){
            temp.setPermisoSeccionHistorialPreciosVehiculoReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialPreciosVehiculoReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialPreciosVehiculoReportePdf()){
        btnDesactivar117.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar117.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar117.setText("Desactivar");  
        btnDesactivar117.setEnabled(true);
        }
        else{
            btnDesactivar117.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar117.setText("Activar");
            btnDesactivar117.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar117.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionHistorialPreciosVehiculoReporteExcel()){
            temp.setPermisoSeccionHistorialPreciosVehiculoReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionHistorialPreciosVehiculoReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionHistorialPreciosVehiculoReporteExcel()){
        btnDesactivar119.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar119.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar119.setText("Desactivar");  
        btnDesactivar119.setEnabled(true);
        }
        else{
            btnDesactivar119.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar119.setText("Activar");
            btnDesactivar119.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar119.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBuscarVehiculoBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBuscarVehiculoBuscar()){
            temp.setPermisoSeccionBuscarVehiculoBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBuscarVehiculoBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBuscarVehiculoBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBuscarVehiculoBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBuscarVehiculoBuscar()){
        btnDesactivar112.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar112.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar112.setText("Desactivar");  
        btnDesactivar112.setEnabled(true);
        }
        else{
            btnDesactivar112.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar112.setText("Activar");
            btnDesactivar112.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar112.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionBuscarVehiculoReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBuscarVehiculoReportePdf()){
            temp.setPermisoSeccionBuscarVehiculoReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBuscarVehiculoReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBuscarVehiculoReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionBuscarVehiculoReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBuscarVehiculoReportePdf()){
        btnDesactivar111.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar111.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar111.setText("Desactivar");  
        btnDesactivar111.setEnabled(true);
        }
        else{
            btnDesactivar111.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar111.setText("Activar");
            btnDesactivar111.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar111.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionBuscarVehiculoExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionBuscarVehiculoExcel()){
            temp.setPermisoSeccionBuscarVehiculoExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionBuscarVehiculoExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionBuscarVehiculoExcel();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionBuscarVehiculoExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionBuscarVehiculoExcel()){
        btnDesactivar113.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar113.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar113.setText("Desactivar");  
        btnDesactivar113.setEnabled(true);
        }
        else{
            btnDesactivar113.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar113.setText("Activar");
            btnDesactivar113.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar113.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionVentasAgregarVehiculo() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVentasAgregarVehiculo()){
            temp.setPermisoSeccionVentasAgregarVehiculo(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVentasAgregarVehiculo(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVentasAgregarVehiculo();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionVentasAgregarVehiculo(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVentasAgregarVehiculo()){
        btnDesactivar65.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar65.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar65.setText("Desactivar");  
        btnDesactivar65.setEnabled(true);
        }
        else{
            btnDesactivar65.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar65.setText("Activar");
            btnDesactivar65.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar65.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionVentasAgregarPieza() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVentasAgregarPieza()){
            temp.setPermisoSeccionVentasAgregarPieza(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVentasAgregarPieza(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVentasAgregarPieza();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionVentasAgregarPieza(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVentasAgregarPieza()){
        btnDesactivar67.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar67.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar67.setText("Desactivar");  
        btnDesactivar67.setEnabled(true);
        }
        else{
            btnDesactivar67.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar67.setText("Activar");
            btnDesactivar67.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar67.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionVentasGenerarVenta() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVentasGenerarVenta()){
            temp.setPermisoSeccionVentasGenerarVenta(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVentasGenerarVenta(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVentasGenerarVenta();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionVentasGenerarVenta(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVentasGenerarVenta()){
        btnDesactivar69.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar69.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar69.setText("Desactivar");  
        btnDesactivar69.setEnabled(true);
        }
        else{
            btnDesactivar69.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar69.setText("Activar");
            btnDesactivar69.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar69.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionVentasBuscarPieza() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVentasBuscarPieza()){
            temp.setPermisoSeccionVentasBuscarPieza(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVentasBuscarPieza(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVentasBuscarPieza();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionVentasBuscarPieza(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVentasBuscarPieza()){
        btnDesactivar77.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar77.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar77.setText("Desactivar");  
        btnDesactivar77.setEnabled(true);
        }
        else{
            btnDesactivar77.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar77.setText("Activar");
            btnDesactivar77.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar77.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionVentasBuscarVehiculo() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionVentasBuscarVehiculo()){
            temp.setPermisoSeccionVentasBuscarVehiculo(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionVentasBuscarVehiculo(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionVentasBuscarVehiculo();

        return true;
        
}

public void btnActivarDesactivarPermisoSeccionVentasBuscarVehiculo(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionVentasBuscarVehiculo()){
        btnDesactivar78.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar78.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar78.setText("Desactivar");  
        btnDesactivar78.setEnabled(true);
        }
        else{
            btnDesactivar78.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar78.setText("Activar");
            btnDesactivar78.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar78.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoFacturaAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoFacturaAgregar()){
            temp.setPermisoSeccionTipoFacturaAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoFacturaAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoFacturaAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoFacturaAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoFacturaAgregar()){
        btnDesactivar70.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar70.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar70.setText("Desactivar");  
        btnDesactivar70.setEnabled(true);
        }
        else{
            btnDesactivar70.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar70.setText("Activar");
            btnDesactivar70.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar70.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoFacturaModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoFacturaModificar()){
            temp.setPermisoSeccionTipoFacturaModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoFacturaModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoFacturaModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoFacturaModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoFacturaModificar()){
        btnDesactivar144.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar144.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar144.setText("Desactivar");  
        btnDesactivar144.setEnabled(true);
        }
        else{
            btnDesactivar144.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar144.setText("Activar");
            btnDesactivar144.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar144.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoFacturaDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoFacturaDesactivar()){
            temp.setPermisoSeccionTipoFacturaDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoFacturaDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoFacturaDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoFacturaDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoFacturaDesactivar()){
        btnDesactivar146.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar146.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar146.setText("Desactivar");  
        btnDesactivar146.setEnabled(true);
        }
        else{
            btnDesactivar146.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar146.setText("Activar");
            btnDesactivar146.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar146.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoFacturaReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoFacturaReportePdf()){
            temp.setPermisoSeccionTipoFacturaReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoFacturaReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoFacturaReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoFacturaReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoFacturaReportePdf()){
        btnDesactivar145.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar145.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar145.setText("Desactivar");  
        btnDesactivar145.setEnabled(true);
        }
        else{
            btnDesactivar145.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar145.setText("Activar");
            btnDesactivar145.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar145.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoFacturaReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoFacturaReporteExcel()){
            temp.setPermisoSeccionTipoFacturaReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoFacturaReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoFacturaReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoFacturaReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoFacturaReporteExcel()){
        btnDesactivar147.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar147.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar147.setText("Desactivar");  
        btnDesactivar147.setEnabled(true);
        }
        else{
            btnDesactivar147.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar147.setText("Activar");
            btnDesactivar147.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar147.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoPagoAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPagoAgregar()){
            temp.setPermisoSeccionTipoPagoAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPagoAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPagoAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPagoAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPagoAgregar()){
        btnDesactivar72.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar72.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar72.setText("Desactivar");  
        btnDesactivar72.setEnabled(true);
        }
        else{
            btnDesactivar72.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar72.setText("Activar");
            btnDesactivar72.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar72.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoPagoModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPagoModificar()){
            temp.setPermisoSeccionTipoPagoModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPagoModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPagoModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPagoModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPagoModificar()){
        btnDesactivar152.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar152.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar152.setText("Desactivar");  
        btnDesactivar152.setEnabled(true);
        }
        else{
            btnDesactivar152.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar152.setText("Activar");
            btnDesactivar152.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar152.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoPagoDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPagoDesactivar()){
            temp.setPermisoSeccionTipoPagoDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPagoDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPagoDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPagoDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPagoDesactivar()){
        btnDesactivar154.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar154.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar154.setText("Desactivar");  
        btnDesactivar154.setEnabled(true);
        }
        else{
            btnDesactivar154.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar154.setText("Activar");
            btnDesactivar154.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar154.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionTipoPagoReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPagoReportePdf()){
            temp.setPermisoSeccionTipoPagoReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPagoReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPagoReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPagoReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPagoReportePdf()){
        btnDesactivar153.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar153.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar153.setText("Desactivar");  
        btnDesactivar153.setEnabled(true);
        }
        else{
            btnDesactivar153.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar153.setText("Activar");
            btnDesactivar153.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar153.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionTipoPagoReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionTipoPagoReporteExcel()){
            temp.setPermisoSeccionTipoPagoReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionTipoPagoReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionTipoPagoReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionTipoPagoReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionTipoPagoReporteExcel()){
        btnDesactivar155.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar155.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar155.setText("Desactivar");  
        btnDesactivar155.setEnabled(true);
        }
        else{
            btnDesactivar155.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar155.setText("Activar");
            btnDesactivar155.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar155.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionCaiAgregar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCaiAgregar()){
            temp.setPermisoSeccionCaiAgregar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCaiAgregar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCaiAgregar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCaiAgregar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCaiAgregar()){
        btnDesactivar71.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar71.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar71.setText("Desactivar");  
        btnDesactivar71.setEnabled(true);
        }
        else{
            btnDesactivar71.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar71.setText("Activar");
            btnDesactivar71.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar71.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionCaiModificar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCaiModificar()){
            temp.setPermisoSeccionCaiModificar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCaiModificar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCaiModificar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCaiModificar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCaiModificar()){
        btnDesactivar148.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar148.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar148.setText("Desactivar");  
        btnDesactivar148.setEnabled(true);
        }
        else{
            btnDesactivar148.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar148.setText("Activar");
            btnDesactivar148.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar148.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionCaiDesactivar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCaiDesactivar()){
            temp.setPermisoSeccionCaiDesactivar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCaiDesactivar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCaiDesactivar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCaiDesactivar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCaiDesactivar()){
        btnDesactivar150.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar150.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar150.setText("Desactivar");  
        btnDesactivar150.setEnabled(true);
        }
        else{
            btnDesactivar150.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar150.setText("Activar");
            btnDesactivar150.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar150.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionCaiReportePdf() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCaiReportePdf()){
            temp.setPermisoSeccionCaiReportePdf(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCaiReportePdf(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCaiReportePdf();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCaiReportePdf(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCaiReportePdf()){
        btnDesactivar149.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar149.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar149.setText("Desactivar");  
        btnDesactivar149.setEnabled(true);
        }
        else{
            btnDesactivar149.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar149.setText("Activar");
            btnDesactivar149.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar149.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionCaiReporteExcel() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionCaiReporteExcel()){
            temp.setPermisoSeccionCaiReporteExcel(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionCaiReporteExcel(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionCaiReporteExcel();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionCaiReporteExcel(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionCaiReporteExcel()){
        btnDesactivar151.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar151.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar151.setText("Desactivar");  
        btnDesactivar151.setEnabled(true);
        }
        else{
            btnDesactivar151.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar151.setText("Activar");
            btnDesactivar151.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar151.setEnabled(true);
        }
        }

public boolean DesactivarPermisoSeccionReporteReportePdfTabla() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionReporteReportePdfTabla()){
            temp.setPermisoSeccionReporteReportePdfTabla(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionReporteReportePdfTabla(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionReporteReportePdfTabla();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionReporteReportePdfTabla(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionReporteReportePdfTabla()){
        btnDesactivar68.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar68.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar68.setText("Desactivar");  
        btnDesactivar68.setEnabled(true);
        }
        else{
            btnDesactivar68.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar68.setText("Activar");
            btnDesactivar68.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar68.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionReporteBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionReporteBuscar()){
            temp.setPermisoSeccionReporteBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionReporteBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionReporteBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionReporteBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionReporteBuscar()){
        btnDesactivar151.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar66.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar66.setText("Desactivar");  
        btnDesactivar66.setEnabled(true);
        }
        else{
            btnDesactivar66.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar66.setText("Activar");
            btnDesactivar66.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar66.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionFacturasRechazadasBuscar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionFacturasRechazadasBuscar()){
            temp.setPermisoSeccionFacturasRechazadasBuscar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionFacturasRechazadasBuscar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionFacturasRechazadasBuscar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionFacturasRechazadasBuscar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionFacturasRechazadasBuscar()){
        btnDesactivar73.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar73.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar73.setText("Desactivar");  
        btnDesactivar73.setEnabled(true);
        }
        else{
            btnDesactivar73.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar73.setText("Activar");
            btnDesactivar73.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar73.setEnabled(true);
        }
        }
public boolean DesactivarPermisoSeccionFacturasRechazadasRechazar() throws Exception{
           Acceso temp;
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        if(temp.getPermisoSeccionFacturasRechazadasRechazar()){
            temp.setPermisoSeccionFacturasRechazadasRechazar(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setPermisoSeccionFacturasRechazadasRechazar(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        accesoDao.edit(temp);
        btnActivarDesactivarPermisoSeccionFacturasRechazadasRechazar();

        return true;
        
}
public void btnActivarDesactivarPermisoSeccionFacturasRechazadasRechazar(){
         Acceso temp = new  Acceso();
        temp = accesoDao.findAcceso(cmbIDAcceso.getSelectedIndex());
        
        if(temp.getPermisoSeccionFacturasRechazadasRechazar()){
        btnDesactivar156.setFont(new java.awt.Font("Tahoma", 1, 11));
        Color c = new Color(14, 209, 69);
        btnDesactivar156.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar156.setText("Desactivar");  
        btnDesactivar156.setEnabled(true);
        }
        else{
            btnDesactivar156.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar156.setText("Activar");
            btnDesactivar156.setBackground(new java.awt.Color(236, 28, 36));
            btnDesactivar156.setEnabled(true);
        }
        }
private  void createComboBoxAcceso(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDAcceso.setModel(modelo);
        List<Acceso> temp = accesoDao.findAccesoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getIdacceso());
        });
        }
    private void createCombousuario(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbUsuario.setModel(modelo);
        List<Acceso> temp = accesoDao.findAccesoEntities();
        List<Usuarios> temp2 = UsuariosDao.findUsuariosEntities();
        modelo.addElement("Seleccione...");
        for(Acceso tpp: temp){
            for(Usuarios tp: temp2){
                if(tpp.getIdUsuario()==tp.getId_Usuario()){
            modelo.addElement(tp.getId_Nombre()); 
                }
            }
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

        jScrollPane3 = new javax.swing.JScrollPane();
        tblAcceso = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        cmbUsuario = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbIDAcceso = new javax.swing.JComboBox<>();
        btnBuscar2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        btnDesactivar = new javax.swing.JButton();
        btnDesactivar1 = new javax.swing.JButton();
        btnDesactivar5 = new javax.swing.JButton();
        btnDesactivar4 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        btnDesactivar3 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        btnDesactivar6 = new javax.swing.JButton();
        btnDesactivar2 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        btnDesactivar7 = new javax.swing.JButton();
        btnDesactivar8 = new javax.swing.JButton();
        btnDesactivar40 = new javax.swing.JButton();
        btnDesactivar41 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        btnDesactivar42 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        btnDesactivar44 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        btnDesactivar46 = new javax.swing.JButton();
        btnDesactivar80 = new javax.swing.JButton();
        btnDesactivar82 = new javax.swing.JButton();
        jLabel126 = new javax.swing.JLabel();
        btnDesactivar83 = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        btnDesactivar84 = new javax.swing.JButton();
        jLabel128 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        btnDesactivar81 = new javax.swing.JButton();
        jLabel129 = new javax.swing.JLabel();
        btnDesactivar85 = new javax.swing.JButton();
        jLabel130 = new javax.swing.JLabel();
        btnDesactivar86 = new javax.swing.JButton();
        jLabel131 = new javax.swing.JLabel();
        btnDesactivar87 = new javax.swing.JButton();
        btnDesactivar88 = new javax.swing.JButton();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        btnDesactivar89 = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        btnDesactivar90 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        btnDesactivar94 = new javax.swing.JButton();
        jLabel141 = new javax.swing.JLabel();
        btnDesactivar96 = new javax.swing.JButton();
        jLabel142 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        btnDesactivar97 = new javax.swing.JButton();
        jLabel145 = new javax.swing.JLabel();
        btnDesactivar99 = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        btnDesactivar13 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        btnDesactivar23 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        btnDesactivar24 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        btnDesactivar25 = new javax.swing.JButton();
        btnDesactivar26 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        btnDesactivar27 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        btnDesactivar28 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        btnDesactivar29 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        btnDesactivar31 = new javax.swing.JButton();
        btnDesactivar32 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        btnDesactivar34 = new javax.swing.JButton();
        btnDesactivar74 = new javax.swing.JButton();
        jLabel95 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        btnDesactivar9 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        btnDesactivar10 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        btnDesactivar14 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        btnDesactivar15 = new javax.swing.JButton();
        btnDesactivar16 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        btnDesactivar19 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        btnDesactivar11 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        btnDesactivar12 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        btnDesactivar17 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        btnDesactivar18 = new javax.swing.JButton();
        btnDesactivar20 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btnDesactivar21 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        btnDesactivar22 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        btnDesactivar30 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        btnDesactivar33 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        btnDesactivar35 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        btnDesactivar36 = new javax.swing.JButton();
        btnDesactivar37 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnDesactivar39 = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        btnDesactivar43 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        btnDesactivar45 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        btnDesactivar47 = new javax.swing.JButton();
        btnDesactivar48 = new javax.swing.JButton();
        btnDesactivar50 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        btnDesactivar51 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        btnDesactivar52 = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel167 = new javax.swing.JLabel();
        btnDesactivar114 = new javax.swing.JButton();
        btnDesactivar115 = new javax.swing.JButton();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        btnDesactivar116 = new javax.swing.JButton();
        jLabel170 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        btnDesactivar49 = new javax.swing.JButton();
        btnDesactivar91 = new javax.swing.JButton();
        btnDesactivar92 = new javax.swing.JButton();
        jLabel148 = new javax.swing.JLabel();
        btnDesactivar93 = new javax.swing.JButton();
        jLabel149 = new javax.swing.JLabel();
        btnDesactivar100 = new javax.swing.JButton();
        jLabel150 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        btnDesactivar108 = new javax.swing.JButton();
        btnDesactivar109 = new javax.swing.JButton();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        btnDesactivar110 = new javax.swing.JButton();
        jLabel162 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel27 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        btnDesactivar53 = new javax.swing.JButton();
        btnDesactivar54 = new javax.swing.JButton();
        btnDesactivar55 = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        btnDesactivar56 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        btnDesactivar57 = new javax.swing.JButton();
        jLabel151 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        btnDesactivar117 = new javax.swing.JButton();
        btnDesactivar118 = new javax.swing.JButton();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        btnDesactivar119 = new javax.swing.JButton();
        jLabel174 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        btnDesactivar58 = new javax.swing.JButton();
        btnDesactivar101 = new javax.swing.JButton();
        btnDesactivar102 = new javax.swing.JButton();
        jLabel155 = new javax.swing.JLabel();
        btnDesactivar103 = new javax.swing.JButton();
        jLabel156 = new javax.swing.JLabel();
        btnDesactivar104 = new javax.swing.JButton();
        jLabel157 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        btnDesactivar59 = new javax.swing.JButton();
        btnDesactivar105 = new javax.swing.JButton();
        btnDesactivar106 = new javax.swing.JButton();
        jLabel177 = new javax.swing.JLabel();
        btnDesactivar107 = new javax.swing.JButton();
        jLabel178 = new javax.swing.JLabel();
        btnDesactivar120 = new javax.swing.JButton();
        jLabel179 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        btnDesactivar60 = new javax.swing.JButton();
        btnDesactivar121 = new javax.swing.JButton();
        btnDesactivar122 = new javax.swing.JButton();
        jLabel183 = new javax.swing.JLabel();
        btnDesactivar123 = new javax.swing.JButton();
        jLabel184 = new javax.swing.JLabel();
        btnDesactivar124 = new javax.swing.JButton();
        jLabel185 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        btnDesactivar61 = new javax.swing.JButton();
        btnDesactivar125 = new javax.swing.JButton();
        btnDesactivar126 = new javax.swing.JButton();
        jLabel189 = new javax.swing.JLabel();
        btnDesactivar127 = new javax.swing.JButton();
        jLabel190 = new javax.swing.JLabel();
        btnDesactivar128 = new javax.swing.JButton();
        jLabel191 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        btnDesactivar62 = new javax.swing.JButton();
        btnDesactivar129 = new javax.swing.JButton();
        btnDesactivar130 = new javax.swing.JButton();
        jLabel195 = new javax.swing.JLabel();
        btnDesactivar131 = new javax.swing.JButton();
        jLabel196 = new javax.swing.JLabel();
        btnDesactivar132 = new javax.swing.JButton();
        jLabel197 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        btnDesactivar63 = new javax.swing.JButton();
        btnDesactivar133 = new javax.swing.JButton();
        btnDesactivar134 = new javax.swing.JButton();
        jLabel201 = new javax.swing.JLabel();
        btnDesactivar135 = new javax.swing.JButton();
        jLabel202 = new javax.swing.JLabel();
        btnDesactivar136 = new javax.swing.JButton();
        jLabel203 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        btnDesactivar64 = new javax.swing.JButton();
        btnDesactivar137 = new javax.swing.JButton();
        btnDesactivar138 = new javax.swing.JButton();
        jLabel207 = new javax.swing.JLabel();
        btnDesactivar139 = new javax.swing.JButton();
        jLabel208 = new javax.swing.JLabel();
        btnDesactivar140 = new javax.swing.JButton();
        jLabel209 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        btnDesactivar111 = new javax.swing.JButton();
        btnDesactivar112 = new javax.swing.JButton();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        btnDesactivar113 = new javax.swing.JButton();
        jLabel166 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        btnDesactivar66 = new javax.swing.JButton();
        btnDesactivar68 = new javax.swing.JButton();
        jLabel210 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        btnDesactivar65 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        btnDesactivar67 = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        btnDesactivar69 = new javax.swing.JButton();
        jLabel93 = new javax.swing.JLabel();
        btnDesactivar77 = new javax.swing.JButton();
        btnDesactivar78 = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        btnDesactivar70 = new javax.swing.JButton();
        btnDesactivar144 = new javax.swing.JButton();
        btnDesactivar145 = new javax.swing.JButton();
        jLabel218 = new javax.swing.JLabel();
        btnDesactivar146 = new javax.swing.JButton();
        jLabel219 = new javax.swing.JLabel();
        btnDesactivar147 = new javax.swing.JButton();
        jLabel220 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        btnDesactivar71 = new javax.swing.JButton();
        btnDesactivar148 = new javax.swing.JButton();
        btnDesactivar149 = new javax.swing.JButton();
        jLabel224 = new javax.swing.JLabel();
        btnDesactivar150 = new javax.swing.JButton();
        jLabel225 = new javax.swing.JLabel();
        btnDesactivar151 = new javax.swing.JButton();
        jLabel226 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        btnDesactivar72 = new javax.swing.JButton();
        btnDesactivar152 = new javax.swing.JButton();
        btnDesactivar153 = new javax.swing.JButton();
        jLabel230 = new javax.swing.JLabel();
        btnDesactivar154 = new javax.swing.JButton();
        jLabel231 = new javax.swing.JLabel();
        btnDesactivar155 = new javax.swing.JButton();
        jLabel232 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        btnDesactivar73 = new javax.swing.JButton();
        btnDesactivar156 = new javax.swing.JButton();
        jLabel238 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAcceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Acceso", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAcceso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccesoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblAcceso);
        if (tblAcceso.getColumnModel().getColumnCount() > 0) {
            tblAcceso.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon("C:\\CarSoft-Version-2.1\\src\\main\\resources\\Img\\Salir.png")); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cmbUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUsuarioItemStateChanged(evt);
            }
        });
        cmbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuarioActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Usuario:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ID Acceso:");

        cmbIDAcceso.setEnabled(false);
        cmbIDAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDAccesoActionPerformed(evt);
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

        jLabel15.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Panel de Seguridad");

        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Permisos de la Pantalla Menú");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(360, 10, 257, 35);

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Clientes");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Empleados");

        jLabel50.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Pedidos");

        jLabel51.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Bancos");

        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
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

        btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar5.setText("Desactivar");
        btnDesactivar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar5ActionPerformed(evt);
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

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Vehículos");

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Piezas");

        btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar6.setText("Desactivar");
        btnDesactivar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar6ActionPerformed(evt);
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

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Ventas");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnDesactivar3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel27))
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar4))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDesactivar)
                            .addComponent(btnDesactivar3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDesactivar5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar1)))
                    .addComponent(jLabel48))
                .addGap(42, 42, 42)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar2)
                .addGap(42, 42, 42))
        );

        jPanel1.add(jPanel11);
        jPanel11.setBounds(190, 80, 590, 360);

        jTabbedPane1.addTab("Menú", jPanel1);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Permisos de la Pantalla Empleados");

        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel16.setLayout(null);

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel71.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Agregar");

        jLabel72.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Modificar");

        jLabel73.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Buscar");

        jLabel75.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Desactivar");

        btnDesactivar7.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar7.setText("Desactivar");
        btnDesactivar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar7ActionPerformed(evt);
            }
        });

        btnDesactivar8.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar8.setText("Desactivar");
        btnDesactivar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar8ActionPerformed(evt);
            }
        });

        btnDesactivar40.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar40.setText("Desactivar");
        btnDesactivar40.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar40ActionPerformed(evt);
            }
        });

        btnDesactivar41.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar41.setText("Desactivar");
        btnDesactivar41.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar41ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Generar Reporte PDF");

        btnDesactivar42.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar42.setText("Desactivar");
        btnDesactivar42.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar42ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Generar Reporte Excel");

        btnDesactivar44.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar44.setText("Desactivar");
        btnDesactivar44.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar44ActionPerformed(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("Sección Empleados");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDesactivar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar42, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar41, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnDesactivar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnDesactivar40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDesactivar44, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel121)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar7)))
                .addGap(54, 54, 54)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar8))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar41))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel17);
        jPanel17.setBounds(210, 10, 480, 400);

        jTabbedPane2.addTab("Empleados", jPanel16);

        jPanel28.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel122.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("Agregar");

        jLabel123.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("Modificar");

        jLabel125.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Desactivar");

        btnDesactivar46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar46.setText("Desactivar");
        btnDesactivar46.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar46ActionPerformed(evt);
            }
        });

        btnDesactivar80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar80.setText("Desactivar");
        btnDesactivar80.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar80ActionPerformed(evt);
            }
        });

        btnDesactivar82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar82.setText("Desactivar");
        btnDesactivar82.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar82ActionPerformed(evt);
            }
        });

        jLabel126.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("Generar Reporte PDF");

        btnDesactivar83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar83.setText("Desactivar");
        btnDesactivar83.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar83ActionPerformed(evt);
            }
        });

        jLabel127.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("Generar Reporte Excel");

        btnDesactivar84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar84.setText("Desactivar");
        btnDesactivar84.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar84ActionPerformed(evt);
            }
        });

        jLabel128.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setText("Sección Cargos");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDesactivar46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar83, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar82, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar84, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel128)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel125)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar46)))
                .addGap(57, 57, 57)
                .addComponent(jLabel123)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar80)
                .addGap(45, 45, 45)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel126)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar82))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel127)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Cargos", jPanel18);

        jPanel29.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel124.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setText("Agregar");

        btnDesactivar81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar81.setText("Desactivar");
        btnDesactivar81.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar81ActionPerformed(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("Modificar");

        btnDesactivar85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar85.setText("Desactivar");
        btnDesactivar85.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar85ActionPerformed(evt);
            }
        });

        jLabel130.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("Buscar Empleado");

        btnDesactivar86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar86.setText("Desactivar");
        btnDesactivar86.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar86ActionPerformed(evt);
            }
        });

        jLabel131.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("Generar Reporte PDF");

        btnDesactivar87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar87.setText("Desactivar");
        btnDesactivar87.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar87ActionPerformed(evt);
            }
        });

        btnDesactivar88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar88.setText("Desactivar");
        btnDesactivar88.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar88ActionPerformed(evt);
            }
        });

        jLabel132.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("Buscar Usuario");

        jLabel133.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("Generar Reporte Excel");

        btnDesactivar89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar89.setText("Desactivar");
        btnDesactivar89.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar89ActionPerformed(evt);
            }
        });

        jLabel134.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setText("Sección Usuarios");

        jLabel135.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setText("Desactivar");

        btnDesactivar90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar90.setText("Desactivar");
        btnDesactivar90.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar90ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar81)
                            .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar85)
                            .addComponent(btnDesactivar90)
                            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar88)
                            .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar87)
                            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar89)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel134))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar86))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar85)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar81)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel129)
                                .addGap(45, 45, 45)))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel135)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar90))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel132)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar88)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel131)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar87)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel133)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar89)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel130)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar86)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(247, 247, 247)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(247, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane2.addTab("Usuarios", jPanel19);

        jPanel30.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel139.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel139.setText("Generar Reporte PDF");

        btnDesactivar94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar94.setText("Desactivar");
        btnDesactivar94.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar94ActionPerformed(evt);
            }
        });

        jLabel141.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setText("Generar Reporte Excel");

        btnDesactivar96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar96.setText("Desactivar");
        btnDesactivar96.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar96ActionPerformed(evt);
            }
        });

        jLabel142.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setText("Sección Historial de Sueldos");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar94)
                    .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar96))
                .addGap(124, 124, 124))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel139)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar94)
                .addGap(36, 36, 36)
                .addComponent(jLabel141)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar96)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane2.addTab("Historial de Sueldos", jPanel22);

        jPanel31.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel143.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 255, 255));
        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel143.setText("Generar Reporte PDF");

        btnDesactivar97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar97.setText("Desactivar");
        btnDesactivar97.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar97ActionPerformed(evt);
            }
        });

        jLabel145.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 255, 255));
        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel145.setText("Generar Reporte Excel");

        btnDesactivar99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar99.setText("Desactivar");
        btnDesactivar99.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar99ActionPerformed(evt);
            }
        });

        jLabel146.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 255, 255));
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel146.setText("Sección Historial de Cargos");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar97)
                    .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar99))
                .addGap(122, 122, 122))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel143)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar97)
                .addGap(36, 36, 36)
                .addComponent(jLabel145)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar99)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane2.addTab("Historial de Cargos", jPanel25);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(313, 313, 313))
            .addComponent(jTabbedPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel2);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Permisos de la Pantalla Clientes");

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Agregar");

        btnDesactivar13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar13.setText("Desactivar");
        btnDesactivar13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar13ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Modificar");

        btnDesactivar23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar23.setText("Desactivar");
        btnDesactivar23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar23ActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Desactivar");

        btnDesactivar24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar24.setText("Desactivar");
        btnDesactivar24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar24ActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Generar Reporte PDF");

        btnDesactivar25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar25.setText("Desactivar");
        btnDesactivar25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar25ActionPerformed(evt);
            }
        });

        btnDesactivar26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar26.setText("Desactivar");
        btnDesactivar26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar26ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Buscar");

        jLabel56.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Generar Reporte Excel");

        btnDesactivar27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar27.setText("Desactivar");
        btnDesactivar27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar27ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Sección Clientes");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar13)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar23)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar24))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar26)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar25)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar27)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel57)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar23)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar13)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel52)
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel55)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar26)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel54)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar25)))
                .addGap(36, 36, 36)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesactivar24)
                    .addComponent(btnDesactivar27))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Agregar");

        btnDesactivar28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar28.setText("Desactivar");
        btnDesactivar28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar28ActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Modificar");

        btnDesactivar29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar29.setText("Desactivar");
        btnDesactivar29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar29ActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Generar Reporte PDF");

        btnDesactivar31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar31.setText("Desactivar");
        btnDesactivar31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar31ActionPerformed(evt);
            }
        });

        btnDesactivar32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar32.setText("Desactivar");
        btnDesactivar32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar32ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Generar Reporte Excel");

        jLabel64.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Sección Tipo de Documento");

        jLabel65.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Desactivar");

        btnDesactivar34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar34.setText("Desactivar");
        btnDesactivar34.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar34ActionPerformed(evt);
            }
        });

        btnDesactivar74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar74.setText("Desactivar");
        btnDesactivar74.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar74ActionPerformed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Desactivar");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar28)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar29))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar32)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar31)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar34)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar74))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel64)
                .addGap(71, 71, 71))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar29)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar28)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel59)
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel61)
                        .addGap(10, 10, 10)
                        .addComponent(btnDesactivar32)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar31)))
                .addGap(39, 39, 39)
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar74)
                .addGap(143, 143, 143)
                .addComponent(jLabel65)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(330, 330, 330))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Permisos de la Pantalla Bancos");

        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Agregar");

        btnDesactivar9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar9.setText("Desactivar");
        btnDesactivar9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar9ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Modificar");

        btnDesactivar10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar10.setText("Desactivar");
        btnDesactivar10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar10ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Desactivar");

        btnDesactivar14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar14.setText("Desactivar");
        btnDesactivar14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar14ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Generar Reporte PDF");

        btnDesactivar15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar15.setText("Desactivar");
        btnDesactivar15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar15ActionPerformed(evt);
            }
        });

        btnDesactivar16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar16.setText("Desactivar");
        btnDesactivar16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar16ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Buscar");

        jLabel42.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Generar Reporte Excel");

        btnDesactivar19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar19.setText("Desactivar");
        btnDesactivar19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar19ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Sección Bancos");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar9)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar10)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar14))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar16)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar15)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar19)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel35)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar10)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar9)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel33)
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar16)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel38)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar15)))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesactivar14)
                    .addComponent(btnDesactivar19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Agregar");

        btnDesactivar11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar11.setText("Desactivar");
        btnDesactivar11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar11ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Modificar");

        btnDesactivar12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar12.setText("Desactivar");
        btnDesactivar12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar12ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Buscar Cliente");

        btnDesactivar17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar17.setText("Desactivar");
        btnDesactivar17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar17ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Generar Reporte PDF");

        btnDesactivar18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar18.setText("Desactivar");
        btnDesactivar18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar18ActionPerformed(evt);
            }
        });

        btnDesactivar20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar20.setText("Desactivar");
        btnDesactivar20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar20ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Buscar Banco");

        jLabel44.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Generar Reporte Excel");

        btnDesactivar21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar21.setText("Desactivar");
        btnDesactivar21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar21ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Sección Préstamos");

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Desactivar");

        btnDesactivar22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar22.setText("Desactivar");
        btnDesactivar22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar11)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar12)
                            .addComponent(btnDesactivar22)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar20)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar18)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar21)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel45))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar17))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar12)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar11)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel36)
                                .addGap(45, 45, 45)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel46)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar22)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar20)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel41)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar18)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar17)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(305, 305, 305))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Bancos", jPanel7);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Permisos de la Pantalla Pedidos");

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Agregar Vehículo");

        btnDesactivar30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar30.setText("Desactivar");
        btnDesactivar30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar30ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Agregar pieza");

        btnDesactivar33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar33.setText("Desactivar");
        btnDesactivar33.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar33ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Agregar Pedido");

        btnDesactivar35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar35.setText("Desactivar");
        btnDesactivar35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar35ActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Buscar Pieza");

        btnDesactivar36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar36.setText("Desactivar");
        btnDesactivar36.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar36ActionPerformed(evt);
            }
        });

        btnDesactivar37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar37.setText("Desactivar");
        btnDesactivar37.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar37ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Buscar vehículo");

        jLabel70.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Sección Pedidos");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar30)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar33))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar37)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar36)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel70))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar35))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar33)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar30)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel62)
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar37)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel67)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar36)))
                .addGap(37, 37, 37)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar35)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        btnDesactivar39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar39.setText("Desactivar");
        btnDesactivar39.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar39ActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Generar Reporte PDF");

        btnDesactivar43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar43.setText("Desactivar");
        btnDesactivar43.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar43ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Generar Reporte Excel");

        jLabel77.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Sección Listado de Pedidos");

        jLabel78.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Desactivar");

        btnDesactivar45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar45.setText("Desactivar");
        btnDesactivar45.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar45ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel77)
                .addGap(82, 82, 82))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar39)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar43)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar45)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(jLabel76))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar39))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnDesactivar43)))
                .addGap(32, 32, 32)
                .addComponent(jLabel78)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(302, 302, 302))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel8);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Permisos de la Pantalla Piezas");

        jTabbedPane3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel20.setLayout(null);

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel79.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Agregar");

        jLabel80.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Modificar");

        jLabel82.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Desactivar");

        btnDesactivar47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar47.setText("Desactivar");
        btnDesactivar47.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar47ActionPerformed(evt);
            }
        });

        btnDesactivar48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar48.setText("Desactivar");
        btnDesactivar48.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar48ActionPerformed(evt);
            }
        });

        btnDesactivar50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar50.setText("Desactivar");
        btnDesactivar50.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar50ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Generar Reporte PDF");

        btnDesactivar51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar51.setText("Desactivar");
        btnDesactivar51.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar51ActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Generar Reporte Excel");

        btnDesactivar52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar52.setText("Desactivar");
        btnDesactivar52.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar52ActionPerformed(evt);
            }
        });

        jLabel136.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel136.setText("Sección Piezas");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDesactivar47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar51, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar50, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar52, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel136, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar47)))
                .addGap(55, 55, 55)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar48)
                .addGap(47, 47, 47)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar50))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel21);
        jPanel21.setBounds(210, 10, 480, 400);

        jTabbedPane3.addTab("Piezas", jPanel20);

        jPanel36.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel167.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(255, 255, 255));
        jLabel167.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel167.setText("Generar Reporte PDF");

        btnDesactivar114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar114.setText("Desactivar");
        btnDesactivar114.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar114ActionPerformed(evt);
            }
        });

        btnDesactivar115.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar115.setText("Desactivar");
        btnDesactivar115.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar115ActionPerformed(evt);
            }
        });

        jLabel168.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 255, 255));
        jLabel168.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel168.setText("Buscar por Combobox");

        jLabel169.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 255, 255));
        jLabel169.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel169.setText("Generar Reporte Excel");

        btnDesactivar116.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar116.setText("Desactivar");
        btnDesactivar116.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar116ActionPerformed(evt);
            }
        });

        jLabel170.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel170.setText("Sección Historial de Precios");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel170, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesactivar115)
                    .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar114)
                    .addComponent(jLabel169, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar116))
                .addGap(122, 122, 122))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel168)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar115)
                .addGap(35, 35, 35)
                .addComponent(jLabel167)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar114)
                .addGap(36, 36, 36)
                .addComponent(jLabel169)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar116)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane3.addTab("Historial de Precios", jPanel23);

        jPanel32.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel137.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel137.setText("Agregar");

        jLabel138.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel138.setText("Modificar");

        jLabel147.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 255, 255));
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel147.setText("Desactivar");

        btnDesactivar49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar49.setText("Desactivar");
        btnDesactivar49.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar49ActionPerformed(evt);
            }
        });

        btnDesactivar91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar91.setText("Desactivar");
        btnDesactivar91.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar91ActionPerformed(evt);
            }
        });

        btnDesactivar92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar92.setText("Desactivar");
        btnDesactivar92.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar92ActionPerformed(evt);
            }
        });

        jLabel148.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 255, 255));
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel148.setText("Generar Reporte PDF");

        btnDesactivar93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar93.setText("Desactivar");
        btnDesactivar93.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar93ActionPerformed(evt);
            }
        });

        jLabel149.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel149.setText("Generar Reporte Excel");

        btnDesactivar100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar100.setText("Desactivar");
        btnDesactivar100.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar100ActionPerformed(evt);
            }
        });

        jLabel150.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel150.setText("Sección Tipo de Pieza");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar93, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar92, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar100, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel150, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel147)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel137)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar49)))
                .addGap(57, 57, 57)
                .addComponent(jLabel138)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar91)
                .addGap(45, 45, 45)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel148)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar92))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel149)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("Tipo de Pieza", jPanel24);

        jPanel34.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel159.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 255, 255));
        jLabel159.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel159.setText("Generar Reporte PDF");

        btnDesactivar108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar108.setText("Desactivar");
        btnDesactivar108.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar108ActionPerformed(evt);
            }
        });

        btnDesactivar109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar109.setText("Desactivar");
        btnDesactivar109.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar109ActionPerformed(evt);
            }
        });

        jLabel160.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel160.setText("Buscar");

        jLabel161.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("Generar Reporte Excel");

        btnDesactivar110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar110.setText("Desactivar");
        btnDesactivar110.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar110ActionPerformed(evt);
            }
        });

        jLabel162.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 255, 255));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel162.setText("Sección Buscar Pieza");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel162, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesactivar109)
                    .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar108)
                    .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar110))
                .addGap(122, 122, 122))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel160)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar109)
                .addGap(35, 35, 35)
                .addComponent(jLabel159)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar108)
                .addGap(36, 36, 36)
                .addComponent(jLabel161)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar110)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane3.addTab("Buscar Pieza", jPanel26);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Piezas", jPanel4);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Permisos de la Pantalla Vehículos");

        jTabbedPane4.setForeground(new java.awt.Color(255, 255, 255));

        jPanel27.setLayout(null);

        jPanel33.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel81.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Agregar");

        jLabel84.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Modificar");

        jLabel85.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Desactivar");

        btnDesactivar53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar53.setText("Desactivar");
        btnDesactivar53.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar53ActionPerformed(evt);
            }
        });

        btnDesactivar54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar54.setText("Desactivar");
        btnDesactivar54.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar54ActionPerformed(evt);
            }
        });

        btnDesactivar55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar55.setText("Desactivar");
        btnDesactivar55.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar55ActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Generar Reporte PDF");

        btnDesactivar56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar56.setText("Desactivar");
        btnDesactivar56.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar56ActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Generar Reporte Excel");

        btnDesactivar57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar57.setText("Desactivar");
        btnDesactivar57.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar57ActionPerformed(evt);
            }
        });

        jLabel151.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel151.setText("Sección Vehículos");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDesactivar53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar56, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar55, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDesactivar57, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel151, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel85)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar53)))
                .addGap(55, 55, 55)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar54)
                .addGap(47, 47, 47)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar55))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel27.add(jPanel33);
        jPanel33.setBounds(210, 10, 480, 400);

        jTabbedPane4.addTab("Vehículos", jPanel27);

        jPanel37.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel171.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setText("Generar Reporte PDF");

        btnDesactivar117.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar117.setText("Desactivar");
        btnDesactivar117.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar117ActionPerformed(evt);
            }
        });

        btnDesactivar118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar118.setText("Desactivar");
        btnDesactivar118.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar118ActionPerformed(evt);
            }
        });

        jLabel172.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel172.setText("Buscar por Combobox");

        jLabel173.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel173.setText("Generar Reporte Excel");

        btnDesactivar119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar119.setText("Desactivar");
        btnDesactivar119.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar119ActionPerformed(evt);
            }
        });

        jLabel174.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel174.setText("Sección Historial de Precios");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel174, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesactivar118)
                    .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar117)
                    .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar119))
                .addGap(122, 122, 122))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel172)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar118)
                .addGap(35, 35, 35)
                .addComponent(jLabel171)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar117)
                .addGap(36, 36, 36)
                .addComponent(jLabel173)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar119)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane4.addTab("Historial de Precios", jPanel35);

        jPanel39.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel152.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 255, 255));
        jLabel152.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel152.setText("Agregar");

        jLabel153.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel153.setText("Modificar");

        jLabel154.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(255, 255, 255));
        jLabel154.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel154.setText("Desactivar");

        btnDesactivar58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar58.setText("Desactivar");
        btnDesactivar58.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar58ActionPerformed(evt);
            }
        });

        btnDesactivar101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar101.setText("Desactivar");
        btnDesactivar101.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar101ActionPerformed(evt);
            }
        });

        btnDesactivar102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar102.setText("Desactivar");
        btnDesactivar102.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar102ActionPerformed(evt);
            }
        });

        jLabel155.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 255, 255));
        jLabel155.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel155.setText("Generar Reporte PDF");

        btnDesactivar103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar103.setText("Desactivar");
        btnDesactivar103.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar103ActionPerformed(evt);
            }
        });

        jLabel156.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 255, 255));
        jLabel156.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel156.setText("Generar Reporte Excel");

        btnDesactivar104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar104.setText("Desactivar");
        btnDesactivar104.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar104ActionPerformed(evt);
            }
        });

        jLabel157.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(255, 255, 255));
        jLabel157.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel157.setText("Sección Marca");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar103, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar102, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar104, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel157, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel154)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel152)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar58)))
                .addGap(57, 57, 57)
                .addComponent(jLabel153)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar101)
                .addGap(45, 45, 45)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel155)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar102))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel156)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar104, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Marca", jPanel38);

        jPanel48.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel158.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 255, 255));
        jLabel158.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel158.setText("Agregar");

        jLabel175.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel175.setText("Modificar");

        jLabel176.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(255, 255, 255));
        jLabel176.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel176.setText("Desactivar");

        btnDesactivar59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar59.setText("Desactivar");
        btnDesactivar59.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar59ActionPerformed(evt);
            }
        });

        btnDesactivar105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar105.setText("Desactivar");
        btnDesactivar105.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar105ActionPerformed(evt);
            }
        });

        btnDesactivar106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar106.setText("Desactivar");
        btnDesactivar106.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar106ActionPerformed(evt);
            }
        });

        jLabel177.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(255, 255, 255));
        jLabel177.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel177.setText("Generar Reporte PDF");

        btnDesactivar107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar107.setText("Desactivar");
        btnDesactivar107.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar107ActionPerformed(evt);
            }
        });

        jLabel178.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(255, 255, 255));
        jLabel178.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel178.setText("Generar Reporte Excel");

        btnDesactivar120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar120.setText("Desactivar");
        btnDesactivar120.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar120ActionPerformed(evt);
            }
        });

        jLabel179.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 255, 255));
        jLabel179.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel179.setText("Sección Color");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar107, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel177, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar106, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar120, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel179, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel179, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel176)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel158)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar59)))
                .addGap(57, 57, 57)
                .addComponent(jLabel175)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar105)
                .addGap(45, 45, 45)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel177)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar106))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel178)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar120, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel47Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel47Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Color", jPanel47);

        jPanel49.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel180.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 255, 255));
        jLabel180.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel180.setText("Agregar");

        jLabel181.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(255, 255, 255));
        jLabel181.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel181.setText("Modificar");

        jLabel182.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(255, 255, 255));
        jLabel182.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel182.setText("Desactivar");

        btnDesactivar60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar60.setText("Desactivar");
        btnDesactivar60.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar60ActionPerformed(evt);
            }
        });

        btnDesactivar121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar121.setText("Desactivar");
        btnDesactivar121.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar121ActionPerformed(evt);
            }
        });

        btnDesactivar122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar122.setText("Desactivar");
        btnDesactivar122.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar122ActionPerformed(evt);
            }
        });

        jLabel183.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 255, 255));
        jLabel183.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel183.setText("Generar Reporte PDF");

        btnDesactivar123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar123.setText("Desactivar");
        btnDesactivar123.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar123ActionPerformed(evt);
            }
        });

        jLabel184.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(255, 255, 255));
        jLabel184.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel184.setText("Generar Reporte Excel");

        btnDesactivar124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar124.setText("Desactivar");
        btnDesactivar124.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar124ActionPerformed(evt);
            }
        });

        jLabel185.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(255, 255, 255));
        jLabel185.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel185.setText("Sección Tipo de Vehículo");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel181, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar123, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar122, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar124, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel185, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel182)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel180)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar60)))
                .addGap(57, 57, 57)
                .addComponent(jLabel181)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar121)
                .addGap(45, 45, 45)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel183)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar122))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel184)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar124, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Tipo de Vehículo", jPanel42);

        jPanel50.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel186.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel186.setText("Agregar");

        jLabel187.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel187.setText("Modificar");

        jLabel188.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 255, 255));
        jLabel188.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel188.setText("Desactivar");

        btnDesactivar61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar61.setText("Desactivar");
        btnDesactivar61.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar61ActionPerformed(evt);
            }
        });

        btnDesactivar125.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar125.setText("Desactivar");
        btnDesactivar125.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar125ActionPerformed(evt);
            }
        });

        btnDesactivar126.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar126.setText("Desactivar");
        btnDesactivar126.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar126ActionPerformed(evt);
            }
        });

        jLabel189.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 255, 255));
        jLabel189.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel189.setText("Generar Reporte PDF");

        btnDesactivar127.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar127.setText("Desactivar");
        btnDesactivar127.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar127ActionPerformed(evt);
            }
        });

        jLabel190.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(255, 255, 255));
        jLabel190.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel190.setText("Generar Reporte Excel");

        btnDesactivar128.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar128.setText("Desactivar");
        btnDesactivar128.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar128ActionPerformed(evt);
            }
        });

        jLabel191.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 255, 255));
        jLabel191.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel191.setText("Sección Tipo de Cabina");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar127, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar126, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar128, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel191, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel188)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel186)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar61)))
                .addGap(57, 57, 57)
                .addComponent(jLabel187)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar125)
                .addGap(45, 45, 45)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel189)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar126))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel190)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar128, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Cabina", jPanel43);

        jPanel51.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel192.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(255, 255, 255));
        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel192.setText("Agregar");

        jLabel193.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(255, 255, 255));
        jLabel193.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel193.setText("Modificar");

        jLabel194.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel194.setText("Desactivar");

        btnDesactivar62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar62.setText("Desactivar");
        btnDesactivar62.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar62ActionPerformed(evt);
            }
        });

        btnDesactivar129.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar129.setText("Desactivar");
        btnDesactivar129.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar129ActionPerformed(evt);
            }
        });

        btnDesactivar130.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar130.setText("Desactivar");
        btnDesactivar130.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar130ActionPerformed(evt);
            }
        });

        jLabel195.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(255, 255, 255));
        jLabel195.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel195.setText("Generar Reporte PDF");

        btnDesactivar131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar131.setText("Desactivar");
        btnDesactivar131.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar131ActionPerformed(evt);
            }
        });

        jLabel196.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(255, 255, 255));
        jLabel196.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel196.setText("Generar Reporte Excel");

        btnDesactivar132.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar132.setText("Desactivar");
        btnDesactivar132.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar132ActionPerformed(evt);
            }
        });

        jLabel197.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(255, 255, 255));
        jLabel197.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel197.setText("Sección Tipo de Combustible");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar131, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel195, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar130, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar132, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel197, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel197, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel194)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel192)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar62)))
                .addGap(57, 57, 57)
                .addComponent(jLabel193)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar129)
                .addGap(45, 45, 45)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel195)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar130))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel196)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar132, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Combustible", jPanel44);

        jPanel52.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel198.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel198.setText("Agregar");

        jLabel199.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel199.setText("Modificar");

        jLabel200.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel200.setText("Desactivar");

        btnDesactivar63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar63.setText("Desactivar");
        btnDesactivar63.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar63ActionPerformed(evt);
            }
        });

        btnDesactivar133.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar133.setText("Desactivar");
        btnDesactivar133.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar133ActionPerformed(evt);
            }
        });

        btnDesactivar134.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar134.setText("Desactivar");
        btnDesactivar134.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar134ActionPerformed(evt);
            }
        });

        jLabel201.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(255, 255, 255));
        jLabel201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel201.setText("Generar Reporte PDF");

        btnDesactivar135.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar135.setText("Desactivar");
        btnDesactivar135.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar135ActionPerformed(evt);
            }
        });

        jLabel202.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel202.setText("Generar Reporte Excel");

        btnDesactivar136.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar136.setText("Desactivar");
        btnDesactivar136.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar136ActionPerformed(evt);
            }
        });

        jLabel203.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel203.setText("Sección Número de Asientos");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel199, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel198, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel200, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar135, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar134, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar136, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel203, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel203, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel200)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel198)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar63)))
                .addGap(57, 57, 57)
                .addComponent(jLabel199)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar133)
                .addGap(45, 45, 45)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel201)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar134))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel202)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar136, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel45Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel45Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Asientos", jPanel45);

        jPanel53.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel204.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(255, 255, 255));
        jLabel204.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel204.setText("Agregar");

        jLabel205.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(255, 255, 255));
        jLabel205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel205.setText("Modificar");

        jLabel206.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(255, 255, 255));
        jLabel206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel206.setText("Desactivar");

        btnDesactivar64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar64.setText("Desactivar");
        btnDesactivar64.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar64ActionPerformed(evt);
            }
        });

        btnDesactivar137.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar137.setText("Desactivar");
        btnDesactivar137.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar137ActionPerformed(evt);
            }
        });

        btnDesactivar138.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar138.setText("Desactivar");
        btnDesactivar138.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar138ActionPerformed(evt);
            }
        });

        jLabel207.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(255, 255, 255));
        jLabel207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel207.setText("Generar Reporte PDF");

        btnDesactivar139.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar139.setText("Desactivar");
        btnDesactivar139.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar139.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar139ActionPerformed(evt);
            }
        });

        jLabel208.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(255, 255, 255));
        jLabel208.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel208.setText("Generar Reporte Excel");

        btnDesactivar140.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar140.setText("Desactivar");
        btnDesactivar140.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar140ActionPerformed(evt);
            }
        });

        jLabel209.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(255, 255, 255));
        jLabel209.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel209.setText("Sección Tipo de Transmisión");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel205, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel206, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar139, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel207, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar138, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar140, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel209, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel209, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel206)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel204)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar64)))
                .addGap(57, 57, 57)
                .addComponent(jLabel205)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar137)
                .addGap(45, 45, 45)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel207)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar138))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel208)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar140, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel46Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel46Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Transmisión", jPanel46);

        jPanel41.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel163.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 255, 255));
        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel163.setText("Generar Reporte PDF");

        btnDesactivar111.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar111.setText("Desactivar");
        btnDesactivar111.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar111ActionPerformed(evt);
            }
        });

        btnDesactivar112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar112.setText("Desactivar");
        btnDesactivar112.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar112ActionPerformed(evt);
            }
        });

        jLabel164.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(255, 255, 255));
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel164.setText("Buscar");

        jLabel165.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 255, 255));
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel165.setText("Generar Reporte Excel");

        btnDesactivar113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar113.setText("Desactivar");
        btnDesactivar113.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar113ActionPerformed(evt);
            }
        });

        jLabel166.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel166.setText("Sección Buscar Vehículo");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel166, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesactivar112)
                    .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar111)
                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar113))
                .addGap(122, 122, 122))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel164)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar112)
                .addGap(35, 35, 35)
                .addComponent(jLabel163)
                .addGap(5, 5, 5)
                .addComponent(btnDesactivar111)
                .addGap(36, 36, 36)
                .addComponent(jLabel165)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar113)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane4.addTab("Buscar Vehículo", jPanel40);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Vehículos", jPanel5);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Permisos de la Pantalla Ventas");

        jTabbedPane5.setForeground(new java.awt.Color(255, 255, 255));

        jPanel54.setLayout(null);

        jPanel55.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel89.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Buscar");

        jLabel90.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Reporte PDF en la Tabla");

        btnDesactivar66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar66.setText("Desactivar");
        btnDesactivar66.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar66ActionPerformed(evt);
            }
        });

        btnDesactivar68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar68.setText("Desactivar");
        btnDesactivar68.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar68ActionPerformed(evt);
            }
        });

        jLabel210.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(255, 255, 255));
        jLabel210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel210.setText("Sección Reporte");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar68, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDesactivar66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addComponent(jLabel210, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel210, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar68)
                .addGap(55, 55, 55)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar66)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel54.add(jPanel55);
        jPanel55.setBounds(210, 70, 480, 290);

        jTabbedPane5.addTab("Reportes", jPanel54);

        jPanel74.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel88.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Agregar Vehículo");

        btnDesactivar65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar65.setText("Desactivar");
        btnDesactivar65.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar65ActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Agregar pieza");

        btnDesactivar67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar67.setText("Desactivar");
        btnDesactivar67.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar67ActionPerformed(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Generar Venta");

        btnDesactivar69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar69.setText("Desactivar");
        btnDesactivar69.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar69ActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Buscar Pieza");

        btnDesactivar77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar77.setText("Desactivar");
        btnDesactivar77.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar77ActionPerformed(evt);
            }
        });

        btnDesactivar78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar78.setText("Desactivar");
        btnDesactivar78.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar78ActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Buscar vehículo");

        jLabel96.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("Sección Ventas");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar65)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar67))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDesactivar78)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar77)))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel96))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar69))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar67)
                            .addGroup(jPanel74Layout.createSequentialGroup()
                                .addComponent(jLabel88)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar65)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel91)
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel94)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar78)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel93)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar77)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar69)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane5.addTab("Ventas", jPanel56);

        jPanel59.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel215.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(255, 255, 255));
        jLabel215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel215.setText("Agregar");

        jLabel216.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(255, 255, 255));
        jLabel216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel216.setText("Modificar");

        jLabel217.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(255, 255, 255));
        jLabel217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel217.setText("Desactivar");

        btnDesactivar70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar70.setText("Desactivar");
        btnDesactivar70.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar70ActionPerformed(evt);
            }
        });

        btnDesactivar144.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar144.setText("Desactivar");
        btnDesactivar144.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar144.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar144ActionPerformed(evt);
            }
        });

        btnDesactivar145.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar145.setText("Desactivar");
        btnDesactivar145.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar145ActionPerformed(evt);
            }
        });

        jLabel218.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(255, 255, 255));
        jLabel218.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel218.setText("Generar Reporte PDF");

        btnDesactivar146.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar146.setText("Desactivar");
        btnDesactivar146.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar146.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar146ActionPerformed(evt);
            }
        });

        jLabel219.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(255, 255, 255));
        jLabel219.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel219.setText("Generar Reporte Excel");

        btnDesactivar147.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar147.setText("Desactivar");
        btnDesactivar147.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar147.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar147ActionPerformed(evt);
            }
        });

        jLabel220.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(255, 255, 255));
        jLabel220.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel220.setText("Sección Tipo de Factura");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel216, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel215, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel217, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar146, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel218, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar145, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel219, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar147, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel220, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel220, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                        .addComponent(jLabel217)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                        .addComponent(jLabel215)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar70)))
                .addGap(57, 57, 57)
                .addComponent(jLabel216)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar144)
                .addGap(45, 45, 45)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jLabel218)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar145))
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jLabel219)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar147, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel58Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel58Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane5.addTab("Tipo de Factura", jPanel58);

        jPanel61.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel221.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(255, 255, 255));
        jLabel221.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel221.setText("Agregar");

        jLabel222.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(255, 255, 255));
        jLabel222.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel222.setText("Modificar");

        jLabel223.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(255, 255, 255));
        jLabel223.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel223.setText("Desactivar");

        btnDesactivar71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar71.setText("Desactivar");
        btnDesactivar71.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar71ActionPerformed(evt);
            }
        });

        btnDesactivar148.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar148.setText("Desactivar");
        btnDesactivar148.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar148.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar148ActionPerformed(evt);
            }
        });

        btnDesactivar149.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar149.setText("Desactivar");
        btnDesactivar149.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar149.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar149ActionPerformed(evt);
            }
        });

        jLabel224.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(255, 255, 255));
        jLabel224.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel224.setText("Generar Reporte PDF");

        btnDesactivar150.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar150.setText("Desactivar");
        btnDesactivar150.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar150ActionPerformed(evt);
            }
        });

        jLabel225.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(255, 255, 255));
        jLabel225.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel225.setText("Generar Reporte Excel");

        btnDesactivar151.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar151.setText("Desactivar");
        btnDesactivar151.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar151.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar151ActionPerformed(evt);
            }
        });

        jLabel226.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(255, 255, 255));
        jLabel226.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel226.setText("Sección CAI");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar148, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel221, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar150, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar149, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel225, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar151, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel226, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel226, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel223)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel221)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar71)))
                .addGap(57, 57, 57)
                .addComponent(jLabel222)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar148)
                .addGap(45, 45, 45)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel224)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar149))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel225)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar151, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel60Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel60Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane5.addTab("CAI", jPanel60);

        jPanel63.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel227.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(255, 255, 255));
        jLabel227.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel227.setText("Agregar");

        jLabel228.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(255, 255, 255));
        jLabel228.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel228.setText("Modificar");

        jLabel229.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(255, 255, 255));
        jLabel229.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel229.setText("Desactivar");

        btnDesactivar72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar72.setText("Desactivar");
        btnDesactivar72.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar72ActionPerformed(evt);
            }
        });

        btnDesactivar152.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar152.setText("Desactivar");
        btnDesactivar152.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar152.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar152ActionPerformed(evt);
            }
        });

        btnDesactivar153.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar153.setText("Desactivar");
        btnDesactivar153.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar153.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar153ActionPerformed(evt);
            }
        });

        jLabel230.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(255, 255, 255));
        jLabel230.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel230.setText("Generar Reporte PDF");

        btnDesactivar154.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar154.setText("Desactivar");
        btnDesactivar154.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar154.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar154ActionPerformed(evt);
            }
        });

        jLabel231.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(255, 255, 255));
        jLabel231.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel231.setText("Generar Reporte Excel");

        btnDesactivar155.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar155.setText("Desactivar");
        btnDesactivar155.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar155.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar155ActionPerformed(evt);
            }
        });

        jLabel232.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(255, 255, 255));
        jLabel232.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel232.setText("Sección Tipo de Pago");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesactivar152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDesactivar72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar154, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel230, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar153, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar155, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jLabel232, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                        .addComponent(jLabel229)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                        .addComponent(jLabel227)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar72)))
                .addGap(57, 57, 57)
                .addComponent(jLabel228)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar152)
                .addGap(45, 45, 45)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addComponent(jLabel230)
                        .addGap(5, 5, 5)
                        .addComponent(btnDesactivar153))
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addComponent(jLabel231)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar155, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel62Layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel62Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane5.addTab("Tipo de Pago", jPanel62);

        jPanel65.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel233.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(255, 255, 255));
        jLabel233.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel233.setText("Buscar");

        jLabel234.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(255, 255, 255));
        jLabel234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel234.setText("Rechazar");

        btnDesactivar73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar73.setText("Desactivar");
        btnDesactivar73.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar73ActionPerformed(evt);
            }
        });

        btnDesactivar156.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar156.setText("Desactivar");
        btnDesactivar156.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar156.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar156ActionPerformed(evt);
            }
        });

        jLabel238.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(255, 255, 255));
        jLabel238.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel238.setText("Sección Facturas Rechazadas");

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel238, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addGap(0, 161, Short.MAX_VALUE)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDesactivar73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel233, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDesactivar156, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(143, 143, 143))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel238, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel233)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar73)
                .addGap(57, 57, 57)
                .addComponent(jLabel234)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar156)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Facturas Rechazadas", jPanel64);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane5)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Ventas", jPanel6);

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(443, 443, 443)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegresar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbIDAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnBuscar2))))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(425, 425, 425))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIDAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAccesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccesoMouseClicked
        btnBuscar2.setEnabled(false);
        btnDesactivar.setEnabled(true);
        btnDesactivar2.setEnabled(true);
        btnDesactivar3.setEnabled(true);
        btnDesactivar4.setEnabled(true);
        btnDesactivar5.setEnabled(true);
        btnDesactivar6.setEnabled(true);
        btnDesactivar1.setEnabled(true);
        btnDesactivar7.setEnabled(true);
        btnDesactivar8.setEnabled(true);
        btnDesactivar9.setEnabled(true);
        btnDesactivar10.setEnabled(true);
        btnDesactivar11.setEnabled(true);
        btnDesactivar12.setEnabled(true);
        btnDesactivar13.setEnabled(true);
        btnDesactivar14.setEnabled(true);
        btnDesactivar15.setEnabled(true);
        btnDesactivar16.setEnabled(true);
        btnDesactivar17.setEnabled(true);
        btnDesactivar18.setEnabled(true);
        btnDesactivar19.setEnabled(true);
        btnDesactivar20.setEnabled(true);
        btnDesactivar21.setEnabled(true);
        btnDesactivar22.setEnabled(true);
        btnDesactivar23.setEnabled(true);
        btnDesactivar24.setEnabled(true);
        btnDesactivar25.setEnabled(true);
        btnDesactivar26.setEnabled(true);
        btnDesactivar27.setEnabled(true);
        btnDesactivar28.setEnabled(true);
        btnDesactivar29.setEnabled(true);
        btnDesactivar30.setEnabled(true);
        btnDesactivar31.setEnabled(true);
        btnDesactivar32.setEnabled(true);
        btnDesactivar33.setEnabled(true);
        btnDesactivar34.setEnabled(true);
        btnDesactivar35.setEnabled(true);
        btnDesactivar36.setEnabled(true);
        btnDesactivar37.setEnabled(true);
        btnDesactivar39.setEnabled(true);
        btnDesactivar40.setEnabled(true);
        btnDesactivar41.setEnabled(true);
        btnDesactivar42.setEnabled(true);
        btnDesactivar43.setEnabled(true);
        btnDesactivar44.setEnabled(true);
        btnDesactivar45.setEnabled(true);
        btnDesactivar46.setEnabled(true);
        btnDesactivar47.setEnabled(true);
        btnDesactivar48.setEnabled(true);
        btnDesactivar49.setEnabled(true);
        btnDesactivar50.setEnabled(true);
        btnDesactivar51.setEnabled(true);
        btnDesactivar52.setEnabled(true);
        btnDesactivar53.setEnabled(true);
        btnDesactivar54.setEnabled(true);
        btnDesactivar55.setEnabled(true);
        btnDesactivar56.setEnabled(true);
        btnDesactivar57.setEnabled(true);
        btnDesactivar58.setEnabled(true);
        btnDesactivar59.setEnabled(true);
        btnDesactivar60.setEnabled(true);
        btnDesactivar61.setEnabled(true);
        btnDesactivar62.setEnabled(true);
        btnDesactivar63.setEnabled(true);
        btnDesactivar64.setEnabled(true);
        btnDesactivar65.setEnabled(true);
        btnDesactivar66.setEnabled(true);
        btnDesactivar67.setEnabled(true);
        btnDesactivar68.setEnabled(true);
        btnDesactivar69.setEnabled(true);
        btnDesactivar70.setEnabled(true);
        btnDesactivar71.setEnabled(true);
        btnDesactivar72.setEnabled(true);
        btnDesactivar73.setEnabled(true);
        btnDesactivar74.setEnabled(true);
        btnDesactivar87.setEnabled(true);
        btnDesactivar88.setEnabled(true);
        btnDesactivar77.setEnabled(true);
        btnDesactivar78.setEnabled(true);
        btnDesactivar89.setEnabled(true);
        btnDesactivar80.setEnabled(true);
        btnDesactivar81.setEnabled(true);
        btnDesactivar82.setEnabled(true);
        btnDesactivar83.setEnabled(true);
        btnDesactivar84.setEnabled(true);
        btnDesactivar85.setEnabled(true);
        btnDesactivar86.setEnabled(true);
        btnDesactivar90.setEnabled(true);
        btnDesactivar91.setEnabled(true);
        btnDesactivar92.setEnabled(true);
        btnDesactivar93.setEnabled(true);
        btnDesactivar94.setEnabled(true);
        btnDesactivar96.setEnabled(true);
        btnDesactivar97.setEnabled(true);
        btnDesactivar102.setEnabled(true);
        btnDesactivar99.setEnabled(true);
        btnDesactivar100.setEnabled(true);
        btnDesactivar101.setEnabled(true);
        btnDesactivar103.setEnabled(true);
        btnDesactivar104.setEnabled(true);
        btnDesactivar105.setEnabled(true);
        btnDesactivar106.setEnabled(true);
        btnDesactivar107.setEnabled(true);
        btnDesactivar108.setEnabled(true);
        btnDesactivar109.setEnabled(true);
        btnDesactivar110.setEnabled(true);
        btnDesactivar111.setEnabled(true);
        btnDesactivar112.setEnabled(true);
        btnDesactivar113.setEnabled(true);
        btnDesactivar114.setEnabled(true);
        btnDesactivar115.setEnabled(true);
        btnDesactivar116.setEnabled(true);
        btnDesactivar117.setEnabled(true);
        btnDesactivar118.setEnabled(true);
        btnDesactivar119.setEnabled(true);
        btnDesactivar120.setEnabled(true);
        btnDesactivar121.setEnabled(true);
        btnDesactivar122.setEnabled(true);
        btnDesactivar123.setEnabled(true);
        btnDesactivar124.setEnabled(true);
        btnDesactivar125.setEnabled(true);
        btnDesactivar126.setEnabled(true);
        btnDesactivar127.setEnabled(true);
        btnDesactivar128.setEnabled(true);
        btnDesactivar129.setEnabled(true);
        btnDesactivar130.setEnabled(true);
        btnDesactivar131.setEnabled(true);
        btnDesactivar132.setEnabled(true);
        btnDesactivar133.setEnabled(true);
        btnDesactivar134.setEnabled(true);
        btnDesactivar135.setEnabled(true);
        btnDesactivar136.setEnabled(true);
        btnDesactivar137.setEnabled(true);
        btnDesactivar138.setEnabled(true);
        btnDesactivar139.setEnabled(true);
        btnDesactivar140.setEnabled(true);
        btnDesactivar148.setEnabled(true);
        btnDesactivar149.setEnabled(true);
        btnDesactivar150.setEnabled(true);
        btnDesactivar144.setEnabled(true);
        btnDesactivar145.setEnabled(true);
        btnDesactivar146.setEnabled(true);
        btnDesactivar147.setEnabled(true);
        btnDesactivar151.setEnabled(true);
        btnDesactivar152.setEnabled(true);
        btnDesactivar153.setEnabled(true);
        btnDesactivar154.setEnabled(true);
        btnDesactivar155.setEnabled(true);
        btnDesactivar156.setEnabled(true);
        int fila = tblAcceso.getSelectedRow();
        if (fila > -1){
            Acceso temp = accesoDao.findAcceso(Integer.parseInt(tblAcceso.getModel().getValueAt(fila, 0).toString()));
            List<Usuarios> temp2 = UsuariosDao.findUsuariosEntities();
            for(Usuarios tp: temp2){
                if(temp.getIdUsuario()==tp.getId_Usuario()){
            cmbIDAcceso.setSelectedIndex(temp.getIdacceso());
            cmbUsuario.setSelectedItem(tp.getId_Nombre());
                }
            }
            try {
                btnActivarDesactivarMenuCliente();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuEmpleado();

            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuVentas();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuPedidos();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuBancos();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuPiezas();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuVehiculos();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                btnActivarDesactivarPermisoSeccionCargosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosBuscarUsuario();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosBuscarEmpleado();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialSueldosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialSueldosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialCargosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialCargosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionClientesAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        try {
                btnActivarDesactivarPermisoSeccionBancosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionPrestamosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosBuscarCliente();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosBuscarBanco();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosAgregarPedido();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosAgregarPieza();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosAgregarVehiculo();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosBuscarVehiculo();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosBuscarPieza();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionListadoPedidosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionListadoPedidosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionListadoPedidosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionPiezasAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionVehiculosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionColorAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionVentasAgregarVehiculo();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasAgregarPieza();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasBuscarPieza();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasBuscarVehiculo();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasGenerarVenta();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionCaiAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionFacturasRechazadasRechazar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionFacturasRechazadasBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionReporteBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionReporteReportePdfTabla();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_tblAccesoMouseClicked

    private void cmbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuarioActionPerformed

    private void cmbIDAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDAccesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDAccesoActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
               try{
            
        

        if(cmbIDAcceso.getSelectedIndex()==0){
            
        }
        else{
        btnBuscar2.setEnabled(false);
        btnDesactivar.setEnabled(true);
        btnDesactivar2.setEnabled(true);
        btnDesactivar3.setEnabled(true);
        btnDesactivar4.setEnabled(true);
        btnDesactivar5.setEnabled(true);
        btnDesactivar6.setEnabled(true);
        btnDesactivar1.setEnabled(true);
        btnDesactivar7.setEnabled(true);
        btnDesactivar8.setEnabled(true);
        btnDesactivar9.setEnabled(true);
        btnDesactivar10.setEnabled(true);
        btnDesactivar11.setEnabled(true);
        btnDesactivar12.setEnabled(true);
        btnDesactivar13.setEnabled(true);
        btnDesactivar14.setEnabled(true);
        btnDesactivar15.setEnabled(true);
        btnDesactivar16.setEnabled(true);
        btnDesactivar17.setEnabled(true);
        btnDesactivar18.setEnabled(true);
        btnDesactivar19.setEnabled(true);
        btnDesactivar20.setEnabled(true);
        btnDesactivar21.setEnabled(true);
        btnDesactivar22.setEnabled(true);
        btnDesactivar23.setEnabled(true);
        btnDesactivar24.setEnabled(true);
        btnDesactivar25.setEnabled(true);
        btnDesactivar26.setEnabled(true);
        btnDesactivar27.setEnabled(true);
        btnDesactivar28.setEnabled(true);
        btnDesactivar29.setEnabled(true);
        btnDesactivar30.setEnabled(true);
        btnDesactivar31.setEnabled(true);
        btnDesactivar32.setEnabled(true);
        btnDesactivar33.setEnabled(true);
        btnDesactivar34.setEnabled(true);
        btnDesactivar35.setEnabled(true);
        btnDesactivar36.setEnabled(true);
        btnDesactivar37.setEnabled(true);
        btnDesactivar39.setEnabled(true);
        btnDesactivar40.setEnabled(true);
        btnDesactivar41.setEnabled(true);
        btnDesactivar42.setEnabled(true);
        btnDesactivar43.setEnabled(true);
        btnDesactivar44.setEnabled(true);
        btnDesactivar45.setEnabled(true);
        btnDesactivar46.setEnabled(true);
        btnDesactivar47.setEnabled(true);
        btnDesactivar48.setEnabled(true);
        btnDesactivar49.setEnabled(true);
        btnDesactivar50.setEnabled(true);
        btnDesactivar51.setEnabled(true);
        btnDesactivar52.setEnabled(true);
        btnDesactivar53.setEnabled(true);
        btnDesactivar54.setEnabled(true);
        btnDesactivar55.setEnabled(true);
        btnDesactivar56.setEnabled(true);
        btnDesactivar57.setEnabled(true);
        btnDesactivar58.setEnabled(true);
        btnDesactivar59.setEnabled(true);
        btnDesactivar60.setEnabled(true);
        btnDesactivar61.setEnabled(true);
        btnDesactivar62.setEnabled(true);
        btnDesactivar63.setEnabled(true);
        btnDesactivar64.setEnabled(true);
        btnDesactivar65.setEnabled(true);
        btnDesactivar66.setEnabled(true);
        btnDesactivar67.setEnabled(true);
        btnDesactivar68.setEnabled(true);
        btnDesactivar69.setEnabled(true);
        btnDesactivar70.setEnabled(true);
        btnDesactivar71.setEnabled(true);
        btnDesactivar72.setEnabled(true);
        btnDesactivar73.setEnabled(true);
        btnDesactivar74.setEnabled(true);
        btnDesactivar87.setEnabled(true);
        btnDesactivar88.setEnabled(true);
        btnDesactivar77.setEnabled(true);
        btnDesactivar78.setEnabled(true);
        btnDesactivar89.setEnabled(true);
        btnDesactivar80.setEnabled(true);
        btnDesactivar81.setEnabled(true);
        btnDesactivar82.setEnabled(true);
        btnDesactivar83.setEnabled(true);
        btnDesactivar84.setEnabled(true);
        btnDesactivar85.setEnabled(true);
        btnDesactivar86.setEnabled(true);
        btnDesactivar90.setEnabled(true);
        btnDesactivar91.setEnabled(true);
        btnDesactivar92.setEnabled(true);
        btnDesactivar93.setEnabled(true);
        btnDesactivar94.setEnabled(true);
        btnDesactivar96.setEnabled(true);
        btnDesactivar97.setEnabled(true);
        btnDesactivar102.setEnabled(true);
        btnDesactivar99.setEnabled(true);
        btnDesactivar100.setEnabled(true);
        btnDesactivar101.setEnabled(true);
        btnDesactivar103.setEnabled(true);
        btnDesactivar104.setEnabled(true);
        btnDesactivar105.setEnabled(true);
        btnDesactivar106.setEnabled(true);
        btnDesactivar107.setEnabled(true);
        btnDesactivar108.setEnabled(true);
        btnDesactivar109.setEnabled(true);
        btnDesactivar110.setEnabled(true);
        btnDesactivar111.setEnabled(true);
        btnDesactivar112.setEnabled(true);
        btnDesactivar113.setEnabled(true);
        btnDesactivar114.setEnabled(true);
        btnDesactivar115.setEnabled(true);
        btnDesactivar116.setEnabled(true);
        btnDesactivar117.setEnabled(true);
        btnDesactivar118.setEnabled(true);
        btnDesactivar119.setEnabled(true);
        btnDesactivar120.setEnabled(true);
        btnDesactivar121.setEnabled(true);
        btnDesactivar122.setEnabled(true);
        btnDesactivar123.setEnabled(true);
        btnDesactivar124.setEnabled(true);
        btnDesactivar125.setEnabled(true);
        btnDesactivar126.setEnabled(true);
        btnDesactivar127.setEnabled(true);
        btnDesactivar128.setEnabled(true);
        btnDesactivar129.setEnabled(true);
        btnDesactivar130.setEnabled(true);
        btnDesactivar131.setEnabled(true);
        btnDesactivar132.setEnabled(true);
        btnDesactivar133.setEnabled(true);
        btnDesactivar134.setEnabled(true);
        btnDesactivar135.setEnabled(true);
        btnDesactivar136.setEnabled(true);
        btnDesactivar137.setEnabled(true);
        btnDesactivar138.setEnabled(true);
        btnDesactivar139.setEnabled(true);
        btnDesactivar140.setEnabled(true);
        btnDesactivar148.setEnabled(true);
        btnDesactivar149.setEnabled(true);
        btnDesactivar150.setEnabled(true);
        btnDesactivar144.setEnabled(true);
        btnDesactivar145.setEnabled(true);
        btnDesactivar146.setEnabled(true);
        btnDesactivar147.setEnabled(true);
        btnDesactivar151.setEnabled(true);
        btnDesactivar152.setEnabled(true);
        btnDesactivar153.setEnabled(true);
        btnDesactivar154.setEnabled(true);
        btnDesactivar155.setEnabled(true);
        btnDesactivar156.setEnabled(true);
        }
        
        ModalUsuario temp2 = new ModalUsuario(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        cmbIDAcceso.setSelectedIndex(temp2.getId());
        cmbUsuario.setSelectedItem(temp2.getNombre());
        
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
                Logger logger = Logger.getLogger(FrmEmpleados.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"SeguridadBuscarUsuario"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

                   try {
                btnActivarDesactivarMenuCliente();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuEmpleado();

            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuVentas();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuPedidos();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuBancos();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuPiezas();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarMenuVehiculos();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                        try {
                btnActivarDesactivarPermisoSeccionEmpleadosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionCargosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosBuscarUsuario();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosBuscarEmpleado();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialSueldosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialSueldosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialCargosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialCargosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionPrestamosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosBuscarCliente();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosBuscarBanco();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionVehiculosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionColorAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionColorReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasAgregarVehiculo();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasAgregarPieza();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasBuscarPieza();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasBuscarVehiculo();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasGenerarVenta();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionCaiAgregar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiModificar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiDesactivar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiReportePdf();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiReporteExcel();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btnActivarDesactivarPermisoSeccionFacturasRechazadasRechazar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionFacturasRechazadasBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionReporteBuscar();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                btnActivarDesactivarPermisoSeccionReporteReportePdfTabla();
            } catch (Exception ex) {
                Logger.getLogger(FrmSeguridad1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
                try{
            
        DesactivarMenuCliente();
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
                Logger logger = Logger.getLogger(FrmEmpleados.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PermisoMenuCliente"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnDesactivar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar1ActionPerformed
        try {
            DesactivarMenuEmpleado();
        } catch (Exception ex) {
            Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarMenuEmpleado");
        }
    }//GEN-LAST:event_btnDesactivar1ActionPerformed

    private void btnDesactivar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar2ActionPerformed
        try {
            DesactivarMenuVentas();
        } catch (Exception ex) {
            Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarMenuVentas");
        }
    }//GEN-LAST:event_btnDesactivar2ActionPerformed

    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
        // TODO add your handling code here:
        try {
            DesactivarMenuBancos();
        } catch (Exception ex) {
            Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarMenuBancos");
        }
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void btnDesactivar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar4ActionPerformed
        try {
            DesactivarMenuVehiculos();
        } catch (Exception ex) {
            Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarMenuVehiculos");
        }
    }//GEN-LAST:event_btnDesactivar4ActionPerformed

    private void btnDesactivar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar5ActionPerformed
        try {
            DesactivarMenuPedidos();
        } catch (Exception ex) {
            Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarMenuPedidos");
        }
    }//GEN-LAST:event_btnDesactivar5ActionPerformed

    private void btnDesactivar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar6ActionPerformed
        try {
            DesactivarMenuPiezas();
        } catch (Exception ex) {
            Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarMenuPiezas");
        }
    }//GEN-LAST:event_btnDesactivar6ActionPerformed

    private void btnDesactivar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar9ActionPerformed
        try {
                DesactivarPermisoSeccionBancosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBancosAgregar()");
            }

    }//GEN-LAST:event_btnDesactivar9ActionPerformed

    private void btnDesactivar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar10ActionPerformed
                    try {
                DesactivarPermisoSeccionBancosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBancosModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar10ActionPerformed

    private void btnDesactivar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar14ActionPerformed
        try {
                DesactivarPermisoSeccionBancosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBancosDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar14ActionPerformed

    private void btnDesactivar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar15ActionPerformed
        try {
                DesactivarPermisoSeccionBancosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBancosReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar15ActionPerformed

    private void btnDesactivar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar16ActionPerformed
        try {
                DesactivarPermisoSeccionBancosBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBancosBuscar");
            }
            
    }//GEN-LAST:event_btnDesactivar16ActionPerformed

    private void btnDesactivar19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar19ActionPerformed
        try {
                DesactivarPermisoSeccionBancosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBancosReporteExcel");
            }

    }//GEN-LAST:event_btnDesactivar19ActionPerformed

    private void btnDesactivar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar11ActionPerformed
                    
            
            try {
                DesactivarPermisoSeccionPrestamosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPrestamosAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar11ActionPerformed

    private void btnDesactivar12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar12ActionPerformed
        try {
                DesactivarPermisoSeccionPrestamosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPrestamosModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar12ActionPerformed

    private void btnDesactivar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar17ActionPerformed
                try {
                DesactivarPermisoSeccionPrestamosBuscarCliente();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPrestamosBuscarCliente");
            }


    }//GEN-LAST:event_btnDesactivar17ActionPerformed

    private void btnDesactivar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar18ActionPerformed
                    try {
                DesactivarPermisoSeccionPrestamosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPrestamosReporteExcel");
            }
 
    }//GEN-LAST:event_btnDesactivar18ActionPerformed

    private void btnDesactivar20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar20ActionPerformed

            try {
                DesactivarPermisoSeccionPrestamosBuscarBanco();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPrestamoBuscarBanco");
            }
    }//GEN-LAST:event_btnDesactivar20ActionPerformed

    private void btnDesactivar21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar21ActionPerformed
                   try {
                DesactivarPermisoSeccionPrestamosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPrestamosReporteExcel");
            }
    }//GEN-LAST:event_btnDesactivar21ActionPerformed

    private void btnDesactivar22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar22ActionPerformed
        try {
                DesactivarPermisoSeccionPrestamosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPrestamosDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar22ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnDesactivar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar13ActionPerformed
       try {
                DesactivarPermisoSeccionClientesAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionClienteAgregar");
            }

    }//GEN-LAST:event_btnDesactivar13ActionPerformed

    private void btnDesactivar23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar23ActionPerformed

            try {
                DesactivarPermisoSeccionClientesModificar();
            } catch (Exception ex) {
               Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionClienteModificar");
            }

    }//GEN-LAST:event_btnDesactivar23ActionPerformed

    private void btnDesactivar24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar24ActionPerformed
                    try {
                DesactivarPermisoSeccionClientesDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionClienteDesactivar");
            }

    }//GEN-LAST:event_btnDesactivar24ActionPerformed

    private void btnDesactivar25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar25ActionPerformed
                    try {
                DesactivarPermisoSeccionClientesReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionClienteReportePdf");
            }
 
    }//GEN-LAST:event_btnDesactivar25ActionPerformed

    private void btnDesactivar26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar26ActionPerformed
                    try {
                DesactivarPermisoSeccionClientesBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionClienteBuscar");
            }

    }//GEN-LAST:event_btnDesactivar26ActionPerformed

    private void btnDesactivar27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar27ActionPerformed
                   try {
                DesactivarPermisoSeccionClientesReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionClienteReporteExcel");
            }

    }//GEN-LAST:event_btnDesactivar27ActionPerformed

    private void btnDesactivar28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar28ActionPerformed
        
            try {
                DesactivarPermisoSeccionTipoDocumentoAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoDocumentoAgregar");
            }

    }//GEN-LAST:event_btnDesactivar28ActionPerformed

    private void btnDesactivar29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar29ActionPerformed
                    try {
                DesactivarPermisoSeccionTipoDocumentoModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoDocumentoModificar");
            }

    }//GEN-LAST:event_btnDesactivar29ActionPerformed

    private void btnDesactivar31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar31ActionPerformed
                    try {
                DesactivarPermisoSeccionTipoDocumentoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoDocumentoReporteExcel");
            }
    }//GEN-LAST:event_btnDesactivar31ActionPerformed

    private void btnDesactivar32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar32ActionPerformed
                    try {
                DesactivarPermisoSeccionTipoDocumentoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoDocumentoReportePdf");
            }

    }//GEN-LAST:event_btnDesactivar32ActionPerformed

    private void btnDesactivar34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivar34ActionPerformed

    private void btnDesactivar30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar30ActionPerformed
                    try {
                DesactivarPermisoSeccionPedidosAgregarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosAgregarVehiculo");
            }

    }//GEN-LAST:event_btnDesactivar30ActionPerformed

    private void btnDesactivar33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar33ActionPerformed
                   try {
                DesactivarPermisoSeccionPedidosAgregarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosAgregarPieza");
            }

    }//GEN-LAST:event_btnDesactivar33ActionPerformed

    private void btnDesactivar36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar36ActionPerformed
                    try {
                DesactivarPermisoSeccionPedidosBuscarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosBuscarPieza");
            }

    }//GEN-LAST:event_btnDesactivar36ActionPerformed

    private void btnDesactivar37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar37ActionPerformed
                    try {
                DesactivarPermisoSeccionPedidosBuscarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosBuscarVehiculo");
            }

    }//GEN-LAST:event_btnDesactivar37ActionPerformed

    private void btnDesactivar39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar39ActionPerformed
                    try {
                DesactivarPermisoSeccionListadoPedidosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosReportePdf");
            }

    }//GEN-LAST:event_btnDesactivar39ActionPerformed

    private void btnDesactivar43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar43ActionPerformed
                    try {
                DesactivarPermisoSeccionListadoPedidosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosReporteExcel");
            }
    }//GEN-LAST:event_btnDesactivar43ActionPerformed

    private void btnDesactivar45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar45ActionPerformed
                    try {
               DesactivarPermisoSeccionListadoPedidosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosDesactivar");
            }

    }//GEN-LAST:event_btnDesactivar45ActionPerformed

    private void btnDesactivar44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar44ActionPerformed

            try {
                DesactivarPermisoSeccionEmpleadosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionEmpleadosReporteExcel");
            }
    }//GEN-LAST:event_btnDesactivar44ActionPerformed

    private void btnDesactivar42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar42ActionPerformed

            try {
                DesactivarPermisoSeccionEmpleadosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionEmpleadosDesactivar");
            }

    }//GEN-LAST:event_btnDesactivar42ActionPerformed

    private void btnDesactivar41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar41ActionPerformed

            try {
                DesactivarPermisoSeccionEmpleadosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionEmpleadosReportePdf");
            }
    }//GEN-LAST:event_btnDesactivar41ActionPerformed

    private void btnDesactivar40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar40ActionPerformed

            try {
                DesactivarPermisoSeccionEmpleadosBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionEmpleadosBuscar");
            }

    }//GEN-LAST:event_btnDesactivar40ActionPerformed

    private void btnDesactivar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar8ActionPerformed

            try {
                DesactivarPermisoSeccionEmpleadosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionEmpleadosModificar");
            }


    }//GEN-LAST:event_btnDesactivar8ActionPerformed

    private void btnDesactivar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar7ActionPerformed
        try {
                DesactivarPermisoSeccionEmpleadosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionEmpleadosAgregar");
            }

    }//GEN-LAST:event_btnDesactivar7ActionPerformed

    private void btnDesactivar46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar46ActionPerformed
        try {
                DesactivarPermisoSeccionCargosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCargoAgregar");
            }

    }//GEN-LAST:event_btnDesactivar46ActionPerformed

    private void btnDesactivar80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar80ActionPerformed

            try {
                DesactivarPermisoSeccionCargosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCargoModificar");
            }

    }//GEN-LAST:event_btnDesactivar80ActionPerformed

    private void btnDesactivar82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar82ActionPerformed

            try {
                DesactivarPermisoSeccionCargosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCargoReportePdf");
            }

    }//GEN-LAST:event_btnDesactivar82ActionPerformed

    private void btnDesactivar83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar83ActionPerformed

            try {
               DesactivarPermisoSeccionCargosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCargoDesactivar");
            }

    }//GEN-LAST:event_btnDesactivar83ActionPerformed

    private void btnDesactivar84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar84ActionPerformed

            try {
                DesactivarPermisoSeccionCargosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCargoReporteExcel");
            }
    }//GEN-LAST:event_btnDesactivar84ActionPerformed

    private void btnDesactivar81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar81ActionPerformed
        try {
                DesactivarPermisoSeccionUsuariosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionUsuarioAgregar");
            }
    
    }//GEN-LAST:event_btnDesactivar81ActionPerformed

    private void btnDesactivar85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar85ActionPerformed

            try {
                DesactivarPermisoSeccionUsuariosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionUsuarioModificar");
            }

    }//GEN-LAST:event_btnDesactivar85ActionPerformed

    private void btnDesactivar86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar86ActionPerformed
        try {
                DesactivarPermisoSeccionUsuariosBuscarEmpleado();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionUsuarioBuscarEmpleado");
            }
            
    }//GEN-LAST:event_btnDesactivar86ActionPerformed

    private void btnDesactivar87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar87ActionPerformed
        try {
                DesactivarPermisoSeccionUsuariosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionUsuarioReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar87ActionPerformed

    private void btnDesactivar88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar88ActionPerformed
        try {
                DesactivarPermisoSeccionUsuariosBuscarUsuario();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionUsuarioBuscarUsuario");
            }
            
    }//GEN-LAST:event_btnDesactivar88ActionPerformed

    private void btnDesactivar89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar89ActionPerformed
        try {
                DesactivarPermisoSeccionUsuariosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionUsuarioReporteExcel");
            }
            
    }//GEN-LAST:event_btnDesactivar89ActionPerformed

    private void btnDesactivar90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar90ActionPerformed

            try {
                DesactivarPermisoSeccionUsuariosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionUsuarioDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar90ActionPerformed

    private void btnDesactivar94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar94ActionPerformed
        
            try {
                DesactivarPermisoSeccionHistorialSueldosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialSueldosReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar94ActionPerformed

    private void btnDesactivar96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar96ActionPerformed
        try {
                DesactivarPermisoSeccionHistorialSueldosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionSeccionHistorialSueldosReporteExcel");
            }

    }//GEN-LAST:event_btnDesactivar96ActionPerformed

    private void btnDesactivar97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar97ActionPerformed
                    
            try {
               DesactivarPermisoSeccionHistorialCargosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialSueldosReportePdf");
            }

    }//GEN-LAST:event_btnDesactivar97ActionPerformed

    private void btnDesactivar99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar99ActionPerformed
            try {
                DesactivarPermisoSeccionHistorialCargosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionSeccionHistorialCargoReporteExcel");
            }
    }//GEN-LAST:event_btnDesactivar99ActionPerformed

    private void btnDesactivar110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar110ActionPerformed
                    
                       try {
                DesactivarPermisoSeccionBuscarPiezaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBuscarPiezaReporteExcel");
            }

    }//GEN-LAST:event_btnDesactivar110ActionPerformed

    private void btnDesactivar109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar109ActionPerformed
        try {
                DesactivarPermisoSeccionBuscarPiezaBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBuscarPiezaBuscar");
            }
    }//GEN-LAST:event_btnDesactivar109ActionPerformed

    private void btnDesactivar108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar108ActionPerformed
                    try {
                DesactivarPermisoSeccionBuscarPiezaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBuscarPiezaReportePdf");
            }

    }//GEN-LAST:event_btnDesactivar108ActionPerformed

    private void btnDesactivar116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar116ActionPerformed
        try {
               DesactivarPermisoSeccionHistorialPreciosPiezaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialPiezaReporteExcel");
            }

    }//GEN-LAST:event_btnDesactivar116ActionPerformed

    private void btnDesactivar115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar115ActionPerformed
                  
            try {
                DesactivarPermisoSeccionHistorialPreciosPiezaBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialPrecioPiezaBuscar");
            }
            
            
    }//GEN-LAST:event_btnDesactivar115ActionPerformed

    private void btnDesactivar114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar114ActionPerformed
        try {
                DesactivarPermisoSeccionHistorialPreciosPiezaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialPreciosPiezaReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar114ActionPerformed

    private void btnDesactivar52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar52ActionPerformed
        try {
                DesactivarPermisoSeccionPiezasReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPiezaReporteExcel");
            }
    }//GEN-LAST:event_btnDesactivar52ActionPerformed

    private void btnDesactivar51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar51ActionPerformed
               
            try {
                DesactivarPermisoSeccionPiezasDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPiezaDesactivar");
            }

    }//GEN-LAST:event_btnDesactivar51ActionPerformed

    private void btnDesactivar50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar50ActionPerformed
                    try {
                DesactivarPermisoSeccionPiezasReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPiezasReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar50ActionPerformed

    private void btnDesactivar48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar48ActionPerformed
                    try {
                DesactivarPermisoSeccionPiezasModificar();
            } catch (Exception ex) {
                 Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPiezasModificar");
            }
    }//GEN-LAST:event_btnDesactivar48ActionPerformed

    private void btnDesactivar47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar47ActionPerformed
        try {
                DesactivarPermisoSeccionPiezasAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPiezasAgregar");
            }

    }//GEN-LAST:event_btnDesactivar47ActionPerformed

    private void btnDesactivar49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar49ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPiezaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPiezaAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar49ActionPerformed

    private void btnDesactivar91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar91ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPiezaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPiezaModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar91ActionPerformed

    private void btnDesactivar92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar92ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPiezaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPiezaReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar92ActionPerformed

    private void btnDesactivar93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar93ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPiezaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPiezaDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar93ActionPerformed

    private void btnDesactivar100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar100ActionPerformed
                try {
                DesactivarPermisoSeccionTipoPiezaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPiezaReporteExcel");
            }
  
    }//GEN-LAST:event_btnDesactivar100ActionPerformed

    private void btnDesactivar53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar53ActionPerformed
        try {
                DesactivarPermisoSeccionVehiculosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVehiculosAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar53ActionPerformed

    private void btnDesactivar54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar54ActionPerformed
        try {
                DesactivarPermisoSeccionVehiculosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVehiculosModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar54ActionPerformed

    private void btnDesactivar55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar55ActionPerformed
        try {
               DesactivarPermisoSeccionVehiculosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVehiculosReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar55ActionPerformed

    private void btnDesactivar56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar56ActionPerformed
        try {
                DesactivarPermisoSeccionVehiculosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVehiculosDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar56ActionPerformed

    private void btnDesactivar57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar57ActionPerformed
        try {
                DesactivarPermisoSeccionVehiculosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVehiculosReporteExcel");
            }
            
    }//GEN-LAST:event_btnDesactivar57ActionPerformed

    private void btnDesactivar117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar117ActionPerformed
        try {
                DesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar117ActionPerformed

    private void btnDesactivar118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar118ActionPerformed
        
            try {
                DesactivarPermisoSeccionHistorialPreciosVehiculoBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialPreciosVehiculoBuscar");
            }
            
    }//GEN-LAST:event_btnDesactivar118ActionPerformed

    private void btnDesactivar119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar119ActionPerformed
        try {
                DesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel");
            }
            
    }//GEN-LAST:event_btnDesactivar119ActionPerformed

    private void btnDesactivar58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar58ActionPerformed
        try {
               DesactivarPermisoSeccionMarcaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionMarcaAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar58ActionPerformed

    private void btnDesactivar101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar101ActionPerformed
        try {
                DesactivarPermisoSeccionMarcaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionMarcaModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar101ActionPerformed

    private void btnDesactivar102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar102ActionPerformed
        try {
                DesactivarPermisoSeccionMarcaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionMarcaReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar102ActionPerformed

    private void btnDesactivar103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar103ActionPerformed
        try {
                DesactivarPermisoSeccionMarcaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionMarcaDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar103ActionPerformed

    private void btnDesactivar104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar104ActionPerformed
        try {
                DesactivarPermisoSeccionMarcaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionMarcaReporteExcel");
            }
            
            
    }//GEN-LAST:event_btnDesactivar104ActionPerformed

    private void btnDesactivar111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar111ActionPerformed
        try {
                DesactivarPermisoSeccionBuscarVehiculoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBuscarVehiculoReportePdf");
            }

    }//GEN-LAST:event_btnDesactivar111ActionPerformed

    private void btnDesactivar112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar112ActionPerformed
        
            try {
                DesactivarPermisoSeccionBuscarVehiculoBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBuscarVehiculoBuscar");
            }
            
    }//GEN-LAST:event_btnDesactivar112ActionPerformed

    private void btnDesactivar113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar113ActionPerformed
                    try {
                DesactivarPermisoSeccionBuscarVehiculoExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionBuscarVehiculoExcel");
            }
    }//GEN-LAST:event_btnDesactivar113ActionPerformed

    private void btnDesactivar59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar59ActionPerformed
        
            try {
                DesactivarPermisoSeccionColorAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionColorAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar59ActionPerformed

    private void btnDesactivar105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar105ActionPerformed
        try {
                DesactivarPermisoSeccionColorModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionColorModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar105ActionPerformed

    private void btnDesactivar106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar106ActionPerformed
        try {
                DesactivarPermisoSeccionColorReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionColorReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar106ActionPerformed

    private void btnDesactivar107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar107ActionPerformed
        try {
                DesactivarPermisoSeccionColorDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionColorDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar107ActionPerformed

    private void btnDesactivar120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar120ActionPerformed
        try {
                DesactivarPermisoSeccionColorReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionColorReporteExcel");
            }
            
            
    }//GEN-LAST:event_btnDesactivar120ActionPerformed

    private void btnDesactivar60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar60ActionPerformed
           try {
                DesactivarPermisoSeccionTipoVehiculoAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoVehiculoAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar60ActionPerformed

    private void btnDesactivar121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar121ActionPerformed
        try {
                DesactivarPermisoSeccionTipoVehiculoModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoVehiculoModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar121ActionPerformed

    private void btnDesactivar122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar122ActionPerformed
        try {
                DesactivarPermisoSeccionTipoVehiculoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoVehiculoReportePdf");
            }
        
           
    }//GEN-LAST:event_btnDesactivar122ActionPerformed

    private void btnDesactivar123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar123ActionPerformed
        try {
                DesactivarPermisoSeccionTipoVehiculoDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoVehiculoDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar123ActionPerformed

    private void btnDesactivar124ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar124ActionPerformed
        try {
                DesactivarPermisoSeccionTipoVehiculoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoVehiculoReporteExcel");
            }
        
    }//GEN-LAST:event_btnDesactivar124ActionPerformed

    private void btnDesactivar61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar61ActionPerformed
               try {
                DesactivarPermisoSeccionTipoCabinaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCabinaAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar61ActionPerformed

    private void btnDesactivar125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar125ActionPerformed
        try {
                DesactivarPermisoSeccionTipoCabinaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCabinaModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar125ActionPerformed

    private void btnDesactivar126ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar126ActionPerformed
        try {
                DesactivarPermisoSeccionTipoCabinaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCabinaReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar126ActionPerformed

    private void btnDesactivar127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar127ActionPerformed
        try {
                DesactivarPermisoSeccionTipoCabinaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCabinaDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar127ActionPerformed

    private void btnDesactivar128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar128ActionPerformed
        try {
                DesactivarPermisoSeccionTipoCabinaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCabinaReporteExcel");
            }    
    }//GEN-LAST:event_btnDesactivar128ActionPerformed

    private void btnDesactivar62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar62ActionPerformed
        
            try {
                DesactivarPermisoSeccionTipoCombustibleAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCombustibleAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar62ActionPerformed

    private void btnDesactivar129ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar129ActionPerformed
        try {
               DesactivarPermisoSeccionTipoCombustibleModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCombustibleModificar");
            }
             
    }//GEN-LAST:event_btnDesactivar129ActionPerformed

    private void btnDesactivar130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar130ActionPerformed
        try {
                DesactivarPermisoSeccionTipoCombustibleReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCombustibleReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar130ActionPerformed

    private void btnDesactivar131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar131ActionPerformed
        try {
                DesactivarPermisoSeccionTipoCombustibleDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCombustibleDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar131ActionPerformed

    private void btnDesactivar132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar132ActionPerformed
        try {
                DesactivarPermisoSeccionTipoCombustibleReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoCombustibleReporteExcel");
            }
            
            
    }//GEN-LAST:event_btnDesactivar132ActionPerformed

    private void btnDesactivar63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar63ActionPerformed

            
            try {
                DesactivarPermisoSeccionNumeroAsientosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionNumeroAsientosAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar63ActionPerformed

    private void btnDesactivar133ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar133ActionPerformed
        try {
                DesactivarPermisoSeccionNumeroAsientosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionNumeroAsientosModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar133ActionPerformed

    private void btnDesactivar134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar134ActionPerformed
        try {
            DesactivarPermisoSeccionNumeroAsientosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionNumeroAsientosReportePdf");
            }

            
    }//GEN-LAST:event_btnDesactivar134ActionPerformed

    private void btnDesactivar135ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar135ActionPerformed
                    
            
            try {
                DesactivarPermisoSeccionNumeroAsientosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionNumeroAsientosDesactivar");
            }
 
    }//GEN-LAST:event_btnDesactivar135ActionPerformed

    private void btnDesactivar136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar136ActionPerformed
        try {
                DesactivarPermisoSeccionNumeroAsientosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionNumeroAsientosReporteExcel");
            }
            
    }//GEN-LAST:event_btnDesactivar136ActionPerformed

    private void btnDesactivar64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar64ActionPerformed
                try {
                DesactivarPermisoSeccionTipoTransmisionAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoTransmisionAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar64ActionPerformed

    private void btnDesactivar137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar137ActionPerformed
        try {
                DesactivarPermisoSeccionTipoTransmisionModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoTransmisionModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar137ActionPerformed

    private void btnDesactivar138ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar138ActionPerformed
        try {
                DesactivarPermisoSeccionTipoTransmisionReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoTransmisionReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar138ActionPerformed

    private void btnDesactivar139ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar139ActionPerformed
        try {
                DesactivarPermisoSeccionTipoTransmisionDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoTransmisionDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar139ActionPerformed

    private void btnDesactivar140ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar140ActionPerformed
        try {
                DesactivarPermisoSeccionTipoTransmisionReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoTransmisionReporteExcel");
            }
            
    }//GEN-LAST:event_btnDesactivar140ActionPerformed

    private void btnDesactivar66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar66ActionPerformed
                            try {
                DesactivarPermisoSeccionReporteBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionReporteBuscar");
            }
    }//GEN-LAST:event_btnDesactivar66ActionPerformed

    private void btnDesactivar68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar68ActionPerformed

            try {
                DesactivarPermisoSeccionReporteReportePdfTabla();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionReporteReportePdfTabla");
            }
    }//GEN-LAST:event_btnDesactivar68ActionPerformed

    private void btnDesactivar70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar70ActionPerformed
        try {
                DesactivarPermisoSeccionTipoFacturaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoFacturaAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar70ActionPerformed

    private void btnDesactivar144ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar144ActionPerformed
        try {
                DesactivarPermisoSeccionTipoFacturaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoFacturaModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar144ActionPerformed

    private void btnDesactivar145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar145ActionPerformed
        try {
                DesactivarPermisoSeccionTipoFacturaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoFacturaReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar145ActionPerformed

    private void btnDesactivar146ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar146ActionPerformed
        try {
                DesactivarPermisoSeccionTipoFacturaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoFacturaDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar146ActionPerformed

    private void btnDesactivar147ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar147ActionPerformed
        try {
                DesactivarPermisoSeccionTipoFacturaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoFacturaReporteExcel");
            }
            
    }//GEN-LAST:event_btnDesactivar147ActionPerformed

    private void btnDesactivar71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar71ActionPerformed
                    
            
            try {
                DesactivarPermisoSeccionCaiAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCaiAgregar");
            }

    }//GEN-LAST:event_btnDesactivar71ActionPerformed

    private void btnDesactivar148ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar148ActionPerformed
                    try {
                DesactivarPermisoSeccionCaiModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCaiModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar148ActionPerformed

    private void btnDesactivar149ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar149ActionPerformed
        try {
                DesactivarPermisoSeccionCaiReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCaiReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar149ActionPerformed

    private void btnDesactivar150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar150ActionPerformed
                try {
                DesactivarPermisoSeccionCaiDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCaiDesactivar");
            }
    }//GEN-LAST:event_btnDesactivar150ActionPerformed

    private void btnDesactivar151ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar151ActionPerformed

            try {
                DesactivarPermisoSeccionCaiReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionCaiReporteExcel");
            }

    }//GEN-LAST:event_btnDesactivar151ActionPerformed

    private void btnDesactivar72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar72ActionPerformed
        
            try {
                DesactivarPermisoSeccionTipoPagoAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPagoAgregar");
            }
            
    }//GEN-LAST:event_btnDesactivar72ActionPerformed

    private void btnDesactivar152ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar152ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPagoModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPagoModificar");
            }
            
    }//GEN-LAST:event_btnDesactivar152ActionPerformed

    private void btnDesactivar153ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar153ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPagoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPagoReportePdf");
            }
            
    }//GEN-LAST:event_btnDesactivar153ActionPerformed

    private void btnDesactivar154ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar154ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPagoDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPagoDesactivar");
            }
            
    }//GEN-LAST:event_btnDesactivar154ActionPerformed

    private void btnDesactivar155ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar155ActionPerformed
        try {
                DesactivarPermisoSeccionTipoPagoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoPagoReporteExcel");
            }

    }//GEN-LAST:event_btnDesactivar155ActionPerformed

    private void btnDesactivar73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar73ActionPerformed
                    try {
                DesactivarPermisoSeccionFacturasRechazadasBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionFacturasRechazadasBuscar");
            }

    }//GEN-LAST:event_btnDesactivar73ActionPerformed

    private void btnDesactivar156ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar156ActionPerformed
                    
            try {
                DesactivarPermisoSeccionFacturasRechazadasRechazar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionFacturasRechazadasRechazar");
            }

    }//GEN-LAST:event_btnDesactivar156ActionPerformed

    private void btnDesactivar65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar65ActionPerformed
        try {
                DesactivarPermisoSeccionVentasAgregarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVentasAgregarVehiculo");
            }
            
    }//GEN-LAST:event_btnDesactivar65ActionPerformed

    private void btnDesactivar67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar67ActionPerformed
        try {
                DesactivarPermisoSeccionVentasAgregarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVentasAgregarPieza");
            }
            
    }//GEN-LAST:event_btnDesactivar67ActionPerformed

    private void btnDesactivar69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar69ActionPerformed
        try {
             DesactivarPermisoSeccionVentasGenerarVenta();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVentasGenerarVenta");
            }
            
    }//GEN-LAST:event_btnDesactivar69ActionPerformed

    private void btnDesactivar77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar77ActionPerformed
        try {
                DesactivarPermisoSeccionVentasBuscarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVentasBuscarPieza");
            }
            
    }//GEN-LAST:event_btnDesactivar77ActionPerformed

    private void btnDesactivar78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar78ActionPerformed
        try {
                DesactivarPermisoSeccionVentasBuscarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionVentasBuscarVehiculo");
            }
            
    }//GEN-LAST:event_btnDesactivar78ActionPerformed

    private void btnDesactivar74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar74ActionPerformed
                    try {
                DesactivarPermisoSeccionTipoDocumentoDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionTipoDocumentoDesactivar");
            }

    }//GEN-LAST:event_btnDesactivar74ActionPerformed

    private void btnDesactivar35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar35ActionPerformed
        try {
                DesactivarPermisoSeccionPedidosAgregarPedido();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"DesactivarPermisoSeccionPedidosAgregarPedido");
            }

    }//GEN-LAST:event_btnDesactivar35ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
                try{
            
           
            cmbUsuario.setSelectedIndex(0);
            cmbIDAcceso.setSelectedIndex(0);
            btnBuscar2.setEnabled(true);
                    btnDesactivar.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        btnDesactivar4.setEnabled(false);
        btnDesactivar5.setEnabled(false);
        btnDesactivar6.setEnabled(false);
        btnDesactivar1.setEnabled(false);
        btnDesactivar7.setEnabled(false);
        btnDesactivar8.setEnabled(false);
        btnDesactivar9.setEnabled(false);
        btnDesactivar10.setEnabled(false);
        btnDesactivar11.setEnabled(false);
        btnDesactivar12.setEnabled(false);
        btnDesactivar13.setEnabled(false);
        btnDesactivar14.setEnabled(false);
        btnDesactivar15.setEnabled(false);
        btnDesactivar16.setEnabled(false);
        btnDesactivar17.setEnabled(false);
        btnDesactivar18.setEnabled(false);
        btnDesactivar19.setEnabled(false);
        btnDesactivar20.setEnabled(false);
        btnDesactivar21.setEnabled(false);
        btnDesactivar22.setEnabled(false);
        btnDesactivar23.setEnabled(false);
        btnDesactivar24.setEnabled(false);
        btnDesactivar25.setEnabled(false);
        btnDesactivar26.setEnabled(false);
        btnDesactivar27.setEnabled(false);
        btnDesactivar28.setEnabled(false);
        btnDesactivar29.setEnabled(false);
        btnDesactivar30.setEnabled(false);
        btnDesactivar31.setEnabled(false);
        btnDesactivar32.setEnabled(false);
        btnDesactivar33.setEnabled(false);
        btnDesactivar34.setEnabled(false);
        btnDesactivar35.setEnabled(false);
        btnDesactivar36.setEnabled(false);
        btnDesactivar37.setEnabled(false);
        btnDesactivar39.setEnabled(false);
        btnDesactivar40.setEnabled(false);
        btnDesactivar41.setEnabled(false);
        btnDesactivar42.setEnabled(false);
        btnDesactivar43.setEnabled(false);
        btnDesactivar44.setEnabled(false);
        btnDesactivar45.setEnabled(false);
        btnDesactivar46.setEnabled(false);
        btnDesactivar47.setEnabled(false);
        btnDesactivar48.setEnabled(false);
        btnDesactivar49.setEnabled(false);
        btnDesactivar50.setEnabled(false);
        btnDesactivar51.setEnabled(false);
        btnDesactivar52.setEnabled(false);
        btnDesactivar53.setEnabled(false);
        btnDesactivar54.setEnabled(false);
        btnDesactivar55.setEnabled(false);
        btnDesactivar56.setEnabled(false);
        btnDesactivar57.setEnabled(false);
        btnDesactivar58.setEnabled(false);
        btnDesactivar59.setEnabled(false);
        btnDesactivar60.setEnabled(false);
        btnDesactivar61.setEnabled(false);
        btnDesactivar62.setEnabled(false);
        btnDesactivar63.setEnabled(false);
        btnDesactivar64.setEnabled(false);
        btnDesactivar65.setEnabled(false);
        btnDesactivar66.setEnabled(false);
        btnDesactivar67.setEnabled(false);
        btnDesactivar68.setEnabled(false);
        btnDesactivar69.setEnabled(false);
        btnDesactivar70.setEnabled(false);
        btnDesactivar71.setEnabled(false);
        btnDesactivar72.setEnabled(false);
        btnDesactivar73.setEnabled(false);
        btnDesactivar74.setEnabled(false);
        btnDesactivar87.setEnabled(false);
        btnDesactivar88.setEnabled(false);
        btnDesactivar77.setEnabled(false);
        btnDesactivar78.setEnabled(false);
        btnDesactivar89.setEnabled(false);
        btnDesactivar80.setEnabled(false);
        btnDesactivar81.setEnabled(false);
        btnDesactivar82.setEnabled(false);
        btnDesactivar83.setEnabled(false);
        btnDesactivar84.setEnabled(false);
        btnDesactivar85.setEnabled(false);
        btnDesactivar86.setEnabled(false);
        btnDesactivar90.setEnabled(false);
        btnDesactivar91.setEnabled(false);
        btnDesactivar92.setEnabled(false);
        btnDesactivar93.setEnabled(false);
        btnDesactivar94.setEnabled(false);
        btnDesactivar96.setEnabled(false);
        btnDesactivar97.setEnabled(false);
        btnDesactivar102.setEnabled(false);
        btnDesactivar99.setEnabled(false);
        btnDesactivar100.setEnabled(false);
        btnDesactivar101.setEnabled(false);
        btnDesactivar103.setEnabled(false);
        btnDesactivar104.setEnabled(false);
        btnDesactivar105.setEnabled(false);
        btnDesactivar106.setEnabled(false);
        btnDesactivar107.setEnabled(false);
        btnDesactivar108.setEnabled(false);
        btnDesactivar109.setEnabled(false);
        btnDesactivar110.setEnabled(false);
        btnDesactivar111.setEnabled(false);
        btnDesactivar112.setEnabled(false);
        btnDesactivar113.setEnabled(false);
        btnDesactivar114.setEnabled(false);
        btnDesactivar115.setEnabled(false);
        btnDesactivar116.setEnabled(false);
        btnDesactivar117.setEnabled(false);
        btnDesactivar118.setEnabled(false);
        btnDesactivar119.setEnabled(false);
        btnDesactivar120.setEnabled(false);
        btnDesactivar121.setEnabled(false);
        btnDesactivar122.setEnabled(false);
        btnDesactivar123.setEnabled(false);
        btnDesactivar124.setEnabled(false);
        btnDesactivar125.setEnabled(false);
        btnDesactivar126.setEnabled(false);
        btnDesactivar127.setEnabled(false);
        btnDesactivar128.setEnabled(false);
        btnDesactivar129.setEnabled(false);
        btnDesactivar130.setEnabled(false);
        btnDesactivar131.setEnabled(false);
        btnDesactivar132.setEnabled(false);
        btnDesactivar133.setEnabled(false);
        btnDesactivar134.setEnabled(false);
        btnDesactivar135.setEnabled(false);
        btnDesactivar136.setEnabled(false);
        btnDesactivar137.setEnabled(false);
        btnDesactivar138.setEnabled(false);
        btnDesactivar139.setEnabled(false);
        btnDesactivar140.setEnabled(false);
        btnDesactivar148.setEnabled(false);
        btnDesactivar149.setEnabled(false);
        btnDesactivar150.setEnabled(false);
        btnDesactivar144.setEnabled(false);
        btnDesactivar145.setEnabled(false);
        btnDesactivar146.setEnabled(false);
        btnDesactivar147.setEnabled(false);
        btnDesactivar151.setEnabled(false);
        btnDesactivar152.setEnabled(false);
        btnDesactivar153.setEnabled(false);
        btnDesactivar154.setEnabled(false);
        btnDesactivar155.setEnabled(false);
        btnDesactivar156.setEnabled(false);

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
                Logger logger = Logger.getLogger(FrmEmpleados.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"SeguridadLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cmbUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUsuarioItemStateChanged
List<Usuarios> temp2 = UsuariosDao.findUsuariosEntities();
List<Acceso> temp = accesoDao.findAccesoEntities();
String seleccionado=(String)cmbUsuario.getSelectedItem();
for(Usuarios tp: temp2){
if((seleccionado).equals(tp.getId_Nombre())){
    for(Acceso tpp:temp){
        if(tp.getId_Usuario()==tpp.getIdUsuario()){
            cmbIDAcceso.setSelectedIndex(tpp.getIdacceso());
            
                    btnBuscar2.setEnabled(false);
        btnDesactivar.setEnabled(true);
        btnDesactivar2.setEnabled(true);
        btnDesactivar3.setEnabled(true);
        btnDesactivar4.setEnabled(true);
        btnDesactivar5.setEnabled(true);
        btnDesactivar6.setEnabled(true);
        btnDesactivar1.setEnabled(true);
        btnDesactivar7.setEnabled(true);
        btnDesactivar8.setEnabled(true);
        btnDesactivar9.setEnabled(true);
        btnDesactivar10.setEnabled(true);
        btnDesactivar11.setEnabled(true);
        btnDesactivar12.setEnabled(true);
        btnDesactivar13.setEnabled(true);
        btnDesactivar14.setEnabled(true);
        btnDesactivar15.setEnabled(true);
        btnDesactivar16.setEnabled(true);
        btnDesactivar17.setEnabled(true);
        btnDesactivar18.setEnabled(true);
        btnDesactivar19.setEnabled(true);
        btnDesactivar20.setEnabled(true);
        btnDesactivar21.setEnabled(true);
        btnDesactivar22.setEnabled(true);
        btnDesactivar23.setEnabled(true);
        btnDesactivar24.setEnabled(true);
        btnDesactivar25.setEnabled(true);
        btnDesactivar26.setEnabled(true);
        btnDesactivar27.setEnabled(true);
        btnDesactivar28.setEnabled(true);
        btnDesactivar29.setEnabled(true);
        btnDesactivar30.setEnabled(true);
        btnDesactivar31.setEnabled(true);
        btnDesactivar32.setEnabled(true);
        btnDesactivar33.setEnabled(true);
        btnDesactivar34.setEnabled(true);
        btnDesactivar35.setEnabled(true);
        btnDesactivar36.setEnabled(true);
        btnDesactivar37.setEnabled(true);
        btnDesactivar39.setEnabled(true);
        btnDesactivar40.setEnabled(true);
        btnDesactivar41.setEnabled(true);
        btnDesactivar42.setEnabled(true);
        btnDesactivar43.setEnabled(true);
        btnDesactivar44.setEnabled(true);
        btnDesactivar45.setEnabled(true);
        btnDesactivar46.setEnabled(true);
        btnDesactivar47.setEnabled(true);
        btnDesactivar48.setEnabled(true);
        btnDesactivar49.setEnabled(true);
        btnDesactivar50.setEnabled(true);
        btnDesactivar51.setEnabled(true);
        btnDesactivar52.setEnabled(true);
        btnDesactivar53.setEnabled(true);
        btnDesactivar54.setEnabled(true);
        btnDesactivar55.setEnabled(true);
        btnDesactivar56.setEnabled(true);
        btnDesactivar57.setEnabled(true);
        btnDesactivar58.setEnabled(true);
        btnDesactivar59.setEnabled(true);
        btnDesactivar60.setEnabled(true);
        btnDesactivar61.setEnabled(true);
        btnDesactivar62.setEnabled(true);
        btnDesactivar63.setEnabled(true);
        btnDesactivar64.setEnabled(true);
        btnDesactivar65.setEnabled(true);
        btnDesactivar66.setEnabled(true);
        btnDesactivar67.setEnabled(true);
        btnDesactivar68.setEnabled(true);
        btnDesactivar69.setEnabled(true);
        btnDesactivar70.setEnabled(true);
        btnDesactivar71.setEnabled(true);
        btnDesactivar72.setEnabled(true);
        btnDesactivar73.setEnabled(true);
        btnDesactivar74.setEnabled(true);
        btnDesactivar87.setEnabled(true);
        btnDesactivar88.setEnabled(true);
        btnDesactivar77.setEnabled(true);
        btnDesactivar78.setEnabled(true);
        btnDesactivar89.setEnabled(true);
        btnDesactivar80.setEnabled(true);
        btnDesactivar81.setEnabled(true);
        btnDesactivar82.setEnabled(true);
        btnDesactivar83.setEnabled(true);
        btnDesactivar84.setEnabled(true);
        btnDesactivar85.setEnabled(true);
        btnDesactivar86.setEnabled(true);
        btnDesactivar90.setEnabled(true);
        btnDesactivar91.setEnabled(true);
        btnDesactivar92.setEnabled(true);
        btnDesactivar93.setEnabled(true);
        btnDesactivar94.setEnabled(true);
        btnDesactivar96.setEnabled(true);
        btnDesactivar97.setEnabled(true);
        btnDesactivar102.setEnabled(true);
        btnDesactivar99.setEnabled(true);
        btnDesactivar100.setEnabled(true);
        btnDesactivar101.setEnabled(true);
        btnDesactivar103.setEnabled(true);
        btnDesactivar104.setEnabled(true);
        btnDesactivar105.setEnabled(true);
        btnDesactivar106.setEnabled(true);
        btnDesactivar107.setEnabled(true);
        btnDesactivar108.setEnabled(true);
        btnDesactivar109.setEnabled(true);
        btnDesactivar110.setEnabled(true);
        btnDesactivar111.setEnabled(true);
        btnDesactivar112.setEnabled(true);
        btnDesactivar113.setEnabled(true);
        btnDesactivar114.setEnabled(true);
        btnDesactivar115.setEnabled(true);
        btnDesactivar116.setEnabled(true);
        btnDesactivar117.setEnabled(true);
        btnDesactivar118.setEnabled(true);
        btnDesactivar119.setEnabled(true);
        btnDesactivar120.setEnabled(true);
        btnDesactivar121.setEnabled(true);
        btnDesactivar122.setEnabled(true);
        btnDesactivar123.setEnabled(true);
        btnDesactivar124.setEnabled(true);
        btnDesactivar125.setEnabled(true);
        btnDesactivar126.setEnabled(true);
        btnDesactivar127.setEnabled(true);
        btnDesactivar128.setEnabled(true);
        btnDesactivar129.setEnabled(true);
        btnDesactivar130.setEnabled(true);
        btnDesactivar131.setEnabled(true);
        btnDesactivar132.setEnabled(true);
        btnDesactivar133.setEnabled(true);
        btnDesactivar134.setEnabled(true);
        btnDesactivar135.setEnabled(true);
        btnDesactivar136.setEnabled(true);
        btnDesactivar137.setEnabled(true);
        btnDesactivar138.setEnabled(true);
        btnDesactivar139.setEnabled(true);
        btnDesactivar140.setEnabled(true);
        btnDesactivar148.setEnabled(true);
        btnDesactivar149.setEnabled(true);
        btnDesactivar150.setEnabled(true);
        btnDesactivar144.setEnabled(true);
        btnDesactivar145.setEnabled(true);
        btnDesactivar146.setEnabled(true);
        btnDesactivar147.setEnabled(true);
        btnDesactivar151.setEnabled(true);
        btnDesactivar152.setEnabled(true);
        btnDesactivar153.setEnabled(true);
        btnDesactivar154.setEnabled(true);
        btnDesactivar155.setEnabled(true);
        btnDesactivar156.setEnabled(true);
        
        try {
                btnActivarDesactivarMenuCliente();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarMenuEmpleado();

            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarMenuVentas();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarMenuPedidos();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarMenuBancos();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarMenuPiezas();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarMenuVehiculos();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionEmpleadosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }

            try {
                btnActivarDesactivarPermisoSeccionCargosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCargosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosBuscarUsuario();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosBuscarEmpleado();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionUsuariosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialSueldosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialSueldosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialCargosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialCargosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionClientesAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionClientesReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }

            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoDocumentoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
        
        
        try {
                btnActivarDesactivarPermisoSeccionBancosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBancosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionPrestamosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosBuscarCliente();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosBuscarBanco();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPrestamosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosAgregarPedido();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosAgregarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosAgregarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosBuscarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPedidosBuscarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionListadoPedidosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionListadoPedidosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionListadoPedidosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionPiezasAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionPiezasReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPiezaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosPiezaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarPiezaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionVehiculosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVehiculosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionMarcaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionColorAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionColorModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionColorDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionColorReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionColorReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCabinaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoCombustibleReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoTransmisionReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionNumeroAsientosReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoVehiculoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
        
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionHistorialPreciosVehiculoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionBuscarVehiculoExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionVentasAgregarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasAgregarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasBuscarPieza();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasBuscarVehiculo();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionVentasGenerarVenta();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoFacturaReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionTipoPagoReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            
            try {
                btnActivarDesactivarPermisoSeccionCaiAgregar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiModificar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiDesactivar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiReportePdf();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionCaiReporteExcel();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            
            try {
                btnActivarDesactivarPermisoSeccionFacturasRechazadasRechazar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionFacturasRechazadasBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionReporteBuscar();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
            try {
                btnActivarDesactivarPermisoSeccionReporteReportePdfTabla();
            } catch (Exception ex) {
                Validaciones.modulolog( FrmSeguridad1.class.getName(),ex,"SeleccionIDUsuario");
            }
        }
    }
}
}
    }//GEN-LAST:event_cmbUsuarioItemStateChanged

    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnDesactivar1;
    private javax.swing.JButton btnDesactivar10;
    private javax.swing.JButton btnDesactivar100;
    private javax.swing.JButton btnDesactivar101;
    private javax.swing.JButton btnDesactivar102;
    private javax.swing.JButton btnDesactivar103;
    private javax.swing.JButton btnDesactivar104;
    private javax.swing.JButton btnDesactivar105;
    private javax.swing.JButton btnDesactivar106;
    private javax.swing.JButton btnDesactivar107;
    private javax.swing.JButton btnDesactivar108;
    private javax.swing.JButton btnDesactivar109;
    private javax.swing.JButton btnDesactivar11;
    private javax.swing.JButton btnDesactivar110;
    private javax.swing.JButton btnDesactivar111;
    private javax.swing.JButton btnDesactivar112;
    private javax.swing.JButton btnDesactivar113;
    private javax.swing.JButton btnDesactivar114;
    private javax.swing.JButton btnDesactivar115;
    private javax.swing.JButton btnDesactivar116;
    private javax.swing.JButton btnDesactivar117;
    private javax.swing.JButton btnDesactivar118;
    private javax.swing.JButton btnDesactivar119;
    private javax.swing.JButton btnDesactivar12;
    private javax.swing.JButton btnDesactivar120;
    private javax.swing.JButton btnDesactivar121;
    private javax.swing.JButton btnDesactivar122;
    private javax.swing.JButton btnDesactivar123;
    private javax.swing.JButton btnDesactivar124;
    private javax.swing.JButton btnDesactivar125;
    private javax.swing.JButton btnDesactivar126;
    private javax.swing.JButton btnDesactivar127;
    private javax.swing.JButton btnDesactivar128;
    private javax.swing.JButton btnDesactivar129;
    private javax.swing.JButton btnDesactivar13;
    private javax.swing.JButton btnDesactivar130;
    private javax.swing.JButton btnDesactivar131;
    private javax.swing.JButton btnDesactivar132;
    private javax.swing.JButton btnDesactivar133;
    private javax.swing.JButton btnDesactivar134;
    private javax.swing.JButton btnDesactivar135;
    private javax.swing.JButton btnDesactivar136;
    private javax.swing.JButton btnDesactivar137;
    private javax.swing.JButton btnDesactivar138;
    private javax.swing.JButton btnDesactivar139;
    private javax.swing.JButton btnDesactivar14;
    private javax.swing.JButton btnDesactivar140;
    private javax.swing.JButton btnDesactivar144;
    private javax.swing.JButton btnDesactivar145;
    private javax.swing.JButton btnDesactivar146;
    private javax.swing.JButton btnDesactivar147;
    private javax.swing.JButton btnDesactivar148;
    private javax.swing.JButton btnDesactivar149;
    private javax.swing.JButton btnDesactivar15;
    private javax.swing.JButton btnDesactivar150;
    private javax.swing.JButton btnDesactivar151;
    private javax.swing.JButton btnDesactivar152;
    private javax.swing.JButton btnDesactivar153;
    private javax.swing.JButton btnDesactivar154;
    private javax.swing.JButton btnDesactivar155;
    private javax.swing.JButton btnDesactivar156;
    private javax.swing.JButton btnDesactivar16;
    private javax.swing.JButton btnDesactivar17;
    private javax.swing.JButton btnDesactivar18;
    private javax.swing.JButton btnDesactivar19;
    private javax.swing.JButton btnDesactivar2;
    private javax.swing.JButton btnDesactivar20;
    private javax.swing.JButton btnDesactivar21;
    private javax.swing.JButton btnDesactivar22;
    private javax.swing.JButton btnDesactivar23;
    private javax.swing.JButton btnDesactivar24;
    private javax.swing.JButton btnDesactivar25;
    private javax.swing.JButton btnDesactivar26;
    private javax.swing.JButton btnDesactivar27;
    private javax.swing.JButton btnDesactivar28;
    private javax.swing.JButton btnDesactivar29;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnDesactivar30;
    private javax.swing.JButton btnDesactivar31;
    private javax.swing.JButton btnDesactivar32;
    private javax.swing.JButton btnDesactivar33;
    private javax.swing.JButton btnDesactivar34;
    private javax.swing.JButton btnDesactivar35;
    private javax.swing.JButton btnDesactivar36;
    private javax.swing.JButton btnDesactivar37;
    private javax.swing.JButton btnDesactivar39;
    private javax.swing.JButton btnDesactivar4;
    private javax.swing.JButton btnDesactivar40;
    private javax.swing.JButton btnDesactivar41;
    private javax.swing.JButton btnDesactivar42;
    private javax.swing.JButton btnDesactivar43;
    private javax.swing.JButton btnDesactivar44;
    private javax.swing.JButton btnDesactivar45;
    private javax.swing.JButton btnDesactivar46;
    private javax.swing.JButton btnDesactivar47;
    private javax.swing.JButton btnDesactivar48;
    private javax.swing.JButton btnDesactivar49;
    private javax.swing.JButton btnDesactivar5;
    private javax.swing.JButton btnDesactivar50;
    private javax.swing.JButton btnDesactivar51;
    private javax.swing.JButton btnDesactivar52;
    private javax.swing.JButton btnDesactivar53;
    private javax.swing.JButton btnDesactivar54;
    private javax.swing.JButton btnDesactivar55;
    private javax.swing.JButton btnDesactivar56;
    private javax.swing.JButton btnDesactivar57;
    private javax.swing.JButton btnDesactivar58;
    private javax.swing.JButton btnDesactivar59;
    private javax.swing.JButton btnDesactivar6;
    private javax.swing.JButton btnDesactivar60;
    private javax.swing.JButton btnDesactivar61;
    private javax.swing.JButton btnDesactivar62;
    private javax.swing.JButton btnDesactivar63;
    private javax.swing.JButton btnDesactivar64;
    private javax.swing.JButton btnDesactivar65;
    private javax.swing.JButton btnDesactivar66;
    private javax.swing.JButton btnDesactivar67;
    private javax.swing.JButton btnDesactivar68;
    private javax.swing.JButton btnDesactivar69;
    private javax.swing.JButton btnDesactivar7;
    private javax.swing.JButton btnDesactivar70;
    private javax.swing.JButton btnDesactivar71;
    private javax.swing.JButton btnDesactivar72;
    private javax.swing.JButton btnDesactivar73;
    private javax.swing.JButton btnDesactivar74;
    private javax.swing.JButton btnDesactivar77;
    private javax.swing.JButton btnDesactivar78;
    private javax.swing.JButton btnDesactivar8;
    private javax.swing.JButton btnDesactivar80;
    private javax.swing.JButton btnDesactivar81;
    private javax.swing.JButton btnDesactivar82;
    private javax.swing.JButton btnDesactivar83;
    private javax.swing.JButton btnDesactivar84;
    private javax.swing.JButton btnDesactivar85;
    private javax.swing.JButton btnDesactivar86;
    private javax.swing.JButton btnDesactivar87;
    private javax.swing.JButton btnDesactivar88;
    private javax.swing.JButton btnDesactivar89;
    private javax.swing.JButton btnDesactivar9;
    private javax.swing.JButton btnDesactivar90;
    private javax.swing.JButton btnDesactivar91;
    private javax.swing.JButton btnDesactivar92;
    private javax.swing.JButton btnDesactivar93;
    private javax.swing.JButton btnDesactivar94;
    private javax.swing.JButton btnDesactivar96;
    private javax.swing.JButton btnDesactivar97;
    private javax.swing.JButton btnDesactivar99;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cmbIDAcceso;
    public javax.swing.JComboBox<String> cmbUsuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable tblAcceso;
    // End of variables declaration//GEN-END:variables
}
