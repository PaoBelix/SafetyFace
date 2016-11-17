/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import RedimesionarImagenes.Imagen;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
/**
 *
 * @author dragonoz
 */
public class Camara{

    
    int contador = 001;
    public String GuardarImagen(String nombre,VideoCapture camera) throws IOException {
        String url = new File(".").getAbsolutePath ();
        System.out.println("Metodo Guardar Imagen URL: "+url);
    	if(!camera.isOpened()){
    		System.out.println("Error");
    	}
    	else {
    		Mat frame1 = new Mat();
                                
    	    //while(true){
                
    	    	if (camera.read(frame1)){
                                       
                        System.out.println(contador);
                        
                        String con = Integer.toString(contador);
                        nombre = nombre+contador;
                        
                        
    	    		System.out.println("CAPTURA REALIZADA");
    	    		System.out.println("Captured Frame Width " + frame1.width() + " Height " + frame1.height());
                        
                        
                        System.out.println("Mi Ruta es: " + url);
                        
                        Highgui.imwrite(url+"\\Fotos\\"+nombre+".png", frame1);//CreandoFoto
                        
                        Imagen obj = new Imagen();
                        
                        System.out.println("Listo para Redimencionar");
                        ImageIO.write(obj.redimensionar("Fotos/"+nombre+".png", 0.25), "png", new File("Fotos/"+nombre+".png"));
                        System.out.println("Redimencion completa");
                        
    	    		System.out.println("OK");
                        contador+=1;
                        
    	    		//break;
    	    	}
                
    	    //}	
    	}
        String ruta = url+"\\Fotos\\"+nombre+".png";
        String ru = ruta.replace("\\.", "");
        
        return (ru);
    }
       
 }

    