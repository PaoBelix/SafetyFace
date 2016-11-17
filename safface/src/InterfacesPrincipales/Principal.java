/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesPrincipales;

import Informacion.Tabla;
import IngresoySalida.IngresoYsalida;
import Registro.RegistroUsuario;
import VideoSeguridad.MyFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Principal extends javax.swing.JFrame {

   
    public Principal() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);//color blanco
        setTitle("Sistema de Control de Empleados");//poner un titlo al Frame Principal
        setLocationRelativeTo(null);// la posicion de ejeciucion sera en el centro de la pantalla
        btnMarcar.setEnabled(false);//desabilitar el boton marcar
        btnRegistro.setEnabled(false);//Desabilitar el boton Registro
    
        /*Se desabilitan los botoces para poner de preferencial al boton de video vigilancia */
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVideo = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        btnMarcar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Repote = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 550));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosImagenes/LOGOTIPO.png"))); // NOI18N

        btnVideo.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        btnVideo.setText("Video Vigilacia");
        btnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideoActionPerformed(evt);
            }
        });

        btnRegistro.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        btnRegistro.setText("Registrar Usuario");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnMarcar.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        btnMarcar.setText("Marcar (Entrada-Salida)");
        btnMarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarActionPerformed(evt);
            }
        });

        jMenu1.setText("Información");

        Repote.setText("Reporte");
        Repote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepoteActionPerformed(evt);
            }
        });
        jMenu1.add(Repote);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMarcar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVideo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistro)
                .addGap(77, 77, 77)
                .addComponent(btnMarcar)
                .addGap(86, 86, 86)
                .addComponent(btnVideo)
                .addGap(177, 177, 177))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideoActionPerformed

    Cam camara = new Cam();//Instancio la clase Cam en la cual se ejecutara la deteccion facial 
    camara.setVisible(true);//la muestro en pantalla 
        
    btnMarcar.setEnabled(true);//habilito el los botones
    btnRegistro.setEnabled(true);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFrame frame = new MyFrame();
                    frame.setBackground(Color.WHITE);
                    //llama a pack () antes de setLocationRelativeTo (). Esto se debe a que pack () calcula el tamaño de la ventana, que se requiere para realizar el cálculo de centrado correctamente
                    frame.setLocationRelativeTo(null);//centra
                    frame.setUndecorated(true);//sin marco
                    frame.setVisible(true);//visibiliza
                } catch (Exception e) {//ERROR
                    e.printStackTrace();
                }
            }
        });
 
    }//GEN-LAST:event_btnVideoActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
    
        try {
            RegistroUsuario ventana = new RegistroUsuario(); //crea una ventana para registro
            ventana.setVisible(true);//visibiliza la ventana
    
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnMarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarActionPerformed
        IngresoYsalida in = new IngresoYsalida(); //crea registro
        in.setVisible(true);//visibiliza
        dispose();
    }//GEN-LAST:event_btnMarcarActionPerformed

    private void RepoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepoteActionPerformed
        try {
            Tabla nuevo = new Tabla();
            nuevo.setVisible(true);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_RepoteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Repote;
    private javax.swing.JButton btnMarcar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnVideo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
