package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

public class AgregarResumen {
    
    public Resumen leerTxt(){
        String line;
        String txt = "";
        String titulo = "";
        String autores = "";
        String cuerpoResumen = "";
        String palabras = "";
        

        JFileChooser archivo = new JFileChooser();
        int seleccion = archivo.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String nameArchivo = archivo.getSelectedFile().getAbsolutePath();
            File archivoTxt = new File(nameArchivo);

            try {
                FileReader fr = new FileReader(archivoTxt);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    txt += line + "\n";
                }
                
                if (!txt.isEmpty()){
                    String [] txtSplit = txt.split("\n");
                    
                    for (int i=0; i < txtSplit.length; i++){
                        while (!"Autores".equals(txtSplit[i])){
                            if (!"".equals(txtSplit[i])){
                                titulo += txtSplit[i] + "\n";
                                i++;
                            } else{
                                i++;
                            }
                        }
                        
                        String tituloNuevo = titulo.replace("\n", " ");                        
                        i++;
                        
                        while (!"Resumen".equals(txtSplit[i])){
                            if (!"".equals(txtSplit[i])){
                                autores += txtSplit[i] + "\n";
                                i++;
                            } else{
                                i++;
                            }
                        }
                        
                        i++;
                        
                        while (!"".equals(txtSplit[i])){
                            cuerpoResumen += txtSplit[i] + "\n";
                            i++;
                        }
                        
                        i++;
                        
                        while (i < txtSplit.length){
                            palabras += txtSplit[i] + "\n";
                            i++;
                        }
                        
                        String palabrasClaves = "";
                        if (palabras.contains("Palabras Claves")){
                            palabrasClaves = palabras.replace("Palabras Claves: ", "").replace("\n", " ").replace(".", "");
                        } else{
                            palabrasClaves = palabras.replace("Palabras claves: ", "").replace("\n", " ").replace(".", "");
                        }
                        
                        br.close();
                        Resumen resumen = new Resumen(tituloNuevo, autores, cuerpoResumen, palabrasClaves);
                        return resumen;
                    }
                }
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        return null;
    }
    
    public void analizarResumen(HashTable tablaPalabras){
        
    }
    
}
