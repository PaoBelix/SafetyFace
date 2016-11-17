/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Directorio.DirectorioActual;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.sqlite.core.DB;

/**
 *
 * @author Lenovo
 */
public class IngresoUsuarios {
    public void Verificar(JTextField User, JPasswordField pass,String DB, String Tabla) throws ClassNotFoundException, IOException{
        
        if (User.getText().equals("") || pass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Las Casillas no pueden estar vacias intente nuevamente", "Casillas Vacias", HEIGHT);
        }
        else{
            RevisarBase(User.getText(),pass.getText(),DB,Tabla);    
    }
    }
    
    public void RevisarBase(String Nombre, String Clave,String DB,String Tabla) throws ClassNotFoundException, IOException{
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
                if (result.getString("NOMBRE").equals(Nombre) && result.getString("CLAVE").equals(Clave) ){
                    JOptionPane.showMessageDialog(null,result.getString("NOMBRE")+ "\nHORA :"+Hora()+"\nEn la Fecha: "+Fecha(),"SafetyFace",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(result.getString("IMAGEN")));
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "El Usuario o La contraseña Son Incorrectos\nVuelva a intentar..");
                }
            }
        st.close();
        c.commit();
        c.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
    }
    
    public String DirecImagen(String Nombre) throws IOException, ClassNotFoundException{
      String url = null;
      DirectorioActual dir = new DirectorioActual();
      String Base = dir.DirectorioActual()+"\\Base\\"+"Saff";
      System.out.println(Base);
      try {
      Class.forName("org.sqlite.JDBC");
      Connection c = DriverManager.getConnection("jdbc:sqlite:"+Base+".db");
      c.setAutoCommit(false);
      System.out.println("Buscando Url de Imagen");

      PreparedStatement st = c.prepareStatement("select * from "+"Registros");
          ResultSet result = st.executeQuery();
            while (result.next()) {
                
                System.out.println("Confirmando Nombre: "+result.getString("Nombre"));
                System.out.println("Retornando Imagen");
                url=result.getString("Imagen");
            }
        st.close();
        c.commit();
        c.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       return url; 
    } 
    
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
    
}
