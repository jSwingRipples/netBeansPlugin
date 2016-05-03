package org.jswingripples.jsrplugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vmolina
 */
public class jSRPlugin{
    
    
    
    public  void loadJarJSR() {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:/Users/vmolina/Documents/NetBeansProjects/AnotherGrep/dist/AnotherGrep.jar");    
            Process p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = "";
            while((s = in.readLine()) != null){
                System.out.println(s);
            }
            try {
            int status = p.waitFor();
            
            System.out.println("Exited with status: " + status);
            } catch (Exception e){}
        } catch (IOException ex) {
            
        }



}}
