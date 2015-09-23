/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgv;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.JOptionPane;

/**
 * Frame donde se mostrará el vídeo de la web cam
 * @author miguelangel
 */
public class VentanaInternaCamara extends javax.swing.JInternalFrame {
    //Variable que contendrá el medio
    private Player player = null;
    
    private FrameGrabbingControl fgc;
    /**
     * Constructor VentanaInternaCamara
     */
    public VentanaInternaCamara() {
        
        initComponents();
        
        try {

        Vector vector = CaptureDeviceManager.getDeviceList(null);
        CaptureDeviceInfo camera = null;
        for (int i = 0; i<vector.size(); i++) {
            CaptureDeviceInfo device =
                    (CaptureDeviceInfo) vector.elementAt(i);
            if (device.getName().startsWith("vfw")) {
                camera = device;
                break;
            }
        }
        if (camera == null) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado una webcam.");

        }

        MediaLocator locator = camera.getLocator();

        player = Manager.createRealizedPlayer(locator);
        player.start();
        Component areaVisual = player.getVisualComponent();
//        if(areaVisual!=null) add(areaVisual, java.awt.BorderLayout.CENTER);
        if(areaVisual!=null) add(areaVisual);
//        Component panelControl = player.getControlPanelComponent();
//        if(panelControl!=null) add(panelControl, java.awt.BorderLayout.SOUTH);
        fgc = (FrameGrabbingControl) player.getControl(
                    "javax.media.control.FrameGrabbingControl");

        } catch (IOException ex) {
            Logger.getLogger(VentanaInternaCamara.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(VentanaInternaCamara.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(VentanaInternaCamara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retorna una instancia de la clase VentanaInternaCamara
     * @return 
     */
    public static VentanaInternaCamara getInstance(){
        VentanaInternaCamara v = new VentanaInternaCamara();
        if(v.player!=null) return v;
        else return null;
    }
    
    /**
     * Manejador que controla la reproducción del medio
     */
    public void play() {
        if (player != null) {
            try {
                player.start();
            } catch (Exception e) {
                System.err.println("VentanaInternaJMFPlayer: "+e);
            }
        }
    }
    
    /**
     * Devuelve un frame del vídeo que se está reproduciendo
     * @return  Lienzo2dImagen (el frame en cuestión)
     */
    public BufferedImage getFrame(){
        Image img;
        Buffer buf = fgc.grabFrame();
        VideoFormat bufFormat = (VideoFormat) buf.getFormat();
        BufferToImage bti = new BufferToImage(bufFormat);
        img = bti.createImage(buf);
        if (img == null) {
            return null;
        }
        return (BufferedImage) img;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento que controla el cierre de la ventana
     * @param evt 
     */
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        player.close();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
