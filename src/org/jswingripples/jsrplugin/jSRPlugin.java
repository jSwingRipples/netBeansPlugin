package org.jswingripples.jsrplugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void loadJarJSR() {
        Process p = null;
        try {

            JFileChooser abrir = new JFileChooser();
            int seleccion = abrir.showOpenDialog(null);
            File archivo = abrir.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            if (ruta.endsWith(".jar")){
                ProcessBuilder pb = new ProcessBuilder("java", "-jar", ruta);
            p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = "";
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
            }else{
                JOptionPane.showMessageDialog(null, "El archivo es un jar");
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
