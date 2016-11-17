/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Directorio.DirectorioActual;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class RegistroUsuarios {

    private String nombredb;
    
 
    
    
    public String Hora(){
        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        System.out.println("Hora Actual: "+hora + ":" + minutos + ":" + segundos);
    
        String hour = hora + ":" + minutos + ":" + segundos;
        
        return hour;
    };
       
    public String Fecha()
    {
        Calendar c = new GregorianCalendar();
        
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));
        
        System.out.println(annio+"-"+mes+"-"+dia);
        String Fecha = annio+"-"+mes+"-"+dia;
        
        return Fecha;
    }
    
    public void CrearBasedeDatos(String nombredb) throws IOException
    {
   //Crea la bd
        System.out.println("Metodo CrearBasedeDatos");
        Connection c = null;
        
        
    DirectorioActual dir = new DirectorioActual();
    String Base = dir.DirectorioActual()+"\\BaseDatos\\"+nombredb;
      
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+Base+".db");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Base de Datos Abierta Satisfactoriamente");
    }
    
    public void CrearBD(String BD,String Tabla) throws IOException
    {
        //crea la tabla de bd
        System.out.println("MetodoCrearBD");
    Connection c = null;
    Statement stmt = null;
    
    DirectorioActual dir = new DirectorioActual();
    String Base = dir.DirectorioActual()+"\\BaseDatos\\"+BD;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+Base+".db");
      System.out.println("Base de Datos Abierta Satisfactoriamente.. para Creacion de Tabla");
      
      stmt = c.createStatement();
      
      String Comando="CREATE TABLE IF NOT EXISTS "+Tabla;
      
      String sql = Comando +
                   "(ID INT PRIMARY KEY   ," +
                   " NOMBRE       TEXT    , " + 
                   " CLAVE        TEXT    , " + 
                   " FECHA        DATE    , " + 
                   " HORA         TIME    ," +
                   " IMAGEN       TEXT)"; 
      System.out.println(sql);
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     // System.exit(0);
    }
    System.out.println("Tabla Creada Satisfactoriamente..");    
    }
      
    public void InsertarDatos(String DB,String Tabla,String nombre ,String clave,String fecha,String hora,String imagen,int id) throws IOException, ClassNotFoundException, SQLException
    {
    Connection c = null;
    Statement stmt = null;
      
    
    DirectorioActual dir = new DirectorioActual();
    String Base = dir.DirectorioActual()+"\\BaseDatos\\"+DB;
    
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+Base+".db");
      c.setAutoCommit(false);
      System.out.println("Abriendo Base de Datos para Insertar Informacion");

      stmt = c.createStatement();
     
      String sql = "INSERT INTO "+Tabla+" (ID,NOMBRE,CLAVE,FECHA,HORA,IMAGEN) " +
                  "VALUES ("+id+",\""+nombre+"\","+clave+",\""+fecha+"\",\""+hora+"\",\""+imagen+"\");";
      System.out.println(sql);
      stmt.executeUpdate(sql);
      c.commit();
      stmt.close();
      c.close();
      
      
      
      //FileInputStream convertir_imagen = new FileInputStream (ArchivoFoto);
        //System.out.println(convertir_imagen);
                         
    } catch (SQLException e) {
    
        JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                                     + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
        System.out.println("Falla al Intentar Guardar en Base de Datos");
        
        
    }       
    
    c.close();

    
}   
    
  

      
      
/*      
      
      stmt.executeUpdate(sql);
 
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Los Datos Fueron Guardados Satisfactoriamente ");
    }
  */  
    
    public int ContadorRegistros(String DB,String Tabla) throws ClassNotFoundException, IOException{
      ResultSet result = null;
      int num = 0;
      DirectorioActual dir = new DirectorioActual();
      String Base = dir.DirectorioActual()+"\\BaseDatos\\"+DB;
      System.out.println(Base);
      try {
      Class.forName("org.sqlite.JDBC");
      Connection c = DriverManager.getConnection("jdbc:sqlite:"+Base+".db");
      c.setAutoCommit(false);
      System.out.println("Contador de Registros");

      PreparedStatement st = c.prepareStatement("select * from "+Tabla);
            result = st.executeQuery();
            while (result.next()) {
                
                num++;
                System.out.println("Numero de Registros: "+num);
                
            }
        st.close();
        c.commit();
        c.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      return num;
    }
    
    
}
