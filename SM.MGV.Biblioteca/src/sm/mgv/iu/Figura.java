/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.mgv.iu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Clase que permite crear figuras y controlarlas de una forma más fácil
 * @author araluce
 */
public abstract class Figura implements Shape{
    //Puntos inicial y final
    protected Point2D p1, p2;
    
    //Nos dirá el tipo de relleno de la figura
    protected int relleno;
    //Nos dirá el color de la figura
    protected Color color;
    //Color de fondo
    protected Color fondo;
    
    //A partir del grosor, nos dará un trazo para la figura
    protected BasicStroke trazo;
    
    //Nos dice el grosor que tendrá el trazo de la figura
    protected float grosor;
    
    //Forma del trazo
    protected boolean discontinuo;
    
    //Escala de la figura
    protected double escala;
    
    //Nos dirá si la figura está alisada o no
    protected boolean alisar;
    //Nos dirá si a la figura se le aplicará transparencia o no
    protected boolean transparencia;
    
    final static float dash1[] = {10.0f};
    
    /**
     * Constructor de la clase Figura
     * @param punto Punto inicial de la figura
     * @param grosor Grosor que tendrá el trazo de la figura
     * @param color Color de la figura
     * @param fondo Color de fondo
     * @param escala Escala de la figura
     * @param alisar Alisado (true/false)
     * @param transparencia Transparencia (true/false)
     * @param relleno tipo de relleno
     * @param disc Discontinuidad(true/false)
     */
    public Figura(Point2D punto, float grosor, Color color, Color fondo, double escala, 
            boolean alisar, boolean transparencia, int relleno, boolean disc){
        this.p1 = punto;
        this.grosor = grosor;
        this.color = color;
        this.fondo = fondo;
        this.escala = escala;
        this.alisar = alisar;
        this.transparencia = transparencia;
        this.relleno = relleno;
        this.discontinuo = disc;
        
        Trazo();
    }
    
    /**
     * Modifica el trazo
     * @param grosor Se utilizará para cambiar el trazo
     */
    public void setGrosor(float grosor){
        this.grosor = grosor;
        Trazo();
    }
    /**
     * Dibuja el trazo en función de si es continuo o discontinuo
     */
    private void Trazo(){
        if(discontinuo)
            trazo =new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        else
            trazo =new BasicStroke(grosor,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
    }
    /**
     * Cambiará el color de la figura
     * @param color 
     */
    public void setColor(Color color){this.color = color;}
    /**
     * Cambiará el color de fondo
     * @param color
     */
    public void setFondo(Color color){this.fondo = color;}
    /**
     * Cambiará la escala de la figura
     * @param escala 
     */
    public void setEscala(double escala){this.escala = escala;}
    /**
     * Cambiará el valor de relleno al tipo de relleno
     * @param relleno 
     */
    public void setRellenar(int relleno){this.relleno = relleno;}
    /**
     * Cambiará el valor de alisar (true/false)
     * @param alisar 
     */
    public void setAlisar(boolean alisar){this.alisar = alisar;}
    /**
     * Cambiará el valor de transparencia (true/false)
     * @param transparencia 
     */
    public void setTransparencia(boolean transparencia){this.transparencia = transparencia;}
    /**
     * Activa/Desactiva la opción de discontinuidad y actualiza
     * @param disc 
     */
    public void setDiscontinuidad(boolean disc){
        this.discontinuo = disc;
        Trazo();
    }
    
    
    /**
     * Retorna el color
     * @return Color
     */
    public Color getColor(){return color;}
    
    /**
     * Retorna el trazo
     * @return trazo
     */
    public BasicStroke getTrazo(){return trazo;}
    /**
     * Retorna la escala
     * @return escala
     */
    public double getEscala(){return escala;}
    /**
     * Retorna si alisado (true/false)
     * @return alisar
     */
    public boolean alisar(){return alisar;}
    /**
     * Retorna si transparencia (true/false)
     * @return transparencia
     */
    public boolean transparencia(){return transparencia;}
    /**
     * Retorna el tipo de relleno
     * @return relleno
     */
    public int relleno(){return relleno;}
        
    /**
     * Retorna el punto medio de la figura
     * @return Punto medio de la figura
     */
    public abstract Point2D getPuntoMedio();
    
    /**
     * Establece nueva posición de la figura
     * @param position  Nueva posición de la figura
     */
    public abstract void setPosition(Point2D position);
    
    
    /**
     * Devuelve la posición donde está la figura
     * @return  Posición de la figura
     */
    public abstract Point2D getPosition();

    
    /**
     * Modifica el valor del segundo punto de la figura
     * @param p Valor del segundo punto
     */
    public abstract void setPuntoSegundo(Point2D p);
    
    
    /**
     * Dibuja una figura
     * @param g Figura a pintar
     */
    public abstract void paint(Graphics2D g);
    
    
    /**
     * Devuelve el contorno de una figura por un rectángulo
     * @return  Contorno por rectángulo
     */
    @Override
    public abstract Rectangle getBounds();
    
    
    /**
     * Devuelve el contorno de una figura por un rectángulo
     * @return  Contorno por rectángulo
     */
    @Override
    public abstract Rectangle2D getBounds2D();

    
    /**
     * Indica si un punto está contenido por la figura
     * @param   x   Coordenada x del punto
     * @param   y   Coordenada y del punto
     * @return      Indica si el punto está 
     */
    @Override
    public abstract boolean contains(double x, double y);

    
    /**
     * Indica si un punto está contenido por la figura
     * @param   p   Punto a estudiar
     * @return      Indica si el punto está 
     */
    @Override
    public abstract boolean contains(Point2D p);

    
    /**
     * Indica si un área rectangular instersecciona con la figura
     * @param   x   Coordenada x de figura
     * @param   y   Coordenada y de figura
     * @param   w   Anchura de figura
     * @param   h   Altura de figura
     * @return      Indica si la figura está 
     */
    @Override
    public abstract boolean intersects(double x, double y, double w, double h);

    
    /**
     * Indica si el área rectangular intersecciona con la figura
     * @param   r   Área a comprobar
     * @return      Indica si la figura está 
     */
    @Override
    public abstract boolean intersects(Rectangle2D r);

    
    /**
     * Indica si la figura contiene un área
     * @param   x   Coordenada x de la figura
     * @param   y   Coordenada y de la figura
     * @param   w   Anchura
     * @param   h   Altura 
     * @return Indica si el área está 
     */
    @Override
    public abstract boolean contains(double x, double y, double w, double h);

    
    /**
     * Comprueba si una figura está dentro
     * @param   r   Área a comprobar
     * @return      Indica si el área está 
     */
    @Override
    public abstract boolean contains(Rectangle2D r);

    
    /**
     * Iterador de figuras
     * @param at    Transformación
     * @return      Iterador sobre la figura
     */
    @Override
    public abstract PathIterator getPathIterator(AffineTransform at);

    
    /**
     * Iterador de figuras
     * @param at        Transformación
     * @param flatness  Máxima distancia entre segmentos
     * @return          Iterador sobre la figura
     */
    @Override
    public abstract PathIterator getPathIterator(AffineTransform at, double flatness);
    
}
