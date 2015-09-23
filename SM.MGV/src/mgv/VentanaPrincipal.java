/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgv;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import sm.mgv.imagen.Umbralizacion;
import sm.mgv.iu.Lienzo2DImagen;

/**
 * Vista de la ventana principal
 * @author araluce
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    //Tipo de figura seleccionada
    int forma = 0;
    
    static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.WHITE, Color.YELLOW, Color.GREEN};
    int relleno = 0;
    
    static int ancho;
    static int alto;

    /**
     * Constructor de VentanaPrincipal()
     */
    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
        inicializar_botones();
        jComboBox_Fondo.setVisible(false);
        jToggleButton_Degradado.setVisible(false);
        jComboBox_Degradado.setVisible(false);
        ancho = alto = 300;
    }
  
    
    /**
     * Controlador para manejar los botones de las figuras
     */
    public void inicializar_botones(){
        //Seleccion = 1
        //Punto = 1
        //Linea = 2
        //Rectangulo = 3
        //Ovalo = 4
        //Rectangulo redondeado = 5
        //Linea curva = 6
        if (forma == 0){
            jToggleButton_Seleccionar.setSelected(true);
            jToggleButton_Punto.setSelected(false);
            jToggleButton_Linea.setSelected(false);
            jToggleButton_Rectangulo.setSelected(false);
            jToggleButton_Ovalo.setSelected(false);
            jToggleButton_RectanguloRedondeado.setSelected(false);
            jToggleButton_LineaCurva.setSelected(false);
            jLabel_Estado.setText("Seleccion");
        }
        if (forma == 1){
            jToggleButton_Seleccionar.setSelected(false);
            jToggleButton_Punto.setSelected(true);
            jToggleButton_Linea.setSelected(false);
            jToggleButton_Rectangulo.setSelected(false);
            jToggleButton_Ovalo.setSelected(false);
            jToggleButton_RectanguloRedondeado.setSelected(false);
            jToggleButton_LineaCurva.setSelected(false);
            jLabel_Estado.setText("Punto");
        }
        if (forma == 2){
            jToggleButton_Seleccionar.setSelected(false);
            jToggleButton_Punto.setSelected(false);
            jToggleButton_Linea.setSelected(true);
            jToggleButton_Rectangulo.setSelected(false);
            jToggleButton_Ovalo.setSelected(false);  
            jToggleButton_RectanguloRedondeado.setSelected(false);
            jToggleButton_LineaCurva.setSelected(false);
            jLabel_Estado.setText("Linea");
        }
        if (forma == 3){
            jToggleButton_Seleccionar.setSelected(false);
            jToggleButton_Punto.setSelected(false);
            jToggleButton_Linea.setSelected(false);
            jToggleButton_Rectangulo.setSelected(true);
            jToggleButton_Ovalo.setSelected(false); 
            jToggleButton_RectanguloRedondeado.setSelected(false);
            jToggleButton_LineaCurva.setSelected(false);
            jLabel_Estado.setText("Rectangulo");
        }
        if (forma == 4){
            jToggleButton_Seleccionar.setSelected(false);
            jToggleButton_Punto.setSelected(false);
            jToggleButton_Linea.setSelected(false);
            jToggleButton_Rectangulo.setSelected(false);
            jToggleButton_Ovalo.setSelected(true);  
            jToggleButton_RectanguloRedondeado.setSelected(false);
            jToggleButton_LineaCurva.setSelected(false);
            jLabel_Estado.setText("Ovalo");
        }
        if (forma == 5){
            jToggleButton_Seleccionar.setSelected(false);
            jToggleButton_Punto.setSelected(false);
            jToggleButton_Linea.setSelected(false);
            jToggleButton_Rectangulo.setSelected(false);
            jToggleButton_Ovalo.setSelected(false);  
            jToggleButton_RectanguloRedondeado.setSelected(true);
            jToggleButton_LineaCurva.setSelected(false);
            jLabel_Estado.setText("Ovalo");
        }
        if (forma == 6){
            jToggleButton_Seleccionar.setSelected(false);
            jToggleButton_Punto.setSelected(false);
            jToggleButton_Linea.setSelected(false);
            jToggleButton_Rectangulo.setSelected(false);
            jToggleButton_Ovalo.setSelected(false);  
            jToggleButton_RectanguloRedondeado.setSelected(false);
            jToggleButton_LineaCurva.setSelected(true);
            jLabel_Estado.setText("Ovalo");
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

        jButton_Negro = new javax.swing.JButton();
        jButton_Rojo = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToolBar_Formas = new javax.swing.JToolBar();
        jButton_Nuevo = new javax.swing.JButton();
        jButton_Abrir = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jToggleButton_Seleccionar = new javax.swing.JToggleButton();
        jToggleButton_Punto = new javax.swing.JToggleButton();
        jToggleButton_Linea = new javax.swing.JToggleButton();
        jToggleButton_Rectangulo = new javax.swing.JToggleButton();
        jToggleButton_RectanguloRedondeado = new javax.swing.JToggleButton();
        jToggleButton_Ovalo = new javax.swing.JToggleButton();
        jToggleButton_LineaCurva = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jComboBox_Color = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jSpinner_Grosor = new javax.swing.JSpinner();
        jToggleButton_Rellenar = new javax.swing.JToggleButton();
        jToggleButton_Transparencia = new javax.swing.JToggleButton();
        jToggleButton_Alisar = new javax.swing.JToggleButton();
        jToggleButton_Discontinuo = new javax.swing.JToggleButton();
        jComboBox_Fondo = new javax.swing.JComboBox();
        jToggleButton_Degradado = new javax.swing.JToggleButton();
        jComboBox_Degradado = new javax.swing.JComboBox();
        jDesktop_Escritorio = new javax.swing.JDesktopPane();
        jToolBar_Atributos = new javax.swing.JToolBar();
        jPanel_Brillo = new javax.swing.JPanel();
        jSlider_Brillo = new javax.swing.JSlider();
        jPanel_Filtro = new javax.swing.JPanel();
        jComboBox_Filtro = new javax.swing.JComboBox();
        jPanel_Contraste = new javax.swing.JPanel();
        jButton_Contraste = new javax.swing.JButton();
        jButton_Iluminar = new javax.swing.JButton();
        jButton_Oscurecer = new javax.swing.JButton();
        jPanel_Rotacion = new javax.swing.JPanel();
        jSlider_Rotacion = new javax.swing.JSlider();
        jButton_Rotar_90 = new javax.swing.JButton();
        jButton_Rotar_180 = new javax.swing.JButton();
        jButton_Rotar_270 = new javax.swing.JButton();
        jPanel_Escala = new javax.swing.JPanel();
        jButton_Aumentar = new javax.swing.JButton();
        jButtonDisminuir = new javax.swing.JButton();
        jPanel_Umbralizacion = new javax.swing.JPanel();
        jSlider_Umbralizacion = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        jButton_Duplicar = new javax.swing.JButton();
        jButton_Negativo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSlider_Grises = new javax.swing.JSlider();
        jPanel_Estado = new javax.swing.JPanel();
        jLabel_Estado = new javax.swing.JLabel();
        jToolBar_Medios = new javax.swing.JToolBar();
        jButton_Camara = new javax.swing.JButton();
        jButton_Capturar = new javax.swing.JButton();
        jButton_Record = new javax.swing.JButton();
        jMenuBar_Menu = new javax.swing.JMenuBar();
        jMenu_Archivo = new javax.swing.JMenu();
        jMenuItem_Nuevo = new javax.swing.JMenuItem();
        jMenuItem_Abrir = new javax.swing.JMenuItem();
        jMenuItem_Guardar = new javax.swing.JMenuItem();
        jMenu_Editar = new javax.swing.JMenu();
        jCheckBoxMenuItem_BarraEstado = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem_Formas = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem_Atributos = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem_Medios = new javax.swing.JCheckBoxMenuItem();
        jMenu_Ayuda = new javax.swing.JMenu();
        jMenuItem_AcercaDe = new javax.swing.JMenuItem();

        jButton_Negro.setText("jButton1");

        jButton_Rojo.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Final SM - Miguel Ángel García Villegas");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jToolBar_Formas.setFloatable(false);
        jToolBar_Formas.setRollover(true);

        jButton_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/nuevo.png"))); // NOI18N
        jButton_Nuevo.setToolTipText("Nuevo");
        jButton_Nuevo.setFocusable(false);
        jButton_Nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NuevoActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jButton_Nuevo);

        jButton_Abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/abrir.png"))); // NOI18N
        jButton_Abrir.setToolTipText("Abrir");
        jButton_Abrir.setFocusable(false);
        jButton_Abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AbrirActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jButton_Abrir);

        jButton_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/guardar.png"))); // NOI18N
        jButton_Guardar.setToolTipText("Guardar");
        jButton_Guardar.setFocusable(false);
        jButton_Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jButton_Guardar);
        jToolBar_Formas.add(jSeparator1);

        jToggleButton_Seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/seleccion.png"))); // NOI18N
        jToggleButton_Seleccionar.setToolTipText("Seleccionar");
        jToggleButton_Seleccionar.setFocusable(false);
        jToggleButton_Seleccionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Seleccionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_SeleccionarActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Seleccionar);

        jToggleButton_Punto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/punto.png"))); // NOI18N
        jToggleButton_Punto.setToolTipText("Punto");
        jToggleButton_Punto.setFocusable(false);
        jToggleButton_Punto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Punto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Punto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_PuntoActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Punto);

        jToggleButton_Linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/linea.png"))); // NOI18N
        jToggleButton_Linea.setToolTipText("Linea");
        jToggleButton_Linea.setFocusable(false);
        jToggleButton_Linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_LineaActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Linea);

        jToggleButton_Rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/rectangulo.png"))); // NOI18N
        jToggleButton_Rectangulo.setToolTipText("Rectangulo");
        jToggleButton_Rectangulo.setFocusable(false);
        jToggleButton_Rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Rectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_RectanguloActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Rectangulo);

        jToggleButton_RectanguloRedondeado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/RectanguloRedondeado.png"))); // NOI18N
        jToggleButton_RectanguloRedondeado.setFocusable(false);
        jToggleButton_RectanguloRedondeado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_RectanguloRedondeado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_RectanguloRedondeado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_RectanguloRedondeadoActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_RectanguloRedondeado);

        jToggleButton_Ovalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/elipse.png"))); // NOI18N
        jToggleButton_Ovalo.setToolTipText("Elipse");
        jToggleButton_Ovalo.setFocusable(false);
        jToggleButton_Ovalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Ovalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Ovalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_OvaloActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Ovalo);

        jToggleButton_LineaCurva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/PuntoControl.gif"))); // NOI18N
        jToggleButton_LineaCurva.setFocusable(false);
        jToggleButton_LineaCurva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_LineaCurva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_LineaCurva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_LineaCurvaActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_LineaCurva);
        jToolBar_Formas.add(jSeparator2);

        jComboBox_Color.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negro", "Rojo", "Azul", "Blanco", "Amarillo", "Verde", "Seleccionar color" }));
        jComboBox_Color.setToolTipText("Color");
        jComboBox_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_ColorMouseClicked(evt);
            }
        });
        jComboBox_Color.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_ColorItemStateChanged(evt);
            }
        });
        jToolBar_Formas.add(jComboBox_Color);
        jToolBar_Formas.add(jSeparator3);

        jSpinner_Grosor.setToolTipText("Grosor");
        jSpinner_Grosor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSpinner_Grosor.setValue(1);
        jSpinner_Grosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_GrosorStateChanged(evt);
            }
        });
        jToolBar_Formas.add(jSpinner_Grosor);

        jToggleButton_Rellenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/rellenar.png"))); // NOI18N
        jToggleButton_Rellenar.setToolTipText("Rellenar");
        jToggleButton_Rellenar.setFocusable(false);
        jToggleButton_Rellenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Rellenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Rellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_RellenarActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Rellenar);

        jToggleButton_Transparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/transparencia.png"))); // NOI18N
        jToggleButton_Transparencia.setToolTipText("Transparencia");
        jToggleButton_Transparencia.setFocusable(false);
        jToggleButton_Transparencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Transparencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Transparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_TransparenciaActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Transparencia);

        jToggleButton_Alisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/alisar.png"))); // NOI18N
        jToggleButton_Alisar.setToolTipText("Alisar");
        jToggleButton_Alisar.setFocusable(false);
        jToggleButton_Alisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Alisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Alisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_AlisarActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Alisar);

        jToggleButton_Discontinuo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Discontinuo.png"))); // NOI18N
        jToggleButton_Discontinuo.setToolTipText("Aplicar trama discontinua");
        jToggleButton_Discontinuo.setFocusable(false);
        jToggleButton_Discontinuo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Discontinuo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Discontinuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_DiscontinuoActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Discontinuo);

        jComboBox_Fondo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negro", "Rojo", "Azul", "Blanco", "Amarillo", "Verde", "Seleccionar color" }));
        jComboBox_Fondo.setToolTipText("Color de fondo");
        jComboBox_Fondo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_FondoItemStateChanged(evt);
            }
        });
        jComboBox_Fondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_FondoActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jComboBox_Fondo);

        jToggleButton_Degradado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Degradado.png"))); // NOI18N
        jToggleButton_Degradado.setToolTipText("Aplicar degradado");
        jToggleButton_Degradado.setFocusable(false);
        jToggleButton_Degradado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Degradado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton_Degradado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_DegradadoActionPerformed(evt);
            }
        });
        jToolBar_Formas.add(jToggleButton_Degradado);

        jComboBox_Degradado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Degradado vertical", "Degradado horizontal" }));
        jComboBox_Degradado.setToolTipText("Aplicar degradado");
        jComboBox_Degradado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_DegradadoItemStateChanged(evt);
            }
        });
        jToolBar_Formas.add(jComboBox_Degradado);

        jDesktop_Escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jDesktop_EscritorioLayout = new javax.swing.GroupLayout(jDesktop_Escritorio);
        jDesktop_Escritorio.setLayout(jDesktop_EscritorioLayout);
        jDesktop_EscritorioLayout.setHorizontalGroup(
            jDesktop_EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktop_EscritorioLayout.setVerticalGroup(
            jDesktop_EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jToolBar_Atributos.setFloatable(false);
        jToolBar_Atributos.setRollover(true);

        jPanel_Brillo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Brillo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jSlider_Brillo.setMaximum(150);
        jSlider_Brillo.setMinimum(-150);
        jSlider_Brillo.setPaintLabels(true);
        jSlider_Brillo.setToolTipText("Establecer brillo de la figura ");
        jSlider_Brillo.setValue(0);
        jSlider_Brillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_BrilloStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel_BrilloLayout = new javax.swing.GroupLayout(jPanel_Brillo);
        jPanel_Brillo.setLayout(jPanel_BrilloLayout);
        jPanel_BrilloLayout.setHorizontalGroup(
            jPanel_BrilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BrilloLayout.createSequentialGroup()
                .addComponent(jSlider_Brillo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_BrilloLayout.setVerticalGroup(
            jPanel_BrilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSlider_Brillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jToolBar_Atributos.add(jPanel_Brillo);

        jPanel_Filtro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Filtro"));
        jPanel_Filtro.setToolTipText("Filtro");

        jComboBox_Filtro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Media", "Binomial", "Enfoque", "Relieve", "Laplacaino" }));
        jComboBox_Filtro.setToolTipText("Filtro");
        jComboBox_Filtro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_FiltroItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel_FiltroLayout = new javax.swing.GroupLayout(jPanel_Filtro);
        jPanel_Filtro.setLayout(jPanel_FiltroLayout);
        jPanel_FiltroLayout.setHorizontalGroup(
            jPanel_FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel_FiltroLayout.setVerticalGroup(
            jPanel_FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jToolBar_Atributos.add(jPanel_Filtro);

        jPanel_Contraste.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Contraste"));

        jButton_Contraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/contraste.png"))); // NOI18N
        jButton_Contraste.setToolTipText("Contraste");
        jButton_Contraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ContrasteActionPerformed(evt);
            }
        });

        jButton_Iluminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/iluminar.png"))); // NOI18N
        jButton_Iluminar.setToolTipText("Iluminar");
        jButton_Iluminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IluminarActionPerformed(evt);
            }
        });

        jButton_Oscurecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/oscurecer.png"))); // NOI18N
        jButton_Oscurecer.setToolTipText("Oscurecer");
        jButton_Oscurecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OscurecerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ContrasteLayout = new javax.swing.GroupLayout(jPanel_Contraste);
        jPanel_Contraste.setLayout(jPanel_ContrasteLayout);
        jPanel_ContrasteLayout.setHorizontalGroup(
            jPanel_ContrasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ContrasteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Contraste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Iluminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Oscurecer)
                .addContainerGap())
        );
        jPanel_ContrasteLayout.setVerticalGroup(
            jPanel_ContrasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ContrasteLayout.createSequentialGroup()
                .addGroup(jPanel_ContrasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Iluminar)
                    .addComponent(jButton_Contraste)
                    .addComponent(jButton_Oscurecer))
                .addContainerGap())
        );

        jToolBar_Atributos.add(jPanel_Contraste);

        jPanel_Rotacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Rotación", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel_Rotacion.setFocusable(false);

        jSlider_Rotacion.setMaximum(360);
        jSlider_Rotacion.setPaintLabels(true);
        jSlider_Rotacion.setPaintTicks(true);
        jSlider_Rotacion.setSnapToTicks(true);
        jSlider_Rotacion.setToolTipText("Rotar la figura (0,360)");
        jSlider_Rotacion.setValue(0);
        jSlider_Rotacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_RotacionStateChanged(evt);
            }
        });

        jButton_Rotar_90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/rotacion90.png"))); // NOI18N
        jButton_Rotar_90.setToolTipText("Rotar 90 grados");
        jButton_Rotar_90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Rotar_90ActionPerformed(evt);
            }
        });

        jButton_Rotar_180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/rotacion180.png"))); // NOI18N
        jButton_Rotar_180.setToolTipText("Rotar 180 grados");
        jButton_Rotar_180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Rotar_180ActionPerformed(evt);
            }
        });

        jButton_Rotar_270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/rotacion270.png"))); // NOI18N
        jButton_Rotar_270.setToolTipText("Rotar 270 grados");
        jButton_Rotar_270.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Rotar_270ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_RotacionLayout = new javax.swing.GroupLayout(jPanel_Rotacion);
        jPanel_Rotacion.setLayout(jPanel_RotacionLayout);
        jPanel_RotacionLayout.setHorizontalGroup(
            jPanel_RotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RotacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider_Rotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Rotar_90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Rotar_180)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Rotar_270)
                .addContainerGap())
        );
        jPanel_RotacionLayout.setVerticalGroup(
            jPanel_RotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton_Rotar_180)
            .addComponent(jSlider_Rotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel_RotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jButton_Rotar_270, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Rotar_90, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar_Atributos.add(jPanel_Rotacion);

        jPanel_Escala.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Escala", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel_Escala.setFocusable(false);

        jButton_Aumentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/aumentar.png"))); // NOI18N
        jButton_Aumentar.setToolTipText("Aumentar");
        jButton_Aumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AumentarActionPerformed(evt);
            }
        });

        jButtonDisminuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/disminuir.png"))); // NOI18N
        jButtonDisminuir.setToolTipText("Disminuir");
        jButtonDisminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisminuirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_EscalaLayout = new javax.swing.GroupLayout(jPanel_Escala);
        jPanel_Escala.setLayout(jPanel_EscalaLayout);
        jPanel_EscalaLayout.setHorizontalGroup(
            jPanel_EscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_EscalaLayout.createSequentialGroup()
                .addComponent(jButton_Aumentar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDisminuir)
                .addContainerGap())
        );
        jPanel_EscalaLayout.setVerticalGroup(
            jPanel_EscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_EscalaLayout.createSequentialGroup()
                .addGroup(jPanel_EscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Aumentar)
                    .addComponent(jButtonDisminuir))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jToolBar_Atributos.add(jPanel_Escala);

        jPanel_Umbralizacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Umbralizacion", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel_Umbralizacion.setFocusable(false);

        jSlider_Umbralizacion.setMaximum(255);
        jSlider_Umbralizacion.setToolTipText("Establecer umbral (0,255)");
        jSlider_Umbralizacion.setValue(127);
        jSlider_Umbralizacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_UmbralizacionStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel_UmbralizacionLayout = new javax.swing.GroupLayout(jPanel_Umbralizacion);
        jPanel_Umbralizacion.setLayout(jPanel_UmbralizacionLayout);
        jPanel_UmbralizacionLayout.setHorizontalGroup(
            jPanel_UmbralizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_UmbralizacionLayout.createSequentialGroup()
                .addComponent(jSlider_Umbralizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_UmbralizacionLayout.setVerticalGroup(
            jPanel_UmbralizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSlider_Umbralizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jToolBar_Atributos.add(jPanel_Umbralizacion);

        jButton_Duplicar.setText("Duplicar");
        jButton_Duplicar.setToolTipText("Duplicar en un lienzo nuevo");
        jButton_Duplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DuplicarActionPerformed(evt);
            }
        });

        jButton_Negativo.setText("Negativo");
        jButton_Negativo.setToolTipText("Hacer negativo de la imagen");
        jButton_Negativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NegativoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton_Duplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Negativo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Duplicar)
                    .addComponent(jButton_Negativo))
                .addContainerGap())
        );

        jToolBar_Atributos.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Niveles de grises", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jSlider_Grises.setMaximum(255);
        jSlider_Grises.setToolTipText("Aplicar niveles de grises");
        jSlider_Grises.setValue(127);
        jSlider_Grises.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_GrisesStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jSlider_Grises, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSlider_Grises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jToolBar_Atributos.add(jPanel3);

        jPanel_Estado.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel_Estado.setText("Barra de estado: ");
        jLabel_Estado.setToolTipText("Barra de estado [Herramienta]");

        javax.swing.GroupLayout jPanel_EstadoLayout = new javax.swing.GroupLayout(jPanel_Estado);
        jPanel_Estado.setLayout(jPanel_EstadoLayout);
        jPanel_EstadoLayout.setHorizontalGroup(
            jPanel_EstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_EstadoLayout.createSequentialGroup()
                .addComponent(jLabel_Estado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_EstadoLayout.setVerticalGroup(
            jPanel_EstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_EstadoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Estado))
        );

        jToolBar_Medios.setFloatable(false);
        jToolBar_Medios.setRollover(true);

        jButton_Camara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Camara.png"))); // NOI18N
        jButton_Camara.setToolTipText("Cámara");
        jButton_Camara.setFocusable(false);
        jButton_Camara.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Camara.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Camara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CamaraActionPerformed(evt);
            }
        });
        jToolBar_Medios.add(jButton_Camara);

        jButton_Capturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Capturar.png"))); // NOI18N
        jButton_Capturar.setToolTipText("Hacer captura");
        jButton_Capturar.setFocusable(false);
        jButton_Capturar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Capturar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Capturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapturarActionPerformed(evt);
            }
        });
        jToolBar_Medios.add(jButton_Capturar);

        jButton_Record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/record24x24.png"))); // NOI18N
        jButton_Record.setFocusable(false);
        jButton_Record.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Record.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RecordActionPerformed(evt);
            }
        });
        jToolBar_Medios.add(jButton_Record);

        jMenu_Archivo.setText("Archivo");

        jMenuItem_Nuevo.setText("Nuevo");
        jMenuItem_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NuevoActionPerformed(evt);
            }
        });
        jMenu_Archivo.add(jMenuItem_Nuevo);

        jMenuItem_Abrir.setText("Abrir");
        jMenuItem_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AbrirActionPerformed(evt);
            }
        });
        jMenu_Archivo.add(jMenuItem_Abrir);

        jMenuItem_Guardar.setText("Guardar");
        jMenuItem_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GuardarActionPerformed(evt);
            }
        });
        jMenu_Archivo.add(jMenuItem_Guardar);

        jMenuBar_Menu.add(jMenu_Archivo);

        jMenu_Editar.setText("Editar");

        jCheckBoxMenuItem_BarraEstado.setSelected(true);
        jCheckBoxMenuItem_BarraEstado.setText("Ver barra de estado");
        jCheckBoxMenuItem_BarraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_BarraEstadoActionPerformed(evt);
            }
        });
        jMenu_Editar.add(jCheckBoxMenuItem_BarraEstado);

        jCheckBoxMenuItem_Formas.setSelected(true);
        jCheckBoxMenuItem_Formas.setText("Ver barra de Formas");
        jCheckBoxMenuItem_Formas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_FormasActionPerformed(evt);
            }
        });
        jMenu_Editar.add(jCheckBoxMenuItem_Formas);

        jCheckBoxMenuItem_Atributos.setSelected(true);
        jCheckBoxMenuItem_Atributos.setText("Ver barra de atributos");
        jCheckBoxMenuItem_Atributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_AtributosActionPerformed(evt);
            }
        });
        jMenu_Editar.add(jCheckBoxMenuItem_Atributos);

        jCheckBoxMenuItem_Medios.setSelected(true);
        jCheckBoxMenuItem_Medios.setText("Ver barra de medios");
        jCheckBoxMenuItem_Medios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_MediosActionPerformed(evt);
            }
        });
        jMenu_Editar.add(jCheckBoxMenuItem_Medios);

        jMenuBar_Menu.add(jMenu_Editar);

        jMenu_Ayuda.setText("Ayuda");

        jMenuItem_AcercaDe.setText("Acerca de");
        jMenuItem_AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AcercaDeActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_AcercaDe);

        jMenuBar_Menu.add(jMenu_Ayuda);

        setJMenuBar(jMenuBar_Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar_Formas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar_Atributos, javax.swing.GroupLayout.DEFAULT_SIZE, 1581, Short.MAX_VALUE)
            .addComponent(jPanel_Estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar_Medios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktop_Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar_Formas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar_Medios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktop_Escritorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar_Atributos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Controla los eventos de todos los botones de creación de lienzos
     * @param evt Evento
     */
    private void Nuevo(java.awt.event.ActionEvent evt){
        NuevoLienzo dialog = new NuevoLienzo(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        
        VentanaInterna vi = new VentanaInterna();
        vi.setSize(new Dimension(ancho,alto));
        jDesktop_Escritorio.add(vi);
        vi.setTitle("Nueva");
        vi.setVisible(true);
        
        Lienzo2DImagen l = new Lienzo2DImagen();
        l.setGrosor((Integer) jSpinner_Grosor.getValue());
        l.setColor(Color.BLACK);
        l.alisar(jToggleButton_Alisar.isSelected());
        l.transparencia(jToggleButton_Transparencia.isSelected());
        l.rellena(relleno);
    }
    
    /**
     * Llama a la función nuevo que maneja el evento para crear nuevos lienzos
     * @param evt Evento
     */
    private void jMenuItem_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevoActionPerformed
        Nuevo(evt);
    }//GEN-LAST:event_jMenuItem_NuevoActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    
    /**
     * Inicia la forma a 1 (Punto) y envía la nueva forma tomada al lienzo
     * Además llama al controlador de botones para distribuir la nueva posición
     * @param evt 
     */
    private void jToggleButton_PuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_PuntoActionPerformed
        forma = 1;
        inicializar_botones();
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.set_forma(1);
        }
    }//GEN-LAST:event_jToggleButton_PuntoActionPerformed

    /**
     * Inicia la forma a 2 (Línea) y envía la nueva forma tomada al lienzo
     * Además llama al controlador de botones para distribuir la nueva posición
     * @param evt 
     */
    private void jToggleButton_LineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_LineaActionPerformed
        forma = 2;
        inicializar_botones();
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.set_forma(2);
        }
    }//GEN-LAST:event_jToggleButton_LineaActionPerformed

    /**
     * Inicia la forma a 3 (Rectángulo) y envía la nueva forma tomada al lienzo
     * Además llama al controlador de botones para distribuir la nueva posición
     * @param evt 
     */
    private void jToggleButton_RectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_RectanguloActionPerformed
        forma = 3;
        inicializar_botones();
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.set_forma(3);
        }
    }//GEN-LAST:event_jToggleButton_RectanguloActionPerformed

    /**
     * Inicia la forma a 4 (Óvalo) y envía la nueva forma tomada al lienzo
     * Además llama al controlador de botones para distribuir la nueva posición
     * @param evt 
     */
    private void jToggleButton_OvaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_OvaloActionPerformed
        forma = 4;
        inicializar_botones();
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.set_forma(4);
        }
    }//GEN-LAST:event_jToggleButton_OvaloActionPerformed

    /**
     * Opción (ver barra de estado) si la opción está activa muestra la barra de estado, en caso contrario la oculta
     * @param evt 
     */
    private void jCheckBoxMenuItem_BarraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_BarraEstadoActionPerformed
        if(!jCheckBoxMenuItem_BarraEstado.isSelected()){
            jPanel_Estado.setVisible(false);
        }
        else{
            jPanel_Estado.setVisible(true);
            
        }
    }//GEN-LAST:event_jCheckBoxMenuItem_BarraEstadoActionPerformed
    
       
    /**
     * Llama a la función que controla la apertura de ficheros
     * @param evt 
     */
    private void jMenuItem_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AbrirActionPerformed
        Abrir(evt);
    }//GEN-LAST:event_jMenuItem_AbrirActionPerformed

    /**
     * Llama a la función que controla el salvado de los ficheros
     * @param evt 
     */
    private void jMenuItem_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GuardarActionPerformed
        Guardar(evt);
    }//GEN-LAST:event_jMenuItem_GuardarActionPerformed

    /**
     * Inicia la forma a 0 (Seleccionar) y envía la nueva forma tomada al lienzo
     * Además llama al controlador de botones para distribuir la nueva posición
     * @param evt 
     */
    private void jToggleButton_SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_SeleccionarActionPerformed
        forma = 0;
        inicializar_botones();
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.set_forma(0);
        }
    }//GEN-LAST:event_jToggleButton_SeleccionarActionPerformed

    /**
     * Llama a la función que se encarga de crear nuevos lienzos
     * @param evt 
     */
    private void jButton_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NuevoActionPerformed
        Nuevo(evt);
    }//GEN-LAST:event_jButton_NuevoActionPerformed

    private void jComboBox_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_ColorMouseClicked

    }//GEN-LAST:event_jComboBox_ColorMouseClicked

    /**
     * Botón: si se presiona se envía al lienzo la orden de escalar 1.15
     * @param evt 
     */
    private void jButton_AumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AumentarActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();  
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.escalar(1.15);
        }
    }//GEN-LAST:event_jButton_AumentarActionPerformed

    /**
     * Botón: si se presiona se envía al lienzo la orden de escalar 0.85
     * @param evt 
     */
    private void jButtonDisminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisminuirActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.escalar(0.85);
        }
    }//GEN-LAST:event_jButtonDisminuirActionPerformed

    /**
     * CheckBox: Opción (ver barra de formas) si la opción está activa muestra la barra de formas, 
     * en caso contrario la oculta
     * @param evt 
     */
    private void jCheckBoxMenuItem_FormasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_FormasActionPerformed
        if(!jCheckBoxMenuItem_Formas.isSelected()){
            jToolBar_Formas.setVisible(false);
        }
        else{
            jToolBar_Formas.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem_FormasActionPerformed

    /**
     * CheckBox: Opción (ver barra de atributos) si la opción está activa muestra la barra de atributos, 
     * en caso contrario la oculta
     * @param evt 
     */
    private void jCheckBoxMenuItem_AtributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_AtributosActionPerformed
        if(!jCheckBoxMenuItem_Atributos.isSelected()){
            jToolBar_Atributos.setVisible(false);
        }
        else{
            jToolBar_Atributos.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem_AtributosActionPerformed

    /**
     * Evento que envía el relleno (true/false) al lienzo
     * @param evt 
     */
    private void jToggleButton_RellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_RellenarActionPerformed
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            if(jToggleButton_Rellenar.isSelected()) {
                relleno = 1;
                jComboBox_Fondo.setVisible(true);
                jToggleButton_Degradado.setVisible(true);
            }
            else {
                relleno = 0;
                jComboBox_Fondo.setVisible(false);
                jToggleButton_Degradado.setVisible(false);
            }
            l.rellena(relleno);
        }
    }//GEN-LAST:event_jToggleButton_RellenarActionPerformed

    /**
     * Evento que envía la transparencia (true/false) al lienzo
     * @param evt 
     */
    private void jToggleButton_TransparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_TransparenciaActionPerformed
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.transparencia(jToggleButton_Transparencia.isSelected());
        }
    }//GEN-LAST:event_jToggleButton_TransparenciaActionPerformed

    /**
     * Evento que envía el alisado (true/false) al lienzo
     * @param evt 
     */
    private void jToggleButton_AlisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_AlisarActionPerformed
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.alisar(jToggleButton_Alisar.isSelected());
        }
    }//GEN-LAST:event_jToggleButton_AlisarActionPerformed

    /**
     * Manejador del evento lanzado al presionar el botón de rotar 180 grados
     * @param evt 
     */
    private void jButton_Rotar_180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Rotar_180ActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.rotar(180);
        }
        jSlider_Rotacion.setValue(180);
    }//GEN-LAST:event_jButton_Rotar_180ActionPerformed

    /**
     * Manejador del evento lanzado al presionar el botón de rotar 90 grados
     * @param evt 
     */
    private void jButton_Rotar_90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Rotar_90ActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.rotar(90);
        }
        jSlider_Rotacion.setValue(90);
    }//GEN-LAST:event_jButton_Rotar_90ActionPerformed

    /**
     * Manejador del evento lanzado al presionar el botón de rotar 270 grados
     * @param evt 
     */
    private void jButton_Rotar_270ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Rotar_270ActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.rotar(270);
        }
        jSlider_Rotacion.setValue(270);
    }//GEN-LAST:event_jButton_Rotar_270ActionPerformed

    /**
     * Manejador del evento lanzado al cambiar el valor del slider de la rotación
     * @param evt 
     */
    private void jSlider_RotacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_RotacionStateChanged
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.rotar(jSlider_Rotacion.getValue());
        }
//        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
//            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
//            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
//            BufferedImage imgSource = l.getImage();
//            if(imgSource!=null){
//                try{
//                    l.incrustarFiguras();
//                    double r = Math.toRadians(jSlider_Rotacion.getValue());
//                    Point p = new Point(imgSource.getWidth()/2, imgSource.getHeight()/2);
//                    AffineTransform at = AffineTransform.getRotateInstance(r,p.getX(),p.getY());
//                    AffineTransformOp atop;
//                    atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
//                    BufferedImage img = atop.filter(imgSource, null);
//                    l.setImage(img);
//                    l.repaint();
//                } catch(IllegalArgumentException e){
//                    System.err.println(e.getLocalizedMessage());
//                }
//            }
//        }
    }//GEN-LAST:event_jSlider_RotacionStateChanged

    /**
     * Manejador del evento lanzado al cambiar el valor del grosor
     * @param evt 
     */
    private void jSpinner_GrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_GrosorStateChanged
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.setGrosor((Integer) jSpinner_Grosor.getValue());
        }
    }//GEN-LAST:event_jSpinner_GrosorStateChanged

    /**
     * Manejador del evento lanzado al cambiar el valor del color de la figura
     * @param evt 
     */
    private void jComboBox_ColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_ColorItemStateChanged
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame(); 
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            switch((String)jComboBox_Color.getSelectedItem()){
                case "Negro":
                    l.setColor(Color.BLACK);
                    break;
                case "Rojo":
                    l.setColor(Color.RED);
                    break;
                case "Azul":
                    l.setColor(Color.BLUE);
                    break;
                case "Blanco":
                    l.setColor(Color.WHITE);
                    break;
                case "Amarillo":
                    l.setColor(Color.YELLOW);
                    break;
                case "Verde":
                    l.setColor(Color.GREEN);
                    break;
                case "Seleccionar color":
                    if (evt.getStateChange() == ItemEvent.SELECTED) {
                        JColorChooser Selectorcolor=new JColorChooser();
                        l.setColor(Selectorcolor.showDialog(null, "Seleccione un Color", Color.BLACK));
                    }
                    break;
            }
        }
    }//GEN-LAST:event_jComboBox_ColorItemStateChanged
    
    /**
     * Manejador del evento al que llaman los botones de abrir
     * @param evt 
     */
    private void Abrir(java.awt.event.ActionEvent evt){
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            try{
                File f = dlg.getSelectedFile();
                String extension = f.getName().substring(f.getName().length()-3);
                String ex2 = f.getName().substring(f.getName().length()-2);
                
                if("png".equals(extension) || "jpg".equals(extension) || "gif".equals(extension)||
                   "jpeg".equals(extension)){
                    VentanaInterna vi = new VentanaInterna();
                    Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
                    l.setImage(f);
                    this.jDesktop_Escritorio.add(vi);
                    vi.setTitle(f.getName());
                    vi.setVisible(true);
                }
                if("wav".equals(extension) || "au".equals(ex2)){
                    VentanaInternaReproductor vi = new VentanaInternaReproductor(f);
                    this.jDesktop_Escritorio.add(vi);
                    vi.setTitle(f.getName());
                    vi.setVisible(true);
                }
                if("mp3".equals(extension) || "avi".equals(extension)){
                    VentanaInternaJMFPlayer vi = new VentanaInternaJMFPlayer(f);
                    this.jDesktop_Escritorio.add(vi);
                    vi.setTitle(f.getName());
                    vi.setVisible(true);
                }
            }catch(Exception ex){ System.err.println("Error al leer la imagen");}
        }
    }
    
    /**
     * Manejador del evento al que llaman los botones de guardar
     * @param evt 
     */
    private void Guardar(java.awt.event.ActionEvent evt){
        VentanaInterna vi=(VentanaInterna) jDesktop_Escritorio.getSelectedFrame();
        if(vi!=null ){
            JFileChooser dlg = new JFileChooser();
            dlg.addChoosableFileFilter(new FileNameExtensionFilter("Archivo de imagen *.jpg", "jpg","JPG"));
            int resp = dlg.showSaveDialog(this);
            if (resp == JFileChooser.APPROVE_OPTION) {
                try {
                    if (vi != null){
                        Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
                        BufferedImage img = l.getImage();
                        if (img != null) {
                            File f = dlg.getSelectedFile();
                            String PATH = f.getAbsolutePath();
                            
                            l.Guardar(f);
                            img = l.getImage(); 
                            ImageIO.write(img, "jpg", f);
                            if(!(PATH.endsWith(".jpg"))){
                                File temp = new File(PATH+".jpg");
                                f.renameTo(temp);//renombramos el archivo
                            }
                            
                            vi.setTitle(f.getName());
                        }
                    }
                }catch (Exception ex) {
                    System.err.println("Error al guardar la imagen");
                }
            }
        }
        
    }
    
    /**
     * Manejador del evento que llama a Abrir()
     * @param evt 
     */
    private void jButton_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AbrirActionPerformed
        Abrir(evt);
    }//GEN-LAST:event_jButton_AbrirActionPerformed

    /**
     * Manejador del evento que llama a Guardar()
     * @param evt 
     */
    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        Guardar(evt);
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    /**
     * Manejador del evento lanzado al cambiar el valor del slider de brillo
     * @param evt 
     */
    private void jSlider_BrilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_BrilloStateChanged
        VentanaInterna vi = (VentanaInterna) (jDesktop_Escritorio.getSelectedFrame());
        Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
        if (vi != null) {
            BufferedImage imgSource = l.getImage();
            if(imgSource!=null){
                try{
                    l.brillo(jSlider_Brillo.getValue());
                } catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }

    }//GEN-LAST:event_jSlider_BrilloStateChanged

    /**
     * Manejador del evento lanzado al cambiar el valor del filtro
     * @param evt 
     */
    private void jComboBox_FiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_FiltroItemStateChanged
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();  
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            switch((String)jComboBox_Filtro.getSelectedItem()){
                case "Media":
                    l.aplicarFiltro(0);
                    break;
                case "Binomial":
                    l.aplicarFiltro(1);
                    break;
                case "Enfoque":
                    l.aplicarFiltro(2);
                    break;
                case "Relieve":
                    l.aplicarFiltro(3);
                    break;
                case "Laplacaino":
                    l.aplicarFiltro(4);
                    break;
            }
        }
    }//GEN-LAST:event_jComboBox_FiltroItemStateChanged

    /**
     * Manejador del evento contraste
     * @param evt 
     */
    private void jButton_ContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ContrasteActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();  
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.aplicarContraste(0);
        }
    }//GEN-LAST:event_jButton_ContrasteActionPerformed

    /**
     * Manejador del evento Iluminar
     * @param evt 
     */
    private void jButton_IluminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IluminarActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();  
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.aplicarContraste(1);
        }
    }//GEN-LAST:event_jButton_IluminarActionPerformed

    /**
     * Manejador del evento oscurecer
     * @param evt 
     */
    private void jButton_OscurecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OscurecerActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();  
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.aplicarContraste(2);
        }
    }//GEN-LAST:event_jButton_OscurecerActionPerformed

    /**
     * Manejador del evento lanzado al pulsar el botón de cámara
     * @param evt 
     */
    private void jButton_CamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CamaraActionPerformed
        VentanaInternaCamara vic = VentanaInternaCamara.getInstance();
        this.jDesktop_Escritorio.add(vic);
        vic.setTitle("WebCam");
        vic.setVisible(true);
    }//GEN-LAST:event_jButton_CamaraActionPerformed

    /**
     * Manejador del evento lanzado al pulsar el botón de captura
     * @param evt 
     */
    private void jButton_CapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapturarActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInternaCamara){
            VentanaInternaCamara vic=  (VentanaInternaCamara) jDesktop_Escritorio.getSelectedFrame();
            VentanaInterna vi = new VentanaInterna();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            
            l.setImage(vic.getFrame());
            
            vi.setTitle("Imagen capturada");
            jDesktop_Escritorio.add(vi);
            vi.setVisible(true);
        }
        
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInternaJMFPlayer){
            VentanaInternaJMFPlayer vic=  (VentanaInternaJMFPlayer) jDesktop_Escritorio.getSelectedFrame();
            VentanaInterna vi = new VentanaInterna();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            
            l.setImage(vic.getFrame());
            
            vi.setTitle("Imagen capturada");
            jDesktop_Escritorio.add(vi);
            vi.setVisible(true);
        }
    }//GEN-LAST:event_jButton_CapturarActionPerformed

    private void jSlider_UmbralizacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_UmbralizacionStateChanged
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            BufferedImage img = l.getImage();
            Umbralizacion u = new Umbralizacion();
            //l.umbralizacion(u.blancoNegro(img, jSlider_Umbralizacion.getValue()));
            l.umbralizacion(jSlider_Umbralizacion.getValue());
        }
    }//GEN-LAST:event_jSlider_UmbralizacionStateChanged

    private void jToggleButton_RectanguloRedondeadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_RectanguloRedondeadoActionPerformed
        forma = 5;
        inicializar_botones();
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.set_forma(5);
        }
    }//GEN-LAST:event_jToggleButton_RectanguloRedondeadoActionPerformed

    private void jToggleButton_LineaCurvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_LineaCurvaActionPerformed
        forma = 6;
        inicializar_botones();
        for(int i=0; i<jDesktop_Escritorio.getComponentCount(); i++){
            VentanaInterna c = (VentanaInterna) jDesktop_Escritorio.getComponent(i);
            Lienzo2DImagen l = (Lienzo2DImagen) c.get_lienzo();
            l.set_forma(6);
        }
    }//GEN-LAST:event_jToggleButton_LineaCurvaActionPerformed

    private void jButton_RecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RecordActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            try{
                File f = dlg.getSelectedFile();
                VentanaInternaGrabador vir = new VentanaInternaGrabador(f);
                this.jDesktop_Escritorio.add(vir);
                vir.setTitle(f.getName());
                vir.setVisible(true);
            }catch(Exception ex){ System.err.println("Error al leer el audio");}
        }
    }//GEN-LAST:event_jButton_RecordActionPerformed

    private void jComboBox_FondoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_FondoItemStateChanged
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame(); 
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            switch((String)jComboBox_Fondo.getSelectedItem()){
                case "Negro":
                    l.setFondo(Color.BLACK);
                    System.out.println("Hola");
                    break;
                case "Rojo":
                    l.setFondo(Color.RED);
                    break;
                case "Azul":
                    l.setFondo(Color.BLUE);
                    break;
                case "Blanco":
                    l.setFondo(Color.WHITE);
                    break;
                case "Amarillo":
                    l.setFondo(Color.YELLOW);
                    break;
                case "Verde":
                    l.setFondo(Color.GREEN);
                    break;
                case "Seleccionar color":
                    if (evt.getStateChange() == ItemEvent.SELECTED) {
                        JColorChooser Selectorcolor=new JColorChooser();
                        l.setFondo(Selectorcolor.showDialog(null, "Seleccione un Color", Color.BLACK));
                    }
                    break;
            }
        }
    }//GEN-LAST:event_jComboBox_FondoItemStateChanged

    private void jMenuItem_AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AcercaDeActionPerformed
        VentanaAcercaDe vi = new VentanaAcercaDe();
        vi.setVisible(true);
    }//GEN-LAST:event_jMenuItem_AcercaDeActionPerformed

    private void jToggleButton_DiscontinuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_DiscontinuoActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna) jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.setDiscontinuidad(jToggleButton_Discontinuo.isSelected());
            if(jToggleButton_Discontinuo.isSelected()){
                jToggleButton_Discontinuo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Continuo.png")));
                jToggleButton_Discontinuo.setToolTipText("Aplicar trama continua");
            }
            else{
                jToggleButton_Discontinuo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Discontinuo.png")));
                jToggleButton_Discontinuo.setToolTipText("Aplicar trama discontinua");
            }
        }

    }//GEN-LAST:event_jToggleButton_DiscontinuoActionPerformed

    private void jComboBox_FondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_FondoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_FondoActionPerformed

    /**
     * Activa la opción de degradado con opción a retornar a fondo liso
     * @param evt 
     */
    private void jToggleButton_DegradadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_DegradadoActionPerformed
        VentanaInterna vi = (VentanaInterna) jDesktop_Escritorio.getSelectedFrame();
        Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
        if(jToggleButton_Degradado.isSelected()){
            jToggleButton_Degradado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Liso.png")));
            jToggleButton_Degradado.setToolTipText("Aplicar fondo liso");
            jComboBox_Degradado.setVisible(true);
            relleno = 2;
        }
        else{
            jToggleButton_Degradado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgv/iconos/Degradado.png")));
            jToggleButton_Degradado.setToolTipText("Aplicar degradado");
            jComboBox_Degradado.setVisible(false);
            relleno = 1;
        }
        l.rellena(relleno);

    }//GEN-LAST:event_jToggleButton_DegradadoActionPerformed

    /**
     * Combobox que cambia el tipo de degradado (Vertical/horizontal)
     * @param evt 
     */
    private void jComboBox_DegradadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_DegradadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
                VentanaInterna vi = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame(); 
                Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
                switch((String)jComboBox_Degradado.getSelectedItem()){
                    case "Degradado vertical":
                        relleno = 2;
                        break;
                    case "Degradado horizontal":
                        relleno = 3;
                        break;
                }
            }
        VentanaInterna vi = (VentanaInterna) jDesktop_Escritorio.getSelectedFrame();
        Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
        l.rellena(relleno);
        }
    }//GEN-LAST:event_jComboBox_DegradadoItemStateChanged

    /**
     * Manejador que copia una ventana de imagenes y figuras en otra ventana nueva
     * @param evt 
     */
    private void jButton_DuplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DuplicarActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna original = (VentanaInterna)jDesktop_Escritorio.getSelectedFrame(); 
            Lienzo2DImagen l_original = (Lienzo2DImagen) original.get_lienzo();
            VentanaInterna nuevo= new VentanaInterna();
            Lienzo2DImagen l_nuevo = (Lienzo2DImagen) nuevo.get_lienzo();
            l_nuevo.setImage(l_original.getImage());
            l_nuevo.setFiguras(l_original.getFiguras());
            jDesktop_Escritorio.add(nuevo);
            nuevo.setTitle("Copia de " + original.getTitle());
            nuevo.setVisible(true);
        }
    }//GEN-LAST:event_jButton_DuplicarActionPerformed

    /**
     * Manejador que convierte a negativo una imagen
     * @param evt 
     */
    private void jButton_NegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NegativoActionPerformed
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna) jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.negativo();
        }
    }//GEN-LAST:event_jButton_NegativoActionPerformed

    private void jSlider_GrisesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_GrisesStateChanged
        if(jDesktop_Escritorio.getSelectedFrame() instanceof VentanaInterna){
            VentanaInterna vi = (VentanaInterna) jDesktop_Escritorio.getSelectedFrame();
            Lienzo2DImagen l = (Lienzo2DImagen) vi.get_lienzo();
            l.umbralizacion(jSlider_Grises.getValue());
        }
    }//GEN-LAST:event_jSlider_GrisesStateChanged

    /**
     * Opción (ver barra de medios) si la opción está activa muestra la barra de medios, en caso contrario la oculta
     * @param evt 
     */
    private void jCheckBoxMenuItem_MediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_MediosActionPerformed
        if(!jCheckBoxMenuItem_Medios.isSelected()){
            jToolBar_Medios.setVisible(false);
        }
        else{
            jToolBar_Medios.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem_MediosActionPerformed
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonDisminuir;
    private javax.swing.JButton jButton_Abrir;
    private javax.swing.JButton jButton_Aumentar;
    private javax.swing.JButton jButton_Camara;
    private javax.swing.JButton jButton_Capturar;
    private javax.swing.JButton jButton_Contraste;
    private javax.swing.JButton jButton_Duplicar;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JButton jButton_Iluminar;
    private javax.swing.JButton jButton_Negativo;
    private javax.swing.JButton jButton_Negro;
    private javax.swing.JButton jButton_Nuevo;
    private javax.swing.JButton jButton_Oscurecer;
    private javax.swing.JButton jButton_Record;
    private javax.swing.JButton jButton_Rojo;
    private javax.swing.JButton jButton_Rotar_180;
    private javax.swing.JButton jButton_Rotar_270;
    private javax.swing.JButton jButton_Rotar_90;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_Atributos;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_BarraEstado;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_Formas;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_Medios;
    private javax.swing.JComboBox jComboBox_Color;
    private javax.swing.JComboBox jComboBox_Degradado;
    private javax.swing.JComboBox jComboBox_Filtro;
    private javax.swing.JComboBox jComboBox_Fondo;
    private javax.swing.JDesktopPane jDesktop_Escritorio;
    private javax.swing.JLabel jLabel_Estado;
    private javax.swing.JMenuBar jMenuBar_Menu;
    private javax.swing.JMenuItem jMenuItem_Abrir;
    private javax.swing.JMenuItem jMenuItem_AcercaDe;
    private javax.swing.JMenuItem jMenuItem_Guardar;
    private javax.swing.JMenuItem jMenuItem_Nuevo;
    private javax.swing.JMenu jMenu_Archivo;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JMenu jMenu_Editar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Brillo;
    private javax.swing.JPanel jPanel_Contraste;
    private javax.swing.JPanel jPanel_Escala;
    private javax.swing.JPanel jPanel_Estado;
    private javax.swing.JPanel jPanel_Filtro;
    private javax.swing.JPanel jPanel_Rotacion;
    private javax.swing.JPanel jPanel_Umbralizacion;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSlider jSlider_Brillo;
    private javax.swing.JSlider jSlider_Grises;
    private javax.swing.JSlider jSlider_Rotacion;
    private javax.swing.JSlider jSlider_Umbralizacion;
    private javax.swing.JSpinner jSpinner_Grosor;
    private javax.swing.JToggleButton jToggleButton_Alisar;
    private javax.swing.JToggleButton jToggleButton_Degradado;
    private javax.swing.JToggleButton jToggleButton_Discontinuo;
    private javax.swing.JToggleButton jToggleButton_Linea;
    private javax.swing.JToggleButton jToggleButton_LineaCurva;
    private javax.swing.JToggleButton jToggleButton_Ovalo;
    private javax.swing.JToggleButton jToggleButton_Punto;
    private javax.swing.JToggleButton jToggleButton_Rectangulo;
    private javax.swing.JToggleButton jToggleButton_RectanguloRedondeado;
    private javax.swing.JToggleButton jToggleButton_Rellenar;
    private javax.swing.JToggleButton jToggleButton_Seleccionar;
    private javax.swing.JToggleButton jToggleButton_Transparencia;
    private javax.swing.JToolBar jToolBar_Atributos;
    private javax.swing.JToolBar jToolBar_Formas;
    private javax.swing.JToolBar jToolBar_Medios;
    // End of variables declaration//GEN-END:variables
}
