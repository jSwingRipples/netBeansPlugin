package org.jswingripples.jsrplugin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vmolina
 */
public class jSRPlugin {

    public void writeFile(File f, String texto) throws IOException {
        FileWriter w = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);
        wr.write(texto);//escribimos en el archivo
        wr.close();
        bw.close();
    }

    public void openProject(String rutaJar) throws IOException {
        int val = JOptionPane.showConfirmDialog(null, "Desea buscar el proyecto?");
        // JOptionPane.showConfirmDialog(null,val);
        if (val == 0) {
            JFileChooser abrirProject = new JFileChooser();
            abrirProject.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = abrirProject.showOpenDialog(null);
            File archivo = abrirProject.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            JOptionPane.showMessageDialog(null, ruta);
            File guardarRuta = new File(rutaJar+"/guardarRuta.txt");
            writeFile(guardarRuta,ruta);
        }
    }
    
    public String verificarRuta(String getPatch){
        
                
        for(int i=0; i <= getPatch.length(); i++){
            char au= getPatch.charAt(i);
            if(au=='j'){
            
              if(getPatch.substring(i, i+13).equals("jswingripples")){
                  return getPatch.substring(0,i+13);
              }
            }
        }
        
        return getPatch;
    }

    public void loadJarJSR() throws IOException {
       
        Process p = null;
        try {

            JFileChooser abrir = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA APP", "jar", "java");
            abrir.setFileFilter(filter);
            int seleccion = abrir.showOpenDialog(null);
            File archivo = abrir.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            JOptionPane.showMessageDialog(null, archivo.getPath());
             openProject(verificarRuta(archivo.getPath()));
            while (!ruta.endsWith(".jar")) {
                JOptionPane.showMessageDialog(null, "The archive must be .jar");
                seleccion = abrir.showOpenDialog(null);
                archivo = abrir.getSelectedFile();
                ruta = archivo.getAbsolutePath();
            }

            ProcessBuilder pb = new ProcessBuilder("java", "-jar", ruta);
            p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = "";
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }

            try {
                int status = p.waitFor();

                System.out.println("Exited with status: " + status);
            } catch (Exception e) {
            }
        } catch (IOException ex) {

        }

    }
}
