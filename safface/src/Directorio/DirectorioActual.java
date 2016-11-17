/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Directorio;

/**
 *
 * @author Usuario
 */
import java.io.File;
import java.io.IOException;
 public class DirectorioActual {
   
     public String DirectorioActual() throws IOException {
     File miDir = new File (".");
     try {
       System.out.println ("Directorio actual: " + miDir.getCanonicalPath());
       return miDir.getCanonicalPath();
    }
     catch(IOException e) {
       e.printStackTrace();
       }
    return miDir.getCanonicalPath();
    }
}