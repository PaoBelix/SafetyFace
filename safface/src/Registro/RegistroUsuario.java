/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import BaseDatos.RegistroUsuarios;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

/**
 *
 * @author Lenovo
 */
public class RegistroUsuario extends javax.swing.JFrame {

    
    /**
     * Creates new form Inicio
     * @throws java.lang.ClassNotFoundException
     */
    
    
    public RegistroUsuario() throws ClassNotFoundException, IOException {
        initComponents();
        Contador.setText(Integer.toString(db.ContadorRegistros("Saff", "Registros")));
        //Camara.setBackground(Color.BLACK);       
        //System.out.println(RegistroUsuario.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    }

    // definitions
    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;

    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.private static 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Contra = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        Contador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Admin = new javax.swing.JPasswordField();
        MenuPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(690, 610));
        setMinimumSize(new java.awt.Dimension(690, 610));
        setPreferredSize(new java.awt.Dimension(850, 610));
        getContentPane().setLayout(null);

        Nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombreKeyReleased(evt);
            }
        });
        getContentPane().add(Nombre);
        Nombre.setBounds(259, 332, 381, 50);

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel2.setText("CLAVE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(33, 411, 85, 23);

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setText("USUARIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(33, 348, 85, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosImagenes/LOGOTIPOpeq.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 100, 120, 129);

        btnRegistrar.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(259, 534, 135, 31);
        btnRegistrar.getAccessibleContext().setAccessibleName("registrarUsuario");

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel5.setText("CLAVE ADMIN ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(33, 477, 129, 23);

        Contra.setFont(new java.awt.Font("Tibetan Machine Uni", 1, 18)); // NOI18N
        getContentPane().add(Contra);
        Contra.setBounds(259, 400, 381, 41);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(259, 37, 381, 237);

        Contador.setEditable(false);
        Contador.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Contador.setForeground(new java.awt.Color(255, 51, 51));
        Contador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Contador.setText("0");
        getContentPane().add(Contador);
        Contador.setBounds(110, 10, 100, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Registro");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 20, 70, 30);
        getContentPane().add(Admin);
        Admin.setBounds(260, 470, 380, 30);

        jMenu1.setText("Opciones");
        MenuPrincipal.add(jMenu1);

        jMenu2.setText("Ayuda");
        MenuPrincipal.add(jMenu2);

        setJMenuBar(MenuPrincipal);

        getAccessibleContext().setAccessibleName("RegistroEmpleados");
        getAccessibleContext().setAccessibleDescription("RegistroEmpleados");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    RegistroUsuarios db = new RegistroUsuarios();
    Camara fun = new Camara();
    int contador = 1;
    
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    boolean Entrada = false;
    
    if (Nombre.getText().equals("") || Contra.getText().equals("") || Admin.getText().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Las Casillas no pueden estar Vacias Intente Nuevamente....");
            Entrada = false;
        }//fin del If
    
    else if(Admin.getText().equals("ASDasd123")||Admin.getText().equals("123"))
    {
        javax.swing.JOptionPane.showMessageDialog(rootPane, "Acceso Consedido \nCodigo de Acceso Valido");
        Entrada = true;
    }
    
    else
    {
        Entrada = false;
        javax.swing.JOptionPane.showMessageDialog(rootPane,"Acceso denegado:\n"
          + "Por favor ingrese un usuario y/o contraseña correctos",  
          "Acceso denegado", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
        
    if (Entrada)
    {
        String user,cont,admin;
        
        user = Nombre.getText();
        cont = Contra.getName();
        admin = Admin.getText();
        
        try {
            db.CrearBasedeDatos("Saff");
        } catch (IOException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            db.CrearBD("Saff", "Registros");
        } catch (IOException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String HoraActual = db.Hora();
        String FechaActual = db.Fecha();
        
        String Imagen = null;
        try {
            Imagen = fun.GuardarImagen(Nombre.getText(),webSource);
        } catch (IOException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Imagen :"+Imagen);
        
        try {
            db.InsertarDatos("Saff", "Registros", Nombre.getText(), Contra.getText(), FechaActual,
                    HoraActual, Imagen,db.ContadorRegistros("Saff", "Registros")+1);
                       
            //Captura de Imagen
            /*int returnVal = jFileChooser1.showSaveDialog(this);
            System.out.println("Codigo de la Imagen :"+returnVal);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            Highgui.imwrite(file.getPath(), frame);
            
            } else {
            System.out.println("Acceso a Archivos Cancelado");
            }
            */
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        //byte[] imagen = ;
        
        //db.InsertarDatos("Saff", "Registros",user, cont, HoraActual  , FechaActual , contador);
        
        contador ++;
        
        Nombre.setText("");
        Contra.setText("");
        Admin.setText("");
        
        dispose();
    
        
    
    }//fin del Else
          
    }//GEN-LAST:event_btnRegistrarActionPerformed
    int con = 1;
    private void NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreKeyReleased
    if(con == 1){
        webSource =new VideoCapture(0);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
    }
    con ++;
// TODO add your handling code here:
    }//GEN-LAST:event_NombreKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.loadLibrary (Core.NATIVE_LIBRARY_NAME);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RegistroUsuario().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Admin;
    private javax.swing.JTextField Contador;
    private javax.swing.JPasswordField Contra;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    class DaemonThread implements Runnable
    {
    protected volatile boolean runnable = false;

    @Override
    public  void run()
    {
        synchronized(this)
        {
            while(runnable)
            {
                if(webSource.grab())
                {
		    	try
                        {
                            webSource.retrieve(frame);
			    Highgui.imencode(".bmp", frame, mem);
			    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

			    BufferedImage buff = (BufferedImage) im;
			    Graphics g=jPanel1.getGraphics();

			    if (g.drawImage(buff, 0, 0, getWidth()-395, getHeight()-350, 0, 0, buff.getWidth(), buff.getHeight(),null))
			    
			    if(runnable == false)
                            {
			    	System.out.println("Corriendo");
			    	this.wait();
			    }
			 }
			 catch(Exception ex)
                         {
			    System.out.println("Error");
                         }//fin del cacth
                }//fin del If
            }//fin del While
        }//fin de la Sincronizacion
     }//fin metodo run
    }// Fin del Hilo
   }//fin del clase Registro
