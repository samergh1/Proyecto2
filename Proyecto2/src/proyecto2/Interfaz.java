/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2;

import javax.swing.JOptionPane;

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
        autores = new javax.swing.JComboBox<>();
        buscarPorAutor = new javax.swing.JButton();
        titulosPorAutor = new javax.swing.JComboBox<>();
        detallesResumen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarResumen.setText("Agregar resumen");
        agregarResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarResumenActionPerformed(evt);
            }
        });
        jPanel1.add(agregarResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));

        titulosDesplegables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titulosDesplegablesActionPerformed(evt);
            }
        });
        jPanel1.add(titulosDesplegables, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 320, -1));

        analizarResumen.setText("Analizar resumen");
        analizarResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarResumenActionPerformed(evt);
            }
        });
        jPanel1.add(analizarResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        autores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoresActionPerformed(evt);
            }
        });
        jPanel1.add(autores, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 310, -1));

        buscarPorAutor.setText("Buscar resumen autor");
        buscarPorAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorAutorActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPorAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        titulosPorAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titulosPorAutorActionPerformed(evt);
            }
        });
        jPanel1.add(titulosPorAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 280, -1));

        detallesResumen.setText("Ver detalles del resumen");
        detallesResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detallesResumenActionPerformed(evt);
            }
        });
        jPanel1.add(detallesResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        textoArea.setEditable(false);
        textoArea.setColumns(20);
        textoArea.setRows(5);
        jScrollPane1.setViewportView(textoArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 590, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarResumenActionPerformed
        Resumen resumen = leerArchivo.leerTxt();
        boolean logico = tabla.insertar(resumen);
        if (logico){
            titulosDesplegables.addItem(resumen.getTitulo());
            String[] arr = resumen.getAutores().split("\n");
            for (int i=0; i< arr.length; i++){
                autores.addItem(arr[i]);
            }
         
        }
    }//GEN-LAST:event_agregarResumenActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void titulosDesplegablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titulosDesplegablesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titulosDesplegablesActionPerformed

    private void analizarResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarResumenActionPerformed
        if (titulosDesplegables.getSelectedItem() != null){
            HashTable tablaPalabras = new HashTable(15);
            String cadena = "";
            String titulo = (String)titulosDesplegables.getSelectedItem();
            String palabras = tabla.buscar(titulo).getPalabrasClaves();
            String resumen = tabla.buscar(titulo).getResumen();
            String[] resumenFinal = resumen.replace(",", "").replace(".", "").replace("\n", " ").split(" ");
            String[] palabrasClaves = palabras.split(", ");

            for (int i=0; i < palabrasClaves.length; i++){
                PalabrasClaves palabra = new PalabrasClaves(palabrasClaves[i], titulo);
                tablaPalabras.insertarPalabras(palabra);
            }

            tablaPalabras.buscarFrecuenciaPalabra(resumenFinal, palabrasClaves);
            cadena += titulo + "\n\n" + "Autores:" + "\n" + tabla.buscar(titulo).getAutores() + "\n";
            cadena += "Frecuencia de las palabras claves:" + "\n";
            cadena += tablaPalabras.imprimirTablaPalabras();
            textoArea.setText(cadena);
        } else{
            JOptionPane.showMessageDialog(null, "Agregue un resumen para poder analizarlo");
        }
            
        
    }//GEN-LAST:event_analizarResumenActionPerformed

    private void autoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoresActionPerformed

    private void buscarPorAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorAutorActionPerformed
        titulosPorAutor.removeAllItems();
        String autor = (String)autores.getSelectedItem();
        String[] aux = tabla.buscarTitulosPorAutor(autor);
        if (aux != null){
            int a = aux.length;
            for (int i=0; i < a; i++){
                titulosPorAutor.addItem(aux[i]);
            }
            
            }
                
        
    }//GEN-LAST:event_buscarPorAutorActionPerformed

    private void titulosPorAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titulosPorAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titulosPorAutorActionPerformed

    private void detallesResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detallesResumenActionPerformed
        if ((String)titulosPorAutor.getSelectedItem() != null){
            String titulo = (String)titulosPorAutor.getSelectedItem();
            textoArea.setText(tabla.imprimirResumen(titulo));
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione un resumen para ver detalles");
        }
    }//GEN-LAST:event_detallesResumenActionPerformed

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
    private javax.swing.JComboBox<String> autores;
    private javax.swing.JButton buscarPorAutor;
    private javax.swing.JButton detallesResumen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoArea;
    private javax.swing.JComboBox<String> titulosDesplegables;
    private javax.swing.JComboBox<String> titulosPorAutor;
    // End of variables declaration//GEN-END:variables
}
