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
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;
import sm.image.ThresholdOp;

/**
 * Panel en el que se dibujan formas e imágenes
 * @author miguelangel
 */
public class Lienzo2DImagen extends Lienzo2D{
    //Variable que contendrá el conjunto de formas
    private BufferedImage img;
    //Variable a la que se aplicarán las diferentes modificaciones
    private BufferedImage imgAux;
    
    /**
     * Constructor de la clase Lienzo2dImagen
     */
    public Lienzo2DImagen(){
        img = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        imgAux = img;
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
    }
    
    /**
     * Constructor de la clase Lienzo2dImagen
     * @param i Se le extrae la imagen
     */
    public Lienzo2DImagen(Lienzo2DImagen i){
        img = new BufferedImage(i.getHeight(),
             i.getWidth(), BufferedImage.TYPE_INT_RGB);
        imgAux = img;
         
         Graphics2D g = img.createGraphics();
         g.drawImage(i.img,0,0,null);
    }
    
    /**
     * Constructor de la clase Lienzo2dImagen
     * @param bf se convierte en imagen
     */
    public Lienzo2DImagen (BufferedImage bf){
        img = bf;
        imgAux = img;
        if(img.getType()!=BufferedImage.TYPE_INT_RGB){
            BufferedImage aux = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = aux.createGraphics();
            g2d.drawImage(img,0,0,null);
            img=aux;
        } 
    }
    
    /**
     * Dibuja la imagen y las formas
     * @param g Componente gráfico
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
//        if(img!=null) g.drawImage(img,0,0,this);
        if(imgAux != null) g.drawImage(imgAux, 0, 0, this);    }
    
    /**
     * Asigna una imagen a nuestra variable principal
     * @param img Imagen a abrir
     */
    public void setImage(BufferedImage img){
        this.img = img;
        imgAux = img;
        BufferedImage aux = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = aux.createGraphics();
        g.drawImage(img,0,0,null);

    }
    
    /**
     * Aplica una umbralización a la imagen
     * @param img Imagen umbralizada
     */
    public void umbralizacion(BufferedImage img){
        imgAux = img;
        repaint();
    }
    
    /**
     * Asigna una imagen a nuestra variable principal
     * @param f Fichero que contiene la imagen
     */
    public void setImage(File f){
        try {
            img = (BufferedImage)ImageIO.read(f);
            imgAux = img;
        } catch (IOException ex) {
            Logger.getLogger(Lienzo2DImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(img.getType()!=BufferedImage.TYPE_INT_RGB){
            BufferedImage aux = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = aux.createGraphics();
            g2d.drawImage(img,0,0,null);
            img=aux;
        }  
    }
    
    /**
     * Retorna la variable principal
     * @return img
     */
    public BufferedImage getImage(){
        return this.img;
    }
    
    /**
     * Retorna la variable principal
     * @param drawVector Nos dice si hay vector de formas
     * @return img
     */
    public BufferedImage getImage(boolean drawVector){ 
        if (drawVector) {
            Graphics2D g= (Graphics2D) img.getGraphics();

            for(int i=0;i<figuras.size();i++){
                figuras.get(i).paint(g);
            }
        
            figuras.clear();
            return getImage();
        }
        else
            return getImage();
    }
    
    /**
     * Incrusta las figuras dibujadas sobre la imagen y las convierte en parte de la imagen
     */
    public void incrustarFiguras(){
        Graphics2D g2d= (Graphics2D) img.getGraphics();
                
        for(int i=0;i<figuras.size();i++)
            figuras.get(i).paint(g2d);
        
        figuras.clear();
    }
    
    /**
     * Guarda una imagen en un fichero
     * @param f fichero
     */
    public void Guardar(File f){
        incrustarFiguras();
    }
    
    /**
     * Modifica el brillo de la imagen
     * @param brillo 
     */
    public void brillo(int brillo){
        System.out.println("Reescalar: " + brillo);
        incrustarFiguras();
        RescaleOp rop = new RescaleOp(1.0F,brillo, null);
        imgAux=rop.filter(img, null);
        repaint();
    }
    
    /**
     * Aplica un filtro a la imagen
     * @param filtro 
     */
    public void aplicarFiltro(int filtro){
        incrustarFiguras();
        Kernel k = null;
        ConvolveOp op;
       
        switch(filtro){
            case 0:
                k = KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);
                break;
            case 1:
                k = KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3);
                break;
            case 2:
                 k = KernelProducer.createKernel(KernelProducer.TYPE_ENFOQUE_3x3);
                break;
            case 3:
                 k = KernelProducer.createKernel(KernelProducer.TYPE_RELIEVE_3x3);
                break;
            case 4:
                k = KernelProducer.createKernel(KernelProducer.TYPE_LAPLACIANA_3x3);
                break;
        }
        
        op = new ConvolveOp(k);
        imgAux= op.filter(img,null);
        repaint();
    }
    
    /**
     * Aplica un contraste a la imagen
     * @param valor 
     */
    public void aplicarContraste(int valor){
        incrustarFiguras();
        LookupTable lt=null;
        
        if(valor == 0)
                lt=LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_SFUNCION);
        if(valor == 1)
                lt=LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_POWER);
        if(valor ==2 )
                lt=LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_ROOT);
        
        LookupOp op = new LookupOp(lt, null);
        imgAux = op.filter(img, null);
        repaint();
    }
    
    /**
     * Aplica una rotación a la imagen
     * @param value 
     */
    public void rotar(int value){
        incrustarFiguras();
        double r = Math.toRadians(value);
        Point p = new Point(img.getWidth()/2, img.getHeight()/2);
        AffineTransform at = AffineTransform.getRotateInstance(r,p.getX(),p.getY());
        AffineTransformOp atop;
        atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
        imgAux = atop.filter(img, null);
        repaint();
    }
    
    /**
     * Aplica un escalado a la imagen
     * @param cantidad 
     */
    public void escalar(double cantidad){
        incrustarFiguras();
        AffineTransform at = AffineTransform.getScaleInstance(cantidad, cantidad);
        AffineTransformOp atop;
        atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
        imgAux = atop.filter(img, null);
        repaint();
    }

    /**
     * Aplica una umbralización a niveles de grises
     * @param umbral 
     */
    public void umbralizacion(int umbral) {
        incrustarFiguras();
        ThresholdOp op = new ThresholdOp(umbral);
        op.setType(ThresholdOp.TYPE_GREY_LEVEL);
        imgAux = op.filter(img,null);
        repaint();
    }
    
    public void umbralizacionC(int umbral){ 
        incrustarFiguras();
        ThresholdOp op = new ThresholdOp(fondo,umbral);
        op.setType(ThresholdOp.TYPE_COLOR);
        imgAux = op.filter(img,null);
        repaint();
    }
    /**
     * Aplica el negativo a la imagen
     */
    public void negativo(){
        incrustarFiguras();
        LookupTable lt;
        lt=LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_NEGATIVE);
        LookupOp lop = new LookupOp(lt, null);
        imgAux= lop.filter(img, null);
        repaint();
    }
}
