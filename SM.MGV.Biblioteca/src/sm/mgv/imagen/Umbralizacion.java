/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.mgv.imagen;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author araluce1
 */
public class Umbralizacion{
    
    public Umbralizacion(){}
    
    public BufferedImage blancoNegro(BufferedImage imagen, int umbral){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(this.chequearUmbral(auxColor,umbral)));                
            }
        }
        return imagenRetorno;
    }

    private Color chequearUmbral(Color color, int umbral){
        Color colorSalida;
        if (this.calcularMediaColor(color)>=umbral){
            colorSalida=new Color(255,255,255, color.getAlpha());
        }else{
            colorSalida=new Color(0, 0, 0, color.getAlpha());
        }
        return colorSalida;
    }
    private int calcularMediaColor(Color color){
        int averageColor;
        averageColor=(int)((color.getRed()+color.getGreen()+color.getBlue())/3);
        return averageColor;
    }
    private BufferedImage clonarBufferedImage(BufferedImage bufferImage) {
        BufferedImage copiaImagen=new BufferedImage (bufferImage.getWidth(),bufferImage.getHeight(),bufferImage.getType());
        copiaImagen.setData(bufferImage.getData());
        return copiaImagen;
    }
    
    private int colorRGBaSRGB(Color colorRGB){
        int colorSRGB;
        colorSRGB=(colorRGB.getRed() << 16) | (colorRGB.getGreen() << 8) | colorRGB.getBlue();
        return colorSRGB;
    }
    
}
