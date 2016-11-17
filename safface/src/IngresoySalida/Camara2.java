/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngresoySalida;

import java.io.File;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
/**
 *
 * @author dragonoz
 */
public class Camara2{

    
    int contador = 001;
    String ru = null;
    public String GuardarImagen(String nombre,VideoCapture camera) {
        String url = new File(".").getAbsolutePath ();
        //System.out.println("Metodo Guardar Imagen URL: "+url);
        
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
    	    		
                        
                        Highgui.imwrite(url+"\\Fotos\\"+nombre+".jpg", frame1);//CreandoFoto
                        
    	    		System.out.println("OK");
                        contador+=1;
                        
    	    		//break;
    	    	}
                
    	    //}	
    	}
        ru =null;
        String ru = nombre+".jpg";
        System.out.println("Nombre de la Imagen es :"+ru);
        
        return (ru);
    }
       
 }

    