/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TidyUp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author USUARIO
 */
public class MakeList {

    public MakeList() {
        String[] cmd = {"cmd.exe", "/C", "cd", "C:/Users/USUARIO/Music", "&", "dir", "/b", ">", "nombres.txt"};

        Process pr;
        try {
            pr = Runtime.getRuntime().exec(cmd);
            System.out.println(cmd);
            InputStream inputstream = pr.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputstream);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                System.out.println("--->LISTADO CREADO EXITOSAMENTE");
            }
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error al crear el listado. Error: " + ex);
        }
    }

}
