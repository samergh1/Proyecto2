/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2;

/**
 *
 * @author samer
 */
public class Interfaz extends javax.swing.JFrame {
    AgregarResumen leerArchivo = new AgregarResumen();
    HashTable tabla = new HashTable();

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregarResumen = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        titulosDesplegables = new javax.swing.JComboBox<>();
        analizarResumen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarResumen.setText("Agregar resumen");
        agregarResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarResumenActionPerformed(evt);
            }
        });
        jPanel1.add(agregarResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        titulosDesplegables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titulosDesplegablesActionPerformed(evt);
            }
        });
        jPanel1.add(titulosDesplegables, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 320, -1));

        analizarResumen.setText("Analizar resumen");
        analizarResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarResumenActionPerformed(evt);
            }
        });
        jPanel1.add(analizarResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarResumenActionPerformed
        Resumen resumen = leerArchivo.leerTxt();
        boolean logico = tabla.insertar(resumen);
        if (logico){
            titulosDesplegables.addItem(resumen.getTitulo());
        }
    }//GEN-LAST:event_agregarResumenActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void titulosDesplegablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titulosDesplegablesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titulosDesplegablesActionPerformed

    private void analizarResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarResumenActionPerformed
        HashTable tablaPalabras = new HashTable(15);
        String titulo = (String)titulosDesplegables.getSelectedItem();
        String palabras = tabla.buscar(titulo).getPalabrasClaves();
        String resumen = tabla.buscar(titulo).getResumen();
        String[] palabrasClaves = palabras.split(", ");
        
        for (int i=0; i < palabrasClaves.length; i++){
            PalabrasClaves palabra = new PalabrasClaves(palabrasClaves[i]);
            tablaPalabras.insertarPalabras(palabra);
        }
        
    }//GEN-LAST:event_analizarResumenActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton agregarResumen;
    private javax.swing.JButton analizarResumen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> titulosDesplegables;
    // End of variables declaration//GEN-END:variables
}
