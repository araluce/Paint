/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.mgv.iu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import sm.mgv.graficos.Linea;
import sm.mgv.graficos.LineaCurva;
import sm.mgv.graficos.Ovalo;
import sm.mgv.graficos.Punto;
import sm.mgv.graficos.Rectangulo;
import sm.mgv.graficos.RectanguloRedondeado;

/**
 * Panel en el que se dibujan las formas
 * @author araluce
 */
public class Lienzo2D extends javax.swing.JPanel {

    //Forma que se está dibujando
    private int forma = 0;
    //Trazo continuo o discontinuo
    private boolean discontinuo;
    //Array de las figuras dibujadas
    ArrayList<Figura> figuras;
    //Coordenadas x, y
    private double x, y;
    //Figura seleccionada
    private Figura figura_seleccionada;
    //Rectangulo que rodea la seleccion
    private Figura seleccion;
    
    //Variable de relleno
    private int relleno;
    //Variable de transparencia
    private boolean transparencia;
    //Variable de alisado
    private boolean alisar;
    
    //Color de la figura
    Color color;
    //Color de fondo
    Color fondo;
    
    //Escala de la figura
    double escala;
    //Grosor de la figura
    private float grosor;
    
    //Puntos para figura
    Point p1,p2,p3;
    
    /**
     * Constructor de Lienzo2D
     */
    public Lienzo2D() {
        initComponents();
        figuras = new ArrayList();
        relleno = 0;
        discontinuo = false;
        transparencia = false;
        alisar = false;
        color = Color.BLACK;
        fondo = Color.BLACK;
        escala = 1;
        p1=null;
        p2=null;
    }
    
    /**
     * Maneja las formas que van a dibujarse en todo momento
     * @param f punto, linea, rectangulo u ovalo
     */
    public void set_forma(int f){
        this.forma = f;
    }
    
    public void set_discontinuidad(boolean discontinuidad){
        this.discontinuo = discontinuidad;
    }
    
    /**
     * Dibuja las formas sobre el jPanel
     * @param g Objeto gráfico
     */
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        
        for(int i=0; i<figuras.size(); i++)
            figuras.get(i).paint(g2d);
        if(seleccion != null) seleccion.paint(g2d);
    }
    
    /**
     * Se hace un volcado de figuras en el lienzo
     * @param formas 
     */
    public void setFiguras(ArrayList<Figura> formas){
        this.figuras = formas;
        repaint();
    }
    /**
     * Retorna todas las figuras
     * @return 
     */
    public ArrayList<Figura> getFiguras(){
        ArrayList<Figura> aux = figuras;
        return aux;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
    }//GEN-LAST:event_formMouseMoved
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    /**
     * Evento activado al hacer click que pinta la figura según la variable forma
     * @param evt 
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(forma==0){//Seleccionar
            figura_seleccionada=null;
                for(int i=figuras.size()-1;figura_seleccionada==null && i>=0;i--) {
                    if(figuras.get(i).contains(evt.getPoint())) 
                    {
                       figura_seleccionada=figuras.get(i);
                    }
                }
                
                if(figura_seleccionada!=null){
                    x=Math.abs(evt.getPoint().getX()-figura_seleccionada.getPosition().getX());
                    y=Math.abs(evt.getPoint().getY()-figura_seleccionada.getPosition().getY());
                    
                    seleccion=new Rectangulo(figura_seleccionada.getBounds2D());
                }
        }
        if(forma==1){//Punto
            System.out.println("Forma: punto");
            Punto punto = new Punto(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo);
            figuras.add(punto);
            seleccion=null;
        }
        if(forma==2){//Linea
            System.out.println("Forma: Linea");
            Linea linea = new Linea(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo);
            figura_seleccionada = linea;
            figuras.add(linea);
            seleccion=null;
        }
        if(forma==3){//Rectangulo
            System.out.println("Forma: Rectangulo");
            Rectangulo rectangulo = new Rectangulo(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo);
            figura_seleccionada = rectangulo;
            figuras.add(rectangulo);
            seleccion=null;
        }
        if(forma==4){//Ovalo
            System.out.println("Forma: Ovalo");
            Ovalo ovalo = new Ovalo(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo);
            figura_seleccionada = ovalo;
            figuras.add(figura_seleccionada);
            seleccion=null;
        }
        if(forma==5){//Rectángulo redondeado
            System.out.println("Forma: Rectangulo redondeado");
            RectanguloRedondeado rectangulo = new RectanguloRedondeado(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo);
            figura_seleccionada = rectangulo;
            figuras.add(figura_seleccionada);
            seleccion=null;
        }
        if(forma==6){//Línea curva
            seleccion=null;
            System.out.println("Forma: Línea curva");
            if(p1==null && p2==null){
                System.out.println("1");
                    p1=evt.getPoint();
                    LineaCurva lc = new LineaCurva(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo);
                    figura_seleccionada=lc;
                    figuras.add(new Punto(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo));
                }
                else if(p2==null){
                    System.out.println("2");
                    p2 = evt.getPoint();
                    LineaCurva aux = (LineaCurva) figura_seleccionada;
                    aux.setPuntoSegundo(evt.getPoint());
                    figuras.add(new Punto(evt.getPoint(), grosor, color, fondo, escala, alisar, transparencia, relleno, discontinuo));
                   
                }
                else{
                    System.out.println("3");
                    //Borrar últimos puntos
                    figuras.remove(figuras.size()-1);
                    figuras.remove(figuras.size()-1);
                    LineaCurva aux = (LineaCurva) figura_seleccionada;
                    aux.setPuntoTercero(evt.getPoint());
                    figuras.add(figura_seleccionada);
                    p3=evt.getPoint();
                    p1=p2=p3=null;
                }
        }
        repaint();
    }//GEN-LAST:event_formMousePressed

    /**
     * Evento activado al dejar de presionar el click 
     * @param evt 
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(forma==2 || forma==3 || forma==4 || forma==5){
            figura_seleccionada.setPuntoSegundo(evt.getPoint());
        }
        if(forma==6){
            LineaCurva lc= (LineaCurva)figura_seleccionada;
            lc.setPuntoTercero(evt.getPoint());
        }
        if(forma==0){//Ratón
            if(figura_seleccionada!=null){
                Point2D posNueva=new Point2D.Double(evt.getPoint().getX()-x,evt.getPoint().getY()-y);
                figura_seleccionada.setPosition(posNueva);
                seleccion=new Rectangulo(figura_seleccionada.getBounds2D());
            }
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(forma!=6 && p3!=null){
            p1=p2=p3=null;
        }
    }//GEN-LAST:event_formMouseReleased
      
    /**
     * Cambia las figuras a rellenas
     * @param relleno Tipo de relleno
     */
    public void rellena(int relleno){
        this.relleno = relleno;
        if(forma==0 && figura_seleccionada!=null) figura_seleccionada.setRellenar(relleno);
        repaint();
    }
    
    /**
     * Cambia las figuras a transparencia
     * @param transparencia  (true/false)
     */
    public void transparencia(boolean transparencia){
        this.transparencia = transparencia;
        if(forma==0 && figura_seleccionada!=null) figura_seleccionada.setTransparencia(transparencia);
        repaint();
    }
    
    /**
     * Cambia las figuras a alisadas
     * @param alisar  (true/false)
     */
    public void alisar(boolean alisar){
        this.alisar = alisar;
        if(forma==0 && figura_seleccionada!=null) figura_seleccionada.setAlisar(alisar);
        repaint();
    }
    
    /**
     * Cambia el color de las figuras
     * @param color 
     */
    public void setColor(Color color){
        this.color = color;
        if(forma==0 && figura_seleccionada!=null) figura_seleccionada.setColor(color);
        repaint();
    }
    
    public void setFondo(Color c){
        this.fondo = c;
        if(forma==0 && figura_seleccionada!=null) figura_seleccionada.setFondo(fondo);
        repaint();
    }
    
    /**
     * Cambia el grosor de las figuras
     * @param grosor 
     */
    public void setGrosor(Integer grosor){
        this.grosor = grosor;
        if(forma==0 && figura_seleccionada!=null) {figura_seleccionada.setGrosor(grosor);}
        repaint();
    }
    
    /**
     * Cambiar tipo de trazo (continuo/discontinuo)
     * @param disc 
     */
    public void setDiscontinuidad(boolean disc){
        this.discontinuo = disc;
        if(forma==0 && figura_seleccionada!=null) figura_seleccionada.setDiscontinuidad(disc);
        repaint();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
