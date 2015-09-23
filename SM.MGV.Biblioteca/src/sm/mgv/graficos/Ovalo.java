/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.mgv.graficos;

import sm.mgv.iu.Figura;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 * Clase que gestiona la forma Ovalo
 * @author miguelangel
 */
public class Ovalo extends Figura{
    //Variable que contendrá la forma
    Ellipse2D forma;
    
    /**
     * Constructor de la clase Ovalo
     * @param punto Punto inicial de la figura
     * @param grosor Grosor que tendrá el trazo de la figura
     * @param color Color de la figura
     * @param fondo Color de fondo
     * @param escala Escala de la figura
     * @param alisar Alisado (true/false)
     * @param transparencia Transparencia (true/false)
     * @param relleno Relleno (true/false)
     * @param disc Discontinuidad(true/false)
     */
    public Ovalo(Point2D punto, float grosor, Color color, Color fondo, double escala,
            boolean alisar, boolean transparencia, int relleno, boolean disc) {
        super(punto, grosor, color, fondo, escala, alisar, transparencia, relleno, disc);
        forma = new Ellipse2D.Float();
        forma.setFrameFromDiagonal(p1, p1);
    }

    /**
     * Retorna el punto medio de la figura
     * @return Punto medio de la figura
     */
    @Override
    public Point2D getPuntoMedio() {
        return new Point2D.Double((p1.getX()+p2.getX())/2, (p1.getY()+p2.getY())/2);
    }
    
    /**
     * Establece nueva posición de la figura
     * @param position  Nueva posición de la figura
     */
    @Override
    public void setPosition(Point2D position) {
        RectangularShape f = (RectangularShape)forma;
        f.setFrame(position, new Dimension((int)f.getWidth(), (int)f.getHeight()));
    }

    /**
     * Devuelve la posición donde está la figura
     * @return  Posición de la figura
     */
    @Override
    public Point2D getPosition() {
        return new Point2D.Double(forma.getMinX(),forma.getMinY());
    }

    /**
     * Modifica el valor del segundo punto de la figura
     * @param p Valor del segundo punto
     */
    @Override
    public void setPuntoSegundo(Point2D p) {
        p2=p;
        forma.setFrameFromDiagonal(p1, p2);
    }

    /**
     * Dibuja una figura
     * @param g Figura a pintar
     */
    @Override
    public void paint(Graphics2D g) {
        Composite trans = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , 0.75f );
        Composite opac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , 1.0f );
        
        g.setStroke(trazo);

        if(transparencia()) g.setComposite(trans);
        else g.setComposite(opac);
        if(relleno!=0) {
            GradientPaint gradiente;
            switch(relleno){
                case 1:
                    g.setPaint(fondo);
                    break;
                case 2:
                    gradiente = new GradientPaint((float)forma.getMinX(),0,color,(float)forma.getMaxX(), 0,fondo);
                    g.setPaint(gradiente);
                    break;
                case 3:
                    gradiente=new GradientPaint(0f, (float)forma.getMinY(),color,0f, (float)forma.getMaxY(), fondo);
                    g.setPaint(gradiente);
                    break;
            }
            g.fill(forma);
        }
        g.setPaint(color);
        if(alisar())
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.draw(forma);
    }

    /**
     * Devuelve el contorno de una figura por un rectángulo
     * @return  Contorno por rectángulo
     */
    @Override
    public Rectangle getBounds() {
        return forma.getBounds();
    }

    /**
     * Devuelve el contorno de una figura por un rectángulo
     * @return  Contorno por rectángulo
     */
    @Override
    public Rectangle2D getBounds2D() {
        return forma.getBounds2D();
    }

    /**
     * Indica si un punto está contenido por la figura
     * @param   x   Coordenada x del punto
     * @param   y   Coordenada y del punto
     * @return      Indica si el punto está 
     */
    @Override
    public boolean contains(double x, double y) {
        return forma.contains(x, y);
    }

    /**
     * Indica si un punto está contenido por la figura
     * @param   p   Punto a estudiar
     * @return      Indica si el punto está 
     */
    @Override
    public boolean contains(Point2D p) {
        return forma.contains(p);
    }

    /**
     * Indica si un área rectangular instersecciona con la figura
     * @param   x   Coordenada x de figura
     * @param   y   Coordenada y de figura
     * @param   w   Anchura de figura
     * @param   h   Altura de figura
     * @return      Indica si la figura está 
     */
    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return forma.intersects(x, y, w, h);
    }

    /**
     * Indica si el área rectangular intersecciona con la figura
     * @param   r   Área a comprobar
     * @return      Indica si la figura está 
     */
    @Override
    public boolean intersects(Rectangle2D r) {
        return forma.intersects(r);
    }

    /**
     * Indica si la figura contiene un área
     * @param   x   Coordenada x de la figura
     * @param   y   Coordenada y de la figura
     * @param   w   Anchura
     * @param   h   Altura 
     * @return Indica si el área está 
     */
    @Override
    public boolean contains(double x, double y, double w, double h) {
        return forma.contains(x, y, w, h);
    }

    /**
     * Comprueba si una figura está dentro
     * @param   r   Área a comprobar
     * @return      Indica si el área está 
     */
    @Override
    public boolean contains(Rectangle2D r) {
        return forma.contains(r);
    }

    /**
     * Iterador de figuras
     * @param at    Transformación
     * @return      Iterador sobre la figura
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return forma.getPathIterator(at);
    }

    /**
     * Iterador de figuras
     * @param at        Transformación
     * @param flatness  Máxima distancia entre segmentos
     * @return          Iterador sobre la figura
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return forma.getPathIterator(at, flatness);
    }
    
}
