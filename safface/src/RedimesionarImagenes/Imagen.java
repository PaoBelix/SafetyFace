/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RedimesionarImagenes;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Geek
 */
public class Imagen {

    public Imagen() {
    }
    
    public BufferedImage redimensionar(String archivo, double porcentaje ){
        
        BufferedImage bf = null;
        try {
            bf = ImageIO.read(new File(archivo));
            System.out.println("Leyendo Archivo de Imagen");
            System.out.println("Archivo: "+archivo);
            System.out.println("Imagen : "+bf);
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ancho = bf.getWidth();
        System.out.println("Ancho de Imagen: "+ancho);
        int alto = bf.getHeight();
        System.out.println("Alto de Imagen : "+alto);
        int escalaAncho = (int)(porcentaje* ancho);
        System.out.println("Escala de Ancho "+escalaAncho);
        int escalaAlto = (int)(porcentaje*alto);
        System.out.println("Estala de Alto "+escalaAlto);
        BufferedImage bufim = new BufferedImage(escalaAncho, escalaAlto, bf.getType());
        System.out.println("Buffer :"+bufim);        
        Graphics2D g = bufim.createGraphics();
        System.out.println("Iniciando Dibujante");        
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        System.out.println("Dibujando nueva imagen");
        g.drawImage(bf, 0,0, escalaAncho,escalaAlto, 0,0,ancho,alto, null);
        System.out.println("Redimencionando imagen");
        g.dispose();
        System.out.println("Cerrando Dibujante");
        return bufim;
}
    
}
