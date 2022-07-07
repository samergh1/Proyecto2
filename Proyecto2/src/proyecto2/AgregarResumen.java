package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

public class AgregarResumen {
    
    /**
     * Funcion para leer el txt cargado
     * @return Retorna un objeto resumen
     */
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
                        autores = autores.replace("-", " ");
                        
                        br.close();
                        Resumen resumen = new Resumen(tituloNuevo, autores, cuerpoResumen, palabrasClaves);
                        JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
                        return resumen;
                    }
                }
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        return null;
    }
    
    /**
     * Funcion para precargar un txt existente
     * @param tabla
     * @return 
     */
    public HashTable leerTxtGuardado(HashTable tabla){
        String line;
        String txt1 = "";
        String [] txt;
        String titulo = "";
        String autores = "";
        String cuerpoResumen = "";
        String palabras = "";
        
        File file = new File("test\\Resumen.txt");
        
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                txt1 += line + "\n";
            }
            
            txt = txt1.split("-----");
            for (int j=0; j < txt.length; j++){
                String[] txtSplit = txt[j].split("\n");
                
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
                    autores = autores.replace("-", " ");
                    
                    Resumen resumen = new Resumen(tituloNuevo, autores, cuerpoResumen, palabrasClaves);
                    tabla.insertar(resumen);
                }
            }
            br.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
        return tabla;
    }
    
    /**
     * Funcion para guardar todos los resumenes almacenados en un nuevo archivo txt
     * @param tabla Se pasa la HashTable que contiene todos los resumenes
     */
    public void guardarTxt(HashTable tabla){
        String info = "";
        Resumen[] resumen = tabla.getTabla();
        for (int i=0; i < resumen.length; i++){
            if (resumen[i] != null){
                info += resumen[i].getTitulo() + "\n\n";
                info += "Autores\n" + resumen[i].getAutores() + "\n";
                info += "Resumen\n" + resumen[i].getResumen() + "\n";
                info += "Palabras Claves: " + resumen[i].getPalabrasClaves() + "\n";
                info += "-----\n";
            }
        }
        
        try{
            PrintWriter pr = new PrintWriter("test\\ResumenNuevo.txt");
            pr.print(info);
            pr.close();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
        }
    }
}
