/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

import Clases.HistoricoPrecioVehiculos;
import Clases.Marca;
import Clases.TipoGasolina;
import Clases.TipoVehiculo;
import Clases.Tipo_color;
import Clases.Vehiculo;
import JPAController.HistoricoPrecioVehiculosJpaController;
import JPAController.MarcaJpaController;
import JPAController.Numero_AsientosJpaController;
import JPAController.TipoCabinaJpaController;
import JPAController.TipoGasolinaJpaController;
import JPAController.TipoVehiculoJpaController;
import JPAController.Tipo_colorJpaController;
import JPAController.VehiculoJpaController;
import JPAController.transmisionJpaController;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kur013
 */
public class ModalVehiculos extends javax.swing.JDialog {

    MarcaJpaController Marcadao = new MarcaJpaController();
    Tipo_colorJpaController Colorrdao = new Tipo_colorJpaController();
    TipoCabinaJpaController TipoCabinadao = new TipoCabinaJpaController();
    TipoGasolinaJpaController TipoGasolinadao = new TipoGasolinaJpaController();
    transmisionJpaController TipoTransmisiondao = new transmisionJpaController();
    TipoVehiculoJpaController TipoVehiculodao = new TipoVehiculoJpaController();
    Numero_AsientosJpaController NumeroAsientosdao = new Numero_AsientosJpaController();
    VehiculoJpaController vehiculoDao = new VehiculoJpaController();
    HistoricoPrecioVehiculosJpaController historicoPrecioVehiculoDao = new HistoricoPrecioVehiculosJpaController();

    int id=0;
    /**
     * Creates new form ModalVehiculos
     */
    public ModalVehiculos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public int getId() {
        return id;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel46 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(720, 560));

        jPanel2.setLayout(null);

        chkMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMarcaItemStateChanged(evt);
            }
        });
        jPanel2.add(chkMarca);
        chkMarca.setBounds(200, 66, 21, 21);

        chkColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkColorItemStateChanged(evt);
            }
        });
        jPanel2.add(chkColor);
        chkColor.setBounds(200, 94, 21, 21);

        chkTipoVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTipoVehiculoItemStateChanged(evt);
            }
        });
        jPanel2.add(chkTipoVehiculo);
        chkTipoVehiculo.setBounds(200, 125, 21, 21);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Marca:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(59, 70, 40, 14);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Color:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(58, 97, 40, 14);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tipo de Vehiculo:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(2, 125, 150, 28);

        cmbMarcaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Chevrolet", "Honda" }));
        cmbMarcaBusqueda.setEnabled(false);
        jPanel2.add(cmbMarcaBusqueda);
        cmbMarcaBusqueda.setBounds(96, 67, 102, 28);

        cmbColorBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negro", "Rojo", "Azul", " " }));
        cmbColorBusqueda.setEnabled(false);
        jPanel2.add(cmbColorBusqueda);
        cmbColorBusqueda.setBounds(96, 94, 102, 28);

        cmbTipoVehiculoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deportivo", "Comercial", " " }));
        cmbTipoVehiculoBusqueda.setEnabled(false);
        jPanel2.add(cmbTipoVehiculoBusqueda);
        cmbTipoVehiculoBusqueda.setBounds(96, 125, 102, 28);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tipo de Combustible:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(250, 71, 180, 14);

        cmbGasolinaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diesel", " " }));
        cmbGasolinaBusqueda.setEnabled(false);
        jPanel2.add(cmbGasolinaBusqueda);
        cmbGasolinaBusqueda.setBounds(375, 68, 102, 28);

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
        jPanel2.add(chkTipoGasolina);
        chkTipoGasolina.setBounds(479, 67, 21, 21);

        tbBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "VIN", "Marca", "Color", "Tipo de Gasolina", "Tipo de Vehiculo", "Numero de asientos", "Cilindraje", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbBusqueda);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 171, 1270, 184);

        jLabel46.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel46.setText("Busqueda por Filtro");
        jPanel2.add(jLabel46);
        jLabel46.setBounds(517, 11, 230, 35);

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(490, 106, 120, 39);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(375, 106, 102, 39);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jLabel19.setText("jLabel19");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(0, 0, 1780, 780);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1754, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void createcmbTipoGasolinaBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbGasolinaBusqueda.setModel(modelo);
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoGasolina());
        });
    }
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

    private void createcmbColorBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbColorBusqueda.setModel(modelo);
        List<Tipo_color > temp = Colorrdao.findTipo_colorEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipo_color());
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

    private void chkTipoGasolinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTipoGasolinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTipoGasolinaActionPerformed

    private void createTableBusqueda(){
        DefaultTableModel modelo = new DefaultTableModel();
        tbBusqueda.setModel(modelo);
        modelo.addColumn("ID");
        
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Color");
        modelo.addColumn("Combustible");
        modelo.addColumn("Tipo de vehiculo");
        modelo.addColumn("Numero de asientos");
        modelo.addColumn("Precio");
        
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
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
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
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        createTableBusqueda();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = tbBusqueda.getSelectedRow();
        if (fila > -1){
            id =(Integer.parseInt(tbBusqueda.getModel().getValueAt(fila, 0).toString()));
            
        }
        
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkColor;
    private javax.swing.JCheckBox chkMarca;
    private javax.swing.JCheckBox chkTipoGasolina;
    private javax.swing.JCheckBox chkTipoVehiculo;
    private javax.swing.JComboBox<String> cmbColorBusqueda;
    private javax.swing.JComboBox<String> cmbGasolinaBusqueda;
    private javax.swing.JComboBox<String> cmbMarcaBusqueda;
    private javax.swing.JComboBox<String> cmbTipoVehiculoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbBusqueda;
    // End of variables declaration//GEN-END:variables
}